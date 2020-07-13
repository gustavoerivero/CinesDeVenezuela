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
        loadinterface();
        //typeUser(this.rolUser);
        // Se inicializan las variables.
        clearVariables();
        // Activamos los eventos por las views.
        funManagement.addEvents(this);
        funManagement.addMouseEvents(this);
    }
    
    /**
     * Método que determina las acciones a realizar por la aplicación según el 
     * botón presionado.
     * @param evt indica los eventos posibles a ocurrir (click en botónes).
     */
    @Override
    public void actionPerformed(ActionEvent evt) 
    {
                
        //<editor-fold defaultstate="collapsed" desc=" Botones de la Barra Superior ">
        // Minimizar aplicación.
        if(evt.getSource() == funManagement.btnMin){
            funManagement.setExtendedState(java.awt.Frame.ICONIFIED);
            funManagement.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        // Salir de la aplicación.
        else if(evt.getSource() == funManagement.btnExit){
            funManagement.dispose();
        } 
        //</editor-fold>    
    
    }
    
    @Override
    public void mouseClicked(MouseEvent evt) {
 /*     
        // Si se hace click sobre la tabla de empleados.
        if(evt.getSource() == funManagement.tblFunctionList){
                                              
            // Se obtienen los valores de la fila y columna seleccionada.
            int column = funManagement.getColumnTable(), row = funManagement.getRowTable();

            // Se valida que el evento del Mouse fue provocado dentro del JTable.
            if(row < funManagement.tblFunctionList.getRowCount() && row >= 0 && 
                    column < funManagement.tblFunctionList.getColumnCount() && column >= 0){
                
                // Se obtiene el valor de la celda seleccionada.
                Object value = funManagement.tblFunctionList.getValueAt(row, column);
                
                // Si el valor de la celda seleccionada es un JButton;
                if(value instanceof JButton){
                    
                    ((JButton)value).doClick();
                    
                    JButton btn = (JButton) value;
/*
                    //<editor-fold defaultstate="collapsed" desc=" Proceso para consultar una golosina ">
                    
                    // Si el JButton se llama "s";
                    if(btn.getName().equals("s")){
                        
                        // Se imprime en consola en dÃ³nde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                                      
                        // Se obtiene el modelo de la JTable.
                        DefaultTableModel dtm = (DefaultTableModel) canManagement.tblInventoryCandyList.getModel();
                                                
                        // Se obtiene el id de la sucursal en cuestiÃ³n.
                        String id = dtm.getValueAt(row, 0).toString();
                        
                        // Se buscan los datos del empleado.
                        loadCandy(id);
              
                        // Se muestra la vista del CRUD.
                        support.cardSelection(canManagement.panContainerCandy, canManagement.panCRUD);
                                                
                        // Se configura el texto del botÃ³n.
                        canManagement.btnRegisterModifyCandy.setText("Modificar");
                        
                        // Se limpian todos los aspectos visuales.
                        canManagement.clearView();
                                                
                        // Se muestran los datos obtenidos.
                        canManagement.txtIdCandy.setText(id);
                        canManagement.txtNameCandy.setText(name);
                        canManagement.txtDescriptionCandy.setText(descr);
                        canManagement.txtPriceCandy.setText(String.valueOf(price));
                        canManagement.spnStock.setValue(new Integer(stock));
                        // Se bloquea el campo de codigo.
                        canManagement.txtIdCandy.setEnabled(false);
                        canManagement.txtNameCandy.setEnabled(false);
                        canManagement.txtDescriptionCandy.setEnabled(false);
                        canManagement.txtPriceCandy.setEnabled(false);                 }
                    
                    //</editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc=" Proceso para eliminarr un inventario ">
                    
                    // Si el JButton se llama "i";
                    if(btn.getName().equals("e")){
                        
                        // Se imprime en consola en dÃ³nde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                        // Se obtiene el modelo de la JTable.
                        DefaultTableModel dtm = (DefaultTableModel) canManagement.tblInventoryCandyList.getModel();
                                                
                        // Se obtiene el id de la sucursal en cuestiÃ³n.
                        String id = dtm.getValueAt(row, 0).toString();
                        
                        SelectOption select = new SelectOption(canManagement, true, 2, 
                   
                                "¿Está seguro que desea eliminar esta sucursal?", "Si", "No");
                            // Si la respuesta es afirmativa.
                        if(select.getOpc())
                        {
                            cCRUD.DeleteCandy(id, 0);
                            // Se muestra un mensaje de eliminaciÃ³n exitosa.
                            popup = new PopupMessage(canManagement, true, 4, "La golosina se ha eliminado con éxito.");
                            loadCandyTable();
                        }
                    }
                        
                    //</editor-fold>
                    
                }
            }
        }*/
    }    
    
    //<editor-fold defaultstate="collapsed" desc=" Métodos para el funcionamiento del Controller ">

    //<editor-fold defaultstate="collapsed" desc="loadAllCinema - Método para cargar comboBox con las salas por sucursal ">
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

    //<editor-fold defaultstate="collapsed" desc="loadCodeBranch - Método para buscar el codigo de la sucursal ">    
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
    
    //<editor-fold defaultstate="collapsed" desc="buildSentenceSQL - Método para construir la instrucción SQL para cargar la tabla ">
    /**
     * Método para construir la sentencia de búsqueda de funciones.
     * @return Sentencia SQL.
     */
    private String buildSentenceSQL(){
        
        // Se declaran e inicializan las variables que servirÃ¡n para buscar la sucursal.
        String  initSQL     = "SELECT sucursal.\"nombre\" as \"nombreSucursal\", pelicula.\"nombre\" as \"nombrePelicula\", "
                                    + "bloque.\"horainicio\", "
                                    + "bloque.\"horafin\", sala.\"codigo\" as \"codigoSala\", horario.\"fecha\" "
                                    + "FROM \"sucursal\", \"pelicula\", \"bloque\",\"horario\",\"funcion\",\"sala\" "
                                    + "WHERE horario.\"bloque_codigo\"=bloque.\"codigo\" AND "
                                    + "horario.\"sala_codigo\"=sala.\"codigo\" AND funcion.\"horario_codigo\"=horario.\"codigo\" AND "
                                    + "funcion.\"pelicula_codigo\"=pelicula.\"codigo\" "
                                    + "AND sucursal.\"estado\" = 'A' AND pelicula.\"estado\"='A' "
                                    + "AND bloque.\"estado\" = 'A' AND horario.\"estado\" = 'A' AND funcion.\"estado\"= 'A' AND sala.\"estado\"= 'A' "
                                    + "AND sala.\"sucursal_codigo\"=sucursal.\"codigo\"",
                finalSQL    = ";",
                //idSQL       = " AND golosinas.\"codigo\" = ",
                //idBranchSQL = " AND sucursal.\"codigo\" = ",
                SQL         = "";
         
        // Se inicia la sentencia SQL;
        SQL += initSQL;
        // Si se ingresÃ³ el codigo de la sucursal
        /*if(!canManagement.txtSearchIdCandy.getText().equals("Código de la Golosina") && 
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
        }*/
        return SQL += finalSQL;
    }
    //</editor-fold>   
    
    //<editor-fold defaultstate="collapsed" desc="loadFunctionTable - Método para cargar la tabla ">
    /**
     * Método para cargar la información de la sucursal.
     * @return listado con la información de la sucursal.
     */
    private void loadFunctionTable(){
                
        // Se instancia la clase a utilizar.
        fCRUD = new FunctionCRUD(); 
        // Se declaran los arreglos a utilizar
        ArrayList<String>       namesBranch         = new ArrayList<>(),
                                namesMovie     = new ArrayList<>(),
                                startTime     = new ArrayList<>(),
                                endTime     = new ArrayList<>(),
                                //el arraylist del codigo de la sala ya lo tengo creado al inicio
                                dateF         = new ArrayList<>();
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        try {
            // Se realiza la bÃºsqueda de empleados.
            result = fCRUD.readFunctions(buildSentenceSQL());
            // Se obtienen los resultados.
            while(result.next())
            {
                namesBranch.add(result.getString("nombreSucursal"));
                namesMovie.add(result.getString("nombrePelicula"));
                startTime.add(result.getString("horainicio"));
                endTime.add(result.getString("horafin"));
                codCinemaRoomA.add(result.getString("codigoSala"));
                dateF.add(result.getString("fecha"));
            }
            System.out.println("Carga exitosa. Cantidad de funciones encontradas: " + namesBranch.size());
            // Se obtuvo al menos un resultado.
            if(namesBranch.size() > 0)
            {
                // Se limpia la tabla de empleados.
                funManagement.clearFunctionTable(funManagement.tblFunctionList);
                // Se obtiene el modelo de la tabla de empleados.
                DefaultTableModel dtm = (DefaultTableModel) funManagement.tblFunctionList.getModel();
                // Se declara e instancia la clase Table.
                Table table = new Table();
                // Se declara e instancia el componente JButton.
                JButton btnD = new JButton();
                JButton btnS = new JButton();
                // Se le dan las propiedades al JButton.
                table.addDeleteButton(btnD);
                table.addSearchButton(btnS);
                // Se aÃ±aden todos los resultados obtenidos a la tabla.
                for(int i = 0; i < namesBranch.size(); i++){
                    dtm.addRow(new Object[]{
                        namesBranch.get(i),
                        namesMovie.get(i),
                        startTime.get(i),
                        endTime.get(i),
                        codCinemaRoomA.get(i),
                        dateF.get(i),
                        btnS,
                        btnD
                    });
                }
            }
            // No se obtuvo ningún resultado.
            else
                popup = new PopupMessage(funManagement, true, 1, "No se encontraron funciones.");
        } catch (java.sql.SQLException e) 
        {
            System.out.println("Error: " + e);
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Métodos para el funcionamiento del Controller ">

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="clearVariables - Métodos para limpiar las variables de los objetos ">    
   private void clearVariables()
    {   
        // Variables de los objetos.
        //bloque
        startTime= null;
        endTime= null;
        idBlock="";
        estatusBlock='A';
        //funcion
        idFunction="";
        schedule_id="";
        film_id="";
        estatusFunction='A';
        //Horario
        idSchedule="";
        idBlockA="";
        idCinemaA="";
        idTypeDayA="";
        day= null;
        status='A';
    }
    //</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="loadinterface - Métodos para cargar la lista de funciones ">
    private void loadinterface()
    {
        loadFunctionTable();
        ArrayList<String> salas = new ArrayList<>();
        loadAllCinema(salas);
        // Se llena el combobox de las sucursales.
        funManagement.cmbCinemaRoom.removeAllItems();
        funManagement.cmbCinemaRoom.addItem(" - Seleccionar - ");
        for(int i = 0; i < salas.size(); i++)
            funManagement.cmbCinemaRoom.addItem(salas.get(i));
    }
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" PROHIBIDO TOCAR ">
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
