
package models.database;

// Se importan las librerías a utilizar
import java.sql.ResultSet;
import models.Candy;

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
public class CandyCRUD {
    
    // Se declaran las clases a utilizar.
    private ConnectionDB con;
    
    /**
     * Método para recibir todas las golosinas.
     * @return Devuelve consulta
     */
    
    public ResultSet readContCandyInventory(String idA)
    {
                // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
       String SQL = "SELECT COUNT(inventario_golosina.\"Codigo\") as \"cantidadGolosinas\" "
                        + "FROM \"golosinas\",\"inventario_golosina\" WHERE \"GolosinaCodigo\" = '" 
                        + idA + "' AND inventario_golosina.\"Estado\" = 'A' "
                        + "AND golosinas.\"estado\" = 'A';";
        
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
    public ResultSet ReadAllCandy(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT golosinas.\"nombre\" FROM \"golosinas\", \"inventario_golosina\", "
                        + "\"sucursal\" WHERE golosinas.\"codigo\" = \"GolosinaCodigo\" AND "
                        + "sucursal.\"codigo\" = \"SucursarCodigo\" AND \"Stock\" > 0 AND "
                        + "sucursal.\"estado\" = 'A' AND golosinas.\"estado\" = 'A' "
                        + "GROUP BY golosinas.\"nombre\";";
        
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
     * Metodo para buscar el precio de una golosina.
     * @param nameCandy nombre de la golosina.
     * @return Devuelve consulta.
     */
    public ResultSet searchPrice(String nameCandy){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT \"precio\" FROM \"golosinas\" WHERE \"nombre\" = '"
                + nameCandy + "' AND \"estado\" = 'A';";
        
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
    public ResultSet readCandyData(String idCandy){
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT \"codigo\", \"nombre\" , "
                        + "\"descripcion\", \"precio\" "
                        + "FROM \"golosinas\" WHERE \"codigo\" = '" 
                        + idCandy + "' AND "
                        + "\"estado\" = 'A';";
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
     * Método que permite conocer todas las golosinas de una sucursal.
     * @param branch Sucursal a gestionar.
     * @return Devuelve consulta.
     */
    public ResultSet ReadAllCandy(String branch){
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT golosinas.\"nombre\" FROM \"golosinas\", \"inventario_golosina\", \"sucursal\"" +
                        "WHERE sucursal.\"nombre\" = '" + branch + "' AND golosinas.\"codigo\" = \"GolosinaCodigo\"" +
                        "AND sucursal.\"codigo\" = \"SucursarCodigo\" AND \"Stock\" > 0 AND sucursal.\"estado\" = 'A'" +
                        "AND golosinas.\"estado\" = 'A';";
        
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
     * Método que permite conocer todas las golosinas registradas.
     * @param sQL instrucción sQL.
     * @return Devuelve consulta.
     */
    public ResultSet readCandys(String sQL){
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
    
    /**
     * Método que permite conocer si la golosina existe.
     * @param sQL instrucción sQL.
     * @return Devuelve consulta.
     */
    public boolean candyExist(String id){
        try{
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"golosinas\" WHERE \"codigo\" = '"
                            + id + "' AND \"estado\" = 'A';";
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            // Se desconecta la BD.
            con.desconectar();
            return rs.next();
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar la golosina. Error: " + ex);
        }
        return false;
    }
    
    
    public boolean candyExist(String id, char estatus){
        try{
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"golosinas\" WHERE \"codigo\" = '"
                            + id + "' AND \"estado\" = '" + estatus + "';";
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            // Se desconecta la BD.
            con.desconectar();
            return rs.next();
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar la golosina. Error: " + ex);
        }
        return false;
    }
    
    
    /**
     * Método para eliminar/reactivar una golosina.
     * @param id codigo de la golosina.
     * @param type Eliminación o Reactivación de la golosina:
     * '0' para eliminación.
     * Cualquier otro entero para reactivación.
     */
    public void DeleteCandy(String id, int type) {
        // Se declara la variable de sentencia SQL.
        String SQL = "";
        // Dependiendo del valor de type, se elimina (lógica) o se reactiva la golosina.
        if(type == 0)
            SQL     = "UPDATE \"golosinas\" SET \"estado\" = 'I' "
                    + "WHERE \"codigo\" = '" + id + "';";
        else
            SQL     = "UPDATE \"golosinas\" SET \"estado\" = 'A' "
                    + "WHERE \"codigo\" = '" + id + "';";
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        // Se realiza y se recibe la consulta.
        con.queryInsert(SQL);
        // Se muestra mensaje de éxito.
        System.out.println("La eliminación de la golosina '" + id + "' se ha efectuado con éxito.");
        // Se desconecta la BD.
        con.desconectar();
    }
    
        public void UpdateCandy(Candy can, String id) {
        // Se declara la sentencia SQL.
               // System.out.println("AQUI1.5");
        String  SQL = "UPDATE \"golosinas\" SET "
                +  "\"nombre\" = '" + can.getName()+ "',"
                +  "\"descripcion\" = '" + can.getDescr()+ "',"
                +  "\"precio\" = '" + can.getPrice()+ "'"
                +  " WHERE \"codigo\" = '" + id + "';";
        // Se instancia y se establece una conexión con la BD.

        con = new ConnectionDB();
        con.conectar();
        // Se realiza la actualización.
        con.queryInsert(SQL);
        // Se muestra mensaje de éxito.
        System.out.println("La actualización de datos de la golosina '" + id + "' se realizó con éxito.");
        // Se desconecta la BD.
        con.desconectar();
    }
        
    /**
     * Método para registrar una golosina.
     * @param can Clase golosina a registrar
     */
    public void registerCandy(Candy can) {
        // Se declara la sentencia SQL a aplicar.
        String SQL = "INSERT INTO \"golosinas\" (\"codigo\",\"nombre\",\"descripcion\","
                + "\"precio\", \"estado\" ) values ("
                + "'" + can.getId()+ "',"
                + "'" + can.getName()+"',"
                + "'" + can.getDescr()+ "',"
                + "'" + can.getPrice()+ "',"
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
    
        public ResultSet candy(){
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
            // Se declara una sentencia SQL.
            String SQL =    "SELECT nombre FROM \"golosinas\" WHERE \"estado\" = 'A';";
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
        // Se desconecta la BD.
        con.desconectar();
        // Retorna consulta.
        return rs;
    }
        
        
        
    public boolean corretCandyOrder(String idCandy, int stock,String idBranch){
        //boolean t=
        try{
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT inventario_golosina.\"Codigo\" FROM \"inventario_golosina\", \"golosinas\" "
                            + "WHERE \"GolosinaCodigo\"='"+ idCandy +"' AND \"SucursarCodigo\" = '"
                            + idBranch + "' AND \"Stock\" >= '"+ stock +"' "
                            + "AND golosinas.\"estado\" = 'A' AND inventario_golosina.\"Estado\" = 'A';";
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);

            // Se desconecta la BD.
            con.desconectar();
            System.out.println( idCandy+" "+stock+idBranch+" "+rs.next() );

            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar la sucursal. Error: " + ex);
        }
        
        return false;
        
    }
    
    /**
     * Método para buscar una sucursal.
     * @return devuelve consulta de la BD.
     */
    public ResultSet readOnlyCandy(String candyName){
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL  = "SELECT * FROM \"golosinas\" WHERE \"nombre\" = '" + candyName + "' "
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
    
}
