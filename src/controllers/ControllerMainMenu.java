package controllers;

import views.MainPage;
import views.PopupMessage;
import lib.SuportFunctions;

/**
 *
 * @author Gustavo
 */
public class ControllerMainMenu implements java.awt.event.ActionListener{
    
    // Instanciar las clases necesarias para el funcionamiento.
    public MainPage mainPage;
    private ControllerSelectSucursal cSelectSucursal;
    private SuportFunctions sf;
    private PopupMessage popup;
                
    public ControllerMainMenu(){
        // Declarar la variable de las clases instanciadas.
        mainPage = new MainPage();
        sf = new SuportFunctions();
        
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
            sf.cardSelection(mainPage.panContent, mainPage.panOption1);
            
        } 

        // Menú Lateral -> Ventas
        else if(evt.getSource() == mainPage.btnOptionLateral2){
            sf.cardSelection(mainPage.panContent, mainPage.panOption2);
            sf.cardSelection(mainPage.panOption2, mainPage.panDecisionOption2);
            
        }
        
        // Menú Lateral -> Reportes
        else if(evt.getSource() == mainPage.btnOptionLateral3){
            sf.cardSelection(mainPage.panContent, mainPage.panOption3);
            
        }
        
        // Menú Lateral -> Empleados
        else if(evt.getSource() == mainPage.btnOptionLateral4){
            sf.cardSelection(mainPage.panContent, mainPage.panOption4);
            
        }
        
        // Menú Lateral -> Sucursales
        else if(evt.getSource() == mainPage.btnOptionLateral5){
            sf.cardSelection(mainPage.panContent, mainPage.panOption5);
            
        }
        
        // Menú Lateral -> Configuración
        else if(evt.getSource() == mainPage.btnOptionLateral6){
            sf.cardSelection(mainPage.panContent, mainPage.panOption6);
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Botones del MainPage Option 1 ">
        
        // Opción 2 -> Ventas
        else if(evt.getSource() == mainPage.btnBodyOption2){
            mainPage.panBodyOption2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
           
            sf.cardSelection(mainPage.panContent, mainPage.panOption2);
            sf.cardSelection(mainPage.panOption2, mainPage.panDecisionOption2);
                        
        }
        
        // Opción 3 -> Reportes
        else if(evt.getSource() == mainPage.btnBodyOption3){
            mainPage.panBodyOption3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            
            sf.cardSelection(mainPage.panContent, mainPage.panOption3);
            
        }
        
        // Opción 4 -> Empleados
        else if(evt.getSource() == mainPage.btnBodyOption4){
            mainPage.panBodyOption4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            
            sf.cardSelection(mainPage.panContent, mainPage.panOption4);
            
        }
        
        // Opción 5 -> Sucursales
        else if(evt.getSource() == mainPage.btnBodyOption5){
            mainPage.panBodyOption5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            
            sf.cardSelection(mainPage.panContent, mainPage.panOption5);
            
        }
        
        // Opción 6 -> Configuración
        else if(evt.getSource() == mainPage.btnBodyOption6){
            mainPage.panBodyOption6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            
            sf.cardSelection(mainPage.panContent, mainPage.panOption6);
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Botones del MainPage Option 2 ">
        
        //<editor-fold defaultstate="collapsed" desc=" Decisión en la Opción 2 ">
        
        // Tickets de Golosinas
        else if(evt.getSource() == mainPage.btnCandyDecision){
            mainPage.panCapsuleCandyDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
        
            sf.cardSelection(mainPage.panOption2, mainPage.panCandySell);
            
        }
        
        //<editor-fold defaultstate="collapsed" desc=" Venta de tickets para golosinas ">
        
        // Volver para la sección anterior
        else if(evt.getSource() == mainPage.btnBackToTicketDecision1){
            mainPage.btnBackToTicketDecision1.setBackground(new java.awt.Color(249,249,249));
            
            sf.cardSelection(mainPage.panOption2, mainPage.panDecisionOption2);
            
        }
        
        // Cambiar de sucursal a gestionar
        else if(evt.getSource() == mainPage.btnChangeSucursalCandySell){
            
            // Instanciar la clase
            cSelectSucursal = new ControllerSelectSucursal();
            
            
        }
        
        //</editor-fold>
        
        // Tickets de funciones
        else if(evt.getSource() == mainPage.btnCinemaDecision){
            mainPage.panCapsuleCinemaDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
        
            sf.cardSelection(mainPage.panOption2, mainPage.panCinemaSell);
        }
        
        //<editor-fold defaultstate="collapsed" desc=" Venta de tickets para funciones ">
        
        // Volver para la sección anterior
        else if(evt.getSource() == mainPage.btnBackToTicketDecision2){
            mainPage.btnBackToTicketDecision2.setBackground(new java.awt.Color(249,249,249));
            
            sf.cardSelection(mainPage.panOption2, mainPage.panDecisionOption2);
            
        }
        
        //</editor-fold>
        
        //</editor-fold>
        
        //</editor-fold>
        
    }
    
}
