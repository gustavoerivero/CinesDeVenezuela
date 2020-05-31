
package models;

/**
 *
 * @author Gustavo
 */
public class Ticket {
    
    String id;
    char type, estatus;

    public Ticket(String id, char type, char estatus) {
        
        this.id = id;
        this.type = type;
        this.estatus = estatus;
        
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }

}