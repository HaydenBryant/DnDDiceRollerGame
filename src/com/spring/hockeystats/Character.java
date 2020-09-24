package com.spring.hockeystats;

import java.util.ArrayList;

public class Character {

    private int ac;
    private int hp;
    private ArrayList<Die> hitDie;

    public Character(int ac, int hp){
        this.ac = ac;
        this.hp = hp;
    }

    public Character(int ac, int hp, int numHitDie, int sidesOfHitDie){
        this.ac = ac;
        this.hp = hp;
        for (int dieCount = 0; dieCount < numHitDie; dieCount++){
            hitDie.add(new Die(sidesOfHitDie));
        }
    }

    public int getAc() {
        return ac;
    }

    public int getHp() {
        return hp;
    }

    public int attack(){
        int damage = 0;
        for(Die hitDice : hitDie){
            hitDice.roll(hitDice.getSides());
            damage += hitDice.getValue();
        }
        return damage;
    }

    public void takeDamage(int damage){
        hp = hp - damage;
        if(hp <= 0){
            System.out.println("The enemy has been slain");
        } else {
            System.out.println("The enemy has " + hp + " hp left");
        }
    }
}
