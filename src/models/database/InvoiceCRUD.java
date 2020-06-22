
package models.database;

import java.sql.ResultSet;
import models.Invoice;

/**
 *
 * @author Gustavo
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
    
    
}