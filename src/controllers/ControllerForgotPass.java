
package controllers;

// Se importan las librerías a utilizar.
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

// Se importan las librerías de apoyo.
import lib.SuportFunctions;

// Se importan los models a utilizar.
import models.ConexionBD;

// Se importan las views a utilizar.
import views.ForgotPass;
import views.PopupMessage;
import views.SelectOption;

/**
 *
 * @author Gustavo
 */
public class ControllerForgotPass implements java.awt.event.ActionListener{
    
    // Se declaran las clases a utilizar.
    private ForgotPass forgot;
    private PopupMessage popup;
    private SelectOption select;
    private SuportFunctions suport;
    private ConexionBD con;
    
    // Se declaran las variables a utilizar.
    String correo, codex;
    
    public ControllerForgotPass(){
    
        // Se instancia clase de soporte.
        suport = new SuportFunctions();
        
        // Se instancia view a utilizar.
        forgot = new ForgotPass();
        
        // Se activan los eventos de los botones.
        forgot.addEvents(this);
        
        // Se inicializan las variables.
        correo = null;
        codex = null;
                
    }
    
    public void actionPerformed(java.awt.event.ActionEvent evt){
        
        //<editor-fold defaultstate="collapsed" desc=" Botones de la Barra Superior ">
        
        // Minimizar aplicación.
        if(evt.getSource() == forgot.btnMin){
            forgot.setExtendedState(java.awt.Frame.ICONIFIED);
            forgot.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir de la aplicación.
        else if(evt.getSource() == forgot.btnExit){
            forgot.dispose();
        } 

        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" First Step ">
        
        // Botón limpiar; retorna los campos a sus valores iniciales.
        else if(evt.getSource() == forgot.btnClear1){
            
            forgot.txtEmailField.setText("Ingrese su correo electrónico");
            forgot.txtEmailField1.setText("Ingrese nuevamente su correo electrónico");
            
        }
        
        // Botón Aceptar; Correo electrónico
        else if(evt.getSource() == forgot.btnOk){
            
            String  email               = forgot.txtEmailField.getText(),
                    emailConfirmation   = forgot.txtEmailField1.getText();
            
            if((email.isEmpty() ^ emailConfirmation.isEmpty()) ^ 
                    ((email.equals("Ingrese su correo electrónico") ^ 
                    emailConfirmation.equals("Ingrese nuevamente su correo electrónico")))){
                
                popup = new PopupMessage(forgot, true, 1, "Debe ingresar los "
                        + "datos solicitados.");
                
            }
            
            else {
            
                if(email.equals(emailConfirmation) && signer(email)){
                
                    correo = email;
                    
                    System.out.println("El correo con código de confirmación está"
                            + " siendo preparado.");
                    
                    // Datos del usuario emisor.
                    String  from = "cinesdevenezuela.nacional@gmail.com",
                            pass = "cines1234venezuela";
                    
                    // Array de caracteres válidos para el código de confirmación.
                    char[] chars = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789".toCharArray();
                    
                    // StringBuilder de longitud '6'.
                    StringBuilder sb = new StringBuilder(6);
                    
                    // Instanciar clase Random.
                    Random random = new Random();
                    
                    // Ciclo para construir aleatoriamente el código de confirmación.
                    for (int i = 0; i < 6; i++) {
                        char c = chars[random.nextInt(chars.length)];
                        sb.append(c);
                    }
                    
                    // Obtener el código de confirmación.
                    codex = sb.toString();
                                 
                    // Se describen las propiedades de la sesión.
                    Properties props = new Properties();
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.port", "587");
                    
                    // Se instancia una nueva sesión.
                    Session session = Session.getInstance(props,
                            new Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(from, pass);
                                }
                            }
                    );
                            
                    try {
 
                        // Se describen los emisores, receptores, asunto y mensaje.
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(from));
                        message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(email));
                        message.setSubject("Código de confirmación para "
                                + "recuperar contraseña");
                        message.setText("El código de confirmación para poder "
                                + "recuperar tu contraseña es: " + codex);
 
                        // Se envía el mensaje.
                        Transport.send(message);
                        
                        System.out.println("El código " + codex + " ha sido "
                                + "enviado con éxito.");
                        
                        popup = new PopupMessage(forgot, true, 2, "El correo con el "
                            + "código de verificación ha sido enviado");
 
                    } catch (MessagingException ex) {
                        throw new RuntimeException(ex);
                    }
                    
                    // Se cambia la pantalla.
                    suport.cardSelection(forgot.panContent, forgot.panStepTwo);
                
                }   
            
                else{
                
                    popup = new PopupMessage(forgot, true, 1, "Los correos "
                            + "electrónicos no son iguales.");
                
                }
            }
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Second Step ">
        
        // Volver al paso anterior.
        else if(evt.getSource() == forgot.btnBackStepOne){
            
            select = new SelectOption(forgot, true, 2,
                    "¿Está seguro que desea volver al paso anterior?", null, null);
            
            if(select.getOpc() == true)
                suport.cardSelection(forgot.panContent, forgot.panStepOne);
            
        }
        
        else if(evt.getSource() == forgot.btnOk1){
            
            if(forgot.txtEmailField2.getText().isEmpty() ^ 
                    forgot.txtEmailField2.getText().equals("Ingresa código de "
                            + "verificación")){
                
                popup = new PopupMessage(forgot, true, 1, "Ingrese el código de "
                        + "confirmación");
                
            }
            
            else if (!forgot.txtEmailField2.getText().equals(codex)){
                
                popup = new PopupMessage(forgot, true, 1, "El código de "
                        + "confirmación es incorrecto.");
                
            }
            
            else{
                
                suport.cardSelection(forgot.panContent, forgot.panStepThree);
                
            }
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Third Step ">
        
        // Se limpian los campos.
        else if (evt.getSource() == forgot.btnClear2){
            
            forgot.pssPasswordField.setText("Ingrese su nueva contraseña");
            forgot.pssPasswordField1.setText("Ingrese su nueva contraseña");
            forgot.tgbShowPass.setSelected(false);
            forgot.pssPasswordField.setEchoChar('*');
            
        }
        
        // ToggleButton para visualizar el campo de contraseña o ocultarlo (Según el caso).
        else if(evt.getSource() == forgot.tgbShowPass){
            
            // Si el toggleButton es seleccionado la contraseña será visible.
            if(forgot.tgbShowPass.isSelected())
                forgot.pssPasswordField.setEchoChar((char) 0);
            
            // Caso contrario; Si se deselecciona el toggleButton, se oculta la contraseña.
            else 
                forgot.pssPasswordField.setEchoChar('*');
            
        }
        
        // Para actualizar las contraseñas.
        else if(evt.getSource() == forgot.btnOk2){
                           
            // Se otienen las contraseñas.
            char[] password = forgot.pssPasswordField.getPassword(),
                   confirm  = forgot.pssPasswordField1.getPassword();
            
            /* 
             * Se otienen sus variables de tipo String.
             * Se hace esta transformación debido a que las contraseñas de por
             * sí se encuentran encriptadas.
             */
            String  pass                = new String(password),
                    passConfirmation    = new String(confirm);
            
            // Se muestra en consola las contraseñas ingresadas.
            System.out.println("La primera contraseña es: " + pass + " mientras"
                    + " que la segunda es: " + passConfirmation);
            
            // Se comprueba de que las contraseñas sean iguales.
            if(suport.isPasswordCorrect(forgot.pssPasswordField.getPassword(), 
                    forgot.pssPasswordField1.getPassword())){
                
                // Se muestra el aviso de que las contraseñas son iguales.
                System.out.println("Contraseñas iguales. Se procede a actualizar.");
                
                // Se actualiza la contraseña.
                insertNewPass(correo, pass);
                
                // Se muestra mensaje de que la actualización fue exitosa.
                System.out.println("Al usuario " + correo + " se le ha actualizado "
                        + "su contraseña por " + pass + ".");
                
                // Se muestra en pantalla mensaje de que la actualización fue exitosa.
                popup = new PopupMessage(forgot, true, 4, 
                        "La contraseña ha sido actualizada.");
                
                // Se cierra pantalla.
                forgot.dispose();
                
            }
            // Si no se ha agregado ninguna contraseña
            else if((forgot.pssPasswordField.getPassword().toString().equals(
                    "Ingrese su nueva contraseña") ^ 
                    forgot.pssPasswordField1.getPassword().toString().equals(
                            "Ingrese su nueva contraseña")) ^ (
                    forgot.pssPasswordField.getPassword().toString().isEmpty() ^ 
                    forgot.pssPasswordField1.getPassword().toString().isEmpty())){
                
                popup = new PopupMessage(forgot, true, 1, 
                        "Debe ingresar una nueva contraseña.");
                
            }
            // Si las contraseñas no son iguales.
            else{
                
                popup = new PopupMessage(forgot, true, 1, 
                        "Las contraseñas no son iguales.");
                
            }
            
        }
        
        //</editor-fold>
        
    }

    /**
     * Método para comprobar la existencia de un usuario.
     * @param email correo electrónico del usuario.
     * @return variable booleana.
     */
    public boolean signer(String email){
        
        try{
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConexionBD();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM public.\"Usuario\" WHERE \"Correo\" = '"
                            + email + "' AND \"Estado\" = '1';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            // Si el usuario existe (que debe ser único) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar el usuario. Error: " + ex);
        }
        
        // Si el usuario no existe, retorna 'false'.
        return false;
        
    }
    
    /**
     * Método para actualizar la contraseña de un usuario.
     * @param email correo electrónico del usuario.
     * @param pass nueva contraseña
     */
    public void insertNewPass(String email, String pass){
       
        // Se instancia la clase de conexión de la BD y se establece conexión.
        con = new ConexionBD();
        con.conectar();
          
        // Se declara la sentencia SQL.
        String SQL =    "UPDATE public.\"Usuario\" SET \"Clave\" = "
                        + "'" + pass + "' WHERE \"Correo\" = '" + email + "';";
            
        // Se realiza la actualización.
        con.queryInsert(SQL);
            
        // Se desconecta la BD.
        con.desconectar();
                 
    }
    
}
