package constructs;

public class EmptyUni {
    public final double yAxis = 700;
    public final double xAxis = 900;
    public static SpaceShip observer;
    public static Planet[][] leftPlanets = new Planet[30][10];
    public static Planet[][] rightPlanets = new Planet[30][10];

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
                    rightPlanets[i][j] = new Planet(10, 10, j * 15 + 945, i * 15);
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
                    leftPlanets[i][j] = new Planet(10, 10, j * 15, i * 15);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addSpaceship(double speed) {
        try {
            observer = new SpaceShip( (945+150)/2,450, speed);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
