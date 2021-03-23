package constructs;

public class EmptyUni {
    public final double yAxis = 600; // how long is the universe in the Y axis
    public final double xAxis = 1100; // how long is the universe in the X axis
    public final int numLines = 10; // how many lines are in each side
    public final int numRows = 30; // how many rows are in each side
    public final double starRad = 5; // what is the radius of each star
    public final double startOfRightSide = xAxis - 3 * starRad * (numLines - 1);
    public SpaceShip observer; // the observer watching the universe
    public Planet[][] leftPlanets = new Planet[numRows][numLines];
    public Planet[][] rightPlanets = new Planet[numRows][numLines];

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
                    rightPlanets[i][j] = new Planet(10, 10, 3 * j * starRad +
                     startOfRightSide, 3 * i * starRad);
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
                    leftPlanets[i][j] = new Planet(2 * starRad, 2 * starRad, 
                    3 * j * starRad, 3 * i * starRad);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void moveObsPOV(double distance){
        
    }

    public boolean addSpaceship(double speed) {
        try {
            observer = new SpaceShip((startOfRightSide + 3 * starRad *(numLines-1))/ 2, 450, speed);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
