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
     * Método que permite conocer todas las funciones registradas.
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
    
    /**
     * Método que permite conocer todas las funciones registradas de una película.
     * @param SQL instrucción sQL.
     * @return Devuelve consulta.
     */
    public ResultSet readFunctions(String filmName, String branchName){
        
        // Se declara la sentencia SQL
        String SQL    = "SELECT to_char(horario.\"fecha\", 'DD/MM/YYYY') as \"dia\", \n" +
                        "sala.\"codigo\" as \"sala\", to_char(bloque.\"horainicio\", 'HH:MI:SS') as \"hora\", \n" +
                        "(sala.\"columna\" * sala.\"fila\") as \"asientos\", \n" +
                        "((sala.\"columna\" * sala.\"fila\") - count(ticket_funcion.\"FuncionCodigo\")) as \"disponibles\" \n" +
                        "FROM \"pelicula\", \"funcion\", \"horario\", \"sala\", \"bloque\", \"ticket_funcion\", \"sucursal\"\n" +
                        "WHERE pelicula.\"nombre\" = '" + filmName + "' AND\n" +
                        "sucursal.\"nombre\" = '" + branchName + "' AND\n" +
                        "funcion.\"pelicula_codigo\" = pelicula.\"codigo\" AND\n" +
                        "funcion.\"horario_codigo\" = horario.\"codigo\" AND \n" +
                        "funcion.\"codigo\" = ticket_funcion.\"FuncionCodigo\" AND \n" +
                        "sucursal.\"codigo\" = sala.\"sucursal_codigo\" AND\n" +
                        "horario.\"bloque_codigo\" = bloque.\"codigo\" AND\n" +
                        "horario.\"sala_codigo\" = sala.\"codigo\" AND\n" +
                        "sucursal.\"estado\" = 'A' AND pelicula.\"estado\" = 'A' AND \n" +
                        "sala.\"estado\" = 'A' AND horario.\"estado\" = 'A' AND bloque.\"estado\" = 'A'\n" +
                        "GROUP BY sala.\"codigo\", bloque.\"horainicio\", \n" +
                        "horario.\"codigo\", horario.\"fecha\";";
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se instancia y se establece una conexiÃ³n con la BD.
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
