
package controllers;

// Se importan las views a utilizar
import views.Login;
import views.PopupMessage;

// Se importan los models a utilizar
import models.ConexionBD;

// Se importan las clases de soporte.
import lib.SuportFunctions;

/**
 *
 * @author Gustavo
 */
public class ControllerLogin implements java.awt.event.ActionListener {
    
    // Se declaran las clases a utilizar.
    private Login login;
    private PopupMessage popup;
    private ControllerForgotPass forgot;
    private ControllerMainMenu mainMenu;
    private ConexionBD con;
    
    // Se declaran clases de soporte.
    private SuportFunctions suport;
        
    // Constructor del Login
    public ControllerLogin(){
        
        // Se instancian las clases de soporte.
        suport = new SuportFunctions();
        
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
                if(suport.verifyEmail(email)){
                    
                    // Si el usuario y la contraseña son correctos.
                    if(signer(email, pass) == true){

                        // Se muestra quién ingresó al sistema.
                        System.out.println("El usuario '" + email + "' ha ingresado al"
                                + " sistema con la contraseña '" + pass + "'.");

                        // Se muestra un mensaje emergente de "Bienvenido".
                        popup = new PopupMessage(login, true, 4, 
                                "Bienvenido");

                        // Se oculta la view de Login.
                        login.dispose();

                        // Se instancia el Controlador de MainMenu.
                        mainMenu = new ControllerMainMenu();

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
     * Método para comprobar si el usuario que desea ingresar al sistema se 
     * encuentra registrado.
     * @param email correo electrónico del usuario.
     * @param pass contraseña del usuario.
     * @return variable booleana.
     */
    public boolean signer(String email, String pass){
        
        try{
            
            // Se instancia la clase para la conexión con la BD y se establece la conexión.
            con = new ConexionBD();
            con.conectar();
          
            // Se descrie la sentencia SQL.
            String SQL =    "SELECT * FROM public.\"Usuario\" WHERE \"Correo\" = '"
                            + email + "' AND \"Clave\" = '" + pass + 
                            "' AND \"Estado\" = '1';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            // Si se obtuvo un resultado (que tiene que ser único) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar el usuario. Error: " + ex);
        }
        
        // De no encontrarse ningún resultado, retorna 'false'.
        return false;
        
    }
    
}
