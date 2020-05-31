package lib;

/**
 *
 * @author Gustavo
 */
public class SuportFunctions {
    
    // Constructor
    public SuportFunctions(){
        
    }
    
    // Método para utilizar de manera cómoda el cardLayout.
    public void cardSelection(javax.swing.JPanel base, javax.swing.JPanel opc){
        base.removeAll(); // Elimina el contenido del JPanel principal.
        base.add(opc); // Añade el segundo JPanel al JPanel principal.
        base.repaint(); // Actualiza el contenido del JPanel principal.
        base.revalidate(); // Validar el contenido del JPanel principal.
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Métodos de validación ">

    // Método para validar números enteros y positivos.
    public void integerPositiveKeyTyped(java.awt.event.KeyEvent evt){
        // Se trae el caracter ingresado en el campo de texto correspondiente.
        char numbers = evt.getKeyChar();
        // Se aplica la condición para que se elimine o no el caracter.
        if(numbers < '0' || numbers > '9')
            // Si cumple la condición, el caracter se elimina.
            evt.consume();
    }
    
    // Método para validar letras mayúsculas y minúsculas.
    public void alphabetKeyTiped(java.awt.event.KeyEvent evt){
        // Se trae el caracter ingresado en el campo de texto correspondiente.
        char letters = evt.getKeyChar();
        // Se aplica la condición para que se elimine o no el caracter.
        if((letters < 'a' || letters > 'z') && (letters < 'A' || letters > 'Z') && (letters != ' '))
            // Si cumple la condición, el caracter se elimina.
            evt.consume();
    }
    
    
    //</editor-fold>
    
    // Métodos para dar formato a números.
    
    // Método para dar cantidad de decimales a un número.
    public Double numberDecimalFormat(Double number, Integer decimal){
        return Math.round(number * Math.pow(10, decimal)) / Math.pow(10, decimal);
    }
    
}
