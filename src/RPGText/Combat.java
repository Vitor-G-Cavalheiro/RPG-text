package RPGText;

import RPGText.entity.Entity;
import RPGText.entity.EntityPlayable;
import RPGText.entity.EntityEnemy;

public class Combat {
    static boolean combatDuration = true;
    EntityPlayable character;
    EntityEnemy enemy;

    Listener listen = new Listener();
    Item item = new Item();

    public Combat(EntityPlayable character, EntityEnemy enemy) {
        this.character = character;
        this.enemy = enemy;
    };

    public void combatStart() {
        combatDuration = true;
        do{
            if(character.getLife() > 0){
                boolean combatContinue = listen.choiceCombat(character, enemy);
                 if(!combatContinue) {
                    System.out.println("VOCÊ CORREU!");
                    break;
                }
            } else {
                break;
            }
            if(enemy.getLife() > 0) {
                strike(enemy, character);
            }else {
                gainXP(character, enemy);
            }
        }while(combatDuration);
    }

    public static boolean strike(Entity attacker, Entity defensor) {
        int strike = bestStrike(attacker);
        if(strike >= defensor.getDefense()) {
            System.out.println(attacker.getName() + " Acertou " + strike);
            hurtEntity(attacker.getDamage(), defensor, strike);
            return true;
        } else {
            System.out.println(attacker.getName() + " errou");
            return false;
        } 
    }

    public static int bestStrike(Entity attacker) {
        int bestStrike = 0;
        double probability = Math.random();
        if(probability < 0.11) {
            bestStrike = 10;
        } else if(probability < 0.31) {
            bestStrike = 0;
        } else {
            bestStrike = 9;
        }
        return bestStrike;
    }

    public static void hurtEntity(int damage, Entity entity, int strike) {
        if(strike == 10) {
            damage = damage * 2;
        }
        int life = entity.soffrering(damage);
        if(life <= 0) {
            System.out.println(entity.getName() + " morreu");
            endCombat();
        }else {
            System.out.println(entity.getName() + " sofreu, sua vida atual é de: " + life);
        }
    }

    public static void endCombat() {
        combatDuration = false;
    }

    public void gainXP(EntityPlayable character, EntityEnemy enemy) {
        int xp = enemy.getXpDrop();
        character.setActualXp(character, xp);
    }
}

/* 100%
 * 10% - critico
 * 20% - esquiva
 * 70% - acerto
 */