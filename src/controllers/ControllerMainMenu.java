
package controllers;

// Se importan las views que se van a utilizar
import views.MainPage;
import views.PopupMessage;

// Se importan los models que se van a utilizar
import models.*;

// Se importan las clases de soporte a utilizar
import lib.SuportFunctions;
import lib.PDFGenerator;

// Se importan las librerías a utilizar
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class ControllerMainMenu implements java.awt.event.ActionListener{
    
    // Instanciar las clases necesarias para el funcionamiento.
    public MainPage mainPage;
    private ControllerSelectSucursal cSelectSucursal;
    private SuportFunctions suport;
    private PopupMessage popup;
                
    ArrayList<Ticket_Candy> candy_list = new ArrayList<Ticket_Candy>();
    ArrayList<Candy> candies_list = new ArrayList<Candy>();
    
    ArrayList<String> names_list = new ArrayList<String>();
    ArrayList<Integer> cants_list = new ArrayList<Integer>();    
    
    public ControllerMainMenu(){
        // Declarar la variable de las clases instanciadas.
        mainPage = new MainPage();
        suport = new SuportFunctions();
        
        // Activamos los eventos provocados por los botones.
        mainPage.addEvents(this);
        
        
    }

    /*
     * Método que determina las acciones a realizar por la aplicación según el 
     * botón presionado.
     */
    public void actionPerformed(java.awt.event.ActionEvent evt){
        
        //<editor-fold defaultstate="collapsed" desc=" Botones de la Barra Superior ">
        
        // Minimizar aplicación.
        if(evt.getSource() == mainPage.btnMin){
            mainPage.setExtendedState(java.awt.Frame.ICONIFIED);
            mainPage.btnMin.setBackground(new java.awt.Color(249,249,249));
        } 
        
        // Salir de la aplicación.
        else if(evt.getSource() == mainPage.btnExit){
            System.exit(0);
        } 

        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Botones del Menú Lateral ">
        
        // Menú Lateral -> Inicio
        else if(evt.getSource() == mainPage.btnOptionLateral1){
            suport.cardSelection(mainPage.panContent, mainPage.panOption1);
            
        } 

        // Menú Lateral -> Ventas
        else if(evt.getSource() == mainPage.btnOptionLateral2){
            suport.cardSelection(mainPage.panContent, mainPage.panOption2);
            suport.cardSelection(mainPage.panOption2, mainPage.panDecisionOption2);
            
        }
        
        // Menú Lateral -> Reportes
        else if(evt.getSource() == mainPage.btnOptionLateral3){
            suport.cardSelection(mainPage.panContent, mainPage.panOption3);
            
        }
        
        // Menú Lateral -> Empleados
        else if(evt.getSource() == mainPage.btnOptionLateral4){
            suport.cardSelection(mainPage.panContent, mainPage.panOption4);
            
        }
        
        // Menú Lateral -> Sucursales
        else if(evt.getSource() == mainPage.btnOptionLateral5){
            suport.cardSelection(mainPage.panContent, mainPage.panOption5);
            
        }
        
        // Menú Lateral -> Configuración
        else if(evt.getSource() == mainPage.btnOptionLateral6){
            suport.cardSelection(mainPage.panContent, mainPage.panOption6);
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Botones del MainPage Option 1 ">
        
        // Opción 2 -> Ventas
        else if(evt.getSource() == mainPage.btnBodyOption2){
            mainPage.panBodyOption2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
           
            suport.cardSelection(mainPage.panContent, mainPage.panOption2);
            suport.cardSelection(mainPage.panOption2, mainPage.panDecisionOption2);
                        
        }
        
        // Opción 3 -> Reportes
        else if(evt.getSource() == mainPage.btnBodyOption3){
            mainPage.panBodyOption3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            
            suport.cardSelection(mainPage.panContent, mainPage.panOption3);
            
        }
        
        // Opción 4 -> Empleados
        else if(evt.getSource() == mainPage.btnBodyOption4){
            mainPage.panBodyOption4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            
            suport.cardSelection(mainPage.panContent, mainPage.panOption4);
            
        }
        
        // Opción 5 -> Sucursales
        else if(evt.getSource() == mainPage.btnBodyOption5){
            mainPage.panBodyOption5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            
            suport.cardSelection(mainPage.panContent, mainPage.panOption5);
            
        }
        
        // Opción 6 -> Configuración
        else if(evt.getSource() == mainPage.btnBodyOption6){
            mainPage.panBodyOption6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            
            suport.cardSelection(mainPage.panContent, mainPage.panOption6);
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Botones del MainPage Option 2 ">
        
        //<editor-fold defaultstate="collapsed" desc=" Decisión en la Opción 2 ">
                
        // Tickets de Golosinas
        else if(evt.getSource() == mainPage.btnCandyDecision){
            mainPage.panCapsuleCandyDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
        
            suport.cardSelection(mainPage.panOption2, mainPage.panCandySell);
            
            mainPage.clearCandySell();
            
            candy_list.clear();
            
        }
        
        //<editor-fold defaultstate="collapsed" desc=" Venta de tickets para golosinas ">
        
        // Volver para la sección anterior
        else if(evt.getSource() == mainPage.btnBackToTicketDecision1){
            mainPage.btnBackToTicketDecision1.setBackground(new java.awt.Color(249,249,249));
            
            suport.cardSelection(mainPage.panOption2, mainPage.panDecisionOption2);
            
        }
        
        // Cambiar de sucursal a gestionar
        else if(evt.getSource() == mainPage.btnChangeSucursalCandySell){
            
            // Instanciar la clase
            cSelectSucursal = new ControllerSelectSucursal();
            
            
        }
        
        // Agregar golosinas
        else if(evt.getSource() == mainPage.btnAddCandySell){
            
            // Si no se ha seleccionado alguna golosina a agregar.
            if(mainPage.cmbCandySelection.getSelectedIndex() == 0)
                // Se muestra un mensaje de que la venta fue generada con éxito.
                popup = new PopupMessage(1, "Ingrese alguna cantidad de golosinas.");
            
            // Si no se ha indicado una cantidad de golosina a agregar.
            else if((int) mainPage.spnCantCandySell.getValue() == 0)
                // Se muestra un mensaje de que la venta fue generada con éxito.
                popup = new PopupMessage(1, "Ingrese alguna cantidad de golosinas.");
            
            // Si se seleccionó una golosina y se indicó la cantidad a agregar.
            else{
                
                // Se debe restructurar esta sección con métodos y datos obtenidos de la BD
                
                String id = "";
                int cant = (int) mainPage.spnCantCandySell.getValue();
                char type_Ticket = '1', estatus = '1';
                double mount = 5000;
                
                String id_candies = mainPage.cmbCandySelection.getSelectedItem().toString();
                
                Ticket_Candy ticket_candy = new Ticket_Candy(id, type_Ticket, estatus, id_candies, cant);
                
                Candy candy = new Candy(id, id_candies, id, 99, mount, estatus);
                                
                candy_list.add(ticket_candy);
                candies_list.add(candy);
                
                mainPage.cmbCandySelection.setSelectedIndex(0);
                mainPage.spnCantCandySell.setValue((int) 0);
                                                         
                showCandiesOnTicket(names_list, cants_list);
                                
            }
            
        }
        
        // Retornar los valores iniciales
        else if(evt.getSource() == mainPage.btnCandySellClear){
            
            // Aplicar método que retorna los componentes a sus valores iniciales
            mainPage.clearCandySell();
            
        }
        
        // Realizar la venta de golosinas
        else if(evt.getSource() == mainPage.btnCandySell){
            
            // Se genera un JFileChooser para obtener la ruta en donde se va a guardar los archivos.
            javax.swing.JFileChooser FileChooser = new javax.swing.JFileChooser();
            
            // Se crea una variable para mostrar el JFileChooser
            int option = FileChooser.showSaveDialog(mainPage);
            
            // Cuando se aprueba la ubicación, se obtiene la ruta de guardado
            if(option == javax.swing.JFileChooser.APPROVE_OPTION){
                File file = FileChooser.getSelectedFile();
                
                // Se transforma la ruta en una variable de tipo String
                String path = file.toString();
                
                try {
                    
                    // Se instancia la clase
                    PDFGenerator g = new PDFGenerator();
                       
                    /* 
                     * Se llama el método generador de ticket para golosinas pasándole
                     * los parámetros correspondientes.
                     */
                    g.pdfCandyTicket(mainPage.txtIdClientCandySell.getText(),
                            mainPage.cmbCandySeller.getSelectedItem().toString(),
                            "Sucursal XYZ", 
                            path + ".pdf",
                            (int) java.lang.Math.random(),
                            names_list, cants_list);
                    
                    // Se muestra un mensaje de que la venta fue generada con éxito.
                    popup = new PopupMessage(4, "La venta se ha realizado exitosamente");
                    
                    
                } catch (Exception e) {
                    // De producirse un error, se muestra en consola.
                    System.out.print("Error: " + e);
                }
                
            }
            
            
        }
        
        //</editor-fold>
        
        // Tickets de funciones
        else if(evt.getSource() == mainPage.btnCinemaDecision){
            mainPage.panCapsuleCinemaDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
        
            suport.cardSelection(mainPage.panOption2, mainPage.panCinemaSell);
        }
        
        //<editor-fold defaultstate="collapsed" desc=" Venta de tickets para funciones ">
        
        // Volver para la sección anterior
        else if(evt.getSource() == mainPage.btnBackToTicketDecision2){
            mainPage.btnBackToTicketDecision2.setBackground(new java.awt.Color(249,249,249));
            
            suport.cardSelection(mainPage.panOption2, mainPage.panDecisionOption2);
            
        }
        
        //</editor-fold>
        
        //</editor-fold>
        
        //</editor-fold>
        
    }
    
    // Método para mostrar en la tabla las golosinas seleccionadas.
    public void showCandiesOnTicket(ArrayList<String> names, ArrayList<Integer> cants){
        
        /*
         * Se crea la matriz que se mostrará en la tabla; las filas corresponden 
         * a la cantidad de elementos de la lista mientras que las columnas serán 
         * las 7 por defecto.
         */
        String[][] matriz_candy = new String[candy_list.size()][7];
        
        // Se crean las variables acumuladoras que mostrarán los montos correspondientes
        double acum_Sub = 0, acum_IVA = 0, acum_Total = 0;
        
        // Se crea un índice 'j'
        int j = 0;
        
        // Se limpian los arrays que se utilizarán para la elaboración del ticket y factura
        names.clear();
        cants.clear();
                
        for (int i = 0; i < candy_list.size(); i++){
            
            // Se inicializa el índice 'j'
            j = 0;
            
            // Se busca el precio del producto
            while(!candies_list.get(j).getName().equals(candy_list.get(i).getId_candies()))
                j++;
            
            // Se dan valores a los elementos de la matriz
            matriz_candy[i][0] = candy_list.get(i).getId_candies();
            matriz_candy[i][1] = String.valueOf(candy_list.get(i).getCant());
            matriz_candy[i][2] = String.valueOf(candies_list.get(j).getPrice());
            matriz_candy[i][3] = String.valueOf(candies_list.get(j).getPrice() * 0.16);
            matriz_candy[i][4] = String.valueOf(candies_list.get(j).getPrice() * 1.16);
            matriz_candy[i][5] = String.valueOf(candies_list.get(j).getPrice() * 1.16 * candy_list.get(i).getCant());
            matriz_candy[i][6] = "Botón eliminar";
            
            // Los acumuladores son llenados
            acum_Sub    += candies_list.get(j).getPrice() * candy_list.get(i).getCant();
            acum_IVA    += candies_list.get(j).getPrice() * 0.16 * candy_list.get(i).getCant();
            acum_Total  += candies_list.get(j).getPrice() * 1.16 * candy_list.get(i).getCant();
            
            // Los arrays son llenados
            names.add(candy_list.get(i).getId_candies());
            cants.add(candy_list.get(i).getCant());
                                        
        }
           
        // La tabla adquiere el formato indicado
        mainPage.tblCandy.setModel(new javax.swing.table.DefaultTableModel(
            // Las celdas son llenadas por la información que posee la matriz
            matriz_candy, 
            
            // Se indican las columnas por defecto
            new String [] {
                "Golosina", "Cantidad", "Precio (Unidad)", "IVA (Unidad)",
                "Monto (Unidad)", "Total", "Acción"
            }){
                // Ningún campo es editable
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false
                };
                
                // Se aplican los cambios de celdas editables
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
        });
                       
        // Se muestran en pantalla la información de los acumuladores
        mainPage.txtSubTotalCandy.setText(String.valueOf(acum_Sub));
        mainPage.txtIVACandy.setText(String.valueOf(acum_IVA));
        mainPage.txtTotalCandy.setText(String.valueOf(acum_Total));
        
    
    }
    
    
}
