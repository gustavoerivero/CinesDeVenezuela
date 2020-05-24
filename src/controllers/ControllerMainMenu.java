package controllers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.MainMenu;

/**
 *
 * @author Gustavo
 */
public class ControllerMainMenu{
    
    // Instanciar las clases necesarias para el funcionamiento.
    private MainMenu mainMenu;
    
    public ControllerMainMenu(){
        // Declarar la variable de la clase instanciada.
        mainMenu = new MainMenu();
        //mainMenu.addMouseEvents(this);
    }
    
    public void mousePerformed(MouseEvent e){
        if(e.getSource() == mainMenu.jpBody2){
            mainMenu.jpBody2.setBackground(Color.red);
        }
    }

}
