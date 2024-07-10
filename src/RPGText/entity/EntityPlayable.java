package RPGText.entity;

public class EntityPlayable extends Entity {
    // Necessário para Upar / XP Atual
    private int upXp = 50;
    private int actualXp = 0;

    // Nome das Habilidades
    protected String nameSkillOne;
    protected String nameSkillTwo;

    public EntityPlayable(int strength, int agility, int inteligence, int constitution, int damage) {
        super(strength, agility, inteligence, constitution, damage);
    }

    public void setActualXp(EntityPlayable character, int xp) {
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
        maxLife = maxLife + upLife; //this.upLife;
        life = maxLife; //this.upLife;
        strength = strength + upStrength; //this.upStrength;
        agility = agility + upAgility; //this.upAgility;
        inteligence = inteligence + upInteligence; // this.upInteligence;
        constitution = constitution + upConstitution; //this.upConstitution;
        damage = damage + upDamage;
        this.upXp = this.upXp + 25;
        this.level = this.level + 1;
    }

    public String getNameSkillOne() {
        return this.nameSkillOne;
    }

    public String getNameSkillTwo() {
        return this.nameSkillTwo;
    }

    public void skillOne(Entity enemy) {
        //Vai ser sobreescrito
    }

    public void skillTwo(Entity enemy) {
        //Vai ser sobreescrito
    }
}
