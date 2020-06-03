
package views.tables;

import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Gustavo
 */
public class Render extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        if(value instanceof JButton){
            
            JButton btn = (JButton)value;
            
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
        
        return super.getTableCellRendererComponent(table, value, isSelected, 
                hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    
    }
    
}
