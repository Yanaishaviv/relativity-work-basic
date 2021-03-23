package constructs;

import java.util.concurrent.TimeUnit;

public class SpaceShip extends Planet {
    public double speed = 0;
    public double direction = Math.PI/2;

    public SpaceShip(double speed) {
        super();
        this.speed = speed;
        this.thisEll.setColor("yellow");
        this.thisEll.draw();
    }

    public SpaceShip(double xLoc, double yLoc, double speed) {
        super(xLoc, yLoc);
        System.out.println(xLoc);
        this.speed = speed;
        this.thisEll.setColor("yellow");
        this.thisEll.draw();
    }

    /**
     * return the angle between the movement of the spaceship and the location of
     * the planet.
     *
     * @param pla the second planet
     * @return the angle in degrees
     */
    public double angle(Planet pla) {
        double xDif = this.xLoc - pla.xLoc;
        double yDif = this.yLoc - pla.yLoc;
        double ang = Math.atan2(yDif, xDif);
        ang = Math.toDegrees(ang);
        ang = this.direction - ang;
        return ang;
    }

    public String toString() {
        String t = "Spaceship: {x location: " + this.xLoc + ", y location: " + this.yLoc + ", mass: " + this.mass
                + ", speed: " + this.speed + ", direction: " + this.direction + "}";
        return t;
    }

    public void move(double distance){
        double yDis = distance * Math.sin(this.direction);
        double xDis = distance * Math.cos(this.direction);
        System.out.println("x " + xLoc + " y " + yLoc);
        int loopEnd = 100;
        for (int i = 0; i < loopEnd; i++){
            System.out.println("x " + xLoc + "y " + yLoc);
            xLoc += xDis/loopEnd;
            yLoc -= yDis/loopEnd;
            this.draw();
            try{
            TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        
    }

}