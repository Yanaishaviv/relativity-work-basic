package constructs;

import draw.Ellipse;
import main.MainCode;
import java.util.concurrent.TimeUnit;

    /**
     * a class used to represent the spaceship observing the universe
     */
public class SpaceShip extends Planet {
    public double speed = 0.9; // speed in units of C (1 equals speed of light)
    public double direction = 0; // direction in radians

    public SpaceShip(double speed) {
        super();
        this.speed = speed;
        this.thisEll.setColor("yellow");
        this.thisEll.draw();
    }

    public SpaceShip(double xLoc, double yLoc, double speed) {
        super(xLoc, yLoc);
        this.speed = speed;
        this.thisEll.setColor("yellow");
        this.thisEll.draw();
    }

    /**
     * return the angle between the movement of the spaceship and the location of
     * the planet.
     *
     * @param pla the second planet
     * @return the angle in radians
     */
    public double angle(Planet pla) {
        double xDif = this.xLoc - pla.xLoc;
        double yDif = this.yLoc - pla.yLoc;
        double ang = Math.atan2(yDif, -xDif);
        ang = ang - this.direction;
        return ang;
    }

    public String toString() {
        String t = "Spaceship: {x location: " + this.xLoc + ", y location: " + this.yLoc
                + ", speed: " + this.speed + ", direction: " + this.direction + "}";
        return t;
    }

    public void move(double distance) {
        this.move(distance, this.direction, true);
    }

    public void addArrow() {
        double distance = this.speed * 50;
        double yDis = distance * Math.sin(direction);
        double xDis = distance * Math.cos(direction);
        new Ellipse(xDis + this.xLoc, -yDis + 
        this.yLoc, this.width/2, this.height/2, "red").draw();
    }

    public void removeArrow(){
        double distance = this.speed * 50;
        double yDis = distance * Math.sin(direction);
        double xDis = distance * Math.cos(direction);
        new Ellipse(xDis + this.xLoc, -yDis + this.yLoc, this.width/2, this.height/2, "black").draw();
    }

    public static void circle() {
        double dest = Math.PI * 2;
        double jumps = 52;
        EmptyUni univ = main.MainCode.uni;
        for (int i = 0; i < jumps; i++) {
            univ.resetPOV();
            univ.observer.direction = i * dest / jumps;
            univ.moveObsPOV();
            univ.observer.addArrow();
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            univ.observer.removeArrow();
        }
    }
}