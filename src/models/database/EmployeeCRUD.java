/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.database;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Employee;

/**
 *
 * @author Luis David
 */
//public class EmployeeCRUD extends conecionLuis
public class EmployeeCRUD {


//Constructor    
public EmployeeCRUD(){}

    
//<editor-fold defaultstate="collapsed" desc="Registrar Empleado "> 
    
   public void registrarEployee(Employee emp) {

    String sql = "INSERT INTO \"Empleadito\" (\"Cedula\",\"CargoCodigo\",\"SucursalCodigo\",\"Nombre\","
            + "\"Apeliido\", \"Telefono\", \"Direccion\", \"FechaNacimiento\", \"FechaIngreso\", "
            + "\"Correo\", \"Estado\" ) values ("
            + "'" + emp.getId()+ "',"
            + "'" + emp.getPosition_id() + "',"
            + "'" + emp.getBranch_id() +"',"
            + "'" + emp.getName() + "',"
            + "'" + emp.getSurname() + "',"
            + "'" + emp.getPhone() +"',"
            + "'" + emp.getDirection() + "',"
            + "'" + emp.getBirth_date() + "',"
            + "'" + emp.getAdmission_date() + "',"
            + "'" + emp.getEmail() + "',"
            + "1);";
    ConnectionDB con = new ConnectionDB();
    con.conectar();
    con.queryInsert(sql);
    con.desconectar();
    
    
    
    
    
    
}
//</editor-fold>
   
//<editor-fold defaultstate="collapsed" desc="Actualizar Empleado "> 
    
public void ActualizarEployee(String id, String Position_id, String getBranch_id, String name,
String surname, String phone, String direccion, String birth_date, String admision_date,
String email ) {
   

    String sql = "UPDATE \"Empleadito\" SET \"CargoCodigo\" = "
                       +  "'" + Position_id + "',"
                       +  "\"SucursalCodigo\" = '" + getBranch_id + "',"
                       +  "\"Nombre\" = " + name + "',"
                       +  "\"Apellido\" = " + surname + "',"
                       +  "\"Telefono\" = " + surname + "',"
                       +  "\"Direccion\" = " + direccion + "',"
                       +  "\"FechaNacimiento\" = " + birth_date + "',"
                       +  "\"FechaIngreso\" = " + admision_date + "',"
                       +  "\"Correo\" = " + email + "',"
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
String sql=  "UPDATE \"Empleadito\" SET \"Estado\" = '0' "
             + "WHERE \"Cedula\" ='" + ced + "';";
ConnectionDB con = new ConnectionDB();
con.conectar();
con.queryInsert(sql);
con.desconectar();
}
else{
String sql= "UPDATE \"Empleadito\" SET \"Estado\" = '1' "
             + "WHERE \"Cedula\" ='" + ced + "';";

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
    String sql = "SELECT * FROM \"Empleadito\""; 
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
         
 }
    
    
 
  

    
    
     
