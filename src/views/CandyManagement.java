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
public class CandyManagement extends javax.swing.JFrame 
{
    // Se declaran e inicializan las variables a utilizar.
    int xx = 0, xy = 0, row = 0, column = 0;    

    // Se declaran e instancian las clases a utilizar.
    private SupportFunctions support;
    private Table table = new Table();   

    /**
     * Constructor del gestor de empleados.
     */
    public CandyManagement() {
        initComponents();
        // Ubica el JFrame en el centro de la pantalla.
        setLocationRelativeTo(null);        
        
        // Muestra el JFrame.
        setVisible(true);        
        
        // Se limpia la view inicial.
        cleaCandySearch();
        
        // Cambia el ícono del JFrame.
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("images/CDV-icon.png")).getImage());
        }

        
    //<editor-fold defaultstate="collapsed" desc=" Métodos para manipular tablas ">
    
    /**
     * Método que retorna los valores iniciales de los componentes 
     * JPanel de Branch Management.
     */
    public void cleaCandySearch(){
        
        txtSearchIdCandy.setText("Código de la Golosina");
        clearBranchTable(tblCandyList);
        
    }
 
    /**
     * Método que retorna los valores iniciales de un JTable.
     * @param table parámetro JTable.
     */
    public void clearBranchTable(javax.swing.JTable table){
        this.table.buildCandyCRUDTable(table, null);
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
        btnSearchCandy.addActionListener(evt);
        btnClearSearchCandy.addActionListener(evt);
        
        // CRUD
        btnBackCandy.addActionListener(evt);
        btnClearCandy.addActionListener(evt);
        btnDeleteCandy.addActionListener(evt);
        btnRegisterModifyCandy.addActionListener(evt);
        
    }
    
    /**
     * Método que permite activar los eventos del escuchador Mouse.
     * @param evt parámetro que se activa cuando el Mouse reacciona a algo.
     */
    public void addMouseEvents(java.awt.event.MouseListener evt){
        
        tblCandyList.addMouseListener(evt);
        
    }
    
    //</editor-fold>

    
        public void clearView(){
               
        btnBackCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnBackCandy.setForeground(new java.awt.Color(0,0,0));
        btnBackCandy.setBackground(new java.awt.Color(239,232,244));
                
        btnClearCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnClearCandy.setForeground(new java.awt.Color(0,0,0));
        btnClearCandy.setBackground(new java.awt.Color(239,232,244));
        
        btnClearSearchCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnClearSearchCandy.setForeground(new java.awt.Color(0,0,0));
        btnClearSearchCandy.setBackground(new java.awt.Color(239,232,244));
        
        btnDeleteCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnDeleteCandy.setForeground(new java.awt.Color(0,0,0));
        btnDeleteCandy.setBackground(new java.awt.Color(239,232,244));
        
        btnRegisterModifyCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnRegisterModifyCandy.setForeground(new java.awt.Color(0,0,0));
        btnRegisterModifyCandy.setBackground(new java.awt.Color(239,232,244));
        
        btnSearchCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnSearchCandy.setForeground(new java.awt.Color(0,0,0));
        btnSearchCandy.setBackground(new java.awt.Color(239,232,244));
        
        txtIdCandy.setText("Código de la Golosina");
        txtNameCandy.setText("Nombre de la Golosina");
        txtDescriptionCandy.setText("Descripción");
        txtPriceCandy.setText("Precio de la Golosina");
        
        // Búsqueda
        txtSearchIdCandy.setText("Código de la Golosina");
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panCandyManagement = new javax.swing.JPanel();
        panButtonsTopBar = new javax.swing.JPanel();
        btnMin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblTittle = new javax.swing.JLabel();
        sepTittle = new javax.swing.JSeparator();
        lblSucursalName = new javax.swing.JLabel();
        btnChangeBranch = new javax.swing.JButton();
        panContainerCandy = new javax.swing.JPanel();
        panConsultList = new javax.swing.JPanel();
        scpCandyList = new javax.swing.JScrollPane();
        tblCandyList = new javax.swing.JTable();
        txtSearchIdCandy = new javax.swing.JTextField();
        sepSearchIdCandy = new javax.swing.JSeparator();
        btnSearchCandy = new javax.swing.JButton();
        btnClearSearchCandy = new javax.swing.JButton();
        panCRUD = new javax.swing.JPanel();
        lblTittle1 = new javax.swing.JLabel();
        lblIdCandy = new javax.swing.JLabel();
        lblNameCandy = new javax.swing.JLabel();
        lblDescriptionCandy = new javax.swing.JLabel();
        lblPriceCandy = new javax.swing.JLabel();
        txtIdCandy = new javax.swing.JTextField();
        txtNameCandy = new javax.swing.JTextField();
        txtDescriptionCandy = new javax.swing.JTextField();
        btnClearCandy = new javax.swing.JButton();
        btnRegisterModifyCandy = new javax.swing.JButton();
        btnBackCandy = new javax.swing.JButton();
        btnDeleteCandy = new javax.swing.JButton();
        txtPriceCandy = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panCandyManagement.setBackground(new java.awt.Color(249, 249, 249));
        panCandyManagement.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 0, 145)));

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
        lblTittle.setText("Gestión de Golosinas");
        lblTittle.setToolTipText("");

        sepTittle.setBackground(new java.awt.Color(249, 249, 249));
        sepTittle.setForeground(new java.awt.Color(239, 232, 244));

        lblSucursalName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSucursalName.setForeground(new java.awt.Color(75, 0, 145));
        lblSucursalName.setText("Sucursal ");

        btnChangeBranch.setBackground(new java.awt.Color(249, 249, 249));
        btnChangeBranch.setToolTipText("Cambiar Sucursal");
        btnChangeBranch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(249, 249, 249), 1, true));
        btnChangeBranch.setContentAreaFilled(false);
        btnChangeBranch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChangeBranch.setFocusPainted(false);
        btnChangeBranch.setPreferredSize(new java.awt.Dimension(50, 50));
        btnChangeBranch.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnChangeBranchMouseMoved(evt);
            }
        });
        btnChangeBranch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnChangeBranchMouseExited(evt);
            }
        });

        panContainerCandy.setBackground(new java.awt.Color(249, 249, 249));
        panContainerCandy.setLayout(new java.awt.CardLayout());

        panConsultList.setBackground(new java.awt.Color(249, 249, 249));

        tblCandyList.setBackground(new java.awt.Color(249, 249, 249));
        tblCandyList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Descripción", "Precio", "Consultar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCandyList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblCandyList.setSelectionBackground(new java.awt.Color(75, 0, 145));
        tblCandyList.getTableHeader().setReorderingAllowed(false);
        tblCandyList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCandyListMouseClicked(evt);
            }
        });
        scpCandyList.setViewportView(tblCandyList);

        txtSearchIdCandy.setBackground(new java.awt.Color(249, 249, 249));
        txtSearchIdCandy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSearchIdCandy.setText("Código de la Golosina");
        txtSearchIdCandy.setBorder(null);
        txtSearchIdCandy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchIdCandyMouseClicked(evt);
            }
        });
        txtSearchIdCandy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchIdCandyKeyTyped(evt);
            }
        });

        sepSearchIdCandy.setBackground(new java.awt.Color(249, 249, 249));
        sepSearchIdCandy.setForeground(new java.awt.Color(75, 0, 145));

        btnSearchCandy.setBackground(new java.awt.Color(249, 249, 249));
        btnSearchCandy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/findUserIcon.png"))); // NOI18N
        btnSearchCandy.setToolTipText(" Buscar");
        btnSearchCandy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(249, 249, 249), 1, true));
        btnSearchCandy.setContentAreaFilled(false);
        btnSearchCandy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchCandy.setFocusPainted(false);
        btnSearchCandy.setPreferredSize(new java.awt.Dimension(50, 50));
        btnSearchCandy.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSearchCandyMouseMoved(evt);
            }
        });
        btnSearchCandy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchCandyMouseExited(evt);
            }
        });

        btnClearSearchCandy.setBackground(new java.awt.Color(249, 249, 249));
        btnClearSearchCandy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/searchIcon.png"))); // NOI18N
        btnClearSearchCandy.setToolTipText("Limpiar");
        btnClearSearchCandy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(249, 249, 249), 1, true));
        btnClearSearchCandy.setContentAreaFilled(false);
        btnClearSearchCandy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearSearchCandy.setFocusPainted(false);
        btnClearSearchCandy.setPreferredSize(new java.awt.Dimension(50, 50));
        btnClearSearchCandy.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnClearSearchCandyMouseMoved(evt);
            }
        });
        btnClearSearchCandy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClearSearchCandyMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panConsultListLayout = new javax.swing.GroupLayout(panConsultList);
        panConsultList.setLayout(panConsultListLayout);
        panConsultListLayout.setHorizontalGroup(
            panConsultListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConsultListLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panConsultListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sepSearchIdCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchIdCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(btnSearchCandy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClearSearchCandy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panConsultListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpCandyList, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
                .addContainerGap())
        );
        panConsultListLayout.setVerticalGroup(
            panConsultListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConsultListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panConsultListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClearSearchCandy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panConsultListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panConsultListLayout.createSequentialGroup()
                            .addComponent(txtSearchIdCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(sepSearchIdCandy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnSearchCandy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(scpCandyList, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );

        panContainerCandy.add(panConsultList, "card2");

        panCRUD.setBackground(new java.awt.Color(249, 249, 249));

        lblTittle1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTittle1.setForeground(new java.awt.Color(28, 0, 63));
        lblTittle1.setText("Datos de la golosina");
        lblTittle1.setToolTipText("");

        lblIdCandy.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblIdCandy.setForeground(new java.awt.Color(28, 0, 63));
        lblIdCandy.setText("Código:");
        lblIdCandy.setToolTipText("");

        lblNameCandy.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblNameCandy.setForeground(new java.awt.Color(28, 0, 63));
        lblNameCandy.setText("Nombre");
        lblNameCandy.setToolTipText("");

        lblDescriptionCandy.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblDescriptionCandy.setForeground(new java.awt.Color(28, 0, 63));
        lblDescriptionCandy.setText("Descripción:");
        lblDescriptionCandy.setToolTipText("");

        lblPriceCandy.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblPriceCandy.setForeground(new java.awt.Color(28, 0, 63));
        lblPriceCandy.setText("Precio");
        lblPriceCandy.setToolTipText("");

        txtIdCandy.setBackground(new java.awt.Color(249, 249, 249));
        txtIdCandy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIdCandy.setText("Código de la Golosina");
        txtIdCandy.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 0, 145)));
        txtIdCandy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCandyActionPerformed(evt);
            }
        });

        txtNameCandy.setBackground(new java.awt.Color(249, 249, 249));
        txtNameCandy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNameCandy.setText("Nombre de la Golosina");
        txtNameCandy.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 0, 145)));

        txtDescriptionCandy.setBackground(new java.awt.Color(249, 249, 249));
        txtDescriptionCandy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDescriptionCandy.setText("Descripción");
        txtDescriptionCandy.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 0, 145)));

        btnClearCandy.setBackground(new java.awt.Color(239, 232, 244));
        btnClearCandy.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnClearCandy.setText("Limpiar");
        btnClearCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnClearCandy.setBorderPainted(false);
        btnClearCandy.setContentAreaFilled(false);
        btnClearCandy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearCandy.setFocusPainted(false);
        btnClearCandy.setOpaque(true);
        btnClearCandy.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnClearCandyMouseMoved(evt);
            }
        });
        btnClearCandy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClearCandyMouseExited(evt);
            }
        });

        btnRegisterModifyCandy.setBackground(new java.awt.Color(239, 232, 244));
        btnRegisterModifyCandy.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRegisterModifyCandy.setText("@Registrar/Actualizar");
        btnRegisterModifyCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegisterModifyCandy.setBorderPainted(false);
        btnRegisterModifyCandy.setContentAreaFilled(false);
        btnRegisterModifyCandy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegisterModifyCandy.setFocusPainted(false);
        btnRegisterModifyCandy.setOpaque(true);
        btnRegisterModifyCandy.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRegisterModifyCandyMouseMoved(evt);
            }
        });
        btnRegisterModifyCandy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegisterModifyCandyMouseExited(evt);
            }
        });

        btnBackCandy.setBackground(new java.awt.Color(239, 232, 244));
        btnBackCandy.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBackCandy.setText("Atrás");
        btnBackCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBackCandy.setBorderPainted(false);
        btnBackCandy.setContentAreaFilled(false);
        btnBackCandy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackCandy.setFocusPainted(false);
        btnBackCandy.setOpaque(true);
        btnBackCandy.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBackCandyMouseMoved(evt);
            }
        });
        btnBackCandy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackCandyMouseExited(evt);
            }
        });

        btnDeleteCandy.setBackground(new java.awt.Color(239, 232, 244));
        btnDeleteCandy.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnDeleteCandy.setText("Eliminar");
        btnDeleteCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDeleteCandy.setBorderPainted(false);
        btnDeleteCandy.setContentAreaFilled(false);
        btnDeleteCandy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteCandy.setFocusPainted(false);
        btnDeleteCandy.setOpaque(true);
        btnDeleteCandy.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnDeleteCandyMouseMoved(evt);
            }
        });
        btnDeleteCandy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteCandyMouseExited(evt);
            }
        });

        txtPriceCandy.setBackground(new java.awt.Color(249, 249, 249));
        txtPriceCandy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPriceCandy.setText("Precio de la Golosina");
        txtPriceCandy.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 0, 145)));

        javax.swing.GroupLayout panCRUDLayout = new javax.swing.GroupLayout(panCRUD);
        panCRUD.setLayout(panCRUDLayout);
        panCRUDLayout.setHorizontalGroup(
            panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCRUDLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTittle1, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panCRUDLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCRUDLayout.createSequentialGroup()
                        .addComponent(lblIdCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDescriptionCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescriptionCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(panCRUDLayout.createSequentialGroup()
                        .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCRUDLayout.createSequentialGroup()
                                .addComponent(btnBackCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeleteCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClearCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRegisterModifyCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panCRUDLayout.createSequentialGroup()
                                .addComponent(lblNameCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNameCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(lblPriceCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPriceCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panCRUDLayout.setVerticalGroup(
            panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCRUDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTittle1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDescriptionCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescriptionCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPriceCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNameCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPriceCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(panCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBackCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegisterModifyCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panContainerCandy.add(panCRUD, "card2");

        javax.swing.GroupLayout panCandyManagementLayout = new javax.swing.GroupLayout(panCandyManagement);
        panCandyManagement.setLayout(panCandyManagementLayout);
        panCandyManagementLayout.setHorizontalGroup(
            panCandyManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panButtonsTopBar, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
            .addComponent(sepTittle)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCandyManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCandyManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panContainerCandy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panCandyManagementLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSucursalName, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChangeBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        panCandyManagementLayout.setVerticalGroup(
            panCandyManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCandyManagementLayout.createSequentialGroup()
                .addComponent(panButtonsTopBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCandyManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCandyManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSucursalName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnChangeBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panContainerCandy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panCandyManagement, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panCandyManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnChangeBranchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeBranchMouseMoved
        btnChangeBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnChangeBranchMouseMoved

    private void btnChangeBranchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeBranchMouseExited
        btnChangeBranch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnChangeBranchMouseExited

    private void tblCandyListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCandyListMouseClicked
        setColumnTable(tblCandyList.getColumnModel().getColumnIndexAtX(evt.getX()));
        setRowTable(evt.getY()/tblCandyList.getRowHeight());    }//GEN-LAST:event_tblCandyListMouseClicked

    private void txtSearchIdCandyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchIdCandyMouseClicked
        txtSearchIdCandy.setText("");
    }//GEN-LAST:event_txtSearchIdCandyMouseClicked

    private void txtSearchIdCandyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchIdCandyKeyTyped
        /*if(txtSearchIdEmployee.getText().length() < 10)
        support.integerPositiveKeyTyped(evt);
        else
        evt.consume();*/
    }//GEN-LAST:event_txtSearchIdCandyKeyTyped

    private void btnSearchCandyMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchCandyMouseMoved
        btnSearchCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnSearchCandyMouseMoved

    private void btnSearchCandyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchCandyMouseExited
        btnSearchCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnSearchCandyMouseExited

    private void btnClearSearchCandyMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearSearchCandyMouseMoved
        btnClearSearchCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
    }//GEN-LAST:event_btnClearSearchCandyMouseMoved

    private void btnClearSearchCandyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearSearchCandyMouseExited
        btnClearSearchCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
    }//GEN-LAST:event_btnClearSearchCandyMouseExited

    private void txtIdCandyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCandyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCandyActionPerformed

    private void btnClearCandyMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearCandyMouseMoved
        btnClearCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnClearCandy.setForeground(new java.awt.Color(255,255,255));
        btnClearCandy.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnClearCandyMouseMoved

    private void btnClearCandyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearCandyMouseExited
        btnClearCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnClearCandy.setForeground(new java.awt.Color(0,0,0));
        btnClearCandy.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnClearCandyMouseExited

    private void btnRegisterModifyCandyMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterModifyCandyMouseMoved
        btnRegisterModifyCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnRegisterModifyCandy.setForeground(new java.awt.Color(255,255,255));
        btnRegisterModifyCandy.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnRegisterModifyCandyMouseMoved

    private void btnRegisterModifyCandyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterModifyCandyMouseExited
        btnRegisterModifyCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnRegisterModifyCandy.setForeground(new java.awt.Color(0,0,0));
        btnRegisterModifyCandy.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnRegisterModifyCandyMouseExited

    private void btnBackCandyMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackCandyMouseMoved
        btnBackCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnBackCandy.setForeground(new java.awt.Color(255,255,255));
        btnBackCandy.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnBackCandyMouseMoved

    private void btnBackCandyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackCandyMouseExited
        btnBackCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnBackCandy.setForeground(new java.awt.Color(0,0,0));
        btnBackCandy.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnBackCandyMouseExited

    private void btnDeleteCandyMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteCandyMouseMoved
        btnDeleteCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnDeleteCandy.setForeground(new java.awt.Color(255,255,255));
        btnDeleteCandy.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnDeleteCandyMouseMoved

    private void btnDeleteCandyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteCandyMouseExited
        btnDeleteCandy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnDeleteCandy.setForeground(new java.awt.Color(0,0,0));
        btnDeleteCandy.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnDeleteCandyMouseExited



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBackCandy;
    public javax.swing.JButton btnChangeBranch;
    public javax.swing.JButton btnClearCandy;
    public javax.swing.JButton btnClearSearchCandy;
    public javax.swing.JButton btnDeleteCandy;
    public javax.swing.JButton btnExit;
    public javax.swing.JButton btnMin;
    public javax.swing.JButton btnRegisterModifyCandy;
    public javax.swing.JButton btnSearchCandy;
    private javax.swing.JLabel lblDescriptionCandy;
    private javax.swing.JLabel lblIdCandy;
    private javax.swing.JLabel lblNameCandy;
    private javax.swing.JLabel lblPriceCandy;
    public javax.swing.JLabel lblSucursalName;
    private javax.swing.JLabel lblTittle;
    private javax.swing.JLabel lblTittle1;
    private javax.swing.JPanel panButtonsTopBar;
    public javax.swing.JPanel panCRUD;
    private javax.swing.JPanel panCandyManagement;
    public javax.swing.JPanel panConsultList;
    public javax.swing.JPanel panContainerCandy;
    private javax.swing.JScrollPane scpCandyList;
    private javax.swing.JSeparator sepSearchIdCandy;
    private javax.swing.JSeparator sepTittle;
    public javax.swing.JTable tblCandyList;
    public javax.swing.JTextField txtDescriptionCandy;
    public javax.swing.JTextField txtIdCandy;
    public javax.swing.JTextField txtNameCandy;
    public javax.swing.JTextField txtPriceCandy;
    public javax.swing.JTextField txtSearchIdCandy;
    // End of variables declaration//GEN-END:variables
}
