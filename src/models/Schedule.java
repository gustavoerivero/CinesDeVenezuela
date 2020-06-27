
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
public class Schedule {
    private String
            id,
            hour, branch_id;
    private Date day_id;
    
    public Schedule(String id, Date day_id,String hour, String branch_id){
        this.id=id;
        this.day_id=day_id;
        this.hour=hour;
        this.branch_id=branch_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDay_id() {
        return day_id;
    }

    public void setDay_id(Date day_id) {
        this.day_id = day_id;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }
    
    
}
