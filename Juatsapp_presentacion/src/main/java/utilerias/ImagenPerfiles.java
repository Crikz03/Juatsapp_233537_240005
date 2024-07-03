/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author eljulls
 */
public class ImagenPerfiles extends JComponent {

    public Icon getImagen() {
        return imagen;
    }

    public void setImagen(Icon imagen) {
        this.imagen = imagen;
    }

    public int getTamanoBorde() {
        return tamanoBorde;
    }

    public void setTamanoBorde(int tamano) {
        this.tamanoBorde = tamano;
    }

    public Color getColorBorde() {
        return colorBorde;
    }

    public void setColorBorde(Color borderColor) {
        this.colorBorde = colorBorde;
    }

    private Icon imagen;
    private int tamanoBorde = 0;
    private Color colorBorde = new Color(60, 60, 60);

    @Override
    public void paint(Graphics g) {
        if (imagen != null) {
            int ancho = imagen.getIconWidth();
            int altura = imagen.getIconHeight();
            int diametro = Math.min(ancho, altura);
            BufferedImage mascara = new BufferedImage(ancho, altura, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = mascara.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);    //  for image smooth
            g2d.fillOval(0, 0, diametro - 1, diametro - 1);
            g2d.dispose();
            BufferedImage mascarado = new BufferedImage(diametro, diametro, BufferedImage.TYPE_INT_ARGB);
            g2d = mascarado.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);    //  for image smooth
            int x = (diametro - ancho) / 2;
            int y = (diametro - altura) / 2;
            g2d.drawImage(toImage(imagen), x, y, null);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
            g2d.drawImage(mascara, 0, 0, null);
            g2d.dispose();
            Icon icon = new ImageIcon(mascarado);
            Rectangle size = getAutoSize(icon);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(toImage(icon), size.getLocation().x, size.getLocation().y, size.getSize().width, size.getSize().height, null);
//            if (tamanoBorde > 0) {
//                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//                g2.setColor(colorBorde);
//                g2.setStroke(new BasicStroke(tamanoBorde));
//                g2.drawOval(size.x = (tamanoBorde / 2), size.y + (tamanoBorde / 2), size.width - tamanoBorde, size.height - tamanoBorde);
//            }
        }
        super.paint(g);
    }

    private Rectangle getAutoSize(Icon image) {
        int anchura = getWidth();
        int altura = getHeight();
        int imagenAnchura = image.getIconWidth();
        int imagenAltura = image.getIconHeight();
        double xEscala = (double) anchura / imagenAnchura;
        double yEscala = (double) altura / imagenAltura;
        double escala = Math.max(xEscala, yEscala);
        int iconoAnchura = (int) (escala * imagenAnchura);
        int iconoAltura = (int) (escala * imagenAltura);
        int x = (anchura - iconoAnchura) / 2;
        int y = (altura - iconoAltura) / 2;
        return new Rectangle(new Point(x, y), new Dimension(iconoAnchura, iconoAltura));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }

}