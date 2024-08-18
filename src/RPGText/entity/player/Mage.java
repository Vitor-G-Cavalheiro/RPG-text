package RPGText.entity.player;

import RPGText.Combat;
import RPGText.entity.Entity;
import RPGText.entity.EntityPlayable;

public class Mage extends EntityPlayable {
    public Mage() {
        super(1, 3, 3, 2, 4, "MAG");
        this.nameSkillOne = "BOLA DE FOGO";
        this.custSkillOne = 3;
        this.nameSkillTwo = "BURACO ANTI MATERIA";
        this.custSkillTwo = 20;
        this.upDamage = 4;
        this.upStrength = 1;
        this.upAgility = 5;
        this.upInteligence = 5;
        this.upConstitution = 3;
        this.upLife = 4;
    }
    
    @Override
    public void skillOne(Entity enemy) {
        // Um ataque simples para substituir seu ataque comum
        // 0.2 + 0. 7 | 90% chance de acerto - 20% chance de crítico
        double probability = Math.random();
        int damage = 6 + inteligence;
        int strike = 0;
        if (probability < 0.21) {
            strike = 10;
        } else if (probability < 0.91) {
            strike = 9;
        }
        Combat.strikeSkill(name, damage, enemy, strike);
    }

    @Override
    public void skillTwo(Entity enemy) {
        // Um poderoso ataque que aumenta seu dano denpendendo da sorte
        // 80% chance de acerto dividido por 4 para multiplicação do dano
        double probability = Math.random();
        int damage = inteligence * inteligence;
        int strike = 9;
        if(probability < 0.21) {
            damage = damage * 4;
        } else if(probability < 0.41) {
            damage = damage * 3;
        } else if(probability < 0.61) {
            damage = damage * 2;
        } else if(probability > 0.80) {
            strike = 0;
        }
        Combat.strikeSkill(name, damage, enemy, strike);
    }
}
