
package controllers;
// Se importan las librerías de soporte.
import lib.SupportFunctions;
// Se importan los models a utilizar.
import models.CandyInventory;
import models.database.CandyInventoryCRUD;
// Se importan las views a utilizar.
import views.CandyInventoryManagement;
import views.PopupMessage;
import views.SelectOption;
import views.tables.Table;
// Se importan las librerías a utilizar.
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import models.database.BranchCRUD;
import models.database.CandyCRUD;
import models.database.CityCRUD;
import views.ChangeBranch;

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
public class ControllerCandyInventoryManagement implements ActionListener, MouseListener{
        //<editor-fold defaultstate="collapsed" desc=" Declaración de variables ">
    
    // Models
    private CandyInventory candy;
        // Models.database
        private CandyInventoryCRUD cCRUD;
        private CityCRUD citCRUD;
        private BranchCRUD braCRUD;
         private CandyCRUD canCRUD;
        
    // Views
    private CandyInventoryManagement canManagement;
    private PopupMessage popup;
        private ChangeBranch changeBranch;

    
    // Controllers
    private ControllerMainMenu contMainMenu;    
    
    // Librerías de soporte
    private SupportFunctions support;   
    
    // Variables del usuario.    
    private String  rolUser,
                    nameUser,
                    branchUser;   
    // Variables para CRUD de Candy.    
    private String id, idCandy, idBranch,name,descr;
    private int stock;
    private double price;
    private char estatus;
    private String newCode;


    //</editor-fold>    
    
    /**
     * Constructor del gestor de sucursales.
     * @param rolUser Rol del usuario que ha ingresado al sistema.
     * @param nameUser Nombre del usuario que ha ingresado al sistema.
     * @param branchUser Nombre de la sucursal del usuario que ha ingresado al sistema.
     */
    public ControllerCandyInventoryManagement(String rolUser, String nameUser, String branchUser){
        
        // Declarar la variable de las clases instanciadas.
        canManagement   = new CandyInventoryManagement();
        support         = new SupportFunctions();  
        
        // Se inicializan las variables.
        this.rolUser    = rolUser;
        this.nameUser   = nameUser;
        this.branchUser = branchUser;
        
        // Se muestra la primera pantalla.
        canManagement.lblSucursalName.setText(branchUser);
        support.cardSelection(canManagement.panContainerCandy, canManagement.panConsultList);
        loadinterface();
        //typeUser(this.rolUser);
        
        
        // Se inicializan las variables.
        clearVariables();
        
        // Activamos los eventos por las views.
        canManagement.addEvents(this);
        canManagement.addMouseEvents(this);
        generateCode();
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
        if(evt.getSource() == canManagement.btnMin){
            canManagement.setExtendedState(java.awt.Frame.ICONIFIED);
            canManagement.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        // Salir de la aplicación.
        else if(evt.getSource() == canManagement.btnExit){
            canManagement.dispose();
        } 
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Branch Change ">
        
        // Cambiar de sucursal a gestionar
        else if(evt.getSource() == canManagement.btnChangeBranch){
            ArrayList<String>   cityNames   = loadCityNames(),
                                cityBranch  = new ArrayList<>(),
                                branchNames = new ArrayList<>();
            loadBranch(cityBranch, branchNames);
            // Instanciar la clase
            changeBranch = new ChangeBranch(canManagement, true, cityNames, cityBranch, branchNames, rolUser);
            // Se ubica el nombre de la sucursal.
            canManagement.lblSucursalName.setText(changeBranch.getId_Sucursal());
            changeBranch.dispose();
            loadCandyTable();
            
        }
        
        //</editor-fold>         
        
        //<editor-fold defaultstate="collapsed" desc=" Back to Consult List ">
        // Para volver a la view de consulta.
        else if(evt.getSource() == canManagement.btnBackCandy )
        {
            // Se pregunta al usuario si desea abandonar la consulta.
                SelectOption select = new SelectOption(canManagement, true, 1, 
                        "¿Estás seguro que desea abandonar la consulta?", "Si", "No");
                // Si la respuesta es afirmativa.
                if(select.getOpc())
                {
                    // Se muestra la vista del CRUD.
                    support.cardSelection(canManagement.panContainerCandy, canManagement.panConsultList);
                    // Se cargan las sucursales.
                    loadCandyTable();
                    // Se inicializan las variables.
                    clearVariables();
                }
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Inventory Search ">
        // Buscar a un empleado.
        else if(evt.getSource() == canManagement.btnSearchCandy){
            // Si no se ingresÃ³ informaciÃ³n para filtrar.
            if  ((canManagement.txtSearchIdCandy.getText().equals("") || 
                    canManagement.txtSearchIdCandy.getText().equals("Código de la Golosina")))
                    popup = new PopupMessage(canManagement, true, 1, "Debe ingresar al menos un dato para filtrar.");
            // Si al menos se ingresa algún dato para filtrar.
            else
                loadCandyTable();
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Register or Update Branch ">
        // Registro o ModificaciÃ³n de sucursal.
        else if(evt.getSource() == canManagement.btnRegisterModifyCandy)
        {
                    if((int) canManagement.spnStock.getValue()!=0){
                        // Se confirma que se desea eliminar el registro.
                        SelectOption select = new SelectOption(canManagement, true, 2, 
                                "¿Desea actualizar los datos del inventario?", "Si", "No");
                        // Si se confirma la actualizaciÃ³n.
                        if(select.getOpc())
                        {
                            // Se ejecuta la actualizaciÃ³n de informaciÃ³n.
                            updateCandyData(id);
                            // Se muestra la vista del CRUD.
                            support.cardSelection(canManagement.panContainerCandy, canManagement.panConsultList);
                            // Se cargan las sucursales.
                            loadCandyTable();
                            // Se inicializan las variables.
                            clearVariables();
                        }
                    }
                // Si hay campos vacÃ­os.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(canManagement, true, 1, 
                            "Debe ingresar un stock mayor a 0");
        }
        else if(evt.getSource() == canManagement.btnAddCandySell)
        {
            if(canManagement.cmbCandySelection.getSelectedIndex() == 0)
                // Se muestra un mensaje de que la venta fue generada con Ã©xito.
                popup = new PopupMessage(canManagement, true,
                                         1, "Seleccione una golosinas.");
            
            // Si no se ha indicado una cantidad de golosina a agregar.
            else if((int) canManagement.spnCantCandySell.getValue() == 0)
                // Se muestra un mensaje de que la venta fue generada con Ã©xito.
                popup = new PopupMessage(canManagement, true,
                                         1, "Ingrese alguna cantidad de golosinas.");
            
            // Si se seleccionÃ³ una golosina y se indicÃ³ la cantidad a agregar.
            else if(canManagement.lblSucursalName.getText().equals("") &&
                canManagement.lblSucursalName.getText().equals("Sucursal ") &&
                canManagement.lblSucursalName.getText().equals(" - Seleccione - ") &&
                canManagement.lblSucursalName.getText().equals("Cines de Venezuela") && 
                canManagement.lblSucursalName.getText().equals(" Administrador "))
                    popup = new PopupMessage(canManagement, true,
                                         1, "Debe estar en una sucursal.");
            else
            {
                // Si la sucursal ya existe pero se encuentra inactivo.
                idCandy=loadCodeCandy(canManagement.cmbCandySelection.getSelectedItem().toString());
                idBranch=loadCodeBranch(canManagement.lblSucursalName.getText());
                if(cCRUD.InventoryExist(idBranch,idCandy, 'I'))
                {
                    id=loadCodeInventory(idBranch,idCandy);
                    // Se cambia el estado de la sucursal a activo.
                    cCRUD.DeleteCandy(id, 1);
                    // Se actualiza la informaciÃ³n del empleado.
                    updateCandyData(id);
                    // Se cargan los empleados.
                    loadCandyTable();
                    // Se inicializan las variables.
                    clearVariables();
                }
                else if(cCRUD.InventoryExist(idBranch,idCandy, 'A'))
                {
                         popup = new PopupMessage(canManagement, true,
                                         1, "Ya esta dolosina esta registrada en un inventario, pruebe modificarla");   
                }
                // Si el usuario no existe.
                else
                {
                    // Se ejecuta el registro de informaciÃ³n.
                    registerCandyData();
                    // Se muestra la vista del CRUD.
                    // Se cargan las sucursales.
                    loadCandyTable();
                    // Se inicializan las variables.
                    clearVariables();
                                
                            
                }
            }
        }
                //</editor-fold>

    }

@Override
public void mouseClicked(MouseEvent evt) {
      
        // Si se hace click sobre la tabla de empleados.
        if(evt.getSource() == canManagement.tblInventoryCandyList){
                                              
            // Se obtienen los valores de la fila y columna seleccionada.
            int column = canManagement.getColumnTable(), row = canManagement.getRowTable();

            // Se valida que el evento del Mouse fue provocado dentro del JTable.
            if(row < canManagement.tblInventoryCandyList.getRowCount() && row >= 0 && 
                    column < canManagement.tblInventoryCandyList.getColumnCount() && column >= 0){
                
                // Se obtiene el valor de la celda seleccionada.
                Object value = canManagement.tblInventoryCandyList.getValueAt(row, column);
                
                // Si el valor de la celda seleccionada es un JButton;
                if(value instanceof JButton){
                    
                    ((JButton)value).doClick();
                    
                    JButton btn = (JButton) value;

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
        }
    }   
    
    
    
    //<editor-fold defaultstate="collapsed" desc=" Métodos para el funcionamiento del Controller ">
    

    /**
     * MÃ©todo para cargar el combobox golosinas.
     * @param firstList Primer listado con los nombres de ciudades.
     * @param secondList Segundo listado con los nombres de sucursales.
     */
    private void loadAllCandys(ArrayList<String> gol){
        // Se instancia la clase a utilizar.
        canCRUD = new CandyCRUD();
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        try {
            result = canCRUD.candy();
            while(result.next()){
                gol.add(result.getString("nombre"));
            }
            System.out.println("éxito.");
        } catch (java.sql.SQLException e) {
            System.out.println("Error: " + e);
        }
    }



    /**
     * MÃ©todo para buscar el cÃ³digo de una sucursal.
     * @param branchName Nombre de la sucursal.
     * @return Devuelve el cÃ³digo de la sucursal.
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
    
    
        /**
     * MÃ©todo para buscar el codigo de un inventario.
     * @param idbranch CODIGO de la sucursal.
     * @return Devuelve el cÃ³digo de la sucursal.
     */
    private String loadCodeInventory(String idbranchl,String idCandyl){
        // Se instancia la clase a utilizar.
        braCRUD = new BranchCRUD();
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        // Variable de soporte.
        String sql="SELECT * FROM \"inventario_golosina\" WHERE \"SucursarCodigo\" = '"
                            + idbranchl + "' AND \"GolosinaCodigo\" = '"+ idCandyl +"' ;";
        String codex="";
        try 
        {
            result = cCRUD.readCandys(sql);
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
    
    
    
        /**
     * MÃ©todo para buscar el cÃ³digo de una sucursal.
     * @param branchName Nombre de la sucursal.
     * @return Devuelve el cÃ³digo de la sucursal.
     */
    private String loadCodeCandy(String candyName){
        // Se instancia la clase a utilizar.
        canCRUD = new CandyCRUD();
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        // Variable de soporte.
        String codex="";
        try 
        {
            String SQL= "SELECT * FROM \"golosinas\" WHERE \"nombre\" = '"
                            + candyName + "' AND \"estado\" = 'A';";
            result = canCRUD.readCandys(SQL);
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
    
        /**
     * MÃ©todo para cargar todas ciudades.
     * @return Listado de nombres de ciudades.
     */
    private ArrayList<String> loadCityNames(){
        
        // Se instancia la clase a utilizar.
        citCRUD = new CityCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        // Se declara e instancia la variable de soporte.
        ArrayList<String> cityNames = new ArrayList<>();
        
        try {
            result = citCRUD.readAllCityNames();
            while(result.next()){
                cityNames.add(result.getString("nombre"));
            }
            
            System.out.println("Éxito.");
            
            return cityNames;
            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
        return null;
        
    }
    
    /**
     * MÃ©todo para cargar sucursales.
     * @param firstList Primer listado con los nombres de ciudades.
     * @param secondList Segundo listado con los nombres de sucursales.
     */
    private void loadBranch(ArrayList<String> firstList, ArrayList<String> secondList){
        
        // Se instancia la clase a utilizar.
        braCRUD = new BranchCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            result = braCRUD.readBranchForCity();
            while(result.next()){
                firstList.add(result.getString("NombreCiudad"));
                secondList.add(result.getString("NombreSucursal"));
            }
                        
            System.out.println("Éxito.");
                                    
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }
    
    /**
     * MÃ©todo para buscar una sucursal
     * @return Listado de nombres de ciudades.
     */
    private void loadCandy(String id){
        // Se instancia la clase a utilizar.
        cCRUD = new CandyInventoryCRUD();
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        try {
            result = cCRUD.readCandyData(id);
            while(result.next()){
                this.id = result.getString("Codigo");
                descr = result.getString("descripcion");
                name = result.getString("nombre");
                price = result.getDouble("precio");
                stock = result.getInt("Stock");
            }
            System.out.println("Éxito.");
        } catch (java.sql.SQLException e) {
            System.out.println("Error: " + e);
        }
    }    
    
    /**
     * MÃ©todo para construir la sentencia de bÃºsqueda de la sucursal.
     * @return Sentencia SQL.
     */
    private String buildSentenceSQL(){
        
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
    }

    
        /**
     * MÃ©todo para cargar la informaciÃ³n de la sucursal.
     * @return listado con la informaciÃ³n de la sucursal.
     */
    private void loadCandyTable(){
                
        // Se instancia la clase a utilizar.
        cCRUD = new CandyInventoryCRUD(); 
        // Se declaran los arreglos a utilizar
        ArrayList<String>       idInventory         = new ArrayList<>(),
                                namesCandy     = new ArrayList<>(),
                                namesBranch     = new ArrayList<>(),
                                priceCandy     = new ArrayList<>(),
                                stockx         = new ArrayList<>();
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            
            // Se realiza la bÃºsqueda de empleados.
            result = cCRUD.readCandys(buildSentenceSQL());
            
            // Se obtienen los resultados.
            while(result.next()){
                
                idInventory.add(result.getString("Codigo"));
                namesCandy.add(result.getString("nombre"));
                namesBranch.add(result.getString("nombreSucursal"));
                priceCandy.add(result.getString("precio"));
                stockx.add(result.getString("Stock"));
            }
            
            System.out.println("Carga exitosa. Cantidad de las golocinas encontradas: " + idInventory.size());
            
            // Se obtuvo al menos un resultado.
            if(idInventory.size() > 0){
                
                // Se limpia la tabla de empleados.
                canManagement.clearInventoryCandyTable(canManagement.tblInventoryCandyList );
                
                // Se obtiene el modelo de la tabla de empleados.
                DefaultTableModel dtm = (DefaultTableModel) canManagement.tblInventoryCandyList.getModel();

                // Se declara e instancia la clase Table.
                Table table = new Table();

                // Se declara e instancia el componente JButton.
                JButton btnD = new JButton();
                JButton btnR = new JButton();

                // Se le dan las propiedades al JButton.
                table.addDeleteButton(btnD);
                table.addSearchButton(btnR);
                
                // Se aÃ±aden todos los resultados obtenidos a la tabla.
                for(int i = 0; i < idInventory.size(); i++){

                    dtm.addRow(new Object[]{
                        idInventory.get(i),
                        namesBranch.get(i),
                        namesCandy.get(i),
                        priceCandy.get(i),
                        stockx.get(i),
                        btnR,
                        btnD
                    });

                }
            }
            
            // No se obtuvo ningÃºn resultado.
            else
                popup = new PopupMessage(canManagement, true, 1, "No se encontraron golosinas.");
                            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }   
    
    
   private void generateCode()
   {
        cCRUD = new CandyInventoryCRUD(); 
    ArrayList<String>       idInventory         = new ArrayList<>();
       String SQL = "SELECT inventario_golosina.\"Codigo\" "
                                    + "FROM \"inventario_golosina\" "
                                    + "ORDER BY \"Codigo\";";
            java.sql.ResultSet result;
        try 
        {
            // Se realiza la bÃºsqueda de empleados.
            result = cCRUD.readCandys(SQL);
            // Se obtienen los resultados.
            while(result.next()){
                idInventory.add(result.getString("Codigo"));
            }
            System.out.println("Carga exitosa. Cantidad de INV : " + idInventory.size());
            if(idInventory.size() > 0)
           {
               String[] cod = idInventory.get(idInventory.size()-1).split("-");
               int newCN = Integer.parseInt(cod[1]);
               newCN++;
               String newCode=  cod[0] + "-" +  newCN ;
               this.newCode=newCode;
               System.out.println(idInventory.size()+" "+ cod[0] + "-" +  newCN);
           }
        } 
        catch (java.sql.SQLException e) {
            System.out.println("Error: " + e);
        }    
   }
    
    
    /**
     * MÃ©todo para registrar una nueva golosina.
     */
    private void registerCandyData(){
        generateCode();
        String codexBranch = loadCodeBranch(canManagement.lblSucursalName.getText());
        String codexCandy =loadCodeCandy(canManagement.cmbCandySelection.getSelectedItem().toString());
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        System.out.println(codexCandy+" "+ codexBranch);
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        // Se carga la nueva informaciÃ³n del golosina.
        candy = new CandyInventory(newCode,
                                    codexCandy, 
                                    codexBranch, 
                                    (int) canManagement.spnCantCandySell.getValue(), 
                                    'A');
        // Se ejecuta el registro de datos.
        cCRUD.registerCandy(candy);
        
        // Se muestra mensaje de Ã©xito.
        popup = new PopupMessage(canManagement, true, 4, 
                "El inventario ha sido agregado con Éxito");
        
    }    
    /**
     * MÃ©todo para actualizar la informaciÃ³n de la golosina.
     * @param id codigo de la golosina a actualizar.
     */
    private void updateCandyData(String id){
generateCode();
        String codexBranch = loadCodeBranch(canManagement.lblSucursalName.getText());
        String codexCandy =loadCodeCandy(canManagement.cmbCandySelection.getSelectedItem().toString());
        candy = new CandyInventory(newCode,
                                    codexCandy, 
                                    codexBranch, 
                                    (int) canManagement.spnStock.getValue(), 
                                    'A');
        // Se ejecuta la actualizaciÃ³n de datos.
        cCRUD.UpdateCandy(candy, id);
        
        // Se muestra mensaje de Ã©xito.
        popup = new PopupMessage(canManagement, true, 4, 
                "Los datos del inventario se han actualizado con Éxito.");
        
    }
    
/*    private void generateCode()
    {
        // Se fragmenta el dato proporcionado.
        String[] names = empManagement.txtSearchNameEmployee.getText().split(" ");
    }*/

    
    /**
     * MÃ©todo para limpiar las variables.
     */
    private void clearVariables()
    {   
        id          = "";
        idCandy        = "";
        idBranch       = "";
        stock       =0;
        estatus     ='A';
        name="";
        descr="";
    price=0.0;
    }
    
    private void loadinterface()
    {
        loadCandyTable();
        ArrayList<String> golosinas = new ArrayList<>();
        loadAllCandys(golosinas);
        // Se llena el combobox de las sucursales.
        canManagement.cmbCandySelection.removeAllItems();
        canManagement.cmbCandySelection.addItem(" - Seleccionar - ");
        for(int i = 0; i < golosinas.size(); i++)
            canManagement.cmbCandySelection.addItem(golosinas.get(i));
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" PROHIBIDO TOCAR ">
   // @Override
   /* public void actionPerformed(ActionEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

  //  @Override
  /*  public void mouseClicked(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       //</editor-fold>
}
