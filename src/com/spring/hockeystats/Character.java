package com.spring.hockeystats;

import java.util.ArrayList;

public class Character {

    private int ac;
    private int hp;
    private int attackModifier;
    private int defenceModifier;
    private ArrayList<Die> hitDice;

    public Character(int ac, int hp, int defenceModifier){
        this.ac = ac;
        this.hp = hp;
    }

    public Character(int ac, int hp, int attackModifier, int defenceModifier, int numHitDie, int sidesOfHitDie){
        this.defenceModifier = defenceModifier;
        this.attackModifier = attackModifier;

        this.ac = ac;
        this.hp = hp;

        ArrayList<Die> dieList = new ArrayList<>();
        for (int dieCount = 0; dieCount < numHitDie; dieCount++){
            dieList.add(new Die(sidesOfHitDie));
        }
        this.hitDice = dieList;
    }

    public int getAc() {
        return ac;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackModifier() {
        return attackModifier;
    }

    public int getDefenceModifier() {
        return defenceModifier;
    }

    public int attack(){
        int damage = 0;
        for(Die hitDie : hitDice){
            hitDie.roll(hitDie.getSides());
            damage += hitDie.getValue();
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

    public Boolean isDead(Character character){
        if(character.getHp() <= 0){
            return true;
        }
        return false;
    }
}
