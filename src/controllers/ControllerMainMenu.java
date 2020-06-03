
package controllers;

// Se importan las views que se van a utilizar
import views.MainPage;
import views.ChangeBranch;
import views.PopupMessage;

// Se importan los models que se van a utilizar
import models.*;

// Se importan las clases de soporte a utilizar
import lib.SuportFunctions;
import lib.PDFGenerator;

// Se importan las librerías a utilizar
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class ControllerMainMenu implements java.awt.event.ActionListener{
    
    // Instanciar las clases necesarias para el funcionamiento.
        // Views
        private MainPage mainPage;
        private PopupMessage popup;
        private ChangeBranch changeBranch;

        // Suport Class
        private SuportFunctions suport;
                
    // Instanciar las variables necesarias para el funcionamiento.    
    ArrayList<Ticket_Candy> candy_list = new ArrayList<Ticket_Candy>();
    ArrayList<Candy> candies_list = new ArrayList<Candy>();
    
    ArrayList<String> enterprise_data = new ArrayList<String>();
    ArrayList<String> seller_list = new ArrayList<String>();
    ArrayList<String> client_data = new ArrayList<String>();
    
    ArrayList<String> id_tickets = new ArrayList<String>();
    
    ArrayList<String> names_list = new ArrayList<String>();
    ArrayList<Integer> cants_list = new ArrayList<Integer>(); 
    ArrayList<Double> amounts_list = new ArrayList<Double>();
        
    public ControllerMainMenu(){
        // Declarar la variable de las clases instanciadas.
        mainPage = new MainPage();
        suport = new SuportFunctions();
        
        // Activamos los eventos provocados por los botones.
        mainPage.addEvents(this);
        
    }

    /**
     * Método que determina las acciones a realizar por la aplicación según el 
     * botón presionado.
     * @param evt indica los eventos posibles a ocurrir (click en botónes).
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
            changeBranch = new ChangeBranch(mainPage, true);
            
            // Se ubica el nombre de la sucursal.
            mainPage.lblSucursalNameCandySell.setText(changeBranch.getId_Sucursal());
            
            changeBranch.dispose();
            
        }
        
        // Agregar golosinas
        else if(evt.getSource() == mainPage.btnAddCandySell){
            
            // Si no se ha seleccionado alguna golosina a agregar.
            if(mainPage.cmbCandySelection.getSelectedIndex() == 0)
                // Se muestra un mensaje de que la venta fue generada con éxito.
                popup = new PopupMessage(mainPage, true,
                                         1, "Ingrese alguna cantidad de golosinas.");
            
            // Si no se ha indicado una cantidad de golosina a agregar.
            else if((int) mainPage.spnCantCandySell.getValue() == 0)
                // Se muestra un mensaje de que la venta fue generada con éxito.
                popup = new PopupMessage(mainPage, true,
                                         1, "Ingrese alguna cantidad de golosinas.");
            
            // Si se seleccionó una golosina y se indicó la cantidad a agregar.
            else{
                
                // Se debe restructurar esta sección con métodos y datos obtenidos de la BD
                
                String id = "";
                int cant = (int) mainPage.spnCantCandySell.getValue();
                char type_Ticket = '1', estatus = '1';
                double mount = ((int) (Math.random() * 5) + 1) * 2500;
                
                String id_candies = mainPage.cmbCandySelection.getSelectedItem().toString();
                
                Ticket_Candy ticket_candy = new Ticket_Candy(id, type_Ticket, estatus, id_candies, cant);
                
                Candy candy = new Candy(id, id_candies, id, 99, mount, estatus);
                                
                candy_list.add(ticket_candy);
                candies_list.add(candy);
                
                mainPage.cmbCandySelection.setSelectedIndex(0);
                mainPage.spnCantCandySell.setValue((int) 0);
                                                         
                showCandiesOnTicket(names_list, cants_list, amounts_list);
                                
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
            
            // Se configura el JFileChooser para que solo obtenga la ruta donde se desea guardar los archivos.
            FileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
            
            // Se crea una variable para mostrar el JFileChooser
            int option = FileChooser.showSaveDialog(mainPage);
            
            // Cuando se aprueba la ubicación, se obtiene la ruta de guardado
            if(option == javax.swing.JFileChooser.APPROVE_OPTION){
                String path = FileChooser.getSelectedFile().getPath();
                         
            path += "/0001"; // -> Colocar el id del ticket o factura.
                
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
                            path,
                            (int) java.lang.Math.random() * 5000,
                            names_list, cants_list);
                    
                    // Valores de prueba (Se debe borrar y sustituir por valores de la BD
                    
                    enterprise_data.add("J-31476980");
                    enterprise_data.add("CINES DE VENEZUELA, C.A.");
                    enterprise_data.add("AV. YATUSABE CON AV. WATAGATAPITUSBERRY");
                    enterprise_data.add("TOSCANA, ITALIA");
                    enterprise_data.add("TELEFONO: 02512611243");
                    enterprise_data.add("Correo: cinesdevenezuela@gmail.com");
                    
                    seller_list.add("Vendedor: " + 
                                    mainPage.cmbCandySeller.getSelectedItem().toString());
                    seller_list.add("C.I./R.I.F. : v-7559054");
                    
                    client_data.add("Cliente: Analiza Meltrozo");
                    client_data.add("C.I./R.I.F. : v-" + 
                                    mainPage.txtIdClientCandySell.getText());
                    client_data.add("Dirc: urb. Pandemonium");
                    client_data.add("Tlf: 04149561231");
                    
                    id_tickets.add(String.valueOf((int) java.lang.Math.random() * 5000));
                    
                    
                    
                    g.pdfInvoice(   enterprise_data, 
                                    seller_list, 
                                    client_data, 
                                    id_tickets, 
                                    '1', String.valueOf((int) java.lang.Math.random() * 5000), 
                                    names_list, 
                                    cants_list, 
                                    amounts_list, 
                                    path);
                    
                    // Se muestra un mensaje de que la venta fue generada con éxito.
                    popup = new PopupMessage(mainPage, true,
                                             4, "La venta se ha realizado exitosamente");
                    
                    
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
    public void showCandiesOnTicket(ArrayList<String> names, ArrayList<Integer> cants,
                                    ArrayList<Double> amounts){
        
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
        amounts.clear();        
                
        for (int i = 0; i < candy_list.size(); i++){
            
            // Se inicializa el índice 'j'
            j = 0;
            
            // Se busca el precio del producto
            while(!candies_list.get(j).getName().equals(candy_list.get(i).getId_candies()))
                j++;
            
            double price = suport.numberDecimalFormat(candies_list.get(j).getPrice(), 2);
            int cant = candy_list.get(i).getCant();
            
            // Se dan valores a los elementos de la matriz
            matriz_candy[i][0] = candy_list.get(i).getId_candies();
            matriz_candy[i][1] = String.valueOf(cant);
            matriz_candy[i][2] = String.valueOf(price);
            matriz_candy[i][3] = String.valueOf(suport.numberDecimalFormat(price * 0.16, 2));
            matriz_candy[i][4] = String.valueOf(suport.numberDecimalFormat(price * 1.16, 2));
            matriz_candy[i][5] = String.valueOf(suport.numberDecimalFormat(price * 1.16 * cant, 2));
            matriz_candy[i][6] = "Botón eliminar";
            
            // Los acumuladores son llenados
            acum_Sub    += suport.numberDecimalFormat(price * cant, 2);
            acum_IVA    += suport.numberDecimalFormat(price * cant * 0.16, 2);
            acum_Total  += suport.numberDecimalFormat(price * 1.16 * cant, 2);
            
            // Los arrays son llenados
            names.add(candy_list.get(i).getId_candies());
            cants.add(cant);
            amounts.add(suport.numberDecimalFormat(price * 1.16, 2));
                                        
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
