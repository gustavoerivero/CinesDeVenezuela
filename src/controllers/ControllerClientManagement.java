
package controllers;

// Se importan las librerías de soporte.
import lib.SupportFunctions;

// Se importan los models a utilizar.
import models.Client;
import models.database.ClientCRUD;
import models.database.BranchCRUD;
import models.database.CityCRUD;

// Se importan las views a utilizar.
import views.ClientManagement;
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
public class ControllerClientManagement implements ActionListener, MouseListener {
    
     //<editor-fold defaultstate="collapsed" desc=" Declaración de variables ">
    
    // Models
    private Client cli;
    
    // Models.database
    private ClientCRUD cliCRUD;
    private BranchCRUD braCRUD;
    private CityCRUD citCRUD;
    
    // Views
    private ClientManagement cliManagement;
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
                    name,
                    lastName,
                    direction,
                    email,
                    type;
    
    private long    phone;
    
    private Date    birth;
                    
    
    //</editor-fold>
    
    /**
     * Constructor del gestor de Clientes.
     * @param rolUser Rol del usuario que ha ingresado al sistema.
     * @param nameUser Nombre del usuario que ha ingresado al sistema.
     * @param branchUser Nombre de la sucursal del usuario que ha ingresado al sistema.
     */
    public ControllerClientManagement(String rolUser, String nameUser, String branchUser){
        
        // Declarar la variable de las clases instanciadas.
        cliManagement   = new ClientManagement();
        support         = new SupportFunctions();
        
        // Se inicializan las variables.
        this.rolUser    = rolUser;
        this.nameUser   = nameUser;
        this.branchUser = branchUser;
        
        // Se muestra la primera pantalla.
        support.cardSelection(cliManagement.panContainerClient, cliManagement.panConsultList);
        
        // Se cargan los clientes.
        loadClientTable();
        
        // Se habilitan o deshabilitan los botónes según tipo de usuario.
        enabledButtons(this.rolUser);
        
        // Se inicializan las variables.
        clearVariables();
        
        // Activamos los eventos por las views.
        cliManagement.addEvents(this);
        cliManagement.addMouseEvents(this);
        }
    
    
       /**
     * Método que determina las acciones a realizar por la aplicación según el 
     * botón presionado.
     * @param evt indica los eventos posibles a ocurrir (click en botónes).
     */
    public void actionPerformed(ActionEvent evt) {
        
        //<editor-fold defaultstate="collapsed" desc=" Botones de la Barra Superior ">
        
        // Minimizar aplicación.
        if(evt.getSource() == cliManagement.btnMin){
            cliManagement.setExtendedState(java.awt.Frame.ICONIFIED);
            cliManagement.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir de la aplicación.
        else if(evt.getSource() == cliManagement.btnExit){
            cliManagement.dispose();
        } 
        
        //</editor-fold>
    
        //<editor-fold defaultstate="collapsed" desc=" Branch Change ">
        
        // Cambiar de sucursal a gestionar
        else if(evt.getSource() == cliManagement.btnChangeBranch){
            
            ArrayList<String>   cityNames   = loadCityNames(),
                                cityBranch  = new ArrayList<>(),
                                branchNames = new ArrayList<>();
            
            loadBranch(cityBranch, branchNames);
                        
            // Instanciar la clase
            changeBranch = new ChangeBranch(cliManagement, true, cityNames, cityBranch, branchNames, rolUser);
            
            // Se ubica el nombre de la sucursal.
            cliManagement.lblSucursalName.setText(changeBranch.getId_Sucursal());
                        
            changeBranch.dispose();
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Client Search ">
        
        // Buscar a un client.
        else if(evt.getSource() == cliManagement.btnSearchClient){
            
            // Si no se ingresó información para filtrar.
            if  ((cliManagement.txtSearchIdClient.getText().equals("") || 
                    cliManagement.txtSearchIdClient.getText().equals("Cédula del cliente")) &&
                (cliManagement.txtSearchNameClient.getText().equals("") ||
                    cliManagement.txtSearchNameClient.getText().equals("Nombre y apellido del cliente")))
                 popup = new PopupMessage(cliManagement, true, 1, "Debe ingresar al menos un dato para filtrar.");
                 
            // Si al menos se ingresó algún dato para filtrar.
            else
                loadClientTable();   
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Client Table Clear ">
        
        // Limpiar el consultar listado.
        else if(evt.getSource() == cliManagement.btnClearSearchClient){
            
            cliManagement.clearClientSearch();
            
            loadClientTable();
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Back to Consult List ">
        
        // Para volver a la view de consulta.
        else if(evt.getSource() == cliManagement.btnBackClient){
            
            // Se validan todos los campos.
            if(!cliManagement.txtIdClient.getText().equals("Cédula del cliente") && 
                    !cliManagement.txtIdClient.getText().equals("") &&
                    !cliManagement.txtNameClient.getText().equals("Nombre del cliente") &&
                    !cliManagement.txtNameClient.getText().equals("") &&
                    !cliManagement.txtLastNameClient.getText().equals("Apellido del cliente") &&
                    !cliManagement.txtLastNameClient.getText().equals("") &&
                    !cliManagement.txtDirectionClient.getText().equals("Dirección del cliente") &&
                    !cliManagement.txtDirectionClient.getText().equals("") &&
                    !cliManagement.txtEmailClient.getText().equals("Correo electrónico del empleado") &&
                    !cliManagement.txtEmailClient.getText().equals("") &&
                    !cliManagement.txtPhoneClient.getText().equals("Teléfono del empleado") &&
                    !cliManagement.txtPhoneClient.getText().equals("") ){
                
                // Se pregunta al usuario si desea abandonar la consulta.
                SelectOption select = new SelectOption(cliManagement, true, 1, 
                        "¿Está seguro que desea abandonar la consulta?", "Si", "No");
                
                // Si la respuesta es afirmativa.
                if(select.getOpc()){
                    
                    // Se muestra la vista del CRUD.
                    support.cardSelection(cliManagement.panContainerClient, cliManagement.panConsultList);
                    
                    // Se cargan los empleados.
                    loadClientTable();
                    
                    // Se inicializan las variables.
                    clearVariables();
                                        
                }    
                   
            }
            
            // Si no hay campos modificados.
            else{
                
                // Se muestra la vista del CRUD.
                support.cardSelection(cliManagement.panContainerClient, cliManagement.panConsultList);
                    
                // Se cargan los empleados.
                loadClientTable();
                
                // Se inicializan las variables.
                clearVariables();
                
            }
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Clear form ">
        
        // Si se desea limpiar un cliente.
        else if(evt.getSource() == cliManagement.btnClearClient){
            
            if(id.equals(""))
                cliManagement.clearView();
            else{
                
                // Se muestran los datos obtenidos.
                cliManagement.txtIdClient.setText(id);
                cliManagement.txtNameClient.setText(name);
                cliManagement.txtLastNameClient.setText(lastName);
                cliManagement.txtDirectionClient.setText(direction);
                cliManagement.txtEmailClient.setText(email);
                cliManagement.txtPhoneClient.setText(String.valueOf(phone));
                cliManagement.dchBirthClient.setDate(birth);
                
            }
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Register or Update Client ">
        
        // Registro o Modificación de empleado.
        else if(evt.getSource() == cliManagement.btnRegisterModifyClient){
            
            /**
             * Si la variable global 'id' se encuentra vacía, se tiene que el caso
             * es un registro.
             */
            if(id.equals("")){
                
                
                // De no haber campos vacíos.
                if( !cliManagement.txtIdClient.getText().equals("") && 
                    !cliManagement.txtIdClient.getText().equals("Cédula del cliente") && 
                    !cliManagement.txtNameClient.getText().equals("") &&
                    !cliManagement.txtNameClient.getText().equals("Nombre del cliente") &&
                    !cliManagement.txtLastNameClient.getText().equals("") &&
                    !cliManagement.txtLastNameClient.getText().equals("Apellido del cliente") &&
                    !cliManagement.txtDirectionClient.getText().equals("") &&
                    !cliManagement.txtDirectionClient.getText().equals("Dirección del cliente") &&
                    !cliManagement.txtEmailClient.getText().equals("") &&
                    !cliManagement.txtEmailClient.getText().equals("Correo del cliente") &&
                    !cliManagement.txtPhoneClient.getText().equals("") &&
                    !cliManagement.txtPhoneClient.getText().equals("Teléfono del empleado") &&
                     cliManagement.txtPhoneClient.getText().length() <= 10){
                
                        // Se confirma que se desea guardar el registro.
                        SelectOption select = new SelectOption(cliManagement, true, 2, 
                                "¿Desea registrar a este empleado?", "Si", "No");

                        // Si se confirma el registro.
                        if(select.getOpc()){

                            // Si el empleado ya existe pero se encuentra inactivo.
                            if(cliCRUD.signer(cliManagement.txtIdClient.getText(), 'I')){
                                
                                // Se cambia el estado del empleado a activo.
                                cliCRUD.DeleteClient(cliManagement.txtIdClient.getText(), 1);
                                
                                // Se actualiza la información del empleado.
                                updateClientData(cliManagement.txtIdClient.getText());
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(cliManagement.panContainerClient, cliManagement.panConsultList);

                                // Se cargan los empleados.
                                loadClientTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                            }
                            
                            // Si el cliente no existe.
                            else{
                            
                                // Se ejecuta el registro de información.
                                registerClientData();
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(cliManagement.panContainerClient, cliManagement.panConsultList);

                                // Se cargan los empleados.
                                loadClientTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                            }
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(cliManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
      
                
            }
            
            /**
             * Si la variable global 'id' posee algún dato, se tiene el caso de modificación
             * de un registro.
             */
            else{
                
                // De no haber campos vacíos.
                if( !cliManagement.txtIdClient.getText().equals("") && 
                    !cliManagement.txtIdClient.getText().equals("Cédula del cliente") && 
                    !cliManagement.txtNameClient.getText().equals("") &&
                    !cliManagement.txtNameClient.getText().equals("Nombre del cliente") &&
                    !cliManagement.txtLastNameClient.getText().equals("") &&
                    !cliManagement.txtLastNameClient.getText().equals("Apellido del cliente") &&
                    !cliManagement.txtDirectionClient.getText().equals("") &&
                    !cliManagement.txtDirectionClient.getText().equals("Dirección del cliente") &&
                    !cliManagement.txtEmailClient.getText().equals("") &&
                    !cliManagement.txtEmailClient.getText().equals("Correo del cliente") &&
                    !cliManagement.txtPhoneClient.getText().equals("") &&
                    !cliManagement.txtPhoneClient.getText().equals("Teléfono del empleado") &&
                     cliManagement.txtPhoneClient.getText().length() <= 10){
                
                        // Se confirma que se desea actualizar el registro el registro.
                        SelectOption select = new SelectOption(cliManagement, true, 2, 
                                "¿Desea actualizar los datos de este cliente?", "Si", "No");

                        // Si se confirma la actualización.
                        if(select.getOpc()){

                            // Se ejecuta la actualización de información.
                            updateClientData(id);
                            
                            // Se muestra la vista del CRUD.
                            support.cardSelection(cliManagement.panContainerClient, cliManagement.panConsultList);

                            // Se cargan los empleados.
                            loadClientTable();

                            // Se inicializan las variables.
                            clearVariables();
                            
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(cliManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
                                    
            }
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Delete Client ">
        
        // Eliminación de un empleado.
        else if(evt.getSource() == cliManagement.btnDeleteClient){
            
            // Se pregunta al usuario si desea realmente eliminar al cliente.
            SelectOption select = new SelectOption(cliManagement, true, 2, 
                    "¿Está seguro que desea eliminar a este empleado?", "Si", "No");
            
            // Si la respuesta es afirmativa.
            if(select.getOpc()){
                
                // Se realiza la eliminación lógica.
                cliCRUD.DeleteClient(id, 0);
                
                // Se muestra un mensaje de eliminación exitosa.
                popup = new PopupMessage(cliManagement, true, 4, "El empleado se ha eliminado con éxito.");
                
                // Se muestra la vista del CRUD.
                support.cardSelection(cliManagement.panContainerClient, cliManagement.panConsultList);
                    
                // Se cargan los empleados.
                loadClientTable();
                    
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
    
    public void mouseClicked(MouseEvent evt) {
       
        // Si se hace click sobre la tabla de clientes.
        if(evt.getSource() == cliManagement.tblClientList){
                                              
            // Se obtienen los valores de la fila y columna seleccionada.
            int column = cliManagement.getColumnTable(), row = cliManagement.getRowTable();

            // Se valida que el evento del Mouse fue provocado dentro del JTable.
            if(row < cliManagement.tblClientList.getRowCount() && row >= 0 && 
                    column < cliManagement.tblClientList.getColumnCount() && column >= 0){
                
                // Se obtiene el valor de la celda seleccionada.
                Object value = cliManagement.tblClientList.getValueAt(row, column);
                
                // Si el valor de la celda seleccionada es un JButton;
                if(value instanceof JButton){
                    
                    ((JButton)value).doClick();
                    
                    JButton btn = (JButton) value;

                    //<editor-fold defaultstate="collapsed" desc=" Proceso para consultar un cliente ">
                    
                    // Si el JButton se llama "s";
                    if(btn.getName().equals("s")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                                      
                        // Se obtiene el modelo de la JTable.
                        DefaultTableModel dtm = (DefaultTableModel) cliManagement.tblClientList.getModel();
                                                
                        // Se obtiene el id del empleado en cuestión.
                        String idClient = dtm.getValueAt(row, 0).toString();
                        
                        // Se buscan los datos del cliente.
                        loadClient(idClient);
                        
                        // Se crea la variable de formato de fechas.
                        SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
                          
                        // Se muestra la vista del CRUD.
                        support.cardSelection(cliManagement.panContainerClient, cliManagement.panCRUD);
                        
                        // Se bloquea el botón de 'eliminar'.
                        cliManagement.btnDeleteClient.setEnabled(true);
                        
                        // Se configura el texto del botón.
                        cliManagement.btnRegisterModifyClient.setText("Actualizar");
                        
                        // Se limpian todos los aspectos visuales.
                        cliManagement.clearView();
                                                
                        // Se muestran los datos obtenidos.
                        cliManagement.txtIdClient.setText(id);
                        cliManagement.txtNameClient.setText(name);
                        cliManagement.txtLastNameClient.setText(lastName);
                        cliManagement.txtDirectionClient.setText(direction);
                        cliManagement.txtEmailClient.setText(email);
                        cliManagement.txtPhoneClient.setText(String.valueOf(phone));
                        cliManagement.dchBirthClient.setDate(birth);
                        
                        // Se bloquea el campo de cédula.
                        cliManagement.txtIdClient.setEnabled(false);
                        
                    }
                    
                    //</editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc=" Proceso para registrar un cliente ">
                    
                    // Si el JButton se llama "i";
                    if(btn.getName().equals("i")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton registrar en la celda: " + row + ";" + column);
                                     
                        // Se muestra la vista del CRUD.
                        support.cardSelection(cliManagement.panContainerClient, cliManagement.panCRUD);
                        
                        // Se bloquea el botón de 'eliminar'.
                        cliManagement.btnDeleteClient.setEnabled(false);
                        
                        // Se configura el texto del botón.
                        cliManagement.btnRegisterModifyClient.setText("Registrar");
                        
                        // Se limpian todos los aspectos visuales.
                        cliManagement.clearView();
                        cliManagement.txtIdClient.setEnabled(true);
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
                
                cliManagement.btnChangeBranch.setEnabled(true);
                cliManagement.lblSucursalName.setText(branchUser);
                
                break;
                
            // Rol: Gerente
            case "ROL-02":
                
                cliManagement.btnChangeBranch.setEnabled(false);
                cliManagement.lblSucursalName.setText(branchUser);
                
                break;
            
        }
        
    }
    
    /**
     * Método para cargar todos los clientes.
     * @return Listado de los clientes.
     */
    private void loadClient(String idClient){
        
        // Se instancia la clase a utilizar.
        cliCRUD = new ClientCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
                
        try {
            result = cliCRUD.readClientData(idClient);
            while(result.next()){
                id = result.getString("cedula");
                name = result.getString("nombre");
                lastName = result.getString("apellido");
                direction = result.getString("direccion");
                email = result.getString("correo");
                phone = result.getLong("telefono");
                type = result.getString("tipo");
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
     * Método para construir la sentencia de búsqueda del client.
     * @return Sentencia SQL.
     */
    private String buildSentenceSQL(){
        
        // Se declaran e inicializan las variables que servirán para buscar empleados.
        String  initSQL     = "SELECT \"cedula\", \"nombre\", \"apellido\", "
                + "\"direccion\", \"correo\", \"telefono\", \"tipo\" "
                + "FROM \"cliente\" WHERE \"estado\" = 'A'", 
                
                finalSQL    = ";",
                nameSQL     = " AND \"nombre\" = ",
                lastNameSQL = " AND \"apellido\" = ",
                idSQL       = " AND \"cedula\" = ",
                SQL         = "";
         
        // Se inicia la sentencia SQL;
        SQL += initSQL;
        
        // Si se ingresó la cédula de un cliente.
        if(!cliManagement.txtSearchIdClient.getText().equals("Cédula del cliente") && 
                !cliManagement.txtSearchIdClient.getText().equals(""))
            SQL += idSQL + "'" + cliManagement.txtSearchIdClient.getText() + "'";
                
        // Si se ingresó el nombre y apellido de un cliente.
        if(!cliManagement.txtSearchNameClient.getText().equals("") &&
                !cliManagement.txtSearchNameClient.getText().equals("Nombre y apellido del cliente")){
                   
            // Se fragmenta el dato proporcionado.
            String[] names = cliManagement.txtSearchNameClient.getText().split(" ");
                 
            // Se construye la sentencia.
            if(names.length == 2)
                SQL += nameSQL + "'" + names[0] + "'" + lastNameSQL + "'" + names[1] + "'";
            else
                SQL += nameSQL + "'" + names[0] + "'";
                                
        }
        
        return SQL += finalSQL;
        
    }
    
    /**
     * Método para cargar la información del client.
     * @return listado con la información de la empresa.
     */
    private void loadClientTable(){
                
        // Se instancia la clase a utilizar.
        cliCRUD = new ClientCRUD();
        
        // Se declaran los arreglos a utilizar
        ArrayList<String>   idClient      = new ArrayList<>(),
                            namesClient   = new ArrayList<>(),
                            directionClient  = new ArrayList<>(),
                            emailClient     = new ArrayList<>(),
                            phoneClient     = new ArrayList<>(),
                            typeClient     = new ArrayList<>();
                
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            
            // Se realiza la búsqueda de clientes.
            result = cliCRUD.readClient(buildSentenceSQL());
            
            // Se obtienen los resultados.
            while(result.next()){
                
                idClient.add(result.getString("cedula"));
                namesClient.add(result.getString("nombre") + " " + result.getString("apellido"));
                directionClient.add(result.getString("direccion"));
                emailClient.add(result.getString("correo"));
                phoneClient.add(result.getString("telefono"));
                typeClient .add(result.getString("tipo"));
                                   
            }
            
            System.out.println("Carga exitosa. Cantidad de clientes encontrados: " + idClient.size());
            
            // Se obtuvo al menos un resultado.
            if(idClient.size() > 0){
                
                // Se limpia la tabla de clientes.
                cliManagement.clearClientTable(cliManagement.tblClientList);
                
                // Se obtiene el modelo de la tabla de clientes.
                DefaultTableModel dtm = (DefaultTableModel) cliManagement.tblClientList.getModel();

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
                    " . . . ",
                    btnI
                });
                
                // Se añaden todos los resultados obtenidos a la tabla.
                for(int i = 0; i < idClient.size(); i++){

                    dtm.addRow(new Object[]{
                        idClient.get(i),
                        namesClient.get(i),
                        directionClient.get(i),
                        emailClient.get(i),
                        phoneClient.get(i),
                        typeClient.get(i),
                        btnR
                    });

                }
                                
            }
            
            // No se obtuvo ningún resultado.
            else
                popup = new PopupMessage(cliManagement, true, 1, "No se encontraron clientes.");
                            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }
    
    /**
     * Método para registrar a un nuevo empleado.
     */
    private void registerClientData(){
                        
        // Se carga la nueva información del empleado.
        Client cli = new Client(cliManagement.txtIdClient.getText(), 
                                    cliManagement.txtNameClient.getText(), 
                                    cliManagement.txtLastNameClient.getText(),
                                    Long.valueOf(cliManagement.txtPhoneClient.getText()),  
                                    cliManagement.txtDirectionClient.getText(), 
                                    cliManagement.dchBirthClient.getDate(),
                                    "R",
                                    'A',
                                    cliManagement.txtEmailClient.getText());
        
        // Se ejecuta el registro de datos.
        cliCRUD.registerClient(cli);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(cliManagement, true, 4, 
                "El cliente se ha registrado con éxito");
        
    }
    
    /**
     * Método para actualizar la información de un empleado.
     * @param id cédula del empleado a actualizar.
     */
    private void updateClientData(String id){
                        
        // Se carga la nueva información del empleado.
        Client cli = new Client(cliManagement.txtIdClient.getText(), 
                                    cliManagement.txtNameClient.getText(), 
                                    cliManagement.txtLastNameClient.getText(),
                                    Long.valueOf(cliManagement.txtPhoneClient.getText()),  
                                    cliManagement.txtDirectionClient.getText(), 
                                    cliManagement.dchBirthClient.getDate(),
                                    "R",
                                    'A',
                                    cliManagement.txtEmailClient.getText());
        
        // Se ejecuta la actualización de datos.
        cliCRUD.UpdateClient(cli, id);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(cliManagement, true, 4, 
                "Los datos del empleados se han actualizado con éxito.");
        
    }
    
    /**
     * Método para limpiar las variables.
     */
    private void clearVariables(){
        
        id          = "";
        name        = "";
        lastName    = "";
        direction   = "";
        email       = "";
        phone       = 0;
        birth       = null;
        type        ="";
        
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" PROHIBIDO TOCAR ">
    
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //</editor-fold>
    
    
    
}
