import controllers.ControllerLogin;
/**
 *
 * @author Gustavo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*<editor-fold defaultstate="collapsed" desc=" Instrucciones para la apariencia ">
        
        /*
         * =====================================================================
         *  1. Estilo Windows:
         *      1.1. Abrir el <editor-fold> de 'Look and feel...'
         *      1.2. En la línea 'if ("Nimbus".equals(info.getName())) {' sus-
         *           tituir 'Nimbus' por 'Windows'.
         *  2. Eliminar bordes y barra superior:
         *      2.1. Generar una archivo de tipo JFrame.
         *      2.2. Seleccionar el apartado visual 'Design'.
         *      2.3. Dirigirse al apartado de 'Properties' del JFrame.
         *      2.4. Seleccionar la opción 'Undercorated'.
         *      2.5. Deseleccionar la opción 'Resizable'.
         *  3. Guardar los cambios realizados.
         * =====================================================================
         */   
        
        //</editor-fold>
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
                
        // Se declara el controlador principal que dará ejecución a la aplicación.
        ControllerLogin ctrlLogin = new ControllerLogin();
    }
    
}
