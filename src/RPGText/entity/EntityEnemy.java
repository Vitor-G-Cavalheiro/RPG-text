package RPGText.entity;

public class EntityEnemy extends Entity {
    // XP Drop
    protected int xpDrop;
    protected int upXpDrop;

    // Método Criador
    public EntityEnemy(int strength, int agility, int inteligence, int constitution, int damage) {
        super(strength, agility, inteligence, constitution, damage);
    }

    // Métodos Get
    public int getXpDrop() {
        return this.xpDrop;
    }

    // Override SetLevel pq Entity não possui xpDrop
    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        this.xpDrop = this.xpDrop + this.upXpDrop;
    }
}
