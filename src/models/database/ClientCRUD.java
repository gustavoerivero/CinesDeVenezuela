/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.database;

/**
 *
 * @author Marihec
 */
public class ClientCRUD {
    
        private ConnectionDB con;
    
    /**
     * Método para comprobar si el cliente ingresado al sistema se 
     * encuentra registrado.
     * @param id cedula del cliente.
     * @return variable booleana.
     */
    
    public boolean signer(String id){
try{
            
            // Se instancia la clase para la conexión con la BD y se establece la conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se descrie la sentencia SQL.
            String SQL =    "SELECT * FROM \"Cliente\" WHERE \"Cedula\" = '"
                            + id + "' AND \"Estado\" = 'A';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            // Si se obtuvo un resultado (que tiene que ser único) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar al Cliente. Error: " + ex);
        }
        
        // De no encontrarse ningún resultado, retorna 'false'.
        return false;
        
    }
}


