package controllers;

import com.toedter.calendar.JMonthChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import lib.SupportFunctions;
import models.Invoice;
import models.database.EmployeeCRUD;
import models.database.InvoiceCRUD;
import views.PopupMessage;
import views.ListReportsMovie;
import views.tables.Table;
import views.SelectOption;

/**
 *
 * @author Michael Montero
 */
public class ControllerListReportsMovie implements ActionListener, MouseListener{
    
        // Models
    private Invoice inv;
        // Models.database
        private InvoiceCRUD iCrud;
        
    // Views
    private ListReportsMovie report;
    private PopupMessage popup;
    private Table table;
    private SelectOption select;
    
    // Controllers
    private ControllerMainMenu contMainMenu;    
    
    // Librerías de soporte
    private SupportFunctions support;   
    
    // Variables del usuario.
    private int auxM;
    
    private String  rolUser,
                    nameUser,
                    branchUser;   
    
     public ControllerListReportsMovie(String rolUser, String nameUser, String branchUser, int numList){
        
        // Declarar la variable de las clases instanciadas.
        report   = new ListReportsMovie();
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
    
     
    //<editor-fold defaultstate="collapsed" desc=" actionPerformed">
     
     
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) 
    {
        
        
         //metodos basicos
         //<editor-fold defaultstate="collapsed" desc=" minimizar y salir del consult list ">

         // Minimizar consult list
         if(evt.getSource() == report.btnMin)
        {
            report.setExtendedState(java.awt.Frame.ICONIFIED);
            report.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir del consult list
        else if(evt.getSource() == report.btnExit)
        {
            report.dispose();
        } 
        //</editor-fold>
        
         //metodos para reporte General
         //<editor-fold defaultstate="collapsed" desc=" Generar Reporte Pelicula ">
         
         if(evt.getSource() == report.btnSearchBranch4)
         {
             if(!report.txtSearchIdBranch3.getText().equals("Codigo Pelicula") && 
                !report.txtSearchIdBranch3.getText().equals("") &&
                 report.txtSearchIdBranch2.getText().equals("Nombre Pelicula"))
             {
                 
                 loadPeliculaTable(2);
                 report.txtSearchIdBranch3.setText("Codigo Pelicula");
                 report.txtSearchIdBranch2.setText("Nombre Pelicula");
             }
             
             if(!report.txtSearchIdBranch2.getText().equals("Nombre Pelicula") && 
                !report.txtSearchIdBranch2.getText().equals("") &&
                 report.txtSearchIdBranch3.getText().equals("Codigo Pelicula"))
             {
                 
                 loadPeliculaTable(1);
                 report.txtSearchIdBranch3.setText("Codigo Pelicula");
                 report.txtSearchIdBranch2.setText("Nombre Pelicula");
             }
             
             
             /*else
                 popup = new PopupMessage(report, true, 1, "Llene un solo campos para realizar el filtro");*/
         }
         //</editor-fold>
         
         //metodos para reporte por mes Pelicula
         //<editor-fold defaultstate="collapsed" desc=" Generar Reporte Pelicula ">
         if (evt.getSource() == report.btnSearchBranch5)
         {
             
             if( report.cmbSelectCine.getSelectedIndex() != 0)
             {
                 loadPeliculaPorMes();
             }
             
             else
                 popup = new PopupMessage(report, true, 1, "Llene todos los campos por favor");    
         }
  
         //</editor-fold>
         
     }
    //</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Metodo para Cargar Interfaces">
    public void loadInterface(int i)
    {
        switch(i)
        {
            case 1:
                report.lblTittle1.setText("Listado de clientes frecuentes");
                support.cardSelection(report.panContentClient, report.panListClientsFrequent);
                support.cardSelection(report.panSearch, report.panSearchAdmin);
                loadTable(report.getTblListClientsFrequent(), iCrud.invoiceClient());
                table.setCellsAlignment(report.getTblListClientsFrequent(), SwingConstants.CENTER);

                break;
            case 2:
                report.lblTittle1.setText("Listado del monto a comprar de golosinas por cliente");
                support.cardSelection(report.panContentClient, report.panListCandyExpenseClient);
                support.cardSelection(report.panSearch1, report.panSearchAdmin1);
                loadTable(report.getTblCandyExpense(), iCrud.candyCostCustomer());
                table.setCellsAlignment(report.getTblCandyExpense(), SwingConstants.CENTER);

                break;

            case 3:
                report.lblTittle1.setText("Reporte General de Peliculas");
                support.cardSelection(report.jPanel1, report.panContentFilm);
                loadPeliculaTable(3);
                break;
                
            case 4:
                report.lblTittle1.setText("Reporte Peliculas por Mes");
                support.cardSelection(report.jPanel1, report.panContentFilmMonth);
                break;
        }
    }
    
    //</editor-fold>
    

     
    
    //<editor-fold defaultstate="collapsed" desc=" Filtros de Peliculas">
    
    
    //metodos para reporte General
    
    public String BuscarPelicula(){
        
      
        
        String initSQL = "SELECT pelicula.\"nombre\" as \"nombrepelicula\", sucursal.\"nombre\" as \"nombresucursal\","
                                    + "funcion.\"codigo\" as \"funcion\", sala.\"codigo\" as \"sala\" , "
                                    + "horario.\"fecha\" as \"fecha\" , bloque.\"horainicio\" as \"hora\", "
                                    + "COUNT(ticket_funcion.\"Codigo\") as \"cantidadBoletos\","
                
                
                
               
                                    + "(SELECT SUM(factura.\"monto\" + factura.\"iva\") "
                          + "from \"pelicula\",\"sala\",\"funcion\",\"horario\", "
                          + " \"ticket\",\"ticket_funcion\",\"bloque\",\"sucursal\", "
                          + " \"factura\",\"empresa\",\"tipo_dia\", "
                          + "((SELECT cliente.\"cedula\" from \"cliente\", \"factura\",\"ticket\" "
                          + " WHERE cliente.\"cedula\" =  factura.\"cliente_cedula\" "
                          + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                          + "AND ticket.\"tipo\" = '1') AS TABLA1 "
                          + "INNER JOIN(SELECT factura.\"cliente_cedula\" from \"cliente\", \"factura\",\"ticket\", "
                          + "\"ticket_funcion\", \"horario\""
                          + "WHERE cliente.\"cedula\" =  factura.\"cliente_cedula\" "
                          + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                          + "AND ticket.\"codigo\" = ticket_funcion.\"ticketcodigo\" "
                          + "AND funcion.\"codigo\"= ticket_funcion.\"funcioncodigo\" "
                          + "and funcion.\"horario_codigo\" = horario.\"codigo\" "
                          + "AND ticket.\"tipo\" = '2')"
                          + "AS TABLA2 ON TABLA2.\"cliente_cedula\" = TABLA1.\"cedula\") as NewCli "
                          + "WHERE NewCli.\"cedula\" = factura.\"cliente_cedula\""
                          + "AND factura.\"codigo\" = ticket.\"factura_codigo\" "
                          + "and factura.\"fecha_compra\" = horario.\"fecha\""
                          + "AND ticket.\"codigo\" = ticket_funcion.\"ticketcodigo\""
                          + "AND funcion.\"codigo\" = ticket_funcion.\"funcioncodigo\""
                          + "and funcion.\"horario_codigo\" = horario.\"codigo\" "
                          + "and pelicula.\"codigo\"= funcion.\"pelicula_codigo\""
                          + "AND funcion.\"horario_codigo\" = horario.\"codigo\" "
                          + "AND horario.\"sala_codigo\"= sala.\"codigo\""
                          + "AND horario.\"tipo_dia_codigo\"= tipo_dia.\"codigo\""
                          + "AND sala.\"sucursal_codigo\" = sucursal.\"codigo\""
                          + "AND empresa.\"codigo\" = sucursal.\"empresa_codigo\") as \"Golosinas\""
 
                
     
                
                                    + " From \"sala\",\"pelicula\",\"funcion\",\"horario\","
                                    + "\"ticket\",\"ticket_funcion\", \"bloque\", \"sucursal\" ,\"factura\" "
                
                                    + "WHERE pelicula.\"codigo\" = funcion.\"pelicula_codigo\" "
                
                                    + "AND funcion.\"horario_codigo\" = horario.\"codigo\" "
                
                                   + "AND funcion.\"horario_codigo\" = horario.\"codigo\" "
                                   + "AND horario.\"sala_codigo\" = sala.\"codigo\" "
                                   + "AND bloque.\"codigo\" = horario.\"bloque_codigo\" "
                                   + "AND sala.\"sucursal_codigo\" = sucursal.\"codigo\" "
                                   + "AND funcion.\"codigo\" = ticket_funcion.\"funcioncodigo\" "
                                   + "AND ticket_funcion.\"ticketcodigo\" = ticket.\"codigo\" "
                                   + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                
                                    + "AND funcion.\"estado\" = 'A' AND ticket.\"estado\" = 'A'"
                                    + "AND factura.\"estado\" = 'A' AND pelicula.\"estado\" = 'A'"
                                    + "AND bloque.\"estado\" = 'A' AND sucursal.\"estado\" = 'A'"
                                    + "AND horario.\"estado\" = 'A' AND sala.\"estado\" = 'A'"
                                    + "GROUP BY pelicula.\"nombre\", sucursal.\"nombre\" , funcion.\"codigo\"," 
                                    + "sala.\"codigo\", horario.\"fecha\", bloque.\"horainicio\" ",
                
                
               // groupby     =  "GROUP BY pelicula.\"nombre\", sucursal.\"nombre\" , funcion.\"codigo\"," 
                               //+ "sala.\"codigo\", horario.\"fecha\", bloque.\"horainicio\" ",
                finalSQL    = ";",
                SQL         = "";
         
        // Se inicia la sentencia SQL;
        
        SQL += initSQL;
        
       return  SQL += finalSQL;
     }
    
    public String BuscarPeliculaNombre(){
        
        String initSQL = "SELECT pelicula.\"nombre\" as nombrepelicula, sucursal.\"nombre\" as nombresucursal,"
                                    + "funcion.\"codigo\" as funcion, sala.\"codigo\" as sala , "
                                    + "horario.\"fecha\" as fecha , bloque.\"horainicio\" as hora, "
                                    + "COUNT(ticket_funcion.\"codigo\") as cantidadBoletos, "
                
                
                          //metodo para total de golosinas
                          + " (SELECT SUM(factura.\"monto\" + factura.\"iva\") "
                          + "from \"pelicula\",\"sala\",\"funcion\",\"horario\", "
                          + " \"ticket\",\"ticket_funcion\",\"bloque\",\"sucursal\", "
                          + " \"factura\",\"empresa\",\"tipo_dia\", "
                          + "((SELECT cliente.\"cedula\" from \"cliente\", \"factura\",\"ticket\" "
                          + " WHERE cliente.\"cedula\" =  factura.\"cliente_cedula\" "
                          + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                          + "AND ticket.\"tipo\" = '1') AS TABLA1 "
                          + "INNER JOIN(SELECT factura.\"cliente_cedula\" from \"cliente\", \"factura\",\"ticket\", "
                          + "\"ticket_funcion\", \"horario\""
                          + "WHERE cliente.\"cedula\" =  factura.\"cliente_cedula\" "
                          + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                          + "AND ticket.\"codigo\"= ticket_funcion.\"ticketcodigo\" "
                          + "AND funcion.\"codigo\"= ticket_funcion.\"funcioncodigo\" "
                          + "and funcion.\"horario_codigo\" = horario.\"codigo\" "
                          + "AND ticket.\"tipo\" = '2')"
                          + "AS TABLA2 ON TABLA2.\"cliente_cedula\" = TABLA1.\"cedula\") as NewCli "
                          + "WHERE NewCli.\"cedula\" = factura.\"cliente_cedula\""
                          + "AND factura.\"codigo\" = ticket.\"factura_codigo\" "
                          + "and factura.\"fecha_compra\" = horario.\"fecha\""
                          + "AND ticket.\"codigo\" = ticket_funcion.\"ticketcodigo\""
                          + "AND funcion.\"codigo\" = ticket_funcion.\"funcioncodigo\""
                          + "and funcion.\"horario_codigo\" = horario.\"codigo\" "
                          + "and pelicula.\"codigo\"= funcion.\"pelicula_codigo\""
                          + "AND funcion.\"horario_codigo\" = horario.\"codigo\" "
                          + "AND horario.\"sala_codigo\"= sala.\"codigo\""
                          + "AND horario.\"tipo_dia_codigo\"= tipo_dia.\"codigo\""
                          + "AND sala.\"sucursal_codigo\" = sucursal.\"codigo\""
                          + "AND empresa.\"codigo\" = sucursal.\"empresa_codigo\") as \"Golosinas\""
                
      
                
                                    + "FROM "
                                    + "\"sala\",\"pelicula\",\"funcion\",\"horario\","
                                    + "\"ticket\",\"ticket_funcion\", \"bloque\", \"sucursal\" ,\"factura\" "
                
                                    + "WHERE pelicula.\"codigo\" = funcion.\"pelicula_codigo\" "
                
                                    + "AND funcion.\"horario_codigo\" = horario.\"codigo\" "
                
                                   + "AND funcion.\"horario_codigo\" = horario.\"codigo\" "
                                   + "AND horario.\"sala_codigo\" = sala.\"codigo\" "
                                   + "AND bloque.\"codigo\" = horario.\"bloque_codigo\" "
                                   + "AND sala.\"sucursal_codigo\" = sucursal.\"codigo\" "
                                   + "AND funcion.\"codigo\" = ticket_funcion.\"funcioncodigo\" "
                                   + "AND ticket_funcion.\"ticketcodigo\" = ticket.\"codigo\" "
                                   + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                
                                    + "AND funcion.\"estado\" = 'A' AND ticket.\"estado\" = 'A'"
                                    + "AND factura.\"estado\" = 'A' AND pelicula.\"estado\" = 'A'"
                                    + "AND bloque.\"estado\" = 'A' AND sucursal.\"estado\" = 'A'"
                                    + "AND horario.\"estado\" = 'A' AND sala.\"estado\" = 'A'",
                
                                    //+ "COUNT(ticket_funcion.\"codigo\") as cantidadBoletos"
                                    // sucursal.\"nombre\" as nombresucursal,
                                    

                
                nameSQL      = "AND pelicula.\"nombre\" = ",
                groupby     =  "GROUP BY pelicula.\"nombre\", sucursal.\"nombre\" , funcion.\"codigo\"," 
                               + "sala.\"codigo\", horario.\"fecha\", bloque.\"horainicio\" ",
                finalSQL    = ";",
                SQL         = "";
         
        // Se inicia la sentencia SQL;
        
        SQL += initSQL  + nameSQL + "'" + report.txtSearchIdBranch2.getText() + "'" + groupby;
        // Final de la sentencia la sentencia.
       return  SQL += finalSQL;
     }
    
    public String BuscarPeliculaCodigo(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        String initSQL = "SELECT pelicula.\"nombre\" as nombrepelicula, sucursal.\"nombre\" as nombresucursal,"
                                    + "funcion.\"codigo\" as funcion, sala.\"codigo\" as sala , "
                                    + "horario.\"fecha\" as fecha , bloque.\"horainicio\" as hora, "
                                    + "COUNT(ticket_funcion.\"codigo\") as cantidadBoletos "
                                    
                
                
                          //Total Golosinas
                          + "(SELECT SUM(factura.\"monto\" + factura.\"iva\") "
                          + "from \"pelicula\",\"sala\",\"funcion\",\"horario\", "
                          + " \"ticket\",\"ticket_funcion\",\"bloque\",\"sucursal\", "
                          + " \"factura\",\"empresa\",\"tipo_dia\", "
                          + "((SELECT cliente.\"cedula\" from \"cliente\", \"factura\",\"ticket\" "
                          + " WHERE cliente.\"cedula\" =  factura.\"cliente_cedula\" "
                          + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                          + "AND ticket.\"tipo\" = '1') AS TABLA1 "
                          + "INNER JOIN(SELECT factura.\"cliente_cedula\" from \"cliente\", \"factura\",\"ticket\","
                          + "\"ticket_funcion\", \"horario\""
                          + "WHERE cliente.\"cedula\" =  factura.\"cliente_cedula\" "
                          + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                          + "AND ticket.\"codigo\"= ticket_funcion.\"ticketcodigo\" "
                          + "AND funcion.\"codigo\"= ticket_funcion.\"funcioncodigo\" "
                          + "and funcion.\"horario_codigo\" = horario.\"codigo\" "
                          + "AND ticket.\"tipo\" = '2')"
                          + "AS TABLA2 ON TABLA2.\"cliente_cedula\" = TABLA1.\"cedula\") as NewCli "
                          + "WHERE NewCli.\"cedula\" = factura.\"cliente_cedula\""
                          + "AND factura.\"codigo\" = ticket.\"factura_codigo\" "
                          + "and factura.\"fecha_compra\" = horario.\"fecha\""
                          + "AND ticket.\"codigo\" = ticket_funcion.\"ticketcodigo\""
                          + "AND funcion.\"codigo\" = ticket_funcion.\"funcioncodigo\""
                          + "and funcion.\"horario_codigo\" = horario.\"codigo\" "
                          + "and pelicula.\"codigo\"= funcion.\"pelicula_codigo\""
                          + "AND funcion.\"horario_codigo\" = horario.\"codigo\" "
                          + "AND horario.\"sala_codigo\"= sala.\"codigo\""
                          + "AND horario.\"tipo_dia_codigo\"= tipo_dia.\"codigo\""
                          + "AND sala.\"sucursal_codigo\" = sucursal.\"codigo\""
                          + "AND empresa.\"codigo\" = sucursal.\"empresa_codigo\") as \"Golosinas\""
                
                
                
                
                
                
                
                
      
                                    + "FROM "
                                    + "\"sala\",\"pelicula\",\"funcion\",\"horario\","
                                    + "\"ticket\",\"ticket_funcion\", \"bloque\", \"sucursal\" ,\"factura\" "
                
                                    + "WHERE pelicula.\"codigo\" = funcion.\"pelicula_codigo\" "
                
                                    + "AND funcion.\"horario_codigo\" = horario.\"codigo\" "
                
                                   + "AND funcion.\"horario_codigo\" = horario.\"codigo\" "
                                   + "AND horario.\"sala_codigo\" = sala.\"codigo\" "
                                   + "AND bloque.\"codigo\" = horario.\"bloque_codigo\" "
                                   + "AND sala.\"sucursal_codigo\" = sucursal.\"codigo\" "
                                   + "AND funcion.\"codigo\" = ticket_funcion.\"funcioncodigo\" "
                                   + "AND ticket_funcion.\"ticketcodigo\" = ticket.\"codigo\" "
                                   + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                
                                    + "AND funcion.\"estado\" = 'A' AND ticket.\"estado\" = 'A'"
                                    + "AND factura.\"estado\" = 'A' AND pelicula.\"estado\" = 'A'"
                                    + "AND bloque.\"estado\" = 'A' AND sucursal.\"estado\" = 'A'"
                                    + "AND horario.\"estado\" = 'A' AND sala.\"estado\" = 'A'",

                codSQL       = "AND pelicula.\"codigo\" = ",
                groupby     =  "GROUP BY pelicula.\"nombre\", sucursal.\"nombre\" , funcion.\"codigo\"," 
                               + "sala.\"codigo\", horario.\"fecha\", bloque.\"horainicio\" ",
                finalSQL    = ";",
                SQL         = "";
         
        // Se inicia la sentencia SQL;
        
        SQL += initSQL  + codSQL + "'" + report.txtSearchIdBranch3.getText() + "'" + groupby;
     
        // Final de la sentencia la sentencia.
        return  SQL += finalSQL;
     }
    
    public String BuscarTotalGolosina(){
        
        //principal
        String initSQL = "SELECT SUM(factura.\"monto\" + factura.\"iva\") AS montoGolosina, "
                          + "NewCli.\"cedula\" from  \"pelicula\",\"sala\",\"funcion\",\"horario\", "
                          + " \"ticket\",\"ticket_funcion\",\"bloque\",\"sucursal\", "
                          + " \"factura\",\"empresa\",\"tipo_dia\","
                          + "((SELECT cliente.\"cedula\" from \"cliente\", \"factura\",\"ticket\" "
                          + " WHERE cliente.\"cedula\" =  factura.\"cliente_cedula\" "
                          + "AND ticket.\"factura_codigo\" =  factura.\"codigo\" "
                          + "AND ticket.\"tipo\" = '1' GROUP BY cliente.\"cedula\") AS TABLA1 "
                          + "INNER JOIN "
                          + "(SELECT factura.\"cliente_cedula\" from \"cliente\", \"factura\",\"ticket\" "
                          + " WHERE cliente.\"cedula\" =  factura.\"cliente_cedula\" "
                          + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                          + "AND ticket.\"tipo\" = '2' "
                          + "GROUP BY factura.\"cliente_cedula\")"
                          + "AS TABLA2 on TABLA2.\"cliente_cedula\" = TABLA1.\"cedula\") as NewCli "
                          + "WHERE NewCli.\"cedula\" = factura.\"cliente_cedula\""
                          + "AND factura.\"codigo\" = ticket.\"factura_codigo\" "
                          + "and factura.\"fecha_compra\" = horario.\"fecha\""
                          + "AND ticket.\"codigo\" = ticket_funcion.\"ticketcodigo\""
                          + "AND funcion.\"codigo\" = ticket_funcion.\"funcioncodigo\""
                          + "and funcion.\"horario_codigo\" = horario.\"codigo\" "
                          + "and pelicula.\"codigo\"= funcion.\"pelicula_codigo\""
                          + "AND funcion.\"horario_codigo\" = horario.\"codigo\" "
                          + "AND horario.\"sala_codigo\"= sala.\"codigo\""
                          + "AND horario.\"tipo_dia_codigo\"= tipo_dia.\"codigo\""
                          + "AND sala.\"sucursal_codigo\" = sucursal.\"codigo\""
                          + "AND empresa.\"codigo\" = sucursal.\"empresa_codigo\""
                          + "GROUP BY funcion.\"codigo\", NewCli.\"cedula\"",
  
                groupby     = "GROUP BY funcion.\"codigo\", NewCli.\"cedula\"",
                finalSQL    = ";",
                SQL         = "";
        
        /*+ "(SELECT SUM(factura.\"monto\" + factura.\"iva\") AS montoGolosina, "
                                    + "NewCli.\"cedula\" from  \"pelicula\",\"sala\",\"funcion\",\"horario\", "
                                    + " \"ticket\",\"ticket_funcion\",\"bloque\",\"sucursal\", "
                                    + " \"factura\",\"empresa\",\"tipo_dia\","
                                    + "((SELECT cliente.\"cedula\" from \"cliente\", \"factura\",\"ticket\" "
                                    + " WHERE cliente.\"cedula\" =  factura.\"cliente_cedula\" "
                                    + "AND ticket.\"factura_codigo\" =  factura.\"codigo\" "
                                    + "AND ticket.\"tipo\" = '1' GROUP BY cliente.\"cedula\") AS TABLA1 "
                                    + "INNER JOIN "
                                    + "(SELECT factura.\"cliente_cedula\" from \"cliente\", \"factura\",\"ticket\" "
                                    + " WHERE cliente.\"cedula\" =  factura.\"cliente_cedula\" "
                                    + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                                    + "AND ticket.\"tipo\" = '2' "
                                    + "GROUP BY factura.\"cliente_cedula\")"
                                    + "AS TABLA2 on TABLA2.\"cliente_cedula\" = TABLA1.\"cedula\") as NewCli "
                                    + "WHERE NewCli.\"cedula\" = factura.\"cliente_cedula\""
                                    + "AND factura.\"codigo\" = ticket.\"factura_codigo\" "
                                    + "and factura.\"fecha_compra\" = horario.\"fecha\""
                                    + "AND ticket.\"codigo\" = ticket_funcion.\"ticketcodigo\""
                                    + "AND funcion.\"codigo\" = ticket_funcion.\"funcioncodigo\""
                                    + "and funcion.\"horario_codigo\" = horario.\"codigo\" "
                                    + "and pelicula.\"codigo\"= funcion.\"pelicula_codigo\""
                                    + "AND funcion.\"horario_codigo\" = horario.\"codigo\" "
                                    + "AND horario.\"sala_codigo\"= sala.\"codigo\""
                                    + "AND horario.\"tipo_dia_codigo\"= tipo_dia.\"codigo\""
                                    + "AND sala.\"sucursal_codigo\" = sucursal.\"codigo\""
                                    + "AND empresa.\"codigo\" = sucursal.\"empresa_codigo\") AS montoGolosina"*/
         
        // Se inicia la sentencia SQL;
        
        SQL += initSQL  + groupby;
     
        // Final de la sentencia la sentencia.
        return  SQL += finalSQL;
     }
  
    
    
    //Metodos para Reporte por mes
    
    public String BuscarPeliculaPorMes(Date inicioMes, Date finMes, String Cine){
        
        //Se completa la instruccion de sucursal
        String Sucur = "Cines de Venezuela " + Cine;

        String initSQL = "SELECT pelicula.\"nombre\" as nombrepelicula, sucursal.\"nombre\" as nombresucursal,"
                                    + " sala.\"codigo\" as sala ,"
                                    + "horario.\"fecha\" as fecha , bloque.\"horainicio\" as hora, "
                                    
                
                
                                    + "(SELECT SUM(factura.\"monto\" + factura.\"iva\") "
                          + "from \"pelicula\",\"sala\",\"funcion\",\"horario\", "
                          + " \"ticket\",\"ticket_funcion\",\"bloque\",\"sucursal\", "
                          + " \"factura\",\"empresa\",\"tipo_dia\", "
                          + "((SELECT cliente.\"cedula\" from \"cliente\", \"factura\",\"ticket\" "
                          + " WHERE cliente.\"cedula\" =  factura.\"cliente_cedula\" "
                          + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                          + "AND ticket.\"tipo\" = '1') AS TABLA1 "
                          + "INNER JOIN(SELECT factura.\"cliente_cedula\" from \"cliente\", \"factura\",\"ticket\", "
                          + "\"ticket_funcion\", \"horario\""
                          + "WHERE cliente.\"cedula\" =  factura.\"cliente_cedula\" "
                          + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                          + "AND ticket.\"codigo\" = ticket_funcion.\"ticketcodigo\" "
                          + "AND funcion.\"codigo\"= ticket_funcion.\"funcioncodigo\" "
                          + "and funcion.\"horario_codigo\" = horario.\"codigo\" "
                          + "AND ticket.\"tipo\" = '2')"
                          + "AS TABLA2 ON TABLA2.\"cliente_cedula\" = TABLA1.\"cedula\") as NewCli "
                          + "WHERE NewCli.\"cedula\" = factura.\"cliente_cedula\""
                          + "AND factura.\"codigo\" = ticket.\"factura_codigo\" "
                          + "and factura.\"fecha_compra\" = horario.\"fecha\""
                          + "AND ticket.\"codigo\" = ticket_funcion.\"ticketcodigo\""
                          + "AND funcion.\"codigo\" = ticket_funcion.\"funcioncodigo\""
                          + "and funcion.\"horario_codigo\" = horario.\"codigo\" "
                          + "and pelicula.\"codigo\"= funcion.\"pelicula_codigo\""
                          + "AND funcion.\"horario_codigo\" = horario.\"codigo\" "
                          + "AND horario.\"sala_codigo\"= sala.\"codigo\""
                          + "AND horario.\"tipo_dia_codigo\"= tipo_dia.\"codigo\""
                          + "AND sala.\"sucursal_codigo\" = sucursal.\"codigo\""
                          + "AND empresa.\"codigo\" = sucursal.\"empresa_codigo\") as \"Golosinas\""
                                    
                
                
                
                                    + "FROM "
                                    + "\"sala\",\"pelicula\",\"funcion\",\"horario\","
                                    + "\"bloque\", \"sucursal\""
                
                                    + "WHERE pelicula.\"codigo\" = funcion.\"pelicula_codigo\" "
                
                                    + "AND funcion.\"horario_codigo\" = horario.\"codigo\" "
                
                                    + "AND funcion.\"horario_codigo\" = horario.\"codigo\" "
                                    + "AND horario.\"sala_codigo\" = sala.\"codigo\" "
                                    + "AND bloque.\"codigo\" = horario.\"bloque_codigo\" "
                                    + "AND sala.\"sucursal_codigo\" = sucursal.\"codigo\" "
                                    + "AND sucursal.\"nombre\" = '" + Sucur + "' "  
                                    + "AND horario.\"fecha\" >= '" + inicioMes + "' "
                                    + "AND horario.\"fecha\" < '" + finMes + "' "
                                    + "AND funcion.\"estado\" = 'A'"
                                    + "AND pelicula.\"estado\" = 'A'"
                                    + "AND bloque.\"estado\" = 'A' AND sucursal.\"estado\" = 'A'"
                                    + "AND horario.\"estado\" = 'A' AND sala.\"estado\" = 'A'",
                
                
 
                groupby     = "ORDER BY funcion.\"codigo\"",
                finalSQL    = ";",
                SQL         = "";

        // Se inicia la sentencia SQL;
        SQL += initSQL + groupby;
        
        
       return  SQL += finalSQL;
     }
    
    
    
    
   
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Metodos Para los Listados de Peliculas">
    
    
    /**
     * Método para realizar el reporte de la pelicula.
     * @return listado con la información de la pelicula.
     */
    private void loadPeliculaTable(int a){
                
        // Se instancia la clase a utilizar.
        iCrud = new InvoiceCRUD();
        
        // Se declaran los arreglos a utilizar
        ArrayList<String>   nombrePelicula      = new ArrayList<>(),
                            sucursal            = new ArrayList<>(),
                            funcion             = new ArrayList<>(),
                            codSala             = new ArrayList<>(),
                            fecha               = new ArrayList<>(),
                            inicioh             = new ArrayList<>(),
                            boleto              = new ArrayList<>(),
                            totalGolosina       = new ArrayList<>();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        java.sql.ResultSet result2;
        
            
   
        
        try {
            
        //se defeine una variable auxiliar
        String sql, sql2;
        sql = BuscarPelicula();
        
            //definimos que filtro para el reporte
          if (a == 1)
             sql = BuscarPeliculaNombre();
          if (a == 2)
             sql = BuscarPeliculaCodigo();
          if (a == 3)     
          sql = BuscarPelicula();
          
        // se define la variable de la consulta
        result = iCrud.ReportePelicula2(sql);
        

            // Se obtienen los resultados.
            while(result.next()){
                
                nombrePelicula.add(result.getString("nombrepelicula"));
                sucursal.add(result.getString("nombresucursal"));
                funcion.add(result.getString("funcion"));
                codSala.add(result.getString("sala"));
                fecha.add(result.getString("fecha"));
                inicioh.add(result.getString("hora"));
                boleto.add(result.getString("cantidadBoletos")); 
                totalGolosina.add(result.getString("Golosinas"));
            }
                        
            System.out.println("Carga exitosa de peliculas."+ nombrePelicula.size());
            
          
            
            
            // Se obtuvo al menos un resultado.
            if(nombrePelicula.size() > 0){
                

                // Se obtiene el modelo de la tabla de empleados.
                DefaultTableModel dtm = (DefaultTableModel) report.tblListFilm.getModel();

                // Limpiamos la Tabla.
                cleanTablePelicula(dtm);
            
    

                // Se añaden todos los resultados obtenidos a la tabla.
                for(int i = 0; i < nombrePelicula.size(); i++){

                    dtm.addRow(new Object[]{
                        nombrePelicula.get(i),
                        sucursal.get(i),
                        funcion.get(i),
                        codSala.get(i),
                        fecha.get(i),
                        inicioh.get(i),
                        boleto.get(i),
                        totalGolosina.get(i),
                    });
    
                }
                                
            }
            
            
            // No se obtuvo ningún resultado.
            else
                popup = new PopupMessage(report, true, 1, "No se encontraron Peliculas para Reportar.");
                            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }
    

        /**
  
    


    /**
     * Método para realizar el reporte de la pelicula.
     * @return listado con la información de la pelicula.
     */
    private void loadPeliculaPorMes(){
                
        // Se instancia la clase a utilizar.
        iCrud = new InvoiceCRUD();
        
        // Se declaran los arreglos a utilizar
        ArrayList<String>   nombrePelicula      = new ArrayList<>(),
                            sucursal            = new ArrayList<>(),
                            funcion             = new ArrayList<>(),
                            codSala             = new ArrayList<>(),
                            fecha               = new ArrayList<>(),
                            hora                = new ArrayList<>(),
                            totalGolosina       = new ArrayList<>();
                           
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            
        //se defeine una variable auxiliar

        Date inicioMes  = report.dchdateInicio.getDate();
        Date finMes     = report.dchdateFin.getDate();
        String  Cine    = report.cmbSelectCine.getSelectedItem().toString();
        
        // se define la sentencia sql
        String sql =  BuscarPeliculaPorMes(inicioMes,finMes,Cine);
          
        // se define la variable de la consulta
        result = iCrud.ReportePelicula2(sql);
            
            // Se obtienen los resultados.
            while(result.next()){
                
                nombrePelicula.add(result.getString("nombrepelicula"));
                sucursal.add(result.getString("nombresucursal"));
                codSala.add(result.getString("sala"));
                fecha.add(result.getString("fecha"));
                hora.add(result.getString("hora"));
                totalGolosina.add(result.getString("Golosinas"));
                                   
            }
            
            System.out.println("Carga exitosa de peliculas."+ nombrePelicula.size());
            
            // Se obtuvo al menos un resultado.
            if(nombrePelicula.size() > 0){
                

                // Se obtiene el modelo de la tabla de empleados.
                DefaultTableModel dtm = (DefaultTableModel) report.tblListPeliculasporMes.getModel();

                // Limpiamos la Tabla.
                cleanTablePelicula(dtm);

                // Se añaden todos los resultados obtenidos a la tabla.
                for(int i = 0; i < nombrePelicula.size(); i++){

                    dtm.addRow(new Object[]{
                        nombrePelicula.get(i),
                        sucursal.get(i),
                        codSala.get(i),
                        fecha.get(i),
                        hora.get(i),
                        totalGolosina.get(i)
                    });

                }
                                
            }
            
            
            // No se obtuvo ningún resultado.
            else
                popup = new PopupMessage(report, true, 1, "No se encontraron Peliculas para Reportar.");
                            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }

        
        
    }
    
    
    /**
     * Método para cargar la ultima columna del reporte por mes
     * @return listado con el total de golosina por pelicula.
     */
    private void loadColumnaGolosina(ResultSet resu)
      {  

                   try {
                       // Se obtiene el modelo de la tabla de empleados.
                       DefaultTableModel dtm = (DefaultTableModel) report.tblListFilm.getModel();
                       ResultSetMetaData rMd = resu.getMetaData();
                       int cantcolumnas = rMd.getColumnCount();
                       while(resu.next())
                       {
                          Object[] filas = new Object[cantcolumnas];
                                for (int b = 0; b < cantcolumnas ; b++) 
                                   {
                                      filas[b] = resu.getObject(b+8);
                                   }
                                dtm.addRow(filas);
                       }
                       
                           report.tblListFilm.setModel(dtm);
                           
                   } 
                   catch (Exception e) 
                       {
                       }
                   
    }
    
    
      /**
     * Método para limpiar la tabla de pelicula
     * @return 
     */
    private void cleanTablePelicula(DefaultTableModel table)
      {  
    DefaultTableModel Table = (DefaultTableModel) table;
                    Table.setRowCount(0);
        }

    
    //</editor-fold>

     
    
    
    //MICHAEL MONTERO
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
