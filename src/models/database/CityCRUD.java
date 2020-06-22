
package models.database;

// Se importan las librerías a utilizar.
import java.sql.ResultSet;

/**
 *
 * @author Gustavo
 */
public class CityCRUD {
    
    // Se declara las clases a utilizar.
    private ConnectionDB con;
    
    /**
     * Método para buscar todas las sucursales.
     * @return devuelve consulta de la BD.
     */
    public ResultSet readAllCityNames(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT \"nombre\" FROM \"ciudad\" WHERE \"estado\" = 'A';";
        
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
