/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import dtos.UsuarioDTO;
import excepciones.NegocioException;
import interfaces.IiniciaSesionBO;
import negocio.IniciaSesionBO;
import utilerias.Dialogos;
import utilidades.Encriptador;

/**
 *
 * @author eljulls
 */
public class FrmLogin extends javax.swing.JFrame {

    private IiniciaSesionBO inicio;

    /**
     * Creates new form FrmLogin
     */
    public FrmLogin() {
        initComponents();
        this.inicio = new IniciaSesionBO();
        this.setLocationRelativeTo(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();
        txtNumero = new javax.swing.JTextField();
        bRegistrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MacBook Air - 1.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 145, 26));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        jLabel3.setText("Log in");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 200, 90));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 260, 110, 150));

        jButton1.setBackground(new java.awt.Color(0, 145, 26));
        jButton1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 310, 40));

        txtContraseña.setForeground(new java.awt.Color(153, 153, 153));
        txtContraseña.setText("Contraseña");
        txtContraseña.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(102, 102, 102), java.awt.Color.white));
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        jPanel2.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 362, 370, 40));

        txtNumero.setForeground(new java.awt.Color(153, 153, 153));
        txtNumero.setText("Numero");
        txtNumero.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(51, 51, 51), java.awt.Color.white));
        jPanel2.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 370, 40));

        bRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/¿No tienes una cuenta_ Registrate aqui.png"))); // NOI18N
        bRegistrar.setBorder(null);
        bRegistrar.setBorderPainted(false);
        bRegistrar.setContentAreaFilled(false);
        bRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bRegistrarMouseClicked(evt);
            }
        });
        bRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(bRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 510, -1, 30));

        jLabel4.setText("jLabel4");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MacBook Air - 1.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 1000, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.intentarIniciarSesion();
        } catch (NegocioException ex) {
            Dialogos.mostrarMensajeError(this, "Error al iniciar sesion!, intentalo denuevo");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bRegistrarActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void bRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRegistrarMouseClicked
        new FrmRegistrar().setVisible(true);
        dispose();
    }//GEN-LAST:event_bRegistrarMouseClicked

    private void intentarIniciarSesion() throws NegocioException {

        UsuarioDTO usuario;

        usuario = inicio.iniciarSesion(txtNumero.getText());

        if (usuario == null) {
            this.mostrarErrorInicioSesion();
            return;
        }

        String intentoPassword = new String(txtContraseña.getPassword());
        boolean isPasswordValida
                = Encriptador.verificarPasswordConHash(intentoPassword, usuario.getContrasena());

        if (!isPasswordValida) {
            this.mostrarErrorInicioSesion();
            return;
        }

        this.iniciarSesion(usuario);
    }

    private boolean validarCampos() {

        if (txtNumero.getText().isBlank()) {
            return false;
        }

        if (new String(txtContraseña.getPassword()).isBlank()) {
            return false;
        }

        return true;

    }

    private void mostrarErrorInicioSesion() {
        Dialogos.mostrarMensajeError(rootPane, "Credenciales no validas.");
    }

    private void iniciarSesion(UsuarioDTO usuario) {
        new FrmMain().setVisible(true);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRegistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
