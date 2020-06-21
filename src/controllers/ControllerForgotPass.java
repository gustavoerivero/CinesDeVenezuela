
package controllers;

// Se importan las librerías de apoyo.
import lib.SuportFunctions;
import lib.Mail;

// Se importan los models a utilizar.
import models.database.ConnectionDB;
import models.database.UserCRUD;

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
    
        // Views
        private ForgotPass forgot;
        private PopupMessage popup;
        private SelectOption select;
        
        // Librerías de soporte
        private SuportFunctions suport;
        private Mail mail;
        
        // Models
        private UserCRUD user;
    
    
    // Se declaran las variables a utilizar.
    String correo, codex;
    
    public ControllerForgotPass(){
    
        // Se instancia clase de soporte.
        suport = new SuportFunctions();
        user = new UserCRUD();
        mail = new Mail();
        
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
            
            // Si no se proporcionaron los datos solicitados.
            if((email.isEmpty() ^ emailConfirmation.isEmpty()) ^ 
                    ((email.equals("Ingrese su correo electrónico") ^ 
                    emailConfirmation.equals("Ingrese nuevamente su correo electrónico")))){
                
                popup = new PopupMessage(forgot, true, 1, "Debe ingresar los "
                        + "datos solicitados.");
                
            }
            
            // Si se proporcionaron los datos solicitados.
            else {
            
                // Si ambos correos electrónicos tienen formato válido.
                if(suport.verifyEmail(email) && suport.verifyEmail(emailConfirmation)){
                    
                    // Si los correos electrónicos son iguales y existe el usuario.
                    if(email.equals(emailConfirmation) && user.signer(email)){
                
                        correo = email;

                        System.out.println("El correo con código de confirmación está"
                                + " siendo preparado.");

                        // Datos del usuario emisor.
                        String  from = "cinesdevenezuela.nacional@gmail.com",
                                pass = "cines1234venezuela";

                        // Obtener el código de confirmación.
                        codex = suport.randomCharacterString('1', 6);
                            
                        // Se procede a enviar el mensaje con el código de verificación.
                        if(mail.sendMessage(mail.authentication(from, pass), 
                                from, correo, "Código de confirmación para "
                                    + "recuperar contraseña", "El código de "
                                            + "confirmación para poder recuperar"
                                            + " tu contraseña es: " + codex)){
                            
                            popup = new PopupMessage(forgot, true, 2, "El correo con el "
                                + "código de verificación ha sido enviado");
                            
                            // Se cambia la pantalla.
                            suport.cardSelection(forgot.panContent, forgot.panStepTwo);
                            
                        } else
                            
                            popup = new PopupMessage(forgot, true, 2, "El correo con el "
                                + "código de verificación no pudo ser enviado, "
                                    + "verifique los datos ingresados");
                                                  
                    }   
            
                    // Si los correos proporcionados no son iguales o el usuario no está registrado.
                    else{
                        
                        // Si los correos proporcionados no son iguales.
                        if(!email.equals(emailConfirmation))
                            popup = new PopupMessage(forgot, true, 1, "Los correos "
                                    + "electrónicos no son iguales.");
                        
                        // Si el usuario no está registrado
                        else
                            popup = new PopupMessage(forgot, true, 1, "El usuario "
                                    + "no está registrado.");

                    }
                }
                
                // Si uno de los correos electrónicos proporcionados no tienen formato válido.
                else{
                    
                    // Se muestra un mensaje emergente de "Datos faltantes".
                    popup = new PopupMessage(forgot, true, 1, 
                            "El correo electrónico no tiene un formato válido.");
                    
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
                user.insertNewPass(correo, pass);
                
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
        
}
