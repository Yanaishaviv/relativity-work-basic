package constructs;

import draw.Canvas;

    /**
    * the universe which holds the planets
     */
    public class EmptyUni {
        public final double Y_AXIS = Canvas.HEIGHT; // how long is the universe in the Y axis
        public final double X_AXIS = Canvas.WIDTH; // how long is the universe in the X axis
        public final int NUM_LINES = 12; // how many lines are in each side
        public final int NUM_ROWS = 15; // how many rows are in each side
        public final double STAR_RAD = 10; // what is the radius of each star
        public final double SPACESHIP_LOCATION = NUM_ROWS * 2 * STAR_RAD;
        public final double START_OF_RIGHT_SIDE = X_AXIS - 4 * STAR_RAD * (NUM_LINES - 0.5);
        public SpaceShip observer; // the observer watching the universe
        public Planet[][] leftPlanets = new Planet[NUM_ROWS][NUM_LINES];
        public Planet[][] rightPlanets = new Planet[NUM_ROWS][NUM_LINES];

    public EmptyUni() {
        System.out.println("new universe created");
    }

    /**
     * populate the universe with the constructs needed and start the simulation. at first, look 
     * from an observer stationary to the stars.
     * @param speed the speed of the spaceship.
     * @return boolean indicating whether the simulation started successfully.
     */
    public boolean populate(double speed) {
        return fillRightSide() && fillLeftSide() && addSpaceship(speed);
    }

    /**
     * fill the right side of the universe with planets.
     * @return boolean indicating whether it worked.
     */
    public boolean fillRightSide() {
        try {
            for (int i = 0; i < rightPlanets.length; i++) {
                for (int j = 0; j < rightPlanets[i].length; j++) {
                    rightPlanets[i][j] = new Planet(STAR_RAD * 2, 4 * j * STAR_RAD + START_OF_RIGHT_SIDE,
                            4 * i * STAR_RAD);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * fill the left side of the universe with planets.
     * @return boolean indicating whether it worked.
     */
    public boolean fillLeftSide() {
        try {
            for (int i = 0; i < leftPlanets.length; i++) {
                for (int j = 0; j < leftPlanets[i].length; j++) {
                    leftPlanets[i][j] = new Planet(2 * STAR_RAD, 4 * j * STAR_RAD, 4 * i * STAR_RAD);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * resets the state of the universe to the initial state, with an observer stationary to it.
     */
    public void resetPOV() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_LINES; j++) {
                rightPlanets[i][j].moveTo(4 * j * STAR_RAD + START_OF_RIGHT_SIDE, 4 * i * STAR_RAD);
                rightPlanets[i][j].width = STAR_RAD * 2;
                rightPlanets[i][j].height = STAR_RAD * 2;
                leftPlanets[i][j].moveTo(4 * j * STAR_RAD, 4 * i * STAR_RAD);
                leftPlanets[i][j].width = STAR_RAD * 2;
                leftPlanets[i][j].height = STAR_RAD * 2;
            }
        }
    }

    /**
     * move the POV to the observer's frame of reference
     */
    public void moveObsPOV() {
        for (int i = 0; i < NUM_ROWS; i++) { // for each star
            for (int j = 0; j < NUM_LINES; j++) {
                rightPlanets[i][j].spaceShipPOV(observer); // move and compress to the right size
                leftPlanets[i][j].spaceShipPOV(observer);
            }
        } // i have 2 loops to make the drawing transition go faster, instead of calculating and 
        // drawing each iteration
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_LINES; j++) {
                rightPlanets[i][j].thisEll.draw(); // and then draw each planet
                leftPlanets[i][j].thisEll.draw();
            }
        }
    }

    /**
     * create an observer in the form of a spaceship with the speed "speed"
     * @param speed the spaceship's speed
     * @return boolean indicating whether the observer is created successfully.
     */
    public boolean addSpaceship(double speed) {
        try {
            observer = new SpaceShip((X_AXIS - STAR_RAD * 1.5) / 2, SPACESHIP_LOCATION, speed);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
