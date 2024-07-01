public class Combat {
    boolean combatDuration = true;
    Entity character;
    Entity enemy;

    public Combat(Entity character, Entity enemy){
        this.character = character;
        this.enemy = enemy;
    };

    public void combatStart(){
        while(combatDuration){
            if(character.getLife() > 0){
                strike(character, enemy);
            }
            if(enemy.getLife() > 0){
                strike(enemy, character);
            }
        }
    }

    public boolean strike(Entity attacker, Entity defensor) {
        int strike = bestStrike(attacker);
        if(strike >= defensor.getDefense()){
            System.out.println(attacker.getName() + " Acertou " + strike);
            hurtEntity(attacker.getDamage(), defensor);
            return true;
        } else {
            System.out.println(attacker.getName() + " errou");
            return false;
        } 
    }

    public int bestStrike(Entity attacker) {
        int bestStrike = 0;
        for(int i = 0; i < attacker.getstrength(); i++){
            int strike = probability();
            if(strike > bestStrike){
                bestStrike = strike;
            }
        }
        return bestStrike;
    }

    public void hurtEntity(int damage, Entity entity){
        int life = entity.soffrering(damage);
        if(life <= 0){
            System.out.println(entity.getName() + " morreu");
            endCombat();
        }else {
            System.out.println(entity.getName() + " sofreu, sua vida atual é de: " + life);
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
