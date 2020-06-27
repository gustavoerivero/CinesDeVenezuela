
package models.database;

import java.sql.ResultSet;
import models.Client;

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
public class ClientCRUD {
    
    private ConnectionDB con;
    
    /**
     * Método para buscar un cliente.
     * @param id código del cliente.
     * @return Consulta.
     */
    public ResultSet ReadOnlyOneClient(String id){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT * FROM \"cliente\" WHERE \"cedula\" = '" + id + 
                "' AND \"estado\" = 'A';";
        
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
    
    /**
     * Método para comprobar si el cliente ingresado al sistema se 
     * encuentra registrado.
     * @param id cedula del cliente.
     * @return variable booleana.
     */
    public boolean signer(String id){
        try{
            
            // Se instancia la clase para la conexión con la BD y se establece la conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se descrie la sentencia SQL.
            String SQL =    "SELECT * FROM \"cliente\" WHERE \"cedula\" = '"
                            + id + "' AND \"estado\" = 'A';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            // Si se obtuvo un resultado (que tiene que ser único) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar al Cliente. Error: " + ex);
        }
        
        // De no encontrarse ningún resultado, retorna 'false'.
        return false;
        
    }
    
     public void registerClient(Client cli) {
            
            // Se instancia la clase para la conexión con la BD y se establece la conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se descrie la sentencia SQL.
    String SQL = "INSERT INTO \"cliente\" (\"cedula\",\"nombre\","
            + "\"apellido\",\"direccion\",\"correo\", \"telefono\", \"fecha_nacimiento\" ) "
            + "values ("
            + "'" + cli.getId()+ "',"
            + "'" + cli.getName() + "',"
            + "'" + cli.getSurname() + "',"
            + "'" + cli.getDirection() + "',"
            + "'" + cli.getEmail() + "',"
            + "'" + cli.getPhone() +"',"
            + "'" + cli.getBirth_date()+"');";
    
     con.queryInsert(SQL);
     
            // Se desconecta la BD.
            con.desconectar();
    }
     
}
     
