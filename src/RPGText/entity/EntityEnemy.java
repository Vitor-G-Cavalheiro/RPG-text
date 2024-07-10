package RPGText.entity;

public class EntityEnemy extends Entity {
    // XP Drop
    protected int xpDrop;
    protected int upXpDrop;

    public EntityEnemy(int strength, int agility, int inteligence, int constitution, int damage) {
        super(strength, agility, inteligence, constitution, damage);
    }

    public int getXpDrop() {
        return this.xpDrop;
    }

    public void setLevel(int level) {
        while(this.level < level){
            maxLife = maxLife + upLife; //this.upLife;
            life = maxLife; //this.upLife;
            strength = strength + upStrength; //this.upStrength;
            agility = agility + upAgility; //this.upAgility;
            inteligence = inteligence + upInteligence; // this.upInteligence;
            constitution = constitution + upConstitution; //this.upConstitution;
            damage = damage + upDamage;
            this.xpDrop = this.xpDrop + upXpDrop;
            this.level = this.level + 1;
        } 
    }

    /*public void oneAttack() {

    }*/
}
