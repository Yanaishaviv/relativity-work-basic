// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package draw;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Canvas {
    public static Canvas canvasSingleton;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;
    public static int DefaultWaitTime = 30;
    private JFrame frame = new JFrame();
    public Canvas.CanvasPane canvas = new Canvas.CanvasPane();
    public Graphics2D graphic;
    private Color backgroundColour;
    private Image canvasImage;

    public static void setWaitFast() {
        DefaultWaitTime = 0;
    }

    public static void setWaitNormal() {
        DefaultWaitTime = 30;
    }

    public static void setWaitSlow() {
        DefaultWaitTime = 100;
    }

    public static Canvas getCanvas() {
        if (!Chk.chkDate()) {
            return null;
        } else {
            if (canvasSingleton == null) {
                canvasSingleton = new Canvas(Chk.chkVersion(), WIDTH, HEIGHT, Color.black);
            }

            canvasSingleton.setVisible(true);
            return canvasSingleton;
        }
    }

    private Canvas(String title, int width, int height, Color bgColour) {
        this.frame.setContentPane(this.canvas);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setLocationRelativeTo((Component) null);
        this.frame.setTitle(title);
        this.canvas.setPreferredSize(new Dimension(width, height));
        this.backgroundColour = bgColour;
        this.frame.pack();
        this.frame.toFront();
    }

    public void setVisible(boolean visible) {
        if (this.graphic == null) {
//            Dimension size = this.canvas.getSize();
            this.canvasImage = this.canvas.createImage(WIDTH, HEIGHT);
            this.graphic = (Graphics2D) this.canvasImage.getGraphics();
            this.graphic.setColor(this.backgroundColour);
            this.graphic.fillRect(0, 0, WIDTH, HEIGHT);
            this.graphic.setColor(Color.black);
        }

        this.frame.setVisible(visible);
    }

    public boolean isVisible() {
        return this.frame.isVisible();
    }

    public void draw(Shape shape) {
        this.graphic.draw(shape);
        this.canvas.repaint();
    }

    public void fill(Shape shape) {
        this.graphic.fill(shape);
        this.canvas.repaint();
        // this.wait(DefaultWaitTime);
    }

    public void erase(Shape shape) {
        Color original = this.graphic.getColor();
        this.graphic.setColor(this.backgroundColour);
        this.graphic.fill(shape);
        this.graphic.setColor(original);
        this.canvas.repaint();
    }

    public void eraseOutline(Shape shape) {
        Color original = this.graphic.getColor();
        this.graphic.setColor(this.backgroundColour);
        this.graphic.draw(shape);
        this.graphic.setColor(original);
        this.canvas.repaint();
    }

    public boolean drawImage(Image image, int x, int y) {
        System.out.println(image);
        boolean result = this.graphic.drawImage(image, x, y, (ImageObserver) null);
        System.out.println(result);
        this.canvas.repaint();
        return result;
    }

    public void drawString(String text, int x, int y) {
        this.graphic.drawString(text, x, y);
        this.canvas.repaint();
    }

    public void eraseString(String text, int x, int y) {
        Color original = this.graphic.getColor();
        this.graphic.setColor(this.backgroundColour);
        this.graphic.drawString(text, x, y);
        this.graphic.setColor(original);
        this.canvas.repaint();
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        this.graphic.drawLine(x1, y1, x2, y2);
        this.canvas.repaint();
        this.wait(DefaultWaitTime);
    }

    public void eraseLine(int x1, int y1, int x2, int y2) {
        // Color original = this.graphic.getColor();
        this.graphic.setColor(this.backgroundColour);
        this.graphic.drawLine(x1, y1, x2, y2);
        this.canvas.repaint();
    }

    public void setForegroundColour(String colourString) {
        if (colourString.equals("red")) {
            this.graphic.setColor(Color.red);
        } else if (colourString.equals("black")) {
            this.graphic.setColor(Color.black);
        } else if (colourString.equals("blue")) {
            this.graphic.setColor(Color.blue);
        } else if (colourString.equals("yellow")) {
            this.graphic.setColor(Color.yellow);
        } else if (colourString.equals("green")) {
            this.graphic.setColor(Color.green);
        } else if (colourString.equals("magenta")) {
            this.graphic.setColor(Color.magenta);
        } else if (colourString.equals("white")) {
            this.graphic.setColor(Color.white);
        } else if (colourString.equals("gray")) {
            this.graphic.setColor(Color.gray);
        } else if (colourString.equals("orange")) {
            this.graphic.setColor(Color.orange);
        } else {
            this.graphic.setColor(Color.black);
        }

    }

    public void setForegroundColour(Color newColour) {
        this.graphic.setColor(newColour);
    }

    public Color getForegroundColour() {
        return this.graphic.getColor();
    }

    public void setBackgroundColour(Color newColour) {
        this.backgroundColour = newColour;
        this.graphic.setBackground(newColour);
    }

    public Color getBackgroundColour() {
        return this.backgroundColour;
    }

    public void setFont(Font newFont) {
        this.graphic.setFont(newFont);
    }

    public Font getFont() {
        return this.graphic.getFont();
    }

    public void setSize(int width, int height) {
        this.canvas.setPreferredSize(new Dimension(width, height));
        this.frame.pack();
    }

    public Dimension getSize() {
        return this.canvas.getSize();
    }

    public void wait(int milliseconds) {
        try {
            Thread.sleep((long) milliseconds);
        } catch (Exception var3) {
        }

    }

    private class CanvasPane extends JPanel {
        private CanvasPane() {
        }

        public void paint(Graphics g) {
            g.drawImage(Canvas.this.canvasImage, 0, 0, (ImageObserver) null);
        }
    }
}
