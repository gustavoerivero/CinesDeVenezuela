/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Luis david
 */
// views
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import views.RegisterModify;


//models
import models.database.ConnectionDB;
import models.database.EmployeeCRUD;
import models.Employee;


public class ControllerEmployeeCRUD implements ActionListener, ItemListener {
    
    private RegisterModify registerModify;
    private EmployeeCRUD   empc;
    
   
   
    
    //Controlador
    public ControllerEmployeeCRUD(){
      
      registerModify = new RegisterModify();
      registerModify.setVisible(true);
      registerModify.addEvents(this);
      registerModify.modificarCampos(false);

      empc = new EmployeeCRUD();
    }
    
    
    
    
//<editor-fold defaultstate="collapsed" desc=" metodo de seteo ">
  /* private void SetMedico(Employee emp)
    {
        emp.setId(registerModify.getTxtIdEmployee1().getText());
        emp.setPosition_id(registerModify.txtposition_idEmployee1.getText());
        emp.setBranch_id(registerModify.txtbranch_idEmploye1.getText());
        emp.setPosition_id(registerModify.txtposition_idEmployee1.getText());
        emp
        
        
        emp.setSurname(registerModify.getTxtSurnameEmployee1().getText());
        emp.setEspecialidad(registerModify.getCboxEsp().getSelectedItem().toString());
        mm.setHorarioT(turno);
        
        
        registerModify.txtIdEmployee1.getText(), 
                            registerModify.txtposition_idEmployee1.getText(),
                            registerModify.txtbranch_idEmploye1.getText(),
                            registerModify.txtNameEmployee1.getText(),
                            registerModify.txtSurnameEmployee1.getText(),
                            registerModify.txtPhoneEmployee1.getText(),
                            registerModify.txtDirectionEmployee1.getText(),
                            registerModify.txtMailEmployee1.getText());
        
        
        
    }*/
    //</editor-fold>
 
//<editor-fold defaultstate="collapsed" desc=" Metodo para completar Abstract">
  public void itemStateChanged(ItemEvent r){
      
  }
   //</editor-fold>
  
//<editor-fold defaultstate="collapsed" desc=" AcctionPerformed ">
   
    
  public void actionPerformed(ActionEvent e){
      
        //Boton de Registro del Nuevo Paciente
         if(e.getSource()==registerModify.btnRegisterEmployee)
        {
            
        }
       
       
       
            // Actualizar Empleado
              if(e.getSource()== registerModify.btnRegisterEmployee){
            registerModify.modificarCampos(true);
            registerModify.jCalendarbirth_dateEmployee.setEnabled(false);
                        // Conversion Metodo
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaN = sdf.format(registerModify.jCalendarbirth_dateEmployee.getDate());
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                    String ingreso = sdf1.format(registerModify.jCalendarAdmission_dateEmployee1.getDate());
                    
          
            if(CamposVacios()==2)
            {
                            EmployeeCRUD.ActualizarEployee(registerModify.txtIdEmployee1.getText(), 
                            registerModify.txtposition_idEmployee1.getText(),
                            registerModify.txtbranch_idEmploye1.getText(),
                            registerModify.txtNameEmployee1.getText(),
                            registerModify.txtSurnameEmployee1.getText(),
                            registerModify.txtPhoneEmployee1.getText(),
                            registerModify.txtDirectionEmployee1.getText(),
                            fechaN, ingreso,  //solo me reconoce uno 
                            registerModify.txtMailEmployee1.getText());
                            
            }
            else{
                //mensaje de Error
                
            }
        }
              
              
              //Eliminar Empleado
              else if(e.getSource()== registerModify.btnEliminarEmployeer)
              {
                EmployeeCRUD.EliminarEployee(registerModify.txtIdEmployee1.getText(),);
              }
   
         if(e.getSource() == registerModify.btnMin){
            registerModify.setExtendedState(java.awt.Frame.ICONIFIED);
            registerModify.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir de la aplicación.
        else if(e.getSource() == registerModify.btnExitt){
            registerModify.dispose();
            //mainPage.setVisible(true);
        } 
     
    }
    
    
    //</editor-fold>
  
  
 
  
//<editor-fold defaultstate="collapsed" desc=" Metodo Validar Campos ">
    public int CamposVacios()
    {       
        int campos;
    
            String vacio =  registerModify.txtIdEmployee1.getText();
            String vacio1 = registerModify.txtNameEmployee1.getText();
            String vacio2 = registerModify.txtSurnameEmployee1.getText();
            String vacio3 = registerModify.txtMailEmployee1.getText();
            String vacio4 = registerModify.txtPhoneEmployee1.getText();
            String vacio5 = registerModify.txtbranch_idEmploye1.getText();
            String vacio6 = registerModify.txtposition_idEmployee1.getText();
            String vacio7 = registerModify.txtDirectionEmployee1.getText();
            
            if(vacio.equals("") || vacio1.equals("") || vacio2.equals("") 
               || vacio3.equals("") || vacio4.equals("")|| vacio5.equals("")|| 
                    vacio6.equals("")|| vacio7.equals(""))
            campos=1;
            else
            campos=2;
            
        return campos;
    }
     //</editor-fold>
    
public void registrarEmpleado(int tipoPaciente){
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha = registerModify.jCalendarbirth_dateEmployee.getDate();
    String fechaNacimiento = "";
    try {
        fechaNacimiento = sdf.format(fecha);
        registerModify.jCalendarbirth_dateEmployee.setDate(fecha);
    } catch (Exception e) 
    {
    }
           String Id, position_id, branch_id, name, surname, phone, direccion, mail;
            Id = registerModify.txtIdEmployee1.getText();
            branch_id = registerModify.txtbranch_idEmploye1.getText();
            position_id = registerModify.txtposition_idEmployee1.getText();
            name =  registerModify.txtNameEmployee1.getText();
            phone = registerModify.txtPhoneEmployee1.getText();
            direccion = registerModify.txtDirectionEmployee1.getText();
            mail = registerModify.txtMailEmployee1.getText();
            
           
            PacienteAsegurado a = new PacienteAsegurado(nombre, apellido, cedula, telefono, direccion,fechaNacimiento, numeroHistoria, antFamiliares, antPersonales, tipoPaciente, numeroSeguro);
            
            pacienteCrud.setEstadoRegistroPaciente(asegurado);
            pacienteCrud.RegistroPaciente(a, null);
    
    
}



    

    
    
}
         
            
        
