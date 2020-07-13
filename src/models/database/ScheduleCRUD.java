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
public class ScheduleCRUD 
{
    // Se declaran las clases a utilizar.
    private ConnectionDB con;
    
    //<editor-fold defaultstate="collapsed" desc="readFunctions - Leer una instrucción SQL ">
        /**
     * Método para obtener los datos de un horario y su bloque de hora.
     * @param idSchedule es el codigo del horario
     * @return Devuelve consulta.
     */
    public ResultSet readScheduleData(String idSchedule){
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT \"horainicio\", \"horafin\" , "
                        + "\"fecha\" "
                        + "FROM \"bloque\", \"horario\" WHERE \"bloque_codigo\" = bloque.\"codigo\" AND horario.\"codigo\" = '" 
                        + idSchedule + "' AND "
                        + "bloque.\"estado\" = 'A' AND horario.\"estado\" = 'A';";
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
    //</editor-fold>
    
}
