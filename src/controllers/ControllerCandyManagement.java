
package controllers;
// Se importan las librerías de soporte.
import lib.SupportFunctions;
// Se importan los models a utilizar.
import models.Candy;
import models.database.CandyCRUD;
// Se importan las views a utilizar.
import views.CandyManagement;
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
public class ControllerCandyManagement implements ActionListener, MouseListener{
    //<editor-fold defaultstate="collapsed" desc=" Declaración de variables ">
    
    // Models
    private Candy candy;
        // Models.database
        private CandyCRUD cCRUD;
        
    // Views
    private CandyManagement canManagement;
    private PopupMessage popup;
    
    // Controllers
    private ControllerMainMenu contMainMenu;    
    
    // Librerías de soporte
    private SupportFunctions support;   
    
    // Variables del usuario.    
    private String  rolUser,
                    nameUser,
                    branchUser;   
    // Variables para CRUD de Candy.
    private String id, name, descr;
    private int auxa;

    private double price;
    private char estatus;
    
    //</editor-fold>    
    
    /**
     * Constructor del gestor de sucursales.
     * @param rolUser Rol del usuario que ha ingresado al sistema.
     * @param nameUser Nombre del usuario que ha ingresado al sistema.
     * @param branchUser Nombre de la sucursal del usuario que ha ingresado al sistema.
     */
    public ControllerCandyManagement(String rolUser, String nameUser, String branchUser){
        
        // Declarar la variable de las clases instanciadas.
        canManagement   = new CandyManagement();
        support         = new SupportFunctions();  
        
        // Se inicializan las variables.
        this.rolUser    = rolUser;
        this.nameUser   = nameUser;
        this.branchUser = branchUser;
        
        // Se muestra la primera pantalla.
        canManagement.lblSucursalName.setText(branchUser);
        support.cardSelection(canManagement.panContainerCandy, canManagement.panConsultList);
        loadCandyTable();
        // Se habilitan o deshabilitan los botónes según tipo de usuario.
        //typeUser(this.rolUser);
        
        
        // Se inicializan las variables.
        clearVariables();
        
        // Activamos los eventos por las views.
        canManagement.addEvents(this);
        canManagement.addMouseEvents(this);
        
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
        else if(evt.getSource() == canManagement.btnSearchCandy){
            
            // Si no se ingresó información para filtrar.
            if  ((canManagement.txtSearchIdCandy.getText().equals("") || 
                    canManagement.txtSearchIdCandy.getText().equals("Código de la Golosina")))
                    popup = new PopupMessage(canManagement, true, 1, "Debe ingresar al menos un dato para filtrar.");
            
            // Si al menos se ingresó algún dato para filtrar.
            else
                loadCandyTable();
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Branch Table Clear ">
        
        // Limpiar el consultar listado.
        else if(evt.getSource() == canManagement.btnClearSearchCandy ){
            
            canManagement.cleaCandySearch();
            
            loadCandyTable();
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Back to Consult List ">
        
        // Para volver a la view de consulta.
        else if(evt.getSource() == canManagement.btnBackCandy ){
            
            // Se validan todos los campos.
            if(!canManagement.txtIdCandy.getText().equals("Código de la Golosina") && 
                    !canManagement.txtIdCandy.getText().equals("") &&
                    !canManagement.txtNameCandy.getText().equals("Nombre de la Golosina") &&
                    !canManagement.txtNameCandy.getText().equals("") &&
                    !canManagement.txtDescriptionCandy.getText().equals("Descripción") &&
                    !canManagement.txtDescriptionCandy.getText().equals("") &&
                    !canManagement.txtPriceCandy.getText().equals("Precio de la Golosina")){
                
                // Se pregunta al usuario si desea abandonar la consulta.
                SelectOption select = new SelectOption(canManagement, true, 1, 
                        "¿Está seguro que desea abandonar la consulta?", "Si", "No");
                
                // Si la respuesta es afirmativa.
                if(select.getOpc()){
                    
                    // Se muestra la vista del CRUD.
                    support.cardSelection(canManagement.panContainerCandy, canManagement.panConsultList);
                    
                    // Se cargan las sucursales.
                    loadCandyTable();
                    
                    // Se inicializan las variables.
                    clearVariables();
                                        
                }    
                   
            }
            
            // Si no hay campos modificados.
            else{
                
                // Se muestra la vista del CRUD.
                support.cardSelection(canManagement.panContainerCandy, canManagement.panConsultList);
                    
                // Se cargan las sucursales.
                loadCandyTable();
                
                // Se inicializan las variables.
                clearVariables();
                
            }
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Clear form ">
        
        // Si se desea limpiar un empleado.
        else if(evt.getSource() == canManagement.btnClearCandy){
            
            if(id.equals(""))
                canManagement.clearView();
            else{
                
                // Se muestran los datos obtenidos.
                canManagement.txtIdCandy.setText(id);
                canManagement.txtNameCandy.setText(name);
                canManagement.txtDescriptionCandy.setText(descr);
                canManagement.txtPriceCandy.setText(String.valueOf(price));
                
            }
                
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Register or Update Branch ">
        
        // Registro o Modificación de sucursal.
        else if(evt.getSource() == canManagement.btnRegisterModifyCandy){
            
            /**
             * Si la variable global 'id' se encuentra vacía, se tiene que el caso
             * es un registro.
             */
            if(id.equals("")){
                
            // De no haber campos vacíos.
            if(!canManagement.txtIdCandy.getText().equals("Código de la Golosina") && 
                    !canManagement.txtIdCandy.getText().equals("") &&
                    !canManagement.txtNameCandy.getText().equals("Nombre de la Golosina") &&
                    !canManagement.txtNameCandy.getText().equals("") &&
                    !canManagement.txtDescriptionCandy.getText().equals("Descripción") &&
                    !canManagement.txtDescriptionCandy.getText().equals("") &&
                    !canManagement.txtPriceCandy.getText().equals("Precio de la Golosina")){
                
                        // Se confirma que se desea registrar la sucursal
                        SelectOption select = new SelectOption(canManagement, true, 2, 
                                "¿Desea registrar esta golosina?", "Si", "No");

                        // Si se confirma el registro.
                        if(select.getOpc()){

                            // Si la sucursal ya existe pero se encuentra inactivo.
                            if(cCRUD.candyExist(canManagement.txtIdCandy.getText(), 'I')){
                                
                                // Se cambia el estado de la sucursal a activo.
                                cCRUD.DeleteCandy(canManagement.txtIdCandy.getText(), 1);
                                
                                // Se actualiza la información del empleado.
                                updateCandyData(canManagement.txtIdCandy.getText());
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(canManagement.panContainerCandy, canManagement.panConsultList);

                                // Se cargan los empleados.
                                loadCandyTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                                
                            }
                            
                            // Si el usuario no existe.
                            else{
                            
                                // Se ejecuta el registro de información.
                                registerCandyData();
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(canManagement.panContainerCandy, canManagement.panConsultList);

                                // Se cargan las sucursales.
                                loadCandyTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                            }
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(canManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
      
                
            }
            
            /**
             * Si la variable global 'id' posee algún dato, se tiene el caso de modificación
             * de un registro.
             */
            else{
                
                // De no haber campos vacíos.
                if(!canManagement.txtIdCandy.getText().equals("Código de la Golosina") && 
                    !canManagement.txtIdCandy.getText().equals("") &&
                    !canManagement.txtNameCandy.getText().equals("Nombre de la Golosina") &&
                    !canManagement.txtNameCandy.getText().equals("") &&
                    !canManagement.txtDescriptionCandy.getText().equals("Descripción") &&
                    !canManagement.txtDescriptionCandy.getText().equals("") &&
                    !canManagement.txtPriceCandy.getText().equals("Precio de la Golosina")){
                
                        // Se confirma que se desea eliminar el registro.
                        SelectOption select = new SelectOption(canManagement, true, 2, 
                                "¿Desea actualizar los datos de esta golosina?", "Si", "No");

                        // Si se confirma la actualización.
                        if(select.getOpc()){

                            // Se ejecuta la actualización de información.
                            updateCandyData(id);

                            // Se muestra la vista del CRUD.
                            support.cardSelection(canManagement.panContainerCandy, canManagement.panConsultList);
                            // Se cargan las sucursales.
                            loadCandyTable();
                            // Se inicializan las variables.
                            clearVariables();
                            
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(canManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
                                    
            }
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Delete Branch ">
        
        // Eliminación de una sucursal.
        else if(evt.getSource() == canManagement.btnDeleteCandy){
            
            // Se pregunta al usuario si desea realmente eliminar la sucursal.
            SelectOption select = new SelectOption(canManagement, true, 2, 
                    "¿Está seguro que desea eliminar esta sucursal?", "Si", "No");
            
            // Si la respuesta es afirmativa.
            if(select.getOpc())
            {
                checkCandyInventory(id);
                if(auxa>0)
                {
                popup = new PopupMessage(canManagement, true, 1, "No se puede eliminar la golosina porque existen inventarios con esta golosina");
                }
                else
                {
                // Se realiza la eliminación lógica.
                cCRUD.DeleteCandy(id, 0);
                
                // Se muestra un mensaje de eliminación exitosa.
                popup = new PopupMessage(canManagement, true, 4, "La golosina se ha eliminado con éxito.");
                
                // Se muestra la vista del CRUD.
                support.cardSelection(canManagement.panContainerCandy, canManagement.panConsultList);
                    
                // Se cargan los empleados.
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
        if(evt.getSource() == canManagement.tblCandyList){
                                              
            // Se obtienen los valores de la fila y columna seleccionada.
            int column = canManagement.getColumnTable(), row = canManagement.getRowTable();

            // Se valida que el evento del Mouse fue provocado dentro del JTable.
            if(row < canManagement.tblCandyList.getRowCount() && row >= 0 && 
                    column < canManagement.tblCandyList.getColumnCount() && column >= 0){
                
                // Se obtiene el valor de la celda seleccionada.
                Object value = canManagement.tblCandyList.getValueAt(row, column);
                
                // Si el valor de la celda seleccionada es un JButton;
                if(value instanceof JButton){
                    
                    ((JButton)value).doClick();
                    
                    JButton btn = (JButton) value;

                    //<editor-fold defaultstate="collapsed" desc=" Proceso para consultar una golosina ">
                    
                    // Si el JButton se llama "s";
                    if(btn.getName().equals("s")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                                      
                        // Se obtiene el modelo de la JTable.
                        DefaultTableModel dtm = (DefaultTableModel) canManagement.tblCandyList.getModel();
                                                
                        // Se obtiene el id de la sucursal en cuestión.
                        String idCandy = dtm.getValueAt(row, 0).toString();
                        
                        // Se buscan los datos del empleado.
                        loadCandy(idCandy);
              
                        // Se muestra la vista del CRUD.
                        support.cardSelection(canManagement.panContainerCandy, canManagement.panCRUD);
                        
                        // Se desbloquea el botón de 'eliminar'.
                        canManagement.btnDeleteCandy.setEnabled(true);
                        
                        // Se configura el texto del botón.
                        canManagement.btnRegisterModifyCandy.setText("Modificar");
                        
                        // Se limpian todos los aspectos visuales.
                        canManagement.clearView();
                                                
                        // Se muestran los datos obtenidos.
                        canManagement.txtIdCandy.setText(id);
                        canManagement.txtNameCandy.setText(name);
                        canManagement.txtDescriptionCandy.setText(descr);
                        canManagement.txtPriceCandy.setText(String.valueOf(price));

                        
                        // Se bloquea el campo de codigo.
                        canManagement.txtIdCandy.setEnabled(false);
                        
                    }
                    
                    //</editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc=" Proceso para crear una golosina ">
                    
                    // Si el JButton se llama "i";
                    if(btn.getName().equals("i")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                                     
                        // Se muestra la vista del CRUD.
                        support.cardSelection(canManagement.panContainerCandy, canManagement.panCRUD);
                        
                        // Se bloquea el botón de 'eliminar'.
                        canManagement.btnDeleteCandy.setEnabled(false);
                        
                        // Se desbloquea el campo de codigo.
                        canManagement.txtIdCandy.setEnabled(true);
                                                
                        // Se configura el texto del botón.
                        canManagement.btnRegisterModifyCandy.setText("Registrar");
                        
                        // Se limpian todos los aspectos visuales.
                        canManagement.clearView();
                        
                        // Se limpian las variables
                        clearVariables();
                        
                        
                        
                    }
                        
                    //</editor-fold>
                    
                }
            }

        }
        
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Métodos para el funcionamiento del Controller ">

    
        private void checkCandyInventory(String idA)
     {
         auxa=0;
        java.sql.ResultSet result;
        String aux="";
        try {
            result = cCRUD.readContCandyInventory(idA);
            while(result.next()){                
            aux = result.getString("cantidadGolosinas");
                }
            auxa = Integer.parseInt(aux);
            System.out.println("Cantidad de golosinas " + aux + ";");
        } 
        catch (SQLException ex) {
            Logger.getLogger(ControllerBranchManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
    
    
        /**
     * Método para buscar una sucursal
     * @return Listado de nombres de ciudades.
     */
    private void loadCandy(String idCandy){
        
        // Se instancia la clase a utilizar.
        cCRUD = new CandyCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
                
        try {
            result = cCRUD.readCandyData(idCandy);
            while(result.next()){
                id = result.getString("codigo");
                descr = result.getString("descripcion");
                name = result.getString("nombre");
                price = result.getDouble("precio");
            }
            
            System.out.println("Éxito.");
                        
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
                
    }
        
    /**
     * Método para construir la sentencia de búsqueda de la sucursal.
     * @return Sentencia SQL.
     */
    private String buildSentenceSQL(){
        
        // Se declaran e inicializan las variables que servirán para buscar la sucursal.
        String  initSQL     = "SELECT \"codigo\", \"nombre\", \"descripcion\", "
                                    + "\"precio\" "
                                    + "FROM \"golosinas\" WHERE \"estado\" = 'A'",
                finalSQL    = ";",
                idSQL       = " AND \"codigo\" = ",
                SQL         = "";
         
        // Se inicia la sentencia SQL;
        SQL += initSQL;
        // Si se ingresó el codigo de la sucursal
        if(!canManagement.txtSearchIdCandy.getText().equals("Código de la Golosina") && 
           !canManagement.txtSearchIdCandy .getText().equals(""))
            SQL += idSQL + "'" + canManagement.txtSearchIdCandy.getText() + "'";
        /*        
        // Si se ingresó el nombre de la golosina.
        if(!canManagement.txtSearchNameBranch.getText().equals("") &&
           !canManagement.txtSearchNameBranch.getText().equals("Nombre de la sucursal")){
            SQL += nameSQL + "'" + canManagement.txtSearchNameBranch.getText() + "'";
                                
        }*/
        return SQL += finalSQL;
    }

    
        /**
     * Método para cargar la información de la sucursal.
     * @return listado con la información de la sucursal.
     */
    private void loadCandyTable(){
                
        // Se instancia la clase a utilizar.
        cCRUD = new CandyCRUD(); 
        // Se declaran los arreglos a utilizar
        ArrayList<String>   idCandy         = new ArrayList<>(),
                            namesCandy     = new ArrayList<>(),
                            descriptionCandy = new ArrayList<>(),
                            priceCandy     = new ArrayList<>();
                
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            
            // Se realiza la búsqueda de empleados.
            result = cCRUD.readCandys(buildSentenceSQL());
            
            // Se obtienen los resultados.
            while(result.next()){
                
                idCandy.add(result.getString("codigo"));
                namesCandy.add(result.getString("nombre"));
                descriptionCandy.add(result.getString("descripcion"));
                priceCandy.add(result.getString("precio"));
                                   
            }
            
            System.out.println("Carga exitosa. Cantidad de las golocinas encontradas: " + idCandy.size());
            
            // Se obtuvo al menos un resultado.
            if(idCandy.size() > 0){
                
                // Se limpia la tabla de empleados.
                canManagement.clearBranchTable(canManagement.tblCandyList);
                
                // Se obtiene el modelo de la tabla de empleados.
                DefaultTableModel dtm = (DefaultTableModel) canManagement.tblCandyList.getModel();

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
                for(int i = 0; i < idCandy.size(); i++){

                    dtm.addRow(new Object[]{
                        idCandy.get(i),
                        namesCandy.get(i),
                        descriptionCandy.get(i),
                        priceCandy.get(i),
                        btnR
                    });

                }
            }
            
            // No se obtuvo ningún resultado.
            else
                popup = new PopupMessage(canManagement, true, 1, "No se encontraron golosinas.");
                            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }   
    
    /**
     * Método para registrar una nueva golosina.
     */
    private void registerCandyData(){
                        
        // Se carga la nueva información del golosina.
        candy = new Candy(canManagement.txtIdCandy.getText(), 
                                    canManagement.txtNameCandy.getText(), 
                                    canManagement.txtDescriptionCandy.getText(), 
                                    Double.parseDouble(canManagement.txtPriceCandy.getText()),  
                                    'A');
        // Se ejecuta el registro de datos.
        cCRUD.registerCandy(candy);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(canManagement, true, 4, 
                "La sucursal se ha registrado con éxito");
        
    }    
    /**
     * Método para actualizar la información de la golosina.
     * @param id codigo de la golosina a actualizar.
     */
    private void updateCandyData(String id){
        // Se carga la nueva información de la sucursal.
        candy = new Candy(canManagement.txtIdCandy.getText(), 
                                    canManagement.txtNameCandy.getText(), 
                                    canManagement.txtDescriptionCandy.getText(), 
                                    Double.parseDouble(canManagement.txtPriceCandy.getText()),  
                                    'A');
        // Se ejecuta la actualización de datos.
        cCRUD.UpdateCandy(candy, id);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(canManagement, true, 4, 
                "Los datos de la golosina se han actualizado con éxito.");
        
    }
    
    
     /**
     * Método para limpiar las variables.
     */
    private void clearVariables()
    {   
        id          = "";
        name        = "";
        descr       = "";
        price       =0.0;
        estatus     ='A';
    }
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
