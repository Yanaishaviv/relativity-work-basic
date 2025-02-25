package constructs;

import java.util.concurrent.TimeUnit;
import draw.*;
import main.*;

public class Planet {
    public double width = MainCode.uni.STAR_RAD;
    public double height = MainCode.uni.STAR_RAD;
    public double xLoc = 0;
    public double yLoc = 0;
    public Ellipse thisEll;

    public Planet(double radius, double xLoc, double yLoc) {
        this.width = radius;
        this.height = radius;
        this.yLoc = yLoc;
        this.xLoc = xLoc;
        this.thisEll = new Ellipse(this.xLoc, this.yLoc, this.width, this.height, "white");
    }

    public Planet(double xLoc, double yLoc) {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.thisEll = new Ellipse(this.xLoc, this.yLoc, this.width, this.height, "white");
    }

    public Planet() {
        this.thisEll = new Ellipse(this.xLoc, this.yLoc, this.width, this.height, "white");
    }

    public double distance(Planet sec) {
        double x = this.xLoc - sec.xLoc;
        double y = this.yLoc - sec.yLoc;
        x *= x;
        y *= y;
        return Math.sqrt(x + y);
    }

    /**
     * make sure the planet is ready for drawing
     */
    public void prepare() {
        this.thisEll.erase();
        this.thisEll.moveTo(this.xLoc, this.yLoc);
        this.thisEll.setDiaY(this.height);
        this.thisEll.setDiaX(this.width);
    }

    /**
     * move from the planet's frame of reference to the Spaceship's frame of
     * reference.
     * 
     * @param observer the spaceship we are using for FOR
     */
    public void spaceShipPOV(SpaceShip observer) {
        double planetDistance = this.distance(observer); 
        double alpha = observer.angle(this); // get the angle between the planet 
        // and the observer's velocity
        double cosFactor = Math.cos(alpha);
        planetDistance = planetDistance * cosFactor; // get the distance in the velocity's 
        // direction
        double speed = observer.speed; 
        double lFactor = Equations.lorentzFactor(speed); // calculate the lorentz factor 
        // for the spaceship's speed
        double spaceshipDistance = planetDistance / lFactor; // get the distance in the 
        // spaceship's frame of reference
        double yVelocity = observer.speed * Math.sin(observer.direction);
        double xVelocity = observer.speed * Math.cos(observer.direction);
        double xChange = 1 / Equations.lorentzFactor(xVelocity);
        double yChange = 1 / Equations.lorentzFactor(yVelocity);
        this.compressX(xChange); // these compression functions were 
        // built to handle these parameter in these ways
        this.compressY(yChange); 
        // the function move was built to handle this direction correctly if the wait flag 
        // is turned off, although this isn't the natural direction given to it
        this.move(planetDistance - spaceshipDistance, observer.direction, false); 
    }

    /**
     * move the planet a certain distance at a certain direction. can be used
     * differently for planets and spaceships by using the wait parameter.
     * 
     * @param distance  the distance to cover
     * @param direction the direction that the planet needs to move. if it isn't a
     *                  spaceship, the direction will be reversed
     * @param wait      if wait is turned on, the movement will be smooth, and in
     *                  the direction given.
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

    public void moveTo(double x, double y) {
        this.prepare();
        this.xLoc = x;
        this.yLoc = y;
    }

    /**
     * compress the planet on the y axis
     */
    public void compressY(double yChange) {
        this.height *= yChange;
    }

    /**
     * compress the planet on the x axis
     */
    public void compressX(double xChange) {
        this.width *= xChange;
    }

}