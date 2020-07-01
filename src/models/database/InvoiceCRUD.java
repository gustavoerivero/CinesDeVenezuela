
package models.database;

import java.sql.ResultSet;
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
        
        String SQL = "SELECT "
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
    
}
