
package models.database;

import java.sql.ResultSet;

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
public class UserCRUD {
    
    // Se declara la clase a utilizar.
    private ConnectionDB con;
    
    /**
     * Constructor.
     */
    public UserCRUD(){}
        
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
            String SQL =    "SELECT * FROM \"usuario\" WHERE \"correo\" = '"
                            + email + "' AND \"clave\" = '" + pass + 
                            "' AND \"estado\" = 'A';";
            
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
            String SQL =    "SELECT * FROM \"usuario\" WHERE \"correo\" = '"
                            + email + "' AND \"estado\" = 'A';";
            
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
        String SQL =    "UPDATE \"usuario\" SET \"clave\" = '" + pass + 
                        "' WHERE \"correo\" = '" + email + "';";
            
        // Se realiza la actualización.
        con.queryInsert(SQL);
            
        // Se desconecta la BD.
        con.desconectar();
                 
    }
    
    /**
     * Método para obtener los datos de acceso del usuario que ingresa al sistema.
     * @param email Correo Electrónico del usuario que está accediendo al sistema.
     * @return Devuelve consulta.
     */
    public ResultSet getDataAccess(String email){
        
        // Se instancia la variable para la consulta.
        ResultSet result;
        
        // Se declara e inicializa la sentencia SQL
        String SQL  = "SELECT empleado.\"nombre\" as \"NombreEmpleado\", "
                    + "\"apellido\" as \"ApellidoEmpleado\", rol.\"codigo\" as \"CodigoRol\", "
                    + "sucursal.\"nombre\" as \"NombreSucursal\" FROM \"rol\", \"empleado\", "
                    + "\"usuario\", \"sucursal\" WHERE rol.\"codigo\" = \"rol_codigo\" AND "
                    + "\"empleado_cedula\" = \"cedula\" AND \"sucursal_codigo\" = sucursal.\"codigo\" "
                    + "AND usuario.\"correo\" = '" + email + "' AND usuario.\"estado\" = 'A' AND "
                    + "rol.\"estado\" = 'A' AND empleado.\"estado\" = 'A' AND sucursal.\"estado\" = 'A';";
        
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
