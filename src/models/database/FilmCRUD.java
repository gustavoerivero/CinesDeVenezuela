/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.database;
import java.sql.ResultSet;
import models.Film;

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
public class FilmCRUD {

    private ConnectionDB con;
  
//constructor
    public FilmCRUD(){}
  
    /**
     * Método para obtener los datos de una pelicula.
     * @return Devuelve consulta.
     */
    public ResultSet readFilmData(String idFilm){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT \"codigo\",\"nombre\", \"sinopsis\",\"duracion\",\"clasificacion\",\"fecha_estreno\",\"genero\" FROM \"pelicula\"" 
                        + "WHERE \"codigo\" = '" + idFilm + "' AND \"estado\" = 'A';";
        
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
     * Método para obtener a todas las peliculas.
     * @return Devuelve consulta.
     */
    public ResultSet readAllFilm(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT * FROM \"pelicula\" WHERE \"estado\" = 'A';";
        
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
    public ResultSet readFilm(String SQL){
        
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
     * Método para registrar a una pelicula.
     * @param fi Clase pelicula a registrar
     */
    public void registerFilm(Film fi) {

        // Se declara la sentencia SQL a aplicar.
        String SQL = "INSERT INTO \"pelicula\" (\"codigo\",\"nombre\",\"sinopsis\","
                + "\"duracion\", \"clasificacion\", \"fecha_estreno\" , \"genero\", \"estado\") values ("
                + "'" + fi.getId()+ "',"
                + "'" + fi.getName() +"',"
                + "'" + fi.getSynopsis()+ "',"
                + "'" + fi.getDuration()+ "',"
                + "'" + fi.getClassification()+"',"
                + "'" + fi.getPremiere()+"',"
                + "'" + fi.getType()+"',"
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
     * Método para actualizar un registro de una pelicula.
     * @param fi Clase Film.
     * @param id codigo de la pelicula a actualizar.
     */
    public void UpdateFilm(Film fi, String id) {

        // Se declara la sentencia SQL. NO MODIFICA NADA
       /* String  SQL = "UPDATE \"pelicula\" SET "
                + "\"nombre\" = '" + fi.getName() + "',"
                +  "\"sinopsis\" = '" + fi.getSynopsis()+ "',"
                +  "\"duracion\" = '" + fi.getDuration()+ "',"
                +  "\"clasificacion\" = " + fi.getClassification()+ ","
                +  "\"fecha_estreno\" = " + fi.getPremiere()+ ","
                +  "\"genero\" = " + fi.getType()+ ","
                +  " WHERE \"codigo\" = '" + id + "';";*/
        
        //SI MODIFICA LA BD PERO QUEDA DESORDENADO
        String  SQL = "UPDATE \"pelicula\" SET nombre = '" + fi.getName() + "', sinopsis = '" + fi.getSynopsis()+ "', duracion = '" + fi.getDuration()+ "', clasificacion = '" + fi.getClassification()+ "',fecha_estreno = '" + fi.getPremiere()+ "', genero = '" + fi.getType()+ "' WHERE codigo = '" + id + "';";
        
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza la actualización.
        con.queryInsert(SQL);
        
        // Se muestra mensaje de éxito.
        System.out.println("La actualización de datos de la pelicula '" + id + "' se realizó con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
        
    }
/**
     * Método para eliminar/reactivar una pelicula.
     * @param id codigo de la pelicula.
     * @param type Eliminación o Reactivación de la empresa:
     * '0' para eliminación.
     * Cualquier otro entero para reactivación.
     */
    public void DeleteFilm(String id, int type) {
        
        // Se declara la variable de sentencia SQL.
        String SQL = "";
        
        // Dependiendo del valor de type, se elimina (lógica) o se reactiva la pelicula.
        if(type == 0)
            SQL     = "UPDATE \"pelicula\" SET \"estado\" = 'I' "
                    + "WHERE \"codigo\" = '" + id + "';";
        else
            SQL     = "UPDATE \"pelicula\" SET \"estado\" = 'A' "
                    + "WHERE \"codigo\" = '" + id + "';";
        
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        con.queryInsert(SQL);
        
        // Se muestra mensaje de éxito.
        System.out.println("La eliminación de la pelicula '" + id + "' se ha efectuado con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
    }

/**
     * Método para comprobar la existencia de una pelicula activa.
     * @param id codigo de la pelicula a buscar.
     * @return variable booleana.
     */
    public boolean filmExist(String id){
        
        try{
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"pelicula\" WHERE \"codigo\" = '"
                            + id + "' AND \"estado\" = 'A';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            // Si el usuario existe (que debe ser único) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar la pelicula. Error: " + ex);
        }
        
        // Si el usuario no existe, retorna 'false'.
        return false;
        
    }
    
    /**
     * Método para comprobar la existencia de una pelicula según su codigo y estado.
     * @param id codigo de la pelicula a buscar.
     * @param estatus De la pelicula a buscar.
     * @return variable booleana.
     */
    public boolean filmExist(String id, char estatus){
        
        try{
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"pelicula\" WHERE \"codigo\" = '"
                            + id + "' AND \"estado\" = '" + estatus + "';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            // Si el usuario existe (que debe ser único) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar la pelicula. Error: " + ex);
        }
        
        // Si el usuario no existe, retorna 'false'.
        return false;
        
    }

    /**
     * Método para devolver las películas recientes
     * @return Consulta.
     */
    public ResultSet readFilms(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se declara una variable String que posea la sentencia SQL.
        String SQL  = "SELECT * FROM \"pelicula\" WHERE "
                //+ "((extract(month from current_date) - extract(month from fecha_estreno)) < 2)"
                //    + " AND ((extract(year from current_date) - extract(year from fecha_estreno)) = 0) AND "
                + "estado = 'A';";
                
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
