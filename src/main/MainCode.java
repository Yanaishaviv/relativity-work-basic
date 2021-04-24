package main;

import java.util.concurrent.TimeUnit;

import constructs.*;

public class MainCode {

    public static EmptyUni uni = new EmptyUni(); // the main universe where we calculate

    /**
     * the code that runs the whole program. the main code bit to run
     */
    public static void main(String[] args) {
        try { // Exception handling
            uni.populate(0); // create a new universe, with the observer initially not moving (speed = 0)
            TimeUnit.SECONDS.sleep(10); // wait
            uni.observer.direction = 0; // set the observer's direction to right
            uni.observer.speed = 0.9; // and set the observer's speed to 0.9C
            uni.moveObsPOV(); // move to the POV of the observer's frame of reference
            uni.observer.addArrow();
            TimeUnit.SECONDS.sleep(10); // wait
            uni.observer.removeArrow();
            uni.resetPOV(); // reset the universe
            uni.observer.direction = Math.PI/2; // set the observer's direction to up
            uni.moveObsPOV(); // move to the POV of the observer's frame of reference
            uni.observer.addArrow();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
