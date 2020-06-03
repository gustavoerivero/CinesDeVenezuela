
package lib;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class TablesUtilities extends javax.swing.table.AbstractTableModel{
    
    private String[] columnNames;
    private Object[][] data;
    
    public TablesUtilities(String[] columnNames, Object[][] data){
        this.columnNames = columnNames;
        this.data = data;
    }
      
    @Override
    public String getColumnName(int column) {
        // Nombre de las columnas para la cabecera
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        // Devuelve el número de filas
        return data != null ? data.length : 0;
    }

    @Override
    public int getColumnCount() {
        // Devuelve el número de columnas
        return columnNames.length;
    }

    /**
     * Nos devolverá la clase que contiene cada columna,
     * es necesario para trabajar correctamente con los componentes
     * que mostraremos en la tabla.
     */
    @Override
    public Class getColumnClass(int columnIndex) {
        Class clazz = Object.class;

        Object aux = getValueAt(0, columnIndex);
        if (aux != null) {
            clazz = aux.getClass();
        }

        return clazz;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Devuelve el valor que se debe mostrar en la tabla en cada celda
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Si queremos que la tabla sea editable deberemos establecer estos valores
        data[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Permitimos editar todas las celdas de la tabla
        return true;
    }

    /**
     * Nos servira para limpiar la información de una fila
     * @param row
     */
    public void reset(int row) {

        for (int i = 0; i < data[row].length - 1; i++) {
            // Para las columnas con String
            if (getColumnClass(i) == String.class) {
                setValueAt("", row, i);
            } else if(getColumnClass(i) == Boolean.class) {
                setValueAt(false, row, i);
            }
        }

    }

    /*
    public static final int GOLOSINA        = 0;
    public static final int CANTIDAD        = 1;
    public static final int PRECIO_UNIDAD   = 2;
    public static final int IVA_UNIDAD      = 3;
    public static final int MONTO_UNIDAD    = 4;
    public static final int TOTAL           = 5;
    public static final int MODIFICAR       = 6;
    public static final int ELIMINAR        = 7;
    
    public static int selectedRow;
    
    
    public void clearCandyTable(javax.swing.JTable table){
        
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null}
                },
                new String [] {
                                "Golosina", "Cantidad", "Precio (Unidad)", 
                                "IVA (Unidad)", "Monto (Unidad)", "Total", 
                                " ", " "
                }
            )   {
                    boolean[] canEdit = new boolean [] {
                        false, false, false, false, false, false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
        });
        
    }
    
    public void buildCandyTable(javax.swing.JTable table){
        
        ArrayList<String> tittlesList = new ArrayList<String>();
        
        tittlesList.add("Golosina");
        tittlesList.add("Cantidad");
        tittlesList.add("Precio (Unidad)");
        tittlesList.add("IVA (Unidad)");
        tittlesList.add("Monto (Unidad)");
        tittlesList.add("Total");
        tittlesList.add(" ");
        tittlesList.add(" ");
        
        // Se asignan los títulos al arreglo para asignar las columnas.
        String[] tittles = new String[tittlesList.size()];
        for(int i = 0; i < tittles.length; i++)
            tittles[i] = tittlesList.get(i);
        
    }
    */
}
