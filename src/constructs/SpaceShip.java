package constructs;


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
        this.move(distance, this.direction, true);
    }

}