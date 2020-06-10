/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Marihec
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
