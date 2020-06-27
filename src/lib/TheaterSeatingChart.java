
package lib;

// Se importan las librerías a utilizar.
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Gustavo
 */
public class TheaterSeatingChart {
    
    /**
     * Método que construye el panel con los asientos de la sala de cine.
     * @param rows Filas contenidas en la sala.
     * @param columns Columnas contenidas en la sala.
     * @param cantSeats Cantidad máxima de asientos que pueden ser seleccionados
     * @param container JPanel que servirá de contenedor.
     * @param component JPanel en donde se va a construir la sala.
     * @param lblTotal JLabel que indicará el total de asientos.
     * @param lblFree JLabel que indicará los asientos disponibles.
     * @param lblSelected JLabel que indicará los asientos seleccionados.
     * @param busySeats Listado de los asientos ya ocupados.
     */
    public void buildCinemaSeats(int rows, int columns, int cantSeats, 
            JPanel container, JPanel component, JLabel lblTotal, JLabel lblFree, 
            JLabel lblSelected, ArrayList<String> busySeats){
        
        // Se inicializan los listados de asientos.
        clearSelectedSeats();
        clearFreeSeats();
        clearTotalSeats();
        
        // Se remueven todos los componentes existentes en los paneles.
        container.removeAll();
        component.removeAll();
                
        // Se inicializa la variable.
        cantSeatsToSelect = cantSeats;
        
        // Se indican los iconos a utilizar.
        Icon freeSeat = new javax.swing.ImageIcon(getClass().getResource(
                "/views/images/freeSeat.png"));
        Icon selectedSeat = new javax.swing.ImageIcon(getClass().getResource(
                "/views/images/selectedSeat.png"));
        
        // Se asigna el BorderLayout al JPanel Contenedor.
        container.setLayout(new BorderLayout());
        
        // Luego, se añade el JPanel Componente que se debe encontrar ya centrado.
        container.add(component, BorderLayout.CENTER);
        
        /**
         * Se define el JPanel que contendrá los "asientos". Se hace uso de un
         * GridLayout para crear una especie de matriz y ubicar los JToggleButton
         * de manera más ordenada.
         */
        component.setLayout(new GridLayout(rows + 1, columns + 1));
                
        // Un primer ciclo para indicar los nombres de las columnas (Por números)
        for(int i = 0; i < columns + 1; i++){
            JLabel lbl = new JLabel(String.valueOf(i));         // -> Se crea JLabel y se asigna texto a mostrar.
            lbl.setHorizontalAlignment(SwingConstants.CENTER);  // -> Centra Horizontalmente.
            lbl.setVerticalAlignment(SwingConstants.CENTER);    // -> Centra Verticalmente.
            component.add(lbl);                                   // -> Añade el JLabel
        }
        
        // El Ciclo Mayor; Va a construir la matriz fila por fila.
        for (int row = 1; row < rows + 1; row++) {
            
            // La primera columna va a indicar el nombre de cada fila (Por letras)
            JLabel lbl2 = new JLabel(String.valueOf((char) ('A' + (rows - row))));  // -> Método para mostrar letras del abecedario en mayúscula.
            lbl2.setHorizontalAlignment(SwingConstants.CENTER);                     // -> Centra Horizontalmente.
            lbl2.setVerticalAlignment(SwingConstants.CENTER);                       // -> Centra Verticalmente.
            component.add(lbl2);                                                    // -> Añade el JLabel
            
            // El Ciclo Menor; Va a ir agregando elemento a elemento según la columna.
            for (int column = 1; column < columns + 1; column++) {
                
                // Se crea e instancia el JToggleButton.
                JToggleButton button = new JToggleButton();
                // Se le indica un nombre (Nombre de la fila + Nombre de la columna)
                button.getAccessibleContext().setAccessibleName((char) ('A' + (rows - row)) // -> Método para mostrar letras del abecedario en mayúscula.
                         + String.valueOf(column));
                
                // Se totalizan todos los asientos.
                totalSeats.add(button.getAccessibleContext().getAccessibleName());
                
                button.setIcon(freeSeat);                                       // Se le da un ícono (Asiento predeterminado (Vacío)
                button.setBorder(null);                                         // Se le quitan los bordes.
                button.setBorderPainted(false);                                 // Si se selecciona, no muestra bordes.
                button.setContentAreaFilled(false);                             // Si se selecciona, no muestra sombra de selección.
                button.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));  // Se implementa un borde vacío.
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));               // Si el mouse está por encima, el cursor adopta forma de mano.
                
                // Se recorre el listado de los asientos ya ocupados.
                for(int i = 0; i < busySeats.size(); i++){
                    
                    /*
                     * Si el asiento ya está ocupado se bloquea el botón o si se 
                     * ha seleccionado la cantidad de asientos que se van a 
                     * comprar, se bloquean el resto de asientos.
                     */
                    if(busySeats.get(i).equals(button.getAccessibleContext().getAccessibleName()) ||
                            cantSeatsToSelect <= selectedSeats.size()){
                        
                        // Técnicamente vuelve a confirmar lo mismo de arriba, no sé porqué sin esto no me funciona.
                        if(busySeats.get(i).equals(button.getAccessibleContext().getAccessibleName()) ||
                                (cantSeatsToSelect <= selectedSeats.size() && button.getIcon() == freeSeat))
                            button.setEnabled(false); // -> El JToggleButton se desactiva.
                        else
                            button.setEnabled(true); // -> El JToggleButton se activa.
                    }
                    
                }
                
                // Se añade a la lista de asientos disponibles.
                if(button.isEnabled())
                    freeSeats.add(button.getAccessibleContext().getAccessibleName());
                                  
                // Evento activador (Qué ocurre al ser seleccionado el JToggleButton)
                button.addActionListener((ActionEvent evt) -> { // Expresión Lambda
                    AbstractButton abstractButton = (AbstractButton) evt.getSource();
                    boolean selected = abstractButton.getModel().isSelected();
                    
                    // Si el JToggleButton está seleccionado.
                    if (selected) {
                        
                        if(selectedSeats.size() >= cantSeatsToSelect){
                            
                            // Se imprime en consola que no se puede permitir el click en la celda seleccionada.
                            System.out.println("No se puede hacer click en el botón de la celda: " +
                                button.getAccessibleContext().getAccessibleName());
                        
                            // Se deselecciona el botón.
                            button.setSelected(false);
                            
                        }
                        
                        else{
                        
                            button.setIcon(selectedSeat); // -> Se muestra ícono de asiento seleccionado.

                            // Se imprime en consola en dónde se hizo click.
                            System.out.println("Se selecciona el botón en la celda: " +
                                    button.getAccessibleContext().getAccessibleName());

                            // Se añade al listado de asientos seleccionados
                            selectedSeats.add(button.getAccessibleContext().getAccessibleName());

                            // Se retira del listado de asientos seleccionados
                            freeSeats.remove(button.getAccessibleContext().getAccessibleName());
                        
                        }
                    }
                    
                    // Caso contrario: Si el JToggleButton es deseleccionado.
                    else {
                        
                        // Se imprime en consola en dónde se hizo click.
                            System.out.println("Se deselecciona el botón en la celda: " +
                                    button.getAccessibleContext().getAccessibleName());
                        
                        button.setIcon(freeSeat); // -> Se muestra ícono predeterminado.
                        
                        // Se obtiene el índice del asiento seleccionado.
                        int index = searchIndexOnSelectedSeats(
                                button.getAccessibleContext().getAccessibleName());
                        
                        // Si el asiento efectivamente está siendo seleccionado.
                        if(index != -1){
                            
                            // Se retira del listado de asientos ocupados.
                            selectedSeats.remove(index);
                            
                            // Se añade al listado de asientos disponibles.
                            freeSeats.add(button.getAccessibleContext().getAccessibleName());
                            
                        }
                        
                    }
                    
                    // Muestra la cantidad de asientos disponibles.
                    lblFree.setText(String.valueOf(freeSeats.size()));
                    
                    // Muestra la cantidad de asientos seleccionados.
                    lblSelected.setText(String.valueOf(selectedSeats.size()));
                    
                });
                
                // Muestra la cantidad de asientos.
                lblTotal.setText(String.valueOf(totalSeats.size()));
                lblTotal.repaint();
                
                // Muestra la cantidad de asientos disponibles.
                lblFree.setText(String.valueOf(freeSeats.size()));
                lblFree.repaint();
                
                // Muestra la cantidad de asientos seleccionados.
                lblSelected.setText(String.valueOf(selectedSeats.size()));
                lblSelected.repaint();
                                
                // Se añade el JToggleButton al JPanel.
                component.add(button);
                                                            
            }
                        
        }
                        
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Declaración de variables a utilizar ">
    
    private ArrayList<String> selectedSeats = new ArrayList<>();
    private ArrayList<String> freeSeats     = new ArrayList<>();
    private ArrayList<String> totalSeats    = new ArrayList<>();
    private int cantSeatsToSelect           = 0; // Cantidad de asientos a seleccionar.
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc=" Métodos para la manipulación de los listados ">
    
    /**
     * Método que obtiene el arreglo de asientos seleccionados.
     * @return Retorna el listado de tipo String.
     */
    public ArrayList<String> getSeatsSelected() {
        return selectedSeats;
    }

    /**
     * Método que guarda el listado de asientos seleccionados.
     * @param selectedSeats Parámetro de listado con arreglos seleccionados.
     */
    public void setSeatsSelected(ArrayList<String> selectedSeats) {
        this.selectedSeats = selectedSeats;
    }
    
    /**
     * Método para vaciar el listado de asientos seleccionados.
     */
    public void clearSelectedSeats(){
        this.selectedSeats.clear();
    }
    
    /**
     * Método que permite buscar el asiento seleccionado del listado.
     * @param seat asiento a buscar.
     * @return índice del asiento.
     */
    public int searchIndexOnSelectedSeats(String seat){
        
        for (int i = 0; i < selectedSeats.size(); i++)
            
            if(seat.equals(selectedSeats.get(i)))
                return i;
            
        return -1;
    }
    
    /**
     * Método que obtiene el arreglo de asientos libres.
     * @return Retorna el listado de tipo String.
     */
    public ArrayList<String> getFreeSeats() {
        return freeSeats;
    }

    /**
     * Método que guarda el listado de asientos libres.
     * @param freeSeats Parámetro de listado con arreglos libres.
     */
    public void setFreeSeats(ArrayList<String> freeSeats) {
        this.freeSeats = freeSeats;
    }
    
    /**
     * Método para vaciar el listado de asientos libres.
     */
    public void clearFreeSeats(){
        this.freeSeats.clear();
    }
    
    /**
     * Método que permite buscar el asiento libre del listado.
     * @param seat asiento a buscar.
     * @return índice del asiento.
     */
    public int searchIndexOnFreeSeats(String seat){
        
        for (int i = 0; i < freeSeats.size(); i++)
            
            if(seat.equals(freeSeats.get(i)))
                return i;
            
        return -1;
    }
    
    /**
     * Método que obtiene el arreglo de todos los asientos.
     * @return Retorna el listado de tipo String.
     */
    public ArrayList<String> getTotalSeats() {
        return totalSeats;
    }

    /**
     * Método que guarda el listado de todos los asientos.
     * @param totalSeats Parámetro de listado con arreglos seleccionados.
     */
    public void setTotalSeats(ArrayList<String> totalSeats) {
        this.totalSeats = totalSeats;
    }
    
    /**
     * Método para vaciar el listado de todos los asientos..
     */
    public void clearTotalSeats(){
        this.totalSeats.clear();
    }
    
    /**
     * Método que permite buscar un asiento del total de asientos.
     * @param seat asiento a buscar.
     * @return índice del asiento.
     */
    public int searchIndexOnTotalSeats(String seat){
        
        for (int i = 0; i < totalSeats.size(); i++)
            
            if(seat == null ? totalSeats.get(i) == null : seat.equals(totalSeats.get(i)))
                return i;
            
        return -1;
    }
   
    //</editor-fold>
        
}
