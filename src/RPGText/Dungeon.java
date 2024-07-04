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
    int floor = 0;
    
    Listener listen = new Listener();

    List<Entity> enemys = Arrays.asList(
        new Goblin(),
        new Wolf(),
        new Slime()
    );

    Random random = new Random();

    public void startDungeon(Entity junior) {
        for(int i = 0; i < 10;i++){
            Entity enemy = enemys.get(random.nextInt(enemys.size()));
            System.out.println("VOCÊ ENCONTROU UM -=[ " + enemy.getName() + " ]=-");
            System.out.println("Vida: "+enemy.getLife());
            Combat combat = new Combat(junior, enemy);
            combat.combatStart();
            floor++;
        }
        if(floor == 10){
            finalBoss(junior);
        }
    }

    public void finalBoss(Entity junior){
        System.out.println("VOCÊ ENCONTROU O " + boss.getName());
        Combat combat = new Combat(junior, boss);
        combat.combatStart();
    }
}
