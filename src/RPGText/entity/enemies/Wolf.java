package RPGText.entity.enemies;

import RPGText.entity.EntityEnemy;

public class Wolf extends EntityEnemy {
    public Wolf() {
        super(3, 2, 1, 3, 3);
        this.name = "Lobo imundo";
        this.xpDrop = 60;
        this.upXpDrop = 60;
        this.upStrength = 5;
        this.upAgility = 1;
        this.upInteligence = 1;
        this.upConstitution = 5;
        this.upLife = 10;
        this.upDamage = 5;
    }
}
