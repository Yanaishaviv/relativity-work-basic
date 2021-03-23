package main;

import java.util.*;
import java.util.concurrent.TimeUnit;

import constructs.*;
import draw.Ellipse;

public class MainCode {

    public static EmptyUni uni = new EmptyUni(); // the main universe where we calculate

    public static void main(String[] args) {
        uni.populate(800);
        SpaceShip obs = uni.observer;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        obs.move(30);
        uni.moveObsPOV(50);
    }
}
