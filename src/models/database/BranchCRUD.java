
package models.database;

// Se importan las librerías a utilizar.
import java.sql.ResultSet;
import models.Branch;

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
    
    /**
     * Método para buscar una sucursal.
     * @return devuelve consulta de la BD.
     */
    public ResultSet readOnlyBranch(String branchName){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL  = "SELECT * FROM \"sucursal\" WHERE \"nombre\" = '" + branchName + "' "
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
    

        public ResultSet readBranchs(String sQL){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        result = con.queryConsultar(sQL);
        
        // Se desconecta la BD.
        con.desconectar();
        
        // Retorna consulta.
        return result;
        
    }
        
        
    public boolean branchExist(String id){
        
        try{
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"sucursal\" WHERE \"codigo\" = '"
                            + id + "' AND \"estado\" = 'A';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar la sucursal. Error: " + ex);
        }
        
        return false;
        
    }
            
    public boolean branchExist(String id, char estatus){
        
        try{
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"sucursal\" WHERE \"codigo\" = '"
                            + id + "' AND \"estado\" = '" + estatus + "';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar la sucursal. Error: " + ex);
        }
        
        return false;
        
    }
                
                   /**
     * Método para eliminar/reactivar una sucursal.
     * @param id codigo de la sucursal.
     * @param type Eliminación o Reactivación de la sucursal:
     * '0' para eliminación.
     * Cualquier otro entero para reactivación.
     */
    public void DeleteBranch(String id, int type) {
        
        // Se declara la variable de sentencia SQL.
        String SQL = "";
        
        // Dependiendo del valor de type, se elimina (lógica) o se reactiva la suucursal.
        if(type == 0)
            SQL     = "UPDATE \"sucursal\" SET \"estado\" = 'I' "
                    + "WHERE \"codigo\" = '" + id + "';";
        else
            SQL     = "UPDATE \"sucursal\" SET \"estado\" = 'A' "
                    + "WHERE \"codigo\" = '" + id + "';";
        
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        con.queryInsert(SQL);
        
        // Se muestra mensaje de éxito.
        System.out.println("La eliminación de la sucursal '" + id + "' se ha efectuado con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
    }
    
        public void UpdateBranch(Branch bran, String id) {
        // Se declara la sentencia SQL.
        String  SQL = "UPDATE \"sucursal\" SET "
                +  "\"empresa_codigo\" = '" + bran.getEnterprise_id()+ "',"
                +  "\"ciudad_codigo\" = '" + bran.getCity_Id()+ "',"
                +  "\"nombre\" = '" + bran.getName() + "',"
                +  "\"direccion\" = '" + bran.getDirec()+ "',"
                +  "\"telefono\" = '" + bran.getPhone()+ "'"
                +  " WHERE \"codigo\" = '" + id + "';";

        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza la actualización.
        con.queryInsert(SQL);
        
        // Se muestra mensaje de éxito.
        System.out.println("La actualización de datos de la sucursal '" + id + "' se realizó con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
        
    }
        
    /**
     * Método para registrar una sucursal.
     * @param bra Clase sucursal a registrar
     */
    public void registerBranch(Branch bra) {

        // Se declara la sentencia SQL a aplicar.
        String SQL = "INSERT INTO \"sucursal\" (\"codigo\",\"empresa_codigo\",\"ciudad_codigo\","
                + "\"nombre\", \"direccion\", \"telefono\", \"estado\" ) values ("
                + "'" + bra.getId()+ "',"
                + "'" + bra.getEnterprise_id()+"',"
                + "'" + bra.getCity_Id() + "',"
                + "'" + bra.getName() + "',"
                + "'" + bra.getDirec()+"',"
                + "'" + bra.getPhone()+ "',"
                + "'A');";
        
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza la consulta.
        con.queryInsert(SQL);
        
        // Se muestra mensaje de éxito.
        System.out.println("El registro se realizó con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();

    }    
    
    
        /**
     * Método para obtener los datos de un empleado.
     * @return Devuelve consulta.
     */
    public ResultSet readBranchData(String idBranch){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT sucursal.\"codigo\", empresa.\"nombre\" as \"NombreEmpresa\", "
                        + "sucursal.\"nombre\", \"direccion\", "
                        + "ciudad.\"nombre\" as \"NombreCiudad\", sucursal.\"telefono\" "
                        + "FROM \"sucursal\",\"empresa\",\"ciudad\"WHERE sucursal.\"codigo\" = '" 
                        + idBranch + "' AND \"empresa_codigo\" = empresa.\"codigo\" "
                        +"AND \"ciudad_codigo\" = ciudad.\"codigo\" "
                        + "AND empresa.\"estado\" = 'A' AND ciudad.\"estado\" = 'A'"
                        + "AND sucursal.\"estado\" = 'A';";
        
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

        public ResultSet readContEmployeeBranch(String idBranch){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
       String SQL = "SELECT COUNT(empleado.\"cedula\") as \"cantidadEmpleados\" "
                        + "FROM \"empleado\",\"sucursal\" WHERE \"sucursal_codigo\" = '" 
                        + idBranch + "' AND empleado.\"estado\" = 'A' "
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
}
