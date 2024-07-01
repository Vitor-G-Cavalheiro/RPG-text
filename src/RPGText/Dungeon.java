package RPGText;

import RPGText.entity.Dragon;
import RPGText.entity.Warrior;
import RPGText.entity.Goblin;

public class Dungeon {
    Warrior junior = new Warrior(3, 2, 1, 3, 5, "Rodrigo Junior");
    Dragon boss = new Dragon(5, 2, 1, 5, 20, "Deus Dragão Vermelho");
    int floor = 0;

    public void startDungeon(){
        for(int i = 0; i < 10;i++){
            Goblin narigudo = new Goblin(1, 2, 1, 2, 3, "Maldito Verde");
            System.out.println("VOCÊ ENCONTROU UM " + narigudo.getName());
            System.out.println(narigudo.getLife());
            Combat combat = new Combat(junior, narigudo);
            combat.combatStart();
            floor++;
        }
        if(floor == 10){
            finalBoss();
        }
    }

    public void finalBoss(){
        System.out.println("VOCÊ ENCONTROU O " + boss.getName());
        Combat combat = new Combat(junior, boss);
        combat.combatStart();
    }
}
