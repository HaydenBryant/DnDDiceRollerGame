package com.spring.hockeystats;

import java.util.Random;

public class Die {
    private int sides;
    private int value;

    Random rand = new Random();

    public Die(int sides){
        this.sides = sides;
        roll(sides);
    }

    public void roll(int sides){
        value = rand.nextInt(sides) + 1;
    }

    public int getValue() {
        return value;
    }

    public int getSides() {
        return sides;
    }
}
