
package controllers;

import java.util.*;
import views.ChangeBranch;
import views.PopupDialogMessage;

/**
 *
 * @author Gustavo
 */
public class ControllerSelectSucursal implements java.awt.event.ActionListener{
    
    // Instancian las clases a utilizar.
    private ChangeBranch changeBranch;
    private PopupDialogMessage popup;
    
    String sucursal;
    
    public ControllerSelectSucursal(java.awt.Frame parent, boolean modal){
        
        // Se declaran las variables.
        changeBranch = new ChangeBranch(parent, modal);
                        
        // Se activan los eventos de la interfaz.
        changeBranch.addEvents(this);
        
        changeBranch.cmbCity.setSelectedIndex(0);
        changeBranch.cmbBranch.setSelectedIndex(0);
        
        sucursal = "";
                              
    }
    
    // Agregar el nombre de la sucursal a la variable.
    public void setId_Sucursal(String id){
        this.sucursal = id;
    }
    
    // Obteneer el nombre de la sucursal.
    public String getId_Sucursal(){
        return sucursal;
    }
    
    /*
     * Método que determina las acciones a realizar por la aplicación según el 
     * botón o combobox presionado.
     */
    public void actionPerformed(java.awt.event.ActionEvent evt){
        
        // Botón de cerrar interfaz.
        if(evt.getSource() == changeBranch.btnClose){
            changeBranch.dispose();
        }
        
        // Botón de aceptar.
        else if(evt.getSource() == changeBranch.btnOk){
            
            if( changeBranch.cmbCity.getSelectedIndex() != 0 ||
                changeBranch.cmbBranch.getSelectedIndex() != 0  ){
                
                setId_Sucursal((String) changeBranch.cmbBranch.getSelectedItem());
                                
                // Se cierra la interfaz
                changeBranch.dispose();
                
            } else{
                
                // Si no se ha seleccionado algún dato (Ciudad o Sucursal)
                popup = new PopupDialogMessage( changeBranch, true, 
                                                1, "Faltan datos por seleccionar");
                
            }
        }
        
        // Si se selecciona un elemento del combobox de ciudad.
        else if(evt.getSource() == changeBranch.cmbCity){
            
            // Se obtiene el elemento seleccionado.
            String item = (String) changeBranch.cmbCity.getSelectedItem();
            
            // Se remueven todos los items del combobox.
            changeBranch.cmbBranch.removeAllItems();
            
            // Se añade el item base del combobox
            changeBranch.cmbBranch.addItem(" - Seleccionar - ");
            
            // Se instancia y se declara un Array que contendrá todos los nombres de las sucursales.
            ArrayList<String> sucursales = new ArrayList<String>();
            
            // Falta agregar el método que pasa la lista obtenida por la BD de 
            //   nombre de las sucursales a la variable 'sucursales' 
            
            // Se crea una variable indice.
            Iterator<String> i = sucursales.iterator();
            
            // Se llena el combobox con los elementos correspondientes
            while(i.hasNext()){
                
                changeBranch.cmbBranch.addItem(i.next());
                
            }
            
        
        }
        
    }
    
}
