
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
public class SelectOption extends javax.swing.JDialog {
    
    // Se declaran e inicializan las variables de soporte.
    int xx = 0, xy = 0; 
    
    // Se declaran e inicializan las variables.
    boolean opc = false;
    
    /**
     * Constructor SelectOption
     * @param parent JFrame padre.
     * @param modal Indica si el JDialog es modal o no.
     * @param type Que tipo de JDialog se muestra.
     * @param message Mensaje a mostrar.
     * @param opc1 Si la opción 1 tiene un valor distinto al default.
     * @param opc2 Si la opción 2 tiene un valor distinto al default.
     */
    public SelectOption(java.awt.Frame parent, boolean modal, int type,
            String message, String opc1, String opc2) {
                
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
        
        // Si la opción 1 es distinto a default.
        if(opc1 != null)
            btnOk.setText(opc1);
        
        // Si la opción 2 es distinto a default.
        if(opc2 != null)
            btnCancel.setText(opc2);
        
        // Colocar el mensaje pasado por parámetro en el JFrame
        lblMessage.setText(message);
                
        // Cambia el ícono del JFrame.
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("images/CDV-icon.png")).getImage());
        
        // Ubicar el JFrame en el centro de la pantalla.
        setLocationRelativeTo(null);
        
        // Hacer visible el JFrame
        this.setVisible(true);
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
        lblIcon = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        panOk = new javax.swing.JPanel();
        btnOk = new javax.swing.JButton();
        panCancel = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();

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

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblMessage.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(75, 0, 145));
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessage.setText("Contenido");

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
            .addGroup(panOkLayout.createSequentialGroup()
                .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panOkLayout.setVerticalGroup(
            panOkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panOkLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCancelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panPopupMessageLayout = new javax.swing.GroupLayout(panPopupMessage);
        panPopupMessage.setLayout(panPopupMessageLayout);
        panPopupMessageLayout.setHorizontalGroup(
            panPopupMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPopupMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPopupMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPopupMessageLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(panCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        panPopupMessageLayout.setVerticalGroup(
            panPopupMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPopupMessageLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panPopupMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
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

    /**
     * Retorna el valor de Opción.
     * @return 
     */
    public boolean getOpc(){
        return opc;
    }
    
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

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        opc = true;
        this.dispose();
    }//GEN-LAST:event_btnOkActionPerformed

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
        opc = false;
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancel;
    public javax.swing.JButton btnOk;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblMessage;
    public javax.swing.JPanel panCancel;
    public javax.swing.JPanel panOk;
    private javax.swing.JPanel panPopupMessage;
    // End of variables declaration//GEN-END:variables
}
