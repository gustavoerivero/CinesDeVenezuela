package views;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import views.tables.Table;

import lib.SuportFunctions;

/**
 *
 * @author Gustavo
 */
public class MainPage extends javax.swing.JFrame {

    // Variables de apoyo para conocer la ubicación de la aplicación.
    int xx = 0, xy = 0;
    
    // Variables de soporte para el uso de tablas.
    int column = 0, row = 0;
    
    // Se instancia la clase de soporte Table.
    Table table = new Table();
    
    // Se instancia la clase de soporte.
    private SuportFunctions suport;
    
    /**
     * Constructor MainPage.
     */
    public MainPage() {
        
        // Inicializa todas las variables (o mejor dicho componentes) que usa el JFrame.
        initComponents();
        
        // Se instancia la clase de soporte.
        suport = new SuportFunctions();
        
        // Ubica el JFrame en el centro de la pantalla.
        setLocationRelativeTo(null);
        
        // Muestra el JFrame.
        setVisible(true);
        
        // Cambia el ícono del JFrame.
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("images/CDV-icon.png")).getImage());
        
        // Iniciar la aplicación en la opción 1 (Home).
        suport.cardSelection(panContent, panOption1);
                
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
                
                
            // Eventos de los botones de la opción 4 -> Empleado.
                btnAddEmployee.addActionListener(evt);
            
        
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

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Set y get de Tablas ">
   public JTable getTblEmployee(){
        
        return tblEmployee;
        
    }
    /**
     * Método que retorna los valores iniciales de los componentes de 
     * JPanel de Candy Sell.
     */
    public void setTblEmployee(JTable tblEmployee) {
        this.tblEmployee = tblEmployee;
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
        txtSubTotalCandy.setText("");
        txtIVACandy.setText("");
        txtTotalCandy.setText("");
        clearCandyTable(tblCandy);
        
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
        btnForuthStepCinemaTickets = new javax.swing.JButton();
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
        panOption3 = new javax.swing.JPanel();
        lblTittleOption3 = new javax.swing.JLabel();
        sepTittleOption3 = new javax.swing.JSeparator();
        panOption4 = new javax.swing.JPanel();
        panEmployeeForm = new javax.swing.JPanel();
        btnBackToTicketDecision4 = new javax.swing.JButton();
        sepEmployeeTittle = new javax.swing.JSeparator();
        lblEmployeeTittle = new javax.swing.JLabel();
        lblSucursalNameEmployee = new javax.swing.JLabel();
        txtIEmployeeForm = new javax.swing.JTextField();
        lblEmployeeFiltro = new javax.swing.JLabel();
        cmbEmployeForm = new javax.swing.JComboBox<>();
        panChangeSucursalEmpleado1 = new javax.swing.JPanel();
        btnChangeSucursalEmployee = new javax.swing.JButton();
        panSearchEmpleado1 = new javax.swing.JPanel();
        btnSearchEmployee = new javax.swing.JButton();
        panAddEmployee = new javax.swing.JPanel();
        btnAddEmployee = new javax.swing.JButton();
        jSeparatorEmployee = new javax.swing.JSeparator();
        scpEmployee = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        panOption5 = new javax.swing.JPanel();
        lblTittleOption5 = new javax.swing.JLabel();
        sepTittleOption5 = new javax.swing.JSeparator();
        panOption6 = new javax.swing.JPanel();
        sepTittleOption6 = new javax.swing.JSeparator();

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
        btnOut.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnMin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnOptionLateral1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnOptionLateral2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnOptionLateral3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnOptionLateral4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnOptionLateral5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnOptionLateral6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/settingsIcon.png"))); // NOI18N
        btnOptionLateral6.setText("Configuración");
        btnOptionLateral6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnOptionLateral6.setContentAreaFilled(false);
        btnOptionLateral6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
            .addComponent(btnOptionLateral5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOptionLateral3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOptionLateral2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOptionLateral4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOptionLateral6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
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
            .addComponent(lblCDVlogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        panBodyOption2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        panBodyOption3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
        panBodyOption4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
        panBodyOption5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
        panBodyOption6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        panCapsuleCandyDecision.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnCandyDecision.setBackground(new java.awt.Color(249, 249, 249));
        btnCandyDecision.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCandyDecision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/candyIcon.png"))); // NOI18N
        btnCandyDecision.setText("<html><b><FONT SIZE=4>Tickets para golosinas</Font></b><br><p align=’justify’>Gestiona la venta de las golosinas por medio de tickets únicos y personalizados para cada cliente.</p></html>");
        btnCandyDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnCandyDecision.setBorderPainted(false);
        btnCandyDecision.setContentAreaFilled(false);
        btnCandyDecision.setFocusPainted(false);
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
        btnCandyDecision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCandyDecisionActionPerformed(evt);
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
        panCapsuleCinemaDecision.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnCinemaDecision.setBackground(new java.awt.Color(249, 249, 249));
        btnCinemaDecision.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCinemaDecision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/ticketBuyIcon.png"))); // NOI18N
        btnCinemaDecision.setText("<html><b><FONT SIZE=4>Tickets para funciones</Font></b><br><p align=’justify’>Realiza la venta de los boletos de las funciones disponibles que proporciona la sucursal indicada.</p></html>");
        btnCinemaDecision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnCinemaDecision.setBorderPainted(false);
        btnCinemaDecision.setContentAreaFilled(false);
        btnCinemaDecision.setFocusPainted(false);
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
                        .addGap(0, 44, Short.MAX_VALUE)
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
                .addContainerGap(366, Short.MAX_VALUE))
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
        btnBackToTicketDecision1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnChangeSucursalCandySell.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
            .addComponent(btnChangeSucursalCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        btnSearchClientCandySell.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnAddCandySell.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnCandySellClear.setForeground(new java.awt.Color(0, 0, 0));
        btnCandySellClear.setText("Limpiar");
        btnCandySellClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCandySellClear.setBorderPainted(false);
        btnCandySellClear.setContentAreaFilled(false);
        btnCandySellClear.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnCandySellClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCandySellClearActionPerformed(evt);
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
        btnCandySell.setForeground(new java.awt.Color(0, 0, 0));
        btnCandySell.setText("Vender");
        btnCandySell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCandySell.setBorderPainted(false);
        btnCandySell.setContentAreaFilled(false);
        btnCandySell.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        tblCandy.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
                                    .addComponent(lblCandySelection2)
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
                    .addComponent(panChangeSucursalCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panCandySellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnBackToTicketDecision1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCandySellTittle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                    .addComponent(lblSucursalNameCandySell, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(15, 15, 15)
                .addComponent(lblCandySelection2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        btnBackToTicketDecision2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnChangeSucursalCinemaTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        pgrCinemaTickets.setBorder(null);
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
        tblMovieSelector.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        tblFunctionSelector.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnBackToSelectorMovie.setForeground(new java.awt.Color(0, 0, 0));
        btnBackToSelectorMovie.setText("Atrás");
        btnBackToSelectorMovie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBackToSelectorMovie.setBorderPainted(false);
        btnBackToSelectorMovie.setContentAreaFilled(false);
        btnBackToSelectorMovie.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnNextStepBuyTicket.setForeground(new java.awt.Color(0, 0, 0));
        btnNextStepBuyTicket.setText("Siguiente");
        btnNextStepBuyTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNextStepBuyTicket.setBorderPainted(false);
        btnNextStepBuyTicket.setContentAreaFilled(false);
        btnNextStepBuyTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnAddCinemaTickets1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnMinusCinemaTickets1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnAddCinemaTickets2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnMinusCinemaTickets2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnAddCinemaTickets3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnMinusCinemaTickets3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnAddCinemaTickets4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnMinusCinemaTickets4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDescAdultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblDescOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblDescChildTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblDescKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addComponent(panButtonBackToSelectorMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panButtonNextStepBuyTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(lblPriceTicketChild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addComponent(lblAmountOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPriceTicketOld, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblTotalTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotalAmountTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIVAKinderTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(lblTotalKinderTicket))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubtotalAmountKinderTicket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIVAAmountKinderTicket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalAmountKinderTicket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIVAAdultTicket, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTotalAdultTicket)
                                    .addComponent(lblSubtotalAdultTicket)))
                            .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnMinusCinemaTickets2)
                                            .addComponent(btnAddCinemaTickets2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCantCinemaTickets2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnMinusCinemaTickets3)
                                            .addComponent(btnAddCinemaTickets3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCantCinemaTickets3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnMinusCinemaTickets4)
                                            .addComponent(btnAddCinemaTickets4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCantCinemaTickets4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                        .addComponent(lblSubtotalKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(lblSubtotalChildTicket)
                                    .addComponent(lblIVAChildTicket)
                                    .addComponent(lblTotalChildTicket))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblSubtotalAmountAdultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblIVAAmountAdultTicket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(lblTotalAmountAdultTicket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(lblSubtotalAmountChildTicket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblIVAAmountChildTicket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblTotalAmountChildTicket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblSubtotalAmountOldTicket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblIVAAmountOldTicket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTotalAmountOldTicket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnMinusCinemaTickets1)
                                    .addComponent(btnAddCinemaTickets1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCantCinemaTickets1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblSubtotalTicket, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblIVATicket, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIVAAmountTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblTotalOldTicket)
                                    .addComponent(lblSubtotalOldTicket)
                                    .addComponent(lblIVAOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSubtotalAmountTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(19, 19, 19))
        );
        panSecondStepCinemaTicketsLayout.setVerticalGroup(
            panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addComponent(lblDescAdultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAmountAdultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPriceTicketAdult)))
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
                    .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblCantCinemaTickets1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panSecondStepCinemaTicketsLayout.createSequentialGroup()
                            .addComponent(btnAddCinemaTickets1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnMinusCinemaTickets1))))
                .addGap(18, 18, 18)
                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addComponent(lblDescKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAmountKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPriceTicketKinder)))
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSubtotalKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtotalAmountKinderTicket))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIVAKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIVAAmountKinderTicket))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalKinderTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalAmountKinderTicket)))
                    .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblCantCinemaTickets2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panSecondStepCinemaTicketsLayout.createSequentialGroup()
                            .addComponent(btnAddCinemaTickets2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnMinusCinemaTickets2))))
                .addGap(14, 14, 14)
                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblCantCinemaTickets3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panSecondStepCinemaTicketsLayout.createSequentialGroup()
                            .addComponent(btnAddCinemaTickets3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnMinusCinemaTickets3)))
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addComponent(lblDescChildTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAmountChildTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPriceTicketChild)))
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
                            .addComponent(lblTotalAmountChildTicket))))
                .addGap(18, 18, 18)
                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblCantCinemaTickets4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panSecondStepCinemaTicketsLayout.createSequentialGroup()
                            .addComponent(btnAddCinemaTickets4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnMinusCinemaTickets4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAmountOldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPriceTicketOld))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSecondStepCinemaTicketsLayout.createSequentialGroup()
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSubtotalTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtotalAmountTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIVATicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIVAAmountTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSecondStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTotalAmountTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panButtonBackToSelectorMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panButtonNextStepBuyTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
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
            .addGap(0, 406, Short.MAX_VALUE)
            .addGroup(panSelectorSeatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panSelectorSeatsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panTheaterSeatChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panSelectorSeatsLayout.setVerticalGroup(
            panSelectorSeatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
            .addGroup(panSelectorSeatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panSelectorSeatsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panTheaterSeatChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        btnSeatsClear.setBackground(new java.awt.Color(239, 232, 244));
        btnSeatsClear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSeatsClear.setForeground(new java.awt.Color(0, 0, 0));
        btnSeatsClear.setText("Limpiar");
        btnSeatsClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSeatsClear.setBorderPainted(false);
        btnSeatsClear.setContentAreaFilled(false);
        btnSeatsClear.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSeatsClear.setFocusPainted(false);
        btnSeatsClear.setOpaque(true);
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
        btnBackToCantCinemaTickets.setForeground(new java.awt.Color(0, 0, 0));
        btnBackToCantCinemaTickets.setText("Atrás");
        btnBackToCantCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBackToCantCinemaTickets.setBorderPainted(false);
        btnBackToCantCinemaTickets.setContentAreaFilled(false);
        btnBackToCantCinemaTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBackToCantCinemaTickets.setFocusPainted(false);
        btnBackToCantCinemaTickets.setOpaque(true);
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

        btnForuthStepCinemaTickets.setBackground(new java.awt.Color(239, 232, 244));
        btnForuthStepCinemaTickets.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnForuthStepCinemaTickets.setForeground(new java.awt.Color(0, 0, 0));
        btnForuthStepCinemaTickets.setText("Aceptar");
        btnForuthStepCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnForuthStepCinemaTickets.setBorderPainted(false);
        btnForuthStepCinemaTickets.setContentAreaFilled(false);
        btnForuthStepCinemaTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnForuthStepCinemaTickets.setFocusPainted(false);
        btnForuthStepCinemaTickets.setOpaque(true);
        btnForuthStepCinemaTickets.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnForuthStepCinemaTicketsMouseMoved(evt);
            }
        });
        btnForuthStepCinemaTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnForuthStepCinemaTicketsMouseExited(evt);
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
                            .addComponent(btnSeatsClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBackToCantCinemaTickets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnForuthStepCinemaTickets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panThirdStepCinemaTicketsLayout.createSequentialGroup()
                                .addGroup(panThirdStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblTotalSeats, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSelectedSeats, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCantSeatsToSelect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFreeSeats, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panThirdStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotalSeatsCant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFreeSeatsCant, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                    .addComponent(lblSelectedSeatsCant, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                    .addComponent(lblCantSeatsToSelectNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))))))
                .addGap(30, 30, 30))
        );
        panThirdStepCinemaTicketsLayout.setVerticalGroup(
            panThirdStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panThirdStepCinemaTicketsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(btnSeatsClear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBackToCantCinemaTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnForuthStepCinemaTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panThirdStepCinemaTicketsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panSelectorSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );

        panStepsCinemaTickets.add(panThirdStepCinemaTickets, "card4");

        panFourthStepCinemaTickets.setBackground(new java.awt.Color(249, 249, 249));

        javax.swing.GroupLayout panFourthStepCinemaTicketsLayout = new javax.swing.GroupLayout(panFourthStepCinemaTickets);
        panFourthStepCinemaTickets.setLayout(panFourthStepCinemaTicketsLayout);
        panFourthStepCinemaTicketsLayout.setHorizontalGroup(
            panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 673, Short.MAX_VALUE)
        );
        panFourthStepCinemaTicketsLayout.setVerticalGroup(
            panFourthStepCinemaTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
        );

        panStepsCinemaTickets.add(panFourthStepCinemaTickets, "card5");

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
                .addComponent(panStepsCinemaTickets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panOption2.add(panCinemaSell, "card2");

        panContent.add(panOption2, "card2");

        panOption3.setBackground(new java.awt.Color(249, 249, 249));
        panOption3.setPreferredSize(new java.awt.Dimension(685, 620));

        lblTittleOption3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTittleOption3.setForeground(new java.awt.Color(28, 0, 63));
        lblTittleOption3.setText("Reportes");
        lblTittleOption3.setToolTipText("");

        sepTittleOption3.setBackground(new java.awt.Color(249, 249, 249));
        sepTittleOption3.setForeground(new java.awt.Color(239, 232, 244));

        javax.swing.GroupLayout panOption3Layout = new javax.swing.GroupLayout(panOption3);
        panOption3.setLayout(panOption3Layout);
        panOption3Layout.setHorizontalGroup(
            panOption3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panOption3Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(lblTittleOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(sepTittleOption3)
        );
        panOption3Layout.setVerticalGroup(
            panOption3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOption3Layout.createSequentialGroup()
                .addComponent(lblTittleOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTittleOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 519, Short.MAX_VALUE))
        );

        panContent.add(panOption3, "card2");

        panOption4.setBackground(new java.awt.Color(249, 249, 249));
        panOption4.setPreferredSize(new java.awt.Dimension(685, 620));
        panOption4.setLayout(new java.awt.CardLayout());

        panEmployeeForm.setBackground(new java.awt.Color(249, 249, 249));
        panEmployeeForm.setForeground(new java.awt.Color(239, 232, 244));
        panEmployeeForm.setMaximumSize(new java.awt.Dimension(685, 580));
        panEmployeeForm.setMinimumSize(new java.awt.Dimension(685, 580));

        btnBackToTicketDecision4.setBackground(new java.awt.Color(249, 249, 249));
        btnBackToTicketDecision4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBackToTicketDecision4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/backToIcon.png"))); // NOI18N
        btnBackToTicketDecision4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 232, 244)));
        btnBackToTicketDecision4.setBorderPainted(false);
        btnBackToTicketDecision4.setContentAreaFilled(false);
        btnBackToTicketDecision4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBackToTicketDecision4.setFocusPainted(false);
        btnBackToTicketDecision4.setIconTextGap(25);
        btnBackToTicketDecision4.setOpaque(true);
        btnBackToTicketDecision4.setPreferredSize(null);
        btnBackToTicketDecision4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBackToTicketDecision4MouseMoved(evt);
            }
        });
        btnBackToTicketDecision4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackToTicketDecision4MouseExited(evt);
            }
        });

        sepEmployeeTittle.setBackground(new java.awt.Color(249, 249, 249));
        sepEmployeeTittle.setForeground(new java.awt.Color(239, 232, 244));

        lblEmployeeTittle.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblEmployeeTittle.setForeground(new java.awt.Color(28, 0, 63));
        lblEmployeeTittle.setText("Empleados");
        lblEmployeeTittle.setToolTipText("");

        lblSucursalNameEmployee.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSucursalNameEmployee.setForeground(new java.awt.Color(75, 0, 145));
        lblSucursalNameEmployee.setText("Sucursal ");

        txtIEmployeeForm.setBackground(new java.awt.Color(249, 249, 249));
        txtIEmployeeForm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIEmployeeForm.setText("Cédula del Empleado");
        txtIEmployeeForm.setBorder(null);
        txtIEmployeeForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIEmployeeFormMouseClicked(evt);
            }
        });
        txtIEmployeeForm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIEmployeeFormKeyTyped(evt);
            }
        });

        lblEmployeeFiltro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEmployeeFiltro.setText("Filtro");

        cmbEmployeForm.setBackground(new java.awt.Color(249, 249, 249));
        cmbEmployeForm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbEmployeForm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " - Seleccionar - ", "Esteban Dido", "Ana Tomía", "Armando Casas" }));
        cmbEmployeForm.setBorder(null);
        cmbEmployeForm.setLightWeightPopupEnabled(false);

        panChangeSucursalEmpleado1.setBackground(new java.awt.Color(249, 249, 249));
        panChangeSucursalEmpleado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));

        btnChangeSucursalEmployee.setBackground(new java.awt.Color(249, 249, 249));
        btnChangeSucursalEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/shopIcon.png"))); // NOI18N
        btnChangeSucursalEmployee.setToolTipText("Cambiar Sucursal");
        btnChangeSucursalEmployee.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(249, 249, 249), 1, true));
        btnChangeSucursalEmployee.setBorderPainted(false);
        btnChangeSucursalEmployee.setContentAreaFilled(false);
        btnChangeSucursalEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnChangeSucursalEmployee.setFocusPainted(false);
        btnChangeSucursalEmployee.setPreferredSize(new java.awt.Dimension(50, 50));
        btnChangeSucursalEmployee.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnChangeSucursalEmployeeMouseMoved(evt);
            }
        });
        btnChangeSucursalEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnChangeSucursalEmployeeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panChangeSucursalEmpleado1Layout = new javax.swing.GroupLayout(panChangeSucursalEmpleado1);
        panChangeSucursalEmpleado1.setLayout(panChangeSucursalEmpleado1Layout);
        panChangeSucursalEmpleado1Layout.setHorizontalGroup(
            panChangeSucursalEmpleado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panChangeSucursalEmpleado1Layout.createSequentialGroup()
                .addComponent(btnChangeSucursalEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panChangeSucursalEmpleado1Layout.setVerticalGroup(
            panChangeSucursalEmpleado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnChangeSucursalEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panSearchEmpleado1.setBackground(new java.awt.Color(249, 249, 249));
        panSearchEmpleado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        panSearchEmpleado1.setMaximumSize(new java.awt.Dimension(52, 52));
        panSearchEmpleado1.setMinimumSize(new java.awt.Dimension(0, 50));
        panSearchEmpleado1.setPreferredSize(new java.awt.Dimension(52, 52));

        btnSearchEmployee.setBackground(new java.awt.Color(249, 249, 249));
        btnSearchEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/findUserIcon.png"))); // NOI18N
        btnSearchEmployee.setToolTipText(" Buscar");
        btnSearchEmployee.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(249, 249, 249), 1, true));
        btnSearchEmployee.setBorderPainted(false);
        btnSearchEmployee.setContentAreaFilled(false);
        btnSearchEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSearchEmployee.setFocusPainted(false);
        btnSearchEmployee.setPreferredSize(new java.awt.Dimension(50, 50));
        btnSearchEmployee.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSearchEmployeeMouseMoved(evt);
            }
        });
        btnSearchEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchEmployeeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panSearchEmpleado1Layout = new javax.swing.GroupLayout(panSearchEmpleado1);
        panSearchEmpleado1.setLayout(panSearchEmpleado1Layout);
        panSearchEmpleado1Layout.setHorizontalGroup(
            panSearchEmpleado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSearchEmpleado1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panSearchEmpleado1Layout.setVerticalGroup(
            panSearchEmpleado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSearchEmpleado1Layout.createSequentialGroup()
                .addComponent(btnSearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panAddEmployee.setBackground(new java.awt.Color(239, 232, 244));
        panAddEmployee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        panAddEmployee.setForeground(new java.awt.Color(255, 255, 255));

        btnAddEmployee.setBackground(new java.awt.Color(249, 249, 249));
        btnAddEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/addIcon.png"))); // NOI18N
        btnAddEmployee.setToolTipText("Agregar");
        btnAddEmployee.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(249, 249, 249), 1, true));
        btnAddEmployee.setBorderPainted(false);
        btnAddEmployee.setContentAreaFilled(false);
        btnAddEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAddEmployee.setFocusPainted(false);
        btnAddEmployee.setPreferredSize(new java.awt.Dimension(50, 50));
        btnAddEmployee.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnAddEmployeeMouseMoved(evt);
            }
        });
        btnAddEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddEmployeeMouseExited(evt);
            }
        });
        btnAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panAddEmployeeLayout = new javax.swing.GroupLayout(panAddEmployee);
        panAddEmployee.setLayout(panAddEmployeeLayout);
        panAddEmployeeLayout.setHorizontalGroup(
            panAddEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAddEmployeeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panAddEmployeeLayout.setVerticalGroup(
            panAddEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAddEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparatorEmployee.setBackground(new java.awt.Color(249, 249, 249));
        jSeparatorEmployee.setForeground(new java.awt.Color(75, 0, 145));

        scpEmployee.setBackground(new java.awt.Color(249, 249, 249));

        tblEmployee.setBackground(new java.awt.Color(249, 249, 249));
        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Cargo", "Sucursal", "Nombre", "Apellido", "Telefono", "Dirección", "Nacimiento", "Ingreso", "Correo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblEmployee.setSelectionBackground(new java.awt.Color(75, 0, 145));
        tblEmployee.getTableHeader().setReorderingAllowed(false);
        tblEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeeMouseClicked(evt);
            }
        });
        scpEmployee.setViewportView(tblEmployee);

        javax.swing.GroupLayout panEmployeeFormLayout = new javax.swing.GroupLayout(panEmployeeForm);
        panEmployeeForm.setLayout(panEmployeeFormLayout);
        panEmployeeFormLayout.setHorizontalGroup(
            panEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sepEmployeeTittle)
            .addGroup(panEmployeeFormLayout.createSequentialGroup()
                .addGroup(panEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panEmployeeFormLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparatorEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(panEmployeeFormLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtIEmployeeForm, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(panSearchEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(lblEmployeeFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbEmployeForm, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panEmployeeFormLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBackToTicketDecision4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmployeeTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSucursalNameEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panChangeSucursalEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panEmployeeFormLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panAddEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panEmployeeFormLayout.setVerticalGroup(
            panEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEmployeeFormLayout.createSequentialGroup()
                .addGroup(panEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panChangeSucursalEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnBackToTicketDecision4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEmployeeTittle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                    .addComponent(lblSucursalNameEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepEmployeeTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmployeeFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbEmployeForm))
                    .addGroup(panEmployeeFormLayout.createSequentialGroup()
                        .addGroup(panEmployeeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panEmployeeFormLayout.createSequentialGroup()
                                .addComponent(txtIEmployeeForm, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparatorEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panSearchEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(scpEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        panOption4.add(panEmployeeForm, "card2");

        panContent.add(panOption4, "card2");

        panOption5.setBackground(new java.awt.Color(249, 249, 249));
        panOption5.setPreferredSize(new java.awt.Dimension(685, 620));

        lblTittleOption5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTittleOption5.setForeground(new java.awt.Color(28, 0, 63));
        lblTittleOption5.setText("Sucursales");
        lblTittleOption5.setToolTipText("");

        sepTittleOption5.setBackground(new java.awt.Color(249, 249, 249));
        sepTittleOption5.setForeground(new java.awt.Color(239, 232, 244));

        javax.swing.GroupLayout panOption5Layout = new javax.swing.GroupLayout(panOption5);
        panOption5.setLayout(panOption5Layout);
        panOption5Layout.setHorizontalGroup(
            panOption5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panOption5Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(lblTittleOption5, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(sepTittleOption5)
        );
        panOption5Layout.setVerticalGroup(
            panOption5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOption5Layout.createSequentialGroup()
                .addComponent(lblTittleOption5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTittleOption5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 519, Short.MAX_VALUE))
        );

        panContent.add(panOption5, "card2");

        panOption6.setBackground(new java.awt.Color(249, 249, 249));
        panOption6.setPreferredSize(new java.awt.Dimension(685, 620));
        panOption6.setLayout(new java.awt.CardLayout());

        sepTittleOption6.setBackground(new java.awt.Color(249, 249, 249));
        sepTittleOption6.setForeground(new java.awt.Color(239, 232, 244));
        panOption6.add(sepTittleOption6, "card3");

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
            suport.integerPositiveKeyTyped(evt);
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
    
    //<editor-fold defaultstate="collapsed" desc=" Main Menu -> Option 2 (Cinema Tickets)">
    
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

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Second Step ">
      
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

    //</editor-fold>
    
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

    private void btnForuthStepCinemaTicketsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForuthStepCinemaTicketsMouseMoved
        btnForuthStepCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnForuthStepCinemaTickets.setForeground(new java.awt.Color(255,255,255));
        btnForuthStepCinemaTickets.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnForuthStepCinemaTicketsMouseMoved

    private void btnForuthStepCinemaTicketsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForuthStepCinemaTicketsMouseExited
        btnForuthStepCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnForuthStepCinemaTickets.setForeground(new java.awt.Color(0,0,0));
        btnForuthStepCinemaTickets.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnForuthStepCinemaTicketsMouseExited

    private void btnBackToTicketDecision4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToTicketDecision4MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackToTicketDecision4MouseMoved

    private void btnBackToTicketDecision4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToTicketDecision4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackToTicketDecision4MouseExited

    private void txtIEmployeeFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIEmployeeFormMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIEmployeeFormMouseClicked

    private void txtIEmployeeFormKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIEmployeeFormKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIEmployeeFormKeyTyped

    private void btnChangeSucursalEmployeeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeSucursalEmployeeMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChangeSucursalEmployeeMouseMoved

    private void btnChangeSucursalEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeSucursalEmployeeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChangeSucursalEmployeeMouseExited

    private void btnSearchEmployeeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchEmployeeMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchEmployeeMouseMoved

    private void btnSearchEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchEmployeeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchEmployeeMouseExited

    private void btnAddEmployeeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddEmployeeMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddEmployeeMouseMoved

    private void btnAddEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddEmployeeMouseExited
        // TODO add your handling code here:
        panAddEmployee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        panAddEmployee.setForeground(new java.awt.Color(0,0,0));
        panAddEmployee.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnAddEmployeeMouseExited

    private void tblEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEmployeeMouseClicked

    private void btnAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddEmployeeActionPerformed

    private void btnCandySellClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCandySellClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCandySellClearActionPerformed

    private void btnCandyDecisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCandyDecisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCandyDecisionActionPerformed

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
        
        btnForuthStepCinemaTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnForuthStepCinemaTickets.setForeground(new java.awt.Color(0,0,0));
        btnForuthStepCinemaTickets.setBackground(new java.awt.Color(239,232,244));
        
    }
    

    
    //<editor-fold defaultstate="collapsed" desc=" Third Step ">
    
    
    
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Declaración de Variables ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAddCandySell;
    public javax.swing.JButton btnAddCinemaTickets1;
    public javax.swing.JButton btnAddCinemaTickets2;
    public javax.swing.JButton btnAddCinemaTickets3;
    public javax.swing.JButton btnAddCinemaTickets4;
    public javax.swing.JButton btnAddEmployee;
    public javax.swing.JButton btnBackToCantCinemaTickets;
    public javax.swing.JButton btnBackToSelectorMovie;
    public javax.swing.JButton btnBackToTicketDecision1;
    public javax.swing.JButton btnBackToTicketDecision2;
    public javax.swing.JButton btnBackToTicketDecision4;
    public javax.swing.JButton btnBodyOption1;
    public javax.swing.JButton btnBodyOption2;
    public javax.swing.JButton btnBodyOption3;
    public javax.swing.JButton btnBodyOption4;
    public javax.swing.JButton btnBodyOption5;
    public javax.swing.JButton btnBodyOption6;
    public javax.swing.JButton btnBodyOption7;
    public javax.swing.JButton btnCandyDecision;
    public javax.swing.JButton btnCandySell;
    public javax.swing.JButton btnCandySellClear;
    public javax.swing.JButton btnChangeSucursalCandySell;
    public javax.swing.JButton btnChangeSucursalCinemaTickets;
    public javax.swing.JButton btnChangeSucursalEmployee;
    public javax.swing.JButton btnCinemaDecision;
    public javax.swing.JButton btnExit;
    public javax.swing.JButton btnForuthStepCinemaTickets;
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
    private javax.swing.JButton btnSearchEmployee;
    public javax.swing.JButton btnSeatsClear;
    public javax.swing.JComboBox<String> cmbCandySelection;
    public javax.swing.JComboBox<String> cmbCandySeller;
    public javax.swing.JComboBox<String> cmbEmployeForm;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparatorEmployee;
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
    private javax.swing.JLabel lblCinemaTickets;
    private javax.swing.JLabel lblDescAdultTicket;
    private javax.swing.JLabel lblDescChildTicket;
    private javax.swing.JLabel lblDescKinderTicket;
    private javax.swing.JLabel lblDescOldTicket;
    private javax.swing.JLabel lblEmployeeFiltro;
    private javax.swing.JLabel lblEmployeeTittle;
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
    private javax.swing.JLabel lblIVAKinderTicket;
    private javax.swing.JLabel lblIVAOldTicket;
    private javax.swing.JLabel lblIVATicket;
    private javax.swing.JLabel lblMovieSelector;
    public javax.swing.JLabel lblPriceTicketAdult;
    public javax.swing.JLabel lblPriceTicketChild;
    public javax.swing.JLabel lblPriceTicketKinder;
    public javax.swing.JLabel lblPriceTicketOld;
    private javax.swing.JLabel lblSelectedSeats;
    public javax.swing.JLabel lblSelectedSeatsCant;
    public javax.swing.JLabel lblSubTotalCandySell;
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
    public javax.swing.JLabel lblSucursalNameEmployee;
    private javax.swing.JLabel lblTittleOption1;
    private javax.swing.JLabel lblTittleOption2;
    private javax.swing.JLabel lblTittleOption3;
    private javax.swing.JLabel lblTittleOption5;
    private javax.swing.JLabel lblTittleSelectorSeat;
    private javax.swing.JLabel lblTotalAdultTicket;
    public javax.swing.JLabel lblTotalAmountAdultTicket;
    public javax.swing.JLabel lblTotalAmountChildTicket;
    public javax.swing.JLabel lblTotalAmountKinderTicket;
    public javax.swing.JLabel lblTotalAmountOldTicket;
    public javax.swing.JLabel lblTotalAmountTicket;
    public javax.swing.JLabel lblTotalCandySell;
    private javax.swing.JLabel lblTotalChildTicket;
    private javax.swing.JLabel lblTotalKinderTicket;
    private javax.swing.JLabel lblTotalOldTicket;
    private javax.swing.JLabel lblTotalSeats;
    public javax.swing.JLabel lblTotalSeatsCant;
    private javax.swing.JLabel lblTotalTicket;
    private javax.swing.JPanel panAddCandySell;
    public javax.swing.JPanel panAddEmployee;
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
    private javax.swing.JPanel panButtonNextStepBuyTicket;
    private javax.swing.JPanel panButtonsTopBar;
    public javax.swing.JPanel panCandySell;
    public javax.swing.JPanel panCandySellClear;
    public javax.swing.JPanel panCapsuleCandyDecision;
    public javax.swing.JPanel panCapsuleCinemaDecision;
    private javax.swing.JPanel panChangeSucursalCandySell;
    private javax.swing.JPanel panChangeSucursalCinemaTickets;
    private javax.swing.JPanel panChangeSucursalEmpleado1;
    public javax.swing.JPanel panCinemaSell;
    public javax.swing.JPanel panContent;
    public javax.swing.JPanel panDecisionOption2;
    public javax.swing.JPanel panEmployeeForm;
    public javax.swing.JPanel panFirstStepCinemaTickets;
    public javax.swing.JPanel panFourthStepCinemaTickets;
    private javax.swing.JPanel panLateralMenu;
    private javax.swing.JPanel panLateralOptions;
    public javax.swing.JPanel panMainMenu;
    private javax.swing.JPanel panMainPage;
    public javax.swing.JPanel panOption1;
    public javax.swing.JPanel panOption2;
    public javax.swing.JPanel panOption3;
    public javax.swing.JPanel panOption4;
    public javax.swing.JPanel panOption5;
    public javax.swing.JPanel panOption6;
    public javax.swing.JPanel panSearchClientCandySell;
    public javax.swing.JPanel panSearchEmpleado1;
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
    public javax.swing.JScrollPane scpEmployee;
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
    private javax.swing.JSeparator sepCandyDecision;
    private javax.swing.JSeparator sepCandySellTittle;
    private javax.swing.JSeparator sepCinemaDecision;
    private javax.swing.JSeparator sepCinemaSellTittle;
    private javax.swing.JSeparator sepEmployeeTittle;
    private javax.swing.JSeparator sepLateralMenu;
    private javax.swing.JSeparator sepTittleOption1;
    private javax.swing.JSeparator sepTittleOption2;
    private javax.swing.JSeparator sepTittleOption3;
    private javax.swing.JSeparator sepTittleOption5;
    private javax.swing.JSeparator sepTittleOption6;
    public javax.swing.JSpinner spnCantCandySell;
    public javax.swing.JTable tblCandy;
    public javax.swing.JTable tblEmployee;
    public javax.swing.JTable tblFunctionSelector;
    public javax.swing.JTable tblMovieSelector;
    public javax.swing.JTextField txtIEmployeeForm;
    public javax.swing.JTextField txtIVACandy;
    public javax.swing.JTextField txtIdClientCandySell;
    public javax.swing.JTextField txtSubTotalCandy;
    public javax.swing.JTextField txtTotalCandy;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
