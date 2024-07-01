public class Combat {
    boolean combatDuration = true;
    Entity caracther;
    Entity enemy;

    public Combat(Entity caracther, Entity enemy){
        this.caracther = caracther;
        this.enemy = enemy;
    };

    public void combatStart(){
        while(combatDuration){
            for(int i = 0; i < caracther.getStrengh(); i++){
                int strike = probability();
                if(strike >= enemy.getDefense()){
                    System.out.println("Acertou " + strike);
                    hurtEntity(caracther.getDamage(), enemy);
                }else{
                    System.out.println("Tente de novo " + strike);
                }
            }
        }
    }

    public void hurtEntity(int damage, Entity entity){
        int life = entity.soffrering(damage);
        if(life <= 0){
            System.out.println("Alguém morreu");
            endCombat();
        }else {
            System.out.println("O Dragão sofreu, sua vida atual é de: " + life);
        }
    }

    public static int probability() {
        int strike = (int) (Math.random() * 10) + 1;
        return strike;
    }

    public void endCombat() {
        combatDuration = false;
    }
}
