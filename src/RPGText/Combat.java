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

    // Inicia um novo combate
    public Combat(EntityPlayable character, EntityEnemy enemy) {
        this.character = character;
        this.enemy = enemy;
    };

    // Verifica a duração do combate
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

    // Calcula o acerto
    public static boolean strike(Entity attacker, Entity defensor) {
        int strike = bestStrike();
        //int strike = bestStrike(attacker);
        if(strike >= defensor.getDefense()) {
            System.out.println(attacker.getName() + " Acertou " + strike);
            hurtEntity(attacker.getDamage(), defensor, strike);
            return true;
        } else {
            System.out.println(attacker.getName() + " errou");
            return false;
        } 
    }

    // Calcula o acerto de Skills
    public static boolean strikeSkill(String name, int damage, Entity defensor, int strike) {
        if(strike >= defensor.getDefense()) {
            System.out.println(name + " Acertou " + strike);
            hurtEntity(damage, defensor, strike);
            return true;
        } else {
            System.out.println(name + " errou");
            return false;
        } 
    }

    // Calcula o acerto
    public static int bestStrike() {
        int bestStrike = 0;
        double probability = Math.random();
        if(probability < 0.11) {
            bestStrike = 10; // 10% crítico
        } else if(probability < 0.31) {
            bestStrike = 0; // 30% erro | esquiva
        } else {
            bestStrike = 9; // 70% acerto
        }
        return bestStrike;
    }

    // Roda dados -- Remover por probabilidade pura
    /*public static int bestStrike(Entity attacker) {
    *    int bestStrike = 0;
    *    for(int i = 0; i < attacker.getstrength(); i++) {
    *        int strike = Manager.probabilityDice();
    *        if(strike > bestStrike) {
    *            bestStrike = strike;
    *        }
    *    }
    *    return bestStrike;
    }*/

    // Causar dano a qualquer entidade
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

    // Fim do combate
    public static void endCombat() {
        combatDuration = false;
    }

    // Ganho de Xp
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