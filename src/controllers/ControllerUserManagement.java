/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
// Se importan las librerías de soporte.
import lib.SupportFunctions;

// Se importan los models a utilizar.
import models.User;
import models.database.UserCRUD;
import models.database.BranchCRUD;
import models.database.RoleCRUD;
import models.database.CityCRUD;

// Se importan las views a utilizar.
import views.UserManagement;
import views.ChangeBranch;
import views.PopupMessage;
import views.SelectOption;
import views.tables.Table;

// Se importan las librerías a utilizar.
import java.awt.event.*;
import java.text.SimpleDateFormat;
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

public class ControllerUserManagement implements ActionListener, MouseListener{
    
        //<editor-fold defaultstate="collapsed" desc=" Declaración de variables ">
    
    // Models
    private User us;
    // Models.database
    private UserCRUD usCRUD;
    private BranchCRUD braCRUD;
    private CityCRUD citCRUD;
    
    // Views
    private UserManagement usManagement;
    private ChangeBranch changeBranch;
    private PopupMessage popup;
    
    // Controllers
    private ControllerMainMenu contMainMenu;
    
    // Librerías de soporte
    private SupportFunctions support;
    
    // Variables del usuario.
    private String  rolUser,
                    nameUser,
                    branchUser;
    
    // Variables para CRUD del Usuario.
    private String  email,
                    employee_id,
                    nameEmployee,
                    lastNameEmployee,
                    role_id,
                    nameRol,
                    password;
    
    
    //</editor-fold>
    
    /**
     * Constructor del gestor de Usuarios.
     * @param rolUser Rol del usuario que ha ingresado al sistema.
     * @param nameUser Nombre del usuario que ha ingresado al sistema.
     * @param branchUser Nombre de la sucursal del usuario que ha ingresado al sistema.**/
    
     public ControllerUserManagement(String rolUser, String nameUser, String branchUser){
        
        // Declarar la variable de las clases instanciadas.
        usManagement   = new UserManagement();
        support         = new SupportFunctions();
        
        // Se inicializan las variables.
        this.rolUser    = rolUser;
        this.nameUser   = nameUser;
        this.branchUser = branchUser;
        
        // Se muestra la primera pantalla.
        support.cardSelection(usManagement.panContainerUser, usManagement.panConsultList);
        
        // Se cargan los Usuarios.
        loadUserTable();
        
        // Se habilitan o deshabilitan los botónes según tipo de usuario.
        enabledButtons(this.rolUser);
        
        // Se inicializan las variables.
        clearVariables();
        
        // Activamos los eventos por las views.
        usManagement.addEvents(this);
        usManagement.addMouseEvents(this);
        
        }
    
     public void actionPerformed(ActionEvent evt) {
        
        //<editor-fold defaultstate="collapsed" desc=" Botones de la Barra Superior ">
        
        // Minimizar aplicación.
        if(evt.getSource() == usManagement.btnMin){
            usManagement.setExtendedState(java.awt.Frame.ICONIFIED);
            usManagement.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir de la aplicación.
        else if(evt.getSource() == usManagement.btnExit){
            usManagement.dispose();
        } 
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Branch Change ">
        
        // Cambiar de sucursal a gestionar
        else if(evt.getSource() == usManagement.btnChangeBranch){
            
            ArrayList<String>   cityNames   = loadCityNames(),
                                cityBranch  = new ArrayList<>(),
                                branchNames = new ArrayList<>();
            
            loadBranch(cityBranch, branchNames);
                        
            // Instanciar la clase
            changeBranch = new ChangeBranch(usManagement, true, cityNames, cityBranch, branchNames, rolUser);
            
            // Se ubica el nombre de la sucursal.
            usManagement.lblSucursalName.setText(changeBranch.getId_Sucursal());
                        
            changeBranch.dispose();
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" User Search ">
        
        // Buscar a un usuario.
        else if(evt.getSource() == usManagement.btnSearchUser){
            
            // Si no se ingresó información para filtrar.
            if  ((usManagement.txtSearchIdUser.getText().equals("") || 
                    usManagement.txtSearchIdUser.getText().equals("Cédula del usuario")) &&
                (usManagement.cmbSearchRoleUser.getSelectedIndex() == 0))
                    popup = new PopupMessage(usManagement, true, 1, "Debe ingresar al menos un dato para filtrar.");
            
            // Si al menos se ingresó algún dato para filtrar.
            else
                loadUserTable();
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" User Table Clear ">
        
        // Limpiar el consultar listado.
        else if(evt.getSource() == usManagement.btnClearSearchUser){
            
            usManagement.clearUserSearch();
            
            loadUserTable();
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Back to Consult List ">
        
        // Para volver a la view de consulta.
        else if(evt.getSource() == usManagement.btnBackUser){
            
            // Se validan todos los campos.
            if(!usManagement.txtEmailUser.getText().equals("Correo electrónico del usuario") && 
                    !usManagement.txtEmailUser.getText().equals("") &&
                    !usManagement.txtIdUser.getText().equals("Cédula del usuario") &&
                    !usManagement.txtIdUser.getText().equals("") &&
                    !usManagement.txtPasswordUser.getText().equals("Contraseña del usuario") &&
                    !usManagement.txtPasswordUser.getText().equals("") &&
                    usManagement.cmbRoleUser.getSelectedIndex() != 0){
                
                // Se pregunta al usuario si desea abandonar la consulta.
                SelectOption select = new SelectOption(usManagement, true, 1, 
                        "¿Está seguro que desea abandonar la consulta?", "Si", "No");
                
                // Si la respuesta es afirmativa.
                if(select.getOpc()){
                    
                    // Se muestra la vista del CRUD.
                    support.cardSelection(usManagement.panContainerUser, usManagement.panConsultList);
                    
                    // Se cargan los usuarios.
                    loadUserTable();
                    
                    // Se inicializan las variables.
                    clearVariables();
                                        
                }    
                   
            }
            
            // Si no hay campos modificados.
            else{
                
                // Se muestra la vista del CRUD.
                support.cardSelection(usManagement.panContainerUser, usManagement.panConsultList);
                    
                // Se cargan los usuarios.
                loadUserTable();
                
                // Se inicializan las variables.
                clearVariables();
                
            }
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Clear form ">
        
        // Si se desea limpiar un usuario.
        else if(evt.getSource() == usManagement.btnClearUser){
            
            if(email.equals(""))
                usManagement.clearView();
            else{
                
                // Se muestran los datos obtenidos.
                usManagement.txtEmailUser.setText(email);
                usManagement.cmbRoleUser.setSelectedItem(role_id);
                usManagement.txtIdUser.setText(employee_id);
                usManagement.txtPasswordUser.setText(role_id);
                
            }
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Register or Update User ">
        
        // Registro o Modificación de usuario.
        else if(evt.getSource() == usManagement.btnRegisterModifyUser){
            
            /**
             * Si la variable global 'email' se encuentra vacía, se tiene que el caso
             * es un registro.
             */
            if(email.equals("")){
                
                
                // De no haber campos vacíos.
                if( !usManagement.txtEmailUser.getText().equals("") && 
                    !usManagement.txtEmailUser.getText().equals("Correo electrónico del usuario") && 
                    !usManagement.txtIdUser.getText().equals("") &&
                    !usManagement.txtIdUser.getText().equals("Cédula del usuario") &&
                    !usManagement.txtPasswordUser.getText().equals("") &&
                    !usManagement.txtPasswordUser.getText().equals("Contraseña del usuario") &&
                     usManagement.cmbRoleUser.getSelectedIndex() != 0){
                
                        // Se confirma que se desea eliminar el registro.
                        SelectOption select = new SelectOption(usManagement, true, 2, 
                                "¿Desea registrar a este Usuario?", "Si", "No");

                        // Si se confirma el registro.
                        if(select.getOpc()){

                            // Si el usuario ya existe pero se encuentra inactivo.
                            if(usCRUD.userExist(usManagement.txtEmailUser.getText(), 'I')){
                                
                                // Se cambia el estado del usuario a activo.
                                usCRUD.DeleteUser(usManagement.txtEmailUser.getText(), 1);
                                
                                // Se actualiza la información del usuario.
                                updateUserData(usManagement.txtEmailUser.getText());
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(usManagement.panContainerUser, usManagement.panConsultList);

                                // Se cargan los usuarios.
                                loadUserTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                            }
                            
                            // Si el usuario no existe.
                            else{
                            
                                // Se ejecuta el registro de información.
                                registerUserData();
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(usManagement.panContainerUser, usManagement.panConsultList);

                                // Se cargan los usuarios.
                                loadUserTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                            }
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(usManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
      
                
            }
            
            /**
             * Si la variable global 'email' posee algún dato, se tiene el caso de modificación
             * de un registro.
             */
            else{
                
                // De no haber campos vacíos.
                if( !usManagement.txtEmailUser.getText().equals("") && 
                    !usManagement.txtEmailUser.getText().equals("Correo electrónico del usuario") && 
                    !usManagement.txtIdUser.getText().equals("") &&
                    !usManagement.txtIdUser.getText().equals("Cédula del usuario") &&
                    !usManagement.txtPasswordUser.getText().equals("") &&
                    !usManagement.txtPasswordUser.getText().equals("Contraseña del usuario") &&
                     usManagement.cmbRoleUser.getSelectedIndex() != 0){
                
                        // Se confirma que se desea eliminar el registro.
                        SelectOption select = new SelectOption(usManagement, true, 2, 
                                "¿Desea actualizar los datos de este usuario?", "Si", "No");

                        // Si se confirma la actualización.
                        if(select.getOpc()){

                            // Se ejecuta la actualización de información.
                            updateUserData(email);
                            
                            // Se muestra la vista del CRUD.
                            support.cardSelection(usManagement.panContainerUser, usManagement.panConsultList);

                            // Se cargan los empleados.
                            loadUserTable();

                            // Se inicializan las variables.
                            clearVariables();
                            
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(usManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
                                    
            }
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Delete User ">
        
        // Eliminación de un usuario.
        else if(evt.getSource() == usManagement.btnDeleteUser){
            
            // Se pregunta al usuario si desea realmente eliminar al usuario seleccionado.
            SelectOption select = new SelectOption(usManagement, true, 2, 
                    "¿Está seguro que desea eliminar a este usuario?", "Si", "No");
            
            // Si la respuesta es afirmativa.
            if(select.getOpc()){
                
                // Se realiza la eliminación lógica.
                usCRUD.DeleteUser(email, 0);
                
                // Se muestra un mensaje de eliminación exitosa.
                popup = new PopupMessage(usManagement, true, 4, "El usuario se ha eliminado con éxito.");
                
                // Se muestra la vista del CRUD.
                support.cardSelection(usManagement.panContainerUser, usManagement.panConsultList);
                    
                // Se cargan los usuarios.
                loadUserTable();
                    
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
       
        // Si se hace click sobre la tabla de empleados.
        if(evt.getSource() == usManagement.tblUserList){
                                              
            // Se obtienen los valores de la fila y columna seleccionada.
            int column = usManagement.getColumnTable(), row = usManagement.getRowTable();

            // Se valida que el evento del Mouse fue provocado dentro del JTable.
            if(row < usManagement.tblUserList.getRowCount() && row >= 0 && 
                    column < usManagement.tblUserList.getColumnCount() && column >= 0){
                
                // Se obtiene el valor de la celda seleccionada.
                Object value = usManagement.tblUserList.getValueAt(row, column);
                
                // Si el valor de la celda seleccionada es un JButton;
                if(value instanceof JButton){
                    
                    ((JButton)value).doClick();
                    
                    JButton btn = (JButton) value;

                    //<editor-fold defaultstate="collapsed" desc=" Proceso para consultar un usuario ">
                    
                    // Si el JButton se llama "s";
                    if(btn.getName().equals("s")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                                      
                        // Se obtiene el modelo de la JTable.
                        DefaultTableModel dtm = (DefaultTableModel) usManagement.tblUserList.getModel();
                                                
                        // Se obtiene el email del usuario en cuestión.
                        String emailUser = dtm.getValueAt(row, 0).toString();
                        
                        // Se buscan los datos del empleado.
                        loadUser(emailUser);
                                       
                        /*// Variables de apoyo para construir el comboBox de sucursales.
                        ArrayList<String>   codexBranch = new ArrayList<>(),
                                            namesBranch = new ArrayList<>();
                        
                        // Se obtienen los datos de las sucursales.
                        loadBranch(codexBranch, namesBranch);
                        
                        // Se llena el combobox de las sucursales.
                        usManagement.cmbBranchUse.removeAllItems();
                        empManagement.cmbBranchEmployee.addItem(" - Seleccionar una Sucursal - ");
                        
                        for(int i = 0; i < codexBranch.size(); i++)
                            empManagement.cmbBranchEmployee.addItem(namesBranch.get(i));*/
                                                    
                        // Se muestra la vista del CRUD.
                        support.cardSelection(usManagement.panContainerUser, usManagement.panCRUD);
                        
                        // Se bloquea el botón de 'eliminar'.
                        usManagement.btnDeleteUser.setEnabled(false);
                        
                        // Se configura el texto del botón.
                        usManagement.btnRegisterModifyUser.setText("Modificar");
                        
                        // Se limpian todos los aspectos visuales.
                        usManagement.clearView();
                                                
                        // Se muestran los datos obtenidos.
                        usManagement.txtEmailUser.setText(email);
                        usManagement.cmbRoleUser.setSelectedItem(role_id);
                        usManagement.txtIdUser.setText(employee_id);
                        usManagement.txtPasswordUser.setText(password);
                        
                        
                        // Se bloquea los campos correo y clave.
                        usManagement.txtEmailUser.setEnabled(false);
                        usManagement.txtPasswordUser.setEnabled(false);
                        
                    }
                    
                    //</editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc=" Proceso para crear un Usuario ">
                    
                    // Si el JButton se llama "i";
                    if(btn.getName().equals("i")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                                     
                        // Se muestra la vista del CRUD.
                        support.cardSelection(usManagement.panContainerUser, usManagement.panCRUD);
                        
                        // Se bloquea el botón de 'eliminar'.
                        usManagement.btnDeleteUser.setEnabled(true);
                        
                        // Se configura el texto del botón.
                        usManagement.btnRegisterModifyUser.setText("Registrar");
                        
                        // Se limpian todos los aspectos visuales.
                        usManagement.clearView();
                        
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
    private void enabledButtons(String rol){
        
        switch(rol){
            
            // Rol: Administrador
            case "ROL-01":
                
                usManagement.btnChangeBranch.setEnabled(true);
                usManagement.lblSucursalName.setText(branchUser);
                
                break;
                
            // Rol: Gerente
            case "ROL-02":
                
                usManagement.btnChangeBranch.setEnabled(false);
                usManagement.lblSucursalName.setText(branchUser);
                
                break;
            
        }
        
    }
    
    /**
     * Método para cargar todas ciudades.
     * @return Listado de nombres de ciudades.
     */
    private void loadUser(String emailUser){
        
        // Se instancia la clase a utilizar.
        usCRUD = new UserCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
                
        try {
            result = usCRUD.readUserData(emailUser);
            while(result.next()){
                email = result.getString("correo");
                nameEmployee= result.getString("Nombre");
                lastNameEmployee= result.getString("Apellido");
                nameRol= result.getString("rol");
                password = result.getString("clave");
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
     * Método para buscar el código de una sucursal.
     * @param branchName Nombre de la sucursal.
     * @return Devuelve el código de la sucursal.
     */
    private String loadBranch(String branchName){
        
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
        
    }
    
    /**
     * Método para cargar todas ciudades.
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
     * Método para construir la sentencia de búsqueda del empleado.
     * @return Sentencia SQL.
     */
    private String buildSentenceSQL(){
        
        // Se declaran e inicializan las variables que servirán para buscar empleados.
        String  initSQL     = "SELECT usuario.\"correo\", empleado.\"nombre\" as \"Nombre\", "
                            + "empleado.\"apellido\" as \"Apellido\", rol.\"nombre\" as \"rol\", "
                            + "usuario.\"clave\" FROM \"usuario\", \"empleado\", \"rol\" "
                            + "WHERE \"empleado_cedula\" = empleado.\"cedula\" AND \"rol_codigo\" = rol.\"codigo\" "
                            + "AND usuario.\"estado\" = 'A' AND empleado.\"estado\" ='A' AND rol.\"estado\" ='A'",
                
                finalSQL    = ";",
                idSQL       = " AND usuario.\"empleado_cedula\" = ",
                rolSQL      = " AND rol.\"nombre\" = ",
                SQL         = "";
         
        // Se inicia la sentencia SQL;
        SQL += initSQL;
        
        // Si se ingresó la cédula de un empleado.
        if(!usManagement.txtSearchIdUser.getText().equals("Cédula del usuario") && 
                !usManagement.txtSearchIdUser.getText().equals(""))
            SQL += idSQL + "'" + usManagement.txtSearchIdUser.getText() + "'";
         
        // Si se ingresó un rol.
        if(usManagement.cmbSearchRoleUser.getSelectedIndex() != 0)
            SQL += rolSQL + "'" + usManagement.cmbSearchRoleUser.getSelectedItem().toString() + "'";
          
        // Se culmina la sentencia.
        return SQL += finalSQL;
        
    }
    
    /**
     * Método para cargar la información de la empresa.
     * @return listado con la información de la empresa.
     */
    private void loadUserTable(){
                
        // Se instancia la clase a utilizar.
        usCRUD = new UserCRUD();
        
        // Se declaran los arreglos a utilizar
        ArrayList<String>   emailUser     = new ArrayList<>(),
                            namesEmployee   = new ArrayList<>(),
                            nameRole  = new ArrayList<>(),
                            passwordUser    = new ArrayList<>();
                
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            
            // Se realiza la búsqueda de empleados.
            result = usCRUD.readUser(buildSentenceSQL());
            
            // Se obtienen los resultados.
            while(result.next()){
                
                emailUser.add(result.getString("codigo"));
                namesEmployee.add(result.getString("Nombre") + " " + result.getString("Apellido"));
                nameRole.add(result.getString("rol"));
                passwordUser.add(result.getString("clave"));
                                   
            }
            
            System.out.println("Carga exitosa. Cantidad de usuarios encontrados: " + emailUser.size());
            
            // Se obtuvo al menos un resultado.
            if(emailUser.size() > 0){
                
                // Se limpia la tabla de Usuarios.
                usManagement.clearUserTable(usManagement.tblUserList);
                
                // Se obtiene el modelo de la tabla de usuarios.
                DefaultTableModel dtm = (DefaultTableModel) usManagement.tblUserList.getModel();

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
                    btnI
                });
                
                // Se añaden todos los resultados obtenidos a la tabla.
                for(int i = 0; i < emailUser.size(); i++){

                    dtm.addRow(new Object[]{
                        emailUser.get(i),
                        namesEmployee.get(i),
                        nameRole.get(i),
                        passwordUser.get(i),
                        btnR
                    });

                }
                                
            }
            
            // No se obtuvo ningún resultado.
            else
                popup = new PopupMessage(usManagement, true, 1, "No se encontraron usuarios.");
                            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }
    
    /**
     * Método para registrar a un nuevo usuario.
     */
    private void registerUserData(){
                        
        // Se carga la nueva información del usuario.
        User us = new User(usManagement.txtEmailUser.getText(), 
                                    usManagement.txtIdUser.getText(), 
                                    usManagement.cmbRoleUser.getSelectedItem().toString(),
                                    usManagement.txtPasswordUser.getText(),  
                                    'A');
        
        // Se ejecuta el registro de datos.
        usCRUD.registerUser(us);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(usManagement, true, 4, 
                "El usuario se ha registrado con éxito");
        
    }
    
    /**
     * Método para actualizar la información de un usuario.
     * @param email correo del usuario a actualizar.
     */
    private void updateUserData(String email){
                        
        // Se carga la nueva información del usuario.
        User us = new User(usManagement.txtEmailUser.getText(), 
                                    usManagement.txtIdUser.getText(), 
                                    usManagement.cmbRoleUser.getSelectedItem().toString(),
                                    usManagement.txtPasswordUser.getText(),  
                                    'A');
        
        // Se ejecuta la actualización de datos.
        usCRUD.UpdateUser(us, email);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(usManagement, true, 4, 
                "Los datos del usuario se han actualizado con éxito.");
        
    }
    
    /**
     * Método para limpiar las variables.
     */
    private void clearVariables(){
        
        email       = "";
        employee_id = "";
        role_id     = "";
        password    = "";
        
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" PROHIBIDO TOCAR ">
    
    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //</editor-fold>
     
     
}

