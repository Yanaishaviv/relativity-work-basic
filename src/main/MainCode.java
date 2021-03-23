package main;

import java.util.*;
import constructs.*;
import draw.Ellipse;

public class MainCode {

    public static EmptyUni uni = new EmptyUni(); // the main universe where we calculate

    public static void main(String[] args) {
        uni.populate(800);
        SpaceShip obs = uni.observer;
        System.out.println(obs);
        obs.xLoc+=100;
        System.out.println(uni.observer);
    }
}
