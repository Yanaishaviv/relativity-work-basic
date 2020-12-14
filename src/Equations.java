public class Equations {

    public static double lorentzFactor(double speed) {
        double sped = Math.pow(speed, 2);
        double factor = 1 / Math.sqrt(1 - sped);
        return factor;
    }

    public static void main(String[] args) {
        System.out.println(lorentzFactor(0.8));
        System.out.println(1/0.6);
    }
}
