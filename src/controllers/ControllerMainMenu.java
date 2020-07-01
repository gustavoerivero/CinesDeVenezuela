
package controllers;

// Se importan las views que se van a utilizar
import views.*;
import views.tables.Table;

// Se importan los models que se van a utilizar
import models.Invoice;
import models.database.*;

// Se importan las clases de soporte a utilizar
import lib.SupportFunctions;
import lib.PDFGenerator;
import lib.TheaterSeatingChart;

// Se importan las librerías a utilizar
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.Image;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
public class ControllerMainMenu implements ActionListener, MouseListener{
    
    //<editor-fold defaultstate="collapsed" desc=" Declaración de variables ">
                
        // Models
        private Invoice invM;
    
            // Models.DataBase
            private CandyCRUD       canCRUD;
            private ClientCRUD      cliCRUD;
            private EmployeeCRUD    empCRUD;
            private EnterpriseCRUD  entCRUD;
            private TicketCRUD      ticCRUD;
            private InvoiceCRUD     invCRUD;
            private CityCRUD        citCRUD;
            private BranchCRUD      braCRUD;

        // Controllers
        private ControllerLogin                 ctrlLogin;
        private ControllerEmployeeManagement    ctrlEmployeeManagement;
        private ControllerBranchManagement      ctrlBM;
        private ControllerCinemaRoomManagement  ctrlCiRoomManagement;
        private ControllerClientManagement      ctrClientManagement;
        private ControllerEnterpriseManagement  ctrlEnterpriseManagement;
        private ControllerFilmManagement        ctrlFilmManagement;
        private ControllerListReport        ctrlReport;
        
        // Views
        private MainPage        mainPage;
        private PopupMessage    popup;
        private SelectOption    select;
        private ChangeBranch    changeBranch;
        private ModifyCandy     modifyCandy;
        
        // Support Class
        private SupportFunctions support;
        
        // Theater Seating Chart
        private TheaterSeatingChart seatingChart;
                                
    ArrayList<Object> objectList = new ArrayList<>();
    
    ArrayList<Integer> cantCinemaTickets = new ArrayList<>();
    
    private String  rolUser,
                    nameUser,
                    nameBranch;
    
    //</editor-fold>
    
    /**
     * Constructor del Controlador del Menú Principal.
     * @param rolUser Código del usuario que ha ingresado al sistema.
     * @param nameUser Nombre y Apellido del usuario que ha ingresado al sistema.
     * @param nameBranch Nombre de la Sucursal a la que pertenece el usuario que
     * ha ingresado al sistema.
     */
    public ControllerMainMenu(String rolUser, String nameUser, String nameBranch){
        
        // Declarar la variable de las clases instanciadas.
        mainPage        = new MainPage();
        support         = new SupportFunctions();
        seatingChart    = new TheaterSeatingChart();
                
        // Se inicializan las variables de apoyo.
        this.rolUser    = rolUser;
        this.nameUser   = nameUser;
        this.nameBranch = nameBranch;
        
        // Se habilitan o deshabilitan los botónes según el rol del usuario.
        enabledButtons(rolUser);
        
        // Activamos los eventos por las views.
        mainPage.addEvents(this);
        mainPage.addMouseEvents(this);
        
    }
        
    /**
     * Método que determina las acciones a realizar por la aplicación según el 
     * botón presionado.
     * @param evt indica los eventos posibles a ocurrir (click en botónes).
     */
    @Override
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
        
        // Cerar Sesión.
        else if(evt.getSource() == mainPage.btnOut){
            
            ctrlLogin = new ControllerLogin();
            
            mainPage.dispose();
            
        }

        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Botones del Menú Lateral ">
        
        // Menú Lateral -> Inicio
        else if(evt.getSource() == mainPage.btnOptionLateral1){
            support.cardSelection(mainPage.panContent, mainPage.panOption1);
            
        } 

        // Menú Lateral -> Ventas
        else if(evt.getSource() == mainPage.btnOptionLateral2){
            support.cardSelection(mainPage.panContent, mainPage.panOption2);
            support.cardSelection(mainPage.panOption2, mainPage.panDecisionOption2);
            
        }
        
        // Menú Lateral -> Reportes
        else if(evt.getSource() == mainPage.btnOptionLateral3){
            support.cardSelection(mainPage.panContent, mainPage.panOption3);
            support.cardSelection(mainPage.panOption3, mainPage.panDecisionOption3);
            
        }
        
        // Menú Lateral -> Empleados
        else if(evt.getSource() == mainPage.btnOptionLateral4){
            support.cardSelection(mainPage.panContent, mainPage.panOption4);
            
        }
        
        // Menú Lateral -> Sucursales
        else if(evt.getSource() == mainPage.btnOptionLateral5){
            support.cardSelection(mainPage.panContent, mainPage.panOption5);
            
        }
        
        // Menú Lateral -> Configuración
        else if(evt.getSource() == mainPage.btnOptionLateral6){
            support.cardSelection(mainPage.panContent, mainPage.panOption6);
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Botones del MainPage Option 1 ">
        
        // Opción 2 -> Ventas
        else if(evt.getSource() == mainPage.btnBodyOption2){
            mainPage.panBodyOption2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
           
            support.cardSelection(mainPage.panContent, mainPage.panOption2);
            support.cardSelection(mainPage.panOption2, mainPage.panDecisionOption2);
                        
        }
        
        // Opción 3 -> Reportes
        else if(evt.getSource() == mainPage.btnBodyOption3){
            mainPage.panBodyOption3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            
            support.cardSelection(mainPage.panContent, mainPage.panOption3);
            
        }
        
        // Opción 4 -> Empleados
        else if(evt.getSource() == mainPage.btnBodyOption4){
            mainPage.panBodyOption4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            
            support.cardSelection(mainPage.panContent, mainPage.panOption4);
            
        }
        
        // Opción 5 -> Sucursales
        else if(evt.getSource() == mainPage.btnBodyOption5){
            mainPage.panBodyOption5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            
            support.cardSelection(mainPage.panContent, mainPage.panOption5);
            
        }
        
        // Opción 6 -> Configuración
        else if(evt.getSource() == mainPage.btnBodyOption6){
            mainPage.panBodyOption6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
            
            support.cardSelection(mainPage.panContent, mainPage.panOption6);
            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Botones del MainPage Option 2 ">
        
        //<editor-fold defaultstate="collapsed" desc=" Decisión en la Opción 2 ">
                
        // Tickets de Golosinas
        else if(evt.getSource() == mainPage.btnCandyDecision){
            mainPage.panCapsuleCandyDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
        
            support.cardSelection(mainPage.panOption2, mainPage.panCandySell);
            
            mainPage.clearCandySell();
            
            loadCandy(nameBranch);
            
            loadEmployeeOnComboBox(nameBranch, mainPage.cmbCandySeller, 1);
            
            mainPage.cmbCandySeller.setSelectedItem(nameUser);
            
            if(!rolUser.equals("ROL-01") && !rolUser.equals("ROL-02"))
                mainPage.cmbCandySeller.setEnabled(false);
            else
                mainPage.cmbCandySeller.setEnabled(true);
                        
        }
        
        //<editor-fold defaultstate="collapsed" desc=" Venta de tickets para golosinas ">
        
        // Volver para la sección anterior
        else if(evt.getSource() == mainPage.btnBackToTicketDecision1){
            mainPage.btnBackToTicketDecision1.setBackground(new java.awt.Color(249,249,249));
            
            support.cardSelection(mainPage.panOption2, mainPage.panDecisionOption2);
            
        }
        
        // Cambiar de sucursal a gestionar
        else if(evt.getSource() == mainPage.btnChangeSucursalCandySell){
            
            ArrayList<String>   cityNames   = loadCityNames(),
                                cityBranch  = new ArrayList<>(),
                                branchNames = new ArrayList<>();
            
            loadBranch(cityBranch, branchNames);
                        
            // Instanciar la clase
            changeBranch = new ChangeBranch(mainPage, true, cityNames, cityBranch, branchNames, rolUser);
            
            // Se ubica el nombre de la sucursal.
            mainPage.lblSucursalNameCandySell.setText(changeBranch.getId_Sucursal());
            
            ArrayList<String> list = loadEmployeeBranch(changeBranch.getId_Sucursal());
            
            mainPage.cmbCandySeller.removeAllItems();
            mainPage.cmbCandySeller.addItem(" - Seleccione - ");
            
            int index = 0;
            
            for(int i = 0; i < list.size(); i++){
                
                mainPage.cmbCandySeller.addItem(list.get(i));
                
                if(rolUser.equals("ROL-04") && list.get(i).equals(nameUser))
                    index = i;
                
            }
            
            mainPage.cmbCandySeller.repaint();
            
            mainPage.cmbCandySeller.setSelectedIndex(index);
            
            if(!rolUser.equals("ROL-01") && !rolUser.equals("ROL-02"))
                mainPage.cmbCandySeller.setEnabled(false);
            else
                mainPage.cmbCandySeller.setEnabled(true);
                        
            changeBranch.dispose();
            
        }
        
        //Buscar si el cliente esta registrado
        else if(evt.getSource()==mainPage.btnSearchClientCandySell){
            cliCRUD= new ClientCRUD();
            
           // Se obtienen los datos de la cedula.
            String id = mainPage.txtIdClientCandySell.getText();
            
            // Si el contenido del campo id es vacio
             if(id.isEmpty() || id.equals("Cédula del cliente")){
                 
                 // Se muestra un mensaje emergente de "Ingrese la cédula del cliente".
                popup = new PopupMessage(mainPage, true, 1, 
                        "Debe ingresar la cédula del cliente");
             }else {
                 if(cliCRUD.signer(id)==true){
            
                 // Se muestra si se encontro la cedula en el sistema.
                        System.out.println("El cliente con la cédula'" + id + 
                                "' ha sido encontrado.");

                        // Se muestra un mensaje emergente de "Cliente Encontrado".
                        popup = new PopupMessage(mainPage, true, 4, 
                                "Cliente Encontrado");
                 } else{
                      // Se muestra un mensaje emergente de "Cliente no encontrado".
                        popup = new PopupMessage(mainPage, true, 1, 
                                "Cliente no Encontrado.");
                        
                      //SI NO SE ENCUENTRA, REGISTRAR
                 }
            }
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
                char type_Ticket = '1', estatus = 'A';
                
                String id_candies = mainPage.cmbCandySelection.getSelectedItem().toString();
                
                double mount = loadPrice(id_candies);
                
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
                         
                    String idTicket = null;
                    
                    ArrayList<String> codex = loadCodexOfTickets(1);
                    
                    idTicket = codex.get(codex.size() - 1).substring(4);
                    
                    int ticketNumber = Integer.valueOf(idTicket) + 1;
                    
                    String pathTicket = path += "/" + String.valueOf(ticketNumber); // -> Colocar el id del ticket o factura.
                
                    try {
                    
                        // Se instancia la clase
                        PDFGenerator g = new PDFGenerator();
                       
                        ArrayList<String>   names = new ArrayList<>();
                        ArrayList<Integer>  cants = new ArrayList<>();
                        ArrayList<Double> amounts = new ArrayList<>();
                    
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
                                mainPage.lblSucursalNameCandySell.getText(), 
                                pathTicket, ticketNumber, names, cants);
                    
                        // Valores de prueba (Se debe borrar y sustituir por valores de la BD)
                        
                        ArrayList<String>   enterprise_data     = new ArrayList<>(),
                                            seller_data         = new ArrayList<>(),
                                            client_data         = new ArrayList<>();
                        
                        ArrayList<String>   suportList          = new ArrayList<>();
                        
                        suportList = loadEnterprise();
                        
                        enterprise_data.add(suportList.get(0));
                        enterprise_data.add(suportList.get(1));
                        enterprise_data.add(suportList.get(2));
                        enterprise_data.add("Correo: " + suportList.get(3));
                        
                        for(int i = 0; i < enterprise_data.size(); i++)
                            System.out.println(enterprise_data.get(i));
                        
                        for(int i = 0; i < suportList.size(); i++)
                            suportList.remove(i);
                        
                        String seller = mainPage.cmbCandySeller.getSelectedItem().toString();
                        String[] sellerName = seller.split(" ");
                        
                        suportList = loadOnlyOneEmployee(sellerName[0], sellerName[1], 1);
                        
                        seller_data.add("Vendedor: " + suportList.get(1) + " " + suportList.get(2));
                        //String idEmployee = suportList.get(0);
                        seller_data.add("C.I./R.I.F. : " + suportList.get(0));
                        
                        
                        for(int i = 0; i < seller_data.size(); i++)
                            System.out.println(seller_data.get(i));
                                                
                        for(int i = 0; i < suportList.size(); i++)
                            suportList.remove(i);
                        
                        suportList = loadOnlyOneClient(mainPage.txtIdClientCandySell.getText());
                    
                        client_data.add("Cliente: " + suportList.get(1) + " " + suportList.get(2));
                        String idClient = suportList.get(0);
                        client_data.add("C.I./R.I.F. : v-" + idClient);
                        client_data.add("Dirc: " + suportList.get(4));
                        client_data.add("Tlf: " + suportList.get(3));
                        
                        for(int i = 0; i < client_data.size(); i++)
                            System.out.println(client_data.get(i));
                    
                        ArrayList<String> codexInv = loadCodexOfInvoice();
                        
                        int codexNumber = Integer.valueOf(codexInv.get(codexInv.size() - 1).substring(4)) + 1;
                                                                        
                        ArrayList<String> codexTicket = new ArrayList<>();
                        
                        codexTicket.add(String.valueOf(ticketNumber));
                        
                        String pathInvoice = path += "/" + String.valueOf(codexNumber); // -> Colocar el id del ticket o factura.
                                                            
                        /* 
                         * Se llama el método generador de factura para golosinas pasándole
                         * los parámetros correspondientes.
                         */
                        g.pdfInvoice(   enterprise_data, 
                                        seller_data, 
                                        client_data, 
                                        codexTicket, 
                                        '1', String.valueOf(codexNumber), 
                                        names, 
                                        cants, 
                                        amounts, 
                                        pathInvoice);
                        
                        /*
                        String  idInvoice  = "FAC-" + codexNumber;
                        double amount = 0, iva = 0;
                        
                        for(int i = 0; i < amounts.size(); i++){
                            amount += amounts.get(i);
                        }
                        
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        Date date = new Date();
                        Date fecha = sdf.parse(String.valueOf(date));
          
                        amount = support.numberDecimalFormat(amount, 2);
                        iva = support.numberDecimalFormat(amount * 0.16, 2);
                        
                        Invoice invM = new Invoice(idInvoice, idEmployee, idClient, 
                                fecha, iva, amount, 'A');
                        */
                        
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
        
            support.cardSelection(mainPage.panOption2, mainPage.panCinemaSell);
            
            support.cardSelection(mainPage.panStepsCinemaTickets, mainPage.panFirstStepCinemaTickets);
            
            mainPage.clearMovieTable(mainPage.tblMovieSelector);
            
            mainPage.clearFunctionSelectorTable(mainPage.tblFunctionSelector);
            
            showMovies();
            
        }
        
        //<editor-fold defaultstate="collapsed" desc=" Venta de tickets para funciones ">
        
        // Volver para la sección anterior
        else if(evt.getSource() == mainPage.btnBackToTicketDecision2){
            mainPage.btnBackToTicketDecision2.setBackground(new java.awt.Color(249,249,249));
                        
            support.cardSelection(mainPage.panOption2, mainPage.panDecisionOption2);
            
            
        }
        
        // Cambiar de sucursal a gestionar
        else if(evt.getSource() == mainPage.btnChangeSucursalCinemaTickets){
            
            ArrayList<String>   cityNames   = loadCityNames(),
                                cityBranch  = new ArrayList<>(),
                                branchNames = new ArrayList<>();
            
            loadBranch(cityBranch, branchNames);
                        
            // Instanciar la clase
            changeBranch = new ChangeBranch(mainPage, true, cityNames, cityBranch, branchNames, rolUser);
            
            // Se ubica el nombre de la sucursal.
            mainPage.lblSucursalNameCinemaTickets.setText(changeBranch.getId_Sucursal());
            
            ArrayList<String> list = loadEmployeeBranch(changeBranch.getId_Sucursal());
            
            mainPage.cmbCinemaSeller.removeAllItems();
            mainPage.cmbCinemaSeller.addItem(" - Seleccione - ");
            
            for(int i = 0; i < list.size(); i++){
                
                mainPage.cmbCinemaSeller.addItem(list.get(i));
                
            }
                        
            mainPage.cmbCinemaSeller.repaint();
            
            if(!rolUser.equals("ROL-01") && !rolUser.equals("ROL-02"))
                mainPage.cmbCandySeller.setEnabled(false);
            else
                mainPage.cmbCandySeller.setEnabled(true);
            
            changeBranch.dispose();
            
        }
        
        //<editor-fold defaultstate="collapsed" desc=" Second and Third Step ">
        
        //<editor-fold defaultstate="collapsed" desc=" Second Step ">
        
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
                    support.cardSelection(mainPage.panStepsCinemaTickets, 
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
                support.cardSelection(mainPage.panStepsCinemaTickets, 
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
            
                System.out.println(String.valueOf(cant));
                
                //<editor-fold defaultstate="collapsed" desc=" Third Step ">
                
                // Se llama el método que contiene el tercer paso.
                thirdStep();
                
                //</editor-fold>
                                
            }
            
            else{
                
                // Mensaje para indicar que se debe indicar al menos un ticket a comprar.
                popup = new PopupMessage(mainPage, true, 1, "Debe indicar al menos un ticket.");
                
            }
            
        }
        
        //<editor-fold defaultstate="collapsed" desc=" Buttons Third Step ">
        
        // Botón para limpiar la pantalla de selección de asientos.
        else if(evt.getSource() == mainPage.btnSeatsClear){
            
            // Se llama el método que contiene el tercer paso.
            thirdStep();
                                        
        }
        
        // Botón para volver al segundo paso de compra de tickets para funciones.
        else if(evt.getSource() == mainPage.btnBackToCantCinemaTickets){
                        
            // Se muestra el paso anterior para compra de boletos.
            support.cardSelection(mainPage.panStepsCinemaTickets, 
                    mainPage.panSecondStepCinemaTickets);

            /*
             * Método para retornar los valores gráficos de los botones de 
             * la compra de tickets para funciones.
             */
            mainPage.clearButtonsOfTheBuyCinemaTickets();
            
            // Se limpian los tickets a comprar.
            clearCantsCinemaTickets();
            
            // Se cargan los tickets seleccionados.
            showAmountsOfCinemaTickets();
            
            // Se cancela la indeterminación de la barra de progreso.
            mainPage.pgrCinemaTickets.setIndeterminate(false);

            // Se asigna el valor de la barra de progreso a '25'
            mainPage.pgrCinemaTickets.setValue(25);            
            
        }
     
        // Botón para ir al cuarto paso de compra de tickets para funciones.
        else if(evt.getSource() == mainPage.btnFourthStepCinemaTickets){
            
            // Se declara e inicializa una variable acumuladora.
            int cant = 0;
            
            // Acumular las entradas seleccionadas para la compra.
            for(int i = 0; i < cantCinemaTickets.size(); i++)
                cant += cantCinemaTickets.get(i);
            
            if(seatingChart.getSeatsSelected().size() == cant){
                
                // Se muestra el paso anterior para compra de boletos.
                support.cardSelection(mainPage.panStepsCinemaTickets, 
                        mainPage.panFourthStepCinemaTickets);
                      
                // Se muestran los tickets a comprar.
                showFunctionsTicketsToBuy();

                /*
                 * Método para retornar los valores gráficos de los botones de 
                 * la compra de tickets para funciones.
                 */
                mainPage.clearButtonsOfTheBuyCinemaTickets();

                // Se cancela la indeterminación de la barra de progreso.
                mainPage.pgrCinemaTickets.setIndeterminate(false);

                // Se asigna el valor de la barra de progreso a '75'
                mainPage.pgrCinemaTickets.setValue(75);  
                
            }
            
            else{
                
                // Mensaje para indicar que se debe indicar al menos un ticket a comprar.
                popup = new PopupMessage(mainPage, true, 1, "No se han seleccionado "
                        + "la cantidad de asientos correspondientes.");
                                
            }
                            
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Botones para aumentar o disminuir la cantidad de tickets según su tipo ">
 
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
        
        //<editor-fold defaultstate="collapsed" desc=" Fourth Step ">
        
        // Volver al paso anterior.
        else if(evt.getSource() == mainPage.btnCinemaSellBackStep){
            
            select = new SelectOption(mainPage, true, 2, 
                    "¿Desea volver regresar al paso de selección de tickets?", 
                    "Si", "No");
            
            // Si la respuesta es afirmativa.
            if(select.getOpc()){

                // Se limpian los tickets a comprar.
                clearCantsCinemaTickets();

                // Se cargan los tickets seleccionados.
                showAmountsOfCinemaTickets();

                // Se muestra el paso anterior para compra de boletos.
                support.cardSelection(mainPage.panStepsCinemaTickets, 
                        mainPage.panSecondStepCinemaTickets);

                /*
                 * Método para retornar los valores gráficos de los botones de 
                 * la compra de tickets para funciones.
                 */
                mainPage.clearButtonsOfTheBuyCinemaTickets();

            }
            
        }
        
        // Efectuar la venta de tickets para funciones.
        else if(evt.getSource() == mainPage.btnCinemaSell){
            
            DefaultTableModel dtm = (DefaultTableModel) mainPage.tblCinemaTickets.getModel();
            
            /**
             * Se verifica que estén todos los datos.
             *  Se verifica:
             *  - txtIdClientCinemaSell:      Que no esté vacío ni valor predeterminado.
             *  - lblSucursalnameCinemaSell:  Que no esté vacío ni valor predeterminado.
             *  - cmbCinemaSeller:            Que no esté en el valor predeterminado.
             *  - getRowCount():                Que se haya ingresado al menos una golosina.
             */
            if((!"".equals(mainPage.txtIdClientCinemaSell.getText()) || 
                !"Cédula del cliente".equals(mainPage.txtIdClientCinemaSell.getText())) && 
               (!"".equals(mainPage.lblSucursalNameCinemaTickets.getText()) || 
                !"Sucursal".equals(mainPage.lblSucursalNameCinemaTickets.getText())) &&
                mainPage.cmbCinemaSeller.getSelectedIndex() != 0 && dtm.getRowCount() > 0){                             
                
                // Se genera un JFileChooser para obtener la ruta en donde se va a guardar los archivos.
                javax.swing.JFileChooser FileChooser = new javax.swing.JFileChooser();
            
                // Se configura el JFileChooser para que solo obtenga la ruta donde se desea guardar los archivos.
                FileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
            
                // Se crea una variable para mostrar el JFileChooser
                int option = FileChooser.showSaveDialog(mainPage);
            
                // Cuando se aprueba la ubicación, se obtiene la ruta de guardado
                if(option == javax.swing.JFileChooser.APPROVE_OPTION){
                    
                    String path = FileChooser.getSelectedFile().getPath();
                         
                    int codex = 0;
                    
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
                    /*
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
                         *
                        g.pdfInvoice(   enterprise_data, 
                                        seller_list, 
                                        client_data, 
                                        id_tickets, 
                                        '1', String.valueOf((int) java.lang.Math.random() * 5000 + 1), 
                                        names, 
                                        cants, 
                                        amounts, 
                                        path);
                    */
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
        
        //</editor-fold>
        
        //</editor-fold>
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Botones del MainPage Option 3 ">
        
        //<editor-fold defaultstate="collapsed" desc=" Report "> 
        
        else if(evt.getSource() == mainPage.btnListClientDecision){
            // Se instancia y se declara la clase.
            support.cardSelection(mainPage.panOption3, mainPage.panListClientDecision);
            //ctrlFilmManagement = new ControllerFilmManagement(rolUser, nameUser, nameBranch);
             
        }        
        //<editor-fold defaultstate="collapsed" desc=" Clientes frecuentes "> 
        
        else if(evt.getSource() == mainPage.btnListClientDecision1){
            // Se instancia y se declara la clase.
            ctrlReport = new ControllerListReport(rolUser, nameUser, nameBranch,1);
            //ctrlFilmManagement = new ControllerFilmManagement(rolUser, nameUser, nameBranch);
             
        }
        
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc=" Gastos de clientes en golosina "> 
        
        else if(evt.getSource() == mainPage.btnListClientDecision2){
            // Se instancia y se declara la clase.
            ctrlReport = new ControllerListReport(rolUser, nameUser, nameBranch,2);
            //ctrlFilmManagement = new ControllerFilmManagement(rolUser, nameUser, nameBranch);
             
        }
        
        //</editor-fold>   
        //</editor-fold>   
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" Botones del MainPage Option 4 ">
        
        //<editor-fold defaultstate="collapsed" desc=" CRUD Employee "> 
        
        //Consultar listado ->  Empleado
        else if(evt.getSource() == mainPage.btnEmployeeDecision)
        {
            
            // Se instancia y se declara la clase.
            ctrlEmployeeManagement = new ControllerEmployeeManagement(rolUser, nameUser, nameBranch);
             
        }
        //</editor-fold>
         
        //</editor-fold>
                 
        //<editor-fold defaultstate="collapsed" desc=" Botones del MainPage Option 5 ">
          
        //<editor-fold defaultstate="collapsed" desc=" CRUD Branch ">
        
        //
        else if(evt.getSource() == mainPage.btnBranchDecision){
            
            // Se instancia y se declara la clase.
            ctrlBM  =  new ControllerBranchManagement(rolUser, nameUser, nameBranch);
            
        }

        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" CRUD CinemaRoom "> 
        
        //Consultar listado ->  Sala
        else if(evt.getSource() == mainPage.btnCinemaRoomDecision){
            
            // Se instancia y se declara la clase.
            ctrlCiRoomManagement = new ControllerCinemaRoomManagement(rolUser, nameUser, nameBranch);
            
        }
         
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" CRUD Enterprise ">

         //Consultar listado ->  Empresa
         else if(evt.getSource() == mainPage.btnEnterpriseDecision){
             // Se instancia y se declara la clase.
            ctrlEnterpriseManagement = new ControllerEnterpriseManagement(rolUser, nameUser, nameBranch);
            
        }
        
        //</editor-fold>
        
        //</editor-fold>
       
        //<editor-fold defaultstate="collapsed" desc=" Botones del MainPage Option 6 ">
        
        //<editor-fold defaultstate="collapsed" desc=" CRUD Client "> 
        
        //Consultar listado ->  Cliente
        else if(evt.getSource() == mainPage.btnClientDecision){
            
            // Se instancia y se declara la clase.
            ctrClientManagement = new ControllerClientManagement(rolUser, nameUser, nameBranch);
             
        }
         
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" CRUD Film "> 
        
        else if(evt.getSource() == mainPage.btnFilmDecision){
            // Se instancia y se declara la clase.
            ctrlFilmManagement = new ControllerFilmManagement(rolUser, nameUser, nameBranch);
            //ctrlFilmManagement = new ControllerFilmManagement(rolUser, nameUser, nameBranch);
             
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
                        
                        support.cardSelection(mainPage.panStepsCinemaTickets, mainPage.panSecondStepCinemaTickets);
                        
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
        
    }
        
    //<editor-fold defaultstate="collapsed" desc=" Métodos para el funcionamiento del Controller ">
    
    /**
     * Método para habilitar o deshabilitar botónes según el rol del usuario que
     * ingresa al sistema.
     * @param rol Rol del usuario que ingresa al sistema.
     */
    private void enabledButtons(String rol){
        
        switch(rol){
            
            // Rol: Administrador
            case "ROL-01":
                
                // Menú Lateral:
                mainPage.btnOptionLateral1.setEnabled(true);
                mainPage.btnOptionLateral2.setEnabled(true);
                mainPage.btnOptionLateral3.setEnabled(true);
                mainPage.btnOptionLateral4.setEnabled(true);
                mainPage.btnOptionLateral5.setEnabled(true);
                mainPage.btnOptionLateral6.setEnabled(true);
                
                // Opción 1:
                mainPage.btnBodyOption1.setEnabled(true);
                mainPage.btnBodyOption2.setEnabled(true);
                mainPage.btnBodyOption3.setEnabled(true);
                mainPage.btnBodyOption4.setEnabled(true);
                mainPage.btnBodyOption5.setEnabled(true);
                mainPage.btnBodyOption6.setEnabled(true);
                
                // Opción 2:
                mainPage.btnCandyDecision.setEnabled(true);
                mainPage.btnCinemaDecision.setEnabled(true);
                    // Candy Decision:
                    mainPage.lblSucursalNameCandySell.setText(nameBranch);
                    mainPage.btnChangeSucursalCandySell.setEnabled(true);
                    // Cinema Decision:
                    mainPage.lblSucursalNameCinemaTickets.setText(nameBranch);
                    mainPage.btnChangeSucursalCinemaTickets.setEnabled(true);
                    
                // Opción 3:
                    
                // Opción 4:
                mainPage.btnEmployeeDecision.setEnabled(true);
                mainPage.btnUserDecision.setEnabled(true);
                
                // Opción 5:
                mainPage.btnBranchDecision.setEnabled(true);
                mainPage.btnCinemaRoomDecision.setEnabled(true);
                mainPage.btnEnterpriseDecision.setEnabled(true);
                
                // Opción 6:
                mainPage.btnFilmDecision.setEnabled(true);
                mainPage.btnCandyDecisionCL.setEnabled(true);
                mainPage.btnClientDecision.setEnabled(true);
                
                break;
                
            // Rol: Gerente
            case "ROL-02":
                
                // Menú Lateral:
                mainPage.btnOptionLateral1.setEnabled(true);
                mainPage.btnOptionLateral2.setEnabled(true);
                mainPage.btnOptionLateral3.setEnabled(true);
                mainPage.btnOptionLateral4.setEnabled(true);
                mainPage.btnOptionLateral5.setEnabled(true);
                mainPage.btnOptionLateral6.setEnabled(true);
                
                // Opción 1:
                mainPage.btnBodyOption1.setEnabled(true);
                mainPage.btnBodyOption2.setEnabled(true);
                mainPage.btnBodyOption3.setEnabled(true);
                mainPage.btnBodyOption4.setEnabled(true);
                mainPage.btnBodyOption5.setEnabled(true);
                mainPage.btnBodyOption6.setEnabled(true);
                    
                // Opción 2:
                mainPage.btnCandyDecision.setEnabled(true);
                mainPage.btnCinemaDecision.setEnabled(true);
                    // Candy Decision:
                    mainPage.lblSucursalNameCandySell.setText(nameBranch);
                    mainPage.btnChangeSucursalCandySell.setEnabled(false);
                    // Cinema Decision:
                    mainPage.lblSucursalNameCinemaTickets.setText(nameBranch);
                    mainPage.btnChangeSucursalCinemaTickets.setEnabled(false);
                    
                // Opción 3:
                    
                // Opción 4:
                mainPage.btnEmployeeDecision.setEnabled(true);
                mainPage.btnUserDecision.setEnabled(true);
                
                // Opción 5:
                mainPage.btnBranchDecision.setEnabled(true);
                mainPage.btnCinemaRoomDecision.setEnabled(false);
                mainPage.btnEnterpriseDecision.setEnabled(false);
                
                // Opción 6:
                mainPage.btnFilmDecision.setEnabled(true);
                mainPage.btnCandyDecisionCL.setEnabled(true);
                mainPage.btnClientDecision.setEnabled(true);
                
                break;
                
            // Rol: Vendedor de boletos
            case "ROL-03":
                
                // Menú Lateral:
                mainPage.btnOptionLateral1.setEnabled(true);
                mainPage.btnOptionLateral2.setEnabled(true);
                mainPage.btnOptionLateral3.setEnabled(false);
                mainPage.btnOptionLateral4.setEnabled(false);
                mainPage.btnOptionLateral5.setEnabled(false);
                mainPage.btnOptionLateral6.setEnabled(false);
                
                // Opción 1:
                mainPage.btnBodyOption1.setEnabled(true);
                mainPage.btnBodyOption2.setEnabled(true);
                mainPage.btnBodyOption3.setEnabled(false);
                mainPage.btnBodyOption4.setEnabled(false);
                mainPage.btnBodyOption5.setEnabled(false);
                mainPage.btnBodyOption6.setEnabled(false);
                
                // Opción 2:
                mainPage.btnCandyDecision.setEnabled(false);
                mainPage.btnCinemaDecision.setEnabled(true);
                    // Candy Decision:
                    mainPage.lblSucursalNameCandySell.setText(nameBranch);
                    mainPage.btnChangeSucursalCandySell.setEnabled(false);
                    mainPage.cmbCandySeller.setSelectedItem(nameUser);
                    // Cinema Decision:
                    mainPage.lblSucursalNameCinemaTickets.setText(nameBranch);
                    mainPage.btnChangeSucursalCinemaTickets.setEnabled(false);
                    
                // Opción 3:
                    
                // Opción 4:
                mainPage.btnEmployeeDecision.setEnabled(false);
                mainPage.btnUserDecision.setEnabled(false);
                
                // Opción 5:
                mainPage.btnBranchDecision.setEnabled(false);
                mainPage.btnCinemaRoomDecision.setEnabled(false);
                mainPage.btnEnterpriseDecision.setEnabled(false);
                
                // Opción 6:
                mainPage.btnFilmDecision.setEnabled(false);
                mainPage.btnCandyDecisionCL.setEnabled(false);
                mainPage.btnClientDecision.setEnabled(false);
                
                break;
                
            // Rol: Vendedor de golosinas
            case "ROL-04":
                
                // Menú Lateral:
                mainPage.btnOptionLateral1.setEnabled(true);
                mainPage.btnOptionLateral2.setEnabled(true);
                mainPage.btnOptionLateral3.setEnabled(false);
                mainPage.btnOptionLateral4.setEnabled(false);
                mainPage.btnOptionLateral5.setEnabled(false);
                mainPage.btnOptionLateral6.setEnabled(false);
                
                // Opción 1:
                mainPage.btnBodyOption1.setEnabled(true);
                mainPage.btnBodyOption2.setEnabled(true);
                mainPage.btnBodyOption3.setEnabled(false);
                mainPage.btnBodyOption4.setEnabled(false);
                mainPage.btnBodyOption5.setEnabled(false);
                mainPage.btnBodyOption6.setEnabled(false);
                
                // Opción 2:
                mainPage.btnCandyDecision.setEnabled(true);
                mainPage.btnCinemaDecision.setEnabled(false);
                    // Candy Decision:
                    mainPage.lblSucursalNameCandySell.setText(nameBranch);
                    mainPage.btnChangeSucursalCandySell.setEnabled(false);
                    mainPage.cmbCandySeller.setSelectedItem(nameUser);
                    // Cinema Decision:
                    mainPage.lblSucursalNameCinemaTickets.setText(nameBranch);
                    mainPage.btnChangeSucursalCinemaTickets.setEnabled(false);
                    
                // Opción 3:
                    
                // Opción 4:
                mainPage.btnEmployeeDecision.setEnabled(false);
                mainPage.btnUserDecision.setEnabled(false);
                
                // Opción 5:
                mainPage.btnBranchDecision.setEnabled(false);
                mainPage.btnCinemaRoomDecision.setEnabled(false);
                mainPage.btnEnterpriseDecision.setEnabled(false);
                
                // Opción 6:
                mainPage.btnFilmDecision.setEnabled(false);
                mainPage.btnCandyDecisionCL.setEnabled(false);
                mainPage.btnClientDecision.setEnabled(false);
                
                break;
            
        }
        
    }
    
    /**
     * Método para añadir golosinas en una compra.
     * @param candyID id de la golosina comprada.
     * @param cant cantidad de las golosinas compradas
     * @param price precio (unidad) de las golosinas compradas
     */
    private void addCandies(String candyID, int cant, double price){
        
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
        double  iva     = support.numberDecimalFormat(price * 0.16, 2),
                unidad  = support.numberDecimalFormat(price * 1.16, 2),
                total   = support.numberDecimalFormat(price * 1.16 * cant, 2);
            
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
    private void showCandyAmounts(){
        
        // Se obtiene el modelo de la JTable.
        DefaultTableModel dtm = (DefaultTableModel) mainPage.tblCandy.getModel();
             
        // Se crean las variables acumuladoras que mostrarán los montos correspondientes
        double acumSub = 0, acumIVA = 0, acumTotal = 0;
        
        // Ciclo 'for' para recorrer todas las filas de la tabla
        for (int i = 0; i < dtm.getRowCount(); i++){
            
            // Se obtienen los valores y se hacen los respectivos cálculos
            int     cant    = Integer.valueOf(dtm.getValueAt(i, 1).toString());
            double  price   = support.numberDecimalFormat(Double.valueOf(
                                dtm.getValueAt(i,2).toString()) * cant, 2),
                    iva     = support.numberDecimalFormat(price * 0.16, 2),
                    total   = support.numberDecimalFormat(price * 1.16, 2);
            
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
    private void showMovies(){
        
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
    private void showFunctions(String idMovie){
        
        mainPage.clearFunctionSelectorTable(mainPage.tblFunctionSelector);
        
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
    private void showAmountsOfCinemaTickets(){
        
        double price = 0, iva = 0, total = 0;
        
        int cantA = cantCinemaTickets.get(0),
            cantK = cantCinemaTickets.get(1),
            cantC = cantCinemaTickets.get(2),
            cantO = cantCinemaTickets.get(3);
        
        if(cantA >= 0){
            
            double adultPrice = support.numberDecimalFormat(
                    Double.valueOf(mainPage.lblPriceTicketAdult.getText()), 2);
            
            double  aPrice  = support.numberDecimalFormat(cantA * (adultPrice * 100 / 116), 2),
                    aIva    = support.numberDecimalFormat(
                            (cantA * (adultPrice * 100 / 116)) * 0.16, 2),
                    aTotal  = support.numberDecimalFormat((cantA * adultPrice), 2);
            
            price   += support.numberDecimalFormat(aPrice, 2);
            iva     += support.numberDecimalFormat(aIva, 2);
            total   += support.numberDecimalFormat(aTotal, 2);
            
            mainPage.lblSubtotalAmountAdultTicket.setText(String.valueOf(aPrice));
            mainPage.lblIVAAmountAdultTicket.setText(String.valueOf(aIva));
            mainPage.lblTotalAmountAdultTicket.setText(String.valueOf(aTotal));
            
        }
        
        if(cantK >= 0){
            
            double kinderPrice = support.numberDecimalFormat(
                    Double.valueOf(mainPage.lblPriceTicketKinder.getText()), 2);
            
            double  kPrice  = support.numberDecimalFormat(cantK * (kinderPrice * 100 / 116), 2),
                    kIva    = support.numberDecimalFormat(
                            (cantK * (kinderPrice * 100 / 116)) * 0.16, 2),
                    kTotal  = support.numberDecimalFormat((cantK * kinderPrice), 2);
            
            price   += support.numberDecimalFormat(kPrice, 2);
            iva     += support.numberDecimalFormat(kIva, 2);
            total   += support.numberDecimalFormat(kTotal, 2);
            
            mainPage.lblSubtotalAmountKinderTicket.setText(String.valueOf(kPrice));
            mainPage.lblIVAAmountKinderTicket.setText(String.valueOf(kIva));
            mainPage.lblTotalAmountKinderTicket.setText(String.valueOf(kTotal));
            
        }
        
        if(cantC >= 0){
            
            double childPrice = support.numberDecimalFormat(
                    Double.valueOf(mainPage.lblPriceTicketChild.getText()), 2);
            
            double  cPrice  = support.numberDecimalFormat(cantC * (childPrice * 100 / 116), 2),
                    cIva    = support.numberDecimalFormat(
                            (cantC * (childPrice * 100 / 116)) * 0.16, 2),
                    cTotal  = support.numberDecimalFormat((cantC * childPrice), 2);
            
            price   += support.numberDecimalFormat(cPrice, 2);
            iva     += support.numberDecimalFormat(cIva, 2);
            total   += support.numberDecimalFormat(cTotal, 2);
            
            mainPage.lblSubtotalAmountChildTicket.setText(String.valueOf(cPrice));
            mainPage.lblIVAAmountChildTicket.setText(String.valueOf(cIva));
            mainPage.lblTotalAmountChildTicket.setText(String.valueOf(cTotal));
            
        }
        
        if(cantO >= 0){
            
            double oldPrice = support.numberDecimalFormat(
                    Double.valueOf(mainPage.lblPriceTicketOld.getText()), 2);
            
            double  oPrice  = support.numberDecimalFormat(cantO * (oldPrice * 100 / 116), 2),
                    oIva    = support.numberDecimalFormat(
                            (cantO * (oldPrice * 100 / 116)) * 0.16, 2),
                    oTotal  = support.numberDecimalFormat((cantO * oldPrice), 2);
            
            price   += support.numberDecimalFormat(oPrice, 2);
            iva     += support.numberDecimalFormat(oIva, 2);
            total   += support.numberDecimalFormat(oTotal, 2);
            
            mainPage.lblSubtotalAmountOldTicket.setText(String.valueOf(oPrice));
            mainPage.lblIVAAmountOldTicket.setText(String.valueOf(oIva));
            mainPage.lblTotalAmountOldTicket.setText(String.valueOf(oTotal));
            
        }
        
        mainPage.lblSubtotalAmountTicket.setText(String.valueOf(support.numberDecimalFormat(price, 2)));
        mainPage.lblIVAAmountTicket.setText(String.valueOf(support.numberDecimalFormat(iva, 2)));
        mainPage.lblTotalAmountTicket.setText(String.valueOf(support.numberDecimalFormat(total, 2)));
        
    }
    
    /**
     * Método para limpiar la cantidad de tickets seleccionados.
     */
    private void clearCantsCinemaTickets(){
        
        for(int i = 0; i < cantCinemaTickets.size(); i++)
            cantCinemaTickets.set(i, 0);
        
        mainPage.lblCantCinemaTickets1.setText("0");
        mainPage.lblCantCinemaTickets2.setText("0");
        mainPage.lblCantCinemaTickets3.setText("0");
        mainPage.lblCantCinemaTickets4.setText("0");
        showAmountsOfCinemaTickets();
        
    }
    
    /**
     * Método que contiene le procedimiento a seguir para el tercer paso en la compra
     * de tickets para funciones.
     */
    private void thirdStep(){
        
        // Se declara e inicializa una variable acumuladora.
        int cant = 0;
            
        // Acumular las entradas seleccionadas para la compra.
        for(int i = 0; i < cantCinemaTickets.size(); i++)
            cant += cantCinemaTickets.get(i);
        
        // Se muestra el siguiente paso para compra de boletos.
        support.cardSelection(mainPage.panStepsCinemaTickets, 
                mainPage.panThirdStepCinemaTickets);
                
            /*
             * Método para retornar los valores gráficos de los botones de 
             * la compra de tickets para funciones.
             */
            mainPage.clearButtonsOfTheBuyCinemaTickets();

            // Se cancela la indeterminación de la barra de progreso.
            mainPage.pgrCinemaTickets.setIndeterminate(false);

            // Se asigna el valor de la barra de progreso a '50'
            mainPage.pgrCinemaTickets.setValue(50);
                
            // Debe haber un arreglo con los asientos ya ocupados.
            ArrayList<String> busySeats = new ArrayList<>();
                
            busySeats.add("H8");
            busySeats.add("H7");
            busySeats.add("F4");
                       
            // Mostrar la cantidad de asientos que se deben seleccionar.
            mainPage.lblCantSeatsToSelectNumber.setText(String.valueOf(cant));
                            
            // Método para mostrar los asientos disponibles
            seatingChart.buildCinemaSeats(8, 8, cant, mainPage.panSelectorSeats, 
                    mainPage.panTheaterSeatChart, mainPage.lblTotalSeatsCant, 
                    mainPage.lblFreeSeatsCant, mainPage.lblSelectedSeatsCant,
                    busySeats);
                
            // Se indica la indeterminación de la barra de progreso.
            mainPage.pgrCinemaTickets.setIndeterminate(true);
        
    }
    
    /**
     * Método para mostrar todos los tickets y su información al respecto que se van a comprar.
     */
    private void showFunctionsTicketsToBuy(){
        
        // Se limpia la tabla de tickets a comprar.
        mainPage.clearCinemaSell();
        
        // Se obtiene el modelo de la JTable.
        DefaultTableModel dtm = (DefaultTableModel) mainPage.tblCinemaTickets.getModel();
                     
        // Un listado que servirá de soporte.
        ArrayList<String> suportList = seatingChart.getSeatsSelected();
                
        // Se elaboran las variables para los montos.
        double  acumSub     = 0, // -> Acumulador de precios sin IVA.
                acumIVA     = 0, // -> Acumulador de IVAs.
                acumTotal   = 0, // -> Acumulador de precios con IVA.
                price       = 0, // -> Precio obtenido del ticket (total).
                unit        = 0, // -> Precio sin IVA del ticket.
                iva         = 0, // -> IVA del ticket.
                total       = 0; // -> Precio ajustado del ticket.
        String  type        = null, // -> Mensaje a mostrar según el tipo de entrada.
                butaca      = null; // -> Butaca asignada al ticket.
        
        // Mostrar (confirmar) la cantidad de tickets a comprar.
        System.out.println("Cantidad de tickets comprados: " + String.valueOf(suportList.size()));
               
        // Ciclo para recorrer la cantidad total de tickets a comprar.
        for(int i = 0; i <= suportList.size(); i++){
                        
            // Ciclo para recorrer el listado según los tipos de tickets.
            for(int j = 0; j < cantCinemaTickets.size(); j++){
                           
                // Ciclo para recorrer la cantidad de tickets a comprar según el tipo.
                for(int k = 0; k < cantCinemaTickets.get(j); k++){
                
                    /* 
                     * Si se van a comprar tickets según el tipo 'j', se realiza
                     * una validación para que el código no tenga que realizar las
                     * operaciones y optimizar su tiempo de ejecución.
                     */
                    if(cantCinemaTickets.get(j) > 0){

                        // Se obtiene la butaca que se asignará al ticket.
                        butaca = suportList.get(suportList.size() - 1);
                        
                        // Se comprueba que tipo de ticket se va a coprar.
                        switch(j){

                            // Ticket Adulto.
                            case 0:

                                // Se obtiene el monto a pagar por el ticket.
                                price = support.numberDecimalFormat(
                                        Double.valueOf(mainPage.lblPriceTicketAdult.getText()), 2);

                                // Se obtienen los montos del ticket de tipo Adulto.
                                unit    = support.numberDecimalFormat(price * 0.84, 2);
                                iva     = support.numberDecimalFormat(price * 0.16, 2);      
                                total   = support.numberDecimalFormat(price, 2);

                                // Se cataloga el ticket.
                                type = "Adulto";

                                // Fin del caso '0'.
                                break;

                            // Ticket Kinder.
                            case 1:

                                // Se obtiene el monto a pagar por el ticket.
                                price = support.numberDecimalFormat(
                                        Double.valueOf(mainPage.lblPriceTicketKinder.getText()), 2);

                                // Se obtienen los montos del ticket de tipo Adulto.
                                unit    = support.numberDecimalFormat(price * 0.84, 2);
                                iva     = support.numberDecimalFormat(price * 0.16, 2);
                                total   = support.numberDecimalFormat(price, 2);

                                // Se cataloga el ticket.
                                type = "Kinder";

                                // Fin del caso '1'.
                                break;

                            // Ticket Niño.
                            case 2:

                                // Se obtiene el monto a pagar por el ticket.
                                price = support.numberDecimalFormat(
                                        Double.valueOf(mainPage.lblPriceTicketChild.getText()), 2);

                                // Se obtienen los montos del ticket de tipo Adulto.
                                unit    = support.numberDecimalFormat(price * 0.84, 2);
                                iva     = support.numberDecimalFormat(price * 0.16, 2);
                                total   = support.numberDecimalFormat(price, 2);

                                // Se cataloga el ticket.
                                type = "Niño";

                                // Fin del caso '2'.
                                break;

                            // Ticket Tercera Edad.
                            case 3:

                                // Se obtiene el monto a pagar por el ticket.
                                price = support.numberDecimalFormat(
                                        Double.valueOf(mainPage.lblPriceTicketOld.getText()), 2);

                                // Se obtienen los montos del ticket de tipo Adulto.
                                unit    = support.numberDecimalFormat(price * 0.84, 2);
                                iva     = support.numberDecimalFormat(price * 0.16, 2);
                                total   = support.numberDecimalFormat(price, 2);

                                // Se cataloga el ticket.
                                type = "Tercera Edad";

                                // Fin del caso '3'.
                                break;

                        }

                        // Se añade la nueva fila.
                        dtm.addRow( new Object[]{
                                    type,                   // -> Tipo de ticket.
                                    butaca,                 // -> Butaca asignada.
                                    String.valueOf(unit),   // -> Precio sin IVA.
                                    String.valueOf(iva),    // -> IVA
                                    String.valueOf(total)   // -> Precio con IVA.
                        });

                        /*
                         * Se imprime en pantalla la información del ticket a comprar;
                         * Tipo de ticket, butaca asignada, su costo, el iva correspondiente
                         * y el total a pagar por el ticket.
                         */
                        System.out.println(
                                  "La entrada es de tipo: '" + type + "' "
                                + "asignada a la butaca: '" + butaca + "' "
                                + "con un costo de: '" + unit + "' "
                                + "donde su IVA (16%) es de: '" + iva + "' "
                                + "y corresponde a un total a pagar de: '" + total + "'.");
                        
                        /*
                         * Se remueve la butaca de la lista de asientos seleccionados
                         * con el fin de que no se vuelva a repetir; un asiento único
                         * por ticket.
                         */
                        suportList.remove(butaca);
                        
                        /*
                         * Se disminuye la cantidad de tickets a comprar según el tipo
                         * con el propósito de que el ciclo se ejecute sin repeticiones.
                         */
                        cantCinemaTickets.set(j, cantCinemaTickets.get(j)-1);
                        
                    }
                                    
                }
                
            }
            
        }
                
        // Ciclo para obtener los montos a cancelar.
        for(int i = 0; i < dtm.getRowCount(); i++){
            
            acumSub     += Double.valueOf(dtm.getValueAt(i, 2).toString()); // -> Acumulador de precios sin IVA.
            acumIVA     += Double.valueOf(dtm.getValueAt(i, 3).toString()); // -> Acumulador de IVAs.
            acumTotal   += Double.valueOf(dtm.getValueAt(i, 4).toString()); // -> Acumulador de precios con IVA.
            
        }
       
        /*
         * Se muestran en pantalla la información de los acumuladores ajustados 
         * (mostrando únicamente dos decimales).
         */
        mainPage.txtSubTotalCinema.setText(String.valueOf(support.numberDecimalFormat(acumSub, 2)));   // -> SubTotal ajustado.
        mainPage.txtIVACinema.setText(String.valueOf(support.numberDecimalFormat(acumIVA, 2)));   // -> IVA ajustado.
        mainPage.txtTotalCinema.setText(String.valueOf(support.numberDecimalFormat(acumTotal, 2))); // -> Total ajustado.
        
    }
    
    /**
     * Método para cargar todos las golosinas a vender.
     */
    private void loadCandy(String branch){
        
        // Se instancia la clase a utilizar.
        canCRUD = new CandyCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            
            if(!rolUser.equals("ROL-01") && !rolUser.equals("ROL-02"))
                result = canCRUD.ReadAllCandy(branch);
            else
                result = canCRUD.ReadAllCandy();
            
            mainPage.cmbCandySelection.removeAllItems();
            mainPage.cmbCandySelection.addItem(" - Seleccione - ");
            while(result.next()){
                 mainPage.cmbCandySelection.addItem(result.getString("nombre"));
            }
            
            System.out.println("Éxito.");
            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }
    
    /**
     * Método para cargar todas ciudades.
     * @return Listado de nombres de ciudades.
     */
    private ArrayList<String> loadCityNames(){
        
        // Se instancia la clase a utilizar.
        citCRUD = new CityCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        // Se declara e instancia la variable de soporte.
        ArrayList<String> cityNames = new ArrayList<>();
        
        try {
            result = citCRUD.readAllCityNames();
            while(result.next()){
                cityNames.add(result.getString("nombre"));
            }
            
            System.out.println("Éxito.");
            
            return cityNames;
            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
        return null;
        
    }
    
    /**
     * Método para cargar sucursales.
     * @param firstList Primer listado con los nombres de ciudades.
     * @param secondList Segundo listado con los nombres de sucursales.
     */
    private void loadBranch(ArrayList<String> firstList, ArrayList<String> secondList){
        
        // Se instancia la clase a utilizar.
        braCRUD = new BranchCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            result = braCRUD.readBranchForCity();
            while(result.next()){
                firstList.add(result.getString("NombreCiudad"));
                secondList.add(result.getString("NombreSucursal"));
            }
                        
            System.out.println("Éxito.");
                                    
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }
    
    /**
     * Método para buscar el precio de una golosina.
     * @param nameCandy nombre de las golosinas.
     * @return regresa el valor del precio.
     */
    private double loadPrice(String nameCandy){
        
        // Se instancia la clase a utilizar.
        canCRUD = new CandyCRUD();
        
        double price = 0;
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            result = canCRUD.searchPrice(nameCandy);
            while(result.next()){
                 price = Double.valueOf(result.getString("precio"));
            }
            
            System.out.println("Éxito.");
            return price;
            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
        return -1;
        
    }
    
    /**
     * Método para cargar los empleados en un combobox según su tipo.
     * @param cmb Combobox a cargar.
     * @param type Indica que tipo de empleado se va a cargar.
     */
    private void loadEmployeeOnComboBox(String branch, JComboBox cmb, int type){
        
        // Se instancia la clase a utilizar.
        empCRUD = new EmployeeCRUD();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            result = empCRUD.readSellerForType(branch, type);
            cmb.removeAllItems();
            cmb.addItem(" - Seleccione - ");
            while(result.next()){
                 cmb.addItem(result.getString("nombre") + " " + result.getString("apellido"));
            }
            
            System.out.println("Éxito.");
            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
    }
    
    /**
     * Método para cargar los empleados de una Sucursal.
     * @param branch Nombre de la sucursal.
     * @return Listado de los empleados.
     */
    private ArrayList<String> loadEmployeeBranch(String branch){
        
        // Se instancia la clase a utilizar.
        empCRUD = new EmployeeCRUD();
        
        ArrayList<String> list = new ArrayList<>();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            result = empCRUD.readAllEmployeeOnBranch(branch);
            while(result.next()){
                 list.add(result.getString("nombre") + " " + result.getString("apellido"));
            }
            
            System.out.println("Éxito.");
            
            return list;
            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
        return null;
        
    }
    
    /**
     * Método pra cargar los empleados.
     * @param name Nombre del empleado.
     * @param lastName Apellido del empleado.
     * @type Tipo de cargo.
     * @return Listado de datos del empleado.
     */
    private ArrayList<String> loadOnlyOneEmployee(String name, String lastName, int type){
        
        // Se instancia la clase a utilizar.
        empCRUD = new EmployeeCRUD();
        
        // Se declara e instancia un listado.
        ArrayList<String> employeeData = new ArrayList<>();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            result = empCRUD.readOnlyOneSellerForType(name, lastName, type);
            while(result.next()){
                 employeeData.add(result.getString("cedula"));
                 employeeData.add(result.getString("nombre"));
                 employeeData.add(result.getString("apellido"));
                 employeeData.add(result.getString("telefono"));
                 employeeData.add(result.getString("direccion"));
                 employeeData.add(result.getString("correo"));
            }
            
            System.out.println("Éxito.");
            
            return employeeData;
            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
        return null;
        
    }
    
    /**
     * Método para cargar datos de un cliente.
     * @param id Código del cliente.
     * @return Datos del cliente.
     */
    private ArrayList<String> loadOnlyOneClient(String id){
        
        // Se instancia la clase a utilizar.
        cliCRUD = new ClientCRUD();
        
        // Se declara e instancia un listado.
        ArrayList<String> clientData = new ArrayList<>();
        
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            result = cliCRUD.ReadOnlyOneClient(id);
            while(result.next()){
                 clientData.add(result.getString("cedula"));
                 clientData.add(result.getString("nombre"));
                 clientData.add(result.getString("apellido"));
                 clientData.add(result.getString("telefono"));
                 clientData.add(result.getString("direccion"));
                 clientData.add(result.getString("correo"));
            }
            
            System.out.println("Éxito.");
            
            return clientData;
            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
        return null;
        
    }
    
    /**
     * Método para cargar la información de la empresa.
     * @return listado con la información de la empresa.
     */
    private ArrayList<String> loadEnterprise(){
        
        // Se instancia la clase a utilizar.
        entCRUD = new EnterpriseCRUD();
        
        // Se declara e instancia el arreglo resultado.
        ArrayList<String> enterpriseData = new ArrayList<>();
                
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            result = entCRUD.readEnterprise();
            while(result.next()){
                 enterpriseData.add(result.getString("codigo"));
                 enterpriseData.add(result.getString("nombre"));
                 enterpriseData.add(result.getString("descripcion"));
                 enterpriseData.add(result.getString("correo"));
            }
            
            System.out.println("Éxito.");
            
            return enterpriseData;
            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
        return null;
        
    }
    
    /**
     * Método para cargar los códigos de los tickets según el tipo.
     * @param type Tipo del ticket que se va a cargar.
     * @return listado con la información de la empresa.
     */
    private ArrayList<String> loadCodexOfTickets(int type){
        
        // Se instancia la clase a utilizar.
        ticCRUD = new TicketCRUD();
        
        // Se declara e instancia el arreglo resultado.
        ArrayList<String> codex = new ArrayList<>();
                
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            result = ticCRUD.readCodexOfTickets(type);
            while(result.next()){
                 codex.add(result.getString("codigo"));
            }
            
            System.out.println("Éxito.");
            
            return codex;
            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
        return null;
        
    }
    
    /**
     * Método para cargar los códigos de las facturas.
     * @return listado..
     */
    private ArrayList<String> loadCodexOfInvoice(){
        
        // Se instancia la clase a utilizar.
        invCRUD = new InvoiceCRUD();
        
        // Se declara e instancia el arreglo resultado.
        ArrayList<String> codex = new ArrayList<>();
                
        // Se declara la variable que devuelve el resultado.
        java.sql.ResultSet result;
        
        try {
            result = invCRUD.readCodexInvoice();
            while(result.next()){
                 codex.add(result.getString("codigo"));
            }
            
            System.out.println("Éxito.");
            
            return codex;
            
        } catch (java.sql.SQLException e) {
            
            System.out.println("Error: " + e);
            
        }
        
        return null;
        
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
