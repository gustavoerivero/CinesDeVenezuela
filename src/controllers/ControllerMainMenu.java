package controllers;

import views.MainPage;

/**
 *
 * @author Gustavo
 */
public class ControllerMainMenu implements java.awt.event.ActionListener{
    
    // Instanciar las clases necesarias para el funcionamiento.
    private MainPage mainPage;
        
    public ControllerMainMenu(){
        // Declarar la variable de la clase instanciada.
        mainPage = new MainPage();
        
        // Activamos los eventos provocados por los botones.
        mainPage.addEvents(this);
    }

    /*
     * Método que determina las acciones a realizar por la aplicación según el 
     * botón presionado.
     */
    public void actionPerformed(java.awt.event.ActionEvent evt){
        
        //<editor-fold defaultstate="collapsed" desc=" Botones de la Barra Superior ">
        
        // Minimizar aplicación.
        if(evt.getSource() == mainPage.btnMin){
            mainPage.setExtendedState(java.awt.Frame.ICONIFIED);
            mainPage.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir de la aplicación.
        else if(evt.getSource() == mainPage.btnExit){
            System.exit(0);
        } 

        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Botones del Menú Lateral ">
        
        // Menú Lateral -> Inicio
        else if(evt.getSource() == mainPage.btnOptionLateral1){
            mainPage.panContent.removeAll();
            mainPage.panContent.add(mainPage.panOption1);
            mainPage.panContent.repaint();
            mainPage.panContent.revalidate();
        } 

        // Menú Lateral -> Ventas
        else if(evt.getSource() == mainPage.btnOptionLateral2){
            mainPage.panContent.removeAll();
            mainPage.panContent.add(mainPage.panOption2);
            mainPage.panContent.repaint();
            mainPage.panContent.revalidate();
        }
        
        // Menú Lateral -> Reportes
        else if(evt.getSource() == mainPage.btnOptionLateral3){
            mainPage.panContent.removeAll();
            mainPage.panContent.add(mainPage.panOption3);
            mainPage.panContent.repaint();
            mainPage.panContent.revalidate();
        }
        
        // Menú Lateral -> Empleados
        else if(evt.getSource() == mainPage.btnOptionLateral4){
            mainPage.panContent.removeAll();
            mainPage.panContent.add(mainPage.panOption4);
            mainPage.panContent.repaint();
            mainPage.panContent.revalidate();
        }
        
        // Menú Lateral -> Sucursales
        else if(evt.getSource() == mainPage.btnOptionLateral5){
            mainPage.panContent.removeAll();
            mainPage.panContent.add(mainPage.panOption5);
            mainPage.panContent.repaint();
            mainPage.panContent.revalidate();
        }
        
        // Menú Lateral -> Configuración
        else if(evt.getSource() == mainPage.btnOptionLateral6){
            mainPage.panContent.removeAll();
            mainPage.panContent.add(mainPage.panOption6);
            mainPage.panContent.repaint();
            mainPage.panContent.revalidate();
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Botones del MainPage Option 1 ">
        
        // Opción 2 -> Ventas
        else if(evt.getSource() == mainPage.btnBodyOption2){
            mainPage.panBodyOption2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            mainPage.panContent.removeAll();
            mainPage.panContent.add(mainPage.panOption2);
            mainPage.panContent.repaint();
            mainPage.panContent.revalidate();
        }
        
        // Opción 3 -> Reportes
        else if(evt.getSource() == mainPage.btnBodyOption3){
            mainPage.panBodyOption3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            mainPage.panContent.removeAll();
            mainPage.panContent.add(mainPage.panOption3);
            mainPage.panContent.repaint();
            mainPage.panContent.revalidate();
        }
        
        // Opción 4 -> Empleados
        else if(evt.getSource() == mainPage.btnBodyOption4){
            mainPage.panBodyOption4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            mainPage.panContent.removeAll();
            mainPage.panContent.add(mainPage.panOption4);
            mainPage.panContent.repaint();
            mainPage.panContent.revalidate();
        }
        
        // Opción 5 -> Sucursales
        else if(evt.getSource() == mainPage.btnBodyOption5){
            mainPage.panBodyOption5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            mainPage.panContent.removeAll();
            mainPage.panContent.add(mainPage.panOption5);
            mainPage.panContent.repaint();
            mainPage.panContent.revalidate();
        }
        
        // Opción 6 -> Configuración
        else if(evt.getSource() == mainPage.btnBodyOption6){
            mainPage.panBodyOption6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            mainPage.panContent.removeAll();
            mainPage.panContent.add(mainPage.panOption6);
            mainPage.panContent.repaint();
            mainPage.panContent.revalidate();
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Botones del MainPage Option 2 ">
        
        
        //</editor-fold>
        
    }
    
}
