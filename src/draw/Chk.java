//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package draw;
import java.util.Date;

public class Chk {
    public Chk() {
    }

    public static boolean chkDate() {
        return (new Date()).before(new Date(2019, 1, 10));
    }

    public static String chkVersion() {
        return "canvasML V1.12 2018-09";
    }

    public static String chkValid() {
        return "valid until 10/1/2019";
    }
}
