package RPGText.entity;

public class Dragon extends EntityEnemy {
    public Dragon() {
        super(5, 2, 1, 5, 20);
        this.name = "Deus Dragão Vermelho";
        this.xpDrop = 500;
        this.upXpDrop = 500;
        this.upStrength = 5;
        this.upAgility = 1;
        this.upInteligence = 1;
        this.upConstitution = 5;
        this.upLife = 10;
        this.upDamage = 5;
    }
}
