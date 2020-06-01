
package controllers;

import java.util.*;
import views.SelectSucursal;
import views.PopupMessage;

/**
 *
 * @author Gustavo
 */
public class ControllerSelectSucursal implements java.awt.event.ActionListener{
    
    // Instancian las clases a utilizar.
    private SelectSucursal selectSucursal;
    private PopupMessage popup;
    
    public String sucursal;
    
    public ControllerSelectSucursal(){
        
        // Se declaran las variables.
        selectSucursal = new SelectSucursal();
                        
        // Se activan los eventos de la interfaz.
        selectSucursal.addEvents(this);
        
        selectSucursal.cmbSelectCity.setSelectedIndex(0);
        selectSucursal.cmbSelectSucursal.setSelectedIndex(0);
        
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
        if(evt.getSource() == selectSucursal.btnCloseSelectSucursal){
            selectSucursal.dispose();
        }
        
        // Botón de aceptar.
        else if(evt.getSource() == selectSucursal.btnOkSelectSucursal){
            
            if(selectSucursal.cmbSelectSucursal.getSelectedIndex() != 0 ||
                   selectSucursal.cmbSelectCity.getSelectedIndex() != 0  ){
                
                setId_Sucursal((String) selectSucursal.cmbSelectSucursal.getSelectedItem());
                                
                // Se cierra la interfaz
                selectSucursal.dispose();
                
            } else{
                
                // Si no se ha seleccionado algún dato (Ciudad o Sucursal)
                popup = new PopupMessage(selectSucursal, true, 
                                         1, "Faltan datos por seleccionar");
                
            }
        }
        
        // Si se selecciona un elemento del combobox de ciudad.
        else if(evt.getSource() == selectSucursal.cmbSelectCity){
            
            // Se obtiene el elemento seleccionado.
            String item = (String) selectSucursal.cmbSelectCity.getSelectedItem();
            
            // Se remueven todos los items del combobox.
            selectSucursal.cmbSelectSucursal.removeAllItems();
            
            // Se añade el item base del combobox
            selectSucursal.cmbSelectSucursal.addItem(" - Seleccionar - ");
            
            // Se instancia y se declara un Array que contendrá todos los nombres de las sucursales.
            ArrayList<String> sucursales = new ArrayList<String>();
            
            /* Falta agregar el método que pasa la lista obtenida por la BD de 
               nombre de las sucursales a la variable 'sucursales' */
            
            // Se crea una variable indice.
            Iterator<String> i = sucursales.iterator();
            
            // Se llena el combobox con los elementos correspondientes
            while(i.hasNext()){
                
                selectSucursal.cmbSelectSucursal.addItem(i.next());
                
            }
            
            
        }
        
    }
    
}
