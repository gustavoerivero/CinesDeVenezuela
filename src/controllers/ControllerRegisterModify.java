/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.RegisterModify;
import views.MainPage;

/**
 *
 * @author Luis David
 */
public class ControllerRegisterModify implements ActionListener, MouseListener{
   
    private RegisterModify registerModify;
    private MainPage mainpage;
    
    
    //constructor
    public ControllerRegisterModify(){
        
        registerModify = new RegisterModify();
        
        
        registerModify.setVisible(true);
        registerModify.addEvents(this);
      
        registerModify.modificarCampos(false);
        
        
        
    }
    

    public void actionPerformed(java.awt.event.ActionEvent evt){
        
        
    //<editor-fold defaultstate="collapsed" desc=" Botones de la Ventana ">
         
        if(evt.getSource() == registerModify.btnMin){
            
            registerModify.setExtendedState(java.awt.Frame.ICONIFIED);
            registerModify.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir de la aplicación.
        if(evt.getSource() == registerModify.btnExitt){
             registerModify.dispose();
            
             mainpage = new MainPage();
             mainpage.setVisible(true);
            //mainPage.setVisible(true);
        } 
        if(evt.getSource() == registerModify.btnCancel){
            //suport.cardSelection(registerModify.panButtonsModifyRegister, mainpage.panOption1);
            registerModify.dispose();
            
            }
    
         //</editor-fold>
    
    
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent evt) {
        //<editor-fold defaultstate="collapsed" desc=" Botones de la Ventana ">
         
        if(evt.getSource() == registerModify.btnMin){
            
            registerModify.setExtendedState(java.awt.Frame.ICONIFIED);
            registerModify.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir de la aplicación.
        if(evt.getSource() == registerModify.btnExitt){
             registerModify.dispose();
            
             mainpage = new MainPage();
             mainpage.setVisible(true);
            //mainPage.setVisible(true);
        } 
        if(evt.getSource() == registerModify.btnCancel){
            //suport.cardSelection(registerModify.panButtonsModifyRegister, mainpage.panOption1);
            registerModify.dispose();
            
            }
    
         //</editor-fold>
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        
        
    
}
