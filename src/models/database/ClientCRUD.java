
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
        
        // Se instancia y se establece una conexiÃ³n con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        result = con.queryConsultar(SQL);
        
        System.out.println("La consulta se realizÃ³ con Ã©xito.");
        
        // Se desconecta la BD.
        con.desconectar();
        
        // Retorna consulta.
        return result;
        
    }
   
    //<editor-fold defaultstate="collapsed" desc="Verificar existencia de un cliente activo "> 
    
    public boolean signer(String id){
        try{
            
            // Se instancia la clase para la conexiÃ³n con la BD y se establece la conexiÃ³n.
            con = new ConnectionDB();
            con.conectar();
          
            // Se descrie la sentencia SQL.
            String SQL =    "SELECT * FROM \"cliente\" WHERE \"cedula\" = '"
                            + id + "' AND \"estado\" = 'A';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            // Si se obtuvo un resultado (que tiene que ser Ãºnico) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar al Cliente. Error: " + ex);
        }
        
        // De no encontrarse ningun resultado, retorna 'false'.
        return false;
        
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Verificar existencia de un cliente con cualquier estado ">
    public boolean signer(String id, char estatus){
        
        try{
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"cliente\" WHERE \"cedula\" = '"
                            + id + "' AND \"estado\" = '" + estatus + "';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            // Si el cliente existe (que debe ser único) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar el cliente. Error: " + ex);
        }
        
        // Si el usuario no existe, retorna 'false'.
        return false;
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Registrar Cliente "> 
    
   public void registerClient(Client cli) {
            
            // Se instancia la clase para la conexiÃ³n con la BD y se establece la conexiÃ³n.
            con = new ConnectionDB();
            con.conectar();
          
            // Se descrie la sentencia SQL.
    String SQL = "INSERT INTO \"cliente\" (\"cedula\", \"nombre\", "
            + "\"apellido\", \"direccion\", \"correo\", \"telefono\", \"fecha_nacimiento\" ) "
            + "values ("
            + "'" + cli.getId()+ "', "
            + "'" + cli.getName() + "', "
            + "'" + cli.getSurname() + "', "
            + "'" + cli.getDirection() + "', "
            + "'" + cli.getEmail() + "', "
            + "'" + cli.getPhone() +"', "
            + "'" + cli.getBirth_date()+"' );";
    
     con.queryInsert(SQL);
     
            // Se desconecta la BD.
            con.desconectar();
    }
//</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="Actualizar Cliente"> 
   
     public void UpdateClient(Client cli, String id) {
         
            // Se instancia la clase para la conexiÃƒÂ³n con la BD y se establece la conexiÃƒÂ³n.
            con = new ConnectionDB();
            con.conectar(); 

            // Se descrie la sentencia SQL.
            String SQL = "UPDATE \"cliente\" SET \"nombre\" = '" + cli.getName() + "',"
                       + "\"apellido\" = '" + cli.getSurname() + "',"
                       +  "\"direccion\" = '" + cli.getDirection() + "',"
                       +  "\"correo\" = '" + cli.getEmail() + "',"
                       +  "\"telefono\" = '" + cli.getPhone() + "',"
                       +  "\"fecha_nacimiento\" = '" + cli.getBirth_date() + "',"
                       +  "\"tipo\" = '" + cli.getType() + "',"
                       +  " WHERE \"Cedula\" = '" + cli.getId() + "',";
            
            con.queryInsert(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
}
//</editor-fold>
     
    //<editor-fold defaultstate="collapsed" desc="Eliminar Cliente"> 
    
     
   public void DeleteClient(String id, int type) {
        
        // Se declara la variable de sentencia SQL.
        String SQL = "";
        
        // Dependiendo del valor de type, se elimina (lógica) o se reactiva el empleado.
        if(type == 0)
            SQL     = "UPDATE \"cliente\" SET \"estado\" = 'I' "
                    + "WHERE \"cedula\" = '" + id + "';";
        else
            SQL     = "UPDATE \"cliente\" SET \"estado\" = 'A' "
                    + "WHERE \"cedula\" = '" + id + "';";
        
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        con.queryInsert(SQL);
        
        // Se muestra mensaje de éxito.
        System.out.println("La eliminación del cliente cuya cedula es '" + id + "' "
                + "se ha efectuado con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Obtener todos los clientes">       
   
    
    public ResultSet readAllClientes()
    { 
            ResultSet resu;
            
            // Se instancia la clase para la conexiÃƒÂ³n con la BD y se establece la conexiÃƒÂ³n.
            con = new ConnectionDB();
            con.conectar();
            
            // Se descrie la sentencia SQL.
            String SQL = "SELECT * FROM \"Cliente\"WHERE \"estado\" = 'A';"; 
    
            resu = con.queryConsultar(SQL);
             
            con.desconectar();
            return resu;
}


 //</editor-fold>
    
    
    
    /**
     * Método para realizar una consulta en la BD.
     * @param SQL Sentencia SQL.
     * @return Consulta.
     */
    public ResultSet readClient(String SQL){
        
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
    
    
    /**
     * Método para obtener los datos de un empleado.
     * @return Devuelve consulta.
     */
    public ResultSet readClientData(String idClient){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT \"cedula\", \"nombre\", \"apellido\", \"direccion\","
                + " \"correo\",\"telefono\",\" tipo\" FROM\" cliente\" WHERE"
                + "\" cedula\" = '"+ idClient +"' \" AND \"estado\" = 'A';";
        
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
