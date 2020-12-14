//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package draw;
import java.awt.Polygon;

public class Triangle {
    int width;
    int height;
    int xPosition;
    int yPosition;
    String color;

    public Triangle(int xPosition, int yPosition, int width, int height, String color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.color = color;
        this.draw();
    }

    public void moveTo(int newX, int newY) {
        this.xPosition = newX;
        this.yPosition = newY;
    }

    public void move(int deltaX, int deltaY) {
        this.xPosition += deltaX;
        this.yPosition += deltaY;
    }

    public void changeSizeTo(int newWidth, int newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    public void changeSize(int deltaSize) {
        this.width *= deltaSize;
        this.height *= deltaSize;
    }

    public void changeColor(String newColor) {
        this.color = newColor;
    }

    public void draw() {
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(this.color);
        int[] xpoints = new int[] { this.xPosition, this.xPosition + this.width / 2, this.xPosition - this.width / 2 };
        int[] ypoints = new int[] { this.yPosition, this.yPosition + this.height, this.yPosition + this.height };
        canvas.fill(new Polygon(xpoints, ypoints, 3));
        // canvas.wait(Canvas.DefaultWaitTime);
    }

    public void erase() {
        Canvas canvas = Canvas.getCanvas();
        int[] xpoints = new int[] { this.xPosition, this.xPosition + this.width / 2, this.xPosition - this.width / 2 };
        int[] ypoints = new int[] { this.yPosition, this.yPosition + this.height, this.yPosition + this.height };
        canvas.erase(new Polygon(xpoints, ypoints, 3));
    }

    public static void main(String[] args) {
        System.out.println("this is working");
    }
}
