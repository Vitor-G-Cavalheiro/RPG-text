package RPGText.entity;

public abstract class Entity {
    // Atributos
    protected int strength;
    protected int agility;
    protected int inteligence;
    protected int constitution;

    // Atributos Derivados
    protected int defense;
    protected int life;
    protected int damage;
    protected String name;
    protected int maxLife;

    // Level / LevelUp / Xp Atual 
    protected int level = 1;

    // Bônus de Atributos 
    //private int upStrength;
    //private int upAgility;
    //private int upInteligence;
    //private int upConstitution;
    //private int upLife;

    public Entity(int strength, int agility, int inteligence, int constitution, int damage) {
        this.strength = strength;
        this.agility = agility;
        this.inteligence = inteligence;
        this.constitution = constitution;
        this.defense = agility + 5;
        this.life = constitution * 5;
        this.maxLife = life;
        this.damage = damage;
    }     

    public void setName(String name) {
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

    public int healling(int heal) {
        this.life = life + heal;
        if(this.life > maxLife){
            this.life = maxLife;
        }
        return life;
    }
}
