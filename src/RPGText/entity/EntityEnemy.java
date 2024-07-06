package RPGText.entity;

public class EntityEnemy extends Entity {
    // XP Drop
    protected int xpDrop;

    public EntityEnemy(int strength, int agility, int inteligence, int constitution, int damage) {
        super(strength, agility, inteligence, constitution, damage);
    }

    public int getXpDrop() {
        return this.xpDrop;
    }

    /*public void setLeve(int level) {

    }*/
}
