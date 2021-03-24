package constructs;

import java.util.concurrent.TimeUnit;
import draw.*;
import main.Equations;
public class Planet {
    public double radius = 5;
    public double heightDivWidth = 1;
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

    public void prepare() {
        this.thisEll.erase();
        this.thisEll.moveTo(this.xLoc, this.yLoc);
        this.thisEll.setDiaY(this.heightDivWidth * this.radius);
        // this.thisEll.draw();
    }

    /**
     * move from the planet's frame of reference to the Spaceship's frame of reference.
     * @param observer the spaceship we are using for FOR
     */
    public void spaceShipPOV(SpaceShip observer){
        double planetDistance = this.distance(observer);
        planetDistance = planetDistance*Math.cos(observer.angle(this));
        double speed = observer.speed;
        double lFactor = Equations.lorentzFactor(speed);
        double spaceshipDistance = planetDistance/lFactor;
        this.compressY(1/lFactor);
        this.move(planetDistance - spaceshipDistance, observer.direction, false);
    }

    /**
     * move the planet a certain distance at a certain direction. 
     * can be used differently for planets and spaceships by using the wait parameter.
     * @param distance the distance to cover 
     * @param direction the direction that the planet needs to move. 
     * if it isn't a spaceship, the direction will be reversed
     * @param wait if wait is turned on, the movement will be smooth, and in the direction given.
     */
    public void move(double distance, double direction, boolean wait) {
        double yDis = distance * Math.sin(direction);
        double xDis = distance * Math.cos(direction);
        if (!wait) {
            xLoc -= xDis;
            yLoc += yDis;
            this.prepare();
            return;
        }
        int loopEnd = 100;
        for (int i = 0; i < loopEnd; i++) {
            xLoc += xDis / loopEnd;
            yLoc -= yDis / loopEnd; // this is a minus sign because Y is upside down
            this.prepare();
            this.thisEll.draw();
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void compressY(double yChange){
        this.heightDivWidth *= yChange;
    }

}