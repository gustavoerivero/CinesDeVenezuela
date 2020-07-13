package controllers;
// Se importan las librerías de soporte.
import lib.SupportFunctions;
// Se importan los models a utilizar.
import models.Function;
import models.Block;
import models.Schedule;
import models.database.FunctionCRUD;
import models.database.BlockCRUD;
import models.database.ScheduleCRUD;
// Se importan las views a utilizar.
import views.FunctionManagement;
import views.PopupMessage;
import views.SelectOption;
import views.tables.Table;
// Se importan las librerías a utilizar.
import java.awt.event.*;
import java.sql.SQLException;
import java.sql.Time;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import models.database.BranchCRUD;
import models.database.CinemaRoomCRUD;
/**
 *  Materia: Laboratorio I
 *  Sección: 1
 *      Integrantes:
 *          @author Brizuela, Yurisbellys   C.I: 27.142.239
 *          @author Miranda, Marihec        C.I: 26.120.075
 *          @author Montero, Michael        C.I: 26.561.077
 *          @author Rivero, Gustavo         C.I: 26.772.857
 *          @author Torrealba, Luis         C.I: 26.121.249
 */
public class ControllerFunctionManagement implements ActionListener, MouseListener
{
    //<editor-fold defaultstate="collapsed" desc=" Declaración de variables ">
    // Models
    private Block block;
    private Function function;
    private Schedule schedule;
    // Models.database
    private BlockCRUD bCRUD;
    private FunctionCRUD fCRUD;
    private ScheduleCRUD sCRUD;
    private CinemaRoomCRUD cCRUD;
    private BranchCRUD braCRUD;
    // Views
    private FunctionManagement funManagement;
    private PopupMessage popup;
    // Controllers
    private ControllerMainMenu contMainMenu;    
    // Librerías de soporte
    private SupportFunctions support; 
    //ArrayList que almacenarán lo que necesito para usarlo más tarde
    private ArrayList<String>   codFunctionA =new ArrayList<>(),
                                codScheduleA =new ArrayList<>(),
                                codBranchA =new ArrayList<>(),
                                codBlockA =new ArrayList<>(),
                                codCinemaRoomA =new ArrayList<>(),
                                codMoiveA =new ArrayList<>();
    // Variables de los objetos.
    //bloque
    private Time startTime;
    private Time endTime;
    private String idBlock;
    private char estatusBlock;
    //funcion
    private String
            idFunction,
            schedule_id, film_id;
    private char estatusFunction;
    //Horario
    private String
            idSchedule,idBlockA,idCinemaA,idTypeDayA;
    private Date day;
    private char status;
    
    private int auxM;
   //Variables del usuario 
    private String  rolUser,
                    nameUser,
                    branchUser;   
    //</editor-fold>
    
    /**
     * Constructor del gestor de sucursales.
     * @param rolUser Rol del usuario que ha ingresado al sistema.
     * @param nameUser Nombre del usuario que ha ingresado al sistema.
     * @param branchUser Nombre de la sucursal del usuario que ha ingresado al sistema.
     */
    public ControllerFunctionManagement(String rolUser, String nameUser, String branchUser){
        
        // Declarar la variable de las clases instanciadas.
        funManagement   = new FunctionManagement ();
        support         = new SupportFunctions();  
        
        // Se inicializan las variables.
        this.rolUser    = rolUser;
        this.nameUser   = nameUser;
        this.branchUser = branchUser;
        
        // Se muestra la primera pantalla.
        funManagement.lblSucursalName.setText(branchUser);
        support.cardSelection(funManagement.panContainerFunction, funManagement.panConsultList);
        support.cardSelection(funManagement.panAddFunction, funManagement.panAddFunction1);
        
     //   loadinterface();
        //typeUser(this.rolUser);
        
        
        // Se inicializan las variables.
       // clearVariables();
        
        // Activamos los eventos por las views.
     //   canManagement.addEvents(this);
     //   canManagement.addMouseEvents(this);
     //   generateCode();
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Método para cargar comboBox con las salas por sucursal ">
    /**
     * Método para cargar el combobox con las salas por sucursal.
     * @param salas ArrayList que guardará todas las salas.
     */
    private void loadAllCinema(ArrayList<String> salas){
        //Obtenemos el codigo de la sucursal y lo guardamos en una variable local
        String idBranch = loadCodeBranch(funManagement.lblSucursalName.getText());
        // Se instancia la clase a utilizar.
        cCRUD = new CinemaRoomCRUD();
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        try {
            result = cCRUD.readAllCinemaRoomOnBranch(idBranch);
            while(result.next()){
                salas.add(result.getString("codigo"));
            }
            System.out.println("éxito.");
        } catch (java.sql.SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Métodos para buscar el codigo de la sucursal ">    
    /**
     * Método para buscar el código de una sucursal.
     * @param branchName Nombre de la sucursal.
     * @return Devuelve el código de la sucursal.
     */
    private String loadCodeBranch(String branchName){
        // Se instancia la clase a utilizar.
        braCRUD = new BranchCRUD();
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        // Variable de soporte.
        String codex="";
        try 
        {
            result = braCRUD.readOnlyBranch(branchName);
            while(result.next())
            {
                codex = result.getString("codigo");
            }
            System.out.println("Éxito.");
            return codex;            
        } 
        catch (java.sql.SQLException e) 
        {
            System.out.println("Error: " + e);
        }
        return codex;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Métodos para construir la instrucción SQL para cargar la tabla ">
    /**
     * Método para construir la sentencia de búsqueda de funciones.
     * @return Sentencia SQL.
     */
  /*  private String buildSentenceSQL(){
        
        // Se declaran e inicializan las variables que servirÃ¡n para buscar la sucursal.
        String  initSQL     = "SELECT inventario_golosina.\"Codigo\", golosinas.\"nombre\", sucursal.\"nombre\" as \"nombreSucursal\", "
                                    + "golosinas.\"precio\", inventario_golosina.\"Stock\" "
                                    + "FROM \"inventario_golosina\", \"golosinas\", \"sucursal\" WHERE "
                                    + "golosinas.\"estado\" = 'A' AND inventario_golosina.\"GolosinaCodigo\"=golosinas.\"codigo\" "
                                    + "AND inventario_golosina.\"Estado\" = 'A' AND sucursal.\"estado\" = 'A'"
                                    + "AND inventario_golosina.\"SucursarCodigo\"=sucursal.\"codigo\"",
                finalSQL    = ";",
                idSQL       = " AND golosinas.\"codigo\" = ",
                idBranchSQL = " AND sucursal.\"codigo\" = ",
                SQL         = "";
         
        // Se inicia la sentencia SQL;
        SQL += initSQL;
        // Si se ingresÃ³ el codigo de la sucursal
        if(!canManagement.txtSearchIdCandy.getText().equals("Código de la Golosina") && 
           !canManagement.txtSearchIdCandy .getText().equals(""))
            SQL += idSQL + "'" + canManagement.txtSearchIdCandy.getText() + "'";
        
        if(!canManagement.lblSucursalName.getText().equals("") &&
                !canManagement.lblSucursalName.getText().equals("Sucursal ") &&
                !canManagement.lblSucursalName.getText().equals(" - Seleccione - ") &&
                !canManagement.lblSucursalName.getText().equals("Cines de Venezuela") && 
                !canManagement.lblSucursalName.getText().equals(" Administrador "))
        {
            String codexBranch= loadCodeBranch(canManagement.lblSucursalName.getText());
            System.out.println("sucursal "+ codexBranch);
            SQL += idBranchSQL + "'" + codexBranch + "'";
        }
        return SQL += finalSQL;
    }*/
    //</editor-fold>   
    
    //<editor-fold defaultstate="collapsed" desc=" Métodos para el funcionamiento del Controller ">

    //</editor-fold>
    
   /*     private void clearVariables()
    {   
        id          = "";
        idCandy        = "";
        idBranch       = "";
        stock       =0;
        estatus     ='A';
        name="";
        descr="";
    price=0.0;
    }*/
    //<editor-fold defaultstate="collapsed" desc=" Métodos para cargar la lista de funciones ">
   /* private void loadinterface()
    {
        loadFunctionTable();
        ArrayList<String> salas = new ArrayList<>();
        loadAllCinema(salas);
        // Se llena el combobox de las sucursales.
        canManagement.cmbCandySelection.removeAllItems();
        canManagement.cmbCandySelection.addItem(" - Seleccionar - ");
        for(int i = 0; i < golosinas.size(); i++)
            canManagement.cmbCandySelection.addItem(golosinas.get(i));
    }*/
    //</editor-fold>
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" PROHIBIDO TOCAR ">
    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //</editor-fold>
}
