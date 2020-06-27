
package models.database;

// Se importan las librerías a utilizar
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
public class CandyCRUD {
    
    // Se declaran las clases a utilizar.
    private ConnectionDB con;
    
    /**
     * Método para recibir todas las golosinas.
     * @return Devuelve consulta
     */
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
    
}
