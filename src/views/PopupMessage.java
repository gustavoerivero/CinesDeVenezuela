package views;

/**
 *
 * @author Gustavo
 */
public class PopupMessage extends javax.swing.JFrame {
    
    public PopupMessage(int type, String message) {
        initComponents();
                      
        // Identificar el tipo de mensaje
        switch(type){
            case 1:
                lblIcon.setIcon(new javax.swing.ImageIcon("/images/helpIcon.png"));
                break;
            case 2:
                lblIcon.setIcon(new javax.swing.ImageIcon("/images/highPriorityIcon.png"));
                break;
            case 3:
                lblIcon.setIcon(new javax.swing.ImageIcon("/images/errorIcon.png"));
                break;
        }
        
        // Colocar el mensaje pasado por parámetro en el JFrame
        lblMessage.setText(message);
                
        // Cambia el ícono del JFrame.
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("images/CDV-icon.png")).getImage());
        
        // Ubicar el JFrame en el centro de la pantalla.
        setLocationRelativeTo(null);
        
        // Hacer visible el JFrame
        this.setVisible(true);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panPopupMessage = new javax.swing.JPanel();
        lblIcon = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        panOkSelectSucursal = new javax.swing.JPanel();
        btnOkSelectSucursal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panPopupMessage.setBackground(new java.awt.Color(249, 249, 249));
        panPopupMessage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 0, 145)));

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblMessage.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(75, 0, 145));
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessage.setText("<html><p align='center'>Contenido</p></html>");

        panOkSelectSucursal.setBackground(new java.awt.Color(239, 232, 244));
        panOkSelectSucursal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 249, 249)));
        panOkSelectSucursal.setForeground(new java.awt.Color(255, 255, 255));

        btnOkSelectSucursal.setBackground(new java.awt.Color(245, 245, 245));
        btnOkSelectSucursal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnOkSelectSucursal.setForeground(new java.awt.Color(0, 0, 0));
        btnOkSelectSucursal.setText("Aceptar");
        btnOkSelectSucursal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnOkSelectSucursal.setBorderPainted(false);
        btnOkSelectSucursal.setContentAreaFilled(false);
        btnOkSelectSucursal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOkSelectSucursal.setFocusPainted(false);
        btnOkSelectSucursal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnOkSelectSucursalMouseMoved(evt);
            }
        });
        btnOkSelectSucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOkSelectSucursalMouseExited(evt);
            }
        });
        btnOkSelectSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkSelectSucursalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panOkSelectSucursalLayout = new javax.swing.GroupLayout(panOkSelectSucursal);
        panOkSelectSucursal.setLayout(panOkSelectSucursalLayout);
        panOkSelectSucursalLayout.setHorizontalGroup(
            panOkSelectSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOkSelectSucursalLayout.createSequentialGroup()
                .addComponent(btnOkSelectSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panOkSelectSucursalLayout.setVerticalGroup(
            panOkSelectSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panOkSelectSucursalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnOkSelectSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panPopupMessageLayout = new javax.swing.GroupLayout(panPopupMessage);
        panPopupMessage.setLayout(panPopupMessageLayout);
        panPopupMessageLayout.setHorizontalGroup(
            panPopupMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPopupMessageLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPopupMessageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panPopupMessageLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(panOkSelectSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panPopupMessageLayout.setVerticalGroup(
            panPopupMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPopupMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panOkSelectSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panPopupMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panPopupMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkSelectSucursalMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkSelectSucursalMouseMoved
        panOkSelectSucursal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75,0,145)));
        btnOkSelectSucursal.setForeground(new java.awt.Color(255,255,255));
        panOkSelectSucursal.setBackground(new java.awt.Color(66,0,124));
    }//GEN-LAST:event_btnOkSelectSucursalMouseMoved

    private void btnOkSelectSucursalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkSelectSucursalMouseExited
        panOkSelectSucursal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249,249,249)));
        btnOkSelectSucursal.setForeground(new java.awt.Color(0,0,0));
        panOkSelectSucursal.setBackground(new java.awt.Color(239,232,244));
    }//GEN-LAST:event_btnOkSelectSucursalMouseExited

    private void btnOkSelectSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkSelectSucursalActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOkSelectSucursalActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnOkSelectSucursal;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblMessage;
    public javax.swing.JPanel panOkSelectSucursal;
    private javax.swing.JPanel panPopupMessage;
    // End of variables declaration//GEN-END:variables
}
