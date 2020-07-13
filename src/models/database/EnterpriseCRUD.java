
package models.database;

import java.sql.ResultSet;
import models.Enterprise;

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
public class EnterpriseCRUD {
    
    private ConnectionDB con;
    
    //constructor
    public EnterpriseCRUD(){}
    
        public ResultSet readEnterprise(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT * FROM \"empresa\" WHERE \"estado\" = 'A';";
        
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
        public ResultSet readOnlyEnterprise(String enterpriseName){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL  = "SELECT * FROM \"empresa\" WHERE \"nombre\" = '" + enterpriseName + "' "
                    + "AND \"estado\" = 'A';";
        
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
        
    public ResultSet readEnterpriseCN(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL  = "SELECT codigo,nombre FROM \"empresa\" WHERE \"estado\" = 'A';";
        
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
     * Método para obtener los datos de una empresa.
     * @return Devuelve consulta.
     */
    public ResultSet readEnterpriseData(String idEnterprise){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT \"codigo\",\"nombre\", \"descripcion\",\"correo\",\"precio_boleto\" FROM \"empresa\"" 
                        + "WHERE \"codigo\" = '" + idEnterprise + "' AND \"estado\" = 'A';";
        
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
     * Método para obtener a todas las empresa.
     * @return Devuelve consulta.
     */
    public ResultSet readAllEnterprise(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT * FROM \"empresa\" WHERE \"estado\" = 'A';";
        
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
     * Método para realizar una consulta en la BD.
     * @param SQL Sentencia SQL.
     * @return Consulta.
     */
    public ResultSet readEnterprise(String SQL){
        
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
     * Método para registrar a una empresa.
     * @param enter Clase empleado a registrar
     */
    public void registerEnterprise(Enterprise enter) {

        // Se declara la sentencia SQL a aplicar.
        String SQL = "INSERT INTO \"empresa\" (\"codigo\",\"nombre\",\"descripcion\","
                + "\"correo\", \"precio_boleto\", \"estado\") values ("
                + "'" + enter.getId()+ "',"
                + "'" + enter.getName() +"',"
                + "'" + enter.getDescrip() + "',"
                + "'" + enter.getEmail() + "',"
                + "'" + enter.getPriceTicket() +"',"
                + "'A');";
        
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza la consulta.
        con.queryInsert(SQL);
        
        // Se muestra mensaje de éxito.
        System.out.println("La consulta se realizó con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();

    }
    
    /**
     * Método para actualizar un registro de una Empresa.
     * @param enter Clase Empleado.
     * @param id codigo de la empresa a actualizar.
     */
    public void UpdateEnterprise(Enterprise enter, String id) {

        // Se declara la sentencia SQL.
        String  SQL = "UPDATE \"empresa\" SET "
                + "\"nombre\" = '" + enter.getName() + "',"
                +  "\"descripcion\" = '" + enter.getDescrip()+ "',"
                +  "\"correo\" = '" + enter.getEmail() + "',"
                +  "\"precio_boleto\" = " + enter.getPriceTicket()+ ","
                +  " WHERE \"codigo\" = '" + id + "';";

        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza la actualización.
        con.queryInsert(SQL);
        
        // Se muestra mensaje de éxito.
        System.out.println("La actualización de datos de la empresa '" + id + "' se realizó con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
        
    }
    
    /**
     * Método para eliminar/reactivar una Empresa.
     * @param id codigo de la empresa.
     * @param type Eliminación o Reactivación de la empresa:
     * '0' para eliminación.
     * Cualquier otro entero para reactivación.
     */
    public void DeleteEnterprise(String id, int type) {
        
        // Se declara la variable de sentencia SQL.
        String SQL = "";
        
        // Dependiendo del valor de type, se elimina (lógica) o se reactiva la empresa.
        if(type == 0)
            SQL     = "UPDATE \"empresa\" SET \"estado\" = 'I' "
                    + "WHERE \"codigo\" = '" + id + "';";
        else
            SQL     = "UPDATE \"empresa\" SET \"estado\" = 'A' "
                    + "WHERE \"codigo\" = '" + id + "';";
        
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        con.queryInsert(SQL);
        
        // Se muestra mensaje de éxito.
        System.out.println("La eliminación de la empresa '" + id + "' se ha efectuado con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
    }
    
     /**
     * Método para comprobar la existencia de una empresa activa.
     * @param id codigo de la empresa a buscar.
     * @return variable booleana.
     */
    public boolean enterpriseExist(String id){
        
        try{
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"empresa\" WHERE \"codigo\" = '"
                            + id + "' AND \"estado\" = 'A';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            // Si el usuario existe (que debe ser único) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar la empresa. Error: " + ex);
        }
        
        // Si el usuario no existe, retorna 'false'.
        return false;
        
    }
    
    /**
     * Método para comprobar la existencia de una empresa según su codigo y estado.
     * @param id codigo de la empresa a buscar.
     * @param estatus De la empresa a buscar.
     * @return variable booleana.
     */
    public boolean enterpriseExist(String id, char estatus){
        
        try{
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"empresa\" WHERE \"codigo\" = '"
                            + id + "' AND \"estado\" = '" + estatus + "';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            // Si el usuario existe (que debe ser único) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar la empresa. Error: " + ex);
        }
        
        // Si el usuario no existe, retorna 'false'.
        return false;
        
    }
    
}
