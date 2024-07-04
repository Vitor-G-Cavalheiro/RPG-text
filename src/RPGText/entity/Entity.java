package RPGText.entity;
public abstract class Entity {
    // Atributos
    private int strength;
    private int agility;
    private int inteligence;
    private int constitution;

    // Atributos Derivados
    private int defense;
    private int life;
    private int damage;
    protected String name;
    private int maxLife;

    // Level / LevelUp / Xp Atual 
    private int level = 1;
    private int upXp = 50;
    private int actualXp = 0;
    protected int xpDrop;

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

    public int healling(int heal){
        this.life = life + heal;
        if(this.life > maxLife){
            this.life = maxLife;
        }
        return life;
    }

    public int getXpDrop() {
        return this.xpDrop;
    }

    public void setActualXp(Entity character, int xp) {
        this.actualXp = this.actualXp + xp;
        if(this.actualXp >= this.upXp){
            while(this.actualXp >= this.upXp){
                this.actualXp = this.actualXp - this.upXp;
                character.LvlUp();
                System.out.println("Seu nível atual é: " + this.level);
            }
        }
    }

    public int getXpActual() {
        return this.actualXp;
    }

    public int getLevel() {
        return this.level;
    }

    public void LvlUp() {
        this.maxLife = this.maxLife + 10; //this.upLife;
        this.life = this.maxLife + 10; //this.upLife;
        this.strength = this.strength + 5; //this.upStrength;
        this.agility = this.agility + 1; //this.upAgility;
        this.inteligence = this.inteligence + 1; // this.upInteligence;
        this.constitution = this.constitution + 5; //this.upConstitution;
        this.upXp = this.upXp + 25;
        this.level = this.level + 1;
    }
    
    /*public void setLevel() {
    *    Setar level nos monstro é diferente de setar level no player
    }*/
}
