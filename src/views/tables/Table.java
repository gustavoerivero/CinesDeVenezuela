
package views.tables;

// Se importan las librerías a utilizar.
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

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
    
    /**
     * Método para dar formato a un JButton con características de "Buscar"
     * @param btnDelete JButton que se le desea dar un formato.
     */
    public void addSearchButton(JButton btnSearch){
        
        btnSearch.setName("s");
        ImageIcon deleteIcon = new ImageIcon(getClass().getResource(
                "/views/images/okIcon-small.png"));
        btnSearch.setIcon(deleteIcon);
        btnSearch.setToolTipText("Buscar");
        btnSearch.setBackground(new java.awt.Color(245, 245, 245));
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setContentAreaFilled(false);
                
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
    
    /**
     * Método para construir una JTable con formato para visualizar los tickets
     * a comprar
     * @param table JTable que se le dará formato.
     * @param matrix Datos que se van a incorporar a la JTable.
     */
     
    public void buildCinemaTicketsTable(javax.swing.JTable table, Object[][] matrix){
        
        table.setDefaultRenderer(Object.class, new Render());
        
        DefaultTableModel functionSelectorTableModel = new DefaultTableModel(
        matrix,
        new Object[]{
            "Tipo", "Butaca", "Precio", "IVA (16%)", "Monto"
        }
    )
    {
        public boolean isCellEditable(int row, int colum){
            return false;
            }
        };
        table.setModel(functionSelectorTableModel);
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        
    }
    
    /**
     * Método para construir una JTable con formato para la búsqueda de empleados.
     * @param table JTable que se le dará formato.
     * @param matrix Datos que se van a incorporar a la JTable.
     */
    public void buildEmployeeTable(javax.swing.JTable table, Object[][] matrix){
        
        table.setDefaultRenderer(Object.class, new Render());
               
        DefaultTableModel employeeTableModel = new  DefaultTableModel(
            matrix,
            new Object[]{
                "Cédula", "Nombre y Apellido", "Sucursal", "Cargo", "Consultar"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        table.setModel(employeeTableModel);
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
             
        table.setRowHeight(32);
        
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(4).setPreferredWidth(32);
        }
    }
    
    /**
     * Método para construir una JTable con formato de Sucursal.
     * @param table JTable que se le dará formato.
     * @param matrix Datos que se van a incorporar a la JTable.
     */
    public void buildBranchTable(javax.swing.JTable table, Object[][] matrix){
        
        table.setDefaultRenderer(Object.class, new Render());
               
        DefaultTableModel branchTableModel = new  DefaultTableModel(
            matrix,
            new Object[]{
                            "Codigo", "Nombre", "Ciudad", 
                            "Dirección", "Telefono", "Consultar"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        table.setModel(branchTableModel);
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
             
        table.setRowHeight(32);
        
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(5).setPreferredWidth(32);
            
        }
        
    }
    
    /**
     * Método para construir una JTable con formato para la busqueda de clientes.
     * @param table JTable que se le dará formato.
     * @param matrix Datos que se van a incorporar a la JTable.
     */
    public void buildClientTable(javax.swing.JTable table, Object[][] matrix){
        
        table.setDefaultRenderer(Object.class, new Render());
               
        DefaultTableModel clientTableModel = new  DefaultTableModel(
            matrix,
            new Object[]{
                "Cédula", "Nombre y Apellido", "Dirección", 
                "Correo", "Teléfono", "Tipo","Consultar"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        table.setModel(clientTableModel);
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
             
        table.setRowHeight(32);
        
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(6).setResizable(false);
            table.getColumnModel().getColumn(6).setPreferredWidth(32);
        }
}
        
        
    /**
     * Método para construir una JTable con formato para la busqueda de usuarios.
     * @param table JTable que se le dará formato.
     * @param matrix Datos que se van a incorporar a la JTable.
     */
    public void buildUserTable(javax.swing.JTable table, Object[][] matrix){
        
        table.setDefaultRenderer(Object.class, new Render());
               
        DefaultTableModel userTableModel = new  DefaultTableModel(
            matrix,
            new Object[]{
                "Cédula", "Correo", "Nombre y Apellido", "Rol","Clave","Consultar"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        table.setModel(userTableModel);
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
             
        table.setRowHeight(32);
        
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(4).setPreferredWidth(32);
        }
        }

    /**
     * Método para construir una JTable con formato para la busqueda de salas de cine.
     * @param table JTable que se le dará formato.
     * @param matrix Datos que se van a incorporar a la JTable.
     */
            public void buildCinemaRoomTable(javax.swing.JTable table, Object[][] matrix){
        
        table.setDefaultRenderer(Object.class, new Render());
               
        DefaultTableModel userTableModel = new  DefaultTableModel(
            matrix,
            new Object[]{
                "Código", "Sucursal", "Fila","Columna","Consultar"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        table.setModel(userTableModel);
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
             
        table.setRowHeight(32);
        
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(4).setPreferredWidth(32);
        }

        
    }
    
    /**
     * Método para construir una JTable con formato para la búsqueda de empresas.
     * @param table JTable que se le dará formato.
     * @param matrix Datos que se van a incorporar a la JTable.
     */
    public void buildEnterpriseTable(javax.swing.JTable table, Object[][] matrix){
        
        table.setDefaultRenderer(Object.class, new Render());
               
        DefaultTableModel enterpriseTableModel = new  DefaultTableModel(
            matrix,
            new Object[]{
                "Codigo", "Nombre", "Descripcion", "Correo", "Precio Boleto","Consultar"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        table.setModel(enterpriseTableModel);
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
             
        table.setRowHeight(32);
        
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(5).setPreferredWidth(32);
        }
        
    }
    
  /**
     * Método para construir una JTable con formato para la búsqueda de peliculas.
     * @param table JTable que se le dará formato.
     * @param matrix Datos que se van a incorporar a la JTable.
     */
    public void buildFilmTable(javax.swing.JTable table, Object[][] matrix){
        
        table.setDefaultRenderer(Object.class, new Render());
               
        DefaultTableModel filmTableModel = new  DefaultTableModel(
            matrix,
            new Object[]{
                "Codigo", "Nombre", "Sinopsis", "Durarion", "Clasificacion", "Fecha de estreno", "Genero","Consultar"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        table.setModel(filmTableModel);
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
             
        table.setRowHeight(32);
        
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(7).setResizable(false);
            table.getColumnModel().getColumn(7).setPreferredWidth(32);
        }
        
    }
   
    public void buildCandyCRUDTable(javax.swing.JTable table, Object[][] matrix){
        
        table.setDefaultRenderer(Object.class, new Render());
               
        DefaultTableModel filmTableModel = new  DefaultTableModel(
            matrix,
            new Object[]{
                "Codigo", "Nombre", "Descripción", "Precio", "Consultar"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        table.setModel(filmTableModel);
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
             
        table.setRowHeight(32);
        
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(4).setPreferredWidth(32);
        }
        
    }
    
        public void buildInventoryCandyCRUDTable(javax.swing.JTable table, Object[][] matrix){
        
        table.setDefaultRenderer(Object.class, new Render());
               
        DefaultTableModel filmTableModel = new  DefaultTableModel(
            matrix,
            new Object[]{
                "Código", "Sucursal", "Golosina", "Precio(unitario)","Stock",
                "Modificar", "Eliminar"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        table.setModel(filmTableModel);
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
             
        table.setRowHeight(32);
        
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(5).setPreferredWidth(40);
            table.getColumnModel().getColumn(6).setResizable(false);
            table.getColumnModel().getColumn(6).setPreferredWidth(40);
        }
        
    }
    
    //</editor-fold>
    
    
        public static void setCellsAlignment(JTable table, int alignment)
    {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
            table.getColumnModel().getColumn(columnIndex).setResizable(false);
            table.getColumnModel().getColumn(columnIndex).setPreferredWidth(32);
        }
    }

   
}
