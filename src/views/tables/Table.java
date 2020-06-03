
package views.tables;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Gustavo
 */
public class Table {
    
            
    public void addModifyButton(JButton btnModify){
                
        btnModify.setName("m");
        ImageIcon modifyIcon = new ImageIcon(getClass().getResource(
                "/views/images/modifyIcon-small.png"));        
        btnModify.setIcon(modifyIcon);
        btnModify.setBackground(new java.awt.Color(245, 245, 245));
        btnModify.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModify.setToolTipText("Modificar");
        btnModify.setContentAreaFilled(false);
                
    }
    
    public void addDeleteButton(JButton btnDelete){
        
        btnDelete.setName("e");
        ImageIcon deleteIcon = new ImageIcon(getClass().getResource(
                "/views/images/deleteIcon-small.png"));
        btnDelete.setIcon(deleteIcon);
        btnDelete.setToolTipText("Eliminar");
        btnDelete.setBackground(new java.awt.Color(245, 245, 245));
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setContentAreaFilled(false);
                
    }
    
    public void buildCandyTable(javax.swing.JTable table, Object[][] matrix){
        
        table.setDefaultRenderer(Object.class, new Render());
                
        JButton btnModify = new JButton();
        addModifyButton(btnModify);
        
        JButton btnDelete = new JButton();
        addDeleteButton(btnDelete);
        
        DefaultTableModel candyTableModel = new  DefaultTableModel(
            matrix,
            new Object[]{
                            "Golosina", "Cantidad", "Precio (Unidad)", 
                            "IVA (Unidad)", "Monto (Unidad)", "Total", 
                            "Modificar", "Eliminar"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        table.setModel(candyTableModel);
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
             
        table.setRowHeight(24);
        
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(1).setPreferredWidth(40);
            table.getColumnModel().getColumn(6).setResizable(false);
            table.getColumnModel().getColumn(6).setPreferredWidth(40);
            table.getColumnModel().getColumn(7).setResizable(false);
            table.getColumnModel().getColumn(7).setPreferredWidth(40);
        }
        
    }
    
    public void showCandyTable(javax.swing.JTable table, Object[][] matrix){
        
        buildCandyTable(table, matrix);
          
    }

}
