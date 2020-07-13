
package models.database;

// Se importan las librerías a utilizar.
import java.sql.Connection;
import java.sql.DriverManager;
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
public class ConnectionDB {
    
    // Se declaran las variables que indican la Base de Datos, el usuario y la contraseña.
    private final String url = "jdbc:postgresql://localhost:5432/cinesV",
                        user = "postgres",
                        pass = "daMurq.15";
    
    // Se instancia la clase de Connection.
    private Connection con;
    
    /**
     * Constructor.
     */
    public ConnectionDB(){
        this.con = null;
    }
    
    /**
     * Método para conectar la app con la Base de Datos.
     * @return 
     */
    public Connection conectar(){
        try {
            //Nos permitira abrir una conexion a nuestra Base de Datos.
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("La conexión con la Base de Datos se realizó correctamente.");
        } catch (Exception e) {
            System.out.println("Fallo al conectar " + e.getMessage());
        }
        return con;
    }
    
    /**
     * Método para realizar consultas con la Base de Datos.
     * @param sql Sentencia SQL para consultas.
     * @return 
     */
    public ResultSet queryConsultar(String sql){
        try {
            //Nos permitira realizar sentencias sobre la Base de Datos
            java.sql.Statement ejecutorQuery = con.createStatement();
            //Variable que nos ayudara a realizar consultas a la Base de Datos
            ResultSet r = ejecutorQuery.executeQuery(sql);
            System.out.println("Se han obtenido datos.");
            return r;
            
        } catch (Exception e) {
            System.out.println("Conexion Informa: No se pudieron obtener los datos " 
                    + e.getMessage());
            return null;
        }
    }
    
    /**
     * Método para realizar inserciones o modificaciones con la Base de Datos.
     * @param sql Sentencia SQL para inserciones o modificaciones.
     */
    public void queryInsert(String sql){
        try {
            java.sql.Statement sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            System.out.println("Se ha Insertado/Modificado un registro.");

            
        } catch (Exception e) {
         
            System.out.println(e.getMessage());

        }
    }
    
    /**
     * Método para desconectar la Base de Datos de la app.
     */
    public void desconectar(){
        try {
            //Para realizar cierre de la conexion a la Base de Datos
            con.close();
            System.out.println("Exito al Desconectar la Base de Datos.");
        } catch (Exception e) {
            System.out.println("Fallo al desconectar Error: "+ e.getMessage());
        }
    }
    
}



