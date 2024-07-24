package RPGText.entity;

public class EntityPlayable extends Entity {
    // Necessário para Upar / XP Atual
    private int upXp = 50;
    private int actualXp = 0;

    // Nome das Habilidades
    protected String nameSkillOne;
    protected String nameSkillTwo;

    // Mana
    protected int mana;
    protected int maxMana;

    // Método Criador
    public EntityPlayable(int strength, int agility, int inteligence, int constitution, int damage) {
        super(strength, agility, inteligence, constitution, damage);
        this.mana = 12 + inteligence;
        this.maxMana = mana;
    }

     // Métodos Get
     public int getXpActual() {
        return this.actualXp;
    }

    public String getNameSkillOne() {
        return this.nameSkillOne;
    }

    public String getNameSkillTwo() {
        return this.nameSkillTwo;
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
        maxLife = maxLife + constitution; //this.upLife;
        life = maxLife; //this.upLife;
        strength = strength + 5; //this.upStrength;
        agility = agility + 1; //this.upAgility;
        inteligence = inteligence + 1; // this.upInteligence;
        constitution = constitution + 5; //this.upConstitution;
        this.maxMana = maxMana + inteligence;
        this.mana = maxMana;
        this.upXp = this.upXp + 25;
        this.level = this.level + 1;
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
