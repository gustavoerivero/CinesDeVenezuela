
package models.database;


import java.sql.ResultSet;
import models.Employee;

/**
 *
 * @author Luis David
 */
//public class EmployeeCRUD extends conecionLuis
public class EmployeeCRUD {

    private ConnectionDB con;
    
    //Constructor    
    public EmployeeCRUD(){}

    //<editor-fold>

//<editor-fold defaultstate="collapsed" desc="Registrar Empleado "> 
    
   public void registrarEployee(Employee emp) {

    String sql = "INSERT INTO \"empleado\" (\"cedula\",\"sucursal_codigo\",\"nombre\","
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
            + "A);";
    ConnectionDB con = new ConnectionDB();
    con.conectar();
    con.queryInsert(sql);
    con.desconectar();
    
    
    
    
    
    
}
//</editor-fold>
   
//<editor-fold defaultstate="collapsed" desc="Actualizar Empleado "> 
    
public void ActualizarEployee(String id, String getBranch_id, String name,
String surname, String phone, String direccion, String birth_date, String admision_date,
String email, String Position ) {
   

    String sql = "UPDATE \"empleado\" SET \"sucursal_codigo\" = "
                       +  "'" + getBranch_id + "',"
                       +  "\"nombre\" = " + name + "',"
                       +  "\"apellido\" = " + surname + "',"
                       +  "\"telefono\" = " + surname + "',"
                       +  "\"direccion\" = " + direccion + "',"
                       +  "\"fecha_nacimiento\" = " + birth_date + "',"
                       +  "\"fecha_ingreso\" = " + admision_date + "',"
                       +  "\"correo\" = " + email + "',"
                       +  "\"cargo\" = " + Position + "',"
                       +  " WHERE \"Cedula\" = " + id + "',";


ConnectionDB con = new ConnectionDB();
con.conectar();
con.queryInsert(sql);
con.desconectar();

 
}
    

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Eliminar Empleado "> 
    
 public void EliminarEployee(String ced, int i) {

if(i==1){
String sql=  "UPDATE \"empleado\" SET \"estado\" = 'I' "
             + "WHERE \"Cedula\" ='" + ced + "';";
ConnectionDB con = new ConnectionDB();
con.conectar();
con.queryInsert(sql);
con.desconectar();
}
else{
String sql= "UPDATE \"empleado\" SET \"estado\" = 'A' "
             + "WHERE \"cedula\" ='" + ced + "';";

ConnectionDB con = new ConnectionDB();
con.conectar();
con.queryInsert(sql);
con.desconectar();
 
}
    
}
//</editor-fold>
     
//<editor-fold defaultstate="collapsed" desc=" Cargar Tabla FINAL ">       
   
  //Metodo de Cargar Tabla super Comprimido
    
public ResultSet listaEmployee()
    {
   
    ResultSet resu;
    String sql = "SELECT * FROM \"empleado\""; 
    ConnectionDB con = new ConnectionDB();
    con.conectar();
    resu = con.queryConsultar(sql);
    con.desconectar();
    return resu;
}

 //</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" Metodo que funciona Luis ">       
 
//metodo manera de luis que sirve
     /*public ArrayList<employee2>lista2()
    {
        Conexion();
        ArrayList<employee2>lista2; 
        lista2 = new ArrayList<>();
       
        try{
            
            //conn = new ConnectionDB();
            //con.conectar();
           // String SQL = "SELECT * FROM \"Empleadito\"";
            //java.sql.ResultSet rs = con.queryConsultar(SQL);
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM \"Empleadito\"");
            
            
            while(rs.next())
                {
                //emp = new Employee(rs.getString("cedula"),rs.getString("CargoCodigo"), rs.getString("SucursalCodigo"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Telefono"), rs.getString("Direcion"),rs.getDate("FechaNacimiento"), rs.getDate("FechaIngreso"), rs.getString("Correo"), rs.getString("Estado").charAt(0));
                //Employee emp = new Employee(rs.getString("Cedula"),
                        //rs.getString("Nombre"), rs.getString("Apellido"),
                        //rs.getString("Telefono"),rs.getString("Direccion"),
                        //rs.getDate("FechaNacimiento"),rs.getString("Correo"),
                       // rs.getString("Estado").charAt(0),rs.getString("SucursalCodigo"),
                        //rs.getString("CargoCodigo"),rs.getDate("FechaNacimiento"));
                employee2 emp = new employee2();

                emp.setId(rs.getString("Cedula"));
                emp.setPosition_id(rs.getString("CargoCodigo"));
                emp.setBranch_id(rs.getString("SucursalCodigo"));
                emp.setName(rs.getString("Nombre"));
                emp.setSurname(rs.getString("Apellido"));
                emp.setPhone(rs.getString("Telefono"));
                emp.setDirection(rs.getString("Direccion"));
                emp.setAdmission_date(rs.getDate("FechaIngreso"));
                emp.setBirth_date(rs.getDate("FechaNacimiento"));
                emp.setEmail(rs.getString("Correo"));
                emp.setEstatus(rs.getString("Estado").charAt(0));

                lista2.add(emp);
                }
             System.out.println("Empleados: " + lista2);
              rs.close();
                }
        
               catch(java.sql.SQLException ex)
        {
            System.out.println("No se pudo encontrar el usuario. Error: " + ex);
        }
        return lista2;
              
        } */
     
      //</editor-fold>

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
     * Método para buscar vendedores según su tipo.
     * @param type '1' para vendedor de golosinas y cualquier otro int para vendedor de boletos.
     * @return Consulta.
     */
    public ResultSet readSellerForType(int type){
        
        // Se declara una variable de tipo 'ResultSet' para realizar la consulta.
        ResultSet result;
        
        // Se define la sentencia SQL a aplicar en la BD.
        String SQL = null;
        
        if(type == 1)
            SQL = "SELECT * FROM \"empleado\" WHERE "
                    + "\"cargo\" = 'Vendedor de golosinas' AND \"estado\" = 'A';";
        else
            SQL = "SELECT * FROM \"empleado\" WHERE "
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
    
    

}
    
    
 
  

    
    
     
