
package models.database;

/**
 *
 * @author Gustavo
 */
public class UserCRUD {
    
    // Se declara la clase a utilizar.
    private ConnectionDB con;
    
    /**
     * Método para comprobar si el usuario que desea ingresar al sistema se 
     * encuentra registrado.
     * @param email correo electrónico del usuario.
     * @param pass contraseña del usuario.
     * @return variable booleana.
     */
    public boolean signer(String email, String pass){
        
        try{
            
            // Se instancia la clase para la conexión con la BD y se establece la conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se descrie la sentencia SQL.
            String SQL =    "SELECT * FROM \"Usuario\" WHERE \"Correo\" = '"
                            + email + "' AND \"Clave\" = '" + pass + 
                            "' AND \"Estado\" = 'A';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            // Si se obtuvo un resultado (que tiene que ser único) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar el usuario. Error: " + ex);
        }
        
        // De no encontrarse ningún resultado, retorna 'false'.
        return false;
        
    }
    
    /**
     * Método para comprobar la existencia de un usuario.
     * @param email correo electrónico del usuario.
     * @return variable booleana.
     */
    public boolean signer(String email){
        
        try{
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"Usuario\" WHERE \"Correo\" = '"
                            + email + "' AND \"Estado\" = 'A';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            // Si el usuario existe (que debe ser único) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar el usuario. Error: " + ex);
        }
        
        // Si el usuario no existe, retorna 'false'.
        return false;
        
    }
    
    /**
     * Método para actualizar la contraseña de un usuario.
     * @param email correo electrónico del usuario.
     * @param pass nueva contraseña
     */
    public void insertNewPass(String email, String pass){
       
        // Se instancia la clase de conexión de la BD y se establece conexión.
        con = new ConnectionDB();
        con.conectar();
          
        // Se declara la sentencia SQL.
        String SQL =    "UPDATE \"Usuario\" SET \"Clave\" = '" + pass + 
                        "' WHERE \"Correo\" = '" + email + "';";
            
        // Se realiza la actualización.
        con.queryInsert(SQL);
            
        // Se desconecta la BD.
        con.desconectar();
                 
    }
    
}
