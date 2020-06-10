
package models;

/**
 *
 * @author Gustavo
 */
public class City {
    
    private String
            id,
            name;
    private char
            estatus;
    public City(String id, String name, char estatus){
        this.id=id;
        this.name=name;
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

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
    
    
}
