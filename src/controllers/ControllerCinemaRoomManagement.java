/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

// Se importan las librerías de soporte.
import lib.SupportFunctions;

// Se importan los models a utilizar.
import models.CinemaRoom;
import models.database.CinemaRoomCRUD;
import models.database.BranchCRUD;
import models.database.CityCRUD;

// Se importan las views a utilizar.
import views.CinemaRoomManagement;
import views.ChangeBranch;
import views.PopupMessage;
import views.SelectOption;
import views.tables.Table;

// Se importan las librerías a utilizar.
import java.awt.event.*;
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
 **/

public class ControllerCinemaRoomManagement implements ActionListener, MouseListener{
    
    //<editor-fold defaultstate="collapsed" desc=" Declaración de variables ">
    
    // Models
    private CinemaRoom ciRoom;
    // Models.database
    private CinemaRoomCRUD ciRoomCRUD;
    private BranchCRUD braCRUD;
    private CityCRUD citCRUD;
    
    // Views
    private CinemaRoomManagement ciRoomManagement;
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
    
    // Variables para CRUD del empleado.
    private String  id,
                    branch;
    
    private int   fila,
                  column;
    
                    
    
    //</editor-fold>
    
    /**
     * Constructor del gestor de sala.
     * @param rolUser Rol del usuario que ha ingresado al sistema.
     * @param nameUser Nombre del usuario que ha ingresado al sistema.
     * @param branchUser Nombre de la sucursal del usuario que ha ingresado al sistema.
     */
    
    public ControllerCinemaRoomManagement(String rolUser, String nameUser, String branchUser){
        
        // Declarar la variable de las clases instanciadas.
        ciRoomManagement   = new CinemaRoomManagement();
        support         = new SupportFunctions();
        
        // Se inicializan las variables.
        this.rolUser    = rolUser;
        this.nameUser   = nameUser;
        this.branchUser = branchUser;
        
        // Se muestra la primera pantalla.
        support.cardSelection(ciRoomManagement .panContainerCinemaRoom, ciRoomManagement .panConsultList);
        ciRoomManagement.lblSucursalName.setText(branchUser);
        // Se cargan las salas.
        loadCinemaRoomTable();
        
        // Se habilitan o deshabilitan los botónes según tipo de usuario.
        enabledButtons(this.rolUser);
        
        // Se inicializan las variables.
        clearVariables();
        
        // Activamos los eventos por las views.
        ciRoomManagement.addEvents(this);
        ciRoomManagement.addMouseEvents(this);
        
        }
    
    /**
     * Método que determina las acciones a realizar por la aplicación según el 
     * botón presionado.
     * @param evt indica los eventos posibles a ocurrir (click en botónes).
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        
        //<editor-fold defaultstate="collapsed" desc=" Botones de la Barra Superior ">
        
        // Minimizar aplicación.
        if(evt.getSource() == ciRoomManagement.btnMin){
            ciRoomManagement.setExtendedState(java.awt.Frame.ICONIFIED);
            ciRoomManagement.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir de la aplicación.
        else if(evt.getSource() == ciRoomManagement.btnExit){
            ciRoomManagement.dispose();
        } 
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Branch Change ">
        
        // Cambiar de sucursal a gestionar
        else if(evt.getSource() == ciRoomManagement.btnChangeBranch){
            
            ArrayList<String>   cityNames   = loadCityNames(),
                                cityBranch  = new ArrayList<>(),
                                branchNames = new ArrayList<>();
            
            loadBranch(cityBranch, branchNames);
                        
            // Instanciar la clase
            changeBranch = new ChangeBranch(ciRoomManagement, true, cityNames, cityBranch, branchNames, rolUser);
            
            // Se ubica el nombre de la sucursal.
            ciRoomManagement.lblSucursalName.setText(changeBranch.getId_Sucursal());
                        
            changeBranch.dispose();
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Employee Search ">
        
        // Buscar a una sala.
        else if(evt.getSource() == ciRoomManagement.btnSearchCinemaRoom){
            
            // Si no se ingresó información para filtrar.
            if  ((ciRoomManagement.txtSearchIdCinemaRoom.getText().equals("") || 
                    ciRoomManagement.txtSearchIdCinemaRoom.getText().equals("Codigo de la sala")))
                    popup = new PopupMessage(ciRoomManagement, true, 1, "Debe ingresar al menos un dato para filtrar.");
            
            // Si al menos se ingresó algún dato para filtrar.
            else
                loadCinemaRoomTable();
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" CinemaRoom Table Clear ">
        
        // Limpiar el consultar listado.
        else if(evt.getSource() == ciRoomManagement.btnClearSearchCinemaRoom){
            
            ciRoomManagement.clearCinemaRoomSearch();
            
            loadCinemaRoomTable();
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Back to Consult List ">
        
        // Para volver a la view de consulta.
        else if(evt.getSource() == ciRoomManagement.btnBackCinemaRoom){
            
            // Se validan si todos los campos estan vacios.
            if(!ciRoomManagement.txtIdCinemaRoom.getText().equals("Codigo de la sala")&& 
                    !ciRoomManagement.txtIdCinemaRoom.getText().equals("")&&
                    !ciRoomManagement.txtFilaCinemaRoom.getText().equals("Numero de filas") &&
                    !ciRoomManagement.txtFilaCinemaRoom.getText().equals("") &&
                    !ciRoomManagement.txtColumnCinemaRoom.getText().equals("Numero de Columnas") &&
                    !ciRoomManagement.txtColumnCinemaRoom.getText().equals("") &&
                    ciRoomManagement.cmbBranchCinemaRoom.getSelectedIndex() != 0){
                
                // Se pregunta al usuario si desea abandonar la consulta.
                SelectOption select = new SelectOption(ciRoomManagement, true, 1, 
                        "¿Está seguro que desea abandonar la consulta?", "Si", "No");
                
                // Si la respuesta es afirmativa.
                if(select.getOpc()){
                    
                    // Se muestra la vista del CRUD.
                    support.cardSelection(ciRoomManagement.panContainerCinemaRoom, ciRoomManagement.panConsultList);
                    
                    // Se cargan las Salas.
                    loadCinemaRoomTable();
                    
                    // Se inicializan las variables.
                    clearVariables();
                                        
                }    
                   
            }
            
            // Si no hay campos modificados.
            else{
                
                // Se muestra la vista del CRUD.
                support.cardSelection(ciRoomManagement.panContainerCinemaRoom, ciRoomManagement.panConsultList);
                    
                // Se cargan los empleados.
                loadCinemaRoomTable();
                
                // Se inicializan las variables.
                clearVariables();
                
            }
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Clear form ">
        
        // Si se desea limpiar una sala.
        else if(evt.getSource() == ciRoomManagement.btnClearCinemaRoom){
            
            if(id.equals(""))
                ciRoomManagement.clearView();
            else{
                
                // Se muestran los datos obtenidos.
                ciRoomManagement.txtIdCinemaRoom.setText(id);
                ciRoomManagement.cmbBranchCinemaRoom.setSelectedItem(branch);
                ciRoomManagement.txtFilaCinemaRoom.setText(Integer.toString(fila));
                ciRoomManagement.txtColumnCinemaRoom.setText(Integer.toString(column));
                
            }
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Register or Update CinemaRoom ">
        
        // Registro o Modificación de salas.
        else if(evt.getSource() == ciRoomManagement.btnRegisterModifyCinemaRoom){
            
            /**
             * Si la variable global 'id' se encuentra vacía, se tiene que el caso
             * es un registro.
             */
            if(id.equals("")){
                
                
                // De no haber campos vacíos.
                if( !ciRoomManagement.txtIdCinemaRoom.getText().equals("Codigo de la sala")&& 
                    !ciRoomManagement.txtIdCinemaRoom.getText().equals("")&&
                    !ciRoomManagement.txtFilaCinemaRoom.getText().equals("Numero de filas") &&
                    !ciRoomManagement.txtFilaCinemaRoom.getText().equals("") &&
                    !ciRoomManagement.txtColumnCinemaRoom.getText().equals("Numero de Columnas") &&
                    !ciRoomManagement.txtColumnCinemaRoom.getText().equals("") &&
                    ciRoomManagement.cmbBranchCinemaRoom.getSelectedIndex() != 0){
                
                        // Se confirma que se desea eliminar el registro.
                        SelectOption select = new SelectOption(ciRoomManagement, true, 2, 
                                "¿Desea registrar a este empleado?", "Si", "No");

                        // Si se confirma el registro.
                        if(select.getOpc()){

                            // Si la sala ya existe pero se encuentra inactivo.
                            if(ciRoomCRUD.CinemaRoomExist(ciRoomManagement.txtIdCinemaRoom.getText(), 'I')){
                                
                                // Se cambia el estado de la sala a activa.
                                ciRoomCRUD.DeleteCinemaRoom(ciRoomManagement.txtIdCinemaRoom.getText(), 1);
                                
                                // Se actualiza la información de la sala.
                                updateCinemaRoomData(ciRoomManagement.txtIdCinemaRoom.getText());
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(ciRoomManagement.panContainerCinemaRoom, ciRoomManagement.panConsultList);

                                // Se cargan las salas.
                                loadCinemaRoomTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                            }
                            
                            // Si la sala no existe.
                            else{
                            
                                // Se ejecuta el registro de información.
                                registerCinemaRoomData();
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(ciRoomManagement.panContainerCinemaRoom, ciRoomManagement.panConsultList);

                                // Se cargan las salas.
                                loadCinemaRoomTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                            }
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(ciRoomManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
      
                
            }
            
            /**
             * Si la variable global 'id' posee algún dato, se tiene el caso de modificación
             * de un registro.
             */
            else{
                
                // De no haber campos vacíos.
                if( !ciRoomManagement.txtIdCinemaRoom.getText().equals("Codigo de la sala")&& 
                    !ciRoomManagement.txtIdCinemaRoom.getText().equals("")&&
                    !ciRoomManagement.txtFilaCinemaRoom.getText().equals("Numero de filas") &&
                    !ciRoomManagement.txtFilaCinemaRoom.getText().equals("") &&
                    !ciRoomManagement.txtColumnCinemaRoom.getText().equals("Numero de Columnas") &&
                    !ciRoomManagement.txtColumnCinemaRoom.getText().equals("") &&
                    ciRoomManagement.cmbBranchCinemaRoom.getSelectedIndex() != 0){
                
                        // Se confirma que se desea eliminar el registro.
                        SelectOption select = new SelectOption(ciRoomManagement, true, 2, 
                                "¿Desea actualizar los datos de esta sala?", "Si", "No");

                        // Si se confirma la actualización.
                        if(select.getOpc()){

                            // Se ejecuta la actualización de información.
                            updateCinemaRoomData(id);
                            
                            // Se muestra la vista del CRUD.
                            support.cardSelection(ciRoomManagement.panContainerCinemaRoom, ciRoomManagement.panConsultList);

                            // Se cargan las salas.
                            loadCinemaRoomTable();

                            // Se inicializan las variables.
                            clearVariables();
                            
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(ciRoomManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
                                    
            }
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Delete Employee ">
        
        // Eliminación de una sala.
        else if(evt.getSource() == ciRoomManagement.btnDeleteCinemaRoom){
            
            // Se pregunta al usuario si desea realmente eliminar la sala.
            SelectOption select = new SelectOption(ciRoomManagement, true, 2, 
                    "¿Está seguro que desea eliminar a esta sala?", "Si", "No");
            
            // Si la respuesta es afirmativa.
            if(select.getOpc()){
                
                // Se realiza la eliminación lógica.
                ciRoomCRUD.DeleteCinemaRoom(id, 0);
                
                // Se muestra un mensaje de eliminación exitosa.
                popup = new PopupMessage(ciRoomManagement, true, 4, "La sala se ha eliminado con éxito.");
                
                // Se muestra la vista del CRUD.
                support.cardSelection(ciRoomManagement.panContainerCinemaRoom, ciRoomManagement.panConsultList);
                    
                // Se cargan las salas.
                loadCinemaRoomTable();
                    
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
       
        // Si se hace click sobre la tabla de salas.
        if(evt.getSource() == ciRoomManagement.tblCinemaRoomList){
                                              
            // Se obtienen los valores de la fila y columna seleccionada.
            int column = ciRoomManagement.getColumnTable(), row = ciRoomManagement.getRowTable();

            // Se valida que el evento del Mouse fue provocado dentro del JTable.
            if(row < ciRoomManagement.tblCinemaRoomList.getRowCount() && row >= 0 && 
                    column < ciRoomManagement.tblCinemaRoomList.getColumnCount() && column >= 0){
                
                // Se obtiene el valor de la celda seleccionada.
                Object value = ciRoomManagement.tblCinemaRoomList.getValueAt(row, column);
                
                // Si el valor de la celda seleccionada es un JButton;
                if(value instanceof JButton){
                    
                    ((JButton)value).doClick();
                    
                    JButton btn = (JButton) value;

                    //<editor-fold defaultstate="collapsed" desc=" Proceso para consultar una sala ">
                    
                    // Si el JButton se llama "s";
                    if(btn.getName().equals("s")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                                      
                        // Se obtiene el modelo de la JTable.
                        DefaultTableModel dtm = (DefaultTableModel) ciRoomManagement.tblCinemaRoomList.getModel();
                                                
                        // Se obtiene el id de la sala en cuestión.
                        String idCinemaRoom = dtm.getValueAt(row, 0).toString();
                        
                        // Se buscan los datos de la sala.
                        loadCinemaRoom(idCinemaRoom);
                                       
                        // Variables de apoyo para construir el comboBox de sucursales.
                        ArrayList<String>   codexBranch = new ArrayList<>(),
                                            namesBranch = new ArrayList<>();
                        
                        // Se obtienen los datos de las sucursales.
                        loadBranch(codexBranch, namesBranch);
                        
                        // Se llena el combobox de las sucursales.
                        ciRoomManagement.cmbBranchCinemaRoom.removeAllItems();
                        ciRoomManagement.cmbBranchCinemaRoom.addItem(" - Seleccionar una Sucursal - ");
                        
                        for(int i = 0; i < codexBranch.size(); i++)
                            ciRoomManagement.cmbBranchCinemaRoom.addItem(namesBranch.get(i));
                                                    
                        // Se muestra la vista del CRUD.
                        support.cardSelection(ciRoomManagement.panContainerCinemaRoom, ciRoomManagement.panCRUD);
                        
                        // Se bloquea el botón de 'eliminar'.
                        ciRoomManagement.btnDeleteCinemaRoom.setEnabled(false);
                        
                        // Se configura el texto del botón.
                        ciRoomManagement.btnRegisterModifyCinemaRoom.setText("Modificar");
                        
                        // Se limpian todos los aspectos visuales.
                        ciRoomManagement.clearView();
                                                
                        // Se muestran los datos obtenidos.
                        ciRoomManagement.txtIdCinemaRoom.setText(id);
                        ciRoomManagement.cmbBranchCinemaRoom.setSelectedItem(branch);
                        ciRoomManagement.txtFilaCinemaRoom.setText(String.valueOf(fila));
                        ciRoomManagement.txtColumnCinemaRoom.setText(String.valueOf(column));
                        
                        // Se bloquea el campo del codigo.
                        ciRoomManagement.txtIdCinemaRoom.setEnabled(false);
                        
                    }
                    
                    //</editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc=" Proceso para registrar una sala ">
                    
                    // Si el JButton se llama "i";
                    if(btn.getName().equals("i")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                                     
                        // Se muestra la vista del CRUD.
                        support.cardSelection(ciRoomManagement.panContainerCinemaRoom, ciRoomManagement.panCRUD);
                        
                        // Se bloquea el botón de 'eliminar'.
                        ciRoomManagement.btnDeleteCinemaRoom.setEnabled(true);
                        
                        // Se configura el texto del botón.
                        ciRoomManagement.btnRegisterModifyCinemaRoom.setText("Registrar");
                        
                                                // Variables de apoyo para construir el comboBox de sucursales.
                        ArrayList<String>   codexBranch = new ArrayList<>(),
                                            namesBranch = new ArrayList<>();
                        
                        // Se obtienen los datos de las sucursales.
                        loadBranch(codexBranch, namesBranch);
                        
                        // Se llena el combobox de las sucursales.
                        ciRoomManagement.cmbBranchCinemaRoom.removeAllItems();
                        ciRoomManagement.cmbBranchCinemaRoom.addItem(" - Seleccionar una Sucursal - ");
                        
                        for(int i = 0; i < codexBranch.size(); i++)
                            ciRoomManagement.cmbBranchCinemaRoom.addItem(namesBranch.get(i));
                        
                        // Se limpian todos los aspectos visuales.
                        ciRoomManagement.clearView();
                        ciRoomManagement.txtIdCinemaRoom.setEnabled(true);
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
                
                ciRoomManagement.btnChangeBranch.setEnabled(true);
                ciRoomManagement.lblSucursalName.setText(branchUser);
                
                break;
                
            // Rol: Gerente
            case "ROL-02":
                
                ciRoomManagement.btnChangeBranch.setEnabled(false);
                ciRoomManagement.lblSucursalName.setText(branchUser);
                
                break;
            
        }
        
    }
    
    /**
     * Método para cargar todas ciudades.
     * @return Listado de nombres de ciudades.
     */
    private void loadCinemaRoom(String idCinemaRoom){
        
        // Se instancia la clase a utilizar.
        ciRoomCRUD = new CinemaRoomCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
                
        try {
            result = ciRoomCRUD.readCinemaRoomData(idCinemaRoom);
            while(result.next()){
                id = result.getString("codigo");
                branch = result.getString("NombreSucursal");
                fila = result.getInt("fila");
                column = result.getInt("columna");
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
     * Método para construir la sentencia de búsqueda de la sala.
     * @return Sentencia SQL.
     */
    private String buildSentenceSQL(){
        
        // Se declaran e inicializan las variables que servirán para buscar salas.
        String  initSQL     = "SELECT sala.\"codigo\", sucursal.\"nombre\" as \"nombreSucursal\", "
                            + "sala.\"fila\", sala.\"columna\" FROM \"sala\", \"sucursal\" "
                            + "WHERE \"sucursal_codigo\" = sucursal.\"codigo\" AND sala.\"estado\" = 'A' "
                            + "AND sucursal.\"estado\" = 'A'",
                
                finalSQL    = ";",
                idSQL     = " AND sala.\"codigo\" = ",
                nameBranchSQL   = " AND sucursal.\"nombre\" = ",
                SQL         = "";
         
        // Se inicia la sentencia SQL;
        SQL += initSQL;
        
        // Si se ingresó el codigo de una sala.
        if(!ciRoomManagement.txtSearchIdCinemaRoom.getText().equals("Codigo de la sala") && 
                !ciRoomManagement.txtSearchIdCinemaRoom.getText().equals(""))
            SQL += idSQL + "'" + ciRoomManagement.txtSearchIdCinemaRoom.getText() + "'";
                
        
        
        if(!ciRoomManagement.lblSucursalName.getText().equals("") &&
                !ciRoomManagement.lblSucursalName.getText().equals("Sucursal ") &&
                !ciRoomManagement.lblSucursalName.getText().equals(" - Seleccione - ") &&
                !ciRoomManagement.lblSucursalName.getText().equals("Cines de Venezuela") && 
                !ciRoomManagement.lblSucursalName.getText().equals(" Administrador "))
            SQL += nameBranchSQL + "'" + ciRoomManagement.lblSucursalName.getText() + "'";
         
          
        // Se culmina la sentencia.
        return SQL += finalSQL;
        
    }
    
    /**
     * Método para cargar la información de las salas.
     * @return listado con la información de las salas.
     */
    private void loadCinemaRoomTable(){
                
        // Se instancia la clase a utilizar.
        ciRoomCRUD = new CinemaRoomCRUD();
        
        // Se declaran los arreglos a utilizar
        ArrayList<String>   idCinemaRoom     = new ArrayList<>(),
                            branchCinemaRoom  = new ArrayList<>();
        ArrayList<Integer>  fila    = new ArrayList<>(),
                            column   = new ArrayList<>();
                
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            
            // Se realiza la búsqueda de salas.
            result = ciRoomCRUD.readCinemaRoom(buildSentenceSQL());
            
            // Se obtienen los resultados.
            while(result.next()){
                
                idCinemaRoom.add(result.getString("codigo"));
                branchCinemaRoom.add(result.getString("nombreSucursal"));
                fila.add(result.getInt("fila"));
                column.add(result.getInt("columna"));
                                   
            }
            
            System.out.println("Carga exitosa. Cantidad de empleados encontrados: " + idCinemaRoom.size());
            
            // Se obtuvo al menos un resultado.
            if(idCinemaRoom.size() > 0){
                
                // Se limpia la tabla de salas.
                ciRoomManagement.clearCinemaRoomTable(ciRoomManagement.tblCinemaRoomList);
                
                // Se obtiene el modelo de la tabla de salas.
                DefaultTableModel dtm = (DefaultTableModel) ciRoomManagement.tblCinemaRoomList.getModel();

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
                for(int i = 0; i < idCinemaRoom.size(); i++){

                    dtm.addRow(new Object[]{
                        idCinemaRoom.get(i),
                        branchCinemaRoom.get(i),
                        fila.get(i),
                        column.get(i),
                        btnR
                    });

                }
                                
            }
            
            // No se obtuvo ningún resultado.
            else
                popup = new PopupMessage(ciRoomManagement, true, 1, "No se encontraron salas registradas.");
                            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }
    
    /**
     * Método para registrar a una nueva sala.
     */
    private void registerCinemaRoomData(){
                        
        // Se carga la nueva información de la sala.
        CinemaRoom ciRoom= new CinemaRoom(ciRoomManagement.txtIdCinemaRoom.getText(), 
                                    loadBranch(ciRoomManagement.cmbBranchCinemaRoom.getSelectedItem().toString()), 
                                    Integer.valueOf(ciRoomManagement.txtFilaCinemaRoom.getText()),
                                    Integer.valueOf(ciRoomManagement.txtColumnCinemaRoom.getText()),
                                    'A');
        
        // Se ejecuta el registro de datos.
        ciRoomCRUD.registerCinemaRoom(ciRoom);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(ciRoomManagement, true, 4, 
                "La sala se ha registrado con éxito");
        
    }
    
    /**
     * Método para actualizar la información de una sala.
     * @param id codigo se la sala a actualizar.
     */
    private void updateCinemaRoomData(String id){
                        
        // Se carga la nueva información de la sala.
        CinemaRoom ciRoom= new CinemaRoom(ciRoomManagement.txtIdCinemaRoom.getText(), 
                                    loadBranch(ciRoomManagement.cmbBranchCinemaRoom.getSelectedItem().toString()), 
                                    Integer.valueOf(ciRoomManagement.txtFilaCinemaRoom.getText()),
                                    Integer.valueOf(ciRoomManagement.txtColumnCinemaRoom.getText()),
                                    'A');
        
        
        // Se ejecuta la actualización de datos.
        ciRoomCRUD.UpdateCinemaRoom(ciRoom, id);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(ciRoomManagement, true, 4, 
                "Los datos de la sala se han actualizado con éxito.");
        
    }
    
    /**
     * Método para limpiar las variables.
     */
    private void clearVariables(){
        
        id          = "";
        branch      = "";
        fila       = 0;
        column       = 0;
        
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
