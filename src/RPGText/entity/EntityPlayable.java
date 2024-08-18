package RPGText.entity;

public class EntityPlayable extends Entity {
    // Classes
    protected String type;
    
    // Necessário para Upar / XP Atual
    private int upXp = 50;
    private int actualXp = 0;

    // Nome das Habilidades
    protected String nameSkillOne;
    protected String nameSkillTwo;
    
    // Preço das Habilidades
    protected int custSkillOne;
    protected int custSkillTwo;

    // Mana
    protected int mana;
    protected int maxMana;

    // Método Criador
    public EntityPlayable(int strength, int agility, int inteligence, int constitution, int damage, String type) {
        super(strength, agility, inteligence, constitution, damage);
        this.mana = 12 + inteligence;
        this.maxMana = mana;
        this.type = type;
    }

    public EntityPlayable() {
        super(0, 0, 0, 0, 0);
    }

    // Métodos Get
    public String getType() {
        return type;
    }

     public int getXpActual() {
        return this.actualXp;
    }

    public String getNameSkillOne() {
        return this.nameSkillOne;
    }

    public String getNameSkillTwo() {
        return this.nameSkillTwo;
    }

    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getCustSkillOne() {
        return custSkillOne;
    }

    public int getCustSkillTwo() {
        return custSkillTwo;
    }

    // Métodos Set
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

    // Outros Métodos
    public void LvlUp() {
        maxLife = maxLife + upLife;
        life = maxLife; //this.upLife;
        strength = strength + upStrength;
        agility = agility + upAgility;
        inteligence = inteligence + upInteligence;
        constitution = constitution + upConstitution;
        damage = damage + upDamage;
        this.maxMana = maxMana + inteligence;
        this.mana = maxMana;
        this.upXp = this.upXp + 25;
        this.level = this.level + 1;
    }

    // Gerenciamento de Mana
    public void custMana(int cust) {
        this.mana -= cust;
    }

    // Recuperação de Mana
    public int manaRec(int healMana) {
        this.mana = mana + (this.level * healMana);
        this.mana = mana + (this.level * healMana);
        if(this.mana > maxMana){
            this.mana = maxMana;
        }

        return mana;
    }

    // Métodos de Habilidades que vão ser sobreescritos
    public void skillOne(Entity enemy) {
        //Vai ser sobreescrito
    }

    public void skillTwo(Entity enemy) {
        //Vai ser sobreescrito
    }

    // ADICIONAR FORÇA NO ACERTO??? REFORMULAR FORMA DE CALCULAR ACERTO / BALANCEAR O JOGO
}
