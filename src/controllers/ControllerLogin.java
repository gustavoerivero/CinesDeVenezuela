
package controllers;

// Se importan las views a utilizar
import views.Login;
import views.PopupMessage;

/**
 *
 * @author Gustavo
 */
public class ControllerLogin implements java.awt.event.ActionListener {
    
    // Se instancias las clases a utilizar.
    private Login login;
    private PopupMessage popup;
    private ControllerMainMenu mainMenu;
    
    // Constructor del Login
    public ControllerLogin(){
        
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
            login.pssPasswordField.setEchoChar('*');
            
        }
        
        // Botón para ingresar al sistema.
        else if(evt.getSource() == login.btnOk){
                  
            // Si el contenido de los campos es igual a vacío o el mensaje predeterminado.
            if((login.txtEmailField.getText().equals("") || 
                login.txtEmailField.getText().equals("Ingrese su correo electrónico")) || ( 
                login.pssPasswordField.getPassword().toString().equals("") || 
                login.pssPasswordField.getPassword().toString().equals("Ingrese su contraseña"))){
                
                popup = new PopupMessage(login, true, 1, 
                        "<html><p align = 'center'>El correo electrónico o la contraseña son incorrectos</p></html>");
                
                // Si todo está correcto, se accede al sistema.
            } else{
                
                popup = new PopupMessage(login, true, 4, 
                        "Bienvenido");
                
                login.dispose();
                
                mainMenu = new ControllerMainMenu();
                
            }
            
        }
        
        // ToggleButton para visualizar el campo de contraseña o ocultarlo (Según el caso).
        else if(evt.getSource() == login.tgbShowPass){
     
            if(login.tgbShowPass.isSelected())
                login.pssPasswordField.setEchoChar((char) 0);
            else 
                login.pssPasswordField.setEchoChar('*');
        }
        
    }
    
}
