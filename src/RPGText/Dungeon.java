package RPGText;

import RPGText.entity.Dragon;
import RPGText.entity.Entity;
import RPGText.entity.Goblin;

public class Dungeon {
    Dragon boss = new Dragon();
    int floor = 0;
    
    Listener listen = new Listener();

    public void startDungeon(Entity junior) {
        for(int i = 0; i < 10;i++){
            Goblin narigudo = new Goblin();
            System.out.println("VOCÊ ENCONTROU UM " + narigudo.getName());
            System.out.println(narigudo.getLife());
            Combat combat = new Combat(junior, narigudo);
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
