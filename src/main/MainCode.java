package main;

import java.util.*;
import constructs.*;
import draw.Ellipse;

public class MainCode {

    public static EmptyUni uni = new EmptyUni();

    public static void main(String[] args) {
        uni.populate(800);
        SpaceShip obs = constructs.EmptyUni.observer;
        System.out.println(obs.xLoc + " " + obs.yLoc);
        Ellipse ell = new Ellipse(60.0, 600.0, 100.0, 100.0, "white");
        System.out.println(ell.getX() + " " + ell.getY());

    }
}
