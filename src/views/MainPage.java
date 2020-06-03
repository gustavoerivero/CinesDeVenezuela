package views;

import lib.SuportFunctions;

/**
 *
 * @author Gustavo
 */
public class MainPage extends javax.swing.JFrame {

    // Variables de apoyo para conocer la ubicación de la aplicación.
    int xx = 0, xy = 0;
    
    private SuportFunctions suport;
    
    public MainPage() {
        
        // Inicializa todas las variables (o mejor dicho componentes) que usa el JFrame.
        initComponents();
        
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
    
    //<editor-fold defaultstate="collapsed" desc=" Explicación sobre el Método ">
    /*
     * ========================================================================
     * addEvents es un método que se activa al realizar una acción (presionar 
     * click sobre algún botón) añadiendo este evento a una lista que será ma-
     * nejada con mayor profundidad en el Controlador correspondiente.
     * ========================================================================
     */
    //</editor-fold>
    
    public void addEvents(java.awt.event.ActionListener evt){
        // Eventos de los botones de la barra superior.
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
            btnChangeSucursalCandySell.addActionListener(evt);  // -> Cambiar de Sucursal
            btnSearchClientCandySell.addActionListener(evt);    // -> Buscar Cliente
            btnAddCandySell.addActionListener(evt);             // -> Añadir golosina
            btnCandySellClear.addActionListener(evt);           // -> Limpiar formulario
            btnCandySell.addActionListener(evt);                // -> Vender golosinas
            
            // -> Cinema Ticket Sell
        
        
    }

    // Método que retorna los valores iniciales de los componentes de JPanel de Candy Sell
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
    
    public void clearCandyTable(javax.swing.JTable table){
        
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null}
                },
                new String [] {
                                "Golosina", "Cantidad", "Precio (Unidad)", 
                                "IVA (Unidad)", "Monto (Unidad)", "Total", 
                                " ", " "
                }
            )   {
                    boolean[] canEdit = new boolean [] {
                        false, false, false, false, false, false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
        });
        
    }
    
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
        btnBackToTicketDecision2 = new javax.swing.JButton();
        sepCinemaSellTittle = new javax.swing.JSeparator();
        lblCinemaSellTittle1 = new javax.swing.JLabel();
        panOption3 = new javax.swing.JPanel();
        lblTittleOption3 = new javax.swing.JLabel();
        sepTittleOption3 = new javax.swing.JSeparator();
        panOption4 = new javax.swing.JPanel();
        lblTittleOption4 = new javax.swing.JLabel();
        sepTittleOption4 = new javax.swing.JSeparator();
        panOption5 = new javax.swing.JPanel();
        lblTittleOption5 = new javax.swing.JLabel();
        sepTittleOption5 = new javax.swing.JSeparator();
        panOption6 = new javax.swing.JPanel();
        lblTittleOption6 = new javax.swing.JLabel();
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
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(btnMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addGap(14, 14, 14))
        );
        panButtonsTopBarLayout.setVerticalGroup(
            panButtonsTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panButtonsTopBarLayout.createSequentialGroup()
                .addGroup(panButtonsTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMin)
                    .addComponent(btnExit))
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
        lblCDVlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/CDV-small.png"))); // NOI18N
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
        btnOptionLateral6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/settingsIcon.png"))); // NOI18N
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
                .addComponent(lblCDVlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepLateralMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panLateralOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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
        btnBodyOption1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/CDV-medium.png"))); // NOI18N
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
                .addContainerGap(391, Short.MAX_VALUE))
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
        btnCandySellClear.setForeground(new java.awt.Color(0, 0, 0));
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
        btnCandySell.setForeground(new java.awt.Color(0, 0, 0));
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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Golosina", "Cantidad", "Precio (Unidad)", "IVA (Unidad)", "Monto (Unidad)", "Total", "Acción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCandy.setSelectionBackground(new java.awt.Color(75, 0, 145));
        tblCandy.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scpCandyTable.setViewportView(tblCandy);

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

        sepCinemaSellTittle.setBackground(new java.awt.Color(249, 249, 249));
        sepCinemaSellTittle.setForeground(new java.awt.Color(239, 232, 244));

        lblCinemaSellTittle1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblCinemaSellTittle1.setForeground(new java.awt.Color(28, 0, 63));
        lblCinemaSellTittle1.setText("Ventas de tickets para funciones");
        lblCinemaSellTittle1.setToolTipText("");

        javax.swing.GroupLayout panCinemaSellLayout = new javax.swing.GroupLayout(panCinemaSell);
        panCinemaSell.setLayout(panCinemaSellLayout);
        panCinemaSellLayout.setHorizontalGroup(
            panCinemaSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sepCinemaSellTittle)
            .addGroup(panCinemaSellLayout.createSequentialGroup()
                .addComponent(btnBackToTicketDecision2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCinemaSellTittle1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
        );
        panCinemaSellLayout.setVerticalGroup(
            panCinemaSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCinemaSellLayout.createSequentialGroup()
                .addGroup(panCinemaSellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCinemaSellTittle1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(btnBackToTicketDecision2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepCinemaSellTittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(567, Short.MAX_VALUE))
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
                .addGap(0, 559, Short.MAX_VALUE))
        );

        panContent.add(panOption3, "card2");

        panOption4.setBackground(new java.awt.Color(249, 249, 249));
        panOption4.setPreferredSize(new java.awt.Dimension(685, 620));

        lblTittleOption4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTittleOption4.setForeground(new java.awt.Color(28, 0, 63));
        lblTittleOption4.setText("Empleados");
        lblTittleOption4.setToolTipText("");

        sepTittleOption4.setBackground(new java.awt.Color(249, 249, 249));
        sepTittleOption4.setForeground(new java.awt.Color(239, 232, 244));

        javax.swing.GroupLayout panOption4Layout = new javax.swing.GroupLayout(panOption4);
        panOption4.setLayout(panOption4Layout);
        panOption4Layout.setHorizontalGroup(
            panOption4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panOption4Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(lblTittleOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(sepTittleOption4)
        );
        panOption4Layout.setVerticalGroup(
            panOption4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOption4Layout.createSequentialGroup()
                .addComponent(lblTittleOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTittleOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 509, Short.MAX_VALUE))
        );

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
                .addGap(0, 509, Short.MAX_VALUE))
        );

        panContent.add(panOption5, "card2");

        panOption6.setBackground(new java.awt.Color(249, 249, 249));
        panOption6.setPreferredSize(new java.awt.Dimension(685, 620));

        lblTittleOption6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTittleOption6.setForeground(new java.awt.Color(28, 0, 63));
        lblTittleOption6.setText("Configuración");
        lblTittleOption6.setToolTipText("");

        sepTittleOption6.setBackground(new java.awt.Color(249, 249, 249));
        sepTittleOption6.setForeground(new java.awt.Color(239, 232, 244));

        javax.swing.GroupLayout panOption6Layout = new javax.swing.GroupLayout(panOption6);
        panOption6.setLayout(panOption6Layout);
        panOption6Layout.setHorizontalGroup(
            panOption6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panOption6Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(lblTittleOption6, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(sepTittleOption6)
        );
        panOption6Layout.setVerticalGroup(
            panOption6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOption6Layout.createSequentialGroup()
                .addComponent(lblTittleOption6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTittleOption6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 509, Short.MAX_VALUE))
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
    
    //<editor-fold defaultstate="collapsed" desc=" Main Menu -> Option 2 ">
    
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

    private void btnBackToTicketDecision2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToTicketDecision2MouseMoved
        btnBackToTicketDecision2.setBackground(new java.awt.Color(245,245,245));
    }//GEN-LAST:event_btnBackToTicketDecision2MouseMoved

    private void btnBackToTicketDecision2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToTicketDecision2MouseExited
        btnBackToTicketDecision2.setBackground(new java.awt.Color(249,249,249));
    }//GEN-LAST:event_btnBackToTicketDecision2MouseExited

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


        
    
    //</editor-fold>
    
    //</editor-fold>
    
    /**
     * @param args the command line arguments
     */

    //<editor-fold defaultstate="collapsed" desc=" Declaración de Variables ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAddCandySell;
    public javax.swing.JButton btnBackToTicketDecision1;
    public javax.swing.JButton btnBackToTicketDecision2;
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
    public javax.swing.JButton btnCinemaDecision;
    public javax.swing.JButton btnExit;
    public javax.swing.JButton btnMin;
    public javax.swing.JButton btnOptionLateral1;
    public javax.swing.JButton btnOptionLateral2;
    public javax.swing.JButton btnOptionLateral3;
    public javax.swing.JButton btnOptionLateral4;
    public javax.swing.JButton btnOptionLateral5;
    public javax.swing.JButton btnOptionLateral6;
    private javax.swing.JButton btnSearchClientCandySell;
    public javax.swing.JComboBox<String> cmbCandySelection;
    public javax.swing.JComboBox<String> cmbCandySeller;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblADCmark;
    private javax.swing.JLabel lblCDVlogo;
    private javax.swing.JLabel lblCandySelection;
    private javax.swing.JLabel lblCandySelection2;
    private javax.swing.JLabel lblCandySellTittle;
    private javax.swing.JLabel lblCandySeller;
    private javax.swing.JLabel lblCantCandySell;
    private javax.swing.JLabel lblCinemaSellTittle1;
    public javax.swing.JLabel lblIVACandySell;
    public javax.swing.JLabel lblSubTotalCandySell;
    public javax.swing.JLabel lblSucursalNameCandySell;
    private javax.swing.JLabel lblTittleOption1;
    private javax.swing.JLabel lblTittleOption2;
    private javax.swing.JLabel lblTittleOption3;
    private javax.swing.JLabel lblTittleOption4;
    private javax.swing.JLabel lblTittleOption5;
    private javax.swing.JLabel lblTittleOption6;
    public javax.swing.JLabel lblTotalCandySell;
    private javax.swing.JPanel panAddCandySell;
    public javax.swing.JPanel panBodyOption1;
    public javax.swing.JPanel panBodyOption2;
    public javax.swing.JPanel panBodyOption3;
    public javax.swing.JPanel panBodyOption4;
    public javax.swing.JPanel panBodyOption5;
    public javax.swing.JPanel panBodyOption6;
    public javax.swing.JPanel panBodyOption7;
    public javax.swing.JPanel panBodyOptions1;
    private javax.swing.JPanel panButtonCandySell;
    private javax.swing.JPanel panButtonsTopBar;
    public javax.swing.JPanel panCandySell;
    public javax.swing.JPanel panCandySellClear;
    public javax.swing.JPanel panCapsuleCandyDecision;
    public javax.swing.JPanel panCapsuleCinemaDecision;
    private javax.swing.JPanel panChangeSucursalCandySell;
    public javax.swing.JPanel panCinemaSell;
    public javax.swing.JPanel panContent;
    public javax.swing.JPanel panDecisionOption2;
    private javax.swing.JPanel panLateralMenu;
    private javax.swing.JPanel panLateralOptions;
    private javax.swing.JPanel panMainMenu;
    private javax.swing.JPanel panMainPage;
    public javax.swing.JPanel panOption1;
    public javax.swing.JPanel panOption2;
    public javax.swing.JPanel panOption3;
    public javax.swing.JPanel panOption4;
    public javax.swing.JPanel panOption5;
    public javax.swing.JPanel panOption6;
    public javax.swing.JPanel panSearchClientCandySell;
    private javax.swing.JPanel panTopBar;
    private javax.swing.JPanel panTopBarLateralMenu;
    private javax.swing.JScrollPane scpBodyOption1;
    private javax.swing.JScrollPane scpCandyTable;
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
    private javax.swing.JSeparator sepLateralMenu;
    private javax.swing.JSeparator sepTittleOption1;
    private javax.swing.JSeparator sepTittleOption2;
    private javax.swing.JSeparator sepTittleOption3;
    private javax.swing.JSeparator sepTittleOption4;
    private javax.swing.JSeparator sepTittleOption5;
    private javax.swing.JSeparator sepTittleOption6;
    public javax.swing.JSpinner spnCantCandySell;
    public javax.swing.JTable tblCandy;
    public javax.swing.JTextField txtIVACandy;
    public javax.swing.JTextField txtIdClientCandySell;
    public javax.swing.JTextField txtSubTotalCandy;
    public javax.swing.JTextField txtTotalCandy;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
