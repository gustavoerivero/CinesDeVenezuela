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
import lib.SuportFunctions;
import lib.TheaterSeatingChart;
import views.RegisterModify;
import views.PopupMessage;
import views.SelectOption;
import views.MainPage;


//models
import models.database.ConnectionDB;
import models.database.EmployeeCRUD;
import models.Employee;


public class ControllerEmployeeCRUD implements ActionListener, ItemListener {
    
    private RegisterModify registerModify;
    private EmployeeCRUD   empc;
    private PopupMessage popup;
    private SelectOption selectop;
    private SuportFunctions suport;
    private MainPage mainpage;
    private TheaterSeatingChart seatingChart;
    

    //Constructor
    public ControllerEmployeeCRUD(){
      
      registerModify = new RegisterModify();
      

      empc = new EmployeeCRUD();
      
      
      suport          = new SuportFunctions();
      seatingChart    = new TheaterSeatingChart();
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
   
      
    public void actionPerformed(java.awt.event.ActionEvent evt){
  
      
                     //Registrar Empleado
                    /* if(e.getSource()== registerModify.btnRegisterEmployee){
                     {
                         if(CamposVacios()==1)
                         {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        String fechaN = sdf.format(registerModify.jCalendarbirth_dateEmployee.getDate());
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                        String ingreso = sdf1.format(registerModify.jCalendarAdmission_dateEmployee1.getDate());
                    
                    
                            Employee emp;
                             emp = new Employee(registerModify.txtIdEmployee1.getText(), 
                                     registerModify.txtposition_idEmployee1.getText(),
                                     registerModify.txtbranch_idEmploye1.getText(),
                                     registerModify.txtNameEmployee1.getText(),
                                     registerModify.txtSurnameEmployee1.getText(),
                                     registerModify.txtPhoneEmployee1.getText(),
                                     registerModify.txtDirectionEmployee1.getText(),
                                     fechaN,ingreso,
                                     registerModify.txtMailEmployee1.getText(),1);
                             empc.registrarEployee(emp);
                             
                             //mensaje de error por campos vacios
                             popup = new PopupMessage(registerModify, true, 4, 
                             "Empleado Registrado Exitosamente");
                             
                         }
                         
                          else{
                             
                             //mensaje de error por campos vacios
                             popup = new PopupMessage(registerModify, true, 1, 
                             "Debe ingresar todos los datos correspondientes.");
                             
                              }
                         
                     }*/
        
                  
         
        //<editor-fold defaultstate="collapsed" desc=" Accion Actualizar Empleado ">
            

             // Actualizar Empleado
            
            
            if(evt.getSource()== registerModify.btnCancel){
            registerModify.modificarCampos(true);
            registerModify.jCalendarbirth_dateEmployee.setEnabled(false);
            
            
                    // Conversion Metodo
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaN = sdf.format(registerModify.jCalendarbirth_dateEmployee.getDate());
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                    String ingreso = sdf1.format(registerModify.jCalendarAdmission_dateEmployee1.getDate());

            if(CamposVacios()==1)
            {
                            empc.ActualizarEployee(registerModify.txtIdEmployee1.getText(), 
                            registerModify.txtposition_idEmployee1.getText(),
                            registerModify.txtbranch_idEmploye1.getText(),
                            registerModify.txtNameEmployee1.getText(),
                            registerModify.txtSurnameEmployee1.getText(),
                            registerModify.txtPhoneEmployee1.getText(),
                            registerModify.txtDirectionEmployee1.getText(),
                            fechaN, ingreso,  
                            registerModify.txtMailEmployee1.getText());
                            
                            
                            //mensaje de error por campos vacios
                             popup = new PopupMessage(registerModify, true, 4, 
                             "Empleado Actualizado Exitosamente");
                            
            }
            else{
               
                             //mensaje de error por campos vacios
                             popup = new PopupMessage(registerModify, true, 1, 
                             "Debe ingresar todos los datos correspondientes.");
                
            }
        }
            

              //</editor-fold> 

        //<editor-fold defaultstate="collapsed" desc=" Accion Eliminar Empleado ">
              
        //Eliminar Empleado

         else if(evt.getSource()==registerModify.btnCancel)
            {
               
                    selectop = new SelectOption(registerModify, true, 1, 
                    "Empleado Actualizado Exitosamente", "Aceptar", "Cancelar");
 
                    if ( selectop.getOpc() == true)
                    {
                         //Eliminar Empleado       
                          empc.EliminarEmployee(registerModify.txtIdEmployee1.getText());
                    }
             
        }
             //</editor-fold>   
             
 //</editor-fold> 
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


  
    
}
  
  
  

  
