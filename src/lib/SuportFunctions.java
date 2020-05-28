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

}
