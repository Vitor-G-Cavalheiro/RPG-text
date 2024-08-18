package RPGText.dungeon;

import RPGText.Combat;
import RPGText.Manager;
import RPGText.entity.EntityEnemy;
import RPGText.entity.EntityPlayable;
import RPGText.entity.enemies.Slime;

public class Dungeon {
    private EntityEnemy boss;
    private int finalFloor;

    protected boolean rewardAvaliable = true;

    public Dungeon(EntityEnemy boss, int finalFloor) {
        this.boss = boss;
        this.finalFloor = finalFloor;
    }

    // Inicia a Dungeon
    public void startDungeon(EntityPlayable junior) {
        int midFloor = (finalFloor - 1);
        for(int floor = 1; floor <= finalFloor;floor++) {
            if(junior.getLife() < 1) {
                Manager.endGame();
                break;
            }
            if(floor == (midFloor/2)-1 && rewardAvaliable || floor == midFloor-1 && rewardAvaliable){
                rewardRoom();
            } else if(floor == midFloor/2 || floor == midFloor) {
                safeRoom(junior);
            } else if(floor == finalFloor) {
                finalBoss(junior);
            } else {
                roomRandomizer(junior);
            }  
        }     
    }

    // Chama a sala do boss final
    public void finalBoss(EntityPlayable junior) {
        System.out.println("VOCÊ ENCONTROU O " + this.boss.getName());
        Combat combat = new Combat(junior, this.boss);
        combat.combatStart();
        Manager.passwordGenerator(junior);
    }

    // Randomiza os inimigos
    public EntityEnemy enemyRandomizer() {
        return new Slime(); //Feito para ser sobreescrito pelas dungeons
    }

    // Gera uma sala de combate
    public void combatRoom(EntityPlayable junior) {
        EntityEnemy enemy = enemyRandomizer();
        enemy.setLevel(junior.getLevel());
        System.out.println("O LEVEL DO INIMIGO É DE: " + enemy.getLevel());
        System.out.println("VOCÊ ENCONTROU UM -=[ " + enemy.getName() + " ]=-");
        System.out.println("Vida: "+ enemy.getLife());
        Combat combat = new Combat(junior, enemy);
        combat.combatStart();
    }

    // Gera uma sala de descanso
    public void safeRoom(EntityPlayable junior) {
        System.out.println("DESCANSE UM POUCO!");
        junior.healling(junior.getMaxLife());
        junior.manaRec(junior.getMaxMana());
        System.out.println("VOCÊ DESCANSOU, SUA VIDA ATUAL É DE: " + junior.getLife());
        System.out.println("VOCÊ DESCANSOU, SUA MANA ATUAL É DE: " + junior.getMana());
        this.rewardAvaliable = true;
    }

    // Gera uma sala de recompensa
    public void rewardRoom() {
        System.out.println("BEM VINDO A SALA DE RECOMPENSA");
        this.rewardAvaliable = false;
    }

    // Aleatoriza as salas
    public void roomRandomizer(EntityPlayable junior) {
        double probability = Math.random();
        if(probability < 0.31 && rewardAvaliable) {
            rewardRoom(); //30% de chance de sala de bônus
        } else {
            combatRoom(junior);
        }
    }
}

/* Z andares ( Dungeon )
 * Espaço entre : X monstros e Y baus
 * Metade - 1 : safe room
 * Espaço entre : X monstros e Y baus
 * Antes do Final - Final : safe room antes do boss e o boss;
 */

 /* 11 andares ( Dungeon Tutorial )
 * 0 - 4 : monstros e 1 bau
 * 5 : safe room
 * 6 - 9 : 3 monstros e 1 bau
 * 10 - 11 : safe room antes do boss e o boss;
 */