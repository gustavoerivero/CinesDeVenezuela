
package views;

// Se importa librería de soporte.
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
public class ModifyCandy extends javax.swing.JDialog {

    // Se declaran las variables de apoyo.
    int xx = 0, xy = 0;
    
    // Se declaran las variables.
    int cant = 0;
    double price = 0, iva = 0, total = 0, buy = 0;
        
    // Se declaran las clases de apoyo
    private SupportFunctions suport;
    private PopupMessage popup;
    
    /**
     * Constructor
     * @param parent JFrame padre.
     * @param modal Indica si el JDialog es de uso modal o no.
     * @param name Nombre del producto a modificar.
     * @param desc Descripción del producto a modificar.
     * @param amount Precio del producto a modificar.
     */
    public ModifyCandy(java.awt.Frame parent, boolean modal, String name, 
            String desc, double amount) {
        
        super(parent, modal);
        initComponents();
        
        // Se inicializa la clase de soporte
        suport = new SupportFunctions();
        
        // Se indican los valores iniciales del JDialog
        lblCandyName.setText(name);
        lblCandyDescription.setText("<html><p align = 'justify'>" + desc + "</p></html>");
        
        // Se muestra el precio, IVA y monto total que cuesta el producto.
        price   = suport.numberDecimalFormat(amount, 2);
        iva     = suport.numberDecimalFormat(price * 0.16, 2);
        total   = suport.numberDecimalFormat(price * 1.16, 2);
        
        // Se muestra en la interfaz las variables anteriormente calculadas.
        txtPrice.setText(String.valueOf(price));
        txtIVA.setText(String.valueOf(iva));
        txtTotal.setText(String.valueOf(total));
        
        // Se inicializan los campos.
        spnCant.setValue(0);
        txtBuy.setText("0.0");
                
        // Se ubica la interfaz en el centro de la pantalla.
        setLocationRelativeTo(null);
        
        // Se muestra la interfaz.
        setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panModifyCandy = new javax.swing.JPanel();
        panCancel = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        panClear = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        panOk = new javax.swing.JPanel();
        btnOk = new javax.swing.JButton();
        lblTittleModifyCandy = new javax.swing.JLabel();
        lblCandyName = new javax.swing.JLabel();
        lblCandyDescription = new javax.swing.JLabel();
        lblCandyPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblIVA = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblCandyCant = new javax.swing.JLabel();
        spnCant = new javax.swing.JSpinner();
        lblBuy = new javax.swing.JLabel();
        txtBuy = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panModifyCandy.setBackground(new java.awt.Color(249, 249, 249));
        panModifyCandy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 145), 1, true));
        panModifyCandy.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panModifyCandyMouseDragged(evt);
            }
        });
        panModifyCandy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panModifyCandyMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panModifyCandyMouseReleased(evt);
            }
        });

        panCancel.setBackground(new java.awt.Color(239, 232, 244));
        panCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        panCancel.setForeground(new java.awt.Color(255, 255, 255));

        btnCancel.setBackground(new java.awt.Color(245, 245, 245));
        btnCancel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(0, 0, 0));
        btnCancel.setText("Cancelar");
        btnCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCancel.setBorderPainted(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setFocusPainted(false);
        btnCancel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCancelMouseMoved(evt);
            }
        });
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelMouseExited(evt);
            }
        });
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panCancelLayout = new javax.swing.GroupLayout(panCancel);
        panCancel.setLayout(panCancelLayout);
        panCancelLayout.setHorizontalGroup(
            panCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCancelLayout.createSequentialGroup()
                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panCancelLayout.setVerticalGroup(
            panCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panClear.setBackground(new java.awt.Color(239, 232, 244));
        panClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        panClear.setForeground(new java.awt.Color(255, 255, 255));

        btnClear.setBackground(new java.awt.Color(245, 245, 245));
        btnClear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(0, 0, 0));
        btnClear.setText("Limpiar");
        btnClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnClear.setBorderPainted(false);
        btnClear.setContentAreaFilled(false);
        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.setFocusPainted(false);
        btnClear.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnClearMouseMoved(evt);
            }
        });
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClearMouseExited(evt);
            }
        });
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panClearLayout = new javax.swing.GroupLayout(panClear);
        panClear.setLayout(panClearLayout);
        panClearLayout.setHorizontalGroup(
            panClearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panClearLayout.createSequentialGroup()
                .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panClearLayout.setVerticalGroup(
            panClearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panClearLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panOk.setBackground(new java.awt.Color(239, 232, 244));
        panOk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        panOk.setForeground(new java.awt.Color(255, 255, 255));

        btnOk.setBackground(new java.awt.Color(245, 245, 245));
        btnOk.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnOk.setForeground(new java.awt.Color(0, 0, 0));
        btnOk.setText("Aceptar");
        btnOk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnOk.setBorderPainted(false);
        btnOk.setContentAreaFilled(false);
        btnOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOk.setFocusPainted(false);
        btnOk.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnOkMouseMoved(evt);
            }
        });
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOkMouseExited(evt);
            }
        });
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panOkLayout = new javax.swing.GroupLayout(panOk);
        panOk.setLayout(panOkLayout);
        panOkLayout.setHorizontalGroup(
            panOkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnOk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        panOkLayout.setVerticalGroup(
            panOkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

        lblTittleModifyCandy.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblTittleModifyCandy.setForeground(new java.awt.Color(75, 0, 145));
        lblTittleModifyCandy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTittleModifyCandy.setText("Modificar golosina");

        lblCandyName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCandyName.setForeground(new java.awt.Color(75, 0, 145));
        lblCandyName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCandyName.setText("Nombre golosina");

        lblCandyDescription.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCandyDescription.setForeground(new java.awt.Color(0, 0, 0));
        lblCandyDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCandyDescription.setText("Descripción");

        lblCandyPrice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCandyPrice.setForeground(new java.awt.Color(0, 0, 0));
        lblCandyPrice.setText("Precio: ");

        txtPrice.setEditable(false);
        txtPrice.setBackground(new java.awt.Color(249, 249, 249));
        txtPrice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(60, 63, 65));
        txtPrice.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtPrice.setText("0.0");
        txtPrice.setBorder(null);
        txtPrice.setOpaque(false);
        txtPrice.setSelectionColor(new java.awt.Color(75, 0, 145));

        lblIVA.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblIVA.setForeground(new java.awt.Color(0, 0, 0));
        lblIVA.setText("IVA (16%): ");

        txtIVA.setEditable(false);
        txtIVA.setBackground(new java.awt.Color(249, 249, 249));
        txtIVA.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIVA.setForeground(new java.awt.Color(60, 63, 65));
        txtIVA.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtIVA.setText("0.0");
        txtIVA.setBorder(null);
        txtIVA.setOpaque(false);
        txtIVA.setSelectionColor(new java.awt.Color(75, 0, 145));

        lblTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 0, 0));
        lblTotal.setText("Total: ");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(249, 249, 249));
        txtTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(60, 63, 65));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtTotal.setText("0.0");
        txtTotal.setBorder(null);
        txtTotal.setOpaque(false);
        txtTotal.setSelectionColor(new java.awt.Color(75, 0, 145));

        lblCandyCant.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCandyCant.setForeground(new java.awt.Color(0, 0, 0));
        lblCandyCant.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblCandyCant.setText("Ingrese un cantidad:");

        spnCant.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        spnCant.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnCant.setAutoscrolls(true);
        spnCant.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        spnCant.setEditor(new javax.swing.JSpinner.NumberEditor(spnCant, ""));
        spnCant.setOpaque(false);
        spnCant.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCantStateChanged(evt);
            }
        });

        lblBuy.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblBuy.setForeground(new java.awt.Color(0, 0, 0));
        lblBuy.setText("A pagar:");

        txtBuy.setEditable(false);
        txtBuy.setBackground(new java.awt.Color(249, 249, 249));
        txtBuy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuy.setForeground(new java.awt.Color(60, 63, 65));
        txtBuy.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtBuy.setText("0.0");
        txtBuy.setBorder(null);
        txtBuy.setOpaque(false);
        txtBuy.setSelectionColor(new java.awt.Color(75, 0, 145));

        javax.swing.GroupLayout panModifyCandyLayout = new javax.swing.GroupLayout(panModifyCandy);
        panModifyCandy.setLayout(panModifyCandyLayout);
        panModifyCandyLayout.setHorizontalGroup(
            panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panModifyCandyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTittleModifyCandy, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addGroup(panModifyCandyLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panModifyCandyLayout.createSequentialGroup()
                                .addComponent(lblCandyCant, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnCant, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCandyDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCandyName, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panModifyCandyLayout.createSequentialGroup()
                                .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblBuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblIVA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panModifyCandyLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtIVA)
                                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panModifyCandyLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(txtBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panModifyCandyLayout.createSequentialGroup()
                                .addComponent(lblCandyPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panModifyCandyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        panModifyCandyLayout.setVerticalGroup(
            panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panModifyCandyLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblTittleModifyCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCandyName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCandyPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCandyDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panModifyCandyLayout.createSequentialGroup()
                        .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(spnCant)
                        .addComponent(lblCandyCant, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBuy)
                        .addComponent(lblBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(panModifyCandyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panModifyCandy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panModifyCandy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Retorna la cantidad ingresada.
     * @return 
     */
    public int getCant() {
        return cant;
    }

    /**
     * Retorna el monto total a pagar.
     * @return 
     */
    public double getBuy(){
        return buy;
    }
        
    private void btnClearMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseMoved
        panClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnClear.setForeground(new java.awt.Color(255,255,255));
        panClear.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnClearMouseMoved

    private void btnClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseExited
        panClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnClear.setForeground(new java.awt.Color(0,0,0));
        panClear.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnClearMouseExited

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        spnCant.setValue(0);
        txtBuy.setText("0.0");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCancelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseMoved
        panCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnCancel.setForeground(new java.awt.Color(255,255,255));
        panCancel.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnCancelMouseMoved

    private void btnCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseExited
        panCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnCancel.setForeground(new java.awt.Color(0,0,0));
        panCancel.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnCancelMouseExited

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOkMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseMoved
        panOk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnOk.setForeground(new java.awt.Color(255,255,255));
        panOk.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnOkMouseMoved

    private void btnOkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseExited
        panOk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnOk.setForeground(new java.awt.Color(0,0,0));
        panOk.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnOkMouseExited

    /**
     * Evento que ocurre cuando se presiona el botón de 'Aceptar'.
     * @param evt 
     */
    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // Si la cantidad ingresada es mayor a cero.
        if(Integer.valueOf(spnCant.getValue().toString()) > 0)
            // Se cierra el JDialog
            dispose();
        else // De lo contrario, muestra mensaje de error.
            popup = new PopupMessage(this, true, 1, "Debe indicar una cantidad de golosinas");
    }//GEN-LAST:event_btnOkActionPerformed

    /**
     * Evento provocado cada vez que el JSpinner de Cantidad es alterado.
     * Se obtiene la cantidad ingresada y muestra en pantalla el monto total a 
     * pagar por el cliente.
     * @param evt 
     */
    private void spnCantStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCantStateChanged
        
        // Recibe la cantidad ingresada.
        cant = Integer.valueOf(spnCant.getValue().toString());
        
        // Se calcula el monto total a pagar.
        buy = suport.numberDecimalFormat(price * cant * 1.16, 2);
        
        // Se muestra en pantalla el monto total a pagar.
        txtBuy.setText(String.valueOf(buy));
    }//GEN-LAST:event_spnCantStateChanged

    private void panModifyCandyMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panModifyCandyMouseDragged
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
    }//GEN-LAST:event_panModifyCandyMouseDragged

    private void panModifyCandyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panModifyCandyMousePressed
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
    }//GEN-LAST:event_panModifyCandyMousePressed

    private void panModifyCandyMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panModifyCandyMouseReleased
        //<editor-fold defaultstate="collapsed" desc=" Explicación sobre el método ">
        /*
         * Este método devuelve la opacidad de la aplicación a su valor base.
         */
        
        // Se coloca la opacidad de la aplicación en 100%.
        //</editor-fold>
        setOpacity((float)1.0);
    }//GEN-LAST:event_panModifyCandyMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancel;
    public javax.swing.JButton btnClear;
    public javax.swing.JButton btnOk;
    private javax.swing.JLabel lblBuy;
    private javax.swing.JLabel lblCandyCant;
    private javax.swing.JLabel lblCandyDescription;
    private javax.swing.JLabel lblCandyName;
    private javax.swing.JLabel lblCandyPrice;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblTittleModifyCandy;
    private javax.swing.JLabel lblTotal;
    public javax.swing.JPanel panCancel;
    public javax.swing.JPanel panClear;
    private javax.swing.JPanel panModifyCandy;
    public javax.swing.JPanel panOk;
    public javax.swing.JSpinner spnCant;
    private javax.swing.JTextField txtBuy;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
