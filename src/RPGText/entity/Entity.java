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

    // Atributos de Combate
    protected int dodge;
    protected int critic;
    protected int hit;

    // Level
    protected int level = 1;

    // Bônus de Atributos 
    protected int upStrength;
    protected int upAgility;
    protected int upInteligence;
    protected int upConstitution;
    protected int upLife;
    protected int upDamage;

    // Método Criador
    public Entity(int strength, int agility, int inteligence, int constitution, int damage) {
        this.strength = strength;
        this.agility = agility;
        this.inteligence = inteligence;
        this.constitution = constitution;
        this.defense = agility + 4;
        this.life = 15 + constitution;
        this.maxLife = life;
        this.damage = damage;
    }     

    // Métodos Get
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

    public int getLife() {
        return life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public int getDamage() {
        return damage;
    }

    public int getLevel() {
        return this.level;
    }

    // Métodos Set
    public void setName(String name) {
        this.name = name;
    }

    // Outros Métodos
    // Método que remove vida
    public int soffrering(int damage) {
        this.life = life - damage;
        return life;
    }

    // Método que cura vida
    public int healling(int heal) {
        this.life = life + (this.level * heal);
        this.life = life + (this.level * heal);
        if(this.life > maxLife){
            this.life = maxLife;
        }

        return life;
    }

    // Método que muda o Level
    public void setLevel(int level) {
        while(this.level < level){
            this.maxLife = this.maxLife + this.upLife;
            this.life = this.maxLife;
            this.strength = this.strength + this.upStrength;
            this.agility = this.agility + this.upAgility;
            this.inteligence = this.inteligence + this.upInteligence;
            this.constitution = this.constitution + this.upConstitution;
            this.damage = this.damage + this.upDamage;
            this.level = this.level + 1;
        } 
    }
}
