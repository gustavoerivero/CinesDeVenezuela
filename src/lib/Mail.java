
package lib;

// Se importan las librerías a utilizar.
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Gustavo
 */
public class Mail {
    
    /**
     * Método que permite realizar una autenticación con los datos del correo 
     * electrónico proporcionado.
     * @param email Correo electrónico que enviará el mensaje.
     * @param pass Contraseña del correo electrónico que enviará el mensaje.
     * @return Retorna dato de tipo Session.
     */
    public Session authentication(String email, String pass){
        
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
                                return new PasswordAuthentication(email, pass);
                            }
                }
        );
            
        // Retorna estado de la sessión.
        return session;
        
    }
    
    /**
     * Método que envía un correo electrónico.
     * @param session Variable de tipo Session. Antes se debe autenticar.
     * @param from Correo electrónico del emisor.
     * @param to Correo electrónico del receptor.
     * @param subject Asunto del correo a enviar.
     * @param content Contenido del correo a enviar.
     * @return Retorna variable booleana que indica si el correo es o no enviado.
     */
    public boolean sendMessage(Session session, String from, String to, 
            String subject, String content){
        
        // Variable que indica si el correo es o no enviado.
        boolean val = true;
        
        try{
        
        // Se describen los emisores, receptores, asunto y mensaje.
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(content);
                
        // Se envía el mensaje.
        Transport.send(message);
        
        // Se notifica que el correo fue enviado sin inconvenientes.
        System.out.println("El correo fue enviado con éxito.");
                
        }catch (MessagingException ex) {
            
            // Se notifica que el correo no pudo ser enviado.
            System.out.println("El correo no pudo ser enviado. Error: " + ex);
            
            // La variable validadora cambia de estado.
            val = false;
        } 
        
        // Se retorna el estado de la variable validadora.
        return val;
    }
    
}
