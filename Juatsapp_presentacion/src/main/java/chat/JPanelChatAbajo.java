/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package chat;

/**
 *
 * @author eljulls
 */
public class JPanelChatAbajo extends javax.swing.JPanel {

    /**
     * Creates new form JPanelChatAbajo
     */
    public JPanelChatAbajo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuButton2 = new utilerias.MenuButton();
        textFieldModificado1 = new utilerias.TextFieldModificado();
        menuButton1 = new utilerias.MenuButton();

        menuButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/send.png"))); // NOI18N
        menuButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/sendSelected.png"))); // NOI18N

        textFieldModificado1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        textFieldModificado1.setShadowColor(new java.awt.Color(79, 148, 90));
        textFieldModificado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldModificado1ActionPerformed(evt);
            }
        });

        menuButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attach.png"))); // NOI18N
        menuButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/attachSeleccted.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(menuButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldModificado1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldModificado1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(menuButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldModificado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldModificado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldModificado1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilerias.MenuButton menuButton1;
    private utilerias.MenuButton menuButton2;
    private utilerias.TextFieldModificado textFieldModificado1;
    // End of variables declaration//GEN-END:variables
}
