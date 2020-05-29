package views;

import lib.SuportFunctions;

/**
 *
 * @author Gustavo
 */
public class PopupMessage extends javax.swing.JFrame {
    
    int xx = 0, xy = 0;
    
    private SuportFunctions sf;
    
    public PopupMessage(int type, String message) {
        initComponents();
                      
        sf = new SuportFunctions();
        
        // Identificar el tipo de mensaje
        switch(type){
            // type == 1 -> Error
            case 1:
                sf.cardSelection(panIcon, panIcon_Error);
                break;
            // type == 2 -> High Priority
            case 2:
                sf.cardSelection(panIcon, panIcon_HighPriority);
                break;
            // type == 3 -> Help
            case 3:
                sf.cardSelection(panIcon, panIcon_Help);
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
        lblMessage = new javax.swing.JLabel();
        panOkSelectSucursal = new javax.swing.JPanel();
        btnOkSelectSucursal = new javax.swing.JButton();
        panIcon = new javax.swing.JPanel();
        panIcon_Error = new javax.swing.JPanel();
        lblIcon_Error = new javax.swing.JLabel();
        panIcon_HighPriority = new javax.swing.JPanel();
        lblIcon_HighPriority = new javax.swing.JLabel();
        panIcon_Help = new javax.swing.JPanel();
        lblIcon_Help = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panPopupMessage.setBackground(new java.awt.Color(249, 249, 249));
        panPopupMessage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(75, 0, 145)));
        panPopupMessage.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panPopupMessageMouseDragged(evt);
            }
        });
        panPopupMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panPopupMessageMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panPopupMessageMouseReleased(evt);
            }
        });

        lblMessage.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(75, 0, 145));
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessage.setText("Contenido");

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
                .addComponent(btnOkSelectSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panOkSelectSucursalLayout.setVerticalGroup(
            panOkSelectSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panOkSelectSucursalLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnOkSelectSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
        );

        panIcon.setBackground(new java.awt.Color(249, 249, 249));
        panIcon.setMinimumSize(new java.awt.Dimension(314, 88));
        panIcon.setPreferredSize(new java.awt.Dimension(314, 88));
        panIcon.setLayout(new java.awt.CardLayout());

        panIcon_Error.setBackground(new java.awt.Color(249, 249, 249));

        lblIcon_Error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon_Error.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/errorIcon.png"))); // NOI18N

        javax.swing.GroupLayout panIcon_ErrorLayout = new javax.swing.GroupLayout(panIcon_Error);
        panIcon_Error.setLayout(panIcon_ErrorLayout);
        panIcon_ErrorLayout.setHorizontalGroup(
            panIcon_ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
            .addGroup(panIcon_ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panIcon_ErrorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblIcon_Error, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panIcon_ErrorLayout.setVerticalGroup(
            panIcon_ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
            .addGroup(panIcon_ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panIcon_ErrorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblIcon_Error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panIcon.add(panIcon_Error, "card2");

        panIcon_HighPriority.setBackground(new java.awt.Color(249, 249, 249));

        lblIcon_HighPriority.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon_HighPriority.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/highPriorityIcon.png"))); // NOI18N

        javax.swing.GroupLayout panIcon_HighPriorityLayout = new javax.swing.GroupLayout(panIcon_HighPriority);
        panIcon_HighPriority.setLayout(panIcon_HighPriorityLayout);
        panIcon_HighPriorityLayout.setHorizontalGroup(
            panIcon_HighPriorityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
            .addGroup(panIcon_HighPriorityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panIcon_HighPriorityLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblIcon_HighPriority, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panIcon_HighPriorityLayout.setVerticalGroup(
            panIcon_HighPriorityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
            .addGroup(panIcon_HighPriorityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panIcon_HighPriorityLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblIcon_HighPriority, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panIcon.add(panIcon_HighPriority, "card2");

        panIcon_Help.setBackground(new java.awt.Color(249, 249, 249));

        lblIcon_Help.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon_Help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/helpIcon.png"))); // NOI18N

        javax.swing.GroupLayout panIcon_HelpLayout = new javax.swing.GroupLayout(panIcon_Help);
        panIcon_Help.setLayout(panIcon_HelpLayout);
        panIcon_HelpLayout.setHorizontalGroup(
            panIcon_HelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
            .addGroup(panIcon_HelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panIcon_HelpLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblIcon_Help, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panIcon_HelpLayout.setVerticalGroup(
            panIcon_HelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
            .addGroup(panIcon_HelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panIcon_HelpLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblIcon_Help, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panIcon.add(panIcon_Help, "card2");

        javax.swing.GroupLayout panPopupMessageLayout = new javax.swing.GroupLayout(panPopupMessage);
        panPopupMessage.setLayout(panPopupMessageLayout);
        panPopupMessageLayout.setHorizontalGroup(
            panPopupMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panPopupMessageLayout.createSequentialGroup()
                .addGroup(panPopupMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPopupMessageLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(panOkSelectSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panPopupMessageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panPopupMessageLayout.setVerticalGroup(
            panPopupMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPopupMessageLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panOkSelectSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
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

    // Si se mantiene el click pulsado en la barra superior.
    private void panPopupMessageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panPopupMessageMousePressed
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
    }//GEN-LAST:event_panPopupMessageMousePressed

    // Si se deja de presionar el click sobre la barra superior.
    private void panPopupMessageMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panPopupMessageMouseReleased
        //<editor-fold defaultstate="collapsed" desc=" Explicación sobre el método ">
        /*
         * Este método devuelve la opacidad de la aplicación a su valor base.
         */
        
        // Se coloca la opacidad de la aplicación en 100%.
        //</editor-fold>
        setOpacity((float)1.0);
    }//GEN-LAST:event_panPopupMessageMouseReleased

    // Si se mantiene el click pulsado y se mueve a través de la pantalla.
    private void panPopupMessageMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panPopupMessageMouseDragged
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
    }//GEN-LAST:event_panPopupMessageMouseDragged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnOkSelectSucursal;
    private javax.swing.JLabel lblIcon_Error;
    private javax.swing.JLabel lblIcon_Help;
    private javax.swing.JLabel lblIcon_HighPriority;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JPanel panIcon;
    private javax.swing.JPanel panIcon_Error;
    private javax.swing.JPanel panIcon_Help;
    private javax.swing.JPanel panIcon_HighPriority;
    public javax.swing.JPanel panOkSelectSucursal;
    private javax.swing.JPanel panPopupMessage;
    // End of variables declaration//GEN-END:variables
}
