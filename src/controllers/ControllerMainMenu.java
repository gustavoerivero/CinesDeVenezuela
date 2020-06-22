
package controllers;

// Se importan las views que se van a utilizar
import views.*;
import views.tables.Table;

// Se importan los models que se van a utilizar
import models.database.ConnectionDB;
import models.Employee;


// Se importan las clases de soporte a utilizar
import lib.SuportFunctions;
import lib.PDFGenerator;
import lib.TheaterSeatingChart;

// Se importan las librerías a utilizar
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import models.database.*;


/**
 *
 * @author Gustavo
 */
public class ControllerMainMenu implements ActionListener, MouseListener{
    
    // Instanciar las clases necesarias para el funcionamiento.
                
        // Models
        private ConnectionDB con;
        private EmployeeCRUD empC;
        

        
        // Controllers
        private ControllerLogin ctrlLogin;
        
        // Views
        private MainPage mainPage;
        private PopupMessage popup;
        private SelectOption select;
        private ChangeBranch changeBranch;
        private ModifyCandy modifyCandy;
        private RegisterModify registerModify;
        
        // Suport Class
        private SuportFunctions suport;
        
        // Theater Seating Chart
        private TheaterSeatingChart seatingChart;
        
        
        //tablets
        
                
    // Instanciar las variables necesarias para el funcionamiento.    
    ArrayList<String> enterprise_data = new ArrayList<String>();
    ArrayList<String> seller_list = new ArrayList<String>();
    ArrayList<String> client_data = new ArrayList<String>();
    
    ArrayList<String> id_tickets = new ArrayList<String>();

    ArrayList<Object> objectList = new ArrayList<Object>();
    
    
    ArrayList<Integer> cantCinemaTickets = new ArrayList<Integer>();
    
    
    // Constructor
    public ControllerMainMenu(){
        
        // Declarar la variable de las clases instanciadas.
        mainPage        = new MainPage();
        suport          = new SuportFunctions();
        seatingChart    = new TheaterSeatingChart();
        
        empC = new EmployeeCRUD();
        
        // Activamos los eventos por las views.
        mainPage.addEvents(this);
        mainPage.addMouseEvents(this);
        this.CargarEmpleados();
        
        //se carga la lista de empleados, no es lo mas practico pero lo hace !
        
  
    }
    
    
    
    //Autor Luis David
    //<editor-fold defaultstate="collapsed" desc=" METODO PARA EL BOTON EMPLEADO ">
         
        
    //<editor-fold defaultstate="collapsed" desc=" Cargar Tabla dE EMPLEADO Funcional">
      private void CargarEmpleados()
    
      {  
          ResultSet resu;
        try {
            DefaultTableModel TablaEmployee = (DefaultTableModel) mainPage.tblEmployee.getModel();
            resu = empC.listaEmployee();
            ResultSetMetaData rMd = resu.getMetaData();
            int cantcolumnas = rMd.getColumnCount();
            

            while(resu.next()){
                Object[] filas = new Object[cantcolumnas];
                    for (int i = 0; i < cantcolumnas ; i++) 
                    {
                        filas[i] = resu.getObject(i+1);
                    }
                    TablaEmployee.addRow(filas);
            }
        } catch (Exception e) {
        }
        
    }
      
      
       //</editor-fold>
      
    //<editor-fold defaultstate="collapsed" desc=" Cargar Tabla V01 Anterior">
   /* private void CargarTabla2()
    
      {  
        DefaultTableModel tablet = (DefaultTableModel) mainPage.getTblEmployee().getModel();
        lista2 = empC.lista2();
        int total = lista2.size();
        
        for (int i = 0; i < total ; i++) {
            
            tablet.setValueAt(lista2.get(i).getId(), i, 0);
            tablet.setValueAt(lista2.get(i).getPosition_id(), i, 1);
            tablet.setValueAt(lista2.get(i).getBranch_id(), i, 2);
            tablet.setValueAt(lista2.get(i).getName(), i, 3);
            tablet.setValueAt(lista2.get(i).getSurname(), i, 4);
            tablet.setValueAt(lista2.get(i).getPhone(), i, 5);
            tablet.setValueAt(lista2.get(i).getDirection(), i, 6);
            tablet.setValueAt(lista2.get(i).getBirth_date(), i, 7);
            tablet.setValueAt(lista2.get(i).getAdmission_date(), i, 8);
            tablet.setValueAt(lista2.get(i).getEmail(), i, 9);
            tablet.setValueAt(lista2.get(i).getEstatus(), i, 10);
          
            tablet.addRow(new Object[]{"","","","","","","",});
    }
        }*/
       
        //</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc=" Cargar Tabla V02 Anterior">
       //metodo para empleado
      /* {  
        DefaultTableModel tablet = (DefaultTableModel) mainPage.tblEmployee.getModel();
        
        
        lista2 = empC.lista2(emp);
        int total = lista2.size();
        for (int i = 0; i < total ; i++) {
            
            tablet.setValueAt(lista2.get(i).getId(), i, 1);
            tablet.setValueAt(lista2.get(i).getPosition_id(), i, 2);
            tablet.setValueAt(lista2.get(i).getBranch_id(), i, 3);
            tablet.setValueAt(lista2.get(i).getName(), i, 4);
            tablet.setValueAt(lista2.get(i).getSurname(), i, 5);
            tablet.setValueAt(lista2.get(i).getPhone(), i, 6);
            tablet.setValueAt(lista2.get(i).getDirection(), i, 7);
            tablet.setValueAt(lista2.get(i).getBirth_date(), i, 8);
            tablet.setValueAt(lista2.get(i).getAdmission_date(), i, 9);
            tablet.setValueAt(lista2.get(i).getEmail(), i, 10);
            tablet.setValueAt(lista2.get(i).getEstatus(), i, 11);
          
            tablet.addRow(new Object[]{"","","","","","","","","","",""});            
        }
    }*/
       //</editor-fold>


    //</editor-fold>
    

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
            //this.CargarEmpleados();
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
            this.CargarEmpleados();
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
                
                DefaultTableModel dtm = (DefaultTableModel) mainPage.tblCandy.getModel();
                
                String id = "";
                int cant = (int) mainPage.spnCantCandySell.getValue();
                char type_Ticket = '1', estatus = '1';
                double mount = ((int) (Math.random() * 5) + 1) * 2500;
                
                String id_candies = mainPage.cmbCandySelection.getSelectedItem().toString();
                
                // Se verifica que el dulce seleccionado no esté en la tabla.
                
                // Se declara y se inicializa índice.
                int index = 0;
                
                // Se declara y se inicializa la variable validadora.
                boolean val = true;
                
                // Se recorre la tabla verificando que la golosina ya no haya sido agregada.
                while(index < dtm.getRowCount() && val == true){
                    if (id_candies != dtm.getValueAt(index, 0))
                        index++;
                    else
                        val = false;
                }
                
                // Si la golosina no ha sido agregada:
                if(val == true){
                    
                    // Se restauran los valores iniciales.
                    mainPage.cmbCandySelection.setSelectedIndex(0);
                    mainPage.spnCantCandySell.setValue((int) 0);
                        
                    /*Ticket_Candy ticket_candy = new Ticket_Candy(id, type_Ticket, estatus, 
                                                                 id_candies, cant);
                
                    Candy candy = new Candy(id, id_candies, id, 99, mount, estatus);*/
                        
                    addCandies(id_candies, cant, mount); // -> Añade el registro.
                    showCandyAmounts();                  // -> Se muestran los montos.
                    
                }
                
                // Si la golosina ya fue agregada.
                else{
                    
                    popup = new PopupMessage(mainPage, true, 1, "Ya la golosina ha sido ingresada.");
                                        
                }
                                            
            }
            
        }
        
        // Retornar los valores iniciales
        else if(evt.getSource() == mainPage.btnCandySellClear){
                        
            // Aplicar método que retorna los componentes a sus valores iniciales
            mainPage.clearCandySell();
            
        }
        
        // Realizar la venta de golosinas
        else if(evt.getSource() == mainPage.btnCandySell){
            
            DefaultTableModel dtm = (DefaultTableModel) mainPage.tblCandy.getModel();
            
            /**
             * Se verifica que estén todos los datos.
             *  Se verifica:
             *  - txtIdClientCandySell:      Que no esté vacío ni valor predeterminado.
             *  - lblSucursalnameCandySell:  Que no esté vacío ni valor predeterminado.
             *  - cmbCandySeller:            Que no esté en el valor predeterminado.
             *  - getRowCount():             Que se haya ingresado al menos una golosina.
             */
            if((!"".equals(mainPage.txtIdClientCandySell.getText()) || 
                !"Cédula del cliente".equals(mainPage.txtIdClientCandySell.getText())) && 
               (!"".equals(mainPage.lblSucursalNameCandySell.getText()) || 
                !"Sucursal".equals(mainPage.lblSucursalNameCandySell.getText())) &&
                mainPage.cmbCandySeller.getSelectedIndex() != 0 && dtm.getRowCount() > 0){                             
                
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
                       
                        ArrayList<String>   names = new ArrayList<String>();
                        ArrayList<Integer>  cants = new ArrayList<Integer>();
                        ArrayList<Double> amounts = new ArrayList<Double>();
                    
                        for (int i = 0; i < dtm.getRowCount(); i++){
                            names.add(dtm.getValueAt(i, 0).toString());
                            cants.add(Integer.valueOf(dtm.getValueAt(i, 1).toString()));
                            amounts.add(Double.valueOf(dtm.getValueAt(i, 4).toString()));
                        }
                    
                        /* 
                         * Se llama el método generador de ticket para golosinas pasándole
                         * los parámetros correspondientes.
                         */
                        g.pdfCandyTicket(mainPage.txtIdClientCandySell.getText(),
                                mainPage.cmbCandySeller.getSelectedItem().toString(),
                                "Sucursal XYZ", path, (int) java.lang.Math.random() * 5000 + 1,
                                names, cants);
                    
                        // Valores de prueba (Se debe borrar y sustituir por valores de la BD)
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
                    
                        id_tickets.add(String.valueOf((int) java.lang.Math.random() * 5000) + 1);
                                    
                        /* 
                         * Se llama el método generador de factura para golosinas pasándole
                         * los parámetros correspondientes.
                         */
                        g.pdfInvoice(   enterprise_data, 
                                        seller_list, 
                                        client_data, 
                                        id_tickets, 
                                        '1', String.valueOf((int) java.lang.Math.random() * 5000 + 1), 
                                        names, 
                                        cants, 
                                        amounts, 
                                        path);
                    
                        // Se muestra un mensaje de que la venta fue generada con éxito.
                        popup = new PopupMessage(mainPage, true, 4, 
                                "La venta se ha realizado exitosamente");
                    
                        // Aplicar método que retorna los componentes a sus valores iniciales
                        mainPage.clearCandySell();
                    
                    } 
                    
                    catch (Exception e) {
                        // De producirse un error, se muestra en consola.
                        System.out.print("Error: " + e);
                    }
                
                }
                
            }
            
            // En caso de que falten datos por ingresar.
            else{
                // Se muestra mensaje de error.
                popup = new PopupMessage(mainPage, true, 1, "Faltan datos por ingresar.");
                
            }
                           
        }
        
        //</editor-fold>
        
        // Tickets de funciones
        else if(evt.getSource() == mainPage.btnCinemaDecision){
            mainPage.panCapsuleCinemaDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
        
            suport.cardSelection(mainPage.panOption2, mainPage.panCinemaSell);
            
            suport.cardSelection(mainPage.panStepsCinemaTickets, mainPage.panFirstStepCinemaTickets);
            
            mainPage.clearMovieTable(mainPage.tblMovieSelector);
            
            mainPage.clearFunctionSelectorTable(mainPage.tblFunctionSelector);
            
            showMovies();
            
        }
        
        //<editor-fold defaultstate="collapsed" desc=" Venta de tickets para funciones ">
        
        // Volver para la sección anterior
        else if(evt.getSource() == mainPage.btnBackToTicketDecision2){
            mainPage.btnBackToTicketDecision2.setBackground(new java.awt.Color(249,249,249));
                        
            suport.cardSelection(mainPage.panOption2, mainPage.panDecisionOption2);
            
            
        }
        
        // Cambiar de sucursal a gestionar
        else if(evt.getSource() == mainPage.btnChangeSucursalCinemaTickets){
            
            // Instanciar la clase
            changeBranch = new ChangeBranch(mainPage, true);
            
            // Se ubica el nombre de la sucursal.
            mainPage.lblSucursalNameCinemaTickets.setText(changeBranch.getId_Sucursal());
            
            // Se cierra el JDialog de cambio de sucursal.
            changeBranch.dispose();
            
        }
        
        // Volver al primer paso de compra de boletos.
        else if(evt.getSource() == mainPage.btnBackToSelectorMovie){
            
            // Declarar e iniciar la variable acumuladora.
            int cant = 0;
            
            // Acumular las entradas seleccionadas para la compra.
            for(int i = 0; i < cantCinemaTickets.size(); i++)
                cant += cantCinemaTickets.get(i);
            
            // Si la cantidad de tickets seleccionados es mayor a '0'
            if(cant > 0){
                select = new SelectOption(mainPage, true, 2, 
                        "¿Está seguro que desea volver a la opción anterior?", 
                        "Si", "No");
            
                // Si la respuesta es afirmativa.
                if(select.getOpc()){

                    // Se muestra el paso anterior para compra de boletos.
                    suport.cardSelection(mainPage.panStepsCinemaTickets, 
                            mainPage.panFirstStepCinemaTickets);

                    /*
                     * Método para retornar los valores gráficos de los botones de 
                     * la compra de tickets para funciones.
                     */
                    mainPage.clearButtonsOfTheBuyCinemaTickets();

                    // Se vacían los tickets seleccionados.
                    clearCantsCinemaTickets();
                    
                    // Se cancela la indeterminación de la barra de progreso.
                    mainPage.pgrCinemaTickets.setIndeterminate(false);

                    // Se devuelve el valor de la barra de progreso a '0'
                    mainPage.pgrCinemaTickets.setValue(0);

                }
            
            }
            
            // Caso contrario
            else {
                
                // Se muestra el paso anterior para compra de boletos.
                suport.cardSelection(mainPage.panStepsCinemaTickets, 
                        mainPage.panFirstStepCinemaTickets);

                /*
                 * Método para retornar los valores gráficos de los botones de 
                 * la compra de tickets para funciones.
                 */
                mainPage.clearButtonsOfTheBuyCinemaTickets();

                // Se vacían los tickets seleccionados.
                clearCantsCinemaTickets();
                    
                // Se cancela la indeterminación de la barra de progreso.
                mainPage.pgrCinemaTickets.setIndeterminate(false);

                // Se devuelve el valor de la barra de progreso a '0'
                mainPage.pgrCinemaTickets.setValue(0);
                
            }
        }
        
        // Pasar al siguiente paso de compra de boletos.
        else if(evt.getSource() == mainPage.btnNextStepBuyTicket){
            
            // Declarar e iniciar la variable acumuladora.
            int cant = 0;
            
            // Acumular las entradas seleccionadas para la compra.
            for(int i = 0; i < cantCinemaTickets.size(); i++)
                cant += cantCinemaTickets.get(i);
            
            // Si la cantidad de boletos a comprar es mayor a '0'.
            if(cant > 0){
            
                // Se muestra el siguiente paso para compra de boletos.
                suport.cardSelection(mainPage.panStepsCinemaTickets, 
                        mainPage.panThirdStepCinemaTickets);
                
                /*
                 * Método para retornar los valores gráficos de los botones de 
                 * la compra de tickets para funciones.
                 */
                mainPage.clearButtonsOfTheBuyCinemaTickets();

                // Se cancela la indeterminación de la barra de progreso.
                mainPage.pgrCinemaTickets.setIndeterminate(false);

                // Se devuelve el valor de la barra de progreso a '0'
                mainPage.pgrCinemaTickets.setValue(50);
                
                // Se indican los iconos a utilizar
                javax.swing.Icon free = new javax.swing.ImageIcon(getClass().getResource(
                        "/views/images/freeSeat.png"));
                javax.swing.Icon selected = new javax.swing.ImageIcon(getClass().getResource(
                        "/views/images/selectedSeat.png"));
                
                // Método para mostrar los asientos disponibles
                seatingChart.buildCinemaSeats(8, 8, mainPage.panSelectorSeats, 
                        mainPage.panTheaterSeatChart, free, selected, 
                        mainPage.lblTotalSeatsCant, mainPage.lblFreeSeatsCant, 
                        mainPage.lblSelectedSeatsCant);
                                
            }
            
            else{
                
                // Mensaje para indicar que se debe indicar al menos un ticket a comprar.
                popup = new PopupMessage(mainPage, true, 1, "Debe indicar al menos un ticket.");
                
            }
        }
        
        //<editor-fold defaultstate="collapsed" desc=" Aumentar/Disminuir tickets para adultos ">
        
        // Aumentar la cantidad de tickets para adultos.
        else if(evt.getSource() == mainPage.btnAddCinemaTickets1){
            
            // Si la barra de progreso ya está cargando.
            if(mainPage.pgrCinemaTickets.isIndeterminate()){}
            else // Caso contrario.
                mainPage.pgrCinemaTickets.setIndeterminate(true);
            
            // Se declara y se inicia la variable acumuladora.
            int cant = Integer.valueOf(mainPage.lblCantCinemaTickets1.getText());
                
            // Si la cantidad es mayor a 'x', se muestra mensaje de error.
            if(cant >= 99)
                popup = new PopupMessage(mainPage, true, 1, 
                        "Ha ingresado una cantidad muy alta de tickets.");
            
            // De lo contrario, se muestra la cantidad de tickets seleccionados.
            else{
                
                // Se aumenta el contador.
                cant++;
                
                // Se muestra la cantidad de tickets seleccionados.
                mainPage.lblCantCinemaTickets1.setText(String.valueOf(cant));
                //mainPage.lblCantCinemaTickets1.repaint();
                
                // Se agrega a la lista de tickets la cantidad seleccionada.
                cantCinemaTickets.set(0, cant);
                
                // Se actualizan los montos.
                showAmountsOfCinemaTickets();
                
            }
            
        }
        
        // Disminuir la cantidad de tickets para adultos.
        else if (evt.getSource() == mainPage.btnMinusCinemaTickets1){
            
            // Si la barra de progreso ya está cargando.
            if(mainPage.pgrCinemaTickets.isIndeterminate()){}
            else // Caso contrario.
                mainPage.pgrCinemaTickets.setIndeterminate(true);
            
            // Se declara y se inicia la variable acumuladora.
            int cant = Integer.valueOf(mainPage.lblCantCinemaTickets1.getText());
                        
            // Si la cantidad es menor o igual a '0', se muestra mensaje de error.
            if(cant <= 0)
                popup = new PopupMessage(mainPage, true, 1, 
                        "No puede ingresar una cantidad negativa de tickets.");
            
            // De lo contrario, se muestra la cantidad de tickets seleccionados.
            else{
                
                // Declarar e iniciar variable acumuladora
                int c = 0;
                
                // Acumular la cantidad de tickets.
                for(int i = 0; i < cantCinemaTickets.size(); i++)
                    c += cantCinemaTickets.get(i);
                
                // Si no hay tickets, se desactiva la barra de progreso.
                if(c == 0)
                    mainPage.pgrCinemaTickets.setIndeterminate(false);
                
                // Se disminuye el contador.
                cant--;
                
                // Se muestra la cantidad de tickets seleccionados.
                mainPage.lblCantCinemaTickets1.setText(String.valueOf(cant));
                
                // Se agrega a la lista de tickets la cantidad seleccionada.
                cantCinemaTickets.set(0, cant);
                
                // Se actualizan los montos.
                showAmountsOfCinemaTickets();
                
            }
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Aumentar/Disminuir tickets para kinder ">
        
        // Aumentar la cantidad de tickets para adultos.
        else if(evt.getSource() == mainPage.btnAddCinemaTickets2){
            
            // Si la barra de progreso ya está cargando.
            if(mainPage.pgrCinemaTickets.isIndeterminate()){}
            else // Caso contrario.
                mainPage.pgrCinemaTickets.setIndeterminate(true);
            
            // Se declara y se inicia la variable acumuladora.
            int cant = Integer.valueOf(mainPage.lblCantCinemaTickets2.getText());
                
            // Si la cantidad es mayor a 'x', se muestra mensaje de error.
            if(cant >= 99)
                popup = new PopupMessage(mainPage, true, 1, 
                        "Ha ingresado una cantidad muy alta de tickets.");
            
            // De lo contrario, se muestra la cantidad de tickets seleccionados.
            else{
                
                // Se aumenta el contador.
                cant++;
                
                // Se muestra la cantidad de tickets seleccionados.
                mainPage.lblCantCinemaTickets2.setText(String.valueOf(cant));
                //mainPage.lblCantCinemaTickets1.repaint();
                
                // Se agrega a la lista de tickets la cantidad seleccionada.
                cantCinemaTickets.set(1, cant);
                
                // Se actualizan los montos.
                showAmountsOfCinemaTickets();
                
            }
            
        }
        
        // Disminuir la cantidad de tickets para adultos.
        else if (evt.getSource() == mainPage.btnMinusCinemaTickets2){
            
            // Si la barra de progreso ya está cargando.
            if(mainPage.pgrCinemaTickets.isIndeterminate()){}
            else // Caso contrario.
                mainPage.pgrCinemaTickets.setIndeterminate(true);
            
            // Se declara y se inicia la variable acumuladora.
            int cant = Integer.valueOf(mainPage.lblCantCinemaTickets2.getText());
                        
            // Si la cantidad es menor o igual a '0', se muestra mensaje de error.
            if(cant <= 0)
                popup = new PopupMessage(mainPage, true, 1, 
                        "No puede ingresar una cantidad negativa de tickets.");
            
            // De lo contrario, se muestra la cantidad de tickets seleccionados.
            else{
                
                // Declarar e iniciar variable acumuladora
                int c = 0;
                
                // Acumular la cantidad de tickets.
                for(int i = 0; i < cantCinemaTickets.size(); i++)
                    c += cantCinemaTickets.get(i);
                
                // Si no hay tickets, se desactiva la barra de progreso.
                if(c == 0)
                    mainPage.pgrCinemaTickets.setIndeterminate(false);
                
                // Se disminuye el contador.
                cant--;
                
                // Se muestra la cantidad de tickets seleccionados.
                mainPage.lblCantCinemaTickets2.setText(String.valueOf(cant));
                
                // Se agrega a la lista de tickets la cantidad seleccionada.
                cantCinemaTickets.set(1, cant);
                
                // Se actualizan los montos.
                showAmountsOfCinemaTickets();
                
            }
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Aumentar/Disminuir tickets para niños ">
        
        // Aumentar la cantidad de tickets para adultos.
        else if(evt.getSource() == mainPage.btnAddCinemaTickets3){
            
            // Si la barra de progreso ya está cargando.
            if(mainPage.pgrCinemaTickets.isIndeterminate()){}
            else // Caso contrario.
                mainPage.pgrCinemaTickets.setIndeterminate(true);
            
            // Se declara y se inicia la variable acumuladora.
            int cant = Integer.valueOf(mainPage.lblCantCinemaTickets3.getText());
                
            // Si la cantidad es mayor a 'x', se muestra mensaje de error.
            if(cant >= 99)
                popup = new PopupMessage(mainPage, true, 1, 
                        "Ha ingresado una cantidad muy alta de tickets.");
            
            // De lo contrario, se muestra la cantidad de tickets seleccionados.
            else{
                
                // Se aumenta el contador.
                cant++;
                
                // Se muestra la cantidad de tickets seleccionados.
                mainPage.lblCantCinemaTickets3.setText(String.valueOf(cant));
                //mainPage.lblCantCinemaTickets1.repaint();
                
                // Se agrega a la lista de tickets la cantidad seleccionada.
                cantCinemaTickets.set(2, cant);
                
                // Se actualizan los montos.
                showAmountsOfCinemaTickets();
                
            }
            
        }
        
        // Disminuir la cantidad de tickets para adultos.
        else if (evt.getSource() == mainPage.btnMinusCinemaTickets3){
            
            // Si la barra de progreso ya está cargando.
            if(mainPage.pgrCinemaTickets.isIndeterminate()){}
            else // Caso contrario.
                mainPage.pgrCinemaTickets.setIndeterminate(true);
            
            // Se declara y se inicia la variable acumuladora.
            int cant = Integer.valueOf(mainPage.lblCantCinemaTickets3.getText());
                        
            // Si la cantidad es menor o igual a '0', se muestra mensaje de error.
            if(cant <= 0)
                popup = new PopupMessage(mainPage, true, 1, 
                        "No puede ingresar una cantidad negativa de tickets.");
            
            // De lo contrario, se muestra la cantidad de tickets seleccionados.
            else{
                
                // Declarar e iniciar variable acumuladora
                int c = 0;
                
                // Acumular la cantidad de tickets.
                for(int i = 0; i < cantCinemaTickets.size(); i++)
                    c += cantCinemaTickets.get(i);
                
                // Si no hay tickets, se desactiva la barra de progreso.
                if(c == 0)
                    mainPage.pgrCinemaTickets.setIndeterminate(false);
                
                // Se disminuye el contador.
                cant--;
                
                // Se muestra la cantidad de tickets seleccionados.
                mainPage.lblCantCinemaTickets3.setText(String.valueOf(cant));
                
                // Se agrega a la lista de tickets la cantidad seleccionada.
                cantCinemaTickets.set(2, cant);
                
                // Se actualizan los montos.
                showAmountsOfCinemaTickets();
                
            }
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Aumentar/Disminuir tickets para adultos mayores ">
        
        // Aumentar la cantidad de tickets para adultos.
        else if(evt.getSource() == mainPage.btnAddCinemaTickets4){
            
            // Si la barra de progreso ya está cargando.
            if(mainPage.pgrCinemaTickets.isIndeterminate()){}
            else // Caso contrario.
                mainPage.pgrCinemaTickets.setIndeterminate(true);
            
            // Se declara y se inicia la variable acumuladora.
            int cant = Integer.valueOf(mainPage.lblCantCinemaTickets4.getText());
                
            // Si la cantidad es mayor a 'x', se muestra mensaje de error.
            if(cant >= 99)
                popup = new PopupMessage(mainPage, true, 1, 
                        "Ha ingresado una cantidad muy alta de tickets.");
            
            // De lo contrario, se muestra la cantidad de tickets seleccionados.
            else{
                
                // Se aumenta el contador.
                cant++;
                
                // Se muestra la cantidad de tickets seleccionados.
                mainPage.lblCantCinemaTickets4.setText(String.valueOf(cant));
                //mainPage.lblCantCinemaTickets1.repaint();
                
                // Se agrega a la lista de tickets la cantidad seleccionada.
                cantCinemaTickets.set(3, cant);
                
                // Se actualizan los montos.
                showAmountsOfCinemaTickets();
                
            }
            
        }
        
        // Disminuir la cantidad de tickets para adultos.
        else if (evt.getSource() == mainPage.btnMinusCinemaTickets4){
            
            // Si la barra de progreso ya está cargando.
            if(mainPage.pgrCinemaTickets.isIndeterminate()){}
            else // Caso contrario.
                mainPage.pgrCinemaTickets.setIndeterminate(true);
            
            // Se declara y se inicia la variable acumuladora.
            int cant = Integer.valueOf(mainPage.lblCantCinemaTickets4.getText());
                        
            // Si la cantidad es menor o igual a '0', se muestra mensaje de error.
            if(cant <= 0)
                popup = new PopupMessage(mainPage, true, 1, 
                        "No puede ingresar una cantidad negativa de tickets.");
            
            // De lo contrario, se muestra la cantidad de tickets seleccionados.
            else{
                
                // Declarar e iniciar variable acumuladora
                int c = 0;
                
                // Acumular la cantidad de tickets.
                for(int i = 0; i < cantCinemaTickets.size(); i++)
                    c += cantCinemaTickets.get(i);
                
                // Si no hay tickets, se desactiva la barra de progreso.
                if(c == 0)
                    mainPage.pgrCinemaTickets.setIndeterminate(false);
                
                // Se disminuye el contador.
                cant--;
                
                // Se muestra la cantidad de tickets seleccionados.
                mainPage.lblCantCinemaTickets4.setText(String.valueOf(cant));
                
                // Se agrega a la lista de tickets la cantidad seleccionada.
                cantCinemaTickets.set(3, cant);
                
                // Se actualizan los montos.
                showAmountsOfCinemaTickets();
                
            }
            
        }
        
        //</editor-fold>
        
        //</editor-fold>
        
        //</editor-fold>
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Botones del MainPage Option 4 ">
  
        
        //<editor-fold defaultstate="collapsed" desc=" Boton Añadir Empleado ">
                
            // Añadir Empleado
            else if(evt.getSource() == mainPage.btnAddEmployee){
            mainPage.panAddEmployee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            
           
            // Instanciar la clase
            registerModify = new RegisterModify();
            registerModify.setVisible(true);
            suport.cardSelection(registerModify.panData, registerModify.panDataEmployee);
            suport.cardSelection(registerModify.panButtonsModifyRegister, registerModify.panButton);
            
            
            //mainPage.dispose();
               
        }
        
        //</editor-fold>
        
        //</editor-fold>
        
        
    }
    
    /**
     * Eventos provocados por el escuchador de Mouse (MouseListener)
     * @param evt son aquellos eventos que ocurren con acciones del Mouse.
     */
    @Override
    public void mouseClicked(MouseEvent evt) {
        
        //<editor-fold defaultstate="collapsed" desc=" Tabla de Golosinas ">
        
        // Si el evento ocurre en la tabla de golosinas.
        if(evt.getSource() == mainPage.tblCandy){
        
            // Se obtienen los valores de la fila y columna seleccionada.
            int column = mainPage.getColumnTable(), row = mainPage.getRowTable();

            // Se valida que el evento del Mouse fue provocado dentro del JTable.
            if(row < mainPage.tblCandy.getRowCount() && row >= 0 && 
                    column < mainPage.tblCandy.getColumnCount() && column >= 0){
                
                // Se obtiene el valor de la celda seleccionada.
                Object value = mainPage.tblCandy.getValueAt(row, column);
                
                // Si el valor de la celda seleccionada es un JButton;
                if(value instanceof JButton){
                    
                    ((JButton)value).doClick();
                    
                    JButton btn = (JButton) value;

                    // Si el JButton se llama "m";
                    if(btn.getName().equals("m")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton modificar en la celda: " + row + ";" + column);
                                      
                        // Se obtiene el modelo de la JTable.
                        DefaultTableModel dtm = (DefaultTableModel) mainPage.tblCandy.getModel();
                                                
                        // Se obtienen los valores del producto.
                        String name     = dtm.getValueAt(row, 0).toString();
                        String desc     = "Acá iría la descripción del producto " + name;
                        double amount   = Double.valueOf(dtm.getValueAt(row, 2).toString());
                        
                        // Se instancia la clase para modificar el producto seleccionado.
                        modifyCandy = new ModifyCandy(mainPage, true, name, desc, amount);
                        
                        // Se modifica el producto: Cantidad.
                        dtm.setValueAt(String.valueOf(modifyCandy.getCant()), row, 1);
                        
                        // Se modifica el producto: Total
                        dtm.setValueAt(String.valueOf(modifyCandy.getBuy()), row, 5);
                        
                        // Se actualizan montos.
                        showCandyAmounts();
                        
                    }
                    
                    // Si el JButton se llama "e";
                    if(btn.getName().equals("e")){
                        
                        // Se imprime en consola en dónde se hizo click
                        System.out.println("Click en el boton eliminar en la celda: " + row + ";" + column);
                                                                                
                        // Se confirma que se desea eliminar el registro.
                        SelectOption select = new SelectOption(mainPage, true, 2, 
                                                "¿Desea eliminar este registro?", "Si", "No");
                        
                        // Si se confirma la eliminación.
                        if(select.getOpc()){
                            
                            // Se obtiene el modelo de la JTable.
                            DefaultTableModel dtm = (DefaultTableModel) mainPage.tblCandy.getModel();
                        
                            // Se remueve la fila seleccionada.
                            dtm.removeRow(row);
                            
                            // Se actualizan los montos.
                            showCandyAmounts();
                            
                        }
                        
                        // Se cierra el JDialog.
                        select.dispose();
                        
                    }
                }

            }

        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Tabla de Películas ">
        
        // Si el evento ocurre en la tabla de películas.
        else if (evt.getSource() == mainPage.tblMovieSelector){
            
            // Se obtienen los valores de la fila y columna seleccionada.
            int column = mainPage.getColumnTable(), row = mainPage.getRowTable();

            // Se valida que el evento del Mouse fue provocado dentro del JTable.
            if(row < mainPage.tblMovieSelector.getRowCount() && row >= 0 && 
                    column < mainPage.tblMovieSelector.getColumnCount() && column >= 0){
                
                // Se obtiene el valor de la celda seleccionada.
                Object value = mainPage.tblMovieSelector.getValueAt(row, column);
                
                // Si el valor de la celda seleccionada es un JButton;
                if(value instanceof JButton){
                    
                    ((JButton)value).doClick();
                    
                    JButton btn = (JButton) value;

                    // Si el JButton se llama "o";
                    if(btn.getName().equals("o")){
            
                        System.out.println("Click en el boton eliminar en la celda: " + row + ";" + column);
                        
                        DefaultTableModel dtm = (DefaultTableModel) mainPage.tblFunctionSelector.getModel();
                        
                        showFunctions(null);
                        
                        mainPage.pgrCinemaTickets.setIndeterminate(true);
                        
                    }
                }
            }
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Tabla de Funciones ">
        
        // Si el evento ocurre en la tabla de funciones.
        else if (evt.getSource() == mainPage.tblFunctionSelector){
            
            // Se obtienen los valores de la fila y columna seleccionada.
            int column = mainPage.getColumnTable(), row = mainPage.getRowTable();

            // Se valida que el evento del Mouse fue provocado dentro del JTable.
            if(row < mainPage.tblFunctionSelector.getRowCount() && row >= 0 && 
                    column < mainPage.tblFunctionSelector.getColumnCount() && column >= 0){
                
                // Se obtiene el valor de la celda seleccionada.
                Object value = mainPage.tblFunctionSelector.getValueAt(row, column);
                
                // Si el valor de la celda seleccionada es un JButton;
                if(value instanceof JButton){
                    
                    ((JButton)value).doClick();
                    
                    JButton btn = (JButton) value;

                    // Si el JButton se llama "o";
                    if(btn.getName().equals("o")){
            
                        System.out.println("Click en el boton eliminar en la celda: " + row + ";" + column);
                        
                        DefaultTableModel dtm = (DefaultTableModel) mainPage.tblFunctionSelector.getModel();
                                               
                        mainPage.pgrCinemaTickets.setIndeterminate(false);
                        
                        mainPage.pgrCinemaTickets.setValue(25);
                        
                        suport.cardSelection(mainPage.panStepsCinemaTickets, mainPage.panSecondStepCinemaTickets);
                        
                        /*
                         * Método para retornar los valores gráficos de los botones de 
                         * la compra de tickets para funciones.
                         */
                        mainPage.clearButtonsOfTheBuyCinemaTickets();
                        
                        for(int i = 0; i < 4; i++)
                            cantCinemaTickets.add(0);
                        
                    }
                }
            }
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" EMPLEADO">

        //<editor-fold defaultstate="collapsed" desc=" Seccion de Empleado ">
                
        // Añadir Empleado
        
         
   
        
        //</editor-fold>
        
        //</editor-fold>
        
        
    }
        
    //<editor-fold defaultstate="collapsed" desc=" Métodos para el funcionamiento del Controller ">
    
    /**
     * Método para añadir golosinas en una compra.
     * @param candyID id de la golosina comprada.
     * @param cant cantidad de las golosinas compradas
     * @param price precio (unidad) de las golosinas compradas
     */
    public void addCandies(String candyID, int cant, double price){
        
        // Se instancia la clase de apoyo Table
        Table table = new Table();
        
        // Se obtiene el modelo de la JTable.
        DefaultTableModel dtm = (DefaultTableModel) mainPage.tblCandy.getModel();
        
        // Se instancian y se crean las variables de tipo JButton.
        JButton btnModify = new JButton(), btnDelete = new JButton();
        
        // Se les da un formato a las variables JButton.
        table.addModifyButton(btnModify);
        table.addDeleteButton(btnDelete);
        
        // Variables para mostrar montos.
        double  iva     = suport.numberDecimalFormat(price * 0.16, 2),
                unidad  = suport.numberDecimalFormat(price * 1.16, 2),
                total   = suport.numberDecimalFormat(price * 1.16 * cant, 2);
            
        // Variables de tipo String, que serán utilizadas para mostrarse en la JTable.
        String  candyName   = candyID, // Sustituir por búsqueda de nombre en la BD.
                cantString  = String.valueOf(cant),
                priceString = String.valueOf(price),
                ivaString   = String.valueOf(iva),
                monto       = String.valueOf(unidad),
                totalString = String.valueOf(total);
        
        // Se añade una nueva fila con todos estos datos.
        dtm.addRow(new Object[]{candyName, cantString, priceString, ivaString,
                                monto, totalString, btnModify, btnDelete});
        
        // Se le da el nuevo formato a la tabla.
        mainPage.tblCandy.setModel(dtm);
        
    }
    
    /**
     * Método para mostrar los montos como 'Subtotal', 'IVA' y 'Total' que un 
     * cliente tiene que cancelar.
     */
    public void showCandyAmounts(){
        
        // Se obtiene el modelo de la JTable.
        DefaultTableModel dtm = (DefaultTableModel) mainPage.tblCandy.getModel();
             
        // Se crean las variables acumuladoras que mostrarán los montos correspondientes
        double acumSub = 0, acumIVA = 0, acumTotal = 0;
        
        // Ciclo 'for' para recorrer todas las filas de la tabla
        for (int i = 0; i < dtm.getRowCount(); i++){
            
            // Se obtienen los valores y se hacen los respectivos cálculos
            int     cant    = Integer.valueOf(dtm.getValueAt(i, 1).toString());
            double  price   = suport.numberDecimalFormat(Double.valueOf(
                                dtm.getValueAt(i,2).toString()) * cant, 2),
                    iva     = suport.numberDecimalFormat(price * 0.16, 2),
                    total   = suport.numberDecimalFormat(price * 1.16, 2);
            
            // Se llenan los acumuladores.
            acumSub     += price;
            acumIVA     += iva;
            acumTotal   += total;
            
        }
        
        // Se muestran en pantalla la información de los acumuladores
        mainPage.txtSubTotalCandy.setText(String.valueOf(acumSub));
        mainPage.txtIVACandy.setText(String.valueOf(acumIVA));
        mainPage.txtTotalCandy.setText(String.valueOf(acumTotal));
        
    }
    
    /**
     * Método que carga las películas correspondientes a una sucursal.
     */
    public void showMovies(){
        
        DefaultTableModel dtm = (DefaultTableModel) mainPage.tblMovieSelector.getModel();
        
        Table table = new Table();
             
        JLabel lbl = new JLabel();
                    
        lbl.setSize(100, 120);
            
        ImageIcon img   = new ImageIcon(getClass().getResource("/views/images/images.jpg"));
        
        ImageIcon icon  = new ImageIcon(img.getImage().getScaledInstance(
                lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
            
        lbl.setIcon(icon);
        
        JLabel lbl2 = new JLabel();
                    
        lbl2.setSize(100, 120);
            
        ImageIcon img2   = new ImageIcon(getClass().getResource("/views/images/images2.jpg"));
        
        ImageIcon icon2  = new ImageIcon(img2.getImage().getScaledInstance(
                lbl2.getWidth(), lbl2.getHeight(), Image.SCALE_DEFAULT));
            
        lbl2.setIcon(icon2);
        
        String  name        = "The Greatest Showman",
                synopsis    = "Un musical en un circo we.",
                gender      = "Musical",
                censorship  = "A";
            
        String  name2        = "Mulan",
                synopsis2    = "Reboot de Mulan.",
                gender2      = "Acción / Aventura",
                censorship2  = "A";
        
        JButton btn = new JButton();
                        
        table.addOkButton(btn);
                    
        dtm.addRow(new Object[]{
            lbl, 
            "<html><p align='left'>" + name + "</p></html>",
            "<html><p align='left'>" + synopsis + "</p></html>",
            "<html><p align='left'>" + gender + "</p></html>",
            "<html><p align='left'>" + censorship + "</p></html>",
            btn
        });
        
        dtm.addRow(new Object[]{
            lbl2, 
            "<html><p align='left'>" + name2 + "</p></html>",
            "<html><p align='left'>" + synopsis2 + "</p></html>",
            "<html><p align='left'>" + gender2 + "</p></html>",
            "<html><p align='left'>" + censorship2 + "</p></html>",
            btn
        });
        
    }
    
    /**
     * Método para mostrar las funciones correspondentes a una película.
     * @param idMovie Código de la película de la que se van a buscar sus funciones.
     */
    public void showFunctions(String idMovie){
        
        DefaultTableModel dtm = (DefaultTableModel) mainPage.tblFunctionSelector.getModel();
        
        Table table = new Table();
        
        JButton btn = new JButton();
                        
        table.addOkButton(btn);
        
        String  date        = "13/06/2020",
                cinemaRoom  = "D",
                hour        = "5:45 p.m.",
                seats       = "64",
                freeSeats   = "32";
        
        dtm.addRow(new Object[]{
            date,
            cinemaRoom,
            hour,
            seats,
            freeSeats,
            btn
        });
        
    }
    
    /**
     * Método utilizado para mostrar montos según la cantidad de tickets
     * seleccionados para la compra.
     */
    public void showAmountsOfCinemaTickets(){
        
        double price = 0, iva = 0, total = 0;
        
        int cantA = cantCinemaTickets.get(0),
            cantK = cantCinemaTickets.get(1),
            cantC = cantCinemaTickets.get(2),
            cantO = cantCinemaTickets.get(3);
        
        if(cantA >= 0){
            
            double adultPrice = suport.numberDecimalFormat(
                    Double.valueOf(mainPage.lblPriceTicketAdult.getText()), 2);
            
            double  aPrice  = suport.numberDecimalFormat(cantA * (adultPrice * 100 / 116), 2),
                    aIva    = suport.numberDecimalFormat(
                            (cantA * (adultPrice * 100 / 116)) * 0.16, 2),
                    aTotal  = suport.numberDecimalFormat((cantA * adultPrice), 2);
            
            price   += suport.numberDecimalFormat(aPrice, 2);
            iva     += suport.numberDecimalFormat(aIva, 2);
            total   += suport.numberDecimalFormat(aTotal, 2);
            
            mainPage.lblSubtotalAmountAdultTicket.setText(String.valueOf(aPrice));
            mainPage.lblIVAAmountAdultTicket.setText(String.valueOf(aIva));
            mainPage.lblTotalAmountAdultTicket.setText(String.valueOf(aTotal));
            
        }
        
        if(cantK >= 0){
            
            double kinderPrice = suport.numberDecimalFormat(
                    Double.valueOf(mainPage.lblPriceTicketKinder.getText()), 2);
            
            double  kPrice  = suport.numberDecimalFormat(cantK * (kinderPrice * 100 / 116), 2),
                    kIva    = suport.numberDecimalFormat(
                            (cantK * (kinderPrice * 100 / 116)) * 0.16, 2),
                    kTotal  = suport.numberDecimalFormat((cantK * kinderPrice), 2);
            
            price   += suport.numberDecimalFormat(kPrice, 2);
            iva     += suport.numberDecimalFormat(kIva, 2);
            total   += suport.numberDecimalFormat(kTotal, 2);
            
            mainPage.lblSubtotalAmountKinderTicket.setText(String.valueOf(kPrice));
            mainPage.lblIVAAmountKinderTicket.setText(String.valueOf(kIva));
            mainPage.lblTotalAmountKinderTicket.setText(String.valueOf(kTotal));
            
        }
        
        if(cantC >= 0){
            
            double childPrice = suport.numberDecimalFormat(
                    Double.valueOf(mainPage.lblPriceTicketChild.getText()), 2);
            
            double  cPrice  = suport.numberDecimalFormat(cantC * (childPrice * 100 / 116), 2),
                    cIva    = suport.numberDecimalFormat(
                            (cantC * (childPrice * 100 / 116)) * 0.16, 2),
                    cTotal  = suport.numberDecimalFormat((cantC * childPrice), 2);
            
            price   += suport.numberDecimalFormat(cPrice, 2);
            iva     += suport.numberDecimalFormat(cIva, 2);
            total   += suport.numberDecimalFormat(cTotal, 2);
            
            mainPage.lblSubtotalAmountChildTicket.setText(String.valueOf(cPrice));
            mainPage.lblIVAAmountChildTicket.setText(String.valueOf(cIva));
            mainPage.lblTotalAmountChildTicket.setText(String.valueOf(cTotal));
            
        }
        
        if(cantO >= 0){
            
            double oldPrice = suport.numberDecimalFormat(
                    Double.valueOf(mainPage.lblPriceTicketOld.getText()), 2);
            
            double  oPrice  = suport.numberDecimalFormat(cantO * (oldPrice * 100 / 116), 2),
                    oIva    = suport.numberDecimalFormat(
                            (cantO * (oldPrice * 100 / 116)) * 0.16, 2),
                    oTotal  = suport.numberDecimalFormat((cantO * oldPrice), 2);
            
            price   += suport.numberDecimalFormat(oPrice, 2);
            iva     += suport.numberDecimalFormat(oIva, 2);
            total   += suport.numberDecimalFormat(oTotal, 2);
            
            mainPage.lblSubtotalAmountOldTicket.setText(String.valueOf(oPrice));
            mainPage.lblIVAAmountOldTicket.setText(String.valueOf(oIva));
            mainPage.lblTotalAmountOldTicket.setText(String.valueOf(oTotal));
            
        }
        
        mainPage.lblSubtotalAmountTicket.setText(String.valueOf(
                suport.numberDecimalFormat(price, 2)));
        mainPage.lblIVAAmountTicket.setText(String.valueOf(
                suport.numberDecimalFormat(iva, 2)));
        mainPage.lblTotalAmountTicket.setText(String.valueOf(
                suport.numberDecimalFormat(total, 2)));
        
    }
    
    /**
     * Método para limpiar la cantidad de tickets seleccionados.
     */
    public void clearCantsCinemaTickets(){
        
        for(int i = 0; i < cantCinemaTickets.size(); i++)
            cantCinemaTickets.set(i, 0);
        
        mainPage.lblCantCinemaTickets1.setText("0");
        mainPage.lblCantCinemaTickets2.setText("0");
        mainPage.lblCantCinemaTickets3.setText("0");
        mainPage.lblCantCinemaTickets4.setText("0");
        showAmountsOfCinemaTickets();
        
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" PROHIBIDO TOCAR ">
    
    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //</editor-fold>
    
}