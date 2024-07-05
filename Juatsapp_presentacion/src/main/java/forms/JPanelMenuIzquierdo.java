/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package forms;

import dtos.UsuarioDTO;
import excepciones.NegocioException;
import interfaces.IConsultaUsuarioPorTelefonoBO;
import java.awt.Dimension;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.miginfocom.swing.MigLayout;
import utilerias.ScrollBar;

/**
 *
 * @author eljulls
 */
public class JPanelMenuIzquierdo extends javax.swing.JPanel {

    UsuarioDTO usuarioActual;
    IConsultaUsuarioPorTelefonoBO consultaUsuarioPorTelefonoBO;

    public JPanelMenuIzquierdo(UsuarioDTO usarioActual, IConsultaUsuarioPorTelefonoBO consultaUsuarioPorTelefonoBO) {
        initComponents();
        listaMenu.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        this.usuarioActual = usarioActual;
        this.consultaUsuarioPorTelefonoBO=consultaUsuarioPorTelefonoBO;
        mostrarChats();
    }

    private void mostrarChats() {
        listaMenu.removeAll();
        try {
            for (String telefono : usuarioActual.getChats()) {

                UsuarioDTO contacto = (UsuarioDTO) consultaUsuarioPorTelefonoBO.consultaPorTelefono(telefono);
                listaMenu.add(new JPanelContacto(contacto), "wrap");
            }

            listaMenu.repaint();
            listaMenu.revalidate();
        } catch (NegocioException ex) {
            Logger.getLogger(JPanelMenuIzquierdo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void IniciarChats() {
        listaMenu.removeAll();
        try {
            List<String> contactos = new ArrayList<>();
            contactos.addAll(usuarioActual.getContactos());
            contactos.removeAll(usuarioActual.getChats());

            for (String telefono : contactos) {

                UsuarioDTO contacto = (UsuarioDTO) consultaUsuarioPorTelefonoBO.consultaPorTelefono(telefono);
                listaMenu.add(new JPanelContacto(contacto), "wrap");
            }
            listaMenu.repaint();
            listaMenu.revalidate();
        } catch (NegocioException ex) {
            Logger.getLogger(JPanelMenuIzquierdo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        btnChats = new utilerias.MenuButton();
        btnIniciar = new utilerias.MenuButton();
        menuButton5 = new utilerias.MenuButton();
        menuButton6 = new utilerias.MenuButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaMenu = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(246, 246, 246));
        setForeground(new java.awt.Color(239, 239, 244));

        jLayeredPane1.setBackground(new java.awt.Color(246, 246, 246));
        jLayeredPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        btnChats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chats.png"))); // NOI18N
        btnChats.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/chatSeleccionado.png"))); // NOI18N
        btnChats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatsActionPerformed(evt);
            }
        });

        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Edit.png"))); // NOI18N
        btnIniciar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iniciarSeleccionado.png"))); // NOI18N
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        menuButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Add.png"))); // NOI18N
        menuButton5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/nuevoSeleccionado.png"))); // NOI18N
        menuButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton5ActionPerformed(evt);
            }
        });

        menuButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/config.png"))); // NOI18N
        menuButton6.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ajustesSelccionado.png"))); // NOI18N

        jLayeredPane1.setLayer(btnChats, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnIniciar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(menuButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(menuButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btnChats, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnChats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(menuButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(menuButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listaMenu.setBackground(new java.awt.Color(255, 255, 255));
        listaMenu.setOpaque(true);

        javax.swing.GroupLayout listaMenuLayout = new javax.swing.GroupLayout(listaMenu);
        listaMenu.setLayout(listaMenuLayout);
        listaMenuLayout.setHorizontalGroup(
            listaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );
        listaMenuLayout.setVerticalGroup(
            listaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(listaMenu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        this.IniciarChats();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void menuButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuButton5ActionPerformed

    private void btnChatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatsActionPerformed
        this.mostrarChats();
    }//GEN-LAST:event_btnChatsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilerias.MenuButton btnChats;
    private utilerias.MenuButton btnIniciar;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane listaMenu;
    private utilerias.MenuButton menuButton5;
    private utilerias.MenuButton menuButton6;
    // End of variables declaration//GEN-END:variables
}
