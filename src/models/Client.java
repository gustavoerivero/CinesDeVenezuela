
package models;

import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class Client extends Persona{
    private char type;
    
    public Client(String id, String name,String surname,
            String phone,String direction,Date birth_date, 
            String email, char estatus, char type){
        super(id, name, surname, phone, direction, birth_date, email, estatus);
           
       this.type=type; 
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
    
    
}
