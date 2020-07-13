
package models.database;

import java.sql.ResultSet;
import models.User;

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
  
    public boolean userExist(String email, char estatus){
        
        try{
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"usuario\" WHERE \"correo\" = '"
                            + email + "' AND \"estado\" = '" + estatus + "';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            // Si el cliente existe (que debe ser único) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar al usuario. Error: " + ex);
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
    
    /**
     * Método para obtener los datos de una sala.
     * @return Devuelve consulta.
     */
    public ResultSet readUserData(String email){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT usuario.\"correo\", empleado.\"cedula\" as cedula, "
                   + "rol.\"nombre\" as rol, "
                   + "usuario.\"clave\" as clave FROM \"usuario\", \"empleado\", \"rol\" "
                   + "WHERE usuario.\"correo\" = '" + email + "' and \"empleado_cedula\" = empleado.\"cedula\" "
                   + "and \"rol_codigo\" = rol.\"codigo\" and usuario.\"estado\" = 'A' "
                   + "and empleado.\"estado\" = 'A' and rol.\"estado\" = 'A';";
        
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
    
    //<editor-fold defaultstate="collapsed" desc="Registrar Usuario"> 
    
   public void registerUser(User us) {
            
            // Se instancia la clase para la conexiÃ³n con la BD y se establece la conexiÃ³n.
            con = new ConnectionDB();
            con.conectar();
          
            // Se descrie la sentencia SQL.
    String SQL = "INSERT INTO \"usuario\" (\"correo\",\"empleado_cedula\","
            + "\"rol_codigo\",\"clave\", \"estado\" ) "
            + "values ("
            + "'" + us.getEmail() + "', "
            + "'" + us.getEmployee_id() + "', "
            + "'" + us.getRole_id() + "', "
            + "'" + us.getPass() + "', 'A');";
    
            con.queryInsert(SQL);
     
            // Se muestra mensaje de éxito.
            System.out.println("El registro se realizó con éxito.");
        
            // Se desconecta la BD.
            con.desconectar();
    }
//</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="Actualizar Usuario"> 
   
     public void UpdateUser(User us, String email) {
         
            // Se instancia la clase para la conexion con la BD y se establece la conexion.
            con = new ConnectionDB();
            con.conectar(); 

            // Se descrie la sentencia SQL.
            String SQL = "UPDATE \"usuario\" SET "
                       +  "\"empleado_cedula\" = '" + us.getEmployee_id() + "', "
                       +  "\"rol_codigo\" = '" + us.getRole_id() + "', "
                       +  "\"clave\" = '" + us.getPass() + "' "
                       +  "WHERE \"correo\" = '" + email + "';";
            
            con.queryInsert(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
}
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Eliminar Usuario"> 
    
     
   public void DeleteUser(String email, int type) {
        
        // Se declara la variable de sentencia SQL.
        String SQL = "";
        
        // Dependiendo del valor de type, se elimina (lógica) o se reactiva el empleado.
        if(type == 0)
            SQL     = "UPDATE \"usuario\" SET \"estado\" = 'I' "
                    + "WHERE \"correo\" = '" + email + "';";
        else
            SQL     = "UPDATE \"usuario\" SET \"estado\" = 'A' "
                    + "WHERE \"correo\" = '" + email + "';";
        
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        con.queryInsert(SQL);
        
        // Se muestra mensaje de éxito.
        System.out.println("La eliminación del usuario cuya correo es '" + email + "' "
                + "se ha efectuado con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
    }

//</editor-fold>
   
   /**
     * Método para realizar una consulta en la BD.
     * @param SQL Sentencia SQL.
     * @return Consulta.
     */
    public ResultSet readUser(String SQL){
        
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
