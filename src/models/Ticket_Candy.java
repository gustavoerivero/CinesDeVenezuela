
package models;

/**
 *
 * @author Gustavo
 */
public class Ticket_Candy extends Ticket{
    
    private String id_candies;
    private int cant;
    
    public Ticket_Candy(String id, char type, char estatus, String id_candies, int cant) {
        
        super(id, type, estatus);
        
        this.id_candies = id_candies;
        this.cant = cant;
        
    }

    public String getId_candies() {
        return id_candies;
    }

    public void setId_candies(String id_candies) {
        this.id_candies = id_candies;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
}
