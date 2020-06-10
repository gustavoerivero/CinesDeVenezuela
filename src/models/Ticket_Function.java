/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Marihec
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
