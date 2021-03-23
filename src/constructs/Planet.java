package constructs;

import java.util.concurrent.TimeUnit;
import draw.*;

public class Planet {
    public double radius = 5;
    public double mass = 10;
    public double xLoc = 0;
    public double yLoc = 0;
    public Ellipse thisEll;

    public Planet(double radius, double mass, double xLoc, double yLoc) {
        this.radius = radius;
        this.mass = mass;
        this.yLoc = yLoc;
        this.xLoc = xLoc;
        this.thisEll = new Ellipse(this.xLoc, this.yLoc, this.radius, this.radius, "white");
    }

    public Planet(double xLoc, double yLoc) {
        this.xLoc = xLoc;
        System.out.println(xLoc);
        this.yLoc = yLoc;
        this.thisEll = new Ellipse(this.xLoc, this.yLoc, this.radius, this.radius, "white");
    }

    public Planet() {
        this.thisEll = new Ellipse(this.xLoc, this.yLoc, this.radius, this.radius, "white");
    }

    public double distance(Planet sec) {
        double x = this.xLoc - sec.xLoc;
        double y = this.yLoc - sec.yLoc;
        x *= x;
        y *= y;
        return Math.sqrt(x + y);
    }

    public void draw() {
        this.thisEll.erase();
        this.thisEll.moveTo(this.xLoc, this.yLoc);
        this.thisEll.draw();
    }

    public void move(double distance, double direction, boolean wait) {
        double yDis = distance * Math.sin(direction);
        double xDis = distance * Math.cos(direction);
        if (!wait) {
            xLoc += xDis;
            yLoc += yDis;
            this.draw();
            return;
        }
        int loopEnd = 100;
        for (int i = 0; i < loopEnd; i++) {
            xLoc += xDis / loopEnd;
            yLoc -= yDis / loopEnd; // this is a minus sign because Y is upside down
            this.draw();
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}