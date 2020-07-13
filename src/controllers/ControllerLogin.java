
package controllers;

// Se importan las views a utilizar
import java.util.ArrayList;
import views.Login;
import views.PopupMessage;

// Se importan los models a utilizar
import models.database.UserCRUD;

// Se importan las clases de soporte.
import lib.SupportFunctions;

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
public class ControllerLogin implements java.awt.event.ActionListener {
    
    // Se declaran las clases a utilizar.
    
        // Views
        private Login login;
        private PopupMessage popup;
        
        // Models
        private UserCRUD userCRUD;
        
        // Controllers
        private ControllerForgotPass forgot;
        private ControllerMainMenu mainMenu;
    
        
    // Se declaran clases de soporte.
    private SupportFunctions support;
        
    // Constructor del Login
    public ControllerLogin(){
        
        // Se instancian las clases de soporte.
        support = new SupportFunctions();
        userCRUD = new UserCRUD();
                
        // Se instancia la view de Login.
        login = new Login();
        
        // Se añaden los eventos.
        login.addEvents(this);
                
    }
    
    /**
     * Se describen los eventos provocados por las acciones de los botones.
     * @param evt parámetro que corresponde a la acción de los botónes.
     */
    public void actionPerformed(java.awt.event.ActionEvent evt){
        
        //<editor-fold defaultstate="collapsed" desc=" Botones de la Barra Superior ">
        
        // Minimizar aplicación.
        if(evt.getSource() == login.btnMin){
            login.setExtendedState(java.awt.Frame.ICONIFIED);
            login.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir de la aplicación.
        else if(evt.getSource() == login.btnExit){
            System.exit(0);
        } 

        //</editor-fold>
        
        // Botón limpiar; retorna los campos a sus valores iniciales.
        else if(evt.getSource() == login.btnClear){
            
            login.txtEmailField.setText("Ingrese su correo electrónico");
            login.pssPasswordField.setText("Ingrese su contraseña");
            login.tgbShowPass.setSelected(false);
            login.pssPasswordField.setEchoChar('*');
            
        }
        
        // Botón para ingresar al sistema.
        else if(evt.getSource() == login.btnOk){
                 
            // Se obtiene la contraseña ingresada.
            char[] password = login.pssPasswordField.getPassword();
            
            // Se obtienen los datos de tipo String.
            String  email   = login.txtEmailField.getText(),
                    pass    = new String(password); /*
                                                     * -> Se transforma la contraseña en String
                                                     *    por el hecho que esta se encuentra
                                                     *    encriptada por sí sola.
                                                     */
            
            // Si el contenido de los campos es igual a vacío o el mensaje predeterminado.
            if((email.isEmpty() || email.equals("Ingrese su correo electrónico")) || ( 
                pass.isEmpty() || pass.equals("Ingrese su contraseña"))){
                
                // Se muestra un mensaje emergente de "Datos faltantes".
                popup = new PopupMessage(login, true, 1, 
                        "Debe ingresar los datos correspondientes.");
                
            // Si todo está correcto, se accede al sistema.
            } else{
                                
                // Se verifica el formato del correo ingresado.
                if(support.verifyEmail(email)){
                    
                    // Si el usuario y la contraseña son correctos.
                    if(userCRUD.signer(email, pass) == true){
                        
                        // Se muestra quién ingresó al sistema.
                        System.out.println("El usuario '" + email + "' ha ingresado al"
                                + " sistema con la contraseña '" + pass + "'.");

                        // Se muestra un mensaje emergente de "Bienvenido".
                        popup = new PopupMessage(login, true, 4, 
                                "Bienvenido");
                        
                        ArrayList<String> support = new ArrayList<>();
                        
                        // Se obtienen los datos de acceso del usuario.
                        support = getDataAccess(email);
                        
                        System.out.println("Los datos de acceso del usuario son: " +
                                "Rol: " + support.get(1) + ". Nombre: " + support.get(0) + ". Sucursal: " + support.get(2));
                        
                        // Se oculta la view de Login.
                        login.dispose();

                        // Se instancia el Controlador de MainMenu.
                        mainMenu = new ControllerMainMenu(support.get(1), support.get(0), support.get(2));

                    } 
                    
                    // Si el usuario y/o la contraseña son incorrectos.
                    else{
                    
                        // Se muestra un mensaje emergente de "Datos faltantes".
                        popup = new PopupMessage(login, true, 1, 
                                "El correo electrónico o la contraseña son "
                                        + "incorrectos.");

                    }
                    
                }
                
                else{
                    
                    // Se muestra un mensaje emergente de "Datos faltantes".
                    popup = new PopupMessage(login, true, 1, 
                            "El correo electrónico no tiene un formato válido.");
                    
                }
                
            }
            
        }
        
        // ToggleButton para visualizar el campo de contraseña o ocultarlo (Según el caso).
        else if(evt.getSource() == login.tgbShowPass){
            
            // Si el toggleButton es seleccionado la contraseña será visible.
            if(login.tgbShowPass.isSelected())
                login.pssPasswordField.setEchoChar((char) 0);
            
            // Caso contrario; Si se deselecciona el toggleButton, se oculta la contraseña.
            else 
                login.pssPasswordField.setEchoChar('*');
        }
        
        // Si se ha olvidado la contraseña.
        else if(evt.getSource() == login.btnForgotPass){
            
            // Se instancia la clase para recuperar contraseña.
            forgot = new ControllerForgotPass();
            
        }
        
    }
     
    /**
     * Método para obtener los datos de acceso de un usuario.
     * @param email Correo electrónico del usuario que va a ingresar al sistema.
     */
    private ArrayList<String> getDataAccess(String email){
        
        // Se instancia la clase a utilizar.
        userCRUD = new UserCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        ArrayList<String> support = new ArrayList<>();
        
        try {
            result = userCRUD.getDataAccess(email);
            while(result.next()){
                support.add(result.getString("NombreEmpleado") + " " + result.getString("ApellidoEmpleado"));
                support.add(result.getString("CodigoRol"));
                support.add(result.getString("NombreSucursal"));
            }
                                    
            System.out.println("Éxito.");
            
            return support;
                                    
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
        return null;
        
    }
    
}
