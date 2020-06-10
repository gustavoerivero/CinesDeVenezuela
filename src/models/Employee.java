
package models;

import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class Employee extends Persona{
    private String
            branch_id,
            position_id;
    private Date admission_date;
    
    public Employee(String id, String name,String surname, String phone,
            String direction,Date birth_date,String email, char estatus,
            String branch_id, String position_id, Date admission_date){
        
        super(id, name, surname, phone, direction, birth_date, email, estatus);
        
        this.branch_id=branch_id;
        this.position_id=position_id;
        this.admission_date=admission_date;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getPosition_id() {
        return position_id;
    }

    public void setPosition_id(String position_id) {
        this.position_id = position_id;
    }

    public Date getAdmission_date() {
        return admission_date;
    }

    public void setAdmission_date(Date admission_date) {
        this.admission_date = admission_date;
    }
    
    
}
