/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author eljulls
 */
public class JPanelHome extends javax.swing.JPanel {

    private JPanelMenuDerecho panelDerecho;
    private JPanelChats panelChats;
    Icon iconoSiguiente;
    Icon iconoQuitar;

    public JPanelHome() {
        initComponents();
        MetodosIniciales();
    }

    public void MetodosIniciales() {
        setLayout(new BorderLayout());
        JPanelMenuIzquierdo panelIzquierdo = new JPanelMenuIzquierdo();
        panelIzquierdo.setPreferredSize(new Dimension(270, Integer.MAX_VALUE));
        this.add(panelIzquierdo, BorderLayout.LINE_START);
        panelChats = new JPanelChats();
        this.add(panelChats, BorderLayout.CENTER);
        panelDerecho = new JPanelMenuDerecho();
        panelDerecho.setPreferredSize(new Dimension(250, Integer.MAX_VALUE)); // Set the preferred size
        iconoQuitar = panelChats.getToggleButton().getIcon();
        iconoSiguiente = new ImageIcon(getClass().getResource("/Next.png"));

        // Add action listener to the toggle button
        JButton toggleButton = panelChats.getToggleButton();
        toggleButton.addActionListener(e -> togglePanelDerecho());
    }

    private void togglePanelDerecho() {
        if (panelDerecho.getParent() == null) {
            this.add(panelDerecho, BorderLayout.LINE_END);
            panelChats.getToggleButton().setIcon(iconoSiguiente);
        } else {
            remove(panelDerecho);
            panelChats.getToggleButton().setIcon(iconoQuitar);
        }
        revalidate();
        repaint();
    }

//    public JPanelHome() {
//        initComponents();
//        MetodosIniciales();
//    }
//
//    public void MetodosIniciales() {
//        setLayout(new MigLayout("debug, fillx, filly", "0[200!]5[fill, 100%]5[200!]0", ""));
//        this.add(new JPanelMenuIzquierdo());
//        panelChats = new JPanelChats();
//        this.add(panelChats);
//        panelDerecho = new JPanelMenuDerecho();
//        this.add(panelDerecho);
//
//        // Add action listener to the toggle button
//        JButton toggleButton = panelChats.getToggleButton();
//        toggleButton.addActionListener(e -> togglePanelDerecho());
//    }
//
//
//
//    private void togglePanelDerecho() {
//        if (panelDerecho.getParent() != null) {
//            remove(panelDerecho);
//            setLayout(new MigLayout("debug, fillx, filly", "0[200!]5[fill, 100%]0", ""));
//        } else {
//            add(panelDerecho, "growx");
//            setLayout(new MigLayout("debug, fillx, filly", "0[200!]5[fill, 100%]5[200!]0", ""));
//        }
//        revalidate();
//        repaint();
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
