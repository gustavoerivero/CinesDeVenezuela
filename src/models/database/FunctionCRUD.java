/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.database;

import java.sql.ResultSet;

/**
 *
 * @author Michael Montero
 */
public class FunctionCRUD {
    // Se declaran las clases a utilizar.
    private ConnectionDB con;
    
    //<editor-fold defaultstate="collapsed" desc="readFunctions - Leer una instrucción SQL ">
    /**
     * Método que permite conocer todas las golosinas registradas.
     * @param sQL instrucción sQL.
     * @return Devuelve consulta.
     */
    public ResultSet readFunctions(String sQL){
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
    //</editor-fold>
    
    
}
