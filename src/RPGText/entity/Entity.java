package RPGText.entity;
public abstract class Entity {
    /* Atributos */
    private int strength;
    private int agility;
    private int inteligence;
    private int constitution;

    /* Atributos Derivados */
    private int defense;
    private int life;
    private int damage;
    private String name;
    private int maxLife;

    /* Level / LevelUp / Xp Atual */
    private int level;
    private int upXp;
    private int actualXp;

    /* Bônus de Atributos */
    private int upStrength;
    private int upAgility;
    private int upInteligence;
    private int upConstitution;
    private int upLife;
    private int upMaxLife;

    public Entity(int strength, int agility, int inteligence, int constitution, int damage, String name) {
        this.strength = strength;
        this.agility = agility;
        this.inteligence = inteligence;
        this.constitution = constitution;
        this.defense = agility + 5;
        this.life = constitution * 5;
        this.maxLife = life;
        this.damage = damage;
        this.name = name;
        this.actualXp = 0;
    }     

    public void addName(String name) {
        this.name = name;
    }

    public void LvlUp(int level) {
        for(int i = 0; i < level;i++) {
            this.level = this.level + level;
            this.maxLife = this.maxLife + this.upLife;
            this.life = this.maxLife + this.upLife;
            this.strength = this.strength + this.upStrength;
            this.agility = this.agility + this.upAgility;
            this.inteligence = this.inteligence + this.upInteligence;
            this.constitution = this.constitution + this.upConstitution;
        }
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
        if(this.life > maxLife){
            this.life = maxLife;
        }
        return life;
    }
}
