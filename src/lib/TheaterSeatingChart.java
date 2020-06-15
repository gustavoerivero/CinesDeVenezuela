
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
    
    // Se declaran y se instancias las variables a utilizar.
    private ArrayList<String> selectedSeats = new ArrayList<>();
    private ArrayList<String> freeSeats     = new ArrayList<>();
    private ArrayList<String> totalSeats    = new ArrayList<>();
        
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
     * Método que permite obtener el valor de un único asiento seleccionado.
     * @param index índice del listado.
     * @return Retorna el valor del asiento seleccionado.
     */
    public String getOnlyOneSelectedSeat(int index){
        return selectedSeats.get(index);
    }
    
    /**
     * Método que inserta valor de un asiento seleccionado.
     * @param index índice del listado.
     * @param seat asiento.
     */
    public void insertOnlyOneSelectedSeat(int index, String seat){
        this.selectedSeats.set(index, seat);
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
            
            if(seat == selectedSeats.get(i))
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
     * Método que permite obtener el valor de un único asiento libre.
     * @param index índice del listado.
     * @return Retorna el valor del asiento libre.
     */
    public String getOnlyOneFreeSeat(int index){
        return freeSeats.get(index);
    }
    
    /**
     * Método que inserta valor de un asiento libre.
     * @param index índice del listado.
     * @param seat asiento.
     */
    public void insertOnlyOneFreeSeat(int index, String seat){
        this.freeSeats.set(index, seat);
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
            
            if(seat == freeSeats.get(i))
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
     * Método que permite obtener el valor de un único asiento del total.
     * @param index índice del listado.
     * @return Retorna el valor del asiento buscado.
     */
    public String getOnlyOneTotalSeat(int index){
        return totalSeats.get(index);
    }
    
    /**
     * Método que inserta valor de un asiento buscado.
     * @param index índice del listado.
     * @param seat asiento.
     */
    public void insertOnlyOneTotalSeat(int index, String seat){
        this.totalSeats.set(index, seat);
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
            
            if(seat == totalSeats.get(i))
                return i;
            
        return -1;
    }
    
    //</editor-fold>
    
    /**
     * Método que construye el panel con los asientos de la sala de cine.
     * @param rows Filas contenidas en la sala.
     * @param columns Columnas contenidas en la sala.
     * @param container JPanel que servirá de contenedor.
     * @param component JPanel en donde se va a construir la sala.
     * @param freeSeat Ícono que indicará los asientos disponibles.
     * @param selectedSeat Ícono que indicará los asientos seleccionados.
     * @param lblTotal JLabel que indicará el total de asientos.
     * @param lblFree JLabel que indicará los asientos disponibles.
     * @param lblSelected JLabel que indicará los asientos seleccionados.
     */
    public void buildCinemaSeats(int rows, int columns, JPanel container,
            JPanel component, Icon freeSeat, Icon selectedSeat, JLabel lblTotal,
            JLabel lblFree, JLabel lblSelected){
        
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
                
                // Prueba: Si la fila es igual a la columna.
                if(row == column)
                    button.setEnabled(false); // -> El JToggleButton se desactiva.
                else // Se añade a la lista de asientos disponibles.
                    freeSeats.add(button.getAccessibleContext().getAccessibleName());
                      
                // Evento activador (Qué ocurre al ser seleccionado el JToggleButton)
                button.addActionListener((ActionEvent evt) -> { // Expresión Lambda
                    AbstractButton abstractButton = (AbstractButton) evt.getSource();
                    boolean selected = abstractButton.getModel().isSelected();
                    
                    // Si el JToggleButton está seleccionado.
                    if (selected) {
                        button.setIcon(selectedSeat); // -> Se muestra ícono de asiento seleccionado.
                        
                        // Se imprime en consola en dónde se hizo click.
                        System.out.println("Click en el botón en la celda: " +
                                button.getAccessibleContext().getAccessibleName());
                        
                        // Se añade al listado de asientos seleccionados
                        selectedSeats.add(button.getAccessibleContext().getAccessibleName());
                        
                        // Se retira del listado de asientos seleccionados
                        freeSeats.remove(button.getAccessibleContext().getAccessibleName());
                        
                        
                    }
                    
                    // Caso contrario: Si el JToggleButton es deseleccionado.
                    else {
                        button.setIcon(freeSeat); // -> Se muestra ícono predeterminado.
                        
                        int index = searchIndexOnSelectedSeats(
                                button.getAccessibleContext().getAccessibleName());
                        
                        if(index != -1){
                            selectedSeats.remove(index);
                            
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
                
                // Muestra la cantidad de asientos disponibles.
                lblFree.setText(String.valueOf(freeSeats.size()));
                                
                // Se añade el JToggleButton al JPanel.
                component.add(button);
                
            }
        
        }
        
    }
    
}
