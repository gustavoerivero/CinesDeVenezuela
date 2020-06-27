
package models.database;

import java.sql.ResultSet;
import models.Employee;

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
public class EmployeeCRUD {

    private ConnectionDB con;
        
    //Constructor    
    public EmployeeCRUD(){}

    //<editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Metodo de Cargar Tabla, no sirve pero tiene buena logica ">       


    /*public ArrayList<Object>listaEmployee2()
     {
            ArrayList<Object>lista; 
            lista = new ArrayList<>();
            try{
                con = new ConnectionDB();
                con.conectar();
                String SQL = "SELECT * FROM \"Empleadito\"";

                java.sql.ResultSet rs = con.queryConsultar(SQL);
                ResultSetMetaData rMd = rs.getMetaData();
                int cantcolumnas = rMd.getColumnCount();
                while(rs.next())
                    {
                        Object[] filas = new Object[cantcolumnas];
                        for (int i = 0; i < cantcolumnas ; i++) 
                        {
                            filas[i] = rs.getObject(i+1);
                        }
                        lista.add(filas);

                    }

            }
            catch(Exception e)
            {
                System.out.println("No se pudo encontrar al Empleado. Error: " + e);;
            }
    return lista;

    }*/
         //</editor-fold>      

    //</editor-fold>

    /**
     * Método para obtener los datos de un empleado.
     * @return Devuelve consulta.
     */
    public ResultSet readEmployeeData(String idEmployee){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT \"cedula\", sucursal.\"nombre\" as \"NombreSucursal\", "
                        + "empleado.\"nombre\", \"apellido\", empleado.\"telefono\", "
                        + "empleado.\"direccion\", \"fecha_nacimiento\", \"fecha_ingreso\", "
                        + "\"correo\", \"cargo\" FROM \"empleado\", \"sucursal\" "
                        + "WHERE \"cedula\" = '" + idEmployee + "' AND \"sucursal_codigo\" = \"codigo\" "
                        + "AND empleado.\"estado\" = 'A' AND sucursal.\"estado\" = 'A';";
        
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
    public ResultSet readAllEmployee(){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT * FROM \"empleado\" WHERE \"estado\" = 'A';";
        
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
     * Método para obtener todos los empleados de una sucursal.
     * @param branch Nombre de la sucursal.
     * @return Devuelve consulta.
     */
    public ResultSet readAllEmployeeOnBranch(String branch){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = "SELECT empleado.\"nombre\", empleado.\"apellido\" "
                + "FROM \"empleado\", \"sucursal\" WHERE \"codigo\" = \"sucursal_codigo\" "
                + "AND sucursal.\"nombre\" = '" + branch + "' AND "
                + "empleado.\"estado\" = 'A' AND sucursal.\"estado\" = 'A';";
        
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
    public ResultSet readEmployees(String SQL){
        
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
     * Método para buscar vendedores según su tipo.
     * @param branch Para buscar según la rama seleccionada.
     * @param type '1' para vendedor de golosinas y cualquier otro int para vendedor de boletos.
     * @return Consulta.
     */
    public ResultSet readSellerForType(String branch, int type){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = null;
        
        if(type == 1)
            SQL = "SELECT empleado.\"nombre\", empleado.\"apellido\" FROM \"empleado\", \"sucursal\" "
                    + "WHERE \"cargo\" = 'Vendedor de golosinas' AND empleado.\"estado\" = 'A' "
                    + "AND sucursal.\"estado\" = 'A' AND \"sucursal_codigo\" = \"codigo\"";
        else
            SQL = "SELECT empleado.\"nombre\", empleado.\"apellido\" FROM \"empleado\", \"sucursal\" "
                    + "WHERE \"cargo\" = 'Vendedor de boletos' AND empleado.\"estado\" = 'A' "
                    + "AND sucursal.\"estado\" = 'A' AND \"sucursal_codigo\" = \"codigo\"";
        
        if(!branch.equals("Cines de Venezuela") && !branch.equals("") && !branch.equals(" - Seleccione - "))
            SQL += " AND sucursal.\"nombre\" = '" + branch + "'";
        
        SQL += ";";
        
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
     * Método para buscar vendedores según su tipo.
     * @param name Nombre del vendedor a buscar.
     * @param lastName Apellido del vendedor a buscar.
     * @param type '1' para vendedor de golosinas y cualquier otro int para vendedor de boletos.
     * @return Consulta.
     */
    public ResultSet readOnlyOneSellerForType(String name, String lastName, int type){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = null;
        
        if(type == 1)
            SQL = "SELECT * FROM \"empleado\" WHERE \"nombre\" = '" + name + "' "
                    + "AND \"apellido\" = '" + lastName + "' AND "
                    + "\"cargo\" = 'Vendedor de golosinas' AND \"estado\" = 'A';";
        else
            SQL = "SELECT * FROM \"empleado\" WHERE \"nombre\" = '" + name + "' "
                    + "AND \"apellido\" = '" + lastName + "' AND "
                    + "\"cargo\" = 'Vendedor de boletos' AND \"estado\" = 'A';";
        
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
     * Método para registrar a un empleado.
     * @param emp Clase empleado a registrar
     */
    public void registerEployee(Employee emp) {

        // Se declara la sentencia SQL a aplicar.
        String SQL = "INSERT INTO \"empleado\" (\"cedula\",\"sucursal_codigo\",\"nombre\","
                + "\"apellido\", \"telefono\", \"direccion\", \"fecha_nacimiento\", \"fecha_ingreso\", "
                + "\"correo\", \"cargo\", \"estado\" ) values ("
                + "'" + emp.getId()+ "',"
                + "'" + emp.getBranch_id() +"',"
                + "'" + emp.getName() + "',"
                + "'" + emp.getSurname() + "',"
                + "'" + emp.getPhone() +"',"
                + "'" + emp.getDirection() + "',"
                + "'" + emp.getBirth_date() + "',"
                + "'" + emp.getAdmission_date() + "',"
                + "'" + emp.getEmail() + "',"
                + "'" + emp.getPosition() + "',"
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
    public void UpdateEmployee(Employee emp, String id) {

        // Se declara la sentencia SQL.
        String  SQL = "UPDATE \"empleado\" SET "
                + "\"sucursal_codigo\" = '" + emp.getBranch_id() + "',"
                +  "\"nombre\" = '" + emp.getName() + "',"
                +  "\"apellido\" = '" + emp.getSurname() + "',"
                +  "\"telefono\" = " + emp.getPhone() + ","
                +  "\"direccion\" = '" + emp.getDirection() + "',"
                +  "\"fecha_nacimiento\" = " + emp.getBirth_date() + ","
                +  "\"fecha_ingreso\" = " + emp.getAdmission_date() + ","
                +  "\"correo\" = '" + emp.getEmail() + "',"
                +  "\"cargo\" = '" + emp.getPosition() + "',"
                +  " WHERE \"cedula\" = '" + id + "';";

        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza la actualización.
        con.queryInsert(SQL);
        
        // Se muestra mensaje de éxito.
        System.out.println("La actualización de datos del empleado '" + id + "' se realizó con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
        
    }
    
    /**
     * Método para eliminar/reactivar un Empleado.
     * @param id Cédula del empleado.
     * @param type Eliminación o Reactivación del empleado:
     * '0' para eliminación.
     * Cualquier otro entero para reactivación.
     */
    public void DeleteEmployee(String id, int type) {
        
        // Se declara la variable de sentencia SQL.
        String SQL = "";
        
        // Dependiendo del valor de type, se elimina (lógica) o se reactiva el empleado.
        if(type == 0)
            SQL     = "UPDATE \"empleado\" SET \"estado\" = 'I' "
                    + "WHERE \"cedula\" = '" + id + "';";
        else
            SQL     = "UPDATE \"empleado\" SET \"estado\" = 'A' "
                    + "WHERE \"cedula\" = '" + id + "';";
        
        // Se instancia y se establece una conexión con la BD.
        con = new ConnectionDB();
        con.conectar();
        
        // Se realiza y se recibe la consulta.
        con.queryInsert(SQL);
        
        // Se muestra mensaje de éxito.
        System.out.println("La eliminación del empleado '" + id + "' se ha efectuado con éxito.");
        
        // Se desconecta la BD.
        con.desconectar();
    }

    /**
     * Método para comprobar la existencia de un empleado activo.
     * @param id Cédula del empleado a buscar.
     * @return variable booleana.
     */
    public boolean employeeExist(String id){
        
        try{
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"empleado\" WHERE \"cedula\" = '"
                            + id + "' AND \"estado\" = 'A';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            // Si el usuario existe (que debe ser único) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar el empleado. Error: " + ex);
        }
        
        // Si el usuario no existe, retorna 'false'.
        return false;
        
    }
    
    /**
     * Método para comprobar la existencia de un empleado según su cédula y estado.
     * @param id Cédula del empleado a buscar.
     * @param estatus Del Empleado a buscar.
     * @return variable booleana.
     */
    public boolean employeeExist(String id, char estatus){
        
        try{
            
            // Se instancia la clase de conexión con BD y se establece una conexión.
            con = new ConnectionDB();
            con.conectar();
          
            // Se declara una sentencia SQL.
            String SQL =    "SELECT * FROM \"empleado\" WHERE \"cedula\" = '"
                            + id + "' AND \"estado\" = '" + estatus + "';";
            
            // Se realiza la consulta y se obtiene el resultado.
            java.sql.ResultSet rs = con.queryConsultar(SQL);
            
            // Se desconecta la BD.
            con.desconectar();
            
            // Si el usuario existe (que debe ser único) retorna 'true'.
            return rs.next();
            
            
        } catch (java.sql.SQLException ex){
            System.out.println("No se pudo encontrar el empleado. Error: " + ex);
        }
        
        // Si el usuario no existe, retorna 'false'.
        return false;
        
    }
    
}
    
    
 
  

    
    
     
