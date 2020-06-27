
package views.tables;

import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *  Materia: Laboratorio I
 *  Sección: 1
 *      Integrantes:
 *          @author Brizuela, Yurisbellys   C.I: 27.142.239
 *          @author Miranda, Marihec        C.I: 26.120.075
 *          @author Montero, Michael        C.I: 26.561.077
 *          @author Rivero, Gustavo         C.I: 26.772.857
 *          @author Torrealba, Luis         C.I: 26.121.249
 */
public class Render extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        if(value instanceof JButton){
            
            JButton btn = (JButton) value;
            
            if(isSelected){
                
                btn.setForeground(table.getSelectionForeground());
                btn.setBackground(table.getSelectionBackground());
                
            }
            
            else {
                
                btn.setForeground(table.getForeground());
                btn.setBackground(UIManager.getColor("Button.background")); 
                
            }
            
            return btn;
            
        }
        
        else if(value instanceof JLabel){
            
            JLabel lbl = (JLabel) value;
            
            return lbl;
            
        }
        
        return super.getTableCellRendererComponent(table, value, isSelected, 
                hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    
    }
    
}
