
package models;

import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class Client extends Persona{
    
    public Client(String id, String name,String surname,
            String phone,String direction,Date birth_date, 
            String email, char estatus){
        super(id, name, surname, phone, direction, birth_date, email, estatus);
            
    }
    
}
