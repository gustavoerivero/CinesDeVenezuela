
package views;

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
public class PopupMessage extends javax.swing.JDialog {

    int xx = 0, xy = 0;
    
    /**
     * Constructor de mensaje emergente dedicado a Frames.
     * @param parent Pariente del mensaje emergente.
     * @param modal Indicar si el mensaje emergente es o no modal.
     * @param type El tipo de mensaje emergente.
     * @param message El mensaje a mostrar.
     */
    public PopupMessage(java.awt.Frame parent, boolean modal, int type, String message) {
        
        super(parent, modal);
        
        initComponents();
        
        // Identificar el tipo de mensaje
        switch(type){
            // type == 1 -> Error
            case 1:
                lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/errorIcon.png")));
                break;
            // type == 2 -> High Priority
            case 2:
                lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/highPriorityIcon.png")));
                break;
            // type == 3 -> Help
            case 3:
                lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/helpIcon.png")));
                break;
            // type == 4 -> Ok
            case 4:
                lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/okIcon.png")));
        }
        
        // Colocar el mensaje pasado por parámetro en el JDialog
        lblMessage.setText("<html><p align='center'>" + message + "</p></html>");
                
        // Cambia el ícono del JDialog.
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("images/CDV-icon.png")).getImage());
        
        // Ubicar el JDialog en el centro de la pantalla.
        setLocationRelativeTo(null);
        
        // Hacer visible el JDialog
        setVisible(true);
        
    }
    
    /**
     * Constructor de mensaje emergente dedicado a Mensajes de Dialogos.
     * @param parent Pariente del mensaje emergente.
     * @param modal Indicar si el mensaje emergente es o no modal.
     * @param type El tipo de mensaje emergente.
     * @param message El mensaje a mostrar.
     */
    public PopupMessage(java.awt.Dialog parent, boolean modal, int type, String message) {
        
        super(parent, modal);
        
        initComponents();
        
        // Identificar el tipo de mensaje
        switch(type){
            // type == 1 -> Error
            case 1:
                lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/errorIcon.png")));
                break;
            // type == 2 -> High Priority
            case 2:
                lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/highPriorityIcon.png")));
                break;
            // type == 3 -> Help
            case 3:
                lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/helpIcon.png")));
                break;
            // type == 4 -> Ok
            case 4:
                lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/okIcon.png")));
        }
        
        // Colocar el mensaje pasado por parámetro en el JDialog
        lblMessage.setText("<html><p align='center'>" + message + "</p></html>");
                
        // Cambia el ícono del JDialog.
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("images/CDV-icon.png")).getImage());
        
        // Ubicar el JDialog en el centro de la pantalla.
        setLocationRelativeTo(null);
        
        // Hacer visible el JDialog
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

        panPopupMessage = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        panOkSelectSucursal = new javax.swing.JPanel();
        btnOkSelectSucursal = new javax.swing.JButton();
        lblIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
                .addComponent(btnOkSelectSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
        );

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panPopupMessageLayout = new javax.swing.GroupLayout(panPopupMessage);
        panPopupMessage.setLayout(panPopupMessageLayout);
        panPopupMessageLayout.setHorizontalGroup(
            panPopupMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPopupMessageLayout.createSequentialGroup()
                .addGroup(panPopupMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPopupMessageLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(panOkSelectSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panPopupMessageLayout.setVerticalGroup(
            panPopupMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPopupMessageLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panOkSelectSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panPopupMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void panPopupMessageMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panPopupMessageMouseReleased
        //<editor-fold defaultstate="collapsed" desc=" Explicación sobre el método ">
        /*
        * Este método devuelve la opacidad de la aplicación a su valor base.
        */

        // Se coloca la opacidad de la aplicación en 100%.
        //</editor-fold>
        setOpacity((float)1.0);
    }//GEN-LAST:event_panPopupMessageMouseReleased

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
