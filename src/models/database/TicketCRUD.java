
package models.database;

import java.sql.ResultSet;

/**
 *
 * @author Gustavo
 */
public class TicketCRUD {
    
    private ConnectionDB con;
    
    public ResultSet readCodexOfTickets(int type){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        String SQL = null;
        
        // Se define la sentencia SQL a aplicar en la BD.
        if(type == 1)
            SQL = "SELECT ticket.\"codigo\" as \"ticket\", "
                    + "ticket_golosinas.\"codigo\" FROM \"ticket_golosinas\", \"ticket\" "
                    + "WHERE \"ticket_codigo\" = ticket.\"codigo\" AND \"estado\" = 'A';";
        else
            SQL = "SELECT \"codigo\" as \"ticket\", \"Codigo\" as \"codigo\" "
                    + "FROM \"ticket_funcion\", \"ticket\" WHERE \"TicketCodigo\" = \"codigo\" "
                    + "AND \"estado\" = 'A';";
        
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
