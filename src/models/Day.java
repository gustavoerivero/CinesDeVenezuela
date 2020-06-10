
package models;

/**
 *
 * @author Gustavo
 */
public class Day {
    private String
            id,
            type;
    private char estatus;
    
    public Day(String id, String type, char estatus){
        this.id=id;
        this.type=type;
        this.estatus=estatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
    
    
}
