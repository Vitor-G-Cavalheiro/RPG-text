package RPGText.entity;

import RPGText.Combat;

public class Warrior extends EntityPlayable {
    public Warrior() {
        super(3, 2, 1, 3, 5);
        this.nameSkillOne = "FURIA";
        this.nameSkillTwo = "POSTURA DE COMBATE";
        this.upDamage = 5;
        this.upStrength = 5;
        this.upAgility = 1;
        this.upInteligence = 1;
        this.upConstitution = 5;
        this.upLife = 10;
    }

    @Override
    public void skillOne(Entity enemy) {
        boolean hit = true;
        double probability = Math.random();
        double chance = 0.76;
        int damage = 6;
        int vezes = 0;
        // 0.75 | 75% de acerto - Sequência de golpes - % vai diminuindo
        do{
            if(probability < chance){
                chance = chance - 0.20;
                damage = damage + 3;
                vezes++;
                System.out.println(" " + getName() + " acertou " + vezes + " vezes");
            } else {
                hit = false;
            }
        }while(hit);
        System.out.println(damage);
        Combat.hurtEntity(damage, enemy, 9);
    }

    @Override
    public void skillTwo(Entity enemy) {
        double probability = Math.random();
        int damage = 0;
        // 0.2 + 0.7 | 90% de acerto - Um único golpe poderoso - 0.2 | 20% de chance crítica
        if(probability < 0.21){
            damage = 26;
        } else if(probability < 0.91) {
            damage = 13;
        } else {
            damage = 0;
        }
        System.out.println(damage);
        Combat.hurtEntity(damage, enemy, 9);
    }

}
