package main;

import java.util.*;
import java.util.concurrent.TimeUnit;

import constructs.*;

public class MainCode {

    public static EmptyUni uni = new EmptyUni(); // the main universe where we calculate

    public static void main(String[] args) {
        uni.populate(0.9);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 50; i++) {
            SpaceShip.circle();
        }

    }
}
