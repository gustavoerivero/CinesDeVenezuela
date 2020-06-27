
package models;

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
public class Ticket_Function extends Ticket{
    private String
            function_id,
            butaca;
    
    public Ticket_Function(String id, char type, char estatus, 
            String function_id, String butaca){
        
        super(id, type, estatus);
        this.function_id=function_id;
        this.butaca=butaca;
    }

    public String getFunction_id() {
        return function_id;
    }

    public void setFunction_id(String function_id) {
        this.function_id = function_id;
    }

    public String getButaca() {
        return butaca;
    }

    public void setButaca(String butaca) {
        this.butaca = butaca;
    }
    
    
}
