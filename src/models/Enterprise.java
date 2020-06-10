
package models;
/**
 *
 * @author Gustavo
 */
public class Enterprise {
    private String 
            id,
            name,
            descrip,
            email;
    private char estatus;
    
    
    public Enterprise(String id,String name,String descrip,String email, char estatus){
        this.id=id;
        this.name=name;
        this.descrip=descrip;
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

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }

    
}
