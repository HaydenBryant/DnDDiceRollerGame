package com.spring.hockeystats;

import java.util.Scanner;

public class InOut {
    private Die d20 = new Die(20);

    Scanner scan = new Scanner(System.in);

    public Character createEnemy(){
        System.out.println("What is your enemys ac?: ");
        int ac = scan.nextInt();
        System.out.println("What is your enemys hp?: ");
        int hp = scan.nextInt();
        Character enemy = new Character(ac, hp);
        return enemy;
    }

    public Character createCharacter(){
        System.out.println("What is your characters ac?: ");
        int ac = scan.nextInt();
        System.out.println("What is your characters hp?: ");
        int hp = scan.nextInt();
        System.out.println("What are your characters hit die?(ex 2d6): ");
        String[] hitDie = scan.nextLine().split("d");
        int numHitDie = Integer.parseInt(hitDie[0]);
        int hitDieSides = Integer.parseInt(hitDie[1]);

        Character player = new Character(ac, hp, numHitDie, hitDieSides);
        return player;
    }


    public int makeAttack(Character enemy, Character player){
        d20.roll(d20.getSides());
        System.out.println("You rolled " + d20.getValue());
        if (d20.getValue() <= enemy.getAc()){
            System.out.println("Your roll was below the enemys ac of " + enemy.getAc() + " and you missed.");
            return 0;
        }
        if(d20.getValue() == 20){
            int damage = player.attack();
            damage += player.attack();
            System.out.println("Your roll was a critical hit and you dealt " + damage + " damage.");
            return damage;
        }
        int damage = player.attack();
        System.out.println("You dealt " + damage + " damage.");
        return damage;
    }


}
