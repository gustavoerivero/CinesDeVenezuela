/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
/**
 *
 * @author Marihec
 */
public class ConexionBD {
    
    private final String url = "jdbc:postgresql://localhost:5432/CinesVenezuela";
    private final String user = "postgres";
    private final String pass = "26120075";
    private Connection con;
    
    public ConexionBD(){
        this.con = null;
    }
    
    

    public Connection conectar(){
        try {
            //Nos permitira abrir una conexion a nuestra Base de Datos
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Success Full Connection correctamente");
        } catch (Exception e) {
            System.out.println("Fallo al conectar " + e.getMessage());
        }
        return con;
    }
    
    public ResultSet queryConsultar(String sql){
        try {
            //Nos permitira realizar sentencias sobre la Base de Datos
            java.sql.Statement ejecutorQuery = con.createStatement();
            //Variable que nos ayudara a realizar consultas a la Base de Datos
            ResultSet r = ejecutorQuery.executeQuery(sql);
            System.out.println("se han obtenido datos");
            return r;
            
        } catch (Exception e) {
            System.out.println("Conexion Informa: No se pudieron obtener los datos "+e.getMessage());
            return null;
        }
    }
    
    public void queryInsert(String sql){
        try {
            java.sql.Statement sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            System.out.println("se ha Insertado/Modificado un registro");

            
        } catch (Exception e) {
         
            System.out.println(e.getMessage());

        }
    }
    
    public void desconectar(){
        try {
            //Para realizar cierre de la conexion a la Base de Datos
            con.close();
            System.out.println("Exito al Desconectar");
        } catch (Exception e) {
            System.out.println("Fallo al desconectar Error"+ e.getMessage());
        }
    }
    
}



