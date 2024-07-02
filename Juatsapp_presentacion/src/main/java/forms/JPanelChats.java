/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package forms;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author eljulls
 */
public class JPanelChats extends javax.swing.JPanel {

    private Image imagenDeFondo;

    public JPanelChats() {
          initComponents();
        cargarImagenDeFondo();
    }

    private void cargarImagenDeFondo() {
        try {
            //imagenDeFondo = new ImageIcon(getClass().getResource("/fondo.jpg")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenDeFondo != null) {
            g.drawImage(imagenDeFondo, 0, 0, getWidth(), getHeight(), this);
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

        jPanelChatCuerpo1 = new chat.JPanelChatCuerpo();
        jPanelChatArriba1 = new chat.JPanelChatArriba();
        toggleButton = new javax.swing.JButton();
        jPanelChatAbajo1 = new chat.JPanelChatAbajo();

        setBackground(new java.awt.Color(153, 255, 153));

        jPanelChatCuerpo1.setBackground(new java.awt.Color(255, 255, 255));

        toggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Back.png"))); // NOI18N
        toggleButton.setBorderPainted(false);
        toggleButton.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanelChatArriba1Layout = new javax.swing.GroupLayout(jPanelChatArriba1);
        jPanelChatArriba1.setLayout(jPanelChatArriba1Layout);
        jPanelChatArriba1Layout.setHorizontalGroup(
            jPanelChatArriba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChatArriba1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(toggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanelChatArriba1Layout.setVerticalGroup(
            jPanelChatArriba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChatArriba1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(toggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(748, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelChatArriba1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelChatAbajo1, javax.swing.GroupLayout.DEFAULT_SIZE, 1131, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelChatCuerpo1, javax.swing.GroupLayout.DEFAULT_SIZE, 1131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelChatArriba1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelChatAbajo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(97, 97, 97)
                    .addComponent(jPanelChatCuerpo1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(90, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

  public JButton getToggleButton() {
        return toggleButton;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chat.JPanelChatAbajo jPanelChatAbajo1;
    private chat.JPanelChatArriba jPanelChatArriba1;
    private chat.JPanelChatCuerpo jPanelChatCuerpo1;
    private javax.swing.JButton toggleButton;
    // End of variables declaration//GEN-END:variables
}
