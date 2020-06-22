
package models.database;

// Se importan las librerías a utilizar.
import java.sql.ResultSet;

/**
 *
 * @author Gustavo
 */
public class BranchCRUD {
    
    // Se declara la clase a utilizar.
    private ConnectionDB con;
    
    /**
     * Método para buscar todas las sucursales.
     * @return devuelve consulta de la BD.
     */
    public ResultSet readAllBranch(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT * FROM \"sucursal\" WHERE \"estado\" = 'A';";
        
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        result = con.queryConsultar(SQL);
        
        // Se desconecta la BD.
        con.desconectar();
        
        // Retorna consulta.
        return result;
        
    }
    
    /**
     * Método para buscar todas las sucursales de una ciudad.
     * @return devuelve consulta de la BD.
     */
    public ResultSet readBranchOnCity(String city){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT sucursal.\"nombre\" FROM \"ciudad\", \"sucursal\" "
                + "WHERE ciudad.\"codigo\" = sucursal.\"ciudad_codigo\" "
                + "AND ciudad.\"nombre\" = '" + city +"' AND ciudad.\"estado\" = 'A' "
                + "AND sucursal.\"estado\" = 'A';";
        
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        result = con.queryConsultar(SQL);
        
        // Se desconecta la BD.
        con.desconectar();
        
        // Retorna consulta.
        return result;
        
    }
    
    public ResultSet readBranchForCity(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT ciudad.\"nombre\" as \"NombreCiudad\", "
                + "sucursal.\"nombre\" as \"NombreSucursal\" "
                + "FROM \"ciudad\", \"sucursal\" WHERE ciudad.\"codigo\" = sucursal.\"ciudad_codigo\" "
                + "AND ciudad.\"estado\" = 'A' AND sucursal.\"estado\" = 'A';";
        
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        result = con.queryConsultar(SQL);
        
        // Se desconecta la BD.
        con.desconectar();
        
        // Retorna consulta.
        return result;
        
    }
    
}
