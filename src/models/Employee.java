
package models;

import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class Employee extends Persona{
    private String
            branch_id,
            position;
    private Date admission_date;
    
    public Employee(String id, String name,String surname, String phone,
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
