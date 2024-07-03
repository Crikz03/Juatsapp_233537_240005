/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author eljulls
 */
public class ScrollBar extends javax.swing.JScrollBar {

    public ScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(10,10));
        setBackground(new Color(255,255,255));
        setUnitIncrement(30);
    }
    
    
    
}
