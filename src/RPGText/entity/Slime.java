package RPGText.entity;

public class Slime extends EntityEnemy {
    public Slime() {
        super(1, 1, 1, 3, 2);
        this.name = "Gosma afrontosa";
        this.xpDrop = 10;
        this.upXpDrop = 10;
        this.upStrength = 5;
        this.upAgility = 1;
        this.upInteligence = 1;
        this.upConstitution = 5;
        this.upLife = 10;
        this.upDamage = 5;
    }
}
