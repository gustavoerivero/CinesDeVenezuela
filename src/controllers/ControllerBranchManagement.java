package controllers;

// Se importan las librerías de soporte.
import lib.SupportFunctions;

// Se importan los models a utilizar.
import models.Branch;
import models.database.BranchCRUD;
import models.database.EnterpriseCRUD;
import models.database.CityCRUD;

// Se importan las views a utilizar.
import views.BranchManagement;
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
public class ControllerBranchManagement implements ActionListener, MouseListener{
      //<editor-fold defaultstate="collapsed" desc=" Declaración de variables ">
    // Models
    private Branch branch;
    // Models.database
    private BranchCRUD bCRUD;
    private CityCRUD cCRUD;
    private EnterpriseCRUD eCRUD;
    // Views
    private BranchManagement braManagement;
    private PopupMessage popup;
    // Controllers
    private ControllerMainMenu contMainMenu;    
    // Librerías de soporte
    private SupportFunctions support;   
    // Variables del usuario.
    private int auxM;
    private String  rolUser,
                    nameUser,
                    branchUser;    
    // Variables para CRUD del empleado.
    private String  id,
                    enterprise,
                    name,
                    direction,
                    city,
                    phone;
    //</editor-fold>
    
    /**
     * Constructor del gestor de sucursales.
     * @param rolUser Rol del usuario que ha ingresado al sistema.
     * @param nameUser Nombre del usuario que ha ingresado al sistema.
     * @param branchUser Nombre de la sucursal del usuario que ha ingresado al sistema.
     */
    public ControllerBranchManagement(String rolUser, String nameUser, String branchUser){
        
        // Declarar la variable de las clases instanciadas.
        braManagement   = new BranchManagement();
        support         = new SupportFunctions();       
        // Se inicializan las variables.
        this.rolUser    = rolUser;
        this.nameUser   = nameUser;
        this.branchUser = branchUser;
        
        // Se muestra la primera pantalla.
        support.cardSelection(braManagement.panContainerBranch, braManagement.panConsultList);
        // Se cargan los empleados.
        loadBranchTable();
        
        // Se habilitan o deshabilitan los botónes según tipo de usuario.
        enabledButtons(this.rolUser);
        
        // Se inicializan las variables.
        clearVariables();
        
        // Activamos los eventos por las views.
        braManagement.addEvents(this);
        braManagement.addMouseEvents(this);
        
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
        if(evt.getSource() == braManagement.btnMin){
            braManagement.setExtendedState(java.awt.Frame.ICONIFIED);
            braManagement.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir de la aplicación.
        else if(evt.getSource() == braManagement.btnExit){
            braManagement.dispose();
        } 
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Branch Change ">
        
        // Cambiar de sucursal a gestionar
       /* else if(evt.getSource() == braManagement.btnChangeBranch){
            
            ArrayList<String>   cityNames   = loadCityNames(),
                                cityBranch  = new ArrayList<>(),
                                branchNames = new ArrayList<>();
            
            loadBranch(cityBranch, branchNames);
                        
            // Instanciar la clase
            changeBranch = new ChangeBranch(braManagement, true, cityNames, cityBranch, branchNames, rolUser);
            
            // Se ubica el nombre de la sucursal.
            braManagement.lblSucursalName.setText(changeBranch.getId_Sucursal());
                        
            changeBranch.dispose();
            
        }*/
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Branch Search ">
        
        // Buscar a un empleado.
        else if(evt.getSource() == braManagement.btnSearchBranch){
            
            // Si no se ingresó información para filtrar.
            if  ((braManagement.txtSearchIdBranch.getText().equals("") || 
                    braManagement.txtSearchIdBranch.getText().equals("Codigo de la sucursal")) &&
                (braManagement.txtSearchNameBranch.getText().equals("") ||
                    braManagement.txtSearchNameBranch.getText().equals("Nombre de la sucursal")) &&
                (braManagement.cmbSearchCity.getSelectedIndex() == 0) )
                    popup = new PopupMessage(braManagement, true, 1, "Debe ingresar al menos un dato para filtrar.");
            
            // Si al menos se ingresó algún dato para filtrar.
            else
                loadBranchTable();
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Branch Table Clear ">
        
        // Limpiar el consultar listado.
        else if(evt.getSource() == braManagement.btnClearSearchBranch){
            
            braManagement.clearBranchSearch();
            
            loadBranchTable();
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Back to Consult List ">
        
        // Para volver a la view de consulta.
        else if(evt.getSource() == braManagement.btnBackBranch){
            
            // Se validan todos los campos.
            if(!braManagement.txtIdBranch.getText().equals("Codigo de la sucursal") && 
                    !braManagement.txtIdBranch.getText().equals("") &&
                    !braManagement.txtNameBranch.getText().equals("Nombre de la sucursal") &&
                    !braManagement.txtNameBranch.getText().equals("") &&
                    !braManagement.txtDirectionBranch.getText().equals("Dirección de la sucursal") &&
                    !braManagement.txtDirectionBranch.getText().equals("") &&
                    !braManagement.txtPhoneBranch.getText().equals("Teléfono de la sucursal") &&
                    !braManagement.txtPhoneBranch.getText().equals("") &&
                    braManagement.cmbCityBranch.getSelectedIndex() != 0 &&
                    braManagement.cmbCityBranch.getSelectedIndex() != 0 &&
                    braManagement.cmbEnterpriseBranch.getSelectedIndex() != 0 &&
                    braManagement.cmbEnterpriseBranch.getSelectedIndex() != 0){
                
                // Se pregunta al usuario si desea abandonar la consulta.
                SelectOption select = new SelectOption(braManagement, true, 1, 
                        "¿Está seguro que desea abandonar la consulta?", "Si", "No");
                
                // Si la respuesta es afirmativa.
                if(select.getOpc()){
                    
                    // Se muestra la vista del CRUD.
                    support.cardSelection(braManagement.panContainerBranch, braManagement.panConsultList);
                    
                    // Se cargan las sucursales.
                    loadBranchTable();
                    
                    // Se inicializan las variables.
                    clearVariables();
                                        
                }    
                   
            }
            
            // Si no hay campos modificados.
            else{
                
                // Se muestra la vista del CRUD.
                support.cardSelection(braManagement.panContainerBranch, braManagement.panConsultList);
                    
                // Se cargan las sucursales.
                loadBranchTable();
                
                // Se inicializan las variables.
                clearVariables();
                
            }
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Clear form ">
        
        // Si se desea limpiar un empleado.
        else if(evt.getSource() == braManagement.btnClearBranch){
            
            if(id.equals(""))
                braManagement.clearView();
            else{
                
                // Se muestran los datos obtenidos.
                braManagement.txtIdBranch.setText(id);
                braManagement.txtNameBranch.setText(name);
                braManagement.txtDirectionBranch.setText(direction);
                braManagement.txtPhoneBranch.setText(String.valueOf(phone));
                braManagement.cmbEnterpriseBranch.setSelectedItem(enterprise);
                braManagement.cmbCityBranch.setSelectedItem(city);
                
            }
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Register or Update Branch ">
        
        // Registro o Modificación de empleado.
        else if(evt.getSource() == braManagement.btnRegisterModifyBranch){
            
            /**
             * Si la variable global 'id' se encuentra vacía, se tiene que el caso
             * es un registro.
             */
            if(id.equals("")){
                
                
                // De no haber campos vacíos.
            if(!braManagement.txtIdBranch.getText().equals("Codigo de la sucursal") && 
                    !braManagement.txtIdBranch.getText().equals("") &&
                    !braManagement.txtNameBranch.getText().equals("Nombre de la sucursal") &&
                    !braManagement.txtNameBranch.getText().equals("") &&
                    !braManagement.txtDirectionBranch.getText().equals("Dirección de la sucursal") &&
                    !braManagement.txtDirectionBranch.getText().equals("") &&
                    !braManagement.txtPhoneBranch.getText().equals("Teléfono de la sucursal") &&
                    braManagement.txtPhoneBranch.getText().length() <= 10 &&
                    braManagement.cmbCityBranch.getSelectedIndex() != 0 &&
                    braManagement.cmbEnterpriseBranch.getSelectedIndex() != 0){
                
                        // Se confirma que se desea eliminar el registro.
                        SelectOption select = new SelectOption(braManagement, true, 2, 
                                "¿Desea registrar esta sucursal?", "Si", "No");

                        // Si se confirma el registro.
                        if(select.getOpc()){

                            // Si el empleado ya existe pero se encuentra inactivo.
                            if(bCRUD.branchExist(braManagement.txtIdBranch.getText(), 'I')){
                                
                                // Se cambia el estado del empleado a activo.
                                bCRUD.DeleteBranch(braManagement.txtIdBranch.getText(), 1);
                                
                                // Se actualiza la información del empleado.
                                updateBranchData(braManagement.txtIdBranch.getText());
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(braManagement.panContainerBranch, braManagement.panConsultList);

                                // Se cargan los empleados.
                                loadBranchTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                            }
                            
                            // Si el usuario no existe.
                            else{
                            
                                // Se ejecuta el registro de información.
                                registerBranchData();
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(braManagement.panContainerBranch, braManagement.panConsultList);

                                // Se cargan las sucursales.
                                loadBranchTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                            }
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(braManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
      
                
            }
            
            /**
             * Si la variable global 'id' posee algún dato, se tiene el caso de modificación
             * de un registro.
             */
            else{
                
                // De no haber campos vacíos.
                if(!braManagement.txtIdBranch.getText().equals("Codigo de la sucursal") && 
                    !braManagement.txtIdBranch.getText().equals("") &&
                    !braManagement.txtNameBranch.getText().equals("Nombre de la sucursal") &&
                    !braManagement.txtNameBranch.getText().equals("") &&
                    !braManagement.txtDirectionBranch.getText().equals("Dirección de la sucursal") &&
                    !braManagement.txtDirectionBranch.getText().equals("") &&
                    !braManagement.txtPhoneBranch.getText().equals("Teléfono de la sucursal") &&
                    braManagement.txtPhoneBranch.getText().length() <= 10 &&
                    braManagement.cmbCityBranch.getSelectedIndex() != 0 &&
                    braManagement.cmbEnterpriseBranch.getSelectedIndex() != 0){
                
                        // Se confirma que se desea eliminar el registro.
                        SelectOption select = new SelectOption(braManagement, true, 2, 
                                "¿Desea actualizar los datos de esta sucursal?", "Si", "No");

                        // Si se confirma la actualización.
                        if(select.getOpc()){

                            // Se ejecuta la actualización de información.
                            updateBranchData(id);
                            
                            // Se muestra la vista del CRUD.
                            support.cardSelection(braManagement.panContainerBranch, braManagement.panConsultList);

                            // Se cargan las sucursales.
                            loadBranchTable();

                            // Se inicializan las variables.
                            clearVariables();
                            
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(braManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
                                    
            }
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Delete Branch ">
        
        // Eliminación de un empleado.
        else if(evt.getSource() == braManagement.btnDeleteBranch){
            
            // Se pregunta al usuario si desea realmente eliminar la sucursal.
            SelectOption select = new SelectOption(braManagement, true, 2, 
                    "¿Está seguro que desea eliminar esta sucursal?", "Si", "No");
            
            // Si la respuesta es afirmativa.
            if(select.getOpc())
            {
                checkEmployee(id);
                if(auxM>0)
                {
                popup = new PopupMessage(braManagement, true, 1, "No se puede eliminar la sucursal porque tiene empleados registrados");
                }
                else
                {
                // Se realiza la eliminación lógica.
                bCRUD.DeleteBranch(id, 0);
                
                // Se muestra un mensaje de eliminación exitosa.
                popup = new PopupMessage(braManagement, true, 4, "La sucursal se ha eliminado con éxito.");
                
                // Se muestra la vista del CRUD.
                support.cardSelection(braManagement.panContainerBranch, braManagement.panConsultList);
                    
                // Se cargan los empleados.
                loadBranchTable();
                    
                // Se inicializan las variables.
                clearVariables(); 
                }

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
        if(evt.getSource() == braManagement.tblBranchList){
                                              
            // Se obtienen los valores de la fila y columna seleccionada.
            int column = braManagement.getColumnTable(), row = braManagement.getRowTable();

            // Se valida que el evento del Mouse fue provocado dentro del JTable.
            if(row < braManagement.tblBranchList.getRowCount() && row >= 0 && 
                    column < braManagement.tblBranchList.getColumnCount() && column >= 0){
                
                // Se obtiene el valor de la celda seleccionada.
                Object value = braManagement.tblBranchList.getValueAt(row, column);
                
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
                        DefaultTableModel dtm = (DefaultTableModel) braManagement.tblBranchList.getModel();
                                                
                        // Se obtiene el id de la sucursal en cuestión.
                        String idBranch = dtm.getValueAt(row, 0).toString();
                        
                        // Se buscan los datos del empleado.
                        loadBranch(idBranch);
                                                             
                        // Variables de apoyo para construir el comboBox de sucursales.
                        ArrayList<String>   codexCity = new ArrayList<>(),
                                            codexEnterprise= new ArrayList<>(),
                                            nameCity = new ArrayList<>(),
                                            nameEnterprise = new ArrayList<>();
                        
                        // Se obtienen los datos de las sucursales.
                        loadCity(codexCity, nameCity);
                        loadEnterprise(codexEnterprise,nameEnterprise);
                        // Se llena el combobox de las sucursales.
                        braManagement.cmbCityBranch.removeAllItems();
                        braManagement.cmbCityBranch.addItem(" - Seleccionar una Ciudad - ");
                        braManagement.cmbEnterpriseBranch.removeAllItems();
                        braManagement.cmbEnterpriseBranch.addItem(" - Seleccionar una Empresa - ");                        
                        for(int i = 0; i < codexCity.size(); i++)
                            braManagement.cmbCityBranch.addItem(nameCity.get(i));
                        for(int i = 0; i < codexEnterprise.size(); i++)
                            braManagement.cmbEnterpriseBranch.addItem(nameEnterprise.get(i));
                                                    
                        // Se muestra la vista del CRUD.
                        support.cardSelection(braManagement.panContainerBranch, braManagement.panCRUD);
                        
                        // Se bloquea el botón de 'eliminar'.
                        braManagement.btnDeleteBranch.setEnabled(true);
                        
                        // Se configura el texto del botón.
                        braManagement.btnRegisterModifyBranch.setText("Modificar");
                        
                        // Se limpian todos los aspectos visuales.
                        braManagement.clearView();
                                                
                        // Se muestran los datos obtenidos.
                        braManagement.txtIdBranch.setText(id);
                        braManagement.cmbCityBranch.setSelectedItem(city);    
                        braManagement.cmbEnterpriseBranch.setSelectedItem(enterprise);
                        braManagement.txtNameBranch.setText(name);
                        braManagement.txtDirectionBranch.setText(direction);
                        braManagement.txtPhoneBranch.setText(String.valueOf(phone));

                        
                        // Se bloquea el campo de codigo.
                        braManagement.txtIdBranch.setEnabled(false);
                        
                    }
                    
                    //</editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc=" Proceso para crear un empleado ">
                    
                    // Si el JButton se llama "i";
                    if(btn.getName().equals("i")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                                     
                        // Se muestra la vista del CRUD.
                        support.cardSelection(braManagement.panContainerBranch, braManagement.panCRUD);
                        
                        // Se bloquea el botón de 'eliminar'.
                        braManagement.btnDeleteBranch.setEnabled(false);
                        
                        // Se configura el texto del botón.
                        braManagement.btnRegisterModifyBranch.setText("Registrar");
                        
                        // Se limpian todos los aspectos visuales.
                        braManagement.clearView();
                        
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
                
                braManagement.lblSucursalName.setText(branchUser);
                
                break;
                
            // Rol: Gerente
            case "ROL-02":
                
                braManagement.lblSucursalName.setText(branchUser);
                
                break;
            
        }
        
    }

    
    /**
     * Método para buscar una sucursal
     * @return Listado de nombres de ciudades.
     */
    private void loadBranch(String idBranch){
        
        // Se instancia la clase a utilizar.
        bCRUD = new BranchCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
                
        try {
            result = bCRUD.readBranchData(idBranch);
            while(result.next()){
                id = result.getString("codigo");
                enterprise = result.getString("NombreEmpresa");
                name = result.getString("nombre");
                direction = result.getString("direccion");
                city = result.getString("NombreCiudad");
                phone = result.getString("telefono");

            }
            
            System.out.println("Éxito.");
                        
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
                
    }
    
    
    //<editor-fold defaultstate="collapsed" desc=" Métodos para cargar el combobox de ciudad ">
    /**
     * Método para cargar Ciudades.
     * @param firstList Primer listado con los codigos de las ciudades.
     * @param secondList Segundo listado con los nombres de las ciudades.
     */
    private void loadCity(ArrayList<String> firstList, ArrayList<String> secondList){
        
        // Se instancia la clase a utilizar.
        cCRUD = new CityCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            result = cCRUD.readCityCN();
            while(result.next()){
                firstList.add(result.getString("codigo"));
                secondList.add(result.getString("nombre"));
            }
                        
            System.out.println("Éxito.");
                                    
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }
        //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Métodos para cargar el combox de empresa  ">
    /**
     * Método para cargar empresa.
     * @param firstList Primer listado con los codigo de empresa.
     * @param secondList Segundo listado con los nombres de las empresas.
     */
    private void loadEnterprise(ArrayList<String> firstList, ArrayList<String> secondList){
        
        // Se instancia la clase a utilizar.
        eCRUD = new EnterpriseCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            result = eCRUD.readEnterpriseCN();
            while(result.next()){
                firstList.add(result.getString("codigo"));
                secondList.add(result.getString("nombre"));
            }
                        
            System.out.println("Éxito.");
                                    
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }
        //</editor-fold>
     private void checkEmployee(String idA)
     {
         auxM=0;
        java.sql.ResultSet result;
        String aux="";
        try {
            result = bCRUD.readContEmployeeBranch(idA);
            while(result.next()){                
            aux = result.getString("cantidadEmpleados");
                }
            auxM = Integer.parseInt(aux);
            System.out.println("Cantidad de empleados " + aux + ";");
        } 
        catch (SQLException ex) {
            Logger.getLogger(ControllerBranchManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }

    
    /**
     * Método para buscar el código de una ciudad.
     * @param cityName Nombre de la ciudad.
     * @return Devuelve el código de la ciudad.
     */
  
    private String loadCity(String cityName){
        
                // Se instancia la clase a utilizar.
        cCRUD = new CityCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        // Variable de soporte.
        String codex;
        
        try {
            result = cCRUD.readOnlyCity(cityName);
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
     * Método para buscar el código de una empresa.
     * @param cityName Nombre de la ciudad.
     * @return Devuelve el código de la ciudad.
     */
    private String loadEnterprise(String enterpriseName){
        
                // Se instancia la clase a utilizar.
        eCRUD  = new EnterpriseCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        // Variable de soporte.
        String codex;
        
        try {
            result = eCRUD.readOnlyEnterprise(enterpriseName);
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
        cCRUD = new CityCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        // Se declara e instancia la variable de soporte.
        ArrayList<String> cityNames = new ArrayList<>();
        
        try {
            result = cCRUD.readAllCityNames();
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
     * Método para construir la sentencia de búsqueda de la sucursal.
     * @return Sentencia SQL.
     */
    private String buildSentenceSQL(){
        
        // Se declaran e inicializan las variables que servirán para buscar la sucursal.
        String  initSQL     = "SELECT sucursal.\"codigo\", sucursal.\"nombre\", ciudad.\"nombre\" as \"nombreCiudad\", "
                                    + "\"direccion\", \"telefono\" "
                                    + "FROM \"ciudad\", \"sucursal\" WHERE sucursal.\"ciudad_codigo\" = ciudad.\"codigo\" "
                                    + "AND ciudad.\"estado\" = 'A' AND sucursal.\"estado\" = 'A'",
                finalSQL    = ";",
                nameSQL     = " AND sucursal.\"nombre\" = ",
                idSQL       = " AND sucursal.\"codigo\" = ",
                citySQL      = " AND ciudad.\"nombre\" = ",
                SQL         = "";
         
        // Se inicia la sentencia SQL;
        SQL += initSQL;
        // Si se ingresó el codigo de la sucursal
        if(!braManagement.txtSearchIdBranch.getText().equals("Codigo de la sucursal") && 
           !braManagement.txtSearchIdBranch.getText().equals(""))
            SQL += idSQL + "'" + braManagement.txtSearchIdBranch.getText() + "'";
                
        // Si se ingresó el nombre de la sucursal.
        if(!braManagement.txtSearchNameBranch.getText().equals("") &&
           !braManagement.txtSearchNameBranch.getText().equals("Nombre de la sucursal")){
            SQL += nameSQL + "'" + braManagement.txtSearchNameBranch.getText() + "'";
                                
        }
        // Si se ingresó una ciudad.
        if(braManagement.cmbSearchCity.getSelectedIndex() != 0)
            SQL += citySQL + "'" + braManagement.cmbSearchCity.getSelectedItem().toString() + "'";
          
        // Se culmina la sentencia.
        return SQL += finalSQL;
        
    }

    
        /**
     * Método para cargar la información de la sucursal.
     * @return listado con la información de la sucursal.
     */
    private void loadBranchTable(){
                
        // Se instancia la clase a utilizar.
        bCRUD = new BranchCRUD();
        cCRUD = new CityCRUD(); 
        // Se declaran los arreglos a utilizar
        ArrayList<String>   idBranch        = new ArrayList<>(),
                            namesBranch     = new ArrayList<>(),
                            cityBrach       = new ArrayList<>(),
                            directionBranch = new ArrayList<>(),
                            phoneBranch     = new ArrayList<>();
                
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            
            // Se realiza la búsqueda de empleados.
            result = bCRUD.readBranchs(buildSentenceSQL());
            
            // Se obtienen los resultados.
            while(result.next()){
                
                idBranch.add(result.getString("codigo"));
                namesBranch.add(result.getString("nombre"));
                cityBrach.add(result.getString("nombreCiudad"));
                directionBranch.add(result.getString("direccion"));
                phoneBranch.add(result.getString("telefono"));
                                   
            }
            
            System.out.println("Carga exitosa. Cantidad de sucursales encontradas: " + idBranch.size());
            
            // Se obtuvo al menos un resultado.
            if(idBranch.size() > 0){
                
                // Se limpia la tabla de empleados.
                braManagement.clearBranchTable(braManagement.tblBranchList);
                
                // Se obtiene el modelo de la tabla de empleados.
                DefaultTableModel dtm = (DefaultTableModel) braManagement.tblBranchList.getModel();

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
                for(int i = 0; i < idBranch.size(); i++){

                    dtm.addRow(new Object[]{
                        idBranch.get(i),
                        namesBranch.get(i),
                        cityBrach.get(i),
                        directionBranch.get(i),
                        phoneBranch.get(i),
                        btnR
                    });

                }
            }
            
            // No se obtuvo ningún resultado.
            else
                popup = new PopupMessage(braManagement, true, 1, "No se encontraron sucursales.");
                            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }

    
    /**
     * Método para registrar una nueva sucursal.
     */
    private void registerBranchData(){
                        
        // Se carga la nueva información del empleado.
        Branch bra = new Branch(braManagement.txtIdBranch.getText(), 
                                    loadCity(braManagement.cmbCityBranch.getSelectedItem().toString()), 
                                    loadEnterprise(braManagement.cmbEnterpriseBranch.getSelectedItem().toString()), 
                                    braManagement.txtNameBranch.getText(), 
                                    braManagement.txtDirectionBranch.getText(), 
                                    braManagement.txtPhoneBranch.getText(), 
                                    'A');
        // Se ejecuta el registro de datos.
        bCRUD.registerBranch(bra);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(braManagement, true, 4, 
                "La sucursal se ha registrado con éxito");
        
    }
    
    /**
     * Método para actualizar la información de la sucursal.
     * @param id codigo de la sucursal a actualizar.
     */
    private void updateBranchData(String id){
                        
        // Se carga la nueva información de la sucursal.
        Branch bra = new Branch(braManagement.txtIdBranch.getText(), 
                                    loadCity(braManagement.cmbCityBranch.getSelectedItem().toString()), 
                                    loadEnterprise(braManagement.cmbEnterpriseBranch.getSelectedItem().toString()), 
                                    braManagement.txtNameBranch.getText(), 
                                    braManagement.txtDirectionBranch.getText(), 
                                    braManagement.txtPhoneBranch.getText(), 
                                    'A');
        
        // Se ejecuta la actualización de datos.
        bCRUD.UpdateBranch(bra, id);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(braManagement, true, 4, 
                "Los datos de la sucursal se han actualizado con éxito.");
        
    }
    
    /**
     * Método para limpiar las variables.
     */
    private void clearVariables(){
                   
        id          = "";
        enterprise      = "";
        name        = "";
        direction    = "";
        city   = "";
        phone       = "";

        
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
