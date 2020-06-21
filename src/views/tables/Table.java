
package views.tables;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Gustavo
 */
public class Table {
    
    //<editor-fold defaultstate="collapsed" desc=" Botónes para tablas ">
        
    /**
     * Método para dar formato a un JButton con características de "Aceptar".
     * @param btnOk JButton que se le desea dar un formato.
     */
    public void addOkButton(JButton btnOk){
                
        btnOk.setName("o");
        ImageIcon okIcon = new ImageIcon(getClass().getResource(
                "/views/images/okIcon-small.png"));        
        btnOk.setIcon(okIcon);
        btnOk.setBackground(new java.awt.Color(245, 245, 245));
        btnOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOk.setToolTipText("Aceptar");
        btnOk.setContentAreaFilled(false);
                
    }
    
    /**
     * Método para dar formato a un JButton con características de "Incorporar".
     * @param btnIncorporate JButton que se le desea dar un formato.
     */
    public void addIncorporateButton(JButton btnIncorporate){
                
        btnIncorporate.setName("i");
        ImageIcon incorporateIcon = new ImageIcon(getClass().getResource(
                "/views/images/incorporateIcon-small.png"));        
        btnIncorporate.setIcon(incorporateIcon);
        btnIncorporate.setBackground(new java.awt.Color(245, 245, 245));
        btnIncorporate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIncorporate.setToolTipText("Incorporar");
        btnIncorporate.setContentAreaFilled(false);
                
    }
    
    /**
     * Método para dar formato a un JButton con características de "Modificar".
     * @param btnModify JButton que se le desea dar un formato.
     */
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
    
    /**
     * Método para dar formato a un JButton con características de "Eliminar"
     * @param btnDelete JButton que se le desea dar un formato.
     */
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
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Constructores de tablas ">
        
    /**
     * Método para construir una JTable con formato para venta de dulces.
     * @param table JTable que se le dará formato.
     * @param matrix Datos que se van a incorporar a la JTable.
     */
    public void buildCandyTable(javax.swing.JTable table, Object[][] matrix){
        
        table.setDefaultRenderer(Object.class, new Render());
               
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
    
    /**
     * Método para construir una JTable con formato para seleccionar una película.
     * @param table JTable que se le dará formato.
     * @param matrix Datos que se van a incorporar a la JTable.
     */
    public void buildMovieSelectorTable(javax.swing.JTable table, Object[][] matrix){
        
        table.setDefaultRenderer(Object.class, new Render());
                                
        DefaultTableModel movieSelectorTableModel = new  DefaultTableModel(
            matrix,
            new Object[]{
                            "Poster", "Película", "Sinopsis", 
                            "Género", "Censura", "Seleccionar"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        table.setModel(movieSelectorTableModel);
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
             
        table.setRowHeight(125);
        
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(0).setPreferredWidth(110);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(3).setPreferredWidth(45);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(4).setPreferredWidth(35);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(5).setPreferredWidth(45);
        }
        
    }
    
        /**
     * Método para construir una JTable con formato para seleccionar una función.
     * @param table JTable que se le dará formato.
     * @param matrix Datos que se van a incorporar a la JTable.
     */
    public void buildFunctionSelectorTable(javax.swing.JTable table, Object[][] matrix){
        
        table.setDefaultRenderer(Object.class, new Render());
                                
        DefaultTableModel functionSelectorTableModel = new  DefaultTableModel(
            matrix,
            new Object[]{
                            "Día", "Sala", "Hora de la Función", 
                            "Asientos", "Asientos disponibles", "Seleccionar"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        table.setModel(functionSelectorTableModel);
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
             
        table.setRowHeight(24);
        
        if (table.getColumnModel().getColumnCount() > 0) {
                table.getColumnModel().getColumn(0).setResizable(false);
                table.getColumnModel().getColumn(0).setPreferredWidth(35);
                table.getColumnModel().getColumn(1).setResizable(false);
                table.getColumnModel().getColumn(1).setPreferredWidth(35);
                table.getColumnModel().getColumn(2).setResizable(false);
                table.getColumnModel().getColumn(2).setPreferredWidth(80);
                table.getColumnModel().getColumn(3).setResizable(false);
                table.getColumnModel().getColumn(3).setPreferredWidth(35);
                table.getColumnModel().getColumn(4).setResizable(false);
                table.getColumnModel().getColumn(4).setPreferredWidth(80);
                table.getColumnModel().getColumn(5).setResizable(false);
                table.getColumnModel().getColumn(5).setPreferredWidth(45);
        }
        
    }

    //</editor-fold>
    
}
