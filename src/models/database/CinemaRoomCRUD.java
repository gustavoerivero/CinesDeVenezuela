/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.database;

import java.sql.ResultSet;
import models.CinemaRoom;

/**
 *  Materia: Laboratorio I
 *  Sección: 1
 *      Integrantes:
 *          @author Brizuela, Yurisbellys   C.I: 27.142.239
 *          @author Miranda, Marihec        C.I: 26.120.075
 *          @author Montero, Michael        C.I: 26.561.077
 *          @author Rivero, Gustavo         C.I: 26.772.857
 *          @author Torrealba, Luis         C.I: 26.121.249*/
public class CinemaRoomCRUD {
    
    private ConnectionDB con;
        
    //Constructor    
    public CinemaRoomCRUD(){}
    
     /**
     * Método para obtener los datos de una sala.
     * @return Devuelve consulta.
     */
    public ResultSet readCinemaRoomData(String idCinemaRoom){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT sala.\"codigo\", sucursal.\"nombre\" as \"NombreSucursal\", "
                   + "sala.\"fila\", sala.\"columna\" FROM \"sala\", \"sucursal\" WHERE"
                   + " sala.\"codigo\" = '" + idCinemaRoom + "' AND sucursal.\"codigo\" = "
                   + "sala.\"sucursal_codigo\" AND sala.\"estado\" = 'A' AND sucursal.\"estado\" = 'A';";
        
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
     * Método para obtener a todos los empleados.
     * @return Devuelve consulta.
     */
    public ResultSet readAllCinemRoom(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT * FROM \"sala\" WHERE \"estado\" = 'A';";
        
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
     * Método para obtener todas las Salas de una sucursal.
     * @param branch Nombre de la sucursal.
     * @return Devuelve consulta.
     */
    public ResultSet readAllCinemaRoomOnBranch(String branch){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT sala.\"codigo\", \"fila\", \"columna\", sucursal.\"nombre\""
                + " FROM \"sala\", \"sucursal\" WHERE sucursal.\"codigo\" = \"sucursal_codigo\""
                + " AND sucursal.\"nombre\" = '" + branch + "' AND sala.\"estado\" = 'A' "
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
    
    /**
     * Método para realizar una consulta en la BD.
     * @param SQL Sentencia SQL.
     * @return Consulta.
     */
    public ResultSet readCinemaRoom(String SQL){
        
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
    
    public void registerCinemaRoom(CinemaRoom cinRoom) {

        // Se declara la sentencia SQL a aplicar.
        String SQL = "INSERT INTO \"sala\" (\"codigo\", \"sucursal_codigo\", \"fila\", "
                   + "\"columna\", \"estado\") values ("
                + "'" + cinRoom.getId() + "', "
                + "'" + cinRoom.getBranch_id() +"', "
                + "'" + cinRoom.getFila() + "', "
                + "'" + cinRoom.getColum() + "', "
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
     * Método para actualizar un registro de un Empleado.
     * @param emp Clase Empleado.
     * @param id Cédula del empleado a actualizar.
     */
    public void UpdateCinemaRoom(CinemaRoom cinRoom, String id) {

        // Se declara la sentencia SQL.
        String  SQL = "UPDATE \"sala\" SET "
                + "\"sucursal_codigo\" = '" + cinRoom.getBranch_id() + "', "
                + "\"fila\" = '" + cinRoom.getFila() + "', "
                + "\"columna\" = '" + cinRoom.getColum() + "'"
                +  " WHERE \"codigo\" = '" + id + "';";

        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza la actualización.
        con.queryInsert(SQL);
        
        // Se muestra mensaje de éxito.
        System.out.println("La actualización de datos de la sala '" + id + "' se realizó con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
        
    }
    
    /**
     * Método para eliminar/reactivar una Sala.
     * @param id Codigo de la sala.
     * @param caso para la Eliminación o Reactivación de la sala:
     * '0' para eliminación.
     * Cualquier otro entero para reactivación.
     */
    public void DeleteCinemaRoom(String id, int caso) {
        
        // Se declara la variable de sentencia SQL.
        String SQL = "";
        
        // Dependiendo del valor de type, se elimina (lógica) o se reactiva el empleado.
        if(caso == 0)
            SQL     = "UPDATE \"sala\" SET \"estado\" = 'I' "
                    + " WHERE \"codigo\" = '" + id + "';";
        else
            SQL     = "UPDATE \"sala\" SET \"estado\" = 'A' "
                    + " WHERE \"codigo\" = '" + id + "';";
        
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        con.queryInsert(SQL);
        
        // Se muestra mensaje de éxito.
        System.out.println("La eliminación de la sala '" + id + "' se ha efectuado con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
    }

    /**
     * Método para comprobar la existencia de un empleado activo.
     * @param id Codigo de la Sala a buscar.
     * @return variable booleana.
     */
    public boolean CinemaRoomExist(String id){
        
        try{
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"sala\" WHERE \"codigo\" = '" 
                    + id + "' AND \"estado\" = 'A';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            // Si la sala existe (que debe ser única) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar la sala. Error: " + ex);
        }
        
        // Si la sala no existe, retorna 'false'.
        return false;
        
    }
    
    /**
     * Método para comprobar la existencia de una sala según su cédula y estado.
     * @param id Codigo de la Sala a buscar.
     * @param estatus de la Sala a buscar.
     * @return variable booleana.
     */
    public boolean CinemaRoomExistt(String id, char estatus){
        boolean val = true;
        try
        {
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"sala\" WHERE \"codigo\" = '" 
                    + id + "' AND \"estado\" = '" + estatus + "';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            // Si la sala existe (que debe ser única) retorna 'true'.
            
            val = rs.next();
            System.out.println(val);

            return val;
            
            
        } 
        catch (java.sql.SQLException ex)
        {
            System.out.println("No se pudo encontrar la sala. Error: " + ex);
                   return false;

        }
        
        // Si el usuario no existe, retorna 'false'.
        //return false;
        
    }
    
    
}
