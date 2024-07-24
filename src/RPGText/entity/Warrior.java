package RPGText.entity;

import RPGText.Combat;

public class Warrior extends EntityPlayable {
    public Warrior() {
        super(3, 2, 1, 3, 5);
        this.nameSkillOne = "FURIA";
        this.nameSkillTwo = "POSTURA DE COMBATE";
    }

    @Override
    public void skillOne(Entity enemy) {
        boolean hit = true;
        double probability = Math.random();
        double chance = 0.76;
        int damage = 3 * strength;
        int strike = 0;
        int vezes = 0;
        // 0.75 | 75% de acerto - Sequência de golpes - % vai diminuindo
        do{
            if(probability < chance){
                chance = chance - 0.20;
                damage = damage + strength;
                vezes++;
                strike = 9;
                System.out.println(" " + getName() + " acertou " + vezes + " vezes");
            } else {
                hit = false;
            }
        }while(hit);
        Combat.strikeSkill(name, damage, enemy, strike);
    }

    @Override
    public void skillTwo(Entity enemy) {
        double probability = Math.random();
        int damage = 6 * strength;
        int strike = 0;
        // 0.2 + 0.7 | 90% de acerto - Um único golpe poderoso - 0.2 | 20% de chance crítica
        if(probability < 0.21){
            damage = damage * strength;
            strike = 10;
        } else if(probability < 0.91) {
            damage = damage * strength;
            strike = 9;
        } else {
            damage = 0;
        }
        Combat.strikeSkill(name, damage, enemy, strike);
    }

}
