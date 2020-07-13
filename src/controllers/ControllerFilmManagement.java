/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;
// Se importan las librerías de soporte.
import lib.SupportFunctions;

// Se importan los models a utilizar.
import models.Film;
import models.database.FilmCRUD;
//import models.database.BranchCRUD;
//import models.database.CityCRUD;

// Se importan las views a utilizar.
import views.FilmManagement;
//import views.ChangeBranch;
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
public class ControllerFilmManagement implements ActionListener, MouseListener{
     //<editor-fold defaultstate="collapsed" desc=" Declaración de variables ">
    
    // Models
    private Film film;
        // Models.database
        private FilmCRUD filmCRUD;
       // private BranchCRUD braCRUD;
        //private CityCRUD citCRUD;
    
    // Views
    private FilmManagement filmManagement;
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
                    synopsis,
                    duration,
                    type,
                    classification;
    
    //private char    classification;
    
    private Date    premiere;
                    
    
    //</editor-fold>

    /**
     * Constructor del gestor de peliculas.
     * @param rolUser Rol del usuario que ha ingresado al sistema.
     * @param nameUser Nombre del usuario que ha ingresado al sistema.
     * @param branchUser Nombre de la sucursal del usuario que ha ingresado al sistema.
     */
    public ControllerFilmManagement(String rolUser, String nameUser, String branchUser){
        
        // Declarar la variable de las clases instanciadas.
        filmManagement   = new FilmManagement();
        support         = new SupportFunctions();
        
        // Se inicializan las variables.
        this.rolUser    = rolUser;
        this.nameUser   = nameUser;
        this.branchUser = branchUser;
        
        // Se muestra la primera pantalla.
        support.cardSelection(filmManagement.panContainerFilm, filmManagement.panConsultList);
        
        // Se cargan los empleados.
        loadFilmTable();
        
        // Se habilitan o deshabilitan los botónes según tipo de usuario.
        //enabledButtons(this.rolUser);
        
        // Se inicializan las variables.
        clearVariables();
        
        // Activamos los eventos por las views.
        filmManagement.addEvents(this);
        filmManagement.addMouseEvents(this);
        
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
        if(evt.getSource() == filmManagement.btnMin){
            filmManagement.setExtendedState(java.awt.Frame.ICONIFIED);
            filmManagement.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir de la aplicación.
        else if(evt.getSource() == filmManagement.btnExit){
            filmManagement.dispose();
        } 
        
        //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc=" Branch Change ">
        
        // Cambiar de sucursal a gestionar
       /* else if(evt.getSource() == empManagement.btnChangeBranch){
            
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
        
    //<editor-fold defaultstate="collapsed" desc=" Film Search ">
        
        // Buscar a un empleado.
        else if(evt.getSource() == filmManagement.btnSearchFilm){
            
            // Si no se ingresó información para filtrar.
            if  ((filmManagement.txtSearchIdFilm.getText().equals("") || 
                    filmManagement.txtSearchIdFilm.getText().equals("Codigo de la película")) &&
                (filmManagement.txtSearchNameFilm.getText().equals("") ||
                    filmManagement.txtSearchNameFilm.getText().equals("Nombre de la película")) &&
                (filmManagement.cmbSearchCensureFilm.getSelectedIndex() == 0))
                    popup = new PopupMessage(filmManagement, true, 1, "Debe ingresar al menos un dato para filtrar.");
            
            // Si al menos se ingresó algún dato para filtrar.
            else
                loadFilmTable();
                
        }
        
        //</editor-fold>
    
   //<editor-fold defaultstate="collapsed" desc=" Film Table Clear ">
        
        // Limpiar el consultar listado.
        else if(evt.getSource() == filmManagement.btnClearSearchFilm){
            
            filmManagement.clearFilmSearch();
            
            loadFilmTable();
            
        }
        
        //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Back to Consult List ">
        
        // Para volver a la view de consulta.
        else if(evt.getSource() == filmManagement.btnBackFilm){
            
            // Se validan todos los campos.
            if(!filmManagement.txtIdFilm.getText().equals("Codigo de la película") && 
                    !filmManagement.txtIdFilm.getText().equals("") &&
                    !filmManagement.txtNameFilm.getText().equals("Nombre de la película") &&
                    !filmManagement.txtNameFilm.getText().equals("") &&
                    !filmManagement.txtSynopsisFilm.getText().equals("Sinopsis de la película") &&
                    !filmManagement.txtSynopsisFilm.getText().equals("") &&
                    !filmManagement.txtDurationFilm.getText().equals("Duración de la película") &&
                    !filmManagement.txtDurationFilm.getText().equals("") &&
                    !filmManagement.txtTypeFilm.getText().equals("Género de la película") &&
                    !filmManagement.txtTypeFilm.getText().equals("") &&
                    filmManagement.cmbCensureFilm.getSelectedIndex() != 0){
                
                // Se pregunta al usuario si desea abandonar la consulta.
                SelectOption select = new SelectOption(filmManagement, true, 1, 
                        "¿Está seguro que desea abandonar la consulta?", "Si", "No");
                
                // Si la respuesta es afirmativa.
                if(select.getOpc()){
                    
                    // Se muestra la vista del CRUD.
                    support.cardSelection(filmManagement.panContainerFilm, filmManagement.panConsultList);
                    
                    // Se cargan los empleados.
                    loadFilmTable();
                    
                    // Se inicializan las variables.
                    clearVariables();
                                        
                }    
                   
            }
            
            // Si no hay campos modificados.
            else{
                
                // Se muestra la vista del CRUD.
                support.cardSelection(filmManagement.panContainerFilm, filmManagement.panConsultList);
                    
                // Se cargan los empleados.
                loadFilmTable();
                
                // Se inicializan las variables.
                clearVariables();
                
            }
                
        }
        
        //</editor-fold>
        
   //<editor-fold defaultstate="collapsed" desc=" Clear form ">
        
        // Si se desea limpiar un empleado.
        else if(evt.getSource() == filmManagement.btnClearFilm){
            
            if(id.equals(""))
                filmManagement.clearView();
            else{
                
                // Se muestran los datos obtenidos.
                filmManagement.txtIdFilm.setText(id);
                //filmManagement.cmbBranchEmployee.setSelectedItem(branch);
                filmManagement.txtNameFilm.setText(name);
                filmManagement.txtSynopsisFilm.setText(synopsis);
                filmManagement.txtDurationFilm.setText(duration);
                filmManagement.txtTypeFilm.setText(type);
                filmManagement.dchPremiereFilm.setDate(premiere);
                filmManagement.cmbCensureFilm.setSelectedItem(classification);
                
            }
                
        }
        
        //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Register or Update Film ">
        
        // Registro o Modificación de pelicula.
        else if(evt.getSource() == filmManagement.btnRegisterModifyFilm){
            
            /**
             * Si la variable global 'id' se encuentra vacía, se tiene que el caso
             * es un registro.
             */
            if(id.equals("")){
                
                
                // De no haber campos vacíos.
                if( !filmManagement.txtIdFilm.getText().equals("") && 
                    !filmManagement.txtIdFilm.getText().equals("Codigo de la película") && 
                    !filmManagement.txtNameFilm.getText().equals("") &&
                    !filmManagement.txtNameFilm.getText().equals("Nombre de la película") &&
                    !filmManagement.txtSynopsisFilm.getText().equals("") &&
                    !filmManagement.txtSynopsisFilm.getText().equals("Sinopsis de la película") &&
                    !filmManagement.txtDurationFilm.getText().equals("") &&
                    !filmManagement.txtDurationFilm.getText().equals("Duración de la película") &&
                    !filmManagement.txtTypeFilm.getText().equals("") &&
                    !filmManagement.txtTypeFilm.getText().equals("Género de la película") &&
                     filmManagement.cmbCensureFilm.getSelectedIndex() != 0){
                
                        // Se confirma que se desea eliminar el registro.
                        SelectOption select = new SelectOption(filmManagement, true, 2, 
                                "¿Desea registrar esta película?", "Si", "No");

                        // Si se confirma el registro.
                        if(select.getOpc()){

                            // Si el empleado ya existe pero se encuentra inactivo.
                            if(filmCRUD.filmExist(filmManagement.txtIdFilm.getText(), 'I')){
                                
                                // Se cambia el estado del empleado a activo.
                                filmCRUD.DeleteFilm(filmManagement.txtIdFilm.getText(), 1);
                                
                                // Se actualiza la información del empleado.
                                updateFilmData(filmManagement.txtIdFilm.getText());
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(filmManagement.panContainerFilm, filmManagement.panConsultList);

                                // Se cargan los empleados.
                                loadFilmTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                            }
                            
                            // Si el usuario no existe.
                            else{
                            
                                // Se ejecuta el registro de información.
                                registerFilmData();
                                
                                // Se muestra la vista del CRUD.
                                support.cardSelection(filmManagement.panContainerFilm, filmManagement.panConsultList);

                                // Se cargan los empleados.
                                loadFilmTable();

                                // Se inicializan las variables.
                                clearVariables();
                                
                            }
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(filmManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
      
                
            }
            
            /**
             * Si la variable global 'id' posee algún dato, se tiene el caso de modificación
             * de un registro.
             */
            else{
                
                // De no haber campos vacíos.
                if( !filmManagement.txtIdFilm.getText().equals("") && 
                    !filmManagement.txtIdFilm.getText().equals("Codigo de la película") && 
                    !filmManagement.txtNameFilm.getText().equals("") &&
                    !filmManagement.txtNameFilm.getText().equals("Nombre de la película") &&
                    !filmManagement.txtSynopsisFilm.getText().equals("") &&
                    !filmManagement.txtSynopsisFilm.getText().equals("Sinopsis de la película") &&
                    !filmManagement.txtDurationFilm.getText().equals("") &&
                    !filmManagement.txtDurationFilm.getText().equals("Duración de la película") &&
                    !filmManagement.txtTypeFilm.getText().equals("") &&
                    !filmManagement.txtTypeFilm.getText().equals("Género de la película") &&
                     filmManagement.cmbCensureFilm.getSelectedIndex() != 0){
                
                        // Se confirma que se desea eliminar el registro.
                        SelectOption select = new SelectOption(filmManagement, true, 2, 
                                "¿Desea actualizar los datos de esta película?", "Si", "No");

                        // Si se confirma la actualización.
                        if(select.getOpc()){

                            // Se ejecuta la actualización de información.
                            updateFilmData(id);
                            
                            // Se muestra la vista del CRUD.
                            support.cardSelection(filmManagement.panContainerFilm, filmManagement.panConsultList);

                            // Se cargan los empleados.
                            loadFilmTable();

                            // Se inicializan las variables.
                            clearVariables();
                            
                        }
                    
                }
                
                // Si hay campos vacíos.
                else
                    // Se muestra mensaje solicitando datos.
                    popup = new PopupMessage(filmManagement, true, 1, 
                            "Debe ingresar datos en los campos solicitados.");
                                    
            }
            
        }
        
        //</editor-fold>
        
     //<editor-fold defaultstate="collapsed" desc=" Delete Film ">
        
        // Eliminación de un empleado.
        else if(evt.getSource() == filmManagement.btnDeleteFilm){
            
            // Se pregunta al usuario si desea realmente eliminar al empleado.
            SelectOption select = new SelectOption(filmManagement, true, 2, 
                    "¿Está seguro que desea eliminar esta película?", "Si", "No");
            
            // Si la respuesta es afirmativa.
            if(select.getOpc()){
                
                // Se realiza la eliminación lógica.
                filmCRUD.DeleteFilm(id, 0);
                
                // Se muestra un mensaje de eliminación exitosa.
                popup = new PopupMessage(filmManagement, true, 4, "La película se ha eliminado con éxito.");
                
                // Se muestra la vista del CRUD.
                support.cardSelection(filmManagement.panContainerFilm, filmManagement.panConsultList);
                    
                // Se cargan los empleados.
                loadFilmTable();
                    
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
         // Si se hace click sobre la tabla de empleados.
        if(evt.getSource() == filmManagement.tblFilmList){
                                              
            // Se obtienen los valores de la fila y columna seleccionada.
            int column = filmManagement.getColumnTable(), row = filmManagement.getRowTable();

            // Se valida que el evento del Mouse fue provocado dentro del JTable.
            if(row < filmManagement.tblFilmList.getRowCount() && row >= 0 && 
                    column < filmManagement.tblFilmList.getColumnCount() && column >= 0){
                
                // Se obtiene el valor de la celda seleccionada.
                Object value = filmManagement.tblFilmList.getValueAt(row, column);
                
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
                        DefaultTableModel dtm = (DefaultTableModel) filmManagement.tblFilmList.getModel();
                                                
                        // Se obtiene el id del empleado en cuestión.
                        String idFilm = dtm.getValueAt(row, 0).toString();
                        
                        // Se buscan los datos del empleado.
                        loadFilm(idFilm);
                        
                        // Se crea la variable de formato de fechas.
                        SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
                       /*                
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
                         */                           
                        // Se muestra la vista del CRUD.
                        support.cardSelection(filmManagement.panContainerFilm, filmManagement.panCRUD);
                        
                        // Se bloquea el botón de 'eliminar'.
                        filmManagement.btnDeleteFilm.setEnabled(true);
                        
                        // Se configura el texto del botón.
                        filmManagement.btnRegisterModifyFilm.setText("Modificar");
                        
                        // Se limpian todos los aspectos visuales.
                        filmManagement.clearView();
                                                
                        // Se muestran los datos obtenidos.
                        filmManagement.txtIdFilm.setText(id);
                        filmManagement.txtNameFilm.setText(name);
                        filmManagement.txtSynopsisFilm.setText(synopsis);
                        filmManagement.txtDurationFilm.setText(duration);
                        filmManagement.txtTypeFilm.setText(type);
                        filmManagement.dchPremiereFilm.setDate(premiere);
                        filmManagement.cmbCensureFilm.setSelectedItem(classification);
                        
                        // Se bloquea el campo de codigo.
                        filmManagement.txtIdFilm.setEnabled(false);
                        
                    }
                    
                    //</editor-fold>
                    
                    //<editor-fold defaultstate="collapsed" desc=" Proceso para crear un empleado ">
                    
                    // Si el JButton se llama "i";
                    if(btn.getName().equals("i")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                                     
                        // Se muestra la vista del CRUD.
                        support.cardSelection(filmManagement.panContainerFilm, filmManagement.panCRUD);
                        
                        // Se bloquea el botón de 'eliminar'.
                        filmManagement.btnDeleteFilm.setEnabled(true);
                        
                        // Se configura el texto del botón.
                        filmManagement.btnRegisterModifyFilm.setText("Registrar");
                        
                        // Se limpian todos los aspectos visuales.
                        filmManagement.clearView();
                        
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
   /* private void enabledButtons(String rol){
        
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
     * Método para cargar todas ciudades.
     * @return Listado de nombres de ciudades.
     */
    private void loadFilm(String idFilm){
        
        // Se instancia la clase a utilizar.
        filmCRUD = new FilmCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
                
        try {
            result = filmCRUD.readFilmData(idFilm);
            while(result.next()){
                id = result.getString("codigo");
                name = result.getString("nombre");
                synopsis = result.getString("sinopsis");
                duration = result.getString("duracion");
               // phone = result.getLong("telefono");
                type = result.getString("genero");
                premiere = result.getDate("fecha_estreno");
                classification = result.getString("clasificacion");
                
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
   /* private void loadBranch(ArrayList<String> firstList, ArrayList<String> secondList){
        
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
    /*private ArrayList<String> loadCityNames(){
        
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
     * Método para construir la sentencia de búsqueda de la pelicula.
     * @return Sentencia SQL.
     */
    private String buildSentenceSQL(){
        
        // Se declaran e inicializan las variables que servirán para buscar peliculas.
        String  initSQL     = "SELECT \"codigo\", \"nombre\", \"sinopsis\", \"duracion\", \"clasificacion\", \"fecha_estreno\", \"genero\""      
                                    + "FROM \"pelicula\" WHERE \"estado\" = 'A'",
                finalSQL    = ";",
                nameSQL     = " AND \"nombre\" = ",
                synopsisSQL = " AND \"sinopsis\" = ",
                idSQL       = " AND \"codigo\" = ",
                censureSQL      = " AND \"clasificacion\" = ",
                durationSQL   = " AND \"duracion\" = ",
                premiereSQL   = " AND \"fecha_estreno\" = ",
                typeSQL   = " AND \"genero\" = ",
                SQL         = "";
         
        // Se inicia la sentencia SQL;
        SQL += initSQL;
        
        // Si se ingresó el codigo de una pelicula.
        if(!filmManagement.txtSearchIdFilm.getText().equals("Codigo de la película") && 
                !filmManagement.txtSearchIdFilm.getText().equals(""))
            SQL += idSQL + "'" + filmManagement.txtSearchIdFilm.getText() + "'";
                
        // Si se ingresó el nombre de una pelicula.
        if(!filmManagement.txtSearchNameFilm.getText().equals("") &&
                !filmManagement.txtSearchNameFilm.getText().equals("Nombre de la película"))
                SQL += idSQL + "'" + filmManagement.txtSearchNameFilm.getText() + "'";    
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
         */
        // Si se ingresó la censura de la pelicula.
        if(filmManagement.cmbSearchCensureFilm.getSelectedIndex() != 0)
            SQL += censureSQL + "'" + filmManagement.cmbSearchCensureFilm.getSelectedItem().toString() + "'";
          
        // Se culmina la sentencia.
        return SQL += finalSQL;
        
    }
    
    /**
     * Método para cargar la información de la pelicula.
     * @return listado con la información de la pelicula.
     */
    private void loadFilmTable(){
                
        // Se instancia la clase a utilizar.
        filmCRUD = new FilmCRUD();
        
        // Se declaran los arreglos a utilizar
        ArrayList<String>   idFilm      = new ArrayList<>(),
                            nameFilm   = new ArrayList<>(),
                            synopsisFilm   = new ArrayList<>(),
                            durationFilm   = new ArrayList<>(),
                             classificationFilm   = new ArrayList<>(),
                             premiereFilm  = new ArrayList<>(),
                            typeFilm     = new ArrayList<>();
                
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            
            // Se realiza la búsqueda de empleados.
            result = filmCRUD.readFilm(buildSentenceSQL());
            
            // Se obtienen los resultados.
            while(result.next()){
                
                idFilm.add(result.getString("codigo"));
               nameFilm.add(result.getString("nombre"));
                synopsisFilm.add(result.getString("sinopsis"));
                durationFilm.add(result.getString("duracion"));
                classificationFilm.add(result.getString("clasificacion"));
                premiereFilm.add(result.getString("fecha_estreno"));
                typeFilm.add(result.getString("genero"));
                                   
            }
            
            System.out.println("Carga exitosa. Cantidad de películas encontradas: " + idFilm.size());
            
            // Se obtuvo al menos un resultado.
            if(idFilm.size() > 0){
                
                // Se limpia la tabla de empleados.
                filmManagement.clearFilmTable(filmManagement.tblFilmList);
                
                // Se obtiene el modelo de la tabla de empleados.
                DefaultTableModel dtm = (DefaultTableModel) filmManagement.tblFilmList.getModel();

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
                    " . . . ",
                    btnI
                });
                
                // Se añaden todos los resultados obtenidos a la tabla.
                for(int i = 0; i < idFilm.size(); i++){

                    dtm.addRow(new Object[]{
                        idFilm.get(i),
                        nameFilm.get(i),
                        synopsisFilm.get(i),
                        durationFilm.get(i),
                        classificationFilm.get(i),
                        premiereFilm.get(i),
                        typeFilm.get(i),
                        btnR
                    });

                }
                                
            }
            
            // No se obtuvo ningún resultado.
            else
                popup = new PopupMessage(filmManagement, true, 1, "No se encontraron peliculas.");
                            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }
    
    /**
     * Método para registrar a un nuevo empleado.
     */
    private void registerFilmData(){
                        
        // Se carga la nueva información del empleado.
        Film film = new Film(filmManagement.txtIdFilm.getText(), 
                                    filmManagement.txtNameFilm.getText(), 
                                    filmManagement.txtSynopsisFilm.getText(), 
                                    //Long.valueOf(empManagement.txtPhoneEmployee.getText()), 
                                    filmManagement.txtDurationFilm.getText(), 
                                    filmManagement.txtTypeFilm.getText(), 
                                    filmManagement.cmbCensureFilm.getSelectedItem().toString(),
                                    'A',
                                    filmManagement.dchPremiereFilm.getDate());
        
        // Se ejecuta el registro de datos.
        filmCRUD.registerFilm(film);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(filmManagement, true, 4, 
                "La pelicula se ha registrado con éxito");
        
    }
    
    /**
     * Método para actualizar la información de un empleado.
     * @param id cédula del empleado a actualizar.
     */
    private void updateFilmData(String id){
                        
        // Se carga la nueva información del empleado.
        Film film = new Film(filmManagement.txtIdFilm.getText(), 
                                    filmManagement.txtNameFilm.getText(), 
                                    filmManagement.txtSynopsisFilm.getText(), 
                                    //Long.valueOf(empManagement.txtPhoneEmployee.getText()), 
                                    filmManagement.txtDurationFilm.getText(), 
                                    filmManagement.txtTypeFilm.getText(), 
                                    filmManagement.cmbCensureFilm.getSelectedItem().toString(),
                                    'A',
                                    filmManagement.dchPremiereFilm.getDate());
        
        // Se ejecuta la actualización de datos.
        filmCRUD.UpdateFilm(film, id);
        
        // Se muestra mensaje de éxito.
        popup = new PopupMessage(filmManagement, true, 4, 
                "Los datos de la pelicula se han actualizado con éxito.");
        
    }
    
    /**
     * Método para limpiar las variables.
     */
    private void clearVariables(){
        
        id          = "";
        name        = "";
        synopsis    = "";
        duration   = "";
        classification = "";
        premiere       = null;
        type         = "";
        
    }
    
    //</editor-fold>
    
    
 //<editor-fold defaultstate="collapsed" desc=" PROHIBIDO TOCAR ">
    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
