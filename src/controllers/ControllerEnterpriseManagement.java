
package controllers;

// Se importan las librerías de soporte.
import lib.SupportFunctions;

// Se importan los models a utilizar.
import models.Enterprise;
import models.database.EnterpriseCRUD;

// Se importan las views a utilizar.
import views.EnterpriseManagement;
//import views.ChangeBranch;
import views.PopupMessage;
import views.SelectOption;
import views.tables.Table;

// Se importan las librerías a utilizar.
import java.awt.event.*;
//import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

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
public class ControllerEnterpriseManagement implements ActionListener, MouseListener{
    
//<editor-fold defaultstate="collapsed" desc=" Declaración de variables ">
// Models
    private Enterprise enterprise;
        // Models.database
        private EnterpriseCRUD enterCRUD;
        //private BranchCRUD braCRUD;
    
    // Views
    private EnterpriseManagement enterManagement;
    //private ChangeBranch changeBranch;
    private PopupMessage popup;
    
    // Controllers
    private ControllerMainMenu contMainMenu;
    
    // Librerías de soporte
    private SupportFunctions support;
    
    // Variables del usuario.
    private String  rolUser,
                    nameUser,
                    branchUser;
    
    // Variables para CRUD del empleado.
    private String  id,
                    name,
                    description,
                    enteremail; 
    
    private double    priceticket;
 
    //</editor-fold>
    /**
     * Constructor del gestor de empresas.
     * @param rolUser Rol del usuario que ha ingresado al sistema.
     * @param nameUser Nombre del usuario que ha ingresado al sistema.
     * @param branchUser Nombre de la sucursal del usuario que ha ingresado al sistema.
     */
    public ControllerEnterpriseManagement(String rolUser, String nameUser, String branchUser){
        
        // Declarar la variable de las clases instanciadas.
        enterManagement = new EnterpriseManagement();
        support         = new SupportFunctions();
        
        // Se inicializan las variables.
        this.rolUser    = rolUser;
        this.nameUser   = nameUser;
        this.branchUser = branchUser;
        
        // Se muestra la primera pantalla.
        support.cardSelection(enterManagement.panContainerEnterprise, enterManagement.panConsultList);
        
        // Se cargan las empresas.
        loadEnterpriseTable();
        
        // Se habilitan o deshabilitan los botónes según tipo de usuario.
        //enabledButtons(this.rolUser);
        
        // Se inicializan las variables.
        clearVariables();
        
        // Activamos los eventos por las views.
        enterManagement.addEvents(this);
        enterManagement.addMouseEvents(this);
        
    }
  /**
     * Método que determina las acciones a realizar por la aplicación según el 
     * botón presionado.
     * @param evt indica los eventos posibles a ocurrir (click en botónes).
     */  

    @Override
    public void actionPerformed(ActionEvent evt) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //<editor-fold defaultstate="collapsed" desc=" Botones de la Barra Superior ">
        
        // Minimizar aplicación.
        if(evt.getSource() == enterManagement.btnMin){
            enterManagement.setExtendedState(java.awt.Frame.ICONIFIED);
            enterManagement.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir de la aplicación.
        else if(evt.getSource() == enterManagement.btnExit){
            enterManagement.dispose();
        } 
        
        //</editor-fold>
    
     //<editor-fold defaultstate="collapsed" desc=" Branch Change ">
      /*  
        // Cambiar de sucursal a gestionar
        else if(evt.getSource() == empManagement.btnChangeBranch){
            
            ArrayList<String>   cityNames   = loadCityNames(),
                                cityBranch  = new ArrayList<>(),
                                branchNames = new ArrayList<>();
            
            loadBranch(cityBranch, branchNames);
                        
            // Instanciar la clase
            changeBranch = new ChangeBranch(empManagement, true, cityNames, cityBranch, branchNames, rolUser);
            
            // Se ubica el nombre de la sucursal.
            empManagement.lblSucursalName.setText(changeBranch.getId_Sucursal());
                        
            changeBranch.dispose();
            
        }*/
        
        //</editor-fold>
    
     //<editor-fold defaultstate="collapsed" desc=" Enterprise Search ">
        
        // Buscar a una empresa.
        else if(evt.getSource() == enterManagement.btnSearchEnterprise){
            
            // Si no se ingresó información para filtrar.
            if  ((enterManagement.txtSearchIdEnterprise.getText().equals("") || 
                    enterManagement.txtSearchIdEnterprise.getText().equals("Codigo de la empresa")) &&
                (enterManagement.txtSearchNameEnterprise.getText().equals("") ||
                    enterManagement.txtSearchNameEnterprise.getText().equals("Nombre de la empresa"))) 
                
                //&&(enterManagement.cmbSearchJobEmployee.getSelectedIndex() == 0))
                    popup = new PopupMessage(enterManagement, true, 1, "Debe ingresar al menos un dato para filtrar.");
            
            // Si al menos se ingresó algún dato para filtrar.
            else
                loadEnterpriseTable();
                
        }
        
        //</editor-fold>
    
     //<editor-fold defaultstate="collapsed" desc=" Enterprise Table Clear ">
        
        // Limpiar el consultar listado.
        else if(evt.getSource() == enterManagement.btnClearSearchEnterprise){
            
            enterManagement.clearEnterpriseSearch();
            
            loadEnterpriseTable();
            
        }
        
        //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Back to Consult List ">
        
        // Para volver a la view de consulta.
        else if(evt.getSource() == enterManagement.btnBackEnterprise){
            
            // Se validan todos los campos.
            if(!enterManagement.txtIdEnterprise.getText().equals("Codigo de la empresa") && 
                    !enterManagement.txtIdEnterprise.getText().equals("") &&
                    !enterManagement.txtNameEnterprise.getText().equals("Nombre de la empresa") &&
                    !enterManagement.txtNameEnterprise.getText().equals("") &&
                    !enterManagement.txtDescriptionEnterprise.getText().equals("Descripcion de la empresa") &&
                    !enterManagement.txtDescriptionEnterprise.getText().equals("") &&
                    !enterManagement.txtEmailEnterprise.getText().equals("Correo electronico de la empresa") &&
                    !enterManagement.txtEmailEnterprise.getText().equals("") &&
                    !enterManagement.txtPriceTicketEnterprise.getText().equals("Precio base boleto de funciones") &&
                    !enterManagement.txtPriceTicketEnterprise.getText().equals("") ){
                
                // Se pregunta al usuario si desea abandonar la consulta.
                SelectOption select = new SelectOption(enterManagement, true, 1, 
                        "¿Está seguro que desea abandonar la consulta?", "Si", "No");
                
                // Si la respuesta es afirmativa.
                if(select.getOpc()){
                    
                    // Se muestra la vista del CRUD.
                    support.cardSelection(enterManagement.panContainerEnterprise, enterManagement.panConsultList);
                    
                    // Se cargan los empleados.
                    loadEnterpriseTable();
                    
                    // Se inicializan las variables.
                    clearVariables();
                                        
                }    
                   
            }
            
            // Si no hay campos modificados.
            else{
                
                // Se muestra la vista del CRUD.
                support.cardSelection(enterManagement.panContainerEnterprise, enterManagement.panConsultList);
                    
                // Se cargan los empleados.
                loadEnterpriseTable();
                
                // Se inicializan las variables.
                clearVariables();
                
            }
                
        }
        
        //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Clear form ">
        
        // Si se desea limpiar un empleado.
        else if(evt.getSource() == enterManagement.btnClearEnterprise){
            
            if(id.equals(""))
                enterManagement.clearView();
            else{
                
                // Se muestran los datos obtenidos.
                enterManagement.txtIdEnterprise.setText(id);
                //enterManagement.cmbBranchEmployee.setSelectedItem(branch);
                enterManagement.txtNameEnterprise.setText(name);
                enterManagement.txtDescriptionEnterprise.setText(description);
                enterManagement.txtEmailEnterprise.setText(enteremail);
                enterManagement.txtPriceTicketEnterprise.setText(String.valueOf(priceticket));
                
                
            }
                
        }
        
        //</editor-fold>      
 
    //<editor-fold defaultstate="collapsed" desc=" Register or Update Enterprise ">
        
        // Registro o Modificación de empleado.
        else if(evt.getSource() == enterManagement.btnRegisterModifyEnterprise){
            
            /**
             * Si la variable global 'id' se encuentra vacía, se tiene que el caso
             * es un registro.
             */
            if(id.equals("")){
                
                
                // De no haber campos vacíos.
                if( !enterManagement.txtIdEnterprise.getText().equals("") && 
                    !enterManagement.txtIdEnterprise.getText().equals("Codigo de la empresa") && 
                    !enterManagement.txtNameEnterprise.getText().equals("") &&
                    !enterManagement.txtNameEnterprise.getText().equals("Nombre de la empresa") &&
                    !enterManagement.txtDescriptionEnterprise.getText().equals("") &&
                    !enterManagement.txtDescriptionEnterprise.getText().equals("Descripcion de la empresa") &&
                    !enterManagement.txtEmailEnterprise.getText().equals("") &&
                    !enterManagement.txtEmailEnterprise.getText().equals("Correo electronico de la empresa") &&
                    !enterManagement.txtPriceTicketEnterprise.getText().equals("") &&
                    !enterManagement.txtPriceTicketEnterprise.getText().equals("Precio base boleto de funciones")){
                
                        // Se confirma que se desea eliminar el registro.
                        SelectOption select = new SelectOption(enterManagement, true, 2, 
                                "¿Desea registrar a esta empresa?", "Si", "No");

                        // Si se confirma el registro.
                        if(select.getOpc()){

                            // Si el empleado ya existe pero se encuentra inactivo.
                            if(enterCRUD.enterpriseExist(enterManagement.txtIdEnterprise.getText(), 'I')){
                                
                                // Se cambia el estado del empleado a activo.
                                enterCRUD.DeleteEnterprise(enterManagement.txtIdEnterprise.getText(), 1);
                                
                                // Se actualiza la información del empleado.
                                updateEnterpriseData(enterManagement.txtIdEnterprise.getText());
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(enterManagement.panContainerEnterprise, enterManagement.panConsultList);

                                // Se cargan los empleados.
                                loadEnterpriseTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                            }
                            
                            // Si el usuario no existe.
                            else{
                            
                                // Se ejecuta el registro de información.
                                registerEnterpriseData();
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(enterManagement.panContainerEnterprise, enterManagement.panConsultList);

                                // Se cargan los empleados.
                                loadEnterpriseTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                            }
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(enterManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
      
                
            }
            
            /**
             * Si la variable global 'id' posee algún dato, se tiene el caso de modificación
             * de un registro.
             */
            else{
                
                // De no haber campos vacíos.
                if( !enterManagement.txtIdEnterprise.getText().equals("") && 
                    !enterManagement.txtIdEnterprise.getText().equals("Codigo de la empresa") && 
                    !enterManagement.txtNameEnterprise.getText().equals("") &&
                    !enterManagement.txtNameEnterprise.getText().equals("Nombre de la empresa") &&
                    !enterManagement.txtDescriptionEnterprise.getText().equals("") &&
                    !enterManagement.txtDescriptionEnterprise.getText().equals("Descripcion de la empresa") &&
                    !enterManagement.txtEmailEnterprise.getText().equals("") &&
                    !enterManagement.txtEmailEnterprise.getText().equals("Correo electronico de la empresa") &&
                    !enterManagement.txtPriceTicketEnterprise.getText().equals("") &&
                    !enterManagement.txtPriceTicketEnterprise.getText().equals("Precio base boleto de funciones")){
                
                        // Se confirma que se desea eliminar el registro.
                        SelectOption select = new SelectOption(enterManagement, true, 2, 
                                "¿Desea actualizar los datos de esta empresa?", "Si", "No");

                        // Si se confirma la actualización.
                        if(select.getOpc()){

                            // Se ejecuta la actualización de información.
                            updateEnterpriseData(id);
                            
                            // Se muestra la vista del CRUD.
                            support.cardSelection(enterManagement.panContainerEnterprise, enterManagement.panConsultList);

                            // Se cargan los empleados.
                            loadEnterpriseTable();

                            // Se inicializan las variables.
                            clearVariables();
                            
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(enterManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
                                    
            }
            
        }
        
        //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Delete Enterprise ">
        
        // Eliminación de una empresa.
        else if(evt.getSource() == enterManagement.btnDeleteEnterprise){
            
            // Se pregunta al usuario si desea realmente eliminar al empleado.
            SelectOption select = new SelectOption(enterManagement, true, 2, 
                    "¿Está seguro que desea eliminar a esta empresa?", "Si", "No");
            
            // Si la respuesta es afirmativa.
            if(select.getOpc()){
                
                // Se realiza la eliminación lógica.
                enterCRUD.DeleteEnterprise(id, 0);
                
                // Se muestra un mensaje de eliminación exitosa.
                popup = new PopupMessage(enterManagement, true, 4, "La empresa se ha eliminado con éxito.");
                
                // Se muestra la vista del CRUD.
                support.cardSelection(enterManagement.panContainerEnterprise, enterManagement.panConsultList);
                    
                // Se cargan los empleados.
                loadEnterpriseTable();
                    
                // Se inicializan las variables.
                clearVariables();
                
            }
            
        }
        
        //</editor-fold>
    
    }
 /**
     * Eventos provocados por el escuchador de Mouse (MouseListener)
     * @param evt son aquellos eventos que ocurren con acciones del Mouse.
     */
    @Override
    public void mouseClicked(MouseEvent evt) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // Si se hace click sobre la tabla de empresas.
        if(evt.getSource() == enterManagement.tblEnterpriseList){
                                              
            // Se obtienen los valores de la fila y columna seleccionada.
            int column = enterManagement.getColumnTable(), row = enterManagement.getRowTable();

            // Se valida que el evento del Mouse fue provocado dentro del JTable.
            if(row < enterManagement.tblEnterpriseList.getRowCount() && row >= 0 && 
                    column < enterManagement.tblEnterpriseList.getColumnCount() && column >= 0){
                
                // Se obtiene el valor de la celda seleccionada.
                Object value = enterManagement.tblEnterpriseList.getValueAt(row, column);
                
                // Si el valor de la celda seleccionada es un JButton;
                if(value instanceof JButton){
                    
                    ((JButton)value).doClick();
                    
                    JButton btn = (JButton) value;

                    //<editor-fold defaultstate="collapsed" desc=" Proceso para consultar una empresa ">
                    
                    // Si el JButton se llama "s";
                    if(btn.getName().equals("s")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                                      
                        // Se obtiene el modelo de la JTable.
                        DefaultTableModel dtm = (DefaultTableModel) enterManagement.tblEnterpriseList.getModel();
                                                
                        // Se obtiene el id de la empresa en cuestión.
                        String idEnterprise = dtm.getValueAt(row, 0).toString();
                        
                        // Se buscan los datos de la empresa.
                        loadEnterprise(idEnterprise);
                        
                        /*// Se crea la variable de formato de fechas.
                        SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
                                       
                        // Variables de apoyo para construir el comboBox de sucursales.
                        ArrayList<String>   codexBranch = new ArrayList<>(),
                                            namesBranch = new ArrayList<>();
                        
                        // Se obtienen los datos de las sucursales.
                        loadBranch(codexBranch, namesBranch);
                        
                        // Se llena el combobox de las sucursales.
                        empManagement.cmbBranchEmployee.removeAllItems();
                        empManagement.cmbBranchEmployee.addItem(" - Seleccionar una Sucursal - ");
                        
                        for(int i = 0; i < codexBranch.size(); i++)
                            empManagement.cmbBranchEmployee.addItem(namesBranch.get(i));*/
                                                    
                        // Se muestra la vista del CRUD.
                        support.cardSelection(enterManagement.panContainerEnterprise, enterManagement.panCRUD);
                        
                        // Se bloquea el botón de 'eliminar'.
                        enterManagement.btnDeleteEnterprise.setEnabled(true);
                        
                        // Se configura el texto del botón.
                        enterManagement.btnRegisterModifyEnterprise.setText("Modificar");
                        
                        // Se limpian todos los aspectos visuales.
                        enterManagement.clearView();
                                                
                        // Se muestran los datos obtenidos.
                        enterManagement.txtIdEnterprise.setText(id);
                        enterManagement.txtNameEnterprise.setText(name);
                        enterManagement.txtDescriptionEnterprise.setText(description);
                        enterManagement.txtEmailEnterprise.setText(enteremail);
                        enterManagement.txtPriceTicketEnterprise.setText(String.valueOf(priceticket));
                        
                        // Se bloquea el campo de cédula.
                        enterManagement.txtIdEnterprise.setEnabled(false);
                        
                    }
                    
                    //</editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc=" Proceso para crear una empresa ">
                    
                    // Si el JButton se llama "i";
                    if(btn.getName().equals("i")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                                     
                        // Se muestra la vista del CRUD.
                        support.cardSelection(enterManagement.panContainerEnterprise, enterManagement.panCRUD);
                        
                        // Se bloquea el botón de 'eliminar'.
                        enterManagement.btnDeleteEnterprise.setEnabled(true);
                        
                        // Se configura el texto del botón.
                        enterManagement.btnRegisterModifyEnterprise.setText("Registrar");
                        
                        // Se limpian todos los aspectos visuales.
                        enterManagement.clearView();
                        
                        // Se limpian las variables
                        clearVariables();
                        
                        
                        
                    }
                        
                    //</editor-fold>
                    
                }

            }

        } 
    
    }
    
 //<editor-fold defaultstate="collapsed" desc=" Métodos para el funcionamiento del Controller ">
    
    /**
     * Método para habilitar o deshabilitar botónes según tipo de usuario.
     * @param rol Rol del usuario que ha ingresado al sistema.
     */
    /*private void enabledButtons(String rol){
        
        switch(rol){
            
            // Rol: Administrador
            case "ROL-01":
                
                empManagement.btnChangeBranch.setEnabled(true);
                empManagement.lblSucursalName.setText(branchUser);
                
                break;
                
            // Rol: Gerente
            case "ROL-02":
                
                empManagement.btnChangeBranch.setEnabled(false);
                empManagement.lblSucursalName.setText(branchUser);
                
                break;
            
        }
        
    }*/
    
    /**
     * Método para cargar todas las empresas.
     * @return Listado de nombres de empresas.
     */
    private void loadEnterprise(String idEnterprise){
        
        // Se instancia la clase a utilizar.
        enterCRUD = new EnterpriseCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
                
        try {
            result = enterCRUD.readEnterpriseData(idEnterprise);
            while(result.next()){
                id = result.getString("codigo");
                name = result.getString("nombre");
                description = result.getString("descripcion");
                enteremail = result.getString("correo");
                priceticket = result.getDouble("precio_boleto");
                
            }
            
            System.out.println("Éxito.");
                        
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
                
    }
        
    /**
     * Método para cargar sucursales.
     * @param firstList Primer listado con los nombres de ciudades.
     * @param secondList Segundo listado con los nombres de sucursales.
     */
    /*private void loadBranch(ArrayList<String> firstList, ArrayList<String> secondList){
        
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
        
    }*/
    
    /**
     * Método para buscar el código de una sucursal.
     * @param branchName Nombre de la sucursal.
     * @return Devuelve el código de la sucursal.
     */
   /* private String loadBranch(String branchName){
        
                // Se instancia la clase a utilizar.
        braCRUD = new BranchCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        // Variable de soporte.
        String codex;
        
        try {
            result = braCRUD.readOnlyBranch(branchName);
            while(result.next()){
                codex = result.getString("codigo");
            }
                        
            System.out.println("Éxito.");
                                    
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
        return null;
        
    }*/
    
    /**
     * Método para cargar todas ciudades.
     * @return Listado de nombres de ciudades.
     */
   /* private ArrayList<String> loadCityNames(){
        
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
        
    }*/
    
    /**
     * Método para construir la sentencia de búsqueda del empleado.
     * @return Sentencia SQL.
     */
    private String buildSentenceSQL(){
        
        // Se declaran e inicializan las variables que servirán para buscar empleados.
        String  initSQL     = "SELECT \"codigo\", \"nombre\", \"descripcion\", \"correo\", \"precio_boleto\""      
                                    + "FROM \"empresa\" WHERE \"estado\" = 'A'",
                finalSQL    = ";",
                nameSQL     = " AND \"nombre\" = ",
                idSQL       = " AND \"codigo\" = ",
                decripSQL       = " AND \"descripcion\" = ",
                emailSQL       = " AND \"correo\" = ",
                priceSQL       = " AND \"precio_boleto\" = ",
               // branchSQL   = " AND sucursal.\"nombre\" = ",
                SQL         = "";
         
        // Se inicia la sentencia SQL;
        SQL += initSQL;
        
        // Si se ingresó el codigo de una empresa.
        if(!enterManagement.txtSearchIdEnterprise.getText().equals("Codigo de la empresa") && 
                !enterManagement.txtSearchIdEnterprise.getText().equals(""))
            SQL += idSQL + "'" + enterManagement.txtSearchIdEnterprise.getText() + "'";
                
        // Si se ingresó el nombre de la empresa.
        if(!enterManagement.txtSearchNameEnterprise.getText().equals("") &&
                !enterManagement.txtSearchNameEnterprise.getText().equals("Nombre de la empresa"))
            SQL += idSQL + "'" + enterManagement.txtSearchNameEnterprise.getText() + "'";       
           /*
            // Se fragmenta el dato proporcionado.
            String[] names = empManagement.txtSearchNameEmployee.getText().split(" ");
                 
            // Se construye la sentencia.
            if(names.length == 2)
                SQL += nameSQL + "'" + names[0] + "'" + lastNameSQL + "'" + names[1] + "'";
            else
                SQL += nameSQL + "'" + names[0] + "'";
                                
        }
        
        if(!empManagement.lblSucursalName.getText().equals("") &&
                !empManagement.lblSucursalName.getText().equals("Sucursal ") &&
                !empManagement.lblSucursalName.getText().equals(" - Seleccione - ") &&
                !empManagement.lblSucursalName.getText().equals("Cines de Venezuela") && 
                !empManagement.lblSucursalName.getText().equals(" Administrador "))
            SQL += branchSQL + "'" + empManagement.lblSucursalName.getText() + "'";
         
        // Si se ingresó un cargo.
        if(empManagement.cmbSearchJobEmployee.getSelectedIndex() != 0)
            SQL += jobSQL + "'" + empManagement.cmbSearchJobEmployee.getSelectedItem().toString() + "'";*/
          
        // Se culmina la sentencia.
        return SQL += finalSQL;
        
    }
    
    /**
     * Método para cargar la información de la empresa.
     * @return listado con la información de la empresa.
     */
    private void loadEnterpriseTable(){
                
        // Se instancia la clase a utilizar.
        enterCRUD = new EnterpriseCRUD();
        
        // Se declaran los arreglos a utilizar
        ArrayList<String>   idEnterprise      = new ArrayList<>(),
                            nameEnterprise   = new ArrayList<>(),
                            descriptionEnterprise   = new ArrayList<>(),
                            emailEnterprise   = new ArrayList<>(),
                            priceticketEnterprise   = new ArrayList<>();
                            //branchEmployee  = new ArrayList<>(),
                            //jobEmployee     = new ArrayList<>();
                
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            
            // Se realiza la búsqueda de empleados.
            result = enterCRUD.readEnterprise(buildSentenceSQL());
            
            // Se obtienen los resultados.
            while(result.next()){
                
                idEnterprise.add(result.getString("codigo"));
                nameEnterprise.add(result.getString("nombre"));
                descriptionEnterprise.add(result.getString("descripcion"));
                emailEnterprise.add(result.getString("correo"));
                priceticketEnterprise.add(result.getString("precio_boleto"));
                

//branchEmployee.add(result.getString("nombreSucursal"));
                //jobEmployee.add(result.getString("cargo"));
                                   
            }
            
            System.out.println("Carga exitosa. Cantidad de empresas encontradas: " + idEnterprise.size());
            
            // Se obtuvo al menos un resultado.
            if(idEnterprise.size() > 0){
                
                // Se limpia la tabla de empresas.
                enterManagement.clearEnterpriseTable(enterManagement.tblEnterpriseList);
                
                // Se obtiene el modelo de la tabla de empresas
                DefaultTableModel dtm = (DefaultTableModel) enterManagement.tblEnterpriseList.getModel();

                // Se declara e instancia la clase Table.
                Table table = new Table();

                // Se declara e instancia el componente JButton.
                JButton btnI = new JButton();
                JButton btnR = new JButton();

                // Se le dan las propiedades al JButton.
                table.addIncorporateButton(btnI);
                table.addSearchButton(btnR);

                dtm.addRow(new Object[]{
                    " . . . ",
                    " . . . ",
                    " . . . ",
                    " . . . ",
                    " . . . ",
                    btnI
                });
                
                // Se añaden todos los resultados obtenidos a la tabla.
                for(int i = 0; i < idEnterprise.size(); i++){

                    dtm.addRow(new Object[]{
                        idEnterprise.get(i),
                        nameEnterprise.get(i),
                        descriptionEnterprise.get(i),
                        emailEnterprise.get(i),
                        priceticketEnterprise.get(i),
                        //branchEmployee.get(i),
                        //jobEmployee.get(i),
                        btnR
                    });

                }
                                
            }
            
            // No se obtuvo ningún resultado.
            else
                popup = new PopupMessage(enterManagement, true, 1, "No se encontraron empresas.");
                            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }
    
    /**
     * Método para registrar a una nueva empresa.
     */
    private void registerEnterpriseData(){
                        
        // Se carga la nueva información del empleado.
        Enterprise enter = new Enterprise(
                                    enterManagement.txtIdEnterprise.getText(), 
                                    enterManagement.txtNameEnterprise.getText(), 
                                    enterManagement.txtDescriptionEnterprise.getText(),
                                    enterManagement.txtEmailEnterprise.getText(),
                                    Double.valueOf(enterManagement.txtPriceTicketEnterprise.getText()), 
                                    'A' 
                                    /*loadBranch(empManagement.cmbBranchEmployee.getSelectedItem().toString()), 
                                    empManagement.cmbJobEmployee.getSelectedItem().toString(),    
                                    empManagement.dchEntranceDateEmployee.getDate()*/ );
        
        // Se ejecuta el registro de datos.
        enterCRUD.registerEnterprise(enter);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(enterManagement, true, 4, 
                "La empresa se ha registrado con éxito");
        
    }
    
    /**
     * Método para actualizar la información de una empresa.
     * @param id cédula del empleado a actualizar.
     */
    private void updateEnterpriseData(String id){
                        
        // Se carga la nueva información del empleado.
        Enterprise enter = new Enterprise(
                                    enterManagement.txtIdEnterprise.getText(), 
                                    enterManagement.txtNameEnterprise.getText(), 
                                    enterManagement.txtDescriptionEnterprise.getText(),
                                    enterManagement.txtEmailEnterprise.getText(),
                                    Double.valueOf(enterManagement.txtPriceTicketEnterprise.getText()), 
                                    'A' 
                                    /*loadBranch(empManagement.cmbBranchEmployee.getSelectedItem().toString()), 
                                    empManagement.cmbJobEmployee.getSelectedItem().toString(),    
                                    empManagement.dchEntranceDateEmployee.getDate()*/ );
        
        // Se ejecuta la actualización de datos.
        enterCRUD.UpdateEnterprise(enter, id);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(enterManagement, true, 4, 
                "Los datos del empleados se han actualizado con éxito.");
        
    }
    
    /**
     * Método para limpiar las variables.
     */
    private void clearVariables(){
        
        id          = "";
        name        = "";
        description  = "";
        enteremail   = "";
        priceticket  = 0; 
        
    }
    
    //</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc=" PROHIBIDO TOCAR ">
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
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 //</editor-fold>    
    
    
    
    
    
    
    
}
