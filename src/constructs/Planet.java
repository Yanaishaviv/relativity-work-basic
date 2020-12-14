package constructs;

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

    public Planet(double xLoc, double yLoc){
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



}