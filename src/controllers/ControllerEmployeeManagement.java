
package controllers;

// Se importan las librerías de soporte.
import lib.SupportFunctions;

// Se importan los models a utilizar.
import models.Employee;
import models.database.EmployeeCRUD;
import models.database.BranchCRUD;
import models.database.CityCRUD;

// Se importan las views a utilizar.
import views.EmployeeManagement;
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
public class ControllerEmployeeManagement implements ActionListener, MouseListener{
    
    //<editor-fold defaultstate="collapsed" desc=" Declaración de variables ">
    
    // Models
    private Employee employee;
        // Models.database
        private EmployeeCRUD empCRUD;
        private BranchCRUD braCRUD;
        private CityCRUD citCRUD;
    
    // Views
    private EmployeeManagement empManagement;
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
                    branch,
                    name,
                    lastName,
                    direction,
                    email,
                    job;
    
    private long    phone;
    
    private Date    birth,
                    entrance;
                    
    
    //</editor-fold>
    
    /**
     * Constructor del gestor de empleados.
     * @param rolUser Rol del usuario que ha ingresado al sistema.
     * @param nameUser Nombre del usuario que ha ingresado al sistema.
     * @param branchUser Nombre de la sucursal del usuario que ha ingresado al sistema.
     */
    public ControllerEmployeeManagement(String rolUser, String nameUser, String branchUser){
        
        // Declarar la variable de las clases instanciadas.
        empManagement   = new EmployeeManagement();
        support         = new SupportFunctions();
        
        // Se inicializan las variables.
        this.rolUser    = rolUser;
        this.nameUser   = nameUser;
        this.branchUser = branchUser;
        
        // Se muestra la primera pantalla.
        support.cardSelection(empManagement.panContainerEmployee, empManagement.panConsultList);
        empManagement.lblSucursalName.setText(branchUser);
        // Se cargan los empleados.
        loadEmployeeTable();
        
        // Se habilitan o deshabilitan los botónes según tipo de usuario.
        enabledButtons(this.rolUser);
        
        // Se inicializan las variables.
        clearVariables();
        
        // Activamos los eventos por las views.
        empManagement.addEvents(this);
        empManagement.addMouseEvents(this);
        
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
        if(evt.getSource() == empManagement.btnMin){
            empManagement.setExtendedState(java.awt.Frame.ICONIFIED);
            empManagement.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir de la aplicación.
        else if(evt.getSource() == empManagement.btnExit){
            empManagement.dispose();
        } 
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Branch Change ">
        
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
            loadEmployeeTable();

            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Employee Search ">
        
        // Buscar a un empleado.
        else if(evt.getSource() == empManagement.btnSearchEmployee){
            
            // Si no se ingresó información para filtrar.
            if  ((empManagement.txtSearchIdEmployee.getText().equals("") || 
                    empManagement.txtSearchIdEmployee.getText().equals("Cédula del empleado")) &&
                (empManagement.txtSearchNameEmployee.getText().equals("") ||
                    empManagement.txtSearchNameEmployee.getText().equals("Nombre y apellido del empleado")) &&
                (empManagement.cmbSearchJobEmployee.getSelectedIndex() == 0))
                    popup = new PopupMessage(empManagement, true, 1, "Debe ingresar al menos un dato para filtrar.");
            
            // Si al menos se ingresó algún dato para filtrar.
            else
                loadEmployeeTable();
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Employee Table Clear ">
        
        // Limpiar el consultar listado.
        else if(evt.getSource() == empManagement.btnClearSearchEmployee){
            
            empManagement.clearEmployeeSearch();
            //se carga actualización
            loadEmployeeTable();
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Back to Consult List ">
        
        // Para volver a la view de consulta.
        else if(evt.getSource() == empManagement.btnBackEmployee){
            
            // Se validan todos los campos.
            if(!empManagement.txtIdEmployee.getText().equals("Cédula del empleado") && 
                    !empManagement.txtIdEmployee.getText().equals("") &&
                    !empManagement.txtNameEmployee.getText().equals("Nombre del empleado") &&
                    !empManagement.txtNameEmployee.getText().equals("") &&
                    !empManagement.txtLastNameEmployee.getText().equals("Apellido del empleado") &&
                    !empManagement.txtLastNameEmployee.getText().equals("") &&
                    !empManagement.txtPhoneEmployee.getText().equals("Teléfono del empleado") &&
                    !empManagement.txtPhoneEmployee.getText().equals("") &&
                    !empManagement.txtDirectionEmployee.getText().equals("Dirección del empleado") &&
                    !empManagement.txtDirectionEmployee.getText().equals("") &&
                    !empManagement.txtEmailEmployee.getText().equals("Correo electrónico del empleado") &&
                    !empManagement.txtEmailEmployee.getText().equals("") &&
                    empManagement.cmbBranchEmployee.getSelectedIndex() != 0 &&
                    empManagement.cmbJobEmployee.getSelectedIndex() != 0){
                
                // Se pregunta al usuario si desea abandonar la consulta.
                SelectOption select = new SelectOption(empManagement, true, 1, 
                        "¿Está seguro que desea abandonar la consulta?", "Si", "No");
                
                // Si la respuesta es afirmativa.
                if(select.getOpc()){
                    
                    // Se muestra la vista del CRUD.
                    support.cardSelection(empManagement.panContainerEmployee, empManagement.panConsultList);
                    
                    // Se cargan los empleados.
                    //loadEmployeeTable();
                    
                    // Se inicializan las variables.
                    clearVariables();
                                        
                }    
                   
            }
            
            // Si no hay campos modificados.
            else{
                
                // Se muestra la vista del CRUD.
                support.cardSelection(empManagement.panContainerEmployee, empManagement.panConsultList);
                    
                // Se cargan los empleados.
                //loadEmployeeTable();
                
                // Se inicializan las variables.
                clearVariables();
                
            }
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Clear form ">
        
        // Si se desea limpiar un empleado.
        else if(evt.getSource() == empManagement.btnClearEmployee){
            
            if(id.equals(""))
                empManagement.clearView();
            else{
                
                // Se muestran los datos obtenidos.
                empManagement.txtIdEmployee.setText(id);
                empManagement.cmbBranchEmployee.setSelectedItem(branch);
                empManagement.txtNameEmployee.setText(name);
                empManagement.txtLastNameEmployee.setText(lastName);
                empManagement.txtPhoneEmployee.setText(String.valueOf(phone));
                empManagement.txtDirectionEmployee.setText(direction);
                empManagement.dchBirthEmployee.setDate(birth);
                empManagement.dchEntranceDateEmployee.setDate(entrance);
                empManagement.txtEmailEmployee.setText(email);
                empManagement.cmbJobEmployee.setSelectedItem(job);
                
            }
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Register or Update Employee ">
        
        // Registro o Modificación de empleado.
        else if(evt.getSource() == empManagement.btnRegisterModifyEmployee){
            
            /**
             * Si la variable global 'id' se encuentra vacía, se tiene que el caso
             * es un registro.
             */
            if(id.equals("")){
                
                
                // De no haber campos vacíos.
                if( !empManagement.txtIdEmployee.getText().equals("") && 
                    !empManagement.txtIdEmployee.getText().equals("Cédula del empleado") && 
                    !empManagement.txtNameEmployee.getText().equals("") &&
                    !empManagement.txtNameEmployee.getText().equals("Nombre del empleado") &&
                    !empManagement.txtLastNameEmployee.getText().equals("") &&
                    !empManagement.txtLastNameEmployee.getText().equals("Apellido del empleado") &&
                    !empManagement.txtPhoneEmployee.getText().equals("") &&
                    !empManagement.txtPhoneEmployee.getText().equals("Teléfono del empleado") &&
                     empManagement.txtPhoneEmployee.getText().length() <= 10 &&
                    !empManagement.txtDirectionEmployee.getText().equals("") &&
                    !empManagement.txtDirectionEmployee.getText().equals("Dirección del empleado") &&
                     empManagement.cmbBranchEmployee.getSelectedIndex() != 0 && 
                     empManagement.cmbJobEmployee.getSelectedIndex() != 0){
                
                        // Se confirma que se desea registrar el empleado.
                        SelectOption select = new SelectOption(empManagement, true, 2, 
                                "¿Desea registrar a este empleado?", "Si", "No");

                        // Si se confirma el registro.
                        if(select.getOpc()){

                            // Si el empleado ya existe pero se encuentra inactivo.
                            if(empCRUD.employeeExist(empManagement.txtIdEmployee.getText(), 'I')){
                                
                                // Se cambia el estado del empleado a activo.
                                empCRUD.DeleteEmployee(empManagement.txtIdEmployee.getText(), 1);
                                
                                // Se actualiza la información del empleado.
                                updateEmployeeData(empManagement.txtIdEmployee.getText());
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(empManagement.panContainerEmployee, empManagement.panConsultList);

                                // Se cargan los empleados.
                                //loadEmployeeTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                            }
                            
                            // Si el usuario no existe.
                            else{
                            
                                // Se ejecuta el registro de información.
                                registerEmployeeData();
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(empManagement.panContainerEmployee, empManagement.panConsultList);

                                // Se cargan los empleados.
                                loadEmployeeTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                            }
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(empManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
      
                
            }
            
            /**
             * Si la variable global 'id' posee algún dato, se tiene el caso de modificación
             * de un registro.
             */
            else{
                
                // De no haber campos vacíos.
                if( !empManagement.txtIdEmployee.getText().equals("") && 
                    !empManagement.txtIdEmployee.getText().equals("Cédula del empleado") && 
                    !empManagement.txtNameEmployee.getText().equals("") &&
                    !empManagement.txtNameEmployee.getText().equals("Nombre del empleado") &&
                    !empManagement.txtLastNameEmployee.getText().equals("") &&
                    !empManagement.txtLastNameEmployee.getText().equals("Apellido del empleado") &&
                    !empManagement.txtPhoneEmployee.getText().equals("") &&
                    !empManagement.txtPhoneEmployee.getText().equals("Teléfono del empleado") &&
                     empManagement.txtPhoneEmployee.getText().length() <= 10 &&
                    !empManagement.txtDirectionEmployee.getText().equals("") &&
                    !empManagement.txtDirectionEmployee.getText().equals("Dirección del empleado") &&
                     empManagement.cmbBranchEmployee.getSelectedIndex() != 0 && 
                     empManagement.cmbJobEmployee.getSelectedIndex() != 0){
                
                        // Se confirma que se desea eliminar el registro.
                        SelectOption select = new SelectOption(empManagement, true, 2, 
                                "¿Desea actualizar los datos de este empleado?", "Si", "No");

                        // Si se confirma la actualización.
                        if(select.getOpc()){

                            // Se ejecuta la actualización de información.
                            updateEmployeeData(id);
                            
                            // Se muestra la vista del CRUD.
                            support.cardSelection(empManagement.panContainerEmployee, empManagement.panConsultList);

                            // Se cargan los empleados.
                            loadEmployeeTable();

                            // Se inicializan las variables.
                            clearVariables();
                            
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(empManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
                                    
            }
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Delete Employee ">
        
        // Eliminación de un empleado.
        else if(evt.getSource() == empManagement.btnDeleteEmployee){
            
            // Se pregunta al usuario si desea realmente eliminar al empleado.
            SelectOption select = new SelectOption(empManagement, true, 2, 
                    "¿Está seguro que desea eliminar a este empleado?", "Si", "No");
            
            // Si la respuesta es afirmativa.
            if(select.getOpc()){
                
                // Se realiza la eliminación lógica.
                empCRUD.DeleteEmployee(id, 0);
                
                // Se muestra un mensaje de eliminación exitosa.
                popup = new PopupMessage(empManagement, true, 4, "El empleado se ha eliminado con éxito.");
                
                // Se muestra la vista del CRUD.
                support.cardSelection(empManagement.panContainerEmployee, empManagement.panConsultList);
                    
                // Se cargan los empleados.
                clearEmployeetable();
                //loadEmployeeTable();
                    
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
        if(evt.getSource() == empManagement.tblEmployeeList){
                                              
            // Se obtienen los valores de la fila y columna seleccionada.
            int column = empManagement.getColumnTable(), row = empManagement.getRowTable();

            // Se valida que el evento del Mouse fue provocado dentro del JTable.
            if(row < empManagement.tblEmployeeList.getRowCount() && row >= 0 && 
                    column < empManagement.tblEmployeeList.getColumnCount() && column >= 0){
                
                // Se obtiene el valor de la celda seleccionada.
                Object value = empManagement.tblEmployeeList.getValueAt(row, column);
                
                // Si el valor de la celda seleccionada es un JButton;
                if(value instanceof JButton){
                    
                    ((JButton)value).doClick();
                    
                    JButton btn = (JButton) value;

                    //<editor-fold defaultstate="collapsed" desc=" Proceso para consultar un empleado ">
                    
                    // Si el JButton se llama "s";
                    if(btn.getName().equals("s")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                                      
                        // Se obtiene el modelo de la JTable.
                        DefaultTableModel dtm = (DefaultTableModel) empManagement.tblEmployeeList.getModel();
                                                
                        // Se obtiene el id del empleado en cuestión.
                        String idEmployee = dtm.getValueAt(row, 0).toString();
                        
                        // Se buscan los datos del empleado.
                        loadEmployee(idEmployee);
                        
                        // Se crea la variable de formato de fechas.
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
                            empManagement.cmbBranchEmployee.addItem(namesBranch.get(i));
                                                    
                        // Se muestra la vista del CRUD.
                        support.cardSelection(empManagement.panContainerEmployee, empManagement.panCRUD);
                        
                        // Se activa el botón de 'eliminar'.
                        empManagement.btnDeleteEmployee.setEnabled(true);
                        
                        // Se configura el texto del botón.
                        empManagement.btnRegisterModifyEmployee.setText("Modificar");
                        
                        // Se limpian todos los aspectos visuales.
                        empManagement.clearView();
                                                
                        // Se muestran los datos obtenidos.
                        empManagement.txtIdEmployee.setText(id);
                        empManagement.cmbBranchEmployee.setSelectedItem(branch);
                        empManagement.txtNameEmployee.setText(name);
                        empManagement.txtLastNameEmployee.setText(lastName);
                        empManagement.txtPhoneEmployee.setText(String.valueOf(phone));
                        empManagement.txtDirectionEmployee.setText(direction);
                        empManagement.dchBirthEmployee.setDate(birth);
                        empManagement.dchEntranceDateEmployee.setDate(entrance);
                        empManagement.txtEmailEmployee.setText(email);
                        empManagement.cmbJobEmployee.setSelectedItem(job);
                        
                        // Se bloquea el campo de cédula.
                        empManagement.txtIdEmployee.setEnabled(false);
                        
                    }
                    
                    //</editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc=" Proceso para crear un empleado ">
                    
                    // Si el JButton se llama "i";
                    if(btn.getName().equals("i")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                                     
                        // Se muestra la vista del CRUD.
                        support.cardSelection(empManagement.panContainerEmployee, empManagement.panCRUD);
                        
                        // Se bloquea el botón de 'eliminar'.
                        empManagement.btnDeleteEmployee.setEnabled(true);
                        
                        // Se configura el texto del botón.
                        empManagement.btnRegisterModifyEmployee.setText("Registrar");
                        
                        // Variables de apoyo para construir el comboBox de sucursales.
                        ArrayList<String>   codexBranch = new ArrayList<>(),
                                            namesBranch = new ArrayList<>();
                        
                        // Se obtienen los datos de las sucursales.
                        loadBranch(codexBranch, namesBranch);
                        
                        // Se llena el combobox de las sucursales.
                        empManagement.cmbBranchEmployee.removeAllItems();
                        empManagement.cmbBranchEmployee.addItem(" - Seleccionar una Sucursal - ");
                        
                        for(int i = 0; i < codexBranch.size(); i++)
                            empManagement.cmbBranchEmployee.addItem(namesBranch.get(i));
                        
                        // Se limpian todos los aspectos visuales.
                        empManagement.clearView();
                        empManagement.txtIdEmployee.setEnabled(true);
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
                
                empManagement.btnChangeBranch.setEnabled(true);
                empManagement.lblSucursalName.setText(branchUser);
                empManagement.btnDeleteEmployee.setEnabled(true);
                
                break;
                
            // Rol: Gerente
            case "ROL-02":
                
                empManagement.btnChangeBranch.setEnabled(false);
                empManagement.lblSucursalName.setText(branchUser);
                empManagement.btnDeleteEmployee.setEnabled(false);
                
                break;
            
        }
        
    }
    
    /**
     * Método para cargar todas ciudades.
     * @return Listado de nombres de ciudades.
     */
    private void loadEmployee(String idEmployee){
        
        // Se instancia la clase a utilizar.
        empCRUD = new EmployeeCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
                
        try {
            result = empCRUD.readEmployeeData(idEmployee);
            while(result.next()){
                id = result.getString("cedula");
                branch = result.getString("NombreSucursal");
                name = result.getString("nombre");
                lastName = result.getString("apellido");
                phone = result.getLong("telefono");
                direction = result.getString("direccion");
                birth = result.getDate("fecha_nacimiento");
                entrance = result.getDate("fecha_ingreso");
                email = result.getString("correo");
                job = result.getString("cargo");
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
        String  initSQL     = "SELECT empleado.\"cedula\", empleado.\"nombre\", empleado.\"apellido\", "
                                    + "sucursal.\"nombre\" as \"nombreSucursal\", empleado.\"cargo\" "
                                    + "FROM \"empleado\", \"sucursal\" WHERE \"sucursal_codigo\" = sucursal.\"codigo\" "
                                    + "AND empleado.\"estado\" = 'A' AND sucursal.\"estado\" = 'A'",
                finalSQL    = ";",
                nameSQL     = " AND empleado.\"nombre\" = ",
                lastNameSQL = " AND empleado.\"apellido\" = ",
                idSQL       = " AND empleado.\"cedula\" = ",
                jobSQL      = " AND empleado.\"cargo\" = ",
                branchSQL   = " AND sucursal.\"nombre\" = ",
                SQL         = "";
         
        // Se inicia la sentencia SQL;
        SQL += initSQL;
        
        // Si se ingresó la cédula de un empleado.
        if(!empManagement.txtSearchIdEmployee.getText().equals("Cédula del empleado") && 
                !empManagement.txtSearchIdEmployee.getText().equals(""))
            SQL += idSQL + "'" + empManagement.txtSearchIdEmployee.getText() + "'";
                
        // Si se ingresó el nombre y apellido de un empleado.
        if(!empManagement.txtSearchNameEmployee.getText().equals("") &&
                !empManagement.txtSearchNameEmployee.getText().equals("Nombre y apellido del empleado")){
                   
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
            SQL += jobSQL + "'" + empManagement.cmbSearchJobEmployee.getSelectedItem().toString() + "'";
          
        // Se culmina la sentencia.
        return SQL += finalSQL;
        
    }
    
    /**
     * Método para cargar la información del empleado
     * @return listado con la información del empleado.
     */
    private void loadEmployeeTable(){
                
        // Se instancia la clase a utilizar.
        empCRUD = new EmployeeCRUD();
        
        // Se declaran los arreglos a utilizar
        ArrayList<String>   idEmployee      = new ArrayList<>(),
                            namesEmployee   = new ArrayList<>(),
                            branchEmployee  = new ArrayList<>(),
                            jobEmployee     = new ArrayList<>();
                
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            
            // Se realiza la búsqueda de empleados.
            result = empCRUD.readEmployees(buildSentenceSQL());
            
            // Se obtienen los resultados.
            while(result.next()){
                
                idEmployee.add(result.getString("cedula"));
                namesEmployee.add(result.getString("nombre") + " " + result.getString("apellido"));
                branchEmployee.add(result.getString("nombreSucursal"));
                jobEmployee.add(result.getString("cargo"));
                                   
            }
            
            System.out.println("Carga exitosa. Cantidad de empleados encontrados: " + idEmployee.size());
            
            // Se obtuvo al menos un resultado.
            if(idEmployee.size() > 0){
                
                // Se limpia la tabla de empleados.
                empManagement.clearEmployeeTable(empManagement.tblEmployeeList);
                
                // Se obtiene el modelo de la tabla de empleados.
                DefaultTableModel dtm = (DefaultTableModel) empManagement.tblEmployeeList.getModel();

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
                for(int i = 0; i < idEmployee.size(); i++){

                    dtm.addRow(new Object[]{
                        idEmployee.get(i),
                        namesEmployee.get(i),
                        branchEmployee.get(i),
                        jobEmployee.get(i),
                        btnR
                    });

                }
                                
            }
            
            // No se obtuvo ningún resultado.
            else
                popup = new PopupMessage(empManagement, true, 1, "No se encontraron empleados.");
                            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }
    
    /**
     * Método para registrar a un nuevo empleado.
     */
    private void registerEmployeeData(){
                        
        // Se carga la nueva información del empleado.
        Employee emp = new Employee(empManagement.txtIdEmployee.getText(), 
                                    empManagement.txtNameEmployee.getText(), 
                                    empManagement.txtLastNameEmployee.getText(), 
                                    Long.valueOf(empManagement.txtPhoneEmployee.getText()), 
                                    empManagement.txtDirectionEmployee.getText(), 
                                    empManagement.dchBirthEmployee.getDate(), 
                                    empManagement.txtEmailEmployee.getText(), 
                                    'A', 
                                    loadBranch(empManagement.cmbBranchEmployee.getSelectedItem().toString()), 
                                    empManagement.cmbJobEmployee.getSelectedItem().toString(),    
                                    empManagement.dchEntranceDateEmployee.getDate());
        
        // Se ejecuta el registro de datos.
        empCRUD.registerEployee(emp);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(empManagement, true, 4, 
                "El empleado se ha registrado con éxito");
        
    }
    
    /**
     * Método para actualizar la información de un empleado.
     * @param id cédula del empleado a actualizar.
     */
    private void updateEmployeeData(String id){
                        
        // Se carga la nueva información del empleado.
        Employee emp = new Employee(empManagement.txtIdEmployee.getText(), 
                                    empManagement.txtNameEmployee.getText(), 
                                    empManagement.txtLastNameEmployee.getText(), 
                                    Long.valueOf(empManagement.txtPhoneEmployee.getText()), 
                                    empManagement.txtDirectionEmployee.getText(), 
                                    empManagement.dchBirthEmployee.getDate(), 
                                    empManagement.txtEmailEmployee.getText(), 
                                    'A', 
                                    loadBranch(empManagement.cmbBranchEmployee.getSelectedItem().toString()), 
                                    empManagement.cmbJobEmployee.getSelectedItem().toString(),    
                                    empManagement.dchEntranceDateEmployee.getDate());
        
        // Se ejecuta la actualización de datos.
        empCRUD.UpdateEmployee(emp, id);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(empManagement, true, 4, 
                "Los datos del empleados se han actualizado con éxito.");
        
    }
    
     /**
     * Método para actualizar la información de un empleado.
     * @param id cédula del empleado a actualizar.
     */
    private void clearEmployeetable(){
                        
        // Se limpia el panel
        empManagement.clearEmployeeSearch();
        //se carga actualización
        loadEmployeeTable();
        
    }
    
   
    
    /**
     * Método para limpiar las variables.
     */
    private void clearVariables(){
        
        id          = "";
        branch      = "";
        name        = "";
        lastName    = "";
        direction   = "";
        email       = "";
        phone       = 0;
        job         = "";
        birth       = null;
        entrance    = null;
        
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
