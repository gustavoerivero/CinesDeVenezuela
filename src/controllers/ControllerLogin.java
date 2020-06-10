
package controllers;

// Se importan las views a utilizar
import views.Login;
import views.PopupMessage;


import models.ConexionBD;

/**
 *
 * @author Gustavo
 */
public class ControllerLogin implements java.awt.event.ActionListener {
    
    // Se instancias las clases a utilizar.
    private Login login;
    private PopupMessage popup;
    private ControllerMainMenu mainMenu;
    private ConexionBD con;
        
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
            login.tgbShowPass.setSelected(false);
            login.pssPasswordField.setEchoChar('*');
            
        }
        
        // Botón para ingresar al sistema.
        else if(evt.getSource() == login.btnOk){
                 
            String  email   = login.txtEmailField.getText(),
                    pass    = login.pssPasswordField.getPassword().toString();
            
            // Si el contenido de los campos es igual a vacío o el mensaje predeterminado.
            if((email.isEmpty() || email.equals("Ingrese su correo electrónico")) || ( 
                pass.isEmpty() || pass.equals("Ingrese su contraseña"))){
                
                // Se muestra un mensaje emergente de "Datos faltantes".
                popup = new PopupMessage(login, true, 1, 
                        "<html><p align = 'center'>Debe ingresar los datos correspondientes.</p></html>");
                
            // Si todo está correcto, se accede al sistema.
            } else{
                
                // Si el usuario y la contraseña son correctos.
                if(signer(email, pass) == true){
                    
                    // Se muestra un mensaje emergente de "Bienvenido".
                    popup = new PopupMessage(login, true, 4, 
                            "Bienvenido");
                
                    // Se oculta la view de Login.
                    login.dispose();
                
                    // Se instancia el Controlador de MainMenu.
                    mainMenu = new ControllerMainMenu();
                   
                // Si el usuario y/o la contraseña son incorrectos.
                } else{
                    
                    // Se muestra un mensaje emergente de "Datos faltantes".
                    popup = new PopupMessage(login, true, 1, 
                            "<html><p align = 'center'>El correo electrónico o "
                                    + "la contraseña son incorrectos.</p></html>");
                    
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
        
    }
    
    public boolean signer(String email, String pass){
        
        try{
            
            con = new ConexionBD();
            con.conectar();
          
            String SQL =    "SELECT * FROM public.\"Usuario\" WHERE \"Correo\" = '"
                            + email + "' AND \"Clave\" = '" + pass + 
                            "' AND \"Estado\" = '1';";
            
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            con.desconectar();
            
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar el usuario. Error: " + ex);
        }
        
        return false;
        
    }
    
}
