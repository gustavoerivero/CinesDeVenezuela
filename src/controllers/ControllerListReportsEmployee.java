/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.Date;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import lib.SupportFunctions;
import models.Employee;
import models.database.EmployeeCRUD;
import views.PopupMessage;
import views.ListReportsEmployee;
import views.tables.Table;
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
public class ControllerListReportsEmployee implements ActionListener, MouseListener{
    
// Models
    private Employee emp;
        // Models.database
        private EmployeeCRUD empCrud;
        
    // Views
    private ListReportsEmployee reportEmp;
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
    private void cleanTable(JTable table)
      {  
    DefaultTableModel Table = (DefaultTableModel)table.getModel();
                    Table.setRowCount(0);
        }
    //</editor-fold>
    
    public ControllerListReportsEmployee(String rolUser, String nameUser, String branchUser, int numList){
        
        // Declarar la variable de las clases instanciadas.
        reportEmp   = new ListReportsEmployee();
        table = new Table();         
        support         = new SupportFunctions();  
        empCrud  = new EmployeeCRUD();
        
        // Se inicializan las variables.
        this.rolUser    = rolUser;
        this.nameUser   = nameUser;
        this.branchUser = branchUser;
        
        // Se muestra la primera pantalla.
        //support.cardSelection(braManagement.panContainerBranch, braManagement.panConsultList);
                
         loadInterface(numList);
        reportEmp.addEvents(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     //<editor-fold defaultstate="collapsed" desc=" minimizar y salir del consult list ">

         // Minimizar consult list
         if(e.getSource() == reportEmp.btnMin)
        {
            reportEmp.setExtendedState(java.awt.Frame.ICONIFIED);
            reportEmp.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir del consult list
        else if(e.getSource() == reportEmp.btnExit)
        {
            reportEmp.dispose();
        } 
        //</editor-fold>
         
     //<editor-fold defaultstate="collapsed" desc=" Report List Employee Search: listado empleado que vendieron golosinas por semana ">
        
        // Buscar a un empleado.
        else if(e.getSource() == reportEmp.btnSearchEmployee){
            
            // Si no se ingresó información para filtrar.
            if  (reportEmp.dchStartDateWeek.getCalendar()== null )
                    popup = new PopupMessage(reportEmp, true, 1, "Debe ingresar la fecha de inicio de la semana para filtrar.");
            
            // Si al menos se ingresó algún dato para filtrar.
            else{
                
                 //Date fecha=reportEmp.dchStartDateWeek.getDate();
  /*FORMA 1 NO LANZA ERROR PERO NO TRAE CONSULTA
    Calendar fecha=reportEmp.dchStartDateWeek.getCalendar();
   
  
    int fiaño=fecha.get(Calendar.YEAR);
    int fimes=fecha.get(Calendar.MONTH);
    int fidia=fecha.get(Calendar.DAY_OF_MONTH);
    
    int ffaño=fecha.get(Calendar.YEAR);
    int ffmes=fecha.get(Calendar.MONTH);
    int ffdia=fecha.get(Calendar.DAY_OF_MONTH)+6;
   
    
    String fi= fiaño+"-"+fimes+"-"+fidia;
   String ff= ffaño+"-"+ffmes+"-"+ffdia;*/
        
    //SI FUNCIONA
  //Realizar el incremento del dia para obtener la fecha fin de la semana
   Calendar fechafinal=reportEmp.dchStartDateWeek.getCalendar();
   
   //obtenemos la fecha actual del sistema
   Calendar fechaactual = Calendar.getInstance ();
   
//si la fecha de inicio de la semana es mayor que la decha actual del sistema
   if(reportEmp.dchStartDateWeek.getCalendar().after(fechaactual)){
   popup = new PopupMessage(reportEmp, true, 1, "La fecha de inicio de la semana supera a la fecha actual. No hay registros que mostrar.");
   }
   
//Si la fecha de inicio de la semana esta en el rango aceptable
   else{
   fechafinal.add(Calendar.DAY_OF_YEAR, 6); 
   
   //convertir el formato de la fecha fin de la semana calculada para mostrar en el label
   DateFormat fechaConvertida = new SimpleDateFormat("yyyy/MM/dd");		
   reportEmp.lblEndDateWeek.setText(fechaConvertida.format(fechafinal.getTime()));
   
   Calendar fechainicial=reportEmp.dchStartDateWeek.getCalendar();
   DateFormat fechaConvertida1 = new SimpleDateFormat("yyyy/MM/dd");		
   reportEmp.lblStartDateWeek.setText(fechaConvertida1.format(fechainicial.getTime()));
  
    //<editor-fold defaultstate="collapsed" desc=" intentos ">
   ///////
   /*
//String fechaminima=reportEmp.dchStartDateWeek.getMinSelectableDate().toString();
   //fechaminima.getActualMinimum(Calendar.DAY_OF_MONTH);
   
    DateFormat fechaConvertida1 = new SimpleDateFormat("yyyy/MM/dd");	
   reportEmp.lblSucursalName1.setText(fechaConvertida1.format(reportEmp.dchStartDateWeek.getMinSelectableDate()));
   ////////*/
   
   // obtenemos la fecha
/*Calendar fechaminima = reportEmp.dchStartDateWeek.getCalendar();
// calculamos el primer dia del mes anterior
Calendar inicioMesAnterior = (Calendar) fechaminima.clone(); 
inicioMesAnterior.set(Calendar.DAY_OF_MONTH, inicioMesAnterior.getActualMinimum(Calendar.DAY_OF_MONTH));
reportEmp.lblSucursalName1.setText(inicioMesAnterior.toString());*/

   //FUNCIONA PERO DA EL MES ANTERIOR
  /* Calendar fechaminima = reportEmp.dchStartDateWeek.getCalendar();
   String dia=Integer.toString(fechaminima.getMaximum(Calendar.DAY_OF_MONTH));
    String mes=Integer.toString(fechaminima.get(Calendar.MONTH));
     String año=Integer.toString(fechaminima.get(Calendar.YEAR));
     
     String min= año+"-"+mes+"-"+dia;
     reportEmp.lblSucursalName1.setText(min);*/
  /* 
   //FUNCIONA DA LA MAYOR FECHA DEL MES SELECIIONADO EN EL CALENDAR
     Calendar fechaminima = reportEmp.dchStartDateWeek.getCalendar();
String dia=Integer.toString(fechaminima.getActualMaximum(Calendar.DAY_OF_MONTH));
 fechaminima.add(Calendar.MONTH, 0);
 String año=Integer.toString(fechaminima.get(Calendar.YEAR));
SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
//dateFormat.setTimeZone(fechaminima.getTimeZone());
String mes = dateFormat.format(fechaminima.getTime());

String min= año+"-"+mes+"-"+dia;
     reportEmp.lblSucursalName1.setText(min);*/
    //</editor-fold> 
       
   //cargar la tabla
                loadTable(reportEmp.getTblListWeeklyCandySale(), empCrud.ListWeeklyCandySale(reportEmp.dchStartDateWeek.getDate().toString(),fechafinal.getTime().toString()));
                table.setCellsAlignment(reportEmp.getTblListWeeklyCandySale(), SwingConstants.CENTER);
                //liampiar campo del calendario
                reportEmp.dchStartDateWeek.setCalendar(null);
                
              
                
   
   }
         
            }
        
        }
 //<editor-fold defaultstate="collapsed" desc=" Clear List Report Employee ">
        
        // Limpiar el consultar listado.
        else if(e.getSource() == reportEmp.btnClearSearchEmployee){
            
            reportEmp.clearListReportsEmployeeSearch();
             cleanTable(reportEmp.tblListWeeklyCandySale);
   
        }
        
        //</editor-fold>
     
         //</editor-fold>
    
     //<editor-fold defaultstate="collapsed" desc=" Report List Employee Search: listado empleado que vendieron mas golosinas en un mes ">
         
         
    // Buscar a un empleado.
        else if(e.getSource() == reportEmp.btnSearchEmployee1){
            
            // Si no se ingresó información para filtrar.
            if  (reportEmp.dchDateMonth.getCalendar()== null)
                    popup = new PopupMessage(reportEmp, true, 1, "Debe ingresar una fecha del mes que desee para filtrar.");
            
            // Si al menos se ingresó algún dato para filtrar.
            else{
                //Menta de venta
                Double SellGoal=500000.00;
                
     //CALCULAR LA MENOR FECHA DEL MES SELECCIONADO EN EL CALENDAR
     Calendar fechaminima = reportEmp.dchDateMonth.getCalendar();
String dia=Integer.toString(fechaminima.getActualMinimum(Calendar.DAY_OF_MONTH));
 fechaminima.add(Calendar.MONTH, 0);
 String año=Integer.toString(fechaminima.get(Calendar.YEAR));
SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
//dateFormat.setTimeZone(fechaminima.getTimeZone());
String mes = dateFormat.format(fechaminima.getTime());
String min= año+"-"+mes+"-"+dia;
 reportEmp.lblStartDateMonth.setText(min);

//CALCULAR LA MAYOR FECHA DEL MES SELECCIONADO EN EL CALENDAR
     Calendar fechamaxima = reportEmp.dchDateMonth.getCalendar();
String dia1=Integer.toString(fechamaxima.getActualMaximum(Calendar.DAY_OF_MONTH));
 fechamaxima.add(Calendar.MONTH, 0);
 String año1=Integer.toString(fechamaxima.get(Calendar.YEAR));
SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM");
//dateFormat.setTimeZone(fechaminima.getTimeZone());
String mes1 = dateFormat1.format(fechamaxima.getTime());
String max= año1+"-"+mes1+"-"+dia1;
 reportEmp.lblEndDateMonth.setText(max);
           
            
             loadTable(reportEmp.getTblListMonthlyCandySale(), empCrud.ListMonthlyCandySale(SellGoal,min,max));
             table.setCellsAlignment(reportEmp.getTblListWeeklyCandySale(), SwingConstants.CENTER);
            reportEmp.dchDateMonth.setCalendar(null);
            
            
            }
    
    
    
        }
    
    
   //<editor-fold defaultstate="collapsed" desc=" Clear List Report Employee ">
        
        // Limpiar el consultar listado.
        else if(e.getSource() == reportEmp.btnClearSearchEmployee1){
            
            reportEmp.clearListReportsMonthlyEmployeeSearch();
             cleanTable(reportEmp.tblListMonthlyCandySale);
   
        }
        
        //</editor-fold> 
    
    
    
    
    
     //</editor-fold>
   
    
    }
    
    
     //<editor-fold defaultstate="collapsed" desc=" METODOS PARA LIMPIAR COMENTADOS ">
  /*  public static void deleteAllRows(final DefaultTableModel model) {
       for( int i = model.getRowCount() - 1; i >= 0; i-- ) {
           model.removeRow(i);
       }
}*/
    
    /*
    public void eliminar2(){
        DefaultTableModel tb = (DefaultTableModel) reportEmp.tblListMonthlyCandySale.getModel();
        int a = reportEmp.tblListMonthlyCandySale.setRowCount(0);
        }
       
    
    public void eliminar(){
        DefaultTableModel tb = (DefaultTableModel) reportEmp.tblListMonthlyCandySale.getModel();
        int a = reportEmp.tblListMonthlyCandySale.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
        tb.removeRow(tb.getRowCount()-1);
        }
       
    }
    
    public void ClearTableList(){
     DefaultTableModel tb = (DefaultTableModel) reportEmp.tblListWeeklyCandySale.getModel();  
            // tb.setColumnCount(0);
             tb.setRowCount(0);  
    }
    
    */
    
     //</editor-fold>
    
     public void loadInterface(int i)
    {
        switch(i)
        {
            case 1:
                reportEmp.lblTittle1.setText("Listado de empleados que vendieron golosinas por semana");
                support.cardSelection(reportEmp.panContent, reportEmp.panListWeeklyCandySale);
                support.cardSelection(reportEmp.panSearch, reportEmp.panSearchAdmin);
                reportEmp.lblSucursalName1.setText(branchUser);
                //loadTable(reportEmp.getTblListWeeklyCandySale(), empCrud.ListWeeklyCandySale(fi, ff));
               // table.setCellsAlignment(reportEmp.getTblListWeeklyCandySale(), SwingConstants.CENTER);
                break;
            case 2:
                reportEmp.lblTittle1.setText("Listado de empleados que vendieron mas golsoinas durante un mes");
                support.cardSelection(reportEmp.panContent, reportEmp.panListMonthlyCandySale);
                support.cardSelection(reportEmp.panSearch1, reportEmp.panSearchAdmin1);
                reportEmp.lblSucursalName1.setText(branchUser);
               // loadTable(reportEmp.getTblListMonthlyCandySale(), iCrud.candyCostCustomer());
               // table.setCellsAlignment(reportEmp.getTblListMonthlyCandySale(), SwingConstants.CENTER);

                break;                
        }
    }
     
     
     
//<editor-fold defaultstate="collapsed" desc=" no tocar">
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   //</editor-fold>



}
