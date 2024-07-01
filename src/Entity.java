public abstract class Entity {
    private int strengh;
    private int agillity;
    private int inteligence;
    private int constitucion;
    private int defense;
    private int life;
    private int damage;
    private String name;

    public Entity(int strengh, int agillity, int inteligence, int constitucion, int damage, String name) {
        this.strengh = strengh;
        this.agillity = agillity;
        this.inteligence = inteligence;
        this.constitucion = constitucion;
        this.defense = agillity + 5;
        this.life = constitucion * 5;
        this.damage = damage;
        this.name = name;
    }     

    public int getAgillity() {
        return agillity;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public int getInteligence() {
        return inteligence;
    }

    public int getStrengh() {
        return strengh;
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
}
