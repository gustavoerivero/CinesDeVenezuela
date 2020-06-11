package lib;

/**
 *
 * @author Gustavo
 */
public class SuportFunctions {
    
    // Constructor
    public SuportFunctions(){
        
    }
    
    /**
     * Método para utilizar de manera cómoda y rápida el CardLayout.
     * @param base JPanel Base; es el JPanel contenedor o padre.
     * @param opc  JPanel Opc; es el JPanel que se va a mostrar o hijo.
     */
    public void cardSelection(javax.swing.JPanel base, javax.swing.JPanel opc){
        base.removeAll(); // Elimina el contenido del JPanel principal.
        base.add(opc); // Añade el segundo JPanel al JPanel principal.
        base.repaint(); // Actualiza el contenido del JPanel principal.
        base.revalidate(); // Validar el contenido del JPanel principal.
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Métodos de validación ">

    /**
     * Método para validar números enteros y positivos
     * @param evt Variable KeyEvent.
     */
    public void integerPositiveKeyTyped(java.awt.event.KeyEvent evt){
        // Se trae el caracter ingresado en el campo de texto correspondiente.
        char numbers = evt.getKeyChar();
        // Se aplica la condición para que se elimine o no el caracter.
        if(numbers < '0' || numbers > '9')
            // Si cumple la condición, el caracter se elimina.
            evt.consume();
    }
    
    /**
     * Método para validar letras del abecedario.
     * @param evt variable de tipo KeyEvent
     */
    public void alphabetKeyTyped(java.awt.event.KeyEvent evt){
        // Se trae el caracter ingresado en el campo de texto correspondiente.
        char letters = evt.getKeyChar();
        // Se aplica la condición para que se elimine o no el caracter.
        if((letters < 'a' || letters > 'z') && (letters < 'A' || letters > 'Z') && (letters != ' '))
            // Si cumple la condición, el caracter se elimina.
            evt.consume();
    }
    
    public boolean isPasswordCorrect(char[] passOne, char[] passTwo) {
        
        boolean valor = true;
        
        int pointer = 0;
        
        if (passOne.length != passTwo.length)
            valor = false;
        
        else{
            while((valor)&&(pointer < passOne.length)){
                
                if (passOne[pointer] != passTwo[pointer])
                    valor = false;
                
                pointer++;
                
            }
            
        }
        
        return valor;
    }
        
    //</editor-fold>
    
    // Métodos para dar formato a números.
    
    /**
     * Método para dar formato a variables de tipo Double.
     * @param number es el número al que se le quiere dar un formato.
     * @param decimal la cantidad de decimales que se quieren mostrar.
     * @return retorna el número con el formato deseado.
     */
    public Double numberDecimalFormat(Double number, Integer decimal){
        return Math.round(number * Math.pow(10, decimal)) / Math.pow(10, decimal);
    }
    
}
