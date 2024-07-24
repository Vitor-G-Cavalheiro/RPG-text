package RPGText;

import java.util.List;
import java.util.Random;
import java.util.Arrays;

import RPGText.entity.Dragon;
import RPGText.entity.EntityEnemy;
import RPGText.entity.EntityPlayable;
import RPGText.entity.Goblin;
import RPGText.entity.Slime;
import RPGText.entity.Wolf;

public class Dungeon {
    Dragon boss = new Dragon();
    boolean rewardAvaliable = true;
    
    Listener listen = new Listener();

    Random random = new Random();

    // Inicia a Dungeon
    public void startDungeon(EntityPlayable junior) {
        for(int floor = 1; floor < 12;floor++) {
            if(junior.getLife() < 1) {
                Manager.endGame();
                break;
            }
            if(floor == 4 && rewardAvaliable || floor == 8 && rewardAvaliable){
                rewardRoom();
            } else if(floor == 5 || floor == 10) {
                safeRoom(junior);
            } else if(floor == 11) {
                finalBoss(junior);
            } else {
                roomRandomizer(junior);
            }  
        }     
    }

    // Chama a sala do boss final
    public void finalBoss(EntityPlayable junior) {
        System.out.println("VOCÊ ENCONTROU O " + boss.getName());
        Combat combat = new Combat(junior, boss);
        combat.combatStart();
    }

    // Randomiza os inimigos
    public EntityEnemy enemyRandomizer() {
        List<EntityEnemy> enemys = Arrays.asList(
            new Slime(), //40% 0.4 = 0 ao 0.4
            new Goblin(), //35% 0.4 + 0.35 = 0.41 ao 0.75
            new Wolf() //25% 0.4 + 0.35 + 0.25 = 0.76 ao 1
        );
        double probability = Math.random();
        if(probability < 0.41) {
            return enemys.get(0);
        }else if(probability < 0.76) {
            return enemys.get(1);
        }else {
            return enemys.get(2);
        }
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
        junior.healling(100);
        System.out.println("VOCÊ DESCANSOU, SUA VIDA ATUAL É DE: " + junior.getLife());
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
            rewardRoom();
        } else {
            combatRoom(junior);
        }
    }
}


/* 11 andares ( 1 Dungeon )
 * 0 - 4 : monstros e 1 bau
 * 5 : safe room
 * 6 - 9 : 3 monstros e 1 bau
 * 10 - 11 : safe room antes do boss e o boss;
 */