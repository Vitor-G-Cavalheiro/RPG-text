package RPGText.entity;

public class EntityEnemy extends Entity {
    // XP Drop
    protected int xpDrop;

    // Método Criador
    public EntityEnemy(int strength, int agility, int inteligence, int constitution, int damage) {
        super(strength, agility, inteligence, constitution, damage);
    }

    // Métodos Get
    public int getXpDrop() {
        return this.xpDrop;
    }

    // Métodos Set
    public void setLevel(int level) {
        for(int i = 1; i < level;i++) {
            maxLife = maxLife + constitution; //this.upLife;
            life = maxLife; //this.upLife;
            strength = strength + 5; //this.upStrength;
            agility = agility + 1; //this.upAgility;
            inteligence = inteligence + 1; // this.upInteligence;
            constitution = constitution + 5; //this.upConstitution;
            this.level = this.level + 1;
        }
    }
}
