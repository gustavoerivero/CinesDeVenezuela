
package models;

/**
 *
 * @author Gustavo
 */
public class Branch {
    
    private String 
            id,
            enterprise_id,
            name,
            direc,
            phone;
    private char estatus;
    
    public Branch(String id, String enterprise_id, String name, String direc, String phone, char estatus){
        this.id=id;
        this.enterprise_id=enterprise_id;
        this.name=name;
        this.direc=direc;
        this.phone=phone;
        this.estatus=estatus;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(String enterprise_id) {
        this.enterprise_id = enterprise_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
    
}
