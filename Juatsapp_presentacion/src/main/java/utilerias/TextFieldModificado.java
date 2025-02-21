/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTextFieldUI;

/**
 *
 * @author eljulls
 */
public class TextFieldModificado extends JTextField {

    private int round = 10;
    private Color shadowColor = new Color(170, 170, 170);
    private Color backgroundColor = new Color(255, 255, 255);
    private BufferedImage imageShadow;
    private final Insets shadowSize = new Insets(2, 5, 8, 5);

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }

    public Color getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
        repaint();
    }

    public TextFieldModificado() {
        setUI(new TextUI());
        setOpaque(false);
        setForeground(new Color(80, 80, 80));
        setSelectedTextColor(new Color(255, 255, 255));
        setSelectionColor(new Color(133, 209, 255));
        setBorder(new EmptyBorder(10, 12, 15, 12));
        setBackground(new Color(255, 255, 255));
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double width = getWidth() - (shadowSize.left + shadowSize.right);
        double height = getHeight() - (shadowSize.top + shadowSize.bottom);
        double x = shadowSize.left;
        double y = shadowSize.top;
        //  Create Shadow Image
        g2.drawImage(imageShadow, 0, 0, null);
        //  Create Background Color
        g2.setColor(getBackground());
        Area area = new Area(new RoundRectangle2D.Double(x, y, width, height, round, round));
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        createImageShadow();
    }

    private void createImageShadow() {
        int height = getHeight();
        int width = getWidth();
        if (width > 0 && height > 0) {
            imageShadow = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = imageShadow.createGraphics();
            BufferedImage img = createShadow();
            if (img != null) {
                g2.drawImage(img, 0, 0, null);
            }
            g2.dispose();
        }
    }

    private BufferedImage createShadow() {
        int width = getWidth() - (shadowSize.left + shadowSize.right);
        int height = getHeight() - (shadowSize.top + shadowSize.bottom);
        if (width > 0 && height > 0) {
            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fill(new RoundRectangle2D.Double(0, 0, width, height, round, round));
            g2.dispose();
            return new ShadowRenderer(5, 0.3f, shadowColor, shadowColor).createShadow(img);
        } else {
            return null;
        }
    }

    private class TextUI extends BasicTextFieldUI {

        //  Override this method to remove background or not paint background
        @Override
        protected void paintBackground(Graphics grphcs) {

        }
    }

    class ShadowRenderer {

        private final int size;
        private final float opacity;
        private final Color color;
        private final Color shadowColor;

        public ShadowRenderer(int size, float opacity, Color color, Color shadowColor) {
            this.size = size;
            this.opacity = opacity;
            this.color = color;
            this.shadowColor = shadowColor;
        }

        public BufferedImage createShadow(BufferedImage img) {
            int shadowSize = size * 2;
            int srcWidth = img.getWidth();
            int srcHeight = img.getHeight();
            int dstWidth = srcWidth + shadowSize;
            int dstHeight = srcHeight + shadowSize;

            BufferedImage shadow = new BufferedImage(dstWidth, dstHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = shadow.createGraphics();
            g2.drawImage(img, size, size, null);

            g2.setComposite(AlphaComposite.SrcIn);
            g2.setColor(shadowColor);
            g2.fillRect(0, 0, dstWidth, dstHeight);

            g2.dispose();
            return shadow;
        }
    }

}
