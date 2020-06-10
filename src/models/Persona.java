
package models;

import java.util.Date;

/**
 *
 * @author Gustavo Rivero
 */
public class Persona {
    private String
            id,
            name,
            surname,
            phone,
            direction,
            email;
    private Date birth_date;
    public char estatus;
    
    public Persona(String id, String name,String surname,
            String phone,String direction,Date birth_date,
            String email, char estatus){
        
        super();
        
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.phone=phone;
        this.direction=direction;
        this.birth_date=birth_date;
        this.email=email;
        this.estatus=estatus;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }

}

