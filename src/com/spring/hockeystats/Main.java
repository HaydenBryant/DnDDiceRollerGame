package com.spring.hockeystats;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Character enemy = InOut.createEnemy();
        Character player = InOut.createCharacter();

        while(true){
            String answer = InOut.questionAttack();
            if(answer.contains("n")){
                break;
            }

            int damage = InOut.makeAttack(enemy, player);
            enemy.takeDamage(damage);

            if(enemy.isDead(enemy) == true){
                System.out.println("Congratulations");
                break;
            }
        }
    }
}
