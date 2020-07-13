
package views;

// Se importan las librerías a utilizar.
import views.tables.*;
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
public class BranchManagement extends javax.swing.JFrame {
    
    // Se declaran e inicializan las variables a utilizar.
    int xx = 0, xy = 0, row = 0, column = 0;    

    // Se declaran e instancian las clases a utilizar.
    private SupportFunctions support;
    private Table table = new Table();   

    /**
     * Constructor del gestor de empleados.
     */
    public BranchManagement(){
        
        initComponents();                
        
        // Ubica el JFrame en el centro de la pantalla.
        setLocationRelativeTo(null);        
        
        // Muestra el JFrame.
        setVisible(true);        
        
        // Se limpia la view inicial.
        clearBranchSearch();
        
        // Cambia el ícono del JFrame.
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("images/CDV-icon.png")).getImage());
    
    }

    
    //<editor-fold defaultstate="collapsed" desc=" Métodos para manipular tablas ">
    
    /**
     * Método que retorna los valores iniciales de los componentes 
     * JPanel de Branch Management.
     */
    public void clearBranchSearch(){
        
        txtSearchIdBranch.setText("Codigo de la sucursal");
        txtSearchNameBranch.setText("Nombre de la sucursal");
        cmbSearchCity.setSelectedIndex(0);
        clearBranchTable(tblBranchList);
        
    }
 
    /**
     * Método que retorna los valores iniciales de un JTable.
     * @param table parámetro JTable.
     */
    public void clearBranchTable(javax.swing.JTable table){
        this.table.buildBranchTable(table, null);
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
        
        // Top Bar
        btnExit.addActionListener(evt);
        btnMin.addActionListener(evt);
        
        // Search
        btnSearchBranch.addActionListener(evt);
        btnClearSearchBranch.addActionListener(evt);
        
        // CRUD
        btnBackBranch.addActionListener(evt);
        btnClearBranch.addActionListener(evt);
        btnDeleteBranch.addActionListener(evt);
        btnRegisterModifyBranch.addActionListener(evt);
        
    }
    
    /**
     * Método que permite activar los eventos del escuchador Mouse.
     * @param evt parámetro que se activa cuando el Mouse reacciona a algo.
     */
    public void addMouseEvents(java.awt.event.MouseListener evt){
        
        tblBranchList.addMouseListener(evt);
        
    }
    
    //</editor-fold>
    /**
     * Método para devolver a los valores por defecto a los elementos de la view.
     */
    public void clearView(){
               
        btnBackBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnBackBranch.setForeground(new java.awt.Color(0,0,0));
        btnBackBranch.setBackground(new java.awt.Color(239,232,244));
                
        btnClearBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnClearBranch.setForeground(new java.awt.Color(0,0,0));
        btnClearBranch.setBackground(new java.awt.Color(239,232,244));
        
        btnClearSearchBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnClearSearchBranch.setForeground(new java.awt.Color(0,0,0));
        btnClearSearchBranch.setBackground(new java.awt.Color(239,232,244));
        
        btnDeleteBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnDeleteBranch.setForeground(new java.awt.Color(0,0,0));
        btnDeleteBranch.setBackground(new java.awt.Color(239,232,244));
        
        btnRegisterModifyBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnRegisterModifyBranch.setForeground(new java.awt.Color(0,0,0));
        btnRegisterModifyBranch.setBackground(new java.awt.Color(239,232,244));
        
        btnSearchBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnSearchBranch.setForeground(new java.awt.Color(0,0,0));
        btnSearchBranch.setBackground(new java.awt.Color(239,232,244));
        
        cmbCityBranch.setSelectedIndex(0);
        cmbEnterpriseBranch.setSelectedIndex(0);
        cmbSearchCity.setSelectedIndex(0);
        
        txtDirectionBranch.setText("Dirección de la sucursal");
        txtIdBranch.setText("Codigo de la sucursal");
        txtNameBranch.setText("Nombre de la sucursal");
        txtPhoneBranch.setText("Teléfono de la sucursal");
        
        // Búsqueda
        txtSearchIdBranch.setText("Codigo de la sucursal");
        txtSearchNameBranch.setText("Nombre de la sucursal");
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panBranchManagement = new javax.swing.JPanel();
        panButtonsTopBar = new javax.swing.JPanel();
        btnMin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblTittle = new javax.swing.JLabel();
        sepTittle = new javax.swing.JSeparator();
        lblSucursalName = new javax.swing.JLabel();
        panContainerBranch = new javax.swing.JPanel();
        panConsultList = new javax.swing.JPanel();
        scpBranchList = new javax.swing.JScrollPane();
        tblBranchList = new javax.swing.JTable();
        txtSearchIdBranch = new javax.swing.JTextField();
        sepSearchIdBranch = new javax.swing.JSeparator();
        txtSearchNameBranch = new javax.swing.JTextField();
        btnSearchBranch = new javax.swing.JButton();
        sepSearchNameEmployee = new javax.swing.JSeparator();
        cmbSearchCity = new javax.swing.JComboBox<>();
        btnClearSearchBranch = new javax.swing.JButton();
        panCRUD = new javax.swing.JPanel();
        lblTittle1 = new javax.swing.JLabel();
        lblIdBranch = new javax.swing.JLabel();
        lblNameBranch = new javax.swing.JLabel();
        lblPhoneBranch = new javax.swing.JLabel();
        lblEnterpriseBranch = new javax.swing.JLabel();
        lblCityBranch = new javax.swing.JLabel();
        lblDirectionBranch = new javax.swing.JLabel();
        txtIdBranch = new javax.swing.JTextField();
        txtNameBranch = new javax.swing.JTextField();
        txtDirectionBranch = new javax.swing.JTextField();
        txtPhoneBranch = new javax.swing.JTextField();
        cmbCityBranch = new javax.swing.JComboBox<>();
        cmbEnterpriseBranch = new javax.swing.JComboBox<>();
        btnClearBranch = new javax.swing.JButton();
        btnRegisterModifyBranch = new javax.swing.JButton();
        btnBackBranch = new javax.swing.JButton();
        btnDeleteBranch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panBranchManagement.setBackground(new java.awt.Color(249, 249, 249));
        panBranchManagement.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 0, 145)));

        panButtonsTopBar.setBackground(new java.awt.Color(249, 249, 249));
        panButtonsTopBar.setPreferredSize(new java.awt.Dimension(215, 40));
        panButtonsTopBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panButtonsTopBarMouseDragged(evt);
            }
        });
        panButtonsTopBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panButtonsTopBarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panButtonsTopBarMouseReleased(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        lblTittle.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTittle.setForeground(new java.awt.Color(28, 0, 63));
        lblTittle.setText("Gestión de Sucursal");
        lblTittle.setToolTipText("");

        sepTittle.setBackground(new java.awt.Color(249, 249, 249));
        sepTittle.setForeground(new java.awt.Color(239, 232, 244));

        lblSucursalName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSucursalName.setForeground(new java.awt.Color(75, 0, 145));
        lblSucursalName.setText("Sucursal ");

        panContainerBranch.setBackground(new java.awt.Color(249, 249, 249));
        panContainerBranch.setPreferredSize(new java.awt.Dimension(898, 519));
        panContainerBranch.setLayout(new java.awt.CardLayout());

        panConsultList.setBackground(new java.awt.Color(249, 249, 249));

        tblBranchList.setBackground(new java.awt.Color(249, 249, 249));
        tblBranchList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Ciudad", "Dirección", "Telefono", "Consultar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBranchList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblBranchList.setSelectionBackground(new java.awt.Color(75, 0, 145));
        tblBranchList.getTableHeader().setReorderingAllowed(false);
        tblBranchList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBranchListMouseClicked(evt);
            }
        });
        scpBranchList.setViewportView(tblBranchList);

        txtSearchIdBranch.setBackground(new java.awt.Color(249, 249, 249));
        txtSearchIdBranch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSearchIdBranch.setText("Codigo de la sucursal");
        txtSearchIdBranch.setBorder(null);
        txtSearchIdBranch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchIdBranchMouseClicked(evt);
            }
        });
        txtSearchIdBranch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchIdBranchKeyTyped(evt);
            }
        });

        sepSearchIdBranch.setBackground(new java.awt.Color(249, 249, 249));
        sepSearchIdBranch.setForeground(new java.awt.Color(75, 0, 145));

        txtSearchNameBranch.setBackground(new java.awt.Color(249, 249, 249));
        txtSearchNameBranch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSearchNameBranch.setText("Nombre de la sucursal");
        txtSearchNameBranch.setBorder(null);
        txtSearchNameBranch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchNameBranchMouseClicked(evt);
            }
        });
        txtSearchNameBranch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchNameBranchKeyTyped(evt);
            }
        });

        btnSearchBranch.setBackground(new java.awt.Color(249, 249, 249));
        btnSearchBranch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/findUserIcon.png"))); // NOI18N
        btnSearchBranch.setToolTipText(" Buscar");
        btnSearchBranch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(249, 249, 249), 1, true));
        btnSearchBranch.setContentAreaFilled(false);
        btnSearchBranch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchBranch.setFocusPainted(false);
        btnSearchBranch.setPreferredSize(new java.awt.Dimension(50, 50));
        btnSearchBranch.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSearchBranchMouseMoved(evt);
            }
        });
        btnSearchBranch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchBranchMouseExited(evt);
            }
        });

        sepSearchNameEmployee.setBackground(new java.awt.Color(249, 249, 249));
        sepSearchNameEmployee.setForeground(new java.awt.Color(75, 0, 145));

        cmbSearchCity.setBackground(new java.awt.Color(249, 249, 249));
        cmbSearchCity.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbSearchCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccionar una ciudad -", "Barquisimeto", "Caracas", "Maracaibo", "Punto Fijo", "Valencia" }));
        cmbSearchCity.setBorder(null);
        cmbSearchCity.setLightWeightPopupEnabled(false);

        btnClearSearchBranch.setBackground(new java.awt.Color(249, 249, 249));
        btnClearSearchBranch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/searchIcon.png"))); // NOI18N
        btnClearSearchBranch.setToolTipText("Limpiar");
        btnClearSearchBranch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(249, 249, 249), 1, true));
        btnClearSearchBranch.setContentAreaFilled(false);
        btnClearSearchBranch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearSearchBranch.setFocusPainted(false);
        btnClearSearchBranch.setPreferredSize(new java.awt.Dimension(50, 50));
        btnClearSearchBranch.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnClearSearchBranchMouseMoved(evt);
            }
        });
        btnClearSearchBranch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClearSearchBranchMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panConsultListLayout = new javax.swing.GroupLayout(panConsultList);
        panConsultList.setLayout(panConsultListLayout);
        panConsultListLayout.setHorizontalGroup(
            panConsultListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConsultListLayout.createSequentialGroup()
                .addGroup(panConsultListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panConsultListLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scpBranchList))
                    .addGroup(panConsultListLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panConsultListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sepSearchIdBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearchIdBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(panConsultListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sepSearchNameEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtSearchNameBranch))
                        .addGap(29, 29, 29)
                        .addComponent(cmbSearchCity, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnSearchBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClearSearchBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panConsultListLayout.setVerticalGroup(
            panConsultListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConsultListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panConsultListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panConsultListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSearchBranch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbSearchCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnClearSearchBranch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panConsultListLayout.createSequentialGroup()
                        .addGroup(panConsultListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panConsultListLayout.createSequentialGroup()
                                .addComponent(txtSearchNameBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(panConsultListLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtSearchIdBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGroup(panConsultListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sepSearchIdBranch)
                            .addComponent(sepSearchNameEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(scpBranchList, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panContainerBranch.add(panConsultList, "card2");

        panCRUD.setBackground(new java.awt.Color(249, 249, 249));
        panCRUD.setPreferredSize(new java.awt.Dimension(898, 406));

        lblTittle1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTittle1.setForeground(new java.awt.Color(28, 0, 63));
        lblTittle1.setText("Datos de la sucursal");
        lblTittle1.setToolTipText("");

        lblIdBranch.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblIdBranch.setForeground(new java.awt.Color(28, 0, 63));
        lblIdBranch.setText("Codigo:");
        lblIdBranch.setToolTipText("");

        lblNameBranch.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblNameBranch.setForeground(new java.awt.Color(28, 0, 63));
        lblNameBranch.setText("Nombre:");
        lblNameBranch.setToolTipText("");

        lblPhoneBranch.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblPhoneBranch.setForeground(new java.awt.Color(28, 0, 63));
        lblPhoneBranch.setText("Teléfono:");
        lblPhoneBranch.setToolTipText("");

        lblEnterpriseBranch.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblEnterpriseBranch.setForeground(new java.awt.Color(28, 0, 63));
        lblEnterpriseBranch.setText("Empresa");
        lblEnterpriseBranch.setToolTipText("");

        lblCityBranch.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblCityBranch.setForeground(new java.awt.Color(28, 0, 63));
        lblCityBranch.setText("Ciudad:");
        lblCityBranch.setToolTipText("");

        lblDirectionBranch.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblDirectionBranch.setForeground(new java.awt.Color(28, 0, 63));
        lblDirectionBranch.setText("Dirección:");
        lblDirectionBranch.setToolTipText("");

        txtIdBranch.setBackground(new java.awt.Color(249, 249, 249));
        txtIdBranch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIdBranch.setText("Codigo de la sucursal");
        txtIdBranch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 0, 145)));

        txtNameBranch.setBackground(new java.awt.Color(249, 249, 249));
        txtNameBranch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNameBranch.setText("Nombre de la sucursal");
        txtNameBranch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 0, 145)));

        txtDirectionBranch.setBackground(new java.awt.Color(249, 249, 249));
        txtDirectionBranch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDirectionBranch.setText("Dirección de la sucursal");
        txtDirectionBranch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 0, 145)));

        txtPhoneBranch.setBackground(new java.awt.Color(249, 249, 249));
        txtPhoneBranch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPhoneBranch.setText("Teléfono de la sucursal");
        txtPhoneBranch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 0, 145)));

        cmbCityBranch.setBackground(new java.awt.Color(249, 249, 249));
        cmbCityBranch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbCityBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " - Seleccionar una Ciudad - ", "Barquisimeto", "Caracas", "Maracaibo", "Punto Fijo", "Valencia" }));
        cmbCityBranch.setBorder(null);
        cmbCityBranch.setLightWeightPopupEnabled(false);

        cmbEnterpriseBranch.setBackground(new java.awt.Color(249, 249, 249));
        cmbEnterpriseBranch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbEnterpriseBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccionar una Empresa -", "CINES DE VENEZUELA, C.A." }));
        cmbEnterpriseBranch.setBorder(null);
        cmbEnterpriseBranch.setLightWeightPopupEnabled(false);

        btnClearBranch.setBackground(new java.awt.Color(239, 232, 244));
        btnClearBranch.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnClearBranch.setText("Limpiar");
        btnClearBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnClearBranch.setBorderPainted(false);
        btnClearBranch.setContentAreaFilled(false);
        btnClearBranch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearBranch.setFocusPainted(false);
        btnClearBranch.setOpaque(true);
        btnClearBranch.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnClearBranchMouseMoved(evt);
            }
        });
        btnClearBranch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClearBranchMouseExited(evt);
            }
        });

        btnRegisterModifyBranch.setBackground(new java.awt.Color(239, 232, 244));
        btnRegisterModifyBranch.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRegisterModifyBranch.setText("@Registrar/Actualizar");
        btnRegisterModifyBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegisterModifyBranch.setBorderPainted(false);
        btnRegisterModifyBranch.setContentAreaFilled(false);
        btnRegisterModifyBranch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegisterModifyBranch.setFocusPainted(false);
        btnRegisterModifyBranch.setOpaque(true);
        btnRegisterModifyBranch.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRegisterModifyBranchMouseMoved(evt);
            }
        });
        btnRegisterModifyBranch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegisterModifyBranchMouseExited(evt);
            }
        });

        btnBackBranch.setBackground(new java.awt.Color(239, 232, 244));
        btnBackBranch.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBackBranch.setText("Atrás");
        btnBackBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBackBranch.setBorderPainted(false);
        btnBackBranch.setContentAreaFilled(false);
        btnBackBranch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackBranch.setFocusPainted(false);
        btnBackBranch.setOpaque(true);
        btnBackBranch.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBackBranchMouseMoved(evt);
            }
        });
        btnBackBranch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackBranchMouseExited(evt);
            }
        });

        btnDeleteBranch.setBackground(new java.awt.Color(239, 232, 244));
        btnDeleteBranch.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnDeleteBranch.setText("Eliminar");
        btnDeleteBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDeleteBranch.setBorderPainted(false);
        btnDeleteBranch.setContentAreaFilled(false);
        btnDeleteBranch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteBranch.setFocusPainted(false);
        btnDeleteBranch.setOpaque(true);
        btnDeleteBranch.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnDeleteBranchMouseMoved(evt);
            }
        });
        btnDeleteBranch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteBranchMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panCRUDLayout = new javax.swing.GroupLayout(panCRUD);
        panCRUD.setLayout(panCRUDLayout);
        panCRUDLayout.setHorizontalGroup(
            panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCRUDLayout.createSequentialGroup()
                .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panCRUDLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTittle1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panCRUDLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCRUDLayout.createSequentialGroup()
                                .addGap(432, 432, 432)
                                .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblCityBranch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEnterpriseBranch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(lblPhoneBranch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbEnterpriseBranch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panCRUDLayout.createSequentialGroup()
                                        .addComponent(txtPhoneBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cmbCityBranch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panCRUDLayout.createSequentialGroup()
                                .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNameBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIdBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDirectionBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDirectionBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNameBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panCRUDLayout.createSequentialGroup()
                                .addComponent(btnBackBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClearBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegisterModifyBranch, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))))
                .addGap(23, 23, 23))
        );
        panCRUDLayout.setVerticalGroup(
            panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCRUDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTittle1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoneBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNameBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNameBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEnterpriseBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbEnterpriseBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDirectionBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDirectionBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCityBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCityBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBackBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegisterModifyBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        panContainerBranch.add(panCRUD, "card2");

        javax.swing.GroupLayout panBranchManagementLayout = new javax.swing.GroupLayout(panBranchManagement);
        panBranchManagement.setLayout(panBranchManagementLayout);
        panBranchManagementLayout.setHorizontalGroup(
            panBranchManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panButtonsTopBar, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
            .addComponent(sepTittle)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBranchManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBranchManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panContainerBranch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panBranchManagementLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSucursalName, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)))
                .addContainerGap())
        );
        panBranchManagementLayout.setVerticalGroup(
            panBranchManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBranchManagementLayout.createSequentialGroup()
                .addComponent(panButtonsTopBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panBranchManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSucursalName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panContainerBranch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBranchManagement, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBranchManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc=" Top Bar ">
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

    private void panButtonsTopBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panButtonsTopBarMouseDragged
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
    }//GEN-LAST:event_panButtonsTopBarMouseDragged

    private void panButtonsTopBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panButtonsTopBarMousePressed
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
    }//GEN-LAST:event_panButtonsTopBarMousePressed

    private void panButtonsTopBarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panButtonsTopBarMouseReleased
        //<editor-fold defaultstate="collapsed" desc=" Explicación sobre el método ">
        /*
        * Este método devuelve la opacidad de la aplicación a su valor base.
        */

        // Se coloca la opacidad de la aplicación en 100%.
        //</editor-fold>
        setOpacity((float)1.0);
    }//GEN-LAST:event_panButtonsTopBarMouseReleased
    //</editor-fold>
    
    
    
    private void tblBranchListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBranchListMouseClicked
        setColumnTable(tblBranchList.getColumnModel().getColumnIndexAtX(evt.getX()));
        setRowTable(evt.getY()/tblBranchList.getRowHeight());
    }//GEN-LAST:event_tblBranchListMouseClicked
    
    //<editor-fold defaultstate="collapsed" desc=" Search Employee ">
    private void txtSearchIdBranchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchIdBranchMouseClicked
        txtSearchIdBranch.setText("");
    }//GEN-LAST:event_txtSearchIdBranchMouseClicked

    private void txtSearchIdBranchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchIdBranchKeyTyped
        /*if(txtSearchIdEmployee.getText().length() < 10)
        support.integerPositiveKeyTyped(evt);
        else
        evt.consume();*/
    }//GEN-LAST:event_txtSearchIdBranchKeyTyped

    private void txtSearchNameBranchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchNameBranchMouseClicked
        txtSearchNameBranch.setText("");
    }//GEN-LAST:event_txtSearchNameBranchMouseClicked

    private void txtSearchNameBranchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchNameBranchKeyTyped
        //support.alphabetKeyTyped(evt);
    }//GEN-LAST:event_txtSearchNameBranchKeyTyped

    private void btnSearchBranchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchBranchMouseMoved
        btnSearchBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnSearchBranchMouseMoved

    private void btnSearchBranchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchBranchMouseExited
        btnSearchBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnSearchBranchMouseExited

    private void btnClearSearchBranchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearSearchBranchMouseMoved
        btnClearSearchBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnClearSearchBranchMouseMoved

    private void btnClearSearchBranchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearSearchBranchMouseExited
        btnClearSearchBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnClearSearchBranchMouseExited

    private void btnClearBranchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearBranchMouseMoved
        btnClearBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnClearBranch.setForeground(new java.awt.Color(255,255,255));
        btnClearBranch.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnClearBranchMouseMoved

    private void btnClearBranchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearBranchMouseExited
        btnClearBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnClearBranch.setForeground(new java.awt.Color(0,0,0));
        btnClearBranch.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnClearBranchMouseExited
    //</editor-fold>
    
    private void btnRegisterModifyBranchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterModifyBranchMouseMoved
        btnRegisterModifyBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnRegisterModifyBranch.setForeground(new java.awt.Color(255,255,255));
        btnRegisterModifyBranch.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnRegisterModifyBranchMouseMoved

    private void btnRegisterModifyBranchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterModifyBranchMouseExited
        btnRegisterModifyBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnRegisterModifyBranch.setForeground(new java.awt.Color(0,0,0));
        btnRegisterModifyBranch.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnRegisterModifyBranchMouseExited

    private void btnBackBranchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackBranchMouseMoved
        btnBackBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnBackBranch.setForeground(new java.awt.Color(255,255,255));
        btnBackBranch.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnBackBranchMouseMoved

    private void btnBackBranchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackBranchMouseExited
        btnBackBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnBackBranch.setForeground(new java.awt.Color(0,0,0));
        btnBackBranch.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnBackBranchMouseExited

    private void btnDeleteBranchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteBranchMouseMoved
        btnDeleteBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnDeleteBranch.setForeground(new java.awt.Color(255,255,255));
        btnDeleteBranch.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnDeleteBranchMouseMoved

    private void btnDeleteBranchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteBranchMouseExited
        btnDeleteBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnDeleteBranch.setForeground(new java.awt.Color(0,0,0));
        btnDeleteBranch.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnDeleteBranchMouseExited

    //<editor-fold defaultstate="collapsed" desc=" Declaración de variables ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBackBranch;
    public javax.swing.JButton btnClearBranch;
    public javax.swing.JButton btnClearSearchBranch;
    public javax.swing.JButton btnDeleteBranch;
    public javax.swing.JButton btnExit;
    public javax.swing.JButton btnMin;
    public javax.swing.JButton btnRegisterModifyBranch;
    public javax.swing.JButton btnSearchBranch;
    public javax.swing.JComboBox<String> cmbCityBranch;
    public javax.swing.JComboBox<String> cmbEnterpriseBranch;
    public javax.swing.JComboBox<String> cmbSearchCity;
    private javax.swing.JLabel lblCityBranch;
    private javax.swing.JLabel lblDirectionBranch;
    private javax.swing.JLabel lblEnterpriseBranch;
    private javax.swing.JLabel lblIdBranch;
    private javax.swing.JLabel lblNameBranch;
    private javax.swing.JLabel lblPhoneBranch;
    public javax.swing.JLabel lblSucursalName;
    private javax.swing.JLabel lblTittle;
    private javax.swing.JLabel lblTittle1;
    private javax.swing.JPanel panBranchManagement;
    private javax.swing.JPanel panButtonsTopBar;
    public javax.swing.JPanel panCRUD;
    public javax.swing.JPanel panConsultList;
    public javax.swing.JPanel panContainerBranch;
    private javax.swing.JScrollPane scpBranchList;
    private javax.swing.JSeparator sepSearchIdBranch;
    private javax.swing.JSeparator sepSearchNameEmployee;
    private javax.swing.JSeparator sepTittle;
    public javax.swing.JTable tblBranchList;
    public javax.swing.JTextField txtDirectionBranch;
    public javax.swing.JTextField txtIdBranch;
    public javax.swing.JTextField txtNameBranch;
    public javax.swing.JTextField txtPhoneBranch;
    public javax.swing.JTextField txtSearchIdBranch;
    public javax.swing.JTextField txtSearchNameBranch;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
