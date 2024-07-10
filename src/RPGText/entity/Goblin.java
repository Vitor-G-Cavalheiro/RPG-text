package RPGText.entity;

public class Goblin extends EntityEnemy {
    public Goblin() {
        super(1, 2, 1, 2, 3);
        this.name =  "Maldito Verde";
        this.xpDrop = 35;
        this.upXpDrop = 35;
        this.upStrength = 5;
        this.upAgility = 1;
        this.upInteligence = 1;
        this.upConstitution = 5;
        this.upLife = 10;
        this.upDamage = 5;
    }
}
