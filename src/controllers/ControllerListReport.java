package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import lib.SupportFunctions;
import models.Invoice;
import models.database.InvoiceCRUD;
import views.PopupMessage;
import views.ListReports;
import views.tables.Table;

/**
 *
 * @author Michael Montero
 */
public class ControllerListReport implements ActionListener, MouseListener{
    
        // Models
    private Invoice inv;
        // Models.database
        private InvoiceCRUD iCrud;
        
    // Views
    private ListReports report;
    private PopupMessage popup;
    private Table table;
    
    // Controllers
    private ControllerMainMenu contMainMenu;    
    
    // Librerías de soporte
    private SupportFunctions support;   
    
    // Variables del usuario.
    private int auxM;
    
    private String  rolUser,
                    nameUser,
                    branchUser;   
    
    //<editor-fold defaultstate="collapsed" desc=" Cargar Informacion a las tablas">
    /**
     * Método para cargar una tabla
     * @tableGet es un metodo get de la vista ConsultList que retorna la tabla
     * @tableSet es la tabla donde se desea imprimir
     * @resu es la consulta que se desea imprimir en la tabla
     */    
    private void loadTable(JTable tableGet,ResultSet resu)
      {  
        try {
            DefaultTableModel Table = (DefaultTableModel) tableGet.getModel();
            ResultSetMetaData rMd = resu.getMetaData();
            int cantcolumnas = rMd.getColumnCount();
            while(resu.next()){
                Object[] filas = new Object[cantcolumnas];
                    for (int i = 0; i < cantcolumnas ; i++) 
                    {
                        filas[i] = resu.getObject(i+1);
                    }
                    Table.addRow(filas);
            }
            tableGet.setModel(Table);
        } catch (Exception e) {
        }
    }
    //</editor-fold>

    
    //<editor-fold defaultstate="collapsed" desc=" Limpiar informacion de la tablas">
    /**
     * Método que limpia un JTable
     * @table es el JTable que se va a limpiar
     */    
    private void clearTable(JTable table)
      {  
    DefaultTableModel Table = (DefaultTableModel)table.getModel();
                    Table.setRowCount(0);
        }
    //</editor-fold>
     public ControllerListReport(String rolUser, String nameUser, String branchUser, int numList){
        
        // Declarar la variable de las clases instanciadas.
        report   = new ListReports();
        table = new Table();         
        support         = new SupportFunctions();  
        iCrud  = new InvoiceCRUD();
        
        // Se inicializan las variables.
        this.rolUser    = rolUser;
        this.nameUser   = nameUser;
        this.branchUser = branchUser;
        
        // Se muestra la primera pantalla.
        //support.cardSelection(braManagement.panContainerBranch, braManagement.panConsultList);
                
         loadInterface(numList);
        report.addEvents(this);
    }
     
     


    @Override
    public void actionPerformed(ActionEvent e) {
        
    //<editor-fold defaultstate="collapsed" desc=" minimizar y salir del consult list ">

         // Minimizar consult list
         if(e.getSource() == report.btnMin)
        {
            report.setExtendedState(java.awt.Frame.ICONIFIED);
            report.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir del consult list
        else if(e.getSource() == report.btnExit)
        {
            report.dispose();
        } 
        //</editor-fold>
       
    //<editor-fold defaultstate="collapsed" desc=" Filtrar por intervalo de fechas ">

        else if(e.getSource() == report.btnSearchClient){
            
            // Si se ingresó información para filtrar.
            if  ((!report.dchdate1Client.getDate().equals("")) &&
                    (!report.dchdate2Client.getDate().equals(""))){
           
            clearTable(report.tblListClientsFrequent);
                loadTable(report.getTblListClientsFrequent(), iCrud.regularClient(report.dchdate1Client.getDate().toString(), report.dchdate2Client.getDate().toString()));
                table.setCellsAlignment(report.getTblListClientsFrequent(), SwingConstants.CENTER);
            }
            else 
                popup = new PopupMessage(report, true, 1, "Debe ingresar al menos un dato para filtrar.");
                
        }
       
        //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Filtrar por orden">

       else if(e.getSource() == report.btnSearchClient2){
            
            // Si no se ingresó información para filtrar.
            if  ((report.cmbOrderCant.getSelectedIndex() == 0) &&
                    (report.cmbOrderMonto.getSelectedIndex() == 0))
          popup = new PopupMessage(report, true, 1, "Debe ingresar al menos un dato para filtrar.");
            
            else if ((report.cmbOrderCant.getSelectedIndex() != 0) &&
                    (report.cmbOrderMonto.getSelectedIndex() == 0)){
              
             clearTable(report.tblListCandyExpenseClient);
             loadTable(report.getTblCandyExpense(), iCrud.OrderCant(report.cmbOrderCant.getSelectedItem().toString()));
             table.setCellsAlignment(report.getTblCandyExpense(), SwingConstants.CENTER);
                            }
            
           
            else if ((report.cmbOrderCant.getSelectedIndex() == 0) &&
                    (report.cmbOrderMonto.getSelectedIndex() != 0)){
         
             clearTable(report.tblListCandyExpenseClient);
             loadTable(report.getTblCandyExpense(), iCrud.OrderMonto(report.cmbOrderMonto.getSelectedItem().toString()));
             table.setCellsAlignment(report.getTblCandyExpense(), SwingConstants.CENTER);
              
             }
            
            else if ((report.cmbOrderMonto.getSelectedIndex() != 0) &&
                    (report.cmbOrderMonto.getSelectedIndex() != 0)){
         
             clearTable(report.tblListCandyExpenseClient);
             loadTable(report.getTblCandyExpense(), iCrud.OrderMonto(report.cmbOrderMonto.getSelectedItem().toString()));
             table.setCellsAlignment(report.getTblCandyExpense(), SwingConstants.CENTER);                   
        }
            
        }
       
    
        //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc=" Filtrar por mes">

        /*else if(e.getSource() == report.btnSearchClient1){
            
            // Si no se ingresó información para filtrar.
            if  (report.cmbSelecMes.getSelectedIndex() == 0)
                popup = new PopupMessage(report, true, 1, "Debe ingresar al menos un dato para filtrar.");
           
            else
            clearTable(report.tblListSpecialPass);
                loadTable(report.getTblListSpecialPass(), iCrud.specialPassClient());
                table.setCellsAlignment(report.getTblListSpecialPass(), SwingConstants.CENTER);  
        }*/
        
        
       
        //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Limpiar">
      
       else if (e.getSource() == report.btnClearFiltro){
           
           report.dchdate1Client.setCalendar(null);
           report.dchdate2Client.setCalendar(null);
       }
       
       else if (e.getSource() == report.btnClearFiltro1){
           
           report.cmbSelecMes.setSelectedIndex(0);
       }

       else if (e.getSource() == report.btnClearFiltro2){
           
           report.cmbOrderMonto.setSelectedIndex(0);
           report.cmbOrderCant.setSelectedIndex(0);
       }
        //</editor-fold>       
    }

    
    public void loadInterface(int i)
    {
        switch(i)
        {
            case 1:
                report.lblTittle1.setText("Listado de clientes frecuentes");
                support.cardSelection(report.panContent, report.panListClientsFrequent);
                support.cardSelection(report.panSearch, report.panSearchAdmin);
                loadTable(report.getTblListClientsFrequent(), iCrud.invoiceClient());
                table.setCellsAlignment(report.getTblListClientsFrequent(), SwingConstants.CENTER);
                break;
                
            case 2:
                report.lblTittle1.setText("Listado del monto a comprar de golosinas por cliente");
                support.cardSelection(report.panContent, report.panListCandyExpenseClient);
                support.cardSelection(report.panSearch1, report.panSearchAdmin1);
                loadTable(report.getTblCandyExpense(), iCrud.candyCostCustomer());
                table.setCellsAlignment(report.getTblCandyExpense(), SwingConstants.CENTER);

                break;
                
            case 3:
                report.lblTittle1.setText("Listado de clientes frecuentes que recibieron pase especial");
                support.cardSelection(report.panContent, report.panListSpecialPass);
                support.cardSelection(report.panSearch2, report.panSearchAdmin2);
                loadTable(report.getTblListSpecialPass(), iCrud.specialPassClient());
                table.setCellsAlignment(report.getTblListSpecialPass(), SwingConstants.CENTER);
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     

}
