
package models;

import java.util.Date;

/**
 *  Materia: Laboratorio I
 *  Sección: 1
 *      Integrantes:
 *          @author Brizuela, Yurisbellys   C.I: 27.142.239
 *          @author Miranda, Marihec        C.I: 26.120.075
 *          @author Montero, Michael        C.I: 26.561.077
 *          @author Rivero, Gustavo         C.I: 26.772.857
 *          @author Torrealba, Luis         C.I: 26.121.249
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
