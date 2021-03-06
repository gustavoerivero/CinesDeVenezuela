
package views;

// Se importa las librerías de soporte.
import views.tables.Table;
import lib.SupportFunctions;

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
public class MainPage extends javax.swing.JFrame {

    // Variables de apoyo para conocer la ubicación de la aplicación.
    int xx = 0, xy = 0;
    
    // Variables de soporte para el uso de tablas.
    int column = 0, row = 0;
    
    // Se instancia la clase de soporte Table.
    Table table = new Table();
    
    // Se instancia la clase de soporte.
    private SupportFunctions support;
    
    /**
     * Constructor MainPage.
     */
    public MainPage() {
        
        // Inicializa todas las variables (o mejor dicho componentes) que usa el JFrame.
        initComponents();
        
        // Se instancia la clase de soporte.
        support = new SupportFunctions();
        
        // Ubica el JFrame en el centro de la pantalla.
        setLocationRelativeTo(null);
        
        // Muestra el JFrame.
        setVisible(true);
        
        // Cambia el ícono del JFrame.
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("images/CDV-icon.png")).getImage());
        
        // Iniciar la aplicación en la opción 1 (Home).
        support.cardSelection(panContent, panOption1);
                
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Listeners ">
    
    /**
     * Método que se activa al realizar una acción (presionar click sobre algún 
     * botón) añadiendo este evento a una lista que será manejada con mayor pro-
     * fundidad en el Controlador correspondiente.
     * Este método hace uso de la clase abstracta ActionListener la cual está 
     * fuertemente vinculada a todas las acciones provocadas por botones.
     * @param evt 
     */
    public void addEvents(java.awt.event.ActionListener evt){
        // Eventos de los botones de la barra superior.
        btnOut.addActionListener(evt);  // -> Cerrar Sesión
        btnMin.addActionListener(evt);  // -> Minimizar
        btnExit.addActionListener(evt); // -> Cerrar app
        
        // Eventos de los botones del menú lateral.
        btnOptionLateral1.addActionListener(evt); // -> Inicio
        btnOptionLateral2.addActionListener(evt); // -> Ventas
        btnOptionLateral3.addActionListener(evt); // -> Reportes
        btnOptionLateral4.addActionListener(evt); // -> Empleados
        btnOptionLateral5.addActionListener(evt); // -> Sucursales
        btnOptionLateral6.addActionListener(evt); // -> Configuración
        
        // Eventos de los botones de la opción 1 -> Inicio.
        btnBodyOption2.addActionListener(evt); // -> Ventas
        btnBodyOption3.addActionListener(evt); // -> Reportes
        btnBodyOption4.addActionListener(evt); // -> Empleados
        btnBodyOption5.addActionListener(evt); // -> Sucursales
        btnBodyOption6.addActionListener(evt); // -> Configuración
        
        // Eventos de los botones de la opción 2 -> Ventas.
        // Decision: (Candy or Cinema)
        btnCandyDecision.addActionListener(evt);    // -> Venta de tickets para golosinas
        btnCinemaDecision.addActionListener(evt);   // -> Venta de tickets para funciones
        
            //Back to decision ticket.
            btnBackToTicketDecision1.addActionListener(evt); // -> Volver a la interfaz anterior
            btnBackToTicketDecision2.addActionListener(evt); // -> Volver a la interfaz anterior
            
            // -> Candy Ticket Sell
            btnChangeSucursalCandySell.addActionListener(evt);      // -> Cambiar de Sucursal
            btnSearchClientCandySell.addActionListener(evt);        // -> Buscar Cliente
            btnAddCandySell.addActionListener(evt);                 // -> Añadir golosina
            btnCandySellClear.addActionListener(evt);               // -> Limpiar formulario
            btnCandySell.addActionListener(evt);                    // -> Vender golosinas
            
            
            // -> Cinema Ticket Sell
            btnChangeSucursalCinemaTickets.addActionListener(evt);  // -> Cambiar de Sucursal
                // -> Second Step
                btnBackToSelectorMovie.addActionListener(evt);
                btnNextStepBuyTicket.addActionListener(evt);
                
                btnAddCinemaTickets1.addActionListener(evt);
                btnMinusCinemaTickets1.addActionListener(evt);
                
                btnAddCinemaTickets2.addActionListener(evt);
                btnMinusCinemaTickets2.addActionListener(evt);
                
                btnAddCinemaTickets3.addActionListener(evt);
                btnMinusCinemaTickets3.addActionListener(evt);
                
                btnAddCinemaTickets4.addActionListener(evt);
                btnMinusCinemaTickets4.addActionListener(evt);
            
                // -> Third Step
                btnSeatsClear.addActionListener(evt);
                btnBackToCantCinemaTickets.addActionListener(evt);
                btnFourthStepCinemaTickets.addActionListener(evt);
                
                // -> Fourth Step
                btnSearchClientCinemaSell.addActionListener(evt);
                btnCinemaSellBackStep.addActionListener(evt);
                btnCinemaSell.addActionListener(evt);
                
        // Eventos de la opción 3 -> Reportes
        btnListClientDecision.addActionListener(evt);
        btnListEmployeeDecision.addActionListener(evt);
        btnListPeliculasDecision.addActionListener(evt);
            // Eventos de la opción 3.1 -> Listados relacionados con clientes
            btnListClientDecision1.addActionListener(evt);
            btnListClientDecision2.addActionListener(evt);
            // Eventos de la opción 3.1 -> Listados relacionados con Peliculas
            btnListPelculasGeneral.addActionListener(evt);
            btnListPeliculasXmes.addActionListener(evt);
            // Eventos de la opción 3.2 -> Listados relacionados con empleados
            btnListEmployeeDecision1.addActionListener(evt);
            btnListEmployeeDecision2.addActionListener(evt);
            
        // Eventos de la opción 4 -> Empleados
        btnEmployeeDecision.addActionListener(evt);
        btnUserDecision.addActionListener(evt);
        
        // Eventos de la opción 5 -> Sucursales
        btnBranchDecision.addActionListener(evt);
        btnCinemaRoomDecision.addActionListener(evt);
        btnEnterpriseDecision.addActionListener(evt);
        btnCandyInventory.addActionListener(evt);
        btnFunction.addActionListener(evt);
        
        // Eventos de la opción 6 -> Configuración
        btnFilmDecision.addActionListener(evt);
        btnCandyDecisionCL.addActionListener(evt);
        btnClientDecision.addActionListener(evt);
        btnListClientDecision3.addActionListener(evt);
    }
   
    /**
     * Método que permite activar los eventos del escuchador Mouse.
     * @param evt parámetro que se activa cuando el Mouse reacciona a algo.
     */
    public void addMouseEvents(java.awt.event.MouseListener evt){
        tblCandy.addMouseListener(evt);             // -> Tabla de golosinas.
        tblMovieSelector.addMouseListener(evt);     // -> Tabla de películas.
        tblFunctionSelector.addMouseListener(evt);  // -> Tabla de funciones.
    }
    
    /**
     * Método que permite activar los eventos del escuchador de combobox.
     * @param evt parámetro que se activa cuando el Mouse reacciona a algo. 
     */
    public void addItemEvents(java.awt.event.ItemListener evt){
        
        cmbCandySelection.addItemListener(evt);
        cmbCandySeller.addItemListener(evt);
        
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Métodos para manipular tablas ">
    
    /**
     * Método que retorna los valores iniciales de los componentes de 
     * JPanel de Candy Sell.
     */
    public void clearCandySell(){
        
        txtIdClientCandySell.setText("Cédula del cliente");
        cmbCandySeller.setSelectedIndex(0);
        cmbCandySelection.setSelectedIndex(0);
        spnCantCandySell.setValue(0);
        txtSubTotalCandy.setText("0.0");
        txtIVACandy.setText("0.0");
        txtTotalCandy.setText("0.0");
        clearCandyTable(tblCandy);
        
    }
    
    /**
     * Método que retorna los valores iniciales de los componentes del JPanel del
     * cuarto paso en la compra de tickets para funciones.
     */
    public void clearCinemaSell(){
        
        txtIdClientCinemaSell.setText("Cédula del cliente");
        cmbCinemaSeller.setSelectedIndex(0);
        txtSubTotalCinema.setText("0.0");
        txtIVACinema.setText("0.0");
        txtTotalCinema.setText("0.0");
        clearCinemaTicketsTable(tblCinemaTickets);
        
    }
    
    /**
     * Método que retorna los valores iniciales de un JTable.
     * @param table parámetro JTable.
     */
    public void clearCandyTable(javax.swing.JTable table){
        this.table.buildCandyTable(table, null);
    }
    
    /**
     * Método que retorna los valores iniciales de un JTable.
     * @param table parámetro JTable.
     */
    public void clearMovieTable(javax.swing.JTable table){
        this.table.buildMovieSelectorTable(table, null);
    }
    
    /**
     * Método que retorna los valores iniciales de un JTable.
     * @param table parámetro JTable.
     */
    public void clearFunctionSelectorTable(javax.swing.JTable table){
        this.table.buildFunctionSelectorTable(table, null);
    }
    
    /**
     * Método que retorna los valores iniciales de un JTable.
     * @param table parámetro JTable
     */
    public void clearCinemaTicketsTable(javax.swing.JTable table){
        this.table.buildCinemaTicketsTable(table, null);
    }
    
    /**
     * Método para indicar el valor de una columna en un JTable.
     * @param column 
     */
    public void setColumnTable(int column){
        this.column = column;
    }
    
    /**
     * Método para obtener el valor de una columna en un JTable.
     * @return el valor de la columna.
     */
    public int getColumnTable(){
        return column;
    }
    
    /**
     * Método para indicar el valor de una fila en un JTable.
     * @param row 
     */
    public void setRowTable(int row){
        this.row = row;
    }
    
    /**
     * Método para obtener el valor de una columna en un JTable.
     * @return el valor de la fila.
     */
    public int getRowTable(){
        return row;
    }
    
    //</editor-fold>
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panMainPage = new javax.swing.JPanel();
        panTopBar = new javax.swing.JPanel();
        panTopBarLateralMenu = new javax.swing.JPanel();
        panButtonsTopBar = new javax.swing.JPanel();
        btnOut = new javax.swing.JButton();
        btnMin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        panLateralMenu = new javax.swing.JPanel();
        lblCDVlogo = new javax.swing.JLabel();
        sepLateralMenu = new javax.swing.JSeparator();
        lblADCmark = new javax.swing.JLabel();
        panLateralOptions = new javax.swing.JPanel();
        btnOptionLateral1 = new javax.swing.JButton();
        btnOptionLateral2 = new javax.swing.JButton();
        btnOptionLateral3 = new javax.swing.JButton();
        btnOptionLateral4 = new javax.swing.JButton();
        btnOptionLateral5 = new javax.swing.JButton();
        btnOptionLateral6 = new javax.swing.JButton();
        panMainMenu = new javax.swing.JPanel();
        panContent = new javax.swing.JPanel();
        panOption1 = new javax.swing.JPanel();
        lblTittleOption1 = new javax.swing.JLabel();
        sepTittleOption1 = new javax.swing.JSeparator();
        scpBodyOption1 = new javax.swing.JScrollPane();
        panBodyOptions1 = new javax.swing.JPanel();
        sepBodyOption1 = new javax.swing.JSeparator();
        panBodyOption1 = new javax.swing.JPanel();
        btnBodyOption1 = new javax.swing.JButton();
        sepBodyOption2 = new javax.swing.JSeparator();
        panBodyOption2 = new javax.swing.JPanel();
        btnBodyOption2 = new javax.swing.JButton();
        sepBodyOption3 = new javax.swing.JSeparator();
        panBodyOption3 = new javax.swing.JPanel();
        btnBodyOption3 = new javax.swing.JButton();
        sepBodyOption4 = new javax.swing.JSeparator();
        panBodyOption4 = new javax.swing.JPanel();
        btnBodyOption4 = new javax.swing.JButton();
        sepBodyOption5 = new javax.swing.JSeparator();
        panBodyOption5 = new javax.swing.JPanel();
        btnBodyOption5 = new javax.swing.JButton();
        sepBodyOption6 = new javax.swing.JSeparator();
        panBodyOption6 = new javax.swing.JPanel();
        btnBodyOption6 = new javax.swing.JButton();
        sepBodyOption7 = new javax.swing.JSeparator();
        panBodyOption7 = new javax.swing.JPanel();
        btnBodyOption7 = new javax.swing.JButton();
        sepBodyOption8 = new javax.swing.JSeparator();
        panOption2 = new javax.swing.JPanel();
        panDecisionOption2 = new javax.swing.JPanel();
        sepCandyDecision = new javax.swing.JSeparator();
        panCapsuleCandyDecision = new javax.swing.JPanel();
        btnCandyDecision = new javax.swing.JButton();
        sepCinemaDecision = new javax.swing.JSeparator();
        panCapsuleCinemaDecision = new javax.swing.JPanel();
        btnCinemaDecision = new javax.swing.JButton();
        sepTittleOption2 = new javax.swing.JSeparator();
        lblTittleOption2 = new javax.swing.JLabel();
        panCandySell = new javax.swing.JPanel();
        btnBackToTicketDecision1 = new javax.swing.JButton();
        sepCandySellTittle = new javax.swing.JSeparator();
        lblCandySellTittle = new javax.swing.JLabel();
        lblSucursalNameCandySell = new javax.swing.JLabel();
        txtIdClientCandySell = new javax.swing.JTextField();
        lblCandySeller = new javax.swing.JLabel();
        cmbCandySeller = new javax.swing.JComboBox<>();
        lblCandySelection = new javax.swing.JLabel();
        cmbCandySelection = new javax.swing.JComboBox<>();
        lblSubTotalCandySell = new javax.swing.JLabel();
        lblIVACandySell = new javax.swing.JLabel();
        lblTotalCandySell = new javax.swing.JLabel();
        lblCantCandySell = new javax.swing.JLabel();
        spnCantCandySell = new javax.swing.JSpinner();
        lblCandySelection2 = new javax.swing.JLabel();
        panChangeSucursalCandySell = new javax.swing.JPanel();
        btnChangeSucursalCandySell = new javax.swing.JButton();
        panSearchClientCandySell = new javax.swing.JPanel();
        btnSearchClientCandySell = new javax.swing.JButton();
        panAddCandySell = new javax.swing.JPanel();
        btnAddCandySell = new javax.swing.JButton();
        panCandySellClear = new javax.swing.JPanel();
        btnCandySellClear = new javax.swing.JButton();
        panButtonCandySell = new javax.swing.JPanel();
        btnCandySell = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        scpCandyTable = new javax.swing.JScrollPane();
        tblCandy = new javax.swing.JTable();
        txtSubTotalCandy = new javax.swing.JTextField();
        txtIVACandy = new javax.swing.JTextField();
        txtTotalCandy = new javax.swing.JTextField();
        lblClientCedulaCandySell = new javax.swing.JLabel();
        panCinemaSell = new javax.swing.JPanel();
        lblCinemaTickets = new javax.swing.JLabel();
        lblSucursalNameCinemaTickets = new javax.swing.JLabel();
        btnBackToTicketDecision2 = new javax.swing.JButton();
        panChangeSucursalCinemaTickets = new javax.swing.JPanel();
        btnChangeSucursalCinemaTickets = new javax.swing.JButton();
        sepCinemaSellTittle = new javax.swing.JSeparator();
        pgrCinemaTickets = new javax.swing.JProgressBar();
        panStepsCinemaTickets = new javax.swing.JPanel();
        panFirstStepCinemaTickets = new javax.swing.JPanel();
        lblMovieSelector = new javax.swing.JLabel();
        scpMovieSelector = new javax.swing.JScrollPane();
        tblMovieSelector = new javax.swing.JTable();
        lblFunctionSelector = new javax.swing.JLabel();
        scpFunctionSelector = new javax.swing.JScrollPane();
        tblFunctionSelector = new javax.swing.JTable();
        panSecondStepCinemaTickets = new javax.swing.JPanel();
        lblDescAdultTicket = new javax.swing.JLabel();
        lblAmountAdultTicket = new javax.swing.JLabel();
        lblDescKinderTicket = new javax.swing.JLabel();
        lblAmountKinderTicket = new javax.swing.JLabel();
        lblDescChildTicket = new javax.swing.JLabel();
        lblAmountChildTicket = new javax.swing.JLabel();
        lblDescOldTicket = new javax.swing.JLabel();
        lblAmountOldTicket = new javax.swing.JLabel();
        lblSubtotalAdultTicket = new javax.swing.JLabel();
        lblIVAAdultTicket = new javax.swing.JLabel();
        lblTotalAdultTicket = new javax.swing.JLabel();
        lblSubtotalKinderTicket = new javax.swing.JLabel();
        lblIVAKinderTicket = new javax.swing.JLabel();
        lblTotalKinderTicket = new javax.swing.JLabel();
        lblSubtotalChildTicket = new javax.swing.JLabel();
        lblIVAChildTicket = new javax.swing.JLabel();
        lblTotalChildTicket = new javax.swing.JLabel();
        lblSubtotalOldTicket = new javax.swing.JLabel();
        lblIVAOldTicket = new javax.swing.JLabel();
        lblTotalOldTicket = new javax.swing.JLabel();
        lblSubtotalTicket = new javax.swing.JLabel();
        lblIVATicket = new javax.swing.JLabel();
        lblTotalTicket = new javax.swing.JLabel();
        lblSubtotalAmountTicket = new javax.swing.JLabel();
        lblIVAAmountTicket = new javax.swing.JLabel();
        lblTotalAmountTicket = new javax.swing.JLabel();
        lblSubtotalAmountAdultTicket = new javax.swing.JLabel();
        lblIVAAmountAdultTicket = new javax.swing.JLabel();
        lblTotalAmountAdultTicket = new javax.swing.JLabel();
        lblSubtotalAmountKinderTicket = new javax.swing.JLabel();
        lblIVAAmountKinderTicket = new javax.swing.JLabel();
        lblTotalAmountKinderTicket = new javax.swing.JLabel();
        lblSubtotalAmountChildTicket = new javax.swing.JLabel();
        lblIVAAmountChildTicket = new javax.swing.JLabel();
        lblTotalAmountChildTicket = new javax.swing.JLabel();
        lblSubtotalAmountOldTicket = new javax.swing.JLabel();
        lblIVAAmountOldTicket = new javax.swing.JLabel();
        lblTotalAmountOldTicket = new javax.swing.JLabel();
        panButtonBackToSelectorMovie = new javax.swing.JPanel();
        btnBackToSelectorMovie = new javax.swing.JButton();
        panButtonNextStepBuyTicket = new javax.swing.JPanel();
        btnNextStepBuyTicket = new javax.swing.JButton();
        lblPriceTicketAdult = new javax.swing.JLabel();
        lblPriceTicketKinder = new javax.swing.JLabel();
        lblPriceTicketChild = new javax.swing.JLabel();
        lblPriceTicketOld = new javax.swing.JLabel();
        btnAddCinemaTickets1 = new javax.swing.JButton();
        btnMinusCinemaTickets1 = new javax.swing.JButton();
        lblCantCinemaTickets1 = new javax.swing.JLabel();
        lblCantCinemaTickets2 = new javax.swing.JLabel();
        btnAddCinemaTickets2 = new javax.swing.JButton();
        btnMinusCinemaTickets2 = new javax.swing.JButton();
        lblCantCinemaTickets3 = new javax.swing.JLabel();
        btnAddCinemaTickets3 = new javax.swing.JButton();
        btnMinusCinemaTickets3 = new javax.swing.JButton();
        lblCantCinemaTickets4 = new javax.swing.JLabel();
        btnAddCinemaTickets4 = new javax.swing.JButton();
        btnMinusCinemaTickets4 = new javax.swing.JButton();
        panThirdStepCinemaTickets = new javax.swing.JPanel();
        panSelectorSeats = new javax.swing.JPanel();
        panTheaterSeatChart = new javax.swing.JPanel();
        btnSeatsClear = new javax.swing.JButton();
        btnBackToCantCinemaTickets = new javax.swing.JButton();
        btnFourthStepCinemaTickets = new javax.swing.JButton();
        lblTotalSeats = new javax.swing.JLabel();
        lblFreeSeats = new javax.swing.JLabel();
        lblSelectedSeats = new javax.swing.JLabel();
        lblCantSeatsToSelect = new javax.swing.JLabel();
        lblTittleSelectorSeat = new javax.swing.JLabel();
        lblTotalSeatsCant = new javax.swing.JLabel();
        lblFreeSeatsCant = new javax.swing.JLabel();
        lblSelectedSeatsCant = new javax.swing.JLabel();
        lblCantSeatsToSelectNumber = new javax.swing.JLabel();
        panFourthStepCinemaTickets = new javax.swing.JPanel();
        txtIdClientCinemaSell = new javax.swing.JTextField();
        lblCinemaSeller = new javax.swing.JLabel();
        cmbCinemaSeller = new javax.swing.JComboBox<>();
        lblSubTotalCinemaSell = new javax.swing.JLabel();
        lblIVACinemaSell = new javax.swing.JLabel();
        lblTotalCinemaSell = new javax.swing.JLabel();
        lblShowCinemaTickets = new javax.swing.JLabel();
        sepClientCinemaTicket = new javax.swing.JSeparator();
        scpCinemaTicketsTable = new javax.swing.JScrollPane();
        tblCinemaTickets = new javax.swing.JTable();
        txtSubTotalCinema = new javax.swing.JTextField();
        txtIVACinema = new javax.swing.JTextField();
        txtTotalCinema = new javax.swing.JTextField();
        btnSearchClientCinemaSell = new javax.swing.JButton();
        lblMovieTicket = new javax.swing.JLabel();
        lblMovieTicketSell = new javax.swing.JLabel();
        lblDateOfMovie = new javax.swing.JLabel();
        lblDateOfMovieSell = new javax.swing.JLabel();
        btnCinemaSellBackStep = new javax.swing.JButton();
        btnCinemaSell = new javax.swing.JButton();
        panOption3 = new javax.swing.JPanel();
        panDecisionOption3 = new javax.swing.JPanel();
        lblTittleOption4 = new javax.swing.JLabel();
        sepTittleOption3 = new javax.swing.JSeparator();
        panCapsuleListClientDecision = new javax.swing.JPanel();
        btnListClientDecision = new javax.swing.JButton();
        panCapsuleListEmployeeDecision = new javax.swing.JPanel();
        btnListEmployeeDecision = new javax.swing.JButton();
        panCapsuleListPeliculasDecision = new javax.swing.JPanel();
        btnListPeliculasDecision = new javax.swing.JButton();
        sepBranchDecision3 = new javax.swing.JSeparator();
        sepCinemaRoomDecision3 = new javax.swing.JSeparator();
        sepCinemaRoomDecision4 = new javax.swing.JSeparator();
        sepCinemaRoomDecision5 = new javax.swing.JSeparator();
        panListClientDecision = new javax.swing.JPanel();
        lblTittleOption5 = new javax.swing.JLabel();
        sepTittleOption4 = new javax.swing.JSeparator();
        panButtonListClient = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panListClientDecision1 = new javax.swing.JPanel();
        btnListClientDecision1 = new javax.swing.JButton();
        btnListClientDecision2 = new javax.swing.JButton();
        btnListClientDecision3 = new javax.swing.JButton();
        panListPeliculaDecision = new javax.swing.JPanel();
        lblTittleOption6 = new javax.swing.JLabel();
        sepTittleOption5 = new javax.swing.JSeparator();
        panButtonListPeliculas2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panListPeliculasDecision3 = new javax.swing.JPanel();
        btnListPelculasGeneral = new javax.swing.JButton();
        btnListPeliculasXmes = new javax.swing.JButton();
        panListEmployeeDecision = new javax.swing.JPanel();
        lblTittleOption9 = new javax.swing.JLabel();
        sepTittleOption6 = new javax.swing.JSeparator();
        panButtonListEmployee = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panListEmployeeDecision1 = new javax.swing.JPanel();
        btnListEmployeeDecision1 = new javax.swing.JButton();
        btnListEmployeeDecision2 = new javax.swing.JButton();
        panOption4 = new javax.swing.JPanel();
        panDecisionOption4 = new javax.swing.JPanel();
        lblEmployeeeDecision = new javax.swing.JLabel();
        sepTittleOption7 = new javax.swing.JSeparator();
        panCapsuleEmployeeDecision = new javax.swing.JPanel();
        btnEmployeeDecision = new javax.swing.JButton();
        sepBranchDecision1 = new javax.swing.JSeparator();
        panCapsuleUserDecision = new javax.swing.JPanel();
        btnUserDecision = new javax.swing.JButton();
        sepCinemaRoomDecision1 = new javax.swing.JSeparator();
        panOption5 = new javax.swing.JPanel();
        panDecisionOption5 = new javax.swing.JPanel();
        lblTittleOption7 = new javax.swing.JLabel();
        sepTittleOption8 = new javax.swing.JSeparator();
        panCapsuleBranchDecision = new javax.swing.JPanel();
        btnBranchDecision = new javax.swing.JButton();
        sepBranchDecision = new javax.swing.JSeparator();
        panCapsuleCinemaRoomDecision = new javax.swing.JPanel();
        btnCinemaRoomDecision = new javax.swing.JButton();
        sepCinemaRoomDecision = new javax.swing.JSeparator();
        panCapsuleEnterpriseDecision = new javax.swing.JPanel();
        btnEnterpriseDecision = new javax.swing.JButton();
        sepEnterpriseDecision = new javax.swing.JSeparator();
        panCapsuleCandyInventory = new javax.swing.JPanel();
        btnCandyInventory = new javax.swing.JButton();
        panCapsuleCandyInventory2 = new javax.swing.JPanel();
        btnFunction = new javax.swing.JButton();
        panOption6 = new javax.swing.JPanel();
        panDecisionOption6 = new javax.swing.JPanel();
        lblTittleOption8 = new javax.swing.JLabel();
        sepTittleOption9 = new javax.swing.JSeparator();
        panCapsuleFilmDecision = new javax.swing.JPanel();
        btnFilmDecision = new javax.swing.JButton();
        sepBranchDecision2 = new javax.swing.JSeparator();
        panCapsuleCandyDecisionCL = new javax.swing.JPanel();
        btnCandyDecisionCL = new javax.swing.JButton();
        sepCinemaRoomDecision2 = new javax.swing.JSeparator();
        panCapsuleClientDecision = new javax.swing.JPanel();
        btnClientDecision = new javax.swing.JButton();
        sepEnterpriseDecision1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panMainPage.setBackground(new java.awt.Color(249, 249, 249));
        panMainPage.setPreferredSize(new java.awt.Dimension(1030, 630));
        panMainPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panTopBar.setBackground(new java.awt.Color(249, 249, 249));
        panTopBar.setPreferredSize(new java.awt.Dimension(1030, 40));
        panTopBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panTopBarMouseDragged(evt);
            }
        });
        panTopBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panTopBarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panTopBarMouseReleased(evt);
            }
        });

        panTopBarLateralMenu.setBackground(new java.awt.Color(239, 232, 244));
        panTopBarLateralMenu.setPreferredSize(new java.awt.Dimension(320, 40));

        javax.swing.GroupLayout panTopBarLateralMenuLayout = new javax.swing.GroupLayout(panTopBarLateralMenu);
        panTopBarLateralMenu.setLayout(panTopBarLateralMenuLayout);
        panTopBarLateralMenuLayout.setHorizontalGroup(
            panTopBarLateralMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        panTopBarLateralMenuLayout.setVerticalGroup(
            panTopBarLateralMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        panButtonsTopBar.setBackground(new java.awt.Color(249, 249, 249));
        panButtonsTopBar.setPreferredSize(new java.awt.Dimension(215, 40));

        btnOut.setBackground(new java.awt.Color(249, 249, 249));
        btnOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/signOffIcon-24px.png"))); // NOI18N
        btnOut.setToolTipText("Cerrar Sesión");
        btnOut.setBorder(null);
        btnOut.setBorderPainted(false);
        btnOut.setContentAreaFilled(false);
        btnOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOut.setFocusPainted(false);
        btnOut.setOpaque(true);
        btnOut.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnOutMouseMoved(evt);
            }
        });
        btnOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOutMouseExited(evt);
            }
        });

        btnMin.setBackground(new java.awt.Color(249, 249, 249));
        btnMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/expandArrow(Gray)-32px.png"))); // NOI18N
        btnMin.setToolTipText("Minimizar");
        btnMin.setBorder(null);
        btnMin.setBorderPainted(false);
        btnMin.setContentAreaFilled(false);
        btnMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMin.setFocusPainted(false);
        btnMin.setOpaque(true);
        btnMin.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnMinMouseMoved(evt);
            }
        });
        btnMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinMouseExited(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(249, 249, 249));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/multiply(Red)-32px.png"))); // NOI18N
        btnExit.setToolTipText("Cerrar");
        btnExit.setBorder(null);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setFocusPainted(false);
        btnExit.setOpaque(true);
        btnExit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnExitMouseMoved(evt);
            }
        });
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panButtonsTopBarLayout = new javax.swing.GroupLayout(panButtonsTopBar);
        panButtonsTopBar.setLayout(panButtonsTopBarLayout);
        panButtonsTopBarLayout.setHorizontalGroup(
            panButtonsTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panButtonsTopBarLayout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(btnOut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addGap(14, 14, 14))
        );
        panButtonsTopBarLayout.setVerticalGroup(
            panButtonsTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panButtonsTopBarLayout.createSequentialGroup()
                .addGroup(panButtonsTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panTopBarLayout = new javax.swing.GroupLayout(panTopBar);
        panTopBar.setLayout(panTopBarLayout);
        panTopBarLayout.setHorizontalGroup(
            panTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTopBarLayout.createSequentialGroup()
                .addComponent(panTopBarLateralMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 495, Short.MAX_VALUE)
                .addComponent(panButtonsTopBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panTopBarLayout.setVerticalGroup(
            panTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTopBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panTopBarLateralMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panButtonsTopBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panMainPage.add(panTopBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panLateralMenu.setBackground(new java.awt.Color(239, 232, 244));

        lblCDVlogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCDVlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/CDV-logo2.png"))); // NOI18N
        lblCDVlogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        sepLateralMenu.setBackground(new java.awt.Color(239, 232, 244));
        sepLateralMenu.setForeground(new java.awt.Color(75, 0, 145));

        lblADCmark.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblADCmark.setForeground(new java.awt.Color(204, 204, 204));
        lblADCmark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/ADC-icon-small.png"))); // NOI18N
        lblADCmark.setText("ADC Corporation. 2020-I");

        panLateralOptions.setBackground(new java.awt.Color(239, 232, 244));

        btnOptionLateral1.setBackground(new java.awt.Color(239, 232, 244));
        btnOptionLateral1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnOptionLateral1.setForeground(new java.awt.Color(66, 0, 124));
        btnOptionLateral1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/homeIcon.png"))); // NOI18N
        btnOptionLateral1.setText("Inicio");
        btnOptionLateral1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnOptionLateral1.setContentAreaFilled(false);
        btnOptionLateral1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOptionLateral1.setDefaultCapable(false);
        btnOptionLateral1.setFocusPainted(false);
        btnOptionLateral1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnOptionLateral1.setIconTextGap(15);
        btnOptionLateral1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnOptionLateral1MouseMoved(evt);
            }
        });
        btnOptionLateral1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOptionLateral1MouseExited(evt);
            }
        });

        btnOptionLateral2.setBackground(new java.awt.Color(239, 232, 244));
        btnOptionLateral2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnOptionLateral2.setForeground(new java.awt.Color(66, 0, 124));
        btnOptionLateral2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/buyIcon.png"))); // NOI18N
        btnOptionLateral2.setText("Ventas");
        btnOptionLateral2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnOptionLateral2.setContentAreaFilled(false);
        btnOptionLateral2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOptionLateral2.setDefaultCapable(false);
        btnOptionLateral2.setFocusPainted(false);
        btnOptionLateral2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnOptionLateral2.setIconTextGap(15);
        btnOptionLateral2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnOptionLateral2MouseMoved(evt);
            }
        });
        btnOptionLateral2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOptionLateral2MouseExited(evt);
            }
        });

        btnOptionLateral3.setBackground(new java.awt.Color(239, 232, 244));
        btnOptionLateral3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnOptionLateral3.setForeground(new java.awt.Color(66, 0, 124));
        btnOptionLateral3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/taskIcon.png"))); // NOI18N
        btnOptionLateral3.setText("Reportes");
        btnOptionLateral3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnOptionLateral3.setContentAreaFilled(false);
        btnOptionLateral3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOptionLateral3.setDefaultCapable(false);
        btnOptionLateral3.setFocusPainted(false);
        btnOptionLateral3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnOptionLateral3.setIconTextGap(15);
        btnOptionLateral3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnOptionLateral3MouseMoved(evt);
            }
        });
        btnOptionLateral3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOptionLateral3MouseExited(evt);
            }
        });

        btnOptionLateral4.setBackground(new java.awt.Color(239, 232, 244));
        btnOptionLateral4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnOptionLateral4.setForeground(new java.awt.Color(66, 0, 124));
        btnOptionLateral4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/employedIcon.png"))); // NOI18N
        btnOptionLateral4.setText("Empleados");
        btnOptionLateral4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnOptionLateral4.setContentAreaFilled(false);
        btnOptionLateral4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOptionLateral4.setDefaultCapable(false);
        btnOptionLateral4.setFocusPainted(false);
        btnOptionLateral4.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnOptionLateral4.setIconTextGap(15);
        btnOptionLateral4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnOptionLateral4MouseMoved(evt);
            }
        });
        btnOptionLateral4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOptionLateral4MouseExited(evt);
            }
        });

        btnOptionLateral5.setBackground(new java.awt.Color(239, 232, 244));
        btnOptionLateral5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnOptionLateral5.setForeground(new java.awt.Color(66, 0, 124));
        btnOptionLateral5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/shopIcon.png"))); // NOI18N
        btnOptionLateral5.setText("Sucursales");
        btnOptionLateral5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnOptionLateral5.setContentAreaFilled(false);
        btnOptionLateral5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOptionLateral5.setDefaultCapable(false);
        btnOptionLateral5.setFocusPainted(false);
        btnOptionLateral5.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnOptionLateral5.setIconTextGap(15);
        btnOptionLateral5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnOptionLateral5MouseMoved(evt);
            }
        });
        btnOptionLateral5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOptionLateral5MouseExited(evt);
            }
        });

        btnOptionLateral6.setBackground(new java.awt.Color(239, 232, 244));
        btnOptionLateral6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnOptionLateral6.setForeground(new java.awt.Color(66, 0, 124));
        btnOptionLateral6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/settingsIcono.png"))); // NOI18N
        btnOptionLateral6.setText("Configuración");
        btnOptionLateral6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnOptionLateral6.setContentAreaFilled(false);
        btnOptionLateral6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOptionLateral6.setDefaultCapable(false);
        btnOptionLateral6.setFocusPainted(false);
        btnOptionLateral6.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnOptionLateral6.setIconTextGap(15);
        btnOptionLateral6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnOptionLateral6MouseMoved(evt);
            }
        });
        btnOptionLateral6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOptionLateral6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panLateralOptionsLayout = new javax.swing.GroupLayout(panLateralOptions);
        panLateralOptions.setLayout(panLateralOptionsLayout);
        panLateralOptionsLayout.setHorizontalGroup(
            panLateralOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnOptionLateral1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOptionLateral2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOptionLateral3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOptionLateral4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOptionLateral5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOptionLateral6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panLateralOptionsLayout.setVerticalGroup(
            panLateralOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLateralOptionsLayout.createSequentialGroup()
                .addComponent(btnOptionLateral1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOptionLateral2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOptionLateral3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOptionLateral4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOptionLateral5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOptionLateral6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panLateralMenuLayout = new javax.swing.GroupLayout(panLateralMenu);
        panLateralMenu.setLayout(panLateralMenuLayout);
        panLateralMenuLayout.setHorizontalGroup(
            panLateralMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCDVlogo, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
            .addComponent(sepLateralMenu, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panLateralMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblADCmark, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(panLateralOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panLateralMenuLayout.setVerticalGroup(
            panLateralMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLateralMenuLayout.createSequentialGroup()
                .addComponent(lblCDVlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepLateralMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panLateralOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lblADCmark, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panMainPage.add(panLateralMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 320, 590));

        panMainMenu.setBackground(new java.awt.Color(249, 249, 249));

        panContent.setBackground(new java.awt.Color(249, 249, 249));
        panContent.setPreferredSize(new java.awt.Dimension(685, 550));
        panContent.setLayout(new java.awt.CardLayout());

        panOption1.setBackground(new java.awt.Color(249, 249, 249));
        panOption1.setPreferredSize(new java.awt.Dimension(685, 477));

        lblTittleOption1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTittleOption1.setForeground(new java.awt.Color(28, 0, 63));
        lblTittleOption1.setText("Inicio");
        lblTittleOption1.setToolTipText("");

        sepTittleOption1.setBackground(new java.awt.Color(249, 249, 249));
        sepTittleOption1.setForeground(new java.awt.Color(239, 232, 244));

        scpBodyOption1.setBackground(new java.awt.Color(249, 249, 249));
        scpBodyOption1.setBorder(null);
        scpBodyOption1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scpBodyOption1.setAutoscrolls(true);
        scpBodyOption1.setPreferredSize(new java.awt.Dimension(685, 477));

        panBodyOptions1.setBackground(new java.awt.Color(249, 249, 249));
        panBodyOptions1.setMinimumSize(new java.awt.Dimension(685, 1572));
        panBodyOptions1.setPreferredSize(new java.awt.Dimension(685, 1572));

        sepBodyOption1.setForeground(new java.awt.Color(75, 0, 145));
        sepBodyOption1.setMinimumSize(new java.awt.Dimension(50, 5));
        sepBodyOption1.setPreferredSize(new java.awt.Dimension(50, 5));

        panBodyOption1.setBackground(new java.awt.Color(249, 249, 249));
        panBodyOption1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panBodyOption1.setForeground(new java.awt.Color(249, 249, 249));
        panBodyOption1.setToolTipText("");
        panBodyOption1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panBodyOption1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panBodyOption1MouseMoved(evt);
            }
        });
        panBodyOption1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panBodyOption1MouseExited(evt);
            }
        });

        btnBodyOption1.setBackground(new java.awt.Color(249, 249, 249));
        btnBodyOption1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBodyOption1.setForeground(new java.awt.Color(51, 51, 51));
        btnBodyOption1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/CDV-icono.png"))); // NOI18N
        btnBodyOption1.setText("<html><b><p align = 'center'><FONT SIZE=5>¿Quiénes somos?</font></p></b><br><p align = 'justify'>La empresa “Cines de Venezuela” es una red de cines dispersa a lo largo de todo el país, teniendo sucursales en todas las ciudades, ofreciendo las películas más recientes y aclamadas en el campo del entretenimiento, satisfaciendo así los gustos de todos sus clientes.</p></html>");
        btnBodyOption1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 32, 1, 32));
        btnBodyOption1.setBorderPainted(false);
        btnBodyOption1.setContentAreaFilled(false);
        btnBodyOption1.setFocusPainted(false);
        btnBodyOption1.setIconTextGap(50);
        btnBodyOption1.setRequestFocusEnabled(false);
        btnBodyOption1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBodyOption1MouseMoved(evt);
            }
        });
        btnBodyOption1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBodyOption1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panBodyOption1Layout = new javax.swing.GroupLayout(panBodyOption1);
        panBodyOption1.setLayout(panBodyOption1Layout);
        panBodyOption1Layout.setHorizontalGroup(
            panBodyOption1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBodyOption1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panBodyOption1Layout.setVerticalGroup(
            panBodyOption1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBodyOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        sepBodyOption2.setForeground(new java.awt.Color(75, 0, 145));

        panBodyOption2.setBackground(new java.awt.Color(249, 249, 249));
        panBodyOption2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panBodyOption2.setForeground(new java.awt.Color(249, 249, 249));
        panBodyOption2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panBodyOption2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panBodyOption2MouseMoved(evt);
            }
        });
        panBodyOption2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panBodyOption2MouseExited(evt);
            }
        });

        btnBodyOption2.setBackground(new java.awt.Color(249, 249, 249));
        btnBodyOption2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBodyOption2.setForeground(new java.awt.Color(51, 51, 51));
        btnBodyOption2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/ticketsIcon-medium.png"))); // NOI18N
        btnBodyOption2.setText("<html><b><p align = 'center'><FONT SIZE=5>Ventas rápidas</font></p></b><br><p align = 'justify'>\"Cines de Venezuela\" realiza sus ventas por medio de tickets, tanto para las funciones que ofrece como para la venta de golosinas. Para el caso de los tickets de golosina, se dispone de un ticket personalizado para el cliente.</p></html>");
        btnBodyOption2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 32, 1, 56));
        btnBodyOption2.setBorderPainted(false);
        btnBodyOption2.setContentAreaFilled(false);
        btnBodyOption2.setFocusPainted(false);
        btnBodyOption2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnBodyOption2.setIconTextGap(50);
        btnBodyOption2.setRequestFocusEnabled(false);
        btnBodyOption2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBodyOption2MouseMoved(evt);
            }
        });
        btnBodyOption2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBodyOption2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panBodyOption2Layout = new javax.swing.GroupLayout(panBodyOption2);
        panBodyOption2.setLayout(panBodyOption2Layout);
        panBodyOption2Layout.setHorizontalGroup(
            panBodyOption2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBodyOption2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panBodyOption2Layout.setVerticalGroup(
            panBodyOption2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBodyOption2, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );

        sepBodyOption3.setForeground(new java.awt.Color(75, 0, 145));

        panBodyOption3.setBackground(new java.awt.Color(249, 249, 249));
        panBodyOption3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panBodyOption3.setForeground(new java.awt.Color(249, 249, 249));
        panBodyOption3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnBodyOption3.setBackground(new java.awt.Color(249, 249, 249));
        btnBodyOption3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBodyOption3.setForeground(new java.awt.Color(51, 51, 51));
        btnBodyOption3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/documentIcon-medium.png"))); // NOI18N
        btnBodyOption3.setText("<html><b><p align = 'center'><FONT SIZE=5>Visualiza reportes actualizados</font></p></b><br><p align = 'justify'>¿Necesitas conocer las películas proyectadas en el último mes? ¿saber cuáles fueron los clientes más frecuentes? ¿Estar al tanto de los ingresos obtenidos? Visualiza esta información de manera rápida y sencilla.</p></html>");
        btnBodyOption3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 56, 1, 32));
        btnBodyOption3.setBorderPainted(false);
        btnBodyOption3.setContentAreaFilled(false);
        btnBodyOption3.setFocusPainted(false);
        btnBodyOption3.setIconTextGap(50);
        btnBodyOption3.setRequestFocusEnabled(false);
        btnBodyOption3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBodyOption3MouseMoved(evt);
            }
        });
        btnBodyOption3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBodyOption3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panBodyOption3Layout = new javax.swing.GroupLayout(panBodyOption3);
        panBodyOption3.setLayout(panBodyOption3Layout);
        panBodyOption3Layout.setHorizontalGroup(
            panBodyOption3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBodyOption3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panBodyOption3Layout.setVerticalGroup(
            panBodyOption3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBodyOption3, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );

        sepBodyOption4.setForeground(new java.awt.Color(75, 0, 145));

        panBodyOption4.setBackground(new java.awt.Color(249, 249, 249));
        panBodyOption4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panBodyOption4.setForeground(new java.awt.Color(249, 249, 249));
        panBodyOption4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnBodyOption4.setBackground(new java.awt.Color(249, 249, 249));
        btnBodyOption4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBodyOption4.setForeground(new java.awt.Color(51, 51, 51));
        btnBodyOption4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/employedIcon-medium.png"))); // NOI18N
        btnBodyOption4.setText("<html><b><p align = 'center'><FONT SIZE=5>Administra a los empleados</font></p></b><br><p align = 'justify'>Gestiona en tiempo real la información de todos los empleados que laboran para \"Cines de Venezuela\" en cualquiera de sus sucursales de manera práctica y sin complicaciones.</p></html>");
        btnBodyOption4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 32, 1, 56));
        btnBodyOption4.setBorderPainted(false);
        btnBodyOption4.setContentAreaFilled(false);
        btnBodyOption4.setFocusPainted(false);
        btnBodyOption4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnBodyOption4.setIconTextGap(50);
        btnBodyOption4.setRequestFocusEnabled(false);
        btnBodyOption4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBodyOption4MouseMoved(evt);
            }
        });
        btnBodyOption4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBodyOption4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panBodyOption4Layout = new javax.swing.GroupLayout(panBodyOption4);
        panBodyOption4.setLayout(panBodyOption4Layout);
        panBodyOption4Layout.setHorizontalGroup(
            panBodyOption4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBodyOption4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panBodyOption4Layout.setVerticalGroup(
            panBodyOption4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBodyOption4, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );

        sepBodyOption5.setForeground(new java.awt.Color(75, 0, 145));

        panBodyOption5.setBackground(new java.awt.Color(249, 249, 249));
        panBodyOption5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panBodyOption5.setForeground(new java.awt.Color(249, 249, 249));
        panBodyOption5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnBodyOption5.setBackground(new java.awt.Color(249, 249, 249));
        btnBodyOption5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBodyOption5.setForeground(new java.awt.Color(51, 51, 51));
        btnBodyOption5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/shopIcon-medium.png"))); // NOI18N
        btnBodyOption5.setText("<html><b><p align = 'center'><FONT SIZE=5>Dirige las sucursales</font></p></b><br><p align = 'justify'>Administra las sucursales que dispone “Cines de Venezuela” y la información que las concierne como sus horarios de trabajo, golosinas disponibles para la venta, películas a proyectar, entre otros datos.</p></html>");
        btnBodyOption5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 56, 1, 32));
        btnBodyOption5.setBorderPainted(false);
        btnBodyOption5.setContentAreaFilled(false);
        btnBodyOption5.setFocusPainted(false);
        btnBodyOption5.setIconTextGap(50);
        btnBodyOption5.setRequestFocusEnabled(false);
        btnBodyOption5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBodyOption5MouseMoved(evt);
            }
        });
        btnBodyOption5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBodyOption5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panBodyOption5Layout = new javax.swing.GroupLayout(panBodyOption5);
        panBodyOption5.setLayout(panBodyOption5Layout);
        panBodyOption5Layout.setHorizontalGroup(
            panBodyOption5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBodyOption5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panBodyOption5Layout.setVerticalGroup(
            panBodyOption5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBodyOption5, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );

        sepBodyOption6.setForeground(new java.awt.Color(75, 0, 145));

        panBodyOption6.setBackground(new java.awt.Color(249, 249, 249));
        panBodyOption6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panBodyOption6.setForeground(new java.awt.Color(249, 249, 249));
        panBodyOption6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panBodyOption6.setPreferredSize(new java.awt.Dimension(413, 200));

        btnBodyOption6.setBackground(new java.awt.Color(249, 249, 249));
        btnBodyOption6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBodyOption6.setForeground(new java.awt.Color(51, 51, 51));
        btnBodyOption6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/syncIcon-medium.png"))); // NOI18N
        btnBodyOption6.setText("<html><b><p align = 'center'><FONT SIZE=5>Aplica tus gustos</font></p></b><br><p align = 'justify'> Selecciona las características que faciliten la navegación dentro de la aplicación según tus propios gustos.</p></html>");
        btnBodyOption6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 32, 1, 56));
        btnBodyOption6.setBorderPainted(false);
        btnBodyOption6.setContentAreaFilled(false);
        btnBodyOption6.setFocusPainted(false);
        btnBodyOption6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnBodyOption6.setIconTextGap(50);
        btnBodyOption6.setRequestFocusEnabled(false);
        btnBodyOption6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBodyOption6MouseMoved(evt);
            }
        });
        btnBodyOption6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBodyOption6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panBodyOption6Layout = new javax.swing.GroupLayout(panBodyOption6);
        panBodyOption6.setLayout(panBodyOption6Layout);
        panBodyOption6Layout.setHorizontalGroup(
            panBodyOption6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBodyOption6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panBodyOption6Layout.setVerticalGroup(
            panBodyOption6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBodyOption6, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );

        sepBodyOption7.setForeground(new java.awt.Color(75, 0, 145));

        panBodyOption7.setBackground(new java.awt.Color(249, 249, 249));
        panBodyOption7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panBodyOption7.setForeground(new java.awt.Color(249, 249, 249));

        btnBodyOption7.setBackground(new java.awt.Color(249, 249, 249));
        btnBodyOption7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBodyOption7.setForeground(new java.awt.Color(51, 51, 51));
        btnBodyOption7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/ACDIcon-medium.png"))); // NOI18N
        btnBodyOption7.setText("<html><br><b><p align = 'center'><FONT SIZE=5>ADC Corporation</font></p></b><br> <p aling='justify'> <b>Ingeniería en Informática <br>=><i> Laboratorio I.</b> Sección 1:</i> <br>  <table class=\"egt\">  <tr>  <td>Brizuela Yurisbellys</td> <td>C.I.: 27.142.239</td>  </tr>  <tr>  <td>Miranda Marihec</td> <td>C.I.: 26.120.075</td>  </tr>  <tr>  <td>Montero Michael</td> <td>C.I.: 26.561.077</td>  </tr>  <tr>  <td>Rivero Gustavo</td> <td>C.I.: 26.772.857</td>  </tr>  <tr>  <td>Torrealba Luis</td> <td>C.I.: 26.121.249</td>  </tr>  </table>  </p> <br>  </html> ");
        btnBodyOption7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 56, 1, 32));
        btnBodyOption7.setBorderPainted(false);
        btnBodyOption7.setContentAreaFilled(false);
        btnBodyOption7.setFocusPainted(false);
        btnBodyOption7.setIconTextGap(150);
        btnBodyOption7.setRequestFocusEnabled(false);
        btnBodyOption7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBodyOption7MouseMoved(evt);
            }
        });
        btnBodyOption7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBodyOption7MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panBodyOption7Layout = new javax.swing.GroupLayout(panBodyOption7);
        panBodyOption7.setLayout(panBodyOption7Layout);
        panBodyOption7Layout.setHorizontalGroup(
            panBodyOption7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBodyOption7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panBodyOption7Layout.setVerticalGroup(
            panBodyOption7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBodyOption7)
        );

        sepBodyOption8.setForeground(new java.awt.Color(75, 0, 145));

        javax.swing.GroupLayout panBodyOptions1Layout = new javax.swing.GroupLayout(panBodyOptions1);
        panBodyOptions1.setLayout(panBodyOptions1Layout);
        panBodyOptions1Layout.setHorizontalGroup(
            panBodyOptions1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBodyOptions1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panBodyOptions1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sepBodyOption6)
                    .addComponent(sepBodyOption8)
                    .addComponent(panBodyOption7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sepBodyOption7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panBodyOption6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                    .addComponent(panBodyOption5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sepBodyOption5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panBodyOption4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sepBodyOption4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panBodyOption3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sepBodyOption3)
                    .addComponent(sepBodyOption1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panBodyOption2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sepBodyOption2)
                    .addComponent(panBodyOption1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panBodyOptions1Layout.setVerticalGroup(
            panBodyOptions1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBodyOptions1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sepBodyOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(panBodyOption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepBodyOption2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panBodyOption2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepBodyOption3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panBodyOption3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepBodyOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panBodyOption4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepBodyOption5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panBodyOption5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepBodyOption6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panBodyOption6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepBodyOption7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panBodyOption7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepBodyOption8, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        scpBodyOption1.setViewportView(panBodyOptions1);

        javax.swing.GroupLayout panOption1Layout = new javax.swing.GroupLayout(panOption1);
        panOption1.setLayout(panOption1Layout);
        panOption1Layout.setHorizontalGroup(
            panOption1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sepTittleOption1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panOption1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTittleOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(scpBodyOption1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panOption1Layout.setVerticalGroup(
            panOption1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOption1Layout.createSequentialGroup()
                .addComponent(lblTittleOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTittleOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpBodyOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panContent.add(panOption1, "card2");

        panOption2.setBackground(new java.awt.Color(249, 249, 249));
        panOption2.setPreferredSize(new java.awt.Dimension(685, 620));
        panOption2.setLayout(new java.awt.CardLayout());

        panDecisionOption2.setBackground(new java.awt.Color(249, 249, 249));
        panDecisionOption2.setForeground(new java.awt.Color(239, 232, 244));

        sepCandyDecision.setBackground(new java.awt.Color(249, 249, 249));
        sepCandyDecision.setForeground(new java.awt.Color(239, 232, 244));

        panCapsuleCandyDecision.setBackground(new java.awt.Color(249, 249, 249));
        panCapsuleCandyDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panCapsuleCandyDecision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCandyDecision.setBackground(new java.awt.Color(249, 249, 249));
        btnCandyDecision.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCandyDecision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/candyIcon.png"))); // NOI18N
        btnCandyDecision.setText("<html><b><FONT SIZE=4>Tickets para golosinas</Font></b><br><p align=’justify’>Gestiona la venta de las golosinas por medio de tickets únicos y personalizados para cada cliente.</p></html>");
        btnCandyDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnCandyDecision.setBorderPainted(false);
        btnCandyDecision.setContentAreaFilled(false);
        btnCandyDecision.setFocusPainted(false);
        btnCandyDecision.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCandyDecision.setIconTextGap(25);
        btnCandyDecision.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCandyDecisionMouseMoved(evt);
            }
        });
        btnCandyDecision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCandyDecisionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCapsuleCandyDecisionLayout = new javax.swing.GroupLayout(panCapsuleCandyDecision);
        panCapsuleCandyDecision.setLayout(panCapsuleCandyDecisionLayout);
        panCapsuleCandyDecisionLayout.setHorizontalGroup(
            panCapsuleCandyDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCandyDecision, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panCapsuleCandyDecisionLayout.setVerticalGroup(
            panCapsuleCandyDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleCandyDecisionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCandyDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sepCinemaDecision.setBackground(new java.awt.Color(249, 249, 249));
        sepCinemaDecision.setForeground(new java.awt.Color(239, 232, 244));

        panCapsuleCinemaDecision.setBackground(new java.awt.Color(249, 249, 249));
        panCapsuleCinemaDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panCapsuleCinemaDecision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCinemaDecision.setBackground(new java.awt.Color(249, 249, 249));
        btnCinemaDecision.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCinemaDecision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/ticketBuyIcon.png"))); // NOI18N
        btnCinemaDecision.setText("<html><b><FONT SIZE=4>Tickets para funciones</Font></b><br><p align=’justify’>Realiza la venta de los boletos de las funciones disponibles que proporciona la sucursal indicada.</p></html>");
        btnCinemaDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnCinemaDecision.setBorderPainted(false);
        btnCinemaDecision.setContentAreaFilled(false);
        btnCinemaDecision.setFocusPainted(false);
        btnCinemaDecision.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCinemaDecision.setIconTextGap(25);
        btnCinemaDecision.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCinemaDecisionMouseMoved(evt);
            }
        });
        btnCinemaDecision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCinemaDecisionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCapsuleCinemaDecisionLayout = new javax.swing.GroupLayout(panCapsuleCinemaDecision);
        panCapsuleCinemaDecision.setLayout(panCapsuleCinemaDecisionLayout);
        panCapsuleCinemaDecisionLayout.setHorizontalGroup(
            panCapsuleCinemaDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCinemaDecision, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panCapsuleCinemaDecisionLayout.setVerticalGroup(
            panCapsuleCinemaDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleCinemaDecisionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCinemaDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sepTittleOption2.setBackground(new java.awt.Color(249, 249, 249));
        sepTittleOption2.setForeground(new java.awt.Color(239, 232, 244));

        lblTittleOption2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTittleOption2.setForeground(new java.awt.Color(28, 0, 63));
        lblTittleOption2.setText("Ventas");
        lblTittleOption2.setToolTipText("");

        javax.swing.GroupLayout panDecisionOption2Layout = new javax.swing.GroupLayout(panDecisionOption2);
        panDecisionOption2.setLayout(panDecisionOption2Layout);
        panDecisionOption2Layout.setHorizontalGroup(
            panDecisionOption2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sepTittleOption2)
            .addComponent(sepCandyDecision, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(sepCinemaDecision, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panDecisionOption2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDecisionOption2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDecisionOption2Layout.createSequentialGroup()
                        .addGap(0, 51, Short.MAX_VALUE)
                        .addComponent(lblTittleOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panDecisionOption2Layout.createSequentialGroup()
                        .addGroup(panDecisionOption2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panCapsuleCandyDecision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panCapsuleCinemaDecision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panDecisionOption2Layout.setVerticalGroup(
            panDecisionOption2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDecisionOption2Layout.createSequentialGroup()
                .addComponent(lblTittleOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTittleOption2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCapsuleCandyDecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepCandyDecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCapsuleCinemaDecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepCinemaDecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(371, Short.MAX_VALUE))
        );

        panOption2.add(panDecisionOption2, "card2");

        panCandySell.setBackground(new java.awt.Color(249, 249, 249));
        panCandySell.setForeground(new java.awt.Color(239, 232, 244));
        panCandySell.setMaximumSize(new java.awt.Dimension(685, 580));
        panCandySell.setMinimumSize(new java.awt.Dimension(685, 580));
        panCandySell.setPreferredSize(new java.awt.Dimension(685, 580));

        btnBackToTicketDecision1.setBackground(new java.awt.Color(249, 249, 249));
        btnBackToTicketDecision1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBackToTicketDecision1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/backToIcon.png"))); // NOI18N
        btnBackToTicketDecision1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnBackToTicketDecision1.setBorderPainted(false);
        btnBackToTicketDecision1.setContentAreaFilled(false);
        btnBackToTicketDecision1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackToTicketDecision1.setFocusPainted(false);
        btnBackToTicketDecision1.setIconTextGap(25);
        btnBackToTicketDecision1.setOpaque(true);
        btnBackToTicketDecision1.setPreferredSize(null);
        btnBackToTicketDecision1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBackToTicketDecision1MouseMoved(evt);
            }
        });
        btnBackToTicketDecision1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackToTicketDecision1MouseExited(evt);
            }
        });

        sepCandySellTittle.setBackground(new java.awt.Color(249, 249, 249));
        sepCandySellTittle.setForeground(new java.awt.Color(239, 232, 244));

        lblCandySellTittle.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblCandySellTittle.setForeground(new java.awt.Color(28, 0, 63));
        lblCandySellTittle.setText("Ventas de tickets para golosinas");
        lblCandySellTittle.setToolTipText("");

        lblSucursalNameCandySell.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSucursalNameCandySell.setForeground(new java.awt.Color(75, 0, 145));
        lblSucursalNameCandySell.setText("Sucursal ");

        txtIdClientCandySell.setBackground(new java.awt.Color(249, 249, 249));
        txtIdClientCandySell.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIdClientCandySell.setText("Cédula del cliente");
        txtIdClientCandySell.setBorder(null);
        txtIdClientCandySell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdClientCandySellMouseClicked(evt);
            }
        });
        txtIdClientCandySell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdClientCandySellKeyTyped(evt);
            }
        });

        lblCandySeller.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCandySeller.setText("Vendedor:");

        cmbCandySeller.setBackground(new java.awt.Color(249, 249, 249));
        cmbCandySeller.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbCandySeller.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " - Seleccionar - ", "Esteban Dido", "Ana Tomía", "Armando Casas" }));
        cmbCandySeller.setBorder(null);
        cmbCandySeller.setLightWeightPopupEnabled(false);

        lblCandySelection.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCandySelection.setText("Golosina:");

        cmbCandySelection.setBackground(new java.awt.Color(249, 249, 249));
        cmbCandySelection.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbCandySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " - Seleccionar - ", "Flips 200g", "Chocolate Savoy 50g", "Perico 5g" }));
        cmbCandySelection.setBorder(null);

        lblSubTotalCandySell.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSubTotalCandySell.setText("Subtotal: ");

        lblIVACandySell.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblIVACandySell.setText("IVA (16%): ");

        lblTotalCandySell.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTotalCandySell.setText("Total: ");

        lblCantCandySell.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCantCandySell.setText("Cantidad:");

        spnCantCandySell.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        spnCantCandySell.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnCantCandySell.setAutoscrolls(true);
        spnCantCandySell.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        spnCantCandySell.setEditor(new javax.swing.JSpinner.NumberEditor(spnCantCandySell, ""));
        spnCantCandySell.setOpaque(false);

        lblCandySelection2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCandySelection2.setText("Lista de golosinas:");

        panChangeSucursalCandySell.setBackground(new java.awt.Color(249, 249, 249));
        panChangeSucursalCandySell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));

        btnChangeSucursalCandySell.setBackground(new java.awt.Color(249, 249, 249));
        btnChangeSucursalCandySell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/shopIcon.png"))); // NOI18N
        btnChangeSucursalCandySell.setToolTipText("Cambiar Sucursal");
        btnChangeSucursalCandySell.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(249, 249, 249), 1, true));
        btnChangeSucursalCandySell.setBorderPainted(false);
        btnChangeSucursalCandySell.setContentAreaFilled(false);
        btnChangeSucursalCandySell.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChangeSucursalCandySell.setFocusPainted(false);
        btnChangeSucursalCandySell.setPreferredSize(new java.awt.Dimension(50, 50));
        btnChangeSucursalCandySell.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnChangeSucursalCandySellMouseMoved(evt);
            }
        });
        btnChangeSucursalCandySell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnChangeSucursalCandySellMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panChangeSucursalCandySellLayout = new javax.swing.GroupLayout(panChangeSucursalCandySell);
        panChangeSucursalCandySell.setLayout(panChangeSucursalCandySellLayout);
        panChangeSucursalCandySellLayout.setHorizontalGroup(
            panChangeSucursalCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panChangeSucursalCandySellLayout.createSequentialGroup()
                .addComponent(btnChangeSucursalCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panChangeSucursalCandySellLayout.setVerticalGroup(
            panChangeSucursalCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnChangeSucursalCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panSearchClientCandySell.setBackground(new java.awt.Color(249, 249, 249));
        panSearchClientCandySell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        panSearchClientCandySell.setMaximumSize(new java.awt.Dimension(52, 52));
        panSearchClientCandySell.setMinimumSize(new java.awt.Dimension(0, 50));
        panSearchClientCandySell.setPreferredSize(new java.awt.Dimension(52, 52));

        btnSearchClientCandySell.setBackground(new java.awt.Color(249, 249, 249));
        btnSearchClientCandySell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/findUserIcon.png"))); // NOI18N
        btnSearchClientCandySell.setToolTipText(" Buscar");
        btnSearchClientCandySell.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(249, 249, 249), 1, true));
        btnSearchClientCandySell.setBorderPainted(false);
        btnSearchClientCandySell.setContentAreaFilled(false);
        btnSearchClientCandySell.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchClientCandySell.setFocusPainted(false);
        btnSearchClientCandySell.setPreferredSize(new java.awt.Dimension(50, 50));
        btnSearchClientCandySell.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSearchClientCandySellMouseMoved(evt);
            }
        });
        btnSearchClientCandySell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchClientCandySellMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panSearchClientCandySellLayout = new javax.swing.GroupLayout(panSearchClientCandySell);
        panSearchClientCandySell.setLayout(panSearchClientCandySellLayout);
        panSearchClientCandySellLayout.setHorizontalGroup(
            panSearchClientCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSearchClientCandySellLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSearchClientCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panSearchClientCandySellLayout.setVerticalGroup(
            panSearchClientCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSearchClientCandySellLayout.createSequentialGroup()
                .addComponent(btnSearchClientCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panAddCandySell.setBackground(new java.awt.Color(249, 249, 249));
        panAddCandySell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));

        btnAddCandySell.setBackground(new java.awt.Color(249, 249, 249));
        btnAddCandySell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/addIcon.png"))); // NOI18N
        btnAddCandySell.setToolTipText("Agregar");
        btnAddCandySell.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(249, 249, 249), 1, true));
        btnAddCandySell.setBorderPainted(false);
        btnAddCandySell.setContentAreaFilled(false);
        btnAddCandySell.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCandySell.setFocusPainted(false);
        btnAddCandySell.setPreferredSize(new java.awt.Dimension(50, 50));
        btnAddCandySell.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnAddCandySellMouseMoved(evt);
            }
        });
        btnAddCandySell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddCandySellMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panAddCandySellLayout = new javax.swing.GroupLayout(panAddCandySell);
        panAddCandySell.setLayout(panAddCandySellLayout);
        panAddCandySellLayout.setHorizontalGroup(
            panAddCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAddCandySellLayout.createSequentialGroup()
                .addComponent(btnAddCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panAddCandySellLayout.setVerticalGroup(
            panAddCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAddCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panCandySellClear.setBackground(new java.awt.Color(239, 232, 244));
        panCandySellClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));

        btnCandySellClear.setBackground(new java.awt.Color(245, 245, 245));
        btnCandySellClear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCandySellClear.setText("Limpiar");
        btnCandySellClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCandySellClear.setBorderPainted(false);
        btnCandySellClear.setContentAreaFilled(false);
        btnCandySellClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCandySellClear.setFocusPainted(false);
        btnCandySellClear.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCandySellClearMouseMoved(evt);
            }
        });
        btnCandySellClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCandySellClearMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCandySellClearLayout = new javax.swing.GroupLayout(panCandySellClear);
        panCandySellClear.setLayout(panCandySellClearLayout);
        panCandySellClearLayout.setHorizontalGroup(
            panCandySellClearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCandySellClearLayout.createSequentialGroup()
                .addComponent(btnCandySellClear, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panCandySellClearLayout.setVerticalGroup(
            panCandySellClearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCandySellClear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panButtonCandySell.setBackground(new java.awt.Color(239, 232, 244));
        panButtonCandySell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        panButtonCandySell.setForeground(new java.awt.Color(255, 255, 255));

        btnCandySell.setBackground(new java.awt.Color(245, 245, 245));
        btnCandySell.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCandySell.setText("Vender");
        btnCandySell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCandySell.setBorderPainted(false);
        btnCandySell.setContentAreaFilled(false);
        btnCandySell.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCandySell.setFocusPainted(false);
        btnCandySell.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCandySellMouseMoved(evt);
            }
        });
        btnCandySell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCandySellMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panButtonCandySellLayout = new javax.swing.GroupLayout(panButtonCandySell);
        panButtonCandySell.setLayout(panButtonCandySellLayout);
        panButtonCandySellLayout.setHorizontalGroup(
            panButtonCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panButtonCandySellLayout.createSequentialGroup()
                .addComponent(btnCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panButtonCandySellLayout.setVerticalGroup(
            panButtonCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panButtonCandySellLayout.createSequentialGroup()
                .addComponent(btnCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(249, 249, 249));
        jSeparator1.setForeground(new java.awt.Color(75, 0, 145));

        scpCandyTable.setBackground(new java.awt.Color(249, 249, 249));

        tblCandy.setBackground(new java.awt.Color(249, 249, 249));
        tblCandy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Golosina", "Cantidad", "Precio (Unidad)", "IVA (Unidad)", "Monto (Unidad)", "Total", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCandy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblCandy.setSelectionBackground(new java.awt.Color(75, 0, 145));
        tblCandy.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCandy.getTableHeader().setReorderingAllowed(false);
        tblCandy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCandyMouseClicked(evt);
            }
        });
        scpCandyTable.setViewportView(tblCandy);
        if (tblCandy.getColumnModel().getColumnCount() > 0) {
            tblCandy.getColumnModel().getColumn(1).setResizable(false);
            tblCandy.getColumnModel().getColumn(1).setPreferredWidth(56);
            tblCandy.getColumnModel().getColumn(6).setResizable(false);
            tblCandy.getColumnModel().getColumn(6).setPreferredWidth(40);
            tblCandy.getColumnModel().getColumn(7).setResizable(false);
            tblCandy.getColumnModel().getColumn(7).setPreferredWidth(40);
        }

        txtSubTotalCandy.setEditable(false);
        txtSubTotalCandy.setBackground(new java.awt.Color(249, 249, 249));
        txtSubTotalCandy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSubTotalCandy.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtIVACandy.setEditable(false);
        txtIVACandy.setBackground(new java.awt.Color(249, 249, 249));
        txtIVACandy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIVACandy.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtTotalCandy.setEditable(false);
        txtTotalCandy.setBackground(new java.awt.Color(249, 249, 249));
        txtTotalCandy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTotalCandy.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblClientCedulaCandySell.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout panCandySellLayout = new javax.swing.GroupLayout(panCandySell);
        panCandySell.setLayout(panCandySellLayout);
        panCandySellLayout.setHorizontalGroup(
            panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCandySellLayout.createSequentialGroup()
                .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panCandySellLayout.createSequentialGroup()
                        .addComponent(btnBackToTicketDecision1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCandySellTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSucursalNameCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panChangeSucursalCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(panCandySellLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCandySellLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(panCandySellClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panButtonCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panCandySellLayout.createSequentialGroup()
                                .addComponent(lblCandySelection, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCandySelection, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCantCandySell, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                    .addComponent(lblCandySeller, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbCandySeller, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panCandySellLayout.createSequentialGroup()
                                        .addComponent(spnCantCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panAddCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panCandySellLayout.createSequentialGroup()
                                .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panCandySellLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(lblSubTotalCandySell)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSubTotalCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblIVACandySell)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIVACandy, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTotalCandySell)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTotalCandy))
                                    .addGroup(panCandySellLayout.createSequentialGroup()
                                        .addComponent(lblCandySelection2)
                                        .addGap(178, 178, 178)
                                        .addComponent(lblClientCedulaCandySell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panCandySellLayout.createSequentialGroup()
                                        .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtIdClientCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panSearchClientCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(356, 356, 356))
                                    .addComponent(scpCandyTable))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(19, 19, 19))
            .addComponent(sepCandySellTittle)
        );
        panCandySellLayout.setVerticalGroup(
            panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCandySellLayout.createSequentialGroup()
                .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnBackToTicketDecision1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCandySellTittle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                    .addComponent(lblSucursalNameCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panChangeSucursalCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepCandySellTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panSearchClientCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbCandySeller, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addComponent(lblCandySeller, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdClientCandySell, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCantCandySell)
                        .addComponent(cmbCandySelection, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCandySelection, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spnCantCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panAddCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCandySellLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblCandySelection2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCandySellLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblClientCedulaCandySell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpCandyTable, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSubTotalCandy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSubTotalCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTotalCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblIVACandySell, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIVACandy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panButtonCandySell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCandySellClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );

        panSearchClientCandySell.getAccessibleContext().setAccessibleName("");
        panCandySellClear.getAccessibleContext().setAccessibleName("");

        panOption2.add(panCandySell, "card2");

        panCinemaSell.setBackground(new java.awt.Color(249, 249, 249));
        panCinemaSell.setForeground(new java.awt.Color(239, 232, 244));

        lblCinemaTickets.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblCinemaTickets.setForeground(new java.awt.Color(28, 0, 63));
        lblCinemaTickets.setText("Ventas de tickets para golosinas");
        lblCinemaTickets.setToolTipText("");

        lblSucursalNameCinemaTickets.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSucursalNameCinemaTickets.setForeground(new java.awt.Color(75, 0, 145));
        lblSucursalNameCinemaTickets.setText("Sucursal ");

        btnBackToTicketDecision2.setBackground(new java.awt.Color(249, 249, 249));
        btnBackToTicketDecision2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBackToTicketDecision2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/backToIcon.png"))); // NOI18N
        btnBackToTicketDecision2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnBackToTicketDecision2.setBorderPainted(false);
        btnBackToTicketDecision2.setContentAreaFilled(false);
        btnBackToTicketDecision2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackToTicketDecision2.setFocusPainted(false);
        btnBackToTicketDecision2.setIconTextGap(25);
        btnBackToTicketDecision2.setOpaque(true);
        btnBackToTicketDecision2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBackToTicketDecision2MouseMoved(evt);
            }
        });
        btnBackToTicketDecision2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackToTicketDecision2MouseExited(evt);
            }
        });

        panChangeSucursalCinemaTickets.setBackground(new java.awt.Color(249, 249, 249));
        panChangeSucursalCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));

        btnChangeSucursalCinemaTickets.setBackground(new java.awt.Color(249, 249, 249));
        btnChangeSucursalCinemaTickets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/shopIcon.png"))); // NOI18N
        btnChangeSucursalCinemaTickets.setToolTipText("Cambiar Sucursal");
        btnChangeSucursalCinemaTickets.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(249, 249, 249), 1, true));
        btnChangeSucursalCinemaTickets.setBorderPainted(false);
        btnChangeSucursalCinemaTickets.setContentAreaFilled(false);
        btnChangeSucursalCinemaTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChangeSucursalCinemaTickets.setFocusPainted(false);
        btnChangeSucursalCinemaTickets.setPreferredSize(new java.awt.Dimension(50, 50));
        btnChangeSucursalCinemaTickets.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnChangeSucursalCinemaTicketsMouseMoved(evt);
            }
        });
        btnChangeSucursalCinemaTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnChangeSucursalCinemaTicketsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panChangeSucursalCinemaTicketsLayout = new javax.swing.GroupLayout(panChangeSucursalCinemaTickets);
        panChangeSucursalCinemaTickets.setLayout(panChangeSucursalCinemaTicketsLayout);
        panChangeSucursalCinemaTicketsLayout.setHorizontalGroup(
            panChangeSucursalCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panChangeSucursalCinemaTicketsLayout.createSequentialGroup()
                .addComponent(btnChangeSucursalCinemaTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panChangeSucursalCinemaTicketsLayout.setVerticalGroup(
            panChangeSucursalCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnChangeSucursalCinemaTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        sepCinemaSellTittle.setBackground(new java.awt.Color(249, 249, 249));
        sepCinemaSellTittle.setForeground(new java.awt.Color(239, 232, 244));

        pgrCinemaTickets.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pgrCinemaTickets.setForeground(new java.awt.Color(75, 0, 145));
        pgrCinemaTickets.setBorderPainted(false);
        pgrCinemaTickets.setStringPainted(true);

        panStepsCinemaTickets.setBackground(new java.awt.Color(249, 249, 249));
        panStepsCinemaTickets.setLayout(new java.awt.CardLayout());

        panFirstStepCinemaTickets.setBackground(new java.awt.Color(249, 249, 249));

        lblMovieSelector.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMovieSelector.setText("Lista de películas disponibles:");

        scpMovieSelector.setBackground(new java.awt.Color(249, 249, 249));
        scpMovieSelector.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblMovieSelector.setBackground(new java.awt.Color(249, 249, 249));
        tblMovieSelector.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", "", "", "", null}
            },
            new String [] {
                "Poster", "Película", "Sinopsis", "Género", "Censura", "Seleccionar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMovieSelector.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblMovieSelector.setSelectionBackground(new java.awt.Color(75, 0, 145));
        tblMovieSelector.getTableHeader().setReorderingAllowed(false);
        tblMovieSelector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMovieSelectorMouseClicked(evt);
            }
        });
        scpMovieSelector.setViewportView(tblMovieSelector);
        if (tblMovieSelector.getColumnModel().getColumnCount() > 0) {
            tblMovieSelector.getColumnModel().getColumn(0).setResizable(false);
            tblMovieSelector.getColumnModel().getColumn(0).setPreferredWidth(110);
            tblMovieSelector.getColumnModel().getColumn(1).setResizable(false);
            tblMovieSelector.getColumnModel().getColumn(2).setResizable(false);
            tblMovieSelector.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblMovieSelector.getColumnModel().getColumn(3).setResizable(false);
            tblMovieSelector.getColumnModel().getColumn(3).setPreferredWidth(45);
            tblMovieSelector.getColumnModel().getColumn(4).setResizable(false);
            tblMovieSelector.getColumnModel().getColumn(4).setPreferredWidth(35);
            tblMovieSelector.getColumnModel().getColumn(5).setResizable(false);
            tblMovieSelector.getColumnModel().getColumn(5).setPreferredWidth(45);
        }

        lblFunctionSelector.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblFunctionSelector.setText("Lista de funciones disponibles:");

        scpFunctionSelector.setBackground(new java.awt.Color(249, 249, 249));
        scpFunctionSelector.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblFunctionSelector.setBackground(new java.awt.Color(249, 249, 249));
        tblFunctionSelector.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Día", "Sala", "Hora de la función", "Asientos", "Asientos disponibles", "Seleccionar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFunctionSelector.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblFunctionSelector.setSelectionBackground(new java.awt.Color(75, 0, 145));
        tblFunctionSelector.getTableHeader().setReorderingAllowed(false);
        tblFunctionSelector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFunctionSelectorMouseClicked(evt);
            }
        });
        scpFunctionSelector.setViewportView(tblFunctionSelector);
        if (tblFunctionSelector.getColumnModel().getColumnCount() > 0) {
            tblFunctionSelector.getColumnModel().getColumn(0).setResizable(false);
            tblFunctionSelector.getColumnModel().getColumn(0).setPreferredWidth(35);
            tblFunctionSelector.getColumnModel().getColumn(1).setResizable(false);
            tblFunctionSelector.getColumnModel().getColumn(1).setPreferredWidth(35);
            tblFunctionSelector.getColumnModel().getColumn(2).setResizable(false);
            tblFunctionSelector.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblFunctionSelector.getColumnModel().getColumn(3).setResizable(false);
            tblFunctionSelector.getColumnModel().getColumn(3).setPreferredWidth(35);
            tblFunctionSelector.getColumnModel().getColumn(4).setResizable(false);
            tblFunctionSelector.getColumnModel().getColumn(4).setPreferredWidth(80);
            tblFunctionSelector.getColumnModel().getColumn(5).setResizable(false);
            tblFunctionSelector.getColumnModel().getColumn(5).setPreferredWidth(45);
        }

        javax.swing.GroupLayout panFirstStepCinemaTicketsLayout = new javax.swing.GroupLayout(panFirstStepCinemaTickets);
        panFirstStepCinemaTickets.setLayout(panFirstStepCinemaTicketsLayout);
        panFirstStepCinemaTicketsLayout.setHorizontalGroup(
            panFirstStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFirstStepCinemaTicketsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panFirstStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scpFunctionSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panFirstStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblMovieSelector)
                        .addComponent(scpMovieSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFunctionSelector)))
                .addGap(28, 28, 28))
        );
        panFirstStepCinemaTicketsLayout.setVerticalGroup(
            panFirstStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFirstStepCinemaTicketsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblMovieSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpMovieSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFunctionSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpFunctionSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        panStepsCinemaTickets.add(panFirstStepCinemaTickets, "card2");

        panSecondStepCinemaTickets.setBackground(new java.awt.Color(249, 249, 249));

        lblDescAdultTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDescAdultTicket.setText("<html><b>Boletos para adultos</b><br><p align='justify'>Los tickets para funciones de adultos corresponden a personas en una edad comprendida entre 13 años a 59 años.</p></html>");

        lblAmountAdultTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAmountAdultTicket.setText("<html><b>Precio</b> (con IVA):</html>");

        lblDescKinderTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDescKinderTicket.setText("<html><b>Boletos kinder</b><br><p align='justify'>Los tickets para funciones de niños corresponden a personas en una edad comprendida entre 1 año y 4 años.</p></html>");

        lblAmountKinderTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAmountKinderTicket.setText("<html><b>Precio</b> (con IVA):</html>");

        lblDescChildTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDescChildTicket.setText("<html><b>Boletos para niños</b><br><p align='justify'>Los tickets para funciones de niños corresponden a personas en una edad comprendida entre 5 años a 12 años.</p></html>");

        lblAmountChildTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAmountChildTicket.setText("<html><b>Precio</b> (con IVA):</html>");

        lblDescOldTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDescOldTicket.setText("<html><b>Boletos para tercera edad</b><br><p align='justify'>Los tickets para funciones de adultos en tercera edad corresponden a personas en una edad comprendida entre 60 años en adelante.</p></html>");

        lblAmountOldTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAmountOldTicket.setText("<html><b>Precio</b> (con IVA):</html>");

        lblSubtotalAdultTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSubtotalAdultTicket.setText("<html><b>Subtotal: </b></html>");

        lblIVAAdultTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblIVAAdultTicket.setText("<html><b>IVA (16%): </b></html>");

        lblTotalAdultTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTotalAdultTicket.setText("<html><b>Total: </b></html>");

        lblSubtotalKinderTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSubtotalKinderTicket.setText("<html><b>Subtotal: </b></html>");

        lblIVAKinderTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblIVAKinderTicket.setText("<html><b>IVA (16%): </b></html>");

        lblTotalKinderTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTotalKinderTicket.setText("<html><b>Total: </b></html>");

        lblSubtotalChildTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSubtotalChildTicket.setText("<html><b>Subtotal: </b></html>");

        lblIVAChildTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblIVAChildTicket.setText("<html><b>IVA (16%): </b></html>");

        lblTotalChildTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTotalChildTicket.setText("<html><b>Total: </b></html>");

        lblSubtotalOldTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSubtotalOldTicket.setText("<html><b>Subtotal: </b></html>");

        lblIVAOldTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblIVAOldTicket.setText("<html><b>IVA (16%): </b></html>");

        lblTotalOldTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTotalOldTicket.setText("<html><b>Total: </b></html>");

        lblSubtotalTicket.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSubtotalTicket.setText("<html><b>Subtotal: </b></html>");

        lblIVATicket.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblIVATicket.setText("<html><b>IVA (16%): </b></html>");

        lblTotalTicket.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTotalTicket.setText("<html><b>Total: </b></html>");

        lblSubtotalAmountTicket.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSubtotalAmountTicket.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtotalAmountTicket.setText("0.0");

        lblIVAAmountTicket.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblIVAAmountTicket.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIVAAmountTicket.setText("0.0");

        lblTotalAmountTicket.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTotalAmountTicket.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalAmountTicket.setText("0.0");

        lblSubtotalAmountAdultTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSubtotalAmountAdultTicket.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtotalAmountAdultTicket.setText("0.0");

        lblIVAAmountAdultTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblIVAAmountAdultTicket.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIVAAmountAdultTicket.setText("0.0");

        lblTotalAmountAdultTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTotalAmountAdultTicket.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalAmountAdultTicket.setText("0.0");

        lblSubtotalAmountKinderTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSubtotalAmountKinderTicket.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtotalAmountKinderTicket.setText("0.0");

        lblIVAAmountKinderTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblIVAAmountKinderTicket.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIVAAmountKinderTicket.setText("0.0");

        lblTotalAmountKinderTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTotalAmountKinderTicket.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalAmountKinderTicket.setText("0.0");

        lblSubtotalAmountChildTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSubtotalAmountChildTicket.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtotalAmountChildTicket.setText("0.0");

        lblIVAAmountChildTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblIVAAmountChildTicket.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIVAAmountChildTicket.setText("0.0");

        lblTotalAmountChildTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTotalAmountChildTicket.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalAmountChildTicket.setText("0.0");

        lblSubtotalAmountOldTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSubtotalAmountOldTicket.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtotalAmountOldTicket.setText("0.0");

        lblIVAAmountOldTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblIVAAmountOldTicket.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIVAAmountOldTicket.setText("0.0");

        lblTotalAmountOldTicket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTotalAmountOldTicket.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalAmountOldTicket.setText("0.0");

        panButtonBackToSelectorMovie.setBackground(new java.awt.Color(239, 232, 244));
        panButtonBackToSelectorMovie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        panButtonBackToSelectorMovie.setForeground(new java.awt.Color(255, 255, 255));
        panButtonBackToSelectorMovie.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panButtonBackToSelectorMovieMouseMoved(evt);
            }
        });
        panButtonBackToSelectorMovie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panButtonBackToSelectorMovieMouseExited(evt);
            }
        });

        btnBackToSelectorMovie.setBackground(new java.awt.Color(245, 245, 245));
        btnBackToSelectorMovie.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBackToSelectorMovie.setText("Atrás");
        btnBackToSelectorMovie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBackToSelectorMovie.setBorderPainted(false);
        btnBackToSelectorMovie.setContentAreaFilled(false);
        btnBackToSelectorMovie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackToSelectorMovie.setFocusPainted(false);
        btnBackToSelectorMovie.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBackToSelectorMovieMouseMoved(evt);
            }
        });
        btnBackToSelectorMovie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackToSelectorMovieMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panButtonBackToSelectorMovieLayout = new javax.swing.GroupLayout(panButtonBackToSelectorMovie);
        panButtonBackToSelectorMovie.setLayout(panButtonBackToSelectorMovieLayout);
        panButtonBackToSelectorMovieLayout.setHorizontalGroup(
            panButtonBackToSelectorMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBackToSelectorMovie, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );
        panButtonBackToSelectorMovieLayout.setVerticalGroup(
            panButtonBackToSelectorMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBackToSelectorMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panButtonNextStepBuyTicket.setBackground(new java.awt.Color(239, 232, 244));
        panButtonNextStepBuyTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        panButtonNextStepBuyTicket.setForeground(new java.awt.Color(255, 255, 255));
        panButtonNextStepBuyTicket.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panButtonNextStepBuyTicketMouseMoved(evt);
            }
        });
        panButtonNextStepBuyTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panButtonNextStepBuyTicketMouseExited(evt);
            }
        });

        btnNextStepBuyTicket.setBackground(new java.awt.Color(245, 245, 245));
        btnNextStepBuyTicket.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNextStepBuyTicket.setText("Siguiente");
        btnNextStepBuyTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNextStepBuyTicket.setBorderPainted(false);
        btnNextStepBuyTicket.setContentAreaFilled(false);
        btnNextStepBuyTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNextStepBuyTicket.setFocusPainted(false);
        btnNextStepBuyTicket.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnNextStepBuyTicketMouseMoved(evt);
            }
        });
        btnNextStepBuyTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextStepBuyTicketMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panButtonNextStepBuyTicketLayout = new javax.swing.GroupLayout(panButtonNextStepBuyTicket);
        panButtonNextStepBuyTicket.setLayout(panButtonNextStepBuyTicketLayout);
        panButtonNextStepBuyTicketLayout.setHorizontalGroup(
            panButtonNextStepBuyTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNextStepBuyTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        );
        panButtonNextStepBuyTicketLayout.setVerticalGroup(
            panButtonNextStepBuyTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNextStepBuyTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblPriceTicketAdult.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPriceTicketAdult.setText("1.0");

        lblPriceTicketKinder.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPriceTicketKinder.setText("0.5");

        lblPriceTicketChild.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPriceTicketChild.setText("0.7");

        lblPriceTicketOld.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPriceTicketOld.setText("0.7");

        btnAddCinemaTickets1.setBackground(new java.awt.Color(249, 249, 249));
        btnAddCinemaTickets1.setForeground(new java.awt.Color(249, 249, 249));
        btnAddCinemaTickets1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/incorporateIcon-small.png"))); // NOI18N
        btnAddCinemaTickets1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        btnAddCinemaTickets1.setContentAreaFilled(false);
        btnAddCinemaTickets1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCinemaTickets1.setFocusPainted(false);
        btnAddCinemaTickets1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnAddCinemaTickets1MouseMoved(evt);
            }
        });
        btnAddCinemaTickets1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddCinemaTickets1MouseExited(evt);
            }
        });

        btnMinusCinemaTickets1.setBackground(new java.awt.Color(249, 249, 249));
        btnMinusCinemaTickets1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/minusIcon-small.png"))); // NOI18N
        btnMinusCinemaTickets1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        btnMinusCinemaTickets1.setContentAreaFilled(false);
        btnMinusCinemaTickets1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinusCinemaTickets1.setFocusPainted(false);
        btnMinusCinemaTickets1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnMinusCinemaTickets1MouseMoved(evt);
            }
        });
        btnMinusCinemaTickets1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinusCinemaTickets1MouseExited(evt);
            }
        });

        lblCantCinemaTickets1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCantCinemaTickets1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantCinemaTickets1.setText("0");

        lblCantCinemaTickets2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCantCinemaTickets2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantCinemaTickets2.setText("0");

        btnAddCinemaTickets2.setBackground(new java.awt.Color(249, 249, 249));
        btnAddCinemaTickets2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/incorporateIcon-small.png"))); // NOI18N
        btnAddCinemaTickets2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        btnAddCinemaTickets2.setContentAreaFilled(false);
        btnAddCinemaTickets2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCinemaTickets2.setFocusPainted(false);
        btnAddCinemaTickets2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnAddCinemaTickets2MouseMoved(evt);
            }
        });
        btnAddCinemaTickets2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddCinemaTickets2MouseExited(evt);
            }
        });

        btnMinusCinemaTickets2.setBackground(new java.awt.Color(249, 249, 249));
        btnMinusCinemaTickets2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/minusIcon-small.png"))); // NOI18N
        btnMinusCinemaTickets2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        btnMinusCinemaTickets2.setContentAreaFilled(false);
        btnMinusCinemaTickets2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinusCinemaTickets2.setFocusPainted(false);
        btnMinusCinemaTickets2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnMinusCinemaTickets2MouseMoved(evt);
            }
        });
        btnMinusCinemaTickets2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinusCinemaTickets2MouseExited(evt);
            }
        });

        lblCantCinemaTickets3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCantCinemaTickets3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantCinemaTickets3.setText("0");

        btnAddCinemaTickets3.setBackground(new java.awt.Color(249, 249, 249));
        btnAddCinemaTickets3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/incorporateIcon-small.png"))); // NOI18N
        btnAddCinemaTickets3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        btnAddCinemaTickets3.setContentAreaFilled(false);
        btnAddCinemaTickets3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCinemaTickets3.setFocusPainted(false);
        btnAddCinemaTickets3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnAddCinemaTickets3MouseMoved(evt);
            }
        });
        btnAddCinemaTickets3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddCinemaTickets3MouseExited(evt);
            }
        });

        btnMinusCinemaTickets3.setBackground(new java.awt.Color(249, 249, 249));
        btnMinusCinemaTickets3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/minusIcon-small.png"))); // NOI18N
        btnMinusCinemaTickets3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        btnMinusCinemaTickets3.setContentAreaFilled(false);
        btnMinusCinemaTickets3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinusCinemaTickets3.setFocusPainted(false);
        btnMinusCinemaTickets3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnMinusCinemaTickets3MouseMoved(evt);
            }
        });
        btnMinusCinemaTickets3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinusCinemaTickets3MouseExited(evt);
            }
        });

        lblCantCinemaTickets4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCantCinemaTickets4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantCinemaTickets4.setText("0");

        btnAddCinemaTickets4.setBackground(new java.awt.Color(249, 249, 249));
        btnAddCinemaTickets4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/incorporateIcon-small.png"))); // NOI18N
        btnAddCinemaTickets4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        btnAddCinemaTickets4.setContentAreaFilled(false);
        btnAddCinemaTickets4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCinemaTickets4.setFocusPainted(false);
        btnAddCinemaTickets4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnAddCinemaTickets4MouseMoved(evt);
            }
        });
        btnAddCinemaTickets4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddCinemaTickets4MouseExited(evt);
            }
        });

        btnMinusCinemaTickets4.setBackground(new java.awt.Color(249, 249, 249));
        btnMinusCinemaTickets4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/minusIcon-small.png"))); // NOI18N
        btnMinusCinemaTickets4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        btnMinusCinemaTickets4.setContentAreaFilled(false);
        btnMinusCinemaTickets4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinusCinemaTickets4.setFocusPainted(false);
        btnMinusCinemaTickets4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnMinusCinemaTickets4MouseMoved(evt);
            }
        });
        btnMinusCinemaTickets4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinusCinemaTickets4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panSecondStepCinemaTicketsLayout = new javax.swing.GroupLayout(panSecondStepCinemaTickets);
        panSecondStepCinemaTickets.setLayout(panSecondStepCinemaTicketsLayout);
        panSecondStepCinemaTicketsLayout.setHorizontalGroup(
            panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addComponent(panButtonBackToSelectorMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panButtonNextStepBuyTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSubtotalTicket)
                            .addComponent(lblIVATicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalAmountTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIVAAmountTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSubtotalAmountTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                .addComponent(lblAmountOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPriceTicketOld, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblDescAdultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(lblDescOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(lblDescChildTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(lblDescKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                    .addComponent(lblAmountAdultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblPriceTicketAdult, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                    .addComponent(lblAmountKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblPriceTicketKinder, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                    .addComponent(lblAmountChildTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblPriceTicketChild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnMinusCinemaTickets1)
                                    .addComponent(btnAddCinemaTickets1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCantCinemaTickets1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSubtotalAdultTicket)
                                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSubtotalChildTicket)
                                            .addComponent(lblIVAChildTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                            .addComponent(lblTotalChildTicket)))
                                    .addComponent(lblIVAAdultTicket)
                                    .addComponent(lblTotalAdultTicket)
                                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblIVAOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblSubtotalOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTotalOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotalAmountAdultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIVAAmountAdultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSubtotalAmountAdultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSubtotalAmountKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIVAAmountKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTotalAmountKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSubtotalAmountChildTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIVAAmountChildTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTotalAmountChildTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSubtotalAmountOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIVAAmountOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTotalAmountOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11))
                            .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                        .addGap(152, 152, 152)
                                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTotalKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblSubtotalKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblIVAKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                                        .addGap(2, 2, 2)
                                                        .addComponent(btnMinusCinemaTickets2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(btnAddCinemaTickets2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblCantCinemaTickets2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(btnMinusCinemaTickets3, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnAddCinemaTickets3, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblCantCinemaTickets3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnMinusCinemaTickets4)
                                                    .addComponent(btnAddCinemaTickets4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblCantCinemaTickets4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(19, 19, 19))))
        );
        panSecondStepCinemaTicketsLayout.setVerticalGroup(
            panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSubtotalAdultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtotalAmountAdultTicket))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIVAAdultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIVAAmountAdultTicket))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalAdultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalAmountAdultTicket)))
                    .addComponent(lblCantCinemaTickets1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                            .addComponent(btnAddCinemaTickets1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnMinusCinemaTickets1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panSecondStepCinemaTicketsLayout.createSequentialGroup()
                            .addComponent(lblDescAdultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblAmountAdultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPriceTicketAdult)))))
                .addGap(18, 18, 18)
                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSubtotalKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtotalAmountKinderTicket))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIVAAmountKinderTicket)
                            .addComponent(lblIVAKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalAmountKinderTicket)
                            .addComponent(lblTotalKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addComponent(btnAddCinemaTickets2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMinusCinemaTickets2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addComponent(lblDescKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAmountKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPriceTicketKinder)))
                    .addComponent(lblCantCinemaTickets2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSubtotalChildTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtotalAmountChildTicket))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIVAChildTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIVAAmountChildTicket))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalChildTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalAmountChildTicket)))
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addComponent(lblDescChildTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAmountChildTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPriceTicketChild)))
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addComponent(btnAddCinemaTickets3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMinusCinemaTickets3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCantCinemaTickets3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDescOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSubtotalOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtotalAmountOldTicket))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIVAOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIVAAmountOldTicket))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalAmountOldTicket)))
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addComponent(btnAddCinemaTickets4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMinusCinemaTickets4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCantCinemaTickets4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPriceTicketOld)
                    .addComponent(lblAmountOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panButtonNextStepBuyTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panButtonBackToSelectorMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSubtotalTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtotalAmountTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIVATicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIVAAmountTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalAmountTicket))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        panStepsCinemaTickets.add(panSecondStepCinemaTickets, "card3");

        panThirdStepCinemaTickets.setBackground(new java.awt.Color(249, 249, 249));

        panSelectorSeats.setBackground(new java.awt.Color(239, 232, 244));

        panTheaterSeatChart.setBackground(new java.awt.Color(239, 232, 244));

        javax.swing.GroupLayout panTheaterSeatChartLayout = new javax.swing.GroupLayout(panTheaterSeatChart);
        panTheaterSeatChart.setLayout(panTheaterSeatChartLayout);
        panTheaterSeatChartLayout.setHorizontalGroup(
            panTheaterSeatChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        panTheaterSeatChartLayout.setVerticalGroup(
            panTheaterSeatChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panSelectorSeatsLayout = new javax.swing.GroupLayout(panSelectorSeats);
        panSelectorSeats.setLayout(panSelectorSeatsLayout);
        panSelectorSeatsLayout.setHorizontalGroup(
            panSelectorSeatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
            .addGroup(panSelectorSeatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panSelectorSeatsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panTheaterSeatChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panSelectorSeatsLayout.setVerticalGroup(
            panSelectorSeatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
            .addGroup(panSelectorSeatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panSelectorSeatsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panTheaterSeatChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        btnSeatsClear.setBackground(new java.awt.Color(239, 232, 244));
        btnSeatsClear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSeatsClear.setText("Limpiar");
        btnSeatsClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSeatsClear.setBorderPainted(false);
        btnSeatsClear.setContentAreaFilled(false);
        btnSeatsClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeatsClear.setFocusPainted(false);
        btnSeatsClear.setMaximumSize(new java.awt.Dimension(200, 60));
        btnSeatsClear.setMinimumSize(new java.awt.Dimension(200, 60));
        btnSeatsClear.setOpaque(true);
        btnSeatsClear.setPreferredSize(new java.awt.Dimension(200, 60));
        btnSeatsClear.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSeatsClearMouseMoved(evt);
            }
        });
        btnSeatsClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSeatsClearMouseExited(evt);
            }
        });

        btnBackToCantCinemaTickets.setBackground(new java.awt.Color(239, 232, 244));
        btnBackToCantCinemaTickets.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBackToCantCinemaTickets.setText("Atrás");
        btnBackToCantCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBackToCantCinemaTickets.setBorderPainted(false);
        btnBackToCantCinemaTickets.setContentAreaFilled(false);
        btnBackToCantCinemaTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackToCantCinemaTickets.setFocusPainted(false);
        btnBackToCantCinemaTickets.setMaximumSize(new java.awt.Dimension(200, 60));
        btnBackToCantCinemaTickets.setMinimumSize(new java.awt.Dimension(200, 60));
        btnBackToCantCinemaTickets.setOpaque(true);
        btnBackToCantCinemaTickets.setPreferredSize(new java.awt.Dimension(200, 60));
        btnBackToCantCinemaTickets.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBackToCantCinemaTicketsMouseMoved(evt);
            }
        });
        btnBackToCantCinemaTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackToCantCinemaTicketsMouseExited(evt);
            }
        });

        btnFourthStepCinemaTickets.setBackground(new java.awt.Color(239, 232, 244));
        btnFourthStepCinemaTickets.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnFourthStepCinemaTickets.setText("Aceptar");
        btnFourthStepCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFourthStepCinemaTickets.setBorderPainted(false);
        btnFourthStepCinemaTickets.setContentAreaFilled(false);
        btnFourthStepCinemaTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFourthStepCinemaTickets.setFocusPainted(false);
        btnFourthStepCinemaTickets.setMaximumSize(new java.awt.Dimension(200, 60));
        btnFourthStepCinemaTickets.setMinimumSize(new java.awt.Dimension(200, 60));
        btnFourthStepCinemaTickets.setOpaque(true);
        btnFourthStepCinemaTickets.setPreferredSize(new java.awt.Dimension(200, 60));
        btnFourthStepCinemaTickets.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnFourthStepCinemaTicketsMouseMoved(evt);
            }
        });
        btnFourthStepCinemaTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFourthStepCinemaTicketsMouseExited(evt);
            }
        });

        lblTotalSeats.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTotalSeats.setText("Total de asientos:");

        lblFreeSeats.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblFreeSeats.setText("Asientos disponibles:");

        lblSelectedSeats.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblSelectedSeats.setText("Asientos seleccionados:");

        lblCantSeatsToSelect.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCantSeatsToSelect.setText("Boletos a comprar:");

        lblTittleSelectorSeat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTittleSelectorSeat.setForeground(new java.awt.Color(75, 0, 145));
        lblTittleSelectorSeat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTittleSelectorSeat.setText("Selecciona los asientos");

        lblTotalSeatsCant.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTotalSeatsCant.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalSeatsCant.setText("0");

        lblFreeSeatsCant.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFreeSeatsCant.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFreeSeatsCant.setText("0");

        lblSelectedSeatsCant.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSelectedSeatsCant.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSelectedSeatsCant.setText("0");

        lblCantSeatsToSelectNumber.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCantSeatsToSelectNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCantSeatsToSelectNumber.setText("0");

        javax.swing.GroupLayout panThirdStepCinemaTicketsLayout = new javax.swing.GroupLayout(panThirdStepCinemaTickets);
        panThirdStepCinemaTickets.setLayout(panThirdStepCinemaTicketsLayout);
        panThirdStepCinemaTicketsLayout.setHorizontalGroup(
            panThirdStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panThirdStepCinemaTicketsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panThirdStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTittleSelectorSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panThirdStepCinemaTicketsLayout.createSequentialGroup()
                        .addComponent(panSelectorSeats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addGroup(panThirdStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSeatsClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBackToCantCinemaTickets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFourthStepCinemaTickets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panThirdStepCinemaTicketsLayout.createSequentialGroup()
                                .addGroup(panThirdStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblTotalSeats, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSelectedSeats, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCantSeatsToSelect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFreeSeats, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panThirdStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotalSeatsCant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFreeSeatsCant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSelectedSeatsCant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCantSeatsToSelectNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(30, 30, 30))
        );
        panThirdStepCinemaTicketsLayout.setVerticalGroup(
            panThirdStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panThirdStepCinemaTicketsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTittleSelectorSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panThirdStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panThirdStepCinemaTicketsLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panThirdStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalSeats)
                            .addComponent(lblTotalSeatsCant))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panThirdStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFreeSeats)
                            .addComponent(lblFreeSeatsCant))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panThirdStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSelectedSeats)
                            .addComponent(lblSelectedSeatsCant))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panThirdStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCantSeatsToSelect)
                            .addComponent(lblCantSeatsToSelectNumber))
                        .addGap(31, 31, 31)
                        .addComponent(btnSeatsClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBackToCantCinemaTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFourthStepCinemaTickets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panThirdStepCinemaTicketsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panSelectorSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );

        panStepsCinemaTickets.add(panThirdStepCinemaTickets, "card4");

        panFourthStepCinemaTickets.setBackground(new java.awt.Color(249, 249, 249));
        panFourthStepCinemaTickets.setForeground(new java.awt.Color(239, 232, 244));
        panFourthStepCinemaTickets.setMaximumSize(new java.awt.Dimension(673, 477));
        panFourthStepCinemaTickets.setMinimumSize(new java.awt.Dimension(673, 477));

        txtIdClientCinemaSell.setBackground(new java.awt.Color(249, 249, 249));
        txtIdClientCinemaSell.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIdClientCinemaSell.setText("Cédula del cliente");
        txtIdClientCinemaSell.setBorder(null);
        txtIdClientCinemaSell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdClientCinemaSellMouseClicked(evt);
            }
        });
        txtIdClientCinemaSell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdClientCinemaSellKeyTyped(evt);
            }
        });

        lblCinemaSeller.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCinemaSeller.setText("Vendedor:");

        cmbCinemaSeller.setBackground(new java.awt.Color(249, 249, 249));
        cmbCinemaSeller.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbCinemaSeller.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " - Seleccionar - ", "Esteban Dido", "Ana Tomía", "Armando Casas" }));
        cmbCinemaSeller.setBorder(null);
        cmbCinemaSeller.setLightWeightPopupEnabled(false);

        lblSubTotalCinemaSell.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSubTotalCinemaSell.setText("Subtotal: ");

        lblIVACinemaSell.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblIVACinemaSell.setText("IVA (16%): ");

        lblTotalCinemaSell.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTotalCinemaSell.setText("Total: ");

        lblShowCinemaTickets.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblShowCinemaTickets.setText("Lista de tickets para funciones:");

        sepClientCinemaTicket.setBackground(new java.awt.Color(249, 249, 249));
        sepClientCinemaTicket.setForeground(new java.awt.Color(75, 0, 145));

        scpCinemaTicketsTable.setBackground(new java.awt.Color(249, 249, 249));

        tblCinemaTickets.setBackground(new java.awt.Color(249, 249, 249));
        tblCinemaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Butaca", "Precio", "IVA (16%)", "Monto "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCinemaTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblCinemaTickets.setSelectionBackground(new java.awt.Color(75, 0, 145));
        tblCinemaTickets.getTableHeader().setReorderingAllowed(false);
        scpCinemaTicketsTable.setViewportView(tblCinemaTickets);

        txtSubTotalCinema.setEditable(false);
        txtSubTotalCinema.setBackground(new java.awt.Color(249, 249, 249));
        txtSubTotalCinema.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSubTotalCinema.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtIVACinema.setEditable(false);
        txtIVACinema.setBackground(new java.awt.Color(249, 249, 249));
        txtIVACinema.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIVACinema.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtTotalCinema.setEditable(false);
        txtTotalCinema.setBackground(new java.awt.Color(249, 249, 249));
        txtTotalCinema.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTotalCinema.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnSearchClientCinemaSell.setBackground(new java.awt.Color(249, 249, 249));
        btnSearchClientCinemaSell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/findUserIcon.png"))); // NOI18N
        btnSearchClientCinemaSell.setToolTipText(" Buscar");
        btnSearchClientCinemaSell.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(249, 249, 249), 1, true));
        btnSearchClientCinemaSell.setBorderPainted(false);
        btnSearchClientCinemaSell.setContentAreaFilled(false);
        btnSearchClientCinemaSell.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchClientCinemaSell.setFocusPainted(false);
        btnSearchClientCinemaSell.setOpaque(true);
        btnSearchClientCinemaSell.setPreferredSize(new java.awt.Dimension(50, 50));
        btnSearchClientCinemaSell.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSearchClientCinemaSellMouseMoved(evt);
            }
        });
        btnSearchClientCinemaSell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchClientCinemaSellMouseExited(evt);
            }
        });

        lblMovieTicket.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMovieTicket.setText("Película: ");

        lblDateOfMovie.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDateOfMovie.setText("Horario:");

        btnCinemaSellBackStep.setBackground(new java.awt.Color(245, 245, 245));
        btnCinemaSellBackStep.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCinemaSellBackStep.setText("Atrás");
        btnCinemaSellBackStep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCinemaSellBackStep.setBorderPainted(false);
        btnCinemaSellBackStep.setContentAreaFilled(false);
        btnCinemaSellBackStep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCinemaSellBackStep.setFocusPainted(false);
        btnCinemaSellBackStep.setOpaque(true);
        btnCinemaSellBackStep.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCinemaSellBackStepMouseMoved(evt);
            }
        });
        btnCinemaSellBackStep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCinemaSellBackStepMouseExited(evt);
            }
        });

        btnCinemaSell.setBackground(new java.awt.Color(245, 245, 245));
        btnCinemaSell.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCinemaSell.setText("Vender");
        btnCinemaSell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCinemaSell.setBorderPainted(false);
        btnCinemaSell.setContentAreaFilled(false);
        btnCinemaSell.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCinemaSell.setFocusPainted(false);
        btnCinemaSell.setOpaque(true);
        btnCinemaSell.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCinemaSellMouseMoved(evt);
            }
        });
        btnCinemaSell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCinemaSellMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panFourthStepCinemaTicketsLayout = new javax.swing.GroupLayout(panFourthStepCinemaTickets);
        panFourthStepCinemaTickets.setLayout(panFourthStepCinemaTicketsLayout);
        panFourthStepCinemaTicketsLayout.setHorizontalGroup(
            panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFourthStepCinemaTicketsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panFourthStepCinemaTicketsLayout.createSequentialGroup()
                        .addGroup(panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sepClientCinemaTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtIdClientCinemaSell))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchClientCinemaSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCinemaSeller)
                            .addComponent(lblDateOfMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbCinemaSeller, 0, 220, Short.MAX_VALUE)
                            .addComponent(lblDateOfMovieSell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panFourthStepCinemaTicketsLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panFourthStepCinemaTicketsLayout.createSequentialGroup()
                                .addComponent(btnCinemaSellBackStep, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCinemaSell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panFourthStepCinemaTicketsLayout.createSequentialGroup()
                                .addComponent(lblSubTotalCinemaSell)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSubTotalCinema, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblIVACinemaSell)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIVACinema, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTotalCinemaSell)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalCinema, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblShowCinemaTickets)
                            .addGroup(panFourthStepCinemaTicketsLayout.createSequentialGroup()
                                .addComponent(lblMovieTicket)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMovieTicketSell, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scpCinemaTicketsTable))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panFourthStepCinemaTicketsLayout.setVerticalGroup(
            panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFourthStepCinemaTicketsLayout.createSequentialGroup()
                .addGroup(panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFourthStepCinemaTicketsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panFourthStepCinemaTicketsLayout.createSequentialGroup()
                                .addGroup(panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panFourthStepCinemaTicketsLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnSearchClientCinemaSell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFourthStepCinemaTicketsLayout.createSequentialGroup()
                                                .addComponent(txtIdClientCinemaSell, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sepClientCinemaTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(lblCinemaSeller, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbCinemaSeller))
                                .addGroup(panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panFourthStepCinemaTicketsLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(lblMovieTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panFourthStepCinemaTicketsLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblMovieTicketSell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(lblDateOfMovieSell, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFourthStepCinemaTicketsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDateOfMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblShowCinemaTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpCinemaTicketsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtIVACinema, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSubTotalCinemaSell, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalCinemaSell, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIVACinemaSell, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtTotalCinema, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtSubTotalCinema, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCinemaSell, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(btnCinemaSellBackStep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        panStepsCinemaTickets.add(panFourthStepCinemaTickets, "card6");

        javax.swing.GroupLayout panCinemaSellLayout = new javax.swing.GroupLayout(panCinemaSell);
        panCinemaSell.setLayout(panCinemaSellLayout);
        panCinemaSellLayout.setHorizontalGroup(
            panCinemaSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sepCinemaSellTittle)
            .addGroup(panCinemaSellLayout.createSequentialGroup()
                .addComponent(btnBackToTicketDecision2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCinemaTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSucursalNameCinemaTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panChangeSucursalCinemaTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panCinemaSellLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panStepsCinemaTickets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panCinemaSellLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pgrCinemaTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panCinemaSellLayout.setVerticalGroup(
            panCinemaSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCinemaSellLayout.createSequentialGroup()
                .addGroup(panCinemaSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panChangeSucursalCinemaTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panCinemaSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnBackToTicketDecision2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCinemaTickets, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSucursalNameCinemaTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(sepCinemaSellTittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pgrCinemaTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panStepsCinemaTickets, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        panOption2.add(panCinemaSell, "card2");

        panContent.add(panOption2, "card2");

        panOption3.setBackground(new java.awt.Color(249, 249, 249));
        panOption3.setPreferredSize(new java.awt.Dimension(685, 620));
        panOption3.setLayout(new java.awt.CardLayout());

        panDecisionOption3.setBackground(new java.awt.Color(249, 249, 249));

        lblTittleOption4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTittleOption4.setForeground(new java.awt.Color(28, 0, 63));
        lblTittleOption4.setText("Reportes");
        lblTittleOption4.setToolTipText("");

        sepTittleOption3.setBackground(new java.awt.Color(249, 249, 249));
        sepTittleOption3.setForeground(new java.awt.Color(239, 232, 244));

        panCapsuleListClientDecision.setBackground(new java.awt.Color(249, 249, 249));
        panCapsuleListClientDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panCapsuleListClientDecision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnListClientDecision.setBackground(new java.awt.Color(249, 249, 249));
        btnListClientDecision.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnListClientDecision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/client.png"))); // NOI18N
        btnListClientDecision.setText("<html><b><FONT SIZE=4>Listados relacionados con clientes</Font></b><br><p align=’justify’>Generar los listados relacionados con los clientes.</p></html>");
        btnListClientDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnListClientDecision.setBorderPainted(false);
        btnListClientDecision.setContentAreaFilled(false);
        btnListClientDecision.setFocusPainted(false);
        btnListClientDecision.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListClientDecision.setIconTextGap(25);
        btnListClientDecision.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnListClientDecisionMouseMoved(evt);
            }
        });
        btnListClientDecision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnListClientDecisionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCapsuleListClientDecisionLayout = new javax.swing.GroupLayout(panCapsuleListClientDecision);
        panCapsuleListClientDecision.setLayout(panCapsuleListClientDecisionLayout);
        panCapsuleListClientDecisionLayout.setHorizontalGroup(
            panCapsuleListClientDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnListClientDecision)
        );
        panCapsuleListClientDecisionLayout.setVerticalGroup(
            panCapsuleListClientDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleListClientDecisionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnListClientDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panCapsuleListEmployeeDecision.setBackground(new java.awt.Color(249, 249, 249));
        panCapsuleListEmployeeDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panCapsuleListEmployeeDecision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnListEmployeeDecision.setBackground(new java.awt.Color(249, 249, 249));
        btnListEmployeeDecision.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnListEmployeeDecision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/employee.png"))); // NOI18N
        btnListEmployeeDecision.setText("<html><b><FONT SIZE=4>Listados relacionados con empleados</Font></b><br><p align=’justify’>Generar los listados relacionados con empleados.</p></html>");
        btnListEmployeeDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnListEmployeeDecision.setBorderPainted(false);
        btnListEmployeeDecision.setContentAreaFilled(false);
        btnListEmployeeDecision.setFocusPainted(false);
        btnListEmployeeDecision.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListEmployeeDecision.setIconTextGap(25);
        btnListEmployeeDecision.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnListEmployeeDecisionMouseMoved(evt);
            }
        });
        btnListEmployeeDecision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnListEmployeeDecisionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCapsuleListEmployeeDecisionLayout = new javax.swing.GroupLayout(panCapsuleListEmployeeDecision);
        panCapsuleListEmployeeDecision.setLayout(panCapsuleListEmployeeDecisionLayout);
        panCapsuleListEmployeeDecisionLayout.setHorizontalGroup(
            panCapsuleListEmployeeDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnListEmployeeDecision)
        );
        panCapsuleListEmployeeDecisionLayout.setVerticalGroup(
            panCapsuleListEmployeeDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleListEmployeeDecisionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnListEmployeeDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panCapsuleListPeliculasDecision.setBackground(new java.awt.Color(249, 249, 249));
        panCapsuleListPeliculasDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panCapsuleListPeliculasDecision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnListPeliculasDecision.setBackground(new java.awt.Color(249, 249, 249));
        btnListPeliculasDecision.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnListPeliculasDecision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/ticketGolosina.png"))); // NOI18N
        btnListPeliculasDecision.setText("<html><b><FONT SIZE=4>Listado de Peliculas</Font></b><br><p align=’justify’>Generar los listados relacionados con las Peliculas.</p></html>");
        btnListPeliculasDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnListPeliculasDecision.setBorderPainted(false);
        btnListPeliculasDecision.setContentAreaFilled(false);
        btnListPeliculasDecision.setFocusPainted(false);
        btnListPeliculasDecision.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListPeliculasDecision.setIconTextGap(25);
        btnListPeliculasDecision.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnListPeliculasDecisionMouseMoved(evt);
            }
        });
        btnListPeliculasDecision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnListPeliculasDecisionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCapsuleListPeliculasDecisionLayout = new javax.swing.GroupLayout(panCapsuleListPeliculasDecision);
        panCapsuleListPeliculasDecision.setLayout(panCapsuleListPeliculasDecisionLayout);
        panCapsuleListPeliculasDecisionLayout.setHorizontalGroup(
            panCapsuleListPeliculasDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnListPeliculasDecision, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );
        panCapsuleListPeliculasDecisionLayout.setVerticalGroup(
            panCapsuleListPeliculasDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleListPeliculasDecisionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnListPeliculasDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sepBranchDecision3.setForeground(new java.awt.Color(239, 232, 244));

        sepCinemaRoomDecision3.setForeground(new java.awt.Color(239, 232, 244));

        sepCinemaRoomDecision4.setForeground(new java.awt.Color(239, 232, 244));

        sepCinemaRoomDecision5.setForeground(new java.awt.Color(239, 232, 244));

        javax.swing.GroupLayout panDecisionOption3Layout = new javax.swing.GroupLayout(panDecisionOption3);
        panDecisionOption3.setLayout(panDecisionOption3Layout);
        panDecisionOption3Layout.setHorizontalGroup(
            panDecisionOption3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sepTittleOption3)
            .addGroup(panDecisionOption3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lblTittleOption4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panDecisionOption3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDecisionOption3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panCapsuleListClientDecision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCapsuleListEmployeeDecision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCapsuleListPeliculasDecision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sepCinemaRoomDecision3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sepCinemaRoomDecision4)
                    .addComponent(sepCinemaRoomDecision5))
                .addContainerGap())
            .addGroup(panDecisionOption3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panDecisionOption3Layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(sepBranchDecision3)
                    .addGap(3, 3, 3)))
        );
        panDecisionOption3Layout.setVerticalGroup(
            panDecisionOption3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDecisionOption3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTittleOption4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTittleOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCapsuleListClientDecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(sepCinemaRoomDecision3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panCapsuleListEmployeeDecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(sepCinemaRoomDecision4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(panCapsuleListPeliculasDecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepCinemaRoomDecision5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
            .addGroup(panDecisionOption3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panDecisionOption3Layout.createSequentialGroup()
                    .addGap(308, 308, 308)
                    .addComponent(sepBranchDecision3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(321, Short.MAX_VALUE)))
        );

        panOption3.add(panDecisionOption3, "card4");

        panListClientDecision.setBackground(new java.awt.Color(249, 249, 249));

        lblTittleOption5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTittleOption5.setForeground(new java.awt.Color(28, 0, 63));
        lblTittleOption5.setText("Listados relacionados con clientes");
        lblTittleOption5.setToolTipText("");

        sepTittleOption4.setBackground(new java.awt.Color(249, 249, 249));
        sepTittleOption4.setForeground(new java.awt.Color(239, 232, 244));

        panButtonListClient.setBackground(new java.awt.Color(249, 249, 249));

        jScrollPane1.setBackground(new java.awt.Color(249, 249, 249));

        panListClientDecision1.setBackground(new java.awt.Color(249, 249, 249));
        panListClientDecision1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panListClientDecision1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnListClientDecision1.setBackground(new java.awt.Color(249, 249, 249));
        btnListClientDecision1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnListClientDecision1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/pase especial.png"))); // NOI18N
        btnListClientDecision1.setText("<html><b><FONT SIZE=4>Listados de Clientes que recibieron Pase Especial</Font></b><br><p align=’justify’>Clientes frecuentes que recibieron a fin de mes un pase especial.</p></html>");
        btnListClientDecision1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnListClientDecision1.setBorderPainted(false);
        btnListClientDecision1.setContentAreaFilled(false);
        btnListClientDecision1.setFocusPainted(false);
        btnListClientDecision1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListClientDecision1.setIconTextGap(25);
        btnListClientDecision1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnListClientDecision1MouseMoved(evt);
            }
        });
        btnListClientDecision1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnListClientDecision1MouseExited(evt);
            }
        });
        btnListClientDecision1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListClientDecision1ActionPerformed(evt);
            }
        });

        btnListClientDecision2.setBackground(new java.awt.Color(249, 249, 249));
        btnListClientDecision2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnListClientDecision2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/montoGolosina.png"))); // NOI18N
        btnListClientDecision2.setText("<html><b><FONT SIZE=4>Listados de clientes golosinas</Font></b><br><p align=’justify’>Los montos gastados por clientes en golosina.</p></html>");
        btnListClientDecision2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnListClientDecision2.setBorderPainted(false);
        btnListClientDecision2.setContentAreaFilled(false);
        btnListClientDecision2.setFocusPainted(false);
        btnListClientDecision2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListClientDecision2.setIconTextGap(25);

        btnListClientDecision3.setBackground(new java.awt.Color(249, 249, 249));
        btnListClientDecision3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnListClientDecision3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/client frecuente.png"))); // NOI18N
        btnListClientDecision3.setText("<html><b><FONT SIZE=4>Listados de Clientes frecuentes</Font></b><br><p align=’justify’>clientes frecuentes.</p></html>");
        btnListClientDecision3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnListClientDecision3.setBorderPainted(false);
        btnListClientDecision3.setContentAreaFilled(false);
        btnListClientDecision3.setFocusPainted(false);
        btnListClientDecision3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListClientDecision3.setIconTextGap(25);
        btnListClientDecision3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnListClientDecision3MouseMoved(evt);
            }
        });
        btnListClientDecision3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnListClientDecision3MouseExited(evt);
            }
        });
        btnListClientDecision3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListClientDecision3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panListClientDecision1Layout = new javax.swing.GroupLayout(panListClientDecision1);
        panListClientDecision1.setLayout(panListClientDecision1Layout);
        panListClientDecision1Layout.setHorizontalGroup(
            panListClientDecision1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panListClientDecision1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panListClientDecision1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListClientDecision2, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListClientDecision1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListClientDecision3, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panListClientDecision1Layout.setVerticalGroup(
            panListClientDecision1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panListClientDecision1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListClientDecision3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnListClientDecision2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListClientDecision1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 308, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(panListClientDecision1);

        javax.swing.GroupLayout panButtonListClientLayout = new javax.swing.GroupLayout(panButtonListClient);
        panButtonListClient.setLayout(panButtonListClientLayout);
        panButtonListClientLayout.setHorizontalGroup(
            panButtonListClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );
        panButtonListClientLayout.setVerticalGroup(
            panButtonListClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panButtonListClientLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 273, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panListClientDecisionLayout = new javax.swing.GroupLayout(panListClientDecision);
        panListClientDecision.setLayout(panListClientDecisionLayout);
        panListClientDecisionLayout.setHorizontalGroup(
            panListClientDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panListClientDecisionLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblTittleOption5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(sepTittleOption4)
            .addComponent(panButtonListClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panListClientDecisionLayout.setVerticalGroup(
            panListClientDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panListClientDecisionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTittleOption5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTittleOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panButtonListClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panOption3.add(panListClientDecision, "card5");

        panListPeliculaDecision.setBackground(new java.awt.Color(249, 249, 249));

        lblTittleOption6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTittleOption6.setForeground(new java.awt.Color(28, 0, 63));
        lblTittleOption6.setText("Reportes Peliculas");
        lblTittleOption6.setToolTipText("");

        sepTittleOption5.setBackground(new java.awt.Color(249, 249, 249));
        sepTittleOption5.setForeground(new java.awt.Color(239, 232, 244));

        panButtonListPeliculas2.setBackground(new java.awt.Color(249, 249, 249));

        jScrollPane2.setBackground(new java.awt.Color(249, 249, 249));

        panListPeliculasDecision3.setBackground(new java.awt.Color(249, 249, 249));
        panListPeliculasDecision3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panListPeliculasDecision3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnListPelculasGeneral.setBackground(new java.awt.Color(249, 249, 249));
        btnListPelculasGeneral.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnListPelculasGeneral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/video.png"))); // NOI18N
        btnListPelculasGeneral.setText("<html><b><FONT SIZE=4>Listados de General de Peliculas</Font></b><br><p align=’justify’>Información de Peliculas .</p></html>");
        btnListPelculasGeneral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnListPelculasGeneral.setBorderPainted(false);
        btnListPelculasGeneral.setContentAreaFilled(false);
        btnListPelculasGeneral.setFocusPainted(false);
        btnListPelculasGeneral.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListPelculasGeneral.setIconTextGap(25);
        btnListPelculasGeneral.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnListPelculasGeneralMouseMoved(evt);
            }
        });
        btnListPelculasGeneral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnListPelculasGeneralMouseExited(evt);
            }
        });
        btnListPelculasGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListPelculasGeneralActionPerformed(evt);
            }
        });

        btnListPeliculasXmes.setBackground(new java.awt.Color(249, 249, 249));
        btnListPeliculasXmes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnListPeliculasXmes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/cinema (1).png"))); // NOI18N
        btnListPeliculasXmes.setText("<html><b><FONT SIZE=4>Listados de Peliculas por Mes</Font></b><br><p align=’justify’>Detalles de Peliculas Proyectadas.</p></html>");
        btnListPeliculasXmes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnListPeliculasXmes.setBorderPainted(false);
        btnListPeliculasXmes.setContentAreaFilled(false);
        btnListPeliculasXmes.setFocusPainted(false);
        btnListPeliculasXmes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListPeliculasXmes.setIconTextGap(25);

        javax.swing.GroupLayout panListPeliculasDecision3Layout = new javax.swing.GroupLayout(panListPeliculasDecision3);
        panListPeliculasDecision3.setLayout(panListPeliculasDecision3Layout);
        panListPeliculasDecision3Layout.setHorizontalGroup(
            panListPeliculasDecision3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnListPelculasGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
            .addGroup(panListPeliculasDecision3Layout.createSequentialGroup()
                .addComponent(btnListPeliculasXmes, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panListPeliculasDecision3Layout.setVerticalGroup(
            panListPeliculasDecision3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panListPeliculasDecision3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListPelculasGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListPeliculasXmes, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 414, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(panListPeliculasDecision3);

        javax.swing.GroupLayout panButtonListPeliculas2Layout = new javax.swing.GroupLayout(panButtonListPeliculas2);
        panButtonListPeliculas2.setLayout(panButtonListPeliculas2Layout);
        panButtonListPeliculas2Layout.setHorizontalGroup(
            panButtonListPeliculas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );
        panButtonListPeliculas2Layout.setVerticalGroup(
            panButtonListPeliculas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panButtonListPeliculas2Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout panListPeliculaDecisionLayout = new javax.swing.GroupLayout(panListPeliculaDecision);
        panListPeliculaDecision.setLayout(panListPeliculaDecisionLayout);
        panListPeliculaDecisionLayout.setHorizontalGroup(
            panListPeliculaDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sepTittleOption5)
            .addComponent(panButtonListPeliculas2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panListPeliculaDecisionLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblTittleOption6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panListPeliculaDecisionLayout.setVerticalGroup(
            panListPeliculaDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panListPeliculaDecisionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTittleOption6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTittleOption5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panButtonListPeliculas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panOption3.add(panListPeliculaDecision, "card5");

        panListEmployeeDecision.setBackground(new java.awt.Color(249, 249, 249));

        lblTittleOption9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTittleOption9.setForeground(new java.awt.Color(28, 0, 63));
        lblTittleOption9.setText("Listados relacionados con empleados");
        lblTittleOption9.setToolTipText("");

        sepTittleOption6.setBackground(new java.awt.Color(249, 249, 249));
        sepTittleOption6.setForeground(new java.awt.Color(239, 232, 244));

        panButtonListEmployee.setBackground(new java.awt.Color(249, 249, 249));

        jScrollPane3.setBackground(new java.awt.Color(249, 249, 249));

        panListEmployeeDecision1.setBackground(new java.awt.Color(249, 249, 249));
        panListEmployeeDecision1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panListEmployeeDecision1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnListEmployeeDecision1.setBackground(new java.awt.Color(249, 249, 249));
        btnListEmployeeDecision1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnListEmployeeDecision1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/ventaGolosinaSemana.png"))); // NOI18N
        btnListEmployeeDecision1.setText("<html><b><FONT SIZE=4>Listados de empleados que vendieron golosinas por semana</Font></b><br><p align=’justify’>Empleados con ventas de golosinas por semana.</p></html>");
        btnListEmployeeDecision1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnListEmployeeDecision1.setBorderPainted(false);
        btnListEmployeeDecision1.setContentAreaFilled(false);
        btnListEmployeeDecision1.setFocusPainted(false);
        btnListEmployeeDecision1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListEmployeeDecision1.setIconTextGap(25);
        btnListEmployeeDecision1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnListEmployeeDecision1MouseMoved(evt);
            }
        });
        btnListEmployeeDecision1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnListEmployeeDecision1MouseExited(evt);
            }
        });
        btnListEmployeeDecision1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListEmployeeDecision1ActionPerformed(evt);
            }
        });

        btnListEmployeeDecision2.setBackground(new java.awt.Color(249, 249, 249));
        btnListEmployeeDecision2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnListEmployeeDecision2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/VentaGolosinaMes.png"))); // NOI18N
        btnListEmployeeDecision2.setText("<html><b><FONT SIZE=4>Listados de empleados que vendieron mas golosinas durante un mes</Font></b><br><p align=’justify’>Empleados con mayor ventas de golsinas durante un mes.</p></html>");
        btnListEmployeeDecision2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnListEmployeeDecision2.setBorderPainted(false);
        btnListEmployeeDecision2.setContentAreaFilled(false);
        btnListEmployeeDecision2.setFocusPainted(false);
        btnListEmployeeDecision2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListEmployeeDecision2.setIconTextGap(25);

        javax.swing.GroupLayout panListEmployeeDecision1Layout = new javax.swing.GroupLayout(panListEmployeeDecision1);
        panListEmployeeDecision1.setLayout(panListEmployeeDecision1Layout);
        panListEmployeeDecision1Layout.setHorizontalGroup(
            panListEmployeeDecision1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnListEmployeeDecision1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
            .addGroup(panListEmployeeDecision1Layout.createSequentialGroup()
                .addComponent(btnListEmployeeDecision2, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panListEmployeeDecision1Layout.setVerticalGroup(
            panListEmployeeDecision1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panListEmployeeDecision1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListEmployeeDecision1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListEmployeeDecision2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 414, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(panListEmployeeDecision1);

        javax.swing.GroupLayout panButtonListEmployeeLayout = new javax.swing.GroupLayout(panButtonListEmployee);
        panButtonListEmployee.setLayout(panButtonListEmployeeLayout);
        panButtonListEmployeeLayout.setHorizontalGroup(
            panButtonListEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );
        panButtonListEmployeeLayout.setVerticalGroup(
            panButtonListEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panButtonListEmployeeLayout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout panListEmployeeDecisionLayout = new javax.swing.GroupLayout(panListEmployeeDecision);
        panListEmployeeDecision.setLayout(panListEmployeeDecisionLayout);
        panListEmployeeDecisionLayout.setHorizontalGroup(
            panListEmployeeDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panListEmployeeDecisionLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblTittleOption9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(sepTittleOption6)
            .addComponent(panButtonListEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panListEmployeeDecisionLayout.setVerticalGroup(
            panListEmployeeDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panListEmployeeDecisionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTittleOption9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTittleOption6, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panButtonListEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panOption3.add(panListEmployeeDecision, "card4");

        panContent.add(panOption3, "card7");

        panOption4.setBackground(new java.awt.Color(249, 249, 249));
        panOption4.setPreferredSize(new java.awt.Dimension(685, 620));

        panDecisionOption4.setBackground(new java.awt.Color(249, 249, 249));
        panDecisionOption4.setForeground(new java.awt.Color(239, 232, 244));
        panDecisionOption4.setFocusTraversalPolicyProvider(true);
        panDecisionOption4.setPreferredSize(new java.awt.Dimension(689, 620));

        lblEmployeeeDecision.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblEmployeeeDecision.setForeground(new java.awt.Color(28, 0, 63));
        lblEmployeeeDecision.setText("Empleado");
        lblEmployeeeDecision.setPreferredSize(new java.awt.Dimension(55, 24));

        sepTittleOption7.setBackground(new java.awt.Color(249, 249, 249));
        sepTittleOption7.setForeground(new java.awt.Color(239, 232, 244));

        panCapsuleEmployeeDecision.setBackground(new java.awt.Color(249, 249, 249));
        panCapsuleEmployeeDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panCapsuleEmployeeDecision.setPreferredSize(new java.awt.Dimension(619, 74));

        btnEmployeeDecision.setBackground(new java.awt.Color(249, 249, 249));
        btnEmployeeDecision.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEmployeeDecision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/empleado.png"))); // NOI18N
        btnEmployeeDecision.setText("<html><b><FONT SIZE=4>Empleados</Font></b><br><p align=’justify’>Gestiona la información de los empleados que trabajan para Cines de Venezuela.</p></html>");
        btnEmployeeDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnEmployeeDecision.setBorderPainted(false);
        btnEmployeeDecision.setContentAreaFilled(false);
        btnEmployeeDecision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeDecision.setFocusPainted(false);
        btnEmployeeDecision.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEmployeeDecision.setIconTextGap(25);
        btnEmployeeDecision.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEmployeeDecisionMouseMoved(evt);
            }
        });
        btnEmployeeDecision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEmployeeDecisionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCapsuleEmployeeDecisionLayout = new javax.swing.GroupLayout(panCapsuleEmployeeDecision);
        panCapsuleEmployeeDecision.setLayout(panCapsuleEmployeeDecisionLayout);
        panCapsuleEmployeeDecisionLayout.setHorizontalGroup(
            panCapsuleEmployeeDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEmployeeDecision)
        );
        panCapsuleEmployeeDecisionLayout.setVerticalGroup(
            panCapsuleEmployeeDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleEmployeeDecisionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEmployeeDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sepBranchDecision1.setForeground(new java.awt.Color(239, 232, 244));

        panCapsuleUserDecision.setBackground(new java.awt.Color(249, 249, 249));
        panCapsuleUserDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panCapsuleUserDecision.setPreferredSize(new java.awt.Dimension(619, 74));

        btnUserDecision.setBackground(new java.awt.Color(249, 249, 249));
        btnUserDecision.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnUserDecision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/Usuario.png"))); // NOI18N
        btnUserDecision.setText("<html><b><FONT SIZE=4>Usuarios</Font></b><br><p align=’justify’>Gestiona los usuarios.</p></html>");
        btnUserDecision.setActionCommand("<html><b><FONT SIZE=4>Salas</Font></b><br><p align=’justify’>Modificar la información de las salas.</p></html>");
        btnUserDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnUserDecision.setBorderPainted(false);
        btnUserDecision.setContentAreaFilled(false);
        btnUserDecision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserDecision.setFocusPainted(false);
        btnUserDecision.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnUserDecision.setIconTextGap(25);
        btnUserDecision.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnUserDecisionMouseMoved(evt);
            }
        });
        btnUserDecision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUserDecisionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCapsuleUserDecisionLayout = new javax.swing.GroupLayout(panCapsuleUserDecision);
        panCapsuleUserDecision.setLayout(panCapsuleUserDecisionLayout);
        panCapsuleUserDecisionLayout.setHorizontalGroup(
            panCapsuleUserDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnUserDecision, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panCapsuleUserDecisionLayout.setVerticalGroup(
            panCapsuleUserDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleUserDecisionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnUserDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sepCinemaRoomDecision1.setForeground(new java.awt.Color(239, 232, 244));

        javax.swing.GroupLayout panDecisionOption4Layout = new javax.swing.GroupLayout(panDecisionOption4);
        panDecisionOption4.setLayout(panDecisionOption4Layout);
        panDecisionOption4Layout.setHorizontalGroup(
            panDecisionOption4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDecisionOption4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDecisionOption4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDecisionOption4Layout.createSequentialGroup()
                        .addComponent(panCapsuleUserDecision, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panDecisionOption4Layout.createSequentialGroup()
                        .addGroup(panDecisionOption4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panCapsuleEmployeeDecision, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                            .addGroup(panDecisionOption4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblEmployeeeDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panDecisionOption4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panDecisionOption4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sepCinemaRoomDecision1)
                    .addComponent(sepBranchDecision1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sepTittleOption7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)))
        );
        panDecisionOption4Layout.setVerticalGroup(
            panDecisionOption4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDecisionOption4Layout.createSequentialGroup()
                .addComponent(lblEmployeeeDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTittleOption7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCapsuleEmployeeDecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepBranchDecision1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCapsuleUserDecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepCinemaRoomDecision1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(394, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panOption4Layout = new javax.swing.GroupLayout(panOption4);
        panOption4.setLayout(panOption4Layout);
        panOption4Layout.setHorizontalGroup(
            panOption4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOption4Layout.createSequentialGroup()
                .addComponent(panDecisionOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panOption4Layout.setVerticalGroup(
            panOption4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOption4Layout.createSequentialGroup()
                .addComponent(panDecisionOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panContent.add(panOption4, "card2");

        panOption5.setBackground(new java.awt.Color(249, 249, 249));
        panOption5.setPreferredSize(new java.awt.Dimension(685, 620));

        panDecisionOption5.setBackground(new java.awt.Color(249, 249, 249));
        panDecisionOption5.setForeground(new java.awt.Color(239, 232, 244));
        panDecisionOption5.setFocusTraversalPolicyProvider(true);
        panDecisionOption5.setPreferredSize(new java.awt.Dimension(689, 620));

        lblTittleOption7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTittleOption7.setForeground(new java.awt.Color(28, 0, 63));
        lblTittleOption7.setText("Sucursal");
        lblTittleOption7.setPreferredSize(new java.awt.Dimension(55, 24));

        sepTittleOption8.setBackground(new java.awt.Color(249, 249, 249));
        sepTittleOption8.setForeground(new java.awt.Color(239, 232, 244));

        panCapsuleBranchDecision.setBackground(new java.awt.Color(249, 249, 249));
        panCapsuleBranchDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panCapsuleBranchDecision.setPreferredSize(new java.awt.Dimension(619, 74));

        btnBranchDecision.setBackground(new java.awt.Color(249, 249, 249));
        btnBranchDecision.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBranchDecision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/sucursal.png"))); // NOI18N
        btnBranchDecision.setText("<html><b><FONT SIZE=4>Sucursal</Font></b><br><p align=’justify’>Gestiona los datos de la sucursal</p></html>");
        btnBranchDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnBranchDecision.setBorderPainted(false);
        btnBranchDecision.setContentAreaFilled(false);
        btnBranchDecision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBranchDecision.setFocusPainted(false);
        btnBranchDecision.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBranchDecision.setIconTextGap(25);
        btnBranchDecision.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBranchDecisionMouseMoved(evt);
            }
        });
        btnBranchDecision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBranchDecisionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCapsuleBranchDecisionLayout = new javax.swing.GroupLayout(panCapsuleBranchDecision);
        panCapsuleBranchDecision.setLayout(panCapsuleBranchDecisionLayout);
        panCapsuleBranchDecisionLayout.setHorizontalGroup(
            panCapsuleBranchDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBranchDecision)
        );
        panCapsuleBranchDecisionLayout.setVerticalGroup(
            panCapsuleBranchDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleBranchDecisionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBranchDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sepBranchDecision.setForeground(new java.awt.Color(239, 232, 244));

        panCapsuleCinemaRoomDecision.setBackground(new java.awt.Color(249, 249, 249));
        panCapsuleCinemaRoomDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panCapsuleCinemaRoomDecision.setPreferredSize(new java.awt.Dimension(619, 74));

        btnCinemaRoomDecision.setBackground(new java.awt.Color(249, 249, 249));
        btnCinemaRoomDecision.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCinemaRoomDecision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/sala.png"))); // NOI18N
        btnCinemaRoomDecision.setText("<html><b><FONT SIZE=4>Salas</Font></b><br><p align=’justify’>Gestiona la información de las salas.</p></html>");
        btnCinemaRoomDecision.setActionCommand("<html><b><FONT SIZE=4>Salas</Font></b><br><p align=’justify’>Modificar la información de las salas.</p></html>");
        btnCinemaRoomDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnCinemaRoomDecision.setBorderPainted(false);
        btnCinemaRoomDecision.setContentAreaFilled(false);
        btnCinemaRoomDecision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCinemaRoomDecision.setFocusPainted(false);
        btnCinemaRoomDecision.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCinemaRoomDecision.setIconTextGap(25);
        btnCinemaRoomDecision.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCinemaRoomDecisionMouseMoved(evt);
            }
        });
        btnCinemaRoomDecision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCinemaRoomDecisionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCapsuleCinemaRoomDecisionLayout = new javax.swing.GroupLayout(panCapsuleCinemaRoomDecision);
        panCapsuleCinemaRoomDecision.setLayout(panCapsuleCinemaRoomDecisionLayout);
        panCapsuleCinemaRoomDecisionLayout.setHorizontalGroup(
            panCapsuleCinemaRoomDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCinemaRoomDecision)
        );
        panCapsuleCinemaRoomDecisionLayout.setVerticalGroup(
            panCapsuleCinemaRoomDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleCinemaRoomDecisionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCinemaRoomDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sepCinemaRoomDecision.setForeground(new java.awt.Color(239, 232, 244));

        panCapsuleEnterpriseDecision.setBackground(new java.awt.Color(249, 249, 249));
        panCapsuleEnterpriseDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panCapsuleEnterpriseDecision.setPreferredSize(new java.awt.Dimension(619, 74));

        btnEnterpriseDecision.setBackground(new java.awt.Color(249, 249, 249));
        btnEnterpriseDecision.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEnterpriseDecision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/empresa.png"))); // NOI18N
        btnEnterpriseDecision.setText("<html><b><FONT SIZE=4>Empresa</Font></b><br><p align=’justify’>Gestiona la información de la empresa</p></html>");
        btnEnterpriseDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnEnterpriseDecision.setBorderPainted(false);
        btnEnterpriseDecision.setContentAreaFilled(false);
        btnEnterpriseDecision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnterpriseDecision.setFocusPainted(false);
        btnEnterpriseDecision.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEnterpriseDecision.setIconTextGap(25);
        btnEnterpriseDecision.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEnterpriseDecisionMouseMoved(evt);
            }
        });
        btnEnterpriseDecision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnterpriseDecisionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCapsuleEnterpriseDecisionLayout = new javax.swing.GroupLayout(panCapsuleEnterpriseDecision);
        panCapsuleEnterpriseDecision.setLayout(panCapsuleEnterpriseDecisionLayout);
        panCapsuleEnterpriseDecisionLayout.setHorizontalGroup(
            panCapsuleEnterpriseDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnterpriseDecision, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panCapsuleEnterpriseDecisionLayout.setVerticalGroup(
            panCapsuleEnterpriseDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleEnterpriseDecisionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEnterpriseDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sepEnterpriseDecision.setForeground(new java.awt.Color(239, 232, 244));

        panCapsuleCandyInventory.setBackground(new java.awt.Color(249, 249, 249));
        panCapsuleCandyInventory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panCapsuleCandyInventory.setPreferredSize(new java.awt.Dimension(619, 74));

        btnCandyInventory.setBackground(new java.awt.Color(249, 249, 249));
        btnCandyInventory.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCandyInventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/inventory.png"))); // NOI18N
        btnCandyInventory.setText("<html><b><FONT SIZE=4>Inventario de Golosinas</Font></b><br><p align=’justify’>Gestionar los inventarios de golosinas</p></html>");
        btnCandyInventory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnCandyInventory.setBorderPainted(false);
        btnCandyInventory.setContentAreaFilled(false);
        btnCandyInventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCandyInventory.setFocusPainted(false);
        btnCandyInventory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCandyInventory.setIconTextGap(25);
        btnCandyInventory.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCandyInventoryMouseMoved(evt);
            }
        });
        btnCandyInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCandyInventoryMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCapsuleCandyInventoryLayout = new javax.swing.GroupLayout(panCapsuleCandyInventory);
        panCapsuleCandyInventory.setLayout(panCapsuleCandyInventoryLayout);
        panCapsuleCandyInventoryLayout.setHorizontalGroup(
            panCapsuleCandyInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleCandyInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCandyInventory))
        );
        panCapsuleCandyInventoryLayout.setVerticalGroup(
            panCapsuleCandyInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleCandyInventoryLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCandyInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panCapsuleCandyInventory2.setBackground(new java.awt.Color(249, 249, 249));
        panCapsuleCandyInventory2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panCapsuleCandyInventory2.setPreferredSize(new java.awt.Dimension(619, 74));

        btnFunction.setBackground(new java.awt.Color(249, 249, 249));
        btnFunction.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnFunction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/cinema (1).png"))); // NOI18N
        btnFunction.setText("<html><b><FONT SIZE=4>Funciones</Font></b><br><p align=’justify’>Gestionar las funciones</p></html>");
        btnFunction.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnFunction.setBorderPainted(false);
        btnFunction.setContentAreaFilled(false);
        btnFunction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFunction.setFocusPainted(false);
        btnFunction.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFunction.setIconTextGap(25);
        btnFunction.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnFunctionMouseMoved(evt);
            }
        });
        btnFunction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFunctionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCapsuleCandyInventory2Layout = new javax.swing.GroupLayout(panCapsuleCandyInventory2);
        panCapsuleCandyInventory2.setLayout(panCapsuleCandyInventory2Layout);
        panCapsuleCandyInventory2Layout.setHorizontalGroup(
            panCapsuleCandyInventory2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnFunction)
        );
        panCapsuleCandyInventory2Layout.setVerticalGroup(
            panCapsuleCandyInventory2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleCandyInventory2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFunction, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panDecisionOption5Layout = new javax.swing.GroupLayout(panDecisionOption5);
        panDecisionOption5.setLayout(panDecisionOption5Layout);
        panDecisionOption5Layout.setHorizontalGroup(
            panDecisionOption5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDecisionOption5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panDecisionOption5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panDecisionOption5Layout.createSequentialGroup()
                        .addComponent(panCapsuleCandyInventory, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sepEnterpriseDecision))
                    .addComponent(sepCinemaRoomDecision)
                    .addComponent(sepTittleOption8, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)))
            .addGroup(panDecisionOption5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDecisionOption5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panDecisionOption5Layout.createSequentialGroup()
                        .addGap(0, 39, Short.MAX_VALUE)
                        .addComponent(lblTittleOption7, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panDecisionOption5Layout.createSequentialGroup()
                        .addGroup(panDecisionOption5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panCapsuleBranchDecision, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                            .addComponent(panCapsuleEnterpriseDecision, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                            .addComponent(panCapsuleCinemaRoomDecision, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(sepBranchDecision, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panDecisionOption5Layout.createSequentialGroup()
                        .addComponent(panCapsuleCandyInventory2, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panDecisionOption5Layout.setVerticalGroup(
            panDecisionOption5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDecisionOption5Layout.createSequentialGroup()
                .addComponent(lblTittleOption7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTittleOption8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCapsuleBranchDecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepBranchDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCapsuleCinemaRoomDecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepCinemaRoomDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCapsuleEnterpriseDecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDecisionOption5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sepEnterpriseDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panCapsuleCandyInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panCapsuleCandyInventory2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panOption5Layout = new javax.swing.GroupLayout(panOption5);
        panOption5.setLayout(panOption5Layout);
        panOption5Layout.setHorizontalGroup(
            panOption5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOption5Layout.createSequentialGroup()
                .addComponent(panDecisionOption5, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panOption5Layout.setVerticalGroup(
            panOption5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOption5Layout.createSequentialGroup()
                .addComponent(panDecisionOption5, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panContent.add(panOption5, "card2");

        panOption6.setBackground(new java.awt.Color(249, 249, 249));
        panOption6.setPreferredSize(new java.awt.Dimension(685, 620));

        panDecisionOption6.setBackground(new java.awt.Color(249, 249, 249));
        panDecisionOption6.setForeground(new java.awt.Color(239, 232, 244));
        panDecisionOption6.setFocusTraversalPolicyProvider(true);
        panDecisionOption6.setPreferredSize(new java.awt.Dimension(689, 620));

        lblTittleOption8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTittleOption8.setForeground(new java.awt.Color(28, 0, 63));
        lblTittleOption8.setText("Configuración");
        lblTittleOption8.setPreferredSize(new java.awt.Dimension(55, 24));

        sepTittleOption9.setBackground(new java.awt.Color(249, 249, 249));
        sepTittleOption9.setForeground(new java.awt.Color(239, 232, 244));

        panCapsuleFilmDecision.setBackground(new java.awt.Color(249, 249, 249));
        panCapsuleFilmDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panCapsuleFilmDecision.setPreferredSize(new java.awt.Dimension(619, 74));

        btnFilmDecision.setBackground(new java.awt.Color(249, 249, 249));
        btnFilmDecision.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnFilmDecision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/peliculas.png"))); // NOI18N
        btnFilmDecision.setText("<html><b><FONT SIZE=4>Peliculas</Font></b><br><p align=’justify’>Gestiona las peliculas</p></html>");
        btnFilmDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnFilmDecision.setBorderPainted(false);
        btnFilmDecision.setContentAreaFilled(false);
        btnFilmDecision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFilmDecision.setFocusPainted(false);
        btnFilmDecision.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFilmDecision.setIconTextGap(25);
        btnFilmDecision.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnFilmDecisionMouseMoved(evt);
            }
        });
        btnFilmDecision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFilmDecisionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCapsuleFilmDecisionLayout = new javax.swing.GroupLayout(panCapsuleFilmDecision);
        panCapsuleFilmDecision.setLayout(panCapsuleFilmDecisionLayout);
        panCapsuleFilmDecisionLayout.setHorizontalGroup(
            panCapsuleFilmDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnFilmDecision, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panCapsuleFilmDecisionLayout.setVerticalGroup(
            panCapsuleFilmDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleFilmDecisionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFilmDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sepBranchDecision2.setForeground(new java.awt.Color(239, 232, 244));

        panCapsuleCandyDecisionCL.setBackground(new java.awt.Color(249, 249, 249));
        panCapsuleCandyDecisionCL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panCapsuleCandyDecisionCL.setPreferredSize(new java.awt.Dimension(619, 74));

        btnCandyDecisionCL.setBackground(new java.awt.Color(249, 249, 249));
        btnCandyDecisionCL.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCandyDecisionCL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/candyIcon.png"))); // NOI18N
        btnCandyDecisionCL.setText("<html><b><FONT SIZE=4>Golosinas</Font></b><br><p align=’justify’>Gestiona las golosinas.</p></html>");
        btnCandyDecisionCL.setActionCommand("<html><b><FONT SIZE=4>Salas</Font></b><br><p align=’justify’>Modificar la información de las salas.</p></html>");
        btnCandyDecisionCL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnCandyDecisionCL.setBorderPainted(false);
        btnCandyDecisionCL.setContentAreaFilled(false);
        btnCandyDecisionCL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCandyDecisionCL.setFocusPainted(false);
        btnCandyDecisionCL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCandyDecisionCL.setIconTextGap(25);
        btnCandyDecisionCL.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCandyDecisionCLMouseMoved(evt);
            }
        });
        btnCandyDecisionCL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCandyDecisionCLMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCapsuleCandyDecisionCLLayout = new javax.swing.GroupLayout(panCapsuleCandyDecisionCL);
        panCapsuleCandyDecisionCL.setLayout(panCapsuleCandyDecisionCLLayout);
        panCapsuleCandyDecisionCLLayout.setHorizontalGroup(
            panCapsuleCandyDecisionCLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCandyDecisionCL, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panCapsuleCandyDecisionCLLayout.setVerticalGroup(
            panCapsuleCandyDecisionCLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleCandyDecisionCLLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCandyDecisionCL, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sepCinemaRoomDecision2.setForeground(new java.awt.Color(239, 232, 244));

        panCapsuleClientDecision.setBackground(new java.awt.Color(249, 249, 249));
        panCapsuleClientDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        panCapsuleClientDecision.setPreferredSize(new java.awt.Dimension(619, 74));

        btnClientDecision.setBackground(new java.awt.Color(249, 249, 249));
        btnClientDecision.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnClientDecision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/cliente1.png"))); // NOI18N
        btnClientDecision.setText("<html><b><FONT SIZE=4>Cliente</Font></b><br><p align=’justify’>Gestiona la información de los clientes</p></html>");
        btnClientDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnClientDecision.setBorderPainted(false);
        btnClientDecision.setContentAreaFilled(false);
        btnClientDecision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientDecision.setFocusPainted(false);
        btnClientDecision.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClientDecision.setIconTextGap(25);
        btnClientDecision.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnClientDecisionMouseMoved(evt);
            }
        });
        btnClientDecision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClientDecisionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCapsuleClientDecisionLayout = new javax.swing.GroupLayout(panCapsuleClientDecision);
        panCapsuleClientDecision.setLayout(panCapsuleClientDecisionLayout);
        panCapsuleClientDecisionLayout.setHorizontalGroup(
            panCapsuleClientDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClientDecision, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panCapsuleClientDecisionLayout.setVerticalGroup(
            panCapsuleClientDecisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCapsuleClientDecisionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClientDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sepEnterpriseDecision1.setForeground(new java.awt.Color(239, 232, 244));

        javax.swing.GroupLayout panDecisionOption6Layout = new javax.swing.GroupLayout(panDecisionOption6);
        panDecisionOption6.setLayout(panDecisionOption6Layout);
        panDecisionOption6Layout.setHorizontalGroup(
            panDecisionOption6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDecisionOption6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDecisionOption6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sepBranchDecision2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panDecisionOption6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTittleOption8, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panDecisionOption6Layout.createSequentialGroup()
                        .addGroup(panDecisionOption6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panCapsuleFilmDecision, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                            .addComponent(panCapsuleClientDecision, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                            .addComponent(panCapsuleCandyDecisionCL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panDecisionOption6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panDecisionOption6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sepCinemaRoomDecision2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sepTittleOption9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                    .addComponent(sepEnterpriseDecision1)))
        );
        panDecisionOption6Layout.setVerticalGroup(
            panDecisionOption6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDecisionOption6Layout.createSequentialGroup()
                .addComponent(lblTittleOption8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTittleOption9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCapsuleFilmDecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepBranchDecision2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCapsuleCandyDecisionCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepCinemaRoomDecision2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCapsuleClientDecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepEnterpriseDecision1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panOption6Layout = new javax.swing.GroupLayout(panOption6);
        panOption6.setLayout(panOption6Layout);
        panOption6Layout.setHorizontalGroup(
            panOption6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panDecisionOption6, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panOption6Layout.setVerticalGroup(
            panOption6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOption6Layout.createSequentialGroup()
                .addComponent(panDecisionOption6, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panContent.add(panOption6, "card2");

        javax.swing.GroupLayout panMainMenuLayout = new javax.swing.GroupLayout(panMainMenu);
        panMainMenu.setLayout(panMainMenuLayout);
        panMainMenuLayout.setHorizontalGroup(
            panMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMainMenuLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(panContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panMainMenuLayout.setVerticalGroup(
            panMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panContent, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panMainPage.add(panMainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 710, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMainPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMainPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc=" TopBar ">
    //<editor-fold defaultstate="collapsed" desc=" Explicación sobre la Barra Superior y los Botónes que la componen ">
    /*
     * ========================================================================
     * 
     * Barra Superior:
     * - Se configura el apartado de la barra superior de la aplicación como la
     *   movibilidad y transparencia de la app.
     *
     * Botónes de la Barra Superior:
     * - Se efectuán las caraterísticas visuales que poseen los botones de la 
     *   barra superior (Minimizar y Cerrar), tal como color de fondo y funcio-
     *   nalidades.
     *
     * ========================================================================
     */
    //</editor-fold>
   
    // Si se mantiene el click pulsado y se mueve a través de la pantalla.
    private void panTopBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panTopBarMouseDragged
        //<editor-fold defaultstate="collapsed" desc=" Explicación sobre el método ">
        /*
         * Este método permite mover la aplicación por toda la pantalla del
         * computador del usuario.
         */
        
        // Se declaran las variables que obtienen la ubicación de la aplicación.
        //</editor-fold>
        int x = evt.getXOnScreen(); // Ubicación con respecto al eje X.
        int y = evt.getYOnScreen(); // Ubicación con respecto al eje Y.
        
        // Se ubica la aplicación en la nueva ubicación.
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_panTopBarMouseDragged

    // Si se mantiene el click pulsado en la barra superior.
    private void panTopBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panTopBarMousePressed
        //<editor-fold defaultstate="collapsed" desc=" Explicación sobre el método ">
        /*
         * Este método posee dos características:
         *      1) La opacidad de la aplicación disminuye un 20%.
         *      2) Se obtiene la ubicación del Mouse en el momento.
         */
        
        // Se coloca la opacidad de la aplicación en 80%.
        //</editor-fold>
        setOpacity((float)0.8);
        
        // Se obtiene la ubicación del Mouse en el momento.
        xx = evt.getX(); // Ubicación con respecto al eje X.
        xy = evt.getY(); // Ubicación con respecto al eje Y.
    }//GEN-LAST:event_panTopBarMousePressed

    // Si se deja de presionar el click sobre la barra superior.
    private void panTopBarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panTopBarMouseReleased
        //<editor-fold defaultstate="collapsed" desc=" Explicación sobre el método ">
        /*
         * Este método devuelve la opacidad de la aplicación a su valor base.
         */
        
        // Se coloca la opacidad de la aplicación en 100%.
        //</editor-fold>
        setOpacity((float)1.0);
    }//GEN-LAST:event_panTopBarMouseReleased

    private void btnMinMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinMouseMoved
        btnMin.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnMinMouseMoved

    private void btnMinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinMouseExited
        btnMin.setBackground(new java.awt.Color(249,249,249));
    }//GEN-LAST:event_btnMinMouseExited

    private void btnExitMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseMoved
        btnExit.setBackground(new java.awt.Color(255,183,183));
    }//GEN-LAST:event_btnExitMouseMoved

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(new java.awt.Color(249,249,249));
    }//GEN-LAST:event_btnExitMouseExited

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Lateral Menu ">
    
    private void btnOptionLateral1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionLateral1MouseMoved
        btnOptionLateral1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnOptionLateral1MouseMoved

    private void btnOptionLateral1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionLateral1MouseExited
        btnOptionLateral1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnOptionLateral1MouseExited

    private void btnOptionLateral2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionLateral2MouseMoved
        btnOptionLateral2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnOptionLateral2MouseMoved

    private void btnOptionLateral2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionLateral2MouseExited
        btnOptionLateral2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnOptionLateral2MouseExited

    private void btnOptionLateral3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionLateral3MouseMoved
        btnOptionLateral3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnOptionLateral3MouseMoved

    private void btnOptionLateral3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionLateral3MouseExited
        btnOptionLateral3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnOptionLateral3MouseExited

    private void btnOptionLateral4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionLateral4MouseMoved
        btnOptionLateral4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnOptionLateral4MouseMoved

    private void btnOptionLateral4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionLateral4MouseExited
        btnOptionLateral4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnOptionLateral4MouseExited

    private void btnOptionLateral5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionLateral5MouseMoved
        btnOptionLateral5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnOptionLateral5MouseMoved

    private void btnOptionLateral5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionLateral5MouseExited
        btnOptionLateral5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnOptionLateral5MouseExited

    private void btnOptionLateral6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionLateral6MouseMoved
        btnOptionLateral6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnOptionLateral6MouseMoved

    private void btnOptionLateral6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOptionLateral6MouseExited
        btnOptionLateral6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnOptionLateral6MouseExited

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Main Menu -> Option 1 ">
    
    private void panBodyOption1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panBodyOption1MouseMoved
        panBodyOption1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_panBodyOption1MouseMoved

    private void panBodyOption1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panBodyOption1MouseExited
        panBodyOption1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_panBodyOption1MouseExited

    private void btnBodyOption1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyOption1MouseMoved
        panBodyOption1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnBodyOption1MouseMoved

    private void btnBodyOption1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyOption1MouseExited
        panBodyOption1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnBodyOption1MouseExited

    private void panBodyOption2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panBodyOption2MouseMoved
        panBodyOption2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_panBodyOption2MouseMoved

    private void panBodyOption2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panBodyOption2MouseExited
        panBodyOption2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_panBodyOption2MouseExited

    private void btnBodyOption2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyOption2MouseMoved
        panBodyOption2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnBodyOption2MouseMoved

    private void btnBodyOption2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyOption2MouseExited
        panBodyOption2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnBodyOption2MouseExited

    private void btnBodyOption3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyOption3MouseMoved
        panBodyOption3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnBodyOption3MouseMoved

    private void btnBodyOption3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyOption3MouseExited
        panBodyOption3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnBodyOption3MouseExited

    private void btnBodyOption4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyOption4MouseMoved
        panBodyOption4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnBodyOption4MouseMoved

    private void btnBodyOption4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyOption4MouseExited
        panBodyOption4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnBodyOption4MouseExited

    private void btnBodyOption5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyOption5MouseMoved
        panBodyOption5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnBodyOption5MouseMoved

    private void btnBodyOption5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyOption5MouseExited
        panBodyOption5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnBodyOption5MouseExited

    private void btnBodyOption6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyOption6MouseMoved
        panBodyOption6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnBodyOption6MouseMoved

    private void btnBodyOption6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyOption6MouseExited
        panBodyOption6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnBodyOption6MouseExited

    private void btnBodyOption7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyOption7MouseMoved
        panBodyOption7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnBodyOption7MouseMoved

    private void btnBodyOption7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyOption7MouseExited
        panBodyOption7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnBodyOption7MouseExited

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Main Menu -> Option 2 (Candy Sell)">
    
    //<editor-fold defaultstate="collapsed" desc=" Option 2 -> Decision ">
    
    private void btnCinemaDecisionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCinemaDecisionMouseExited
        panCapsuleCinemaDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnCinemaDecisionMouseExited

    private void btnCinemaDecisionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCinemaDecisionMouseMoved
        panCapsuleCinemaDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnCinemaDecisionMouseMoved
       
    private void btnCandyDecisionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCandyDecisionMouseExited
        panCapsuleCandyDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnCandyDecisionMouseExited

    private void btnCandyDecisionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCandyDecisionMouseMoved
        panCapsuleCandyDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnCandyDecisionMouseMoved

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Option 2 -> Back To Ticket Decision ">
    
    private void btnBackToTicketDecision1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToTicketDecision1MouseMoved
        btnBackToTicketDecision1.setBackground(new java.awt.Color(245,245,245));
    }//GEN-LAST:event_btnBackToTicketDecision1MouseMoved

    private void btnBackToTicketDecision1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToTicketDecision1MouseExited
        btnBackToTicketDecision1.setBackground(new java.awt.Color(249,249,249));
    }//GEN-LAST:event_btnBackToTicketDecision1MouseExited

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Option 2 -> Candy Sell "> 
    
    private void btnChangeSucursalCandySellMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeSucursalCandySellMouseMoved
        panChangeSucursalCandySell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnChangeSucursalCandySellMouseMoved

    private void btnChangeSucursalCandySellMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeSucursalCandySellMouseExited
        panChangeSucursalCandySell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnChangeSucursalCandySellMouseExited

    private void btnSearchClientCandySellMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchClientCandySellMouseMoved
        panSearchClientCandySell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnSearchClientCandySellMouseMoved

    private void btnSearchClientCandySellMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchClientCandySellMouseExited
        panSearchClientCandySell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnSearchClientCandySellMouseExited

    private void btnAddCandySellMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCandySellMouseMoved
        panAddCandySell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnAddCandySellMouseMoved

    private void btnAddCandySellMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCandySellMouseExited
        panAddCandySell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnAddCandySellMouseExited

    private void btnCandySellClearMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCandySellClearMouseMoved
        panCandySellClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnCandySellClear.setForeground(new java.awt.Color(255,255,255));
        panCandySellClear.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnCandySellClearMouseMoved

    private void btnCandySellClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCandySellClearMouseExited
        panCandySellClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnCandySellClear.setForeground(new java.awt.Color(0,0,0));
        panCandySellClear.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnCandySellClearMouseExited

    private void btnCandySellMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCandySellMouseMoved
        panButtonCandySell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnCandySell.setForeground(new java.awt.Color(255,255,255));
        panButtonCandySell.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnCandySellMouseMoved

    private void btnCandySellMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCandySellMouseExited
        panButtonCandySell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnCandySell.setForeground(new java.awt.Color(0,0,0));
        panButtonCandySell.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnCandySellMouseExited

    private void txtIdClientCandySellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdClientCandySellMouseClicked
        txtIdClientCandySell.setText("");
    }//GEN-LAST:event_txtIdClientCandySellMouseClicked

    private void txtIdClientCandySellKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdClientCandySellKeyTyped
        if(txtIdClientCandySell.getText().length() < 10)
            support.integerPositiveKeyTyped(evt);
        else
            evt.consume();
    }//GEN-LAST:event_txtIdClientCandySellKeyTyped

    private void tblCandyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCandyMouseClicked
        setColumnTable(tblCandy.getColumnModel().getColumnIndexAtX(evt.getX()));
        setRowTable(evt.getY()/tblCandy.getRowHeight());
    }//GEN-LAST:event_tblCandyMouseClicked

    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Botón de Cerrar Sesión ">
    
    private void btnOutMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOutMouseMoved
        btnOut.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnOutMouseMoved

    private void btnOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOutMouseExited
        btnOut.setBackground(new java.awt.Color(249,249,249));
    }//GEN-LAST:event_btnOutMouseExited

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Main Menu -> Option 2 (Cinema Tickets) ">
    
    private void btnBackToTicketDecision2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToTicketDecision2MouseMoved
        btnBackToTicketDecision2.setBackground(new java.awt.Color(245,245,245));
    }//GEN-LAST:event_btnBackToTicketDecision2MouseMoved

    private void btnBackToTicketDecision2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToTicketDecision2MouseExited
        btnBackToTicketDecision2.setBackground(new java.awt.Color(249,249,249));
    }//GEN-LAST:event_btnBackToTicketDecision2MouseExited

    private void btnChangeSucursalCinemaTicketsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeSucursalCinemaTicketsMouseMoved
        panChangeSucursalCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnChangeSucursalCinemaTicketsMouseMoved

    private void btnChangeSucursalCinemaTicketsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeSucursalCinemaTicketsMouseExited
        panChangeSucursalCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnChangeSucursalCinemaTicketsMouseExited

    //<editor-fold defaultstate="collapsed" desc=" First Step ">
    
    private void tblMovieSelectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMovieSelectorMouseClicked
        setColumnTable(tblMovieSelector.getColumnModel().getColumnIndexAtX(evt.getX()));
        setRowTable(evt.getY()/tblMovieSelector.getRowHeight());
    }//GEN-LAST:event_tblMovieSelectorMouseClicked

    private void tblFunctionSelectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFunctionSelectorMouseClicked
        setColumnTable(tblFunctionSelector.getColumnModel().getColumnIndexAtX(evt.getX()));
        setRowTable(evt.getY()/tblFunctionSelector.getRowHeight());
    }//GEN-LAST:event_tblFunctionSelectorMouseClicked

    private void btnSeatsClearMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeatsClearMouseMoved
        btnSeatsClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnSeatsClear.setForeground(new java.awt.Color(255,255,255));
        btnSeatsClear.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnSeatsClearMouseMoved

    private void btnSeatsClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeatsClearMouseExited
        btnSeatsClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnSeatsClear.setForeground(new java.awt.Color(0,0,0));
        btnSeatsClear.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnSeatsClearMouseExited

    private void btnBackToCantCinemaTicketsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToCantCinemaTicketsMouseMoved
        btnBackToCantCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnBackToCantCinemaTickets.setForeground(new java.awt.Color(255,255,255));
        btnBackToCantCinemaTickets.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnBackToCantCinemaTicketsMouseMoved

    private void btnBackToCantCinemaTicketsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToCantCinemaTicketsMouseExited
        btnBackToCantCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnBackToCantCinemaTickets.setForeground(new java.awt.Color(0,0,0));
        btnBackToCantCinemaTickets.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnBackToCantCinemaTicketsMouseExited

    private void btnFourthStepCinemaTicketsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFourthStepCinemaTicketsMouseMoved
        btnFourthStepCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnFourthStepCinemaTickets.setForeground(new java.awt.Color(255,255,255));
        btnFourthStepCinemaTickets.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnFourthStepCinemaTicketsMouseMoved

    private void btnFourthStepCinemaTicketsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFourthStepCinemaTicketsMouseExited
        btnFourthStepCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnFourthStepCinemaTickets.setForeground(new java.awt.Color(0,0,0));
        btnFourthStepCinemaTickets.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnFourthStepCinemaTicketsMouseExited

    private void txtIdClientCinemaSellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdClientCinemaSellMouseClicked
        txtIdClientCinemaSell.setText("");
    }//GEN-LAST:event_txtIdClientCinemaSellMouseClicked

    private void txtIdClientCinemaSellKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdClientCinemaSellKeyTyped
        if(txtIdClientCinemaSell.getText().length() < 10)
        support.integerPositiveKeyTyped(evt);
        else
        evt.consume();
    }//GEN-LAST:event_txtIdClientCinemaSellKeyTyped

    private void btnSearchClientCinemaSellMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchClientCinemaSellMouseMoved
        btnSearchClientCinemaSell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnSearchClientCinemaSellMouseMoved

    private void btnSearchClientCinemaSellMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchClientCinemaSellMouseExited
        btnSearchClientCinemaSell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnSearchClientCinemaSellMouseExited

    private void btnCinemaSellBackStepMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCinemaSellBackStepMouseMoved
        btnCinemaSellBackStep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnCinemaSellBackStep.setForeground(new java.awt.Color(255,255,255));
        btnCinemaSellBackStep.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnCinemaSellBackStepMouseMoved

    private void btnCinemaSellBackStepMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCinemaSellBackStepMouseExited
        btnCinemaSellBackStep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnCinemaSellBackStep.setForeground(new java.awt.Color(0,0,0));
        btnCinemaSellBackStep.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnCinemaSellBackStepMouseExited

    private void btnCinemaSellMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCinemaSellMouseMoved
        btnCinemaSell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnCinemaSell.setForeground(new java.awt.Color(255,255,255));
        btnCinemaSell.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnCinemaSellMouseMoved

    private void btnCinemaSellMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCinemaSellMouseExited
        btnCinemaSell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnCinemaSell.setForeground(new java.awt.Color(0,0,0));
        btnCinemaSell.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnCinemaSellMouseExited

    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Main Menu -> Bordes de las opciones en el MainPage ">
    
    private void btnUserDecisionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserDecisionMouseMoved
        panCapsuleUserDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnUserDecisionMouseMoved

    private void btnUserDecisionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserDecisionMouseExited
        panCapsuleUserDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnUserDecisionMouseExited

    private void btnBranchDecisionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBranchDecisionMouseMoved
        panCapsuleBranchDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnBranchDecisionMouseMoved

    private void btnBranchDecisionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBranchDecisionMouseExited
        panCapsuleBranchDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnBranchDecisionMouseExited

    private void btnCinemaRoomDecisionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCinemaRoomDecisionMouseMoved
        panCapsuleCinemaRoomDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnCinemaRoomDecisionMouseMoved

    private void btnCinemaRoomDecisionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCinemaRoomDecisionMouseExited
        panCapsuleCinemaRoomDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnCinemaRoomDecisionMouseExited

    private void btnEnterpriseDecisionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnterpriseDecisionMouseMoved
        panCapsuleEnterpriseDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnEnterpriseDecisionMouseMoved

    private void btnEnterpriseDecisionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnterpriseDecisionMouseExited
        panCapsuleEnterpriseDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnEnterpriseDecisionMouseExited

    private void btnFilmDecisionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFilmDecisionMouseMoved
        panCapsuleFilmDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnFilmDecisionMouseMoved

    private void btnFilmDecisionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFilmDecisionMouseExited
        panCapsuleFilmDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnFilmDecisionMouseExited

    private void btnCandyDecisionCLMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCandyDecisionCLMouseMoved
        panCapsuleCandyDecisionCL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnCandyDecisionCLMouseMoved

    private void btnCandyDecisionCLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCandyDecisionCLMouseExited
        panCapsuleCandyDecisionCL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnCandyDecisionCLMouseExited

    private void btnClientDecisionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientDecisionMouseMoved
        panCapsuleClientDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnClientDecisionMouseMoved

    private void btnClientDecisionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientDecisionMouseExited
        panCapsuleClientDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnClientDecisionMouseExited

    private void btnEmployeeDecisionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeDecisionMouseMoved
        panCapsuleEmployeeDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnEmployeeDecisionMouseMoved

    private void btnEmployeeDecisionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeDecisionMouseExited
        panCapsuleEmployeeDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnEmployeeDecisionMouseExited

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Second Step Cinema Tickets ">
    
    private void btnBackToSelectorMovieMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToSelectorMovieMouseMoved
        panButtonBackToSelectorMovie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnBackToSelectorMovie.setForeground(new java.awt.Color(255,255,255));
        panButtonBackToSelectorMovie.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnBackToSelectorMovieMouseMoved

    private void btnBackToSelectorMovieMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToSelectorMovieMouseExited
        panButtonBackToSelectorMovie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnBackToSelectorMovie.setForeground(new java.awt.Color(0,0,0));
        panButtonBackToSelectorMovie.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnBackToSelectorMovieMouseExited

    private void panButtonBackToSelectorMovieMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panButtonBackToSelectorMovieMouseMoved
        panButtonBackToSelectorMovie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnBackToSelectorMovie.setForeground(new java.awt.Color(255,255,255));
        panButtonBackToSelectorMovie.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_panButtonBackToSelectorMovieMouseMoved

    private void panButtonBackToSelectorMovieMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panButtonBackToSelectorMovieMouseExited
        panButtonBackToSelectorMovie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnBackToSelectorMovie.setForeground(new java.awt.Color(0,0,0));
        panButtonBackToSelectorMovie.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_panButtonBackToSelectorMovieMouseExited

    private void btnNextStepBuyTicketMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextStepBuyTicketMouseMoved
        panButtonNextStepBuyTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnNextStepBuyTicket.setForeground(new java.awt.Color(255,255,255));
        panButtonNextStepBuyTicket.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnNextStepBuyTicketMouseMoved

    private void btnNextStepBuyTicketMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextStepBuyTicketMouseExited
        panButtonNextStepBuyTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnNextStepBuyTicket.setForeground(new java.awt.Color(0,0,0));
        panButtonNextStepBuyTicket.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnNextStepBuyTicketMouseExited

    private void panButtonNextStepBuyTicketMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panButtonNextStepBuyTicketMouseMoved
        panButtonNextStepBuyTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnNextStepBuyTicket.setForeground(new java.awt.Color(255,255,255));
        panButtonNextStepBuyTicket.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_panButtonNextStepBuyTicketMouseMoved

    private void panButtonNextStepBuyTicketMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panButtonNextStepBuyTicketMouseExited
        panButtonNextStepBuyTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnNextStepBuyTicket.setForeground(new java.awt.Color(0,0,0));
        panButtonNextStepBuyTicket.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_panButtonNextStepBuyTicketMouseExited

    private void btnAddCinemaTickets1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCinemaTickets1MouseMoved
        btnAddCinemaTickets1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnAddCinemaTickets1MouseMoved

    private void btnAddCinemaTickets1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCinemaTickets1MouseExited
        btnAddCinemaTickets1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnAddCinemaTickets1MouseExited

    private void btnMinusCinemaTickets1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinusCinemaTickets1MouseMoved
        btnMinusCinemaTickets1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnMinusCinemaTickets1MouseMoved

    private void btnMinusCinemaTickets1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinusCinemaTickets1MouseExited
        btnMinusCinemaTickets1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnMinusCinemaTickets1MouseExited

    private void btnAddCinemaTickets2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCinemaTickets2MouseMoved
        btnAddCinemaTickets2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnAddCinemaTickets2MouseMoved

    private void btnAddCinemaTickets2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCinemaTickets2MouseExited
        btnAddCinemaTickets2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnAddCinemaTickets2MouseExited

    private void btnMinusCinemaTickets2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinusCinemaTickets2MouseMoved
        btnMinusCinemaTickets2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnMinusCinemaTickets2MouseMoved

    private void btnMinusCinemaTickets2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinusCinemaTickets2MouseExited
        btnMinusCinemaTickets2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnMinusCinemaTickets2MouseExited

    private void btnAddCinemaTickets3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCinemaTickets3MouseMoved
        btnAddCinemaTickets3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnAddCinemaTickets3MouseMoved

    private void btnAddCinemaTickets3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCinemaTickets3MouseExited
        btnAddCinemaTickets3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnAddCinemaTickets3MouseExited

    private void btnMinusCinemaTickets3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinusCinemaTickets3MouseMoved
        btnMinusCinemaTickets3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnMinusCinemaTickets3MouseMoved

    private void btnMinusCinemaTickets3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinusCinemaTickets3MouseExited
        btnMinusCinemaTickets3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnMinusCinemaTickets3MouseExited

    private void btnAddCinemaTickets4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCinemaTickets4MouseMoved
        btnAddCinemaTickets4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnAddCinemaTickets4MouseMoved

    private void btnAddCinemaTickets4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCinemaTickets4MouseExited
        btnAddCinemaTickets4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnAddCinemaTickets4MouseExited

    private void btnMinusCinemaTickets4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinusCinemaTickets4MouseMoved
        btnMinusCinemaTickets4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnMinusCinemaTickets4MouseMoved

    private void btnMinusCinemaTickets4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinusCinemaTickets4MouseExited
        btnMinusCinemaTickets4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnMinusCinemaTickets4MouseExited

    private void btnListClientDecisionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListClientDecisionMouseMoved
        panCapsuleCandyDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnListClientDecisionMouseMoved

    private void btnListClientDecisionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListClientDecisionMouseExited
        panCapsuleCandyDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnListClientDecisionMouseExited

    private void btnListEmployeeDecisionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListEmployeeDecisionMouseMoved
        btnListEmployeeDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnListEmployeeDecisionMouseMoved

    private void btnListEmployeeDecisionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListEmployeeDecisionMouseExited
        btnListEmployeeDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnListEmployeeDecisionMouseExited

    private void btnListPeliculasDecisionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListPeliculasDecisionMouseMoved
        btnListPeliculasDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnListPeliculasDecisionMouseMoved

    private void btnListPeliculasDecisionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListPeliculasDecisionMouseExited
        btnListPeliculasDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnListPeliculasDecisionMouseExited

    private void btnListClientDecision1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListClientDecision1MouseMoved
        btnListClientDecision1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnListClientDecision1MouseMoved

    private void btnListClientDecision1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListClientDecision1MouseExited
        btnListClientDecision1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnListClientDecision1MouseExited

    private void btnListClientDecision1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListClientDecision1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListClientDecision1ActionPerformed

    private void btnListClientDecision3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListClientDecision3MouseMoved
        btnListClientDecision3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnListClientDecision3MouseMoved

    private void btnListClientDecision3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListClientDecision3MouseExited
        btnListClientDecision3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnListClientDecision3MouseExited

    private void btnListClientDecision3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListClientDecision3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListClientDecision3ActionPerformed

    private void btnFunctionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFunctionMouseMoved
        btnFunction.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnFunctionMouseMoved

    private void btnFunctionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFunctionMouseExited
        btnFunction.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239,232,244)));
    }//GEN-LAST:event_btnFunctionMouseExited

    private void btnCandyInventoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCandyInventoryMouseExited
        btnCandyInventory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnCandyInventoryMouseExited

    private void btnCandyInventoryMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCandyInventoryMouseMoved
        btnCandyInventory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnCandyInventoryMouseMoved

    private void btnListPelculasGeneralMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListPelculasGeneralMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListPelculasGeneralMouseMoved

    private void btnListPelculasGeneralMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListPelculasGeneralMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListPelculasGeneralMouseExited

    private void btnListPelculasGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListPelculasGeneralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListPelculasGeneralActionPerformed

    private void btnListEmployeeDecision1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListEmployeeDecision1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListEmployeeDecision1MouseMoved

    private void btnListEmployeeDecision1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListEmployeeDecision1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListEmployeeDecision1MouseExited

    private void btnListEmployeeDecision1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListEmployeeDecision1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListEmployeeDecision1ActionPerformed

    //</editor-fold>
    
    /**
     * Método para retornar los valores gráficos de todos los botones de la
     * compra de tickets para funciones.
     */
    public void clearButtonsOfTheBuyCinemaTickets(){
        
        panButtonBackToSelectorMovie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnBackToSelectorMovie.setForeground(new java.awt.Color(0,0,0));
        panButtonBackToSelectorMovie.setBackground(new java.awt.Color(239,232,244));
        
        panButtonNextStepBuyTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnNextStepBuyTicket.setForeground(new java.awt.Color(0,0,0));
        panButtonNextStepBuyTicket.setBackground(new java.awt.Color(239,232,244));
        
        btnAddCinemaTickets1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnMinusCinemaTickets1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        
        btnAddCinemaTickets2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnMinusCinemaTickets2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        
        btnAddCinemaTickets3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnMinusCinemaTickets3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        
        btnAddCinemaTickets4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnMinusCinemaTickets4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        
        btnSeatsClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnSeatsClear.setForeground(new java.awt.Color(0,0,0));
        btnSeatsClear.setBackground(new java.awt.Color(239,232,244));
        
        btnBackToCantCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnBackToCantCinemaTickets.setForeground(new java.awt.Color(0,0,0));
        btnBackToCantCinemaTickets.setBackground(new java.awt.Color(239,232,244));
        
        btnFourthStepCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnFourthStepCinemaTickets.setForeground(new java.awt.Color(0,0,0));
        btnFourthStepCinemaTickets.setBackground(new java.awt.Color(239,232,244));
        
    }
        
    //<editor-fold defaultstate="collapsed" desc=" Declaración de Variables ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAddCandySell;
    public javax.swing.JButton btnAddCinemaTickets1;
    public javax.swing.JButton btnAddCinemaTickets2;
    public javax.swing.JButton btnAddCinemaTickets3;
    public javax.swing.JButton btnAddCinemaTickets4;
    public javax.swing.JButton btnBackToCantCinemaTickets;
    public javax.swing.JButton btnBackToSelectorMovie;
    public javax.swing.JButton btnBackToTicketDecision1;
    public javax.swing.JButton btnBackToTicketDecision2;
    public javax.swing.JButton btnBodyOption1;
    public javax.swing.JButton btnBodyOption2;
    public javax.swing.JButton btnBodyOption3;
    public javax.swing.JButton btnBodyOption4;
    public javax.swing.JButton btnBodyOption5;
    public javax.swing.JButton btnBodyOption6;
    public javax.swing.JButton btnBodyOption7;
    public javax.swing.JButton btnBranchDecision;
    public javax.swing.JButton btnCandyDecision;
    public javax.swing.JButton btnCandyDecisionCL;
    public javax.swing.JButton btnCandyInventory;
    public javax.swing.JButton btnCandySell;
    public javax.swing.JButton btnCandySellClear;
    public javax.swing.JButton btnChangeSucursalCandySell;
    public javax.swing.JButton btnChangeSucursalCinemaTickets;
    public javax.swing.JButton btnCinemaDecision;
    public javax.swing.JButton btnCinemaRoomDecision;
    public javax.swing.JButton btnCinemaSell;
    public javax.swing.JButton btnCinemaSellBackStep;
    public javax.swing.JButton btnClientDecision;
    public javax.swing.JButton btnEmployeeDecision;
    public javax.swing.JButton btnEnterpriseDecision;
    public javax.swing.JButton btnExit;
    public javax.swing.JButton btnFilmDecision;
    public javax.swing.JButton btnFourthStepCinemaTickets;
    public javax.swing.JButton btnFunction;
    public javax.swing.JButton btnListClientDecision;
    public javax.swing.JButton btnListClientDecision1;
    public javax.swing.JButton btnListClientDecision2;
    public javax.swing.JButton btnListClientDecision3;
    public javax.swing.JButton btnListEmployeeDecision;
    public javax.swing.JButton btnListEmployeeDecision1;
    public javax.swing.JButton btnListEmployeeDecision2;
    public javax.swing.JButton btnListPelculasGeneral;
    public javax.swing.JButton btnListPeliculasDecision;
    public javax.swing.JButton btnListPeliculasXmes;
    public javax.swing.JButton btnMin;
    public javax.swing.JButton btnMinusCinemaTickets1;
    public javax.swing.JButton btnMinusCinemaTickets2;
    public javax.swing.JButton btnMinusCinemaTickets3;
    public javax.swing.JButton btnMinusCinemaTickets4;
    public javax.swing.JButton btnNextStepBuyTicket;
    public javax.swing.JButton btnOptionLateral1;
    public javax.swing.JButton btnOptionLateral2;
    public javax.swing.JButton btnOptionLateral3;
    public javax.swing.JButton btnOptionLateral4;
    public javax.swing.JButton btnOptionLateral5;
    public javax.swing.JButton btnOptionLateral6;
    public javax.swing.JButton btnOut;
    public javax.swing.JButton btnSearchClientCandySell;
    public javax.swing.JButton btnSearchClientCinemaSell;
    public javax.swing.JButton btnSeatsClear;
    public javax.swing.JButton btnUserDecision;
    public javax.swing.JComboBox<String> cmbCandySelection;
    public javax.swing.JComboBox<String> cmbCandySeller;
    public javax.swing.JComboBox<String> cmbCinemaSeller;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblADCmark;
    private javax.swing.JLabel lblAmountAdultTicket;
    private javax.swing.JLabel lblAmountChildTicket;
    private javax.swing.JLabel lblAmountKinderTicket;
    private javax.swing.JLabel lblAmountOldTicket;
    private javax.swing.JLabel lblCDVlogo;
    private javax.swing.JLabel lblCandySelection;
    private javax.swing.JLabel lblCandySelection2;
    private javax.swing.JLabel lblCandySellTittle;
    private javax.swing.JLabel lblCandySeller;
    private javax.swing.JLabel lblCantCandySell;
    public javax.swing.JLabel lblCantCinemaTickets1;
    public javax.swing.JLabel lblCantCinemaTickets2;
    public javax.swing.JLabel lblCantCinemaTickets3;
    public javax.swing.JLabel lblCantCinemaTickets4;
    private javax.swing.JLabel lblCantSeatsToSelect;
    public javax.swing.JLabel lblCantSeatsToSelectNumber;
    private javax.swing.JLabel lblCinemaSeller;
    private javax.swing.JLabel lblCinemaTickets;
    public javax.swing.JLabel lblClientCedulaCandySell;
    private javax.swing.JLabel lblDateOfMovie;
    public javax.swing.JLabel lblDateOfMovieSell;
    private javax.swing.JLabel lblDescAdultTicket;
    private javax.swing.JLabel lblDescChildTicket;
    private javax.swing.JLabel lblDescKinderTicket;
    private javax.swing.JLabel lblDescOldTicket;
    private javax.swing.JLabel lblEmployeeeDecision;
    private javax.swing.JLabel lblFreeSeats;
    public javax.swing.JLabel lblFreeSeatsCant;
    private javax.swing.JLabel lblFunctionSelector;
    private javax.swing.JLabel lblIVAAdultTicket;
    public javax.swing.JLabel lblIVAAmountAdultTicket;
    public javax.swing.JLabel lblIVAAmountChildTicket;
    public javax.swing.JLabel lblIVAAmountKinderTicket;
    public javax.swing.JLabel lblIVAAmountOldTicket;
    public javax.swing.JLabel lblIVAAmountTicket;
    public javax.swing.JLabel lblIVACandySell;
    private javax.swing.JLabel lblIVAChildTicket;
    public javax.swing.JLabel lblIVACinemaSell;
    private javax.swing.JLabel lblIVAKinderTicket;
    private javax.swing.JLabel lblIVAOldTicket;
    private javax.swing.JLabel lblIVATicket;
    private javax.swing.JLabel lblMovieSelector;
    private javax.swing.JLabel lblMovieTicket;
    public javax.swing.JLabel lblMovieTicketSell;
    public javax.swing.JLabel lblPriceTicketAdult;
    public javax.swing.JLabel lblPriceTicketChild;
    public javax.swing.JLabel lblPriceTicketKinder;
    public javax.swing.JLabel lblPriceTicketOld;
    private javax.swing.JLabel lblSelectedSeats;
    public javax.swing.JLabel lblSelectedSeatsCant;
    private javax.swing.JLabel lblShowCinemaTickets;
    public javax.swing.JLabel lblSubTotalCandySell;
    public javax.swing.JLabel lblSubTotalCinemaSell;
    private javax.swing.JLabel lblSubtotalAdultTicket;
    public javax.swing.JLabel lblSubtotalAmountAdultTicket;
    public javax.swing.JLabel lblSubtotalAmountChildTicket;
    public javax.swing.JLabel lblSubtotalAmountKinderTicket;
    public javax.swing.JLabel lblSubtotalAmountOldTicket;
    public javax.swing.JLabel lblSubtotalAmountTicket;
    private javax.swing.JLabel lblSubtotalChildTicket;
    private javax.swing.JLabel lblSubtotalKinderTicket;
    private javax.swing.JLabel lblSubtotalOldTicket;
    private javax.swing.JLabel lblSubtotalTicket;
    public javax.swing.JLabel lblSucursalNameCandySell;
    public javax.swing.JLabel lblSucursalNameCinemaTickets;
    private javax.swing.JLabel lblTittleOption1;
    private javax.swing.JLabel lblTittleOption2;
    private javax.swing.JLabel lblTittleOption4;
    private javax.swing.JLabel lblTittleOption5;
    private javax.swing.JLabel lblTittleOption6;
    private javax.swing.JLabel lblTittleOption7;
    private javax.swing.JLabel lblTittleOption8;
    private javax.swing.JLabel lblTittleOption9;
    private javax.swing.JLabel lblTittleSelectorSeat;
    private javax.swing.JLabel lblTotalAdultTicket;
    public javax.swing.JLabel lblTotalAmountAdultTicket;
    public javax.swing.JLabel lblTotalAmountChildTicket;
    public javax.swing.JLabel lblTotalAmountKinderTicket;
    public javax.swing.JLabel lblTotalAmountOldTicket;
    public javax.swing.JLabel lblTotalAmountTicket;
    public javax.swing.JLabel lblTotalCandySell;
    private javax.swing.JLabel lblTotalChildTicket;
    public javax.swing.JLabel lblTotalCinemaSell;
    private javax.swing.JLabel lblTotalKinderTicket;
    private javax.swing.JLabel lblTotalOldTicket;
    private javax.swing.JLabel lblTotalSeats;
    public javax.swing.JLabel lblTotalSeatsCant;
    private javax.swing.JLabel lblTotalTicket;
    private javax.swing.JPanel panAddCandySell;
    public javax.swing.JPanel panBodyOption1;
    public javax.swing.JPanel panBodyOption2;
    public javax.swing.JPanel panBodyOption3;
    public javax.swing.JPanel panBodyOption4;
    public javax.swing.JPanel panBodyOption5;
    public javax.swing.JPanel panBodyOption6;
    public javax.swing.JPanel panBodyOption7;
    public javax.swing.JPanel panBodyOptions1;
    private javax.swing.JPanel panButtonBackToSelectorMovie;
    private javax.swing.JPanel panButtonCandySell;
    private javax.swing.JPanel panButtonListClient;
    private javax.swing.JPanel panButtonListEmployee;
    private javax.swing.JPanel panButtonListPeliculas2;
    private javax.swing.JPanel panButtonNextStepBuyTicket;
    private javax.swing.JPanel panButtonsTopBar;
    public javax.swing.JPanel panCandySell;
    public javax.swing.JPanel panCandySellClear;
    public javax.swing.JPanel panCapsuleBranchDecision;
    public javax.swing.JPanel panCapsuleCandyDecision;
    private javax.swing.JPanel panCapsuleCandyDecisionCL;
    private javax.swing.JPanel panCapsuleCandyInventory;
    private javax.swing.JPanel panCapsuleCandyInventory2;
    public javax.swing.JPanel panCapsuleCinemaDecision;
    private javax.swing.JPanel panCapsuleCinemaRoomDecision;
    private javax.swing.JPanel panCapsuleClientDecision;
    public javax.swing.JPanel panCapsuleEmployeeDecision;
    private javax.swing.JPanel panCapsuleEnterpriseDecision;
    public javax.swing.JPanel panCapsuleFilmDecision;
    public javax.swing.JPanel panCapsuleListClientDecision;
    public javax.swing.JPanel panCapsuleListEmployeeDecision;
    public javax.swing.JPanel panCapsuleListPeliculasDecision;
    private javax.swing.JPanel panCapsuleUserDecision;
    private javax.swing.JPanel panChangeSucursalCandySell;
    private javax.swing.JPanel panChangeSucursalCinemaTickets;
    public javax.swing.JPanel panCinemaSell;
    public javax.swing.JPanel panContent;
    public javax.swing.JPanel panDecisionOption2;
    public javax.swing.JPanel panDecisionOption3;
    public javax.swing.JPanel panDecisionOption4;
    public javax.swing.JPanel panDecisionOption5;
    public javax.swing.JPanel panDecisionOption6;
    public javax.swing.JPanel panFirstStepCinemaTickets;
    public javax.swing.JPanel panFourthStepCinemaTickets;
    private javax.swing.JPanel panLateralMenu;
    private javax.swing.JPanel panLateralOptions;
    public javax.swing.JPanel panListClientDecision;
    public javax.swing.JPanel panListClientDecision1;
    public javax.swing.JPanel panListEmployeeDecision;
    public javax.swing.JPanel panListEmployeeDecision1;
    public javax.swing.JPanel panListPeliculaDecision;
    public javax.swing.JPanel panListPeliculasDecision3;
    private javax.swing.JPanel panMainMenu;
    private javax.swing.JPanel panMainPage;
    public javax.swing.JPanel panOption1;
    public javax.swing.JPanel panOption2;
    public javax.swing.JPanel panOption3;
    public javax.swing.JPanel panOption4;
    public javax.swing.JPanel panOption5;
    public javax.swing.JPanel panOption6;
    public javax.swing.JPanel panSearchClientCandySell;
    public javax.swing.JPanel panSecondStepCinemaTickets;
    public javax.swing.JPanel panSelectorSeats;
    public javax.swing.JPanel panStepsCinemaTickets;
    public javax.swing.JPanel panTheaterSeatChart;
    public javax.swing.JPanel panThirdStepCinemaTickets;
    private javax.swing.JPanel panTopBar;
    private javax.swing.JPanel panTopBarLateralMenu;
    public javax.swing.JProgressBar pgrCinemaTickets;
    private javax.swing.JScrollPane scpBodyOption1;
    private javax.swing.JScrollPane scpCandyTable;
    private javax.swing.JScrollPane scpCinemaTicketsTable;
    private javax.swing.JScrollPane scpFunctionSelector;
    private javax.swing.JScrollPane scpMovieSelector;
    private javax.swing.JSeparator sepBodyOption1;
    private javax.swing.JSeparator sepBodyOption2;
    private javax.swing.JSeparator sepBodyOption3;
    private javax.swing.JSeparator sepBodyOption4;
    private javax.swing.JSeparator sepBodyOption5;
    private javax.swing.JSeparator sepBodyOption6;
    private javax.swing.JSeparator sepBodyOption7;
    private javax.swing.JSeparator sepBodyOption8;
    private javax.swing.JSeparator sepBranchDecision;
    private javax.swing.JSeparator sepBranchDecision1;
    private javax.swing.JSeparator sepBranchDecision2;
    private javax.swing.JSeparator sepBranchDecision3;
    private javax.swing.JSeparator sepCandyDecision;
    private javax.swing.JSeparator sepCandySellTittle;
    private javax.swing.JSeparator sepCinemaDecision;
    private javax.swing.JSeparator sepCinemaRoomDecision;
    private javax.swing.JSeparator sepCinemaRoomDecision1;
    private javax.swing.JSeparator sepCinemaRoomDecision2;
    private javax.swing.JSeparator sepCinemaRoomDecision3;
    private javax.swing.JSeparator sepCinemaRoomDecision4;
    private javax.swing.JSeparator sepCinemaRoomDecision5;
    private javax.swing.JSeparator sepCinemaSellTittle;
    private javax.swing.JSeparator sepClientCinemaTicket;
    private javax.swing.JSeparator sepEnterpriseDecision;
    private javax.swing.JSeparator sepEnterpriseDecision1;
    private javax.swing.JSeparator sepLateralMenu;
    private javax.swing.JSeparator sepTittleOption1;
    private javax.swing.JSeparator sepTittleOption2;
    private javax.swing.JSeparator sepTittleOption3;
    private javax.swing.JSeparator sepTittleOption4;
    private javax.swing.JSeparator sepTittleOption5;
    private javax.swing.JSeparator sepTittleOption6;
    private javax.swing.JSeparator sepTittleOption7;
    private javax.swing.JSeparator sepTittleOption8;
    private javax.swing.JSeparator sepTittleOption9;
    public javax.swing.JSpinner spnCantCandySell;
    public javax.swing.JTable tblCandy;
    public javax.swing.JTable tblCinemaTickets;
    public javax.swing.JTable tblFunctionSelector;
    public javax.swing.JTable tblMovieSelector;
    public javax.swing.JTextField txtIVACandy;
    public javax.swing.JTextField txtIVACinema;
    public javax.swing.JTextField txtIdClientCandySell;
    public javax.swing.JTextField txtIdClientCinemaSell;
    public javax.swing.JTextField txtSubTotalCandy;
    public javax.swing.JTextField txtSubTotalCinema;
    public javax.swing.JTextField txtTotalCandy;
    public javax.swing.JTextField txtTotalCinema;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
