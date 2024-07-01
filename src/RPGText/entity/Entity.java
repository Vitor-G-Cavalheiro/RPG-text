package RPGText.entity;
public abstract class Entity {
    private int strength;
    private int agility;
    private int inteligence;
    private int constitution;
    private int defense;
    private int life;
    private int damage;
    private String name;

    public Entity(int strength, int agility, int inteligence, int constitution, int damage, String name) {
        this.strength = strength;
        this.agility = agility;
        this.inteligence = inteligence;
        this.constitution = constitution;
        this.defense = agility + 5;
        this.life = constitution * 5;
        this.damage = damage;
        this.name = name;
    }     

    public int getAgility() {
        return agility;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getInteligence() {
        return inteligence;
    }

    public int getstrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    public String getName() {
        return name;
    }

    public int soffrering(int damage) {
        this.life = life - damage;
        return life;
    }

    public int getLife() {
        return life;
    }

    public int getDamage() {
        return damage;
    }

    public int healling(int heal){
        this.life = life + heal;
        return life;
    }
}
