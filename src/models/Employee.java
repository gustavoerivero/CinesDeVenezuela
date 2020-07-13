
package models;

import java.util.Date;

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
public class Employee extends Persona{
    private String
            branch_id,
            position;
    private Date admission_date;
    
    public Employee(String id, String name,String surname, long phone,
            String direction,Date birth_date,String email, char estatus,
            String branch_id, String position, Date admission_date){
        
        super(id, name, surname, phone, direction, birth_date, email, estatus);
        
        this.branch_id=branch_id;
        this.position=position;
        this.admission_date=admission_date;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getAdmission_date() {
        return admission_date;
    }

    public void setAdmission_date(Date admission_date) {
        this.admission_date = admission_date;
    }
    
    
}
