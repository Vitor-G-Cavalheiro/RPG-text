package RPGText;

import java.util.List;
import java.util.Random;
import java.util.Arrays;

import RPGText.entity.Dragon;
import RPGText.entity.Entity;
import RPGText.entity.Goblin;
import RPGText.entity.Slime;
import RPGText.entity.Wolf;

public class Dungeon {
    Dragon boss = new Dragon();
    boolean rewardAvaliable = true;
    
    Listener listen = new Listener();

    Random random = new Random();

    public void startDungeon(Entity junior) {
        for(int floor = 1; floor < 12;floor++){
            if(junior.getLife() < 1) {
                Manager.endGame();
                break;
            }
            if(floor == 4 && rewardAvaliable || floor == 8 && rewardAvaliable){
                rewardRoom();
            } else if(floor == 5 || floor == 10) {
                safeRoom(junior);
            } else if(floor == 11){
                finalBoss(junior);
            } else {
                roomRandomizer(junior);
            }  
        }     
    }

    public void finalBoss(Entity junior){
        System.out.println("VOCÊ ENCONTROU O " + boss.getName());
        Combat combat = new Combat(junior, boss);
        combat.combatStart();
    }

    public Entity enemyRandomizer() {
        List<Entity> enemys = Arrays.asList(
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

    public void combatRoom(Entity junior) {
        Entity enemy = enemyRandomizer();
        System.out.println("VOCÊ ENCONTROU UM -=[ " + enemy.getName() + " ]=-");
        System.out.println("Vida: "+ enemy.getLife());
        Combat combat = new Combat(junior, enemy);
        combat.combatStart();
    }

    public void safeRoom(Entity junior) {
        System.out.println("DESCANSE UM POUCO!");
        junior.healling(100);
        System.out.println("VOCÊ DESCANSOU, SUA VIDA ATUAL É DE: " + junior.getLife());
        this.rewardAvaliable = true;
    }

    public void rewardRoom() {
        System.out.println("BEM VINDO A SALA DE RECOMPENSA");
        this.rewardAvaliable = false;
    }

    public void roomRandomizer(Entity junior) {
        double probability = Math.random();
        if(probability < 0.31 && rewardAvaliable) {
            rewardRoom();
        } else {
            combatRoom(junior);
        }
    }
}


/* 11 andares
 * 0 - 4 : monstros e 1 bau
 * 5 : safe room
 * 6 - 9 : 3 monstros e 1 bau
 * 10 - 11 : safe room antes do boss e o boss;
 */