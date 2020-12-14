//
// Decompiled by Procyon v0.5.36
//
package draw;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Ellipse
{
    double diameterX;
    double diameterY;
    double xPosition;
    double yPosition;
    String color;

    public Ellipse(final double xPosition, final double yPosition, final double diameterX, final double diameterY, final String color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.diameterX = diameterX;
        this.diameterY = diameterY;
        this.color = color;
        this.draw();
        final Canvas canvas = Canvas.getCanvas();
    }

    public Ellipse(final int xPosition, final int yPosition, final int diameterX, final int diameterY, final String color, final boolean draw) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.diameterX = diameterX;
        this.diameterY = diameterY;
        this.color = color;
        if (draw) {
            this.draw();
        }
    }

    public void moveTo(final double newX, final double newY) {
        this.xPosition = newX;
        this.yPosition = newY;
    }

    public void move(final double deltaX, final double deltaY) {
        this.xPosition += deltaX;
        this.yPosition += deltaY;
    }

    public void changeSizeTo(final double newDiameterX, final double newDiameterY) {
        this.diameterX = newDiameterX;
        this.diameterY = newDiameterY;
    }

    public void changeSize(final double deltaDiameter) {
        this.diameterX *= deltaDiameter;
        this.diameterY *= deltaDiameter;
    }

    public void changeColor(final String newColor) {
        this.color = newColor;
    }

    public void draw() {
        final Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(this.color);
        canvas.fill(new Ellipse2D.Double(this.xPosition, this.yPosition, this.diameterX, this.diameterY));
    }

    public void erase() {
        final Canvas canvas = Canvas.getCanvas();
        canvas.erase(new Ellipse2D.Double(this.xPosition, this.yPosition, this.diameterX, this.diameterY));
    }

    public double getX() {
        return this.xPosition;
    }

    public double getY() {
        return this.yPosition;
    }

    public double getDiaX() {
        return this.diameterX;
    }

    public double getDiaY() {
        return this.diameterY;
    }

    public String getCol() {
        return this.color;
    }

    @Override
    public String toString() {
        return String.valueOf(this.xPosition) + " " + this.yPosition + " " + this.diameterX + " " + this.diameterY + " " + this.color;
    }

    public void setX(final int x) {
        this.xPosition = x;
    }

    public void setY(final int y) {
        this.yPosition = y;
    }

    public void setDiaX(final int x) {
        this.diameterX = x;
    }

    public void setDiaY(final int y) {
        this.diameterY = y;
    }

    public void setCol(final String col) {
        this.color = col;
    }
}
