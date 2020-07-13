
package models.database;

// Se importan las librerÃ­as a utilizar
import java.sql.ResultSet;
import models.CandyInventory;

/**
 *  Materia: Laboratorio I
 *  SecciÃ³n: 1
 *      Integrantes:
 *          @author Brizuela, Yurisbellys   C.I: 27.142.239
 *          @author Miranda, Marihec        C.I: 26.120.075
 *          @author Montero, Michael        C.I: 26.561.077
 *          @author Rivero, Gustavo         C.I: 26.772.857
 *          @author Torrealba, Luis         C.I: 26.121.249
 */
public class CandyInventoryCRUD 
{
    // Se declaran las clases a utilizar.
    private ConnectionDB con;
    
    public void UpdateCandy(CandyInventory can, String id) {
        // Se declara la sentencia SQL.
               // System.out.println("AQUI1.5");
               
        String  SQL = "UPDATE \"inventario_golosina\" SET "
                +  "\"Stock\" = '" + can.getStock()+ "'"
                +  " WHERE \"Codigo\" = '" + id + "';";
        // Se instancia y se establece una conexiÃ³n con la BD.

        con = new ConnectionDB();
        con.conectar();
        // Se realiza la actualizaciÃ³n.
        con.queryInsert(SQL);
        // Se muestra mensaje de Ã©xito.
        System.out.println("La actualizaciÃ³n de datos del inventario '" + id + " "+can.getStock() + "' se realizÃ³ con Ã©xito.");
        // Se desconecta la BD.
        con.desconectar();
    }
    
    /**
     * MÃ©todo para registrar una golosina.
     * @param can Clase golosina a registrar
     */
    public void registerCandy(CandyInventory can) {
        // Se declara la sentencia SQL a aplicar.
        String SQL = "INSERT INTO \"inventario_golosina\" (\"Codigo\",\"GolosinaCodigo\",\"SucursarCodigo\","
                + "\"Stock\", \"Estado\" ) values ("
                + "'" + can.getId()+ "',"
                + "'" + can.getIdCandy()+"',"
                + "'" + can.getIdBranch()+ "',"
                + "'" + can.getStock()+ "',"
                + "'A');";
        // Se instancia y se establece una conexiÃ³n con la BD.
        con = new ConnectionDB();
        con.conectar();
        // Se realiza la consulta.
        con.queryInsert(SQL);
        // Se muestra mensaje de Ã©xito.
        System.out.println("El registro se realizÃ³ con Ã©xito.");
        // Se desconecta la BD.
        con.desconectar();
    }
    
    

     /**
     * MÃ©todo que permite conocer todas las golosinas registradas.
     * @param sQL instrucciÃ³n sQL.
     * @return Devuelve consulta.
     */
    public ResultSet readCandys(String sQL){
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        // Se instancia y se establece una conexiÃ³n con la BD.
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
     * MÃ©todo para obtener los datos de un empleado.
     * @return Devuelve consulta.
     */
    public ResultSet readCandyData(String idCandy){
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT \"Codigo\", \"nombre\" , "
                        + "\"descripcion\", \"precio\", \"Stock\" "
                        + "FROM \"golosinas\", \"inventario_golosina\" WHERE \"Codigo\" = '" 
                        + idCandy + "' AND "
                        + "\"estado\" = 'A' AND \"Estado\" = 'A';";
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
    /**
     * MÃ©todo para eliminar/reactivar una golosina.
     * @param id codigo de la golosina.
     * @param type EliminaciÃ³n o ReactivaciÃ³n de la golosina:
     * '0' para eliminaciÃ³n.
     * Cualquier otro entero para reactivaciÃ³n.
     */
    public void DeleteCandy(String id, int type) {
        // Se declara la variable de sentencia SQL.
        String SQL = "";
        // Dependiendo del valor de type, se elimina (lÃ³gica) o se reactiva la golosina.
        if(type == 0)
            SQL     = "UPDATE \"inventario_golosina\" SET \"Estado\" = 'I' "
                    + "WHERE \"Codigo\" = '" + id + "';";
        else
            SQL     = "UPDATE \"inventario_golosina\" SET \"Estado\" = 'A' "
                    + "WHERE \"Codigo\" = '" + id + "';";
        // Se instancia y se establece una conexiÃ³n con la BD.
        con = new ConnectionDB();
        con.conectar();
        // Se realiza y se recibe la consulta.
        con.queryInsert(SQL);
        // Se muestra mensaje de Ã©xito.
        System.out.println("La eliminaciÃ³n de la golosina '" + id + "' se ha efectuado con Ã©xito.");
        // Se desconecta la BD.
        con.desconectar();
    }
    
    public ResultSet readSQL(String sQL){
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        // Se instancia y se establece una conexiÃ³n con la BD.
        con = new ConnectionDB();
        con.conectar();
        // Se realiza y se recibe la consulta.
        result = con.queryConsultar(sQL);
        // Se desconecta la BD.
        con.desconectar();
        // Retorna consulta.
        return result;
    }
    
    
 public boolean InventoryExist(String idBranch, String idCandy, char estatus){
        
        try{
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"inventario_golosina\" WHERE \"SucursarCodigo\" = '"
                            + idBranch + "' AND \"GolosinaCodigo\" = '"+ idCandy +"' AND \"Estado\" = '" + estatus + "';";
            
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
    
}
