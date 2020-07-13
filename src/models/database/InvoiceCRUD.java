
package models.database;

import java.sql.ResultSet;
import java.util.Calendar;
import models.Invoice;

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
public class InvoiceCRUD {
    
    private ConnectionDB con;
    
    public ResultSet regularClient(String dma1, String dma2) {

        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;

        String SQL
                = "select "
                + "cliente.\"cedula\", \"nombre\", \"apellido\", sum(\"monto\") as monto, "
                + "sum(\"iva\") as iva, sum(\"monto\"+\"iva\") as total, (select count(\"codigo\") "
                + "from \"factura\" where factura.\"cliente_cedula\"=cliente.\"cedula\" "
                + "and factura.\"estado\"='A') as cantidad from \"cliente\", \"factura\" "
                + "where factura.\"cliente_cedula\"=cliente.\"cedula\" and (select count(\"codigo\") "
                + "from \"factura\" where factura.\"cliente_cedula\"=cliente.\"cedula\" and "
                + "factura.\"estado\"='A')>1 and \"fecha_compra\">'" + dma1 + "' "
                + "and \"fecha_compra\"<'" + dma2 + "' and cliente.\"estado\"='A' "
                + "and factura.\"estado\"='A' "
                + "group by cliente.\"cedula\";";

        // la columna «cliente.cedula» debe aparecer en la cláusula GROUP BY o ser usada en una función de agregación
        //michaelmontero.idb@gmail.com
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();

        // Se realiza y se recibe la consulta.
        result = con.queryConsultar(SQL);

        System.out.println("La consulta se realizó con éxito.");

        // Se desconecta la BD.
        con.desconectar();

        // Retorna consulta.
        return result;
    }
    
    public ResultSet readCodexInvoice(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        String SQL = "SELECT \"codigo\" FROM \"factura\" WHERE \"estado\" = 'A';";
        
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        result = con.queryConsultar(SQL);
        
        System.out.println("La consulta se realizó con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
        
        // Retorna consulta.
        return result;
        
    }
    
    public void registerInvoice(Invoice inv){
        
        String SQL = "INSERT INTO \"factura\" (\"codigo\", \"empleado_cedula\", "
                + "\"cliente_cedula\", \"fecha_compra\", \"monto\", \"iva\", \"estado\") "
                + "Values("
         + "'" + inv.getId() + "', "
         + "'" + inv.getId_employee() + "', "
         + "'" + inv.getId_client() + "', "
         + "'" + inv.getDate_purchase() + "'," + inv.getAmount() + ", "
         + "" + inv.getIva() + ", "
         + "'" + inv.getEstatus() + "');";
        
        ConnectionDB con = new ConnectionDB();
        con.conectar();
        con.queryInsert(SQL);
        con.desconectar();
        
    }
    
        public ResultSet invoiceClient(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        String SQL = "SELECT "
                + "\"cliente_cedula\","
                + "\"nombre\","
                + "\"apellido\","
                + " SUM(\"monto\") as \"montoGastado\","
                + " SUM(\"iva\"),"
                + " SUM(\"monto\"+\"iva\"),"
                + " COUNT(\"cliente_cedula\")"
                + "FROM \"factura\",\"cliente\" "
                + "WHERE \"cedula\"=\"cliente_cedula\" AND factura.\"estado\" = 'A' "
                + "AND cliente.\"estado\" = 'A'"
                + "GROUP BY \"cliente_cedula\", \"nombre\",\"apellido\" "
                + " ;";
        
        // la columna «cliente.cedula» debe aparecer en la cláusula GROUP BY o ser usada en una función de agregación
        //michaelmontero.idb@gmail.com
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        result = con.queryConsultar(SQL);
        
        System.out.println("La consulta se realizó con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
        
        // Retorna consulta.
        return result;
        
    }
    
        
    public ResultSet candyCostCustomer(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        /*String SQL = "SELECT "
                + "\"cliente_cedula\","
                + "cliente.\"nombre\","
                + "cliente.\"apellido\","
                + " SUM(\"cantidad\"*\"precio\"),"
                + " COUNT(\"cliente_cedula\")"
                + "FROM \"factura\",\"cliente\",\"ticket\",\"ticket_golosinas\","
                + "\"inventario_golosina\",\"golosinas\" "
                + "WHERE \"cedula\"=\"cliente_cedula\" AND "
                + "factura.\"estado\" = 'A' AND "
                + "\"factura_codigo\" = factura.\"codigo\" AND "
                + "\"ticket_codigo\" = ticket.\"codigo\" AND "
                + "inventario_golosina.\"Codigo\" = \"inventario_gcodigo\" AND "
                + "golosinas.\"codigo\" = \"GolosinaCodigo\" "
                + "AND cliente.\"estado\" = 'A'"
                + "GROUP BY factura.\"cliente_cedula\", cliente.\"nombre\",cliente.\"apellido\" "
                + " ;";*/
        
         String SQL = "SELECT "
                 + "cliente.\"cedula\", \"nombre\", \"apellido\", SUM(\"monto\") as monto, "
                 + "count(\"cliente_cedula\") as cantidad FROM \"cliente\", \"factura\", \"ticket\", "
                 + "\"ticket_golosinas\" WHERE cliente.\"cedula\" = factura.\"cliente_cedula\" "
                 + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                 + "AND ticket.\"codigo\" = ticket_golosinas.\"ticket_codigo\""
                 + "GROUP BY cliente.\"cedula\" "
                 + ";";
        
        
        // la columna «cliente.cedula» debe aparecer en la cláusula GROUP BY o ser usada en una función de agregación
        //michaelmontero.idb@gmail.com
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        result = con.queryConsultar(SQL);
        
        System.out.println("La consulta se realizó con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
        
        // Retorna consulta.
        return result;
        
    }
    
    public ResultSet OrderMonto(String Order) {
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = null;
        
        if (Order == "Mayor a menor")
             SQL = "SELECT "
                 + "cliente.\"cedula\", \"nombre\", \"apellido\", SUM(\"monto\") as monto, "
                 + "count(\"cliente_cedula\") as cantidad FROM \"cliente\", \"factura\", \"ticket\", "
                 + "\"ticket_golosinas\" WHERE cliente.\"cedula\" = factura.\"cliente_cedula\" "
                 + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                 + "AND ticket.\"codigo\" = ticket_golosinas.\"ticket_codigo\""
                 + "GROUP BY cliente.\"cedula\""
                 + "ORDER BY SUM(\"monto\") DESC;";
        
        
        else
             SQL = "SELECT "
                 + "cliente.\"cedula\", \"nombre\", \"apellido\", SUM(\"monto\") as monto, "
                 + "count(\"cliente_cedula\") as cantidad FROM \"cliente\", \"factura\", \"ticket\", "
                 + "\"ticket_golosinas\" WHERE cliente.\"cedula\" = factura.\"cliente_cedula\" "
                 + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                 + "AND ticket.\"codigo\" = ticket_golosinas.\"ticket_codigo\""
                 + "GROUP BY cliente.\"cedula\""
                 + "ORDER BY SUM(\"monto\") ASC;";
        
        
        // la columna «cliente.cedula» debe aparecer en la cláusula GROUP BY o ser usada en una función de agregación
        //michaelmontero.idb@gmail.com
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();

        // Se realiza y se recibe la consulta.
        result = con.queryConsultar(SQL);

        System.out.println("La consulta se realizó con éxito.");

        // Se desconecta la BD.
        con.desconectar();

        // Retorna consulta.
        return result;
    }
      
      public ResultSet OrderCant(String order) {
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = null;
        
        
        if (order == "Mayor a menor")
             SQL = "SELECT "
                 + "cliente.\"cedula\", \"nombre\", \"apellido\", SUM(\"monto\") as monto, "
                 + "count(\"cliente_cedula\") as cantidad FROM \"cliente\", \"factura\", \"ticket\", "
                 + "\"ticket_golosinas\" WHERE cliente.\"cedula\" = factura.\"cliente_cedula\" "
                 + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                 + "AND ticket.\"codigo\" = ticket_golosinas.\"ticket_codigo\""
                 + "GROUP BY cliente.\"cedula\""
                 + "ORDER BY count(\"cliente_cedula\") DESC;";
        
        
        else
             SQL = "SELECT "
                 + "cliente.\"cedula\", \"nombre\", \"apellido\", SUM(\"monto\") as monto, "
                 + "count(\"cliente_cedula\") as cantidad FROM \"cliente\", \"factura\", \"ticket\", "
                 + "\"ticket_golosinas\" WHERE cliente.\"cedula\" = factura.\"cliente_cedula\" "
                 + "AND ticket.\"factura_codigo\" = factura.\"codigo\" "
                 + "AND ticket.\"codigo\" = ticket_golosinas.\"ticket_codigo\""
                 + "GROUP BY cliente.\"cedula\""
                 + "ORDER BY count(\"cliente_cedula\") ASC;";
        
        
        // la columna «cliente.cedula» debe aparecer en la cláusula GROUP BY o ser usada en una función de agregación
        //michaelmontero.idb@gmail.com
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();

        // Se realiza y se recibe la consulta.
        result = con.queryConsultar(SQL);

        System.out.println("La consulta se realizó con éxito.");

        // Se desconecta la BD.
        con.desconectar();

        // Retorna consulta.
        return result;
    }
      
    public ResultSet specialPassClient() {
        
        Calendar c = Calendar.getInstance();
        c.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        int año = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH)+1; 
        int dia = c.get(Calendar.DAY_OF_MONTH); 
        
        String fecha1= 1 + "/" + mes + "/" + año;
        String fecha2= dia + "/" + mes + "/" + año;

        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;

        String SQL
                = "select "
                + "\"cedula\", \"nombre\", \"apellido\", \"telefono\" "
                + "from \"cliente\", \"factura\" "
                + "where factura.\"cliente_cedula\"=cliente.\"cedula\" and (select count(\"codigo\") "
                + "from \"factura\" where factura.\"cliente_cedula\"=cliente.\"cedula\" and "
                + "factura.\"estado\"='A')>1 "
                + "and \"fecha_compra\">'" + fecha1 + "' "
                + "and \"fecha_compra\"<'" + fecha2 + "' "
                + "and cliente.\"estado\"='A' "
                + "and factura.\"estado\"='A' "
                + "group by \"cedula\";";
        
        // la columna «cliente.cedula» debe aparecer en la cláusula GROUP BY o ser usada en una función de agregación
        //michaelmontero.idb@gmail.com
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();

        // Se realiza y se recibe la consulta.
        result = con.queryConsultar(SQL);

        System.out.println("La consulta se realizó con éxito.");

        // Se desconecta la BD.
        con.desconectar();

        // Retorna consulta.
        return result;
    }
    public ResultSet ReportePelicula2(String SQL){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
      
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        result = con.queryConsultar(SQL);
        
        System.out.println("La consulta se realizó con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
        
        // Retorna consulta.
        return result;
        
    }
    
}
