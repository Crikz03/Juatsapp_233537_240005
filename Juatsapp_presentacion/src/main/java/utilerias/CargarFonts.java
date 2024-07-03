/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author eljulls
 */
public class CargarFonts {
    public static Font cargarFonts(String ruta) {
        try {
            Font fuente = Font.createFont(Font.TRUETYPE_FONT, new File(ruta));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fuente);
            return fuente;
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

