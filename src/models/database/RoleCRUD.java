/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.database;

import java.sql.ResultSet;

/**
 *
 * @author Marihec
 */
public class RoleCRUD {
     // Se declara la clase a utilizar.
    private ConnectionDB con;
    
    /**
     * Constructor.
     */
    public RoleCRUD(){}
    
   public ResultSet readOnlyRole(String RoleName){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL  = "SELECT \"codigo\" FROM \"rol\" WHERE \"nombre\" = '" + RoleName + "' "
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
   
   public ResultSet readRoleCN(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL  = "SELECT codigo,nombre FROM \"rol\" WHERE \"estado\" = 'A';";
        
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
