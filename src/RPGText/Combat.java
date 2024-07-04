package RPGText;
import RPGText.entity.Entity;

public class Combat {
    boolean combatDuration = true;
    Entity character;
    Entity enemy;

    Listener listen = new Listener();
    Item item = new Item();

    public Combat(Entity character, Entity enemy){
        this.character = character;
        this.enemy = enemy;
    };

    public void combatStart(){
        do{
            if(character.getLife() > 0){
                String player = listen.choiceCombat();
                if(player.equalsIgnoreCase("ATACAR")){
                    strike(character, enemy);
                }else if(player.equalsIgnoreCase("ITEM")){
                    String consumables = listen.choiceItem();
                    item.usageItem(consumables, character);
                }else if(player.equalsIgnoreCase("FUGIR")){
                    System.out.println("VOCÊ CORREU!");
                    break;
                }
            }
            if(enemy.getLife() > 0){
                strike(enemy, character);
            }else {
                gainXP(character, enemy);
            }
        }while(combatDuration);
    }

    public boolean strike(Entity attacker, Entity defensor) {
        int strike = bestStrike(attacker);
        if(strike >= defensor.getDefense()){
            System.out.println(attacker.getName() + " Acertou " + strike);
            hurtEntity(attacker.getDamage(), defensor, strike);
            return true;
        } else {
            System.out.println(attacker.getName() + " errou");
            return false;
        } 
    }

    public int bestStrike(Entity attacker) {
        int bestStrike = 0;
        for(int i = 0; i < attacker.getstrength(); i++){
            int strike = Manager.probabilityDice();
            if(strike > bestStrike){
                bestStrike = strike;
            }
        }
        return bestStrike;
    }

    public void hurtEntity(int damage, Entity entity, int strike){
        if(strike == 10){
            damage = damage * 2;
        }
        int life = entity.soffrering(damage);
        if(life <= 0){
            System.out.println(entity.getName() + " morreu");
            endCombat();
        }else {
            System.out.println(entity.getName() + " sofreu, sua vida atual é de: " + life);
        }
    }

    public void endCombat() {
        combatDuration = false;
    }

    public void gainXP(Entity character, Entity enemy) {
        enemy.getXpDrop();
    }
}
