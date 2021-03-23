package constructs;

import java.util.function.Function;

import draw.Canvas;
import draw.canvas;

public class EmptyUni {
    public final double Y_AXIS = Canvas.HEIGHT; // how long is the universe in the Y axis
    public final double X_AXIS = Canvas.WIDTH; // how long is the universe in the X axis
    public final int NUM_LINES = 5; // how many lines are in each side
    public final int NUM_ROWS = 10; // how many rows are in each side
    public final double STAR_RAD = 5; // what is the radius of each star
    public final double START_OF_RIGHT_SIDE = X_AXIS - 3 * STAR_RAD * (NUM_LINES);
    public SpaceShip observer; // the observer watching the universe
    public Planet[][] leftPlanets = new Planet[NUM_ROWS][NUM_LINES];
    public Planet[][] rightPlanets = new Planet[NUM_ROWS][NUM_LINES];

    public EmptyUni() {
        System.out.println("new universe created");
    }

    public boolean populate(double speed) {
        return fillRightSide() && fillLeftSide() && addSpaceship(speed);
    }

    public boolean fillRightSide() {
        try {
            for (int i = 0; i < rightPlanets.length; i++) {
                for (int j = 0; j < rightPlanets[i].length; j++) {
                    rightPlanets[i][j] = new Planet(10, 10, 3 * j * STAR_RAD + START_OF_RIGHT_SIDE, 3 * i * STAR_RAD);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean fillLeftSide() {
        try {
            for (int i = 0; i < leftPlanets.length; i++) {
                for (int j = 0; j < leftPlanets[i].length; j++) {
                    leftPlanets[i][j] = new Planet(2 * STAR_RAD, 2 * STAR_RAD, 3 * j * STAR_RAD, 3 * i * STAR_RAD);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void moveObsPOV(double distance) {
        int repeat = 10;
        for (int k = 0; k < repeat; k++) {
            for (int i = 0; i < NUM_ROWS; i++) {
                for (int j = 0; j < NUM_LINES; j++) {
                    rightPlanets[i][NUM_LINES-1-j].move(distance / repeat, observer.direction, false);
                    leftPlanets[i][j].move(distance / repeat, observer.direction, false);
                }
            }
        }
    }

    public boolean addSpaceship(double speed) {
        try {
            observer = new SpaceShip((START_OF_RIGHT_SIDE + 3 * STAR_RAD * (NUM_LINES - 1)) / 2, 450, speed);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
