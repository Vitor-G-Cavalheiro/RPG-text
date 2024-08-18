package RPGText.dungeon;

import RPGText.entity.EntityEnemy;
import RPGText.entity.enemies.Dragon;
import RPGText.entity.enemies.Goblin;
import RPGText.entity.enemies.Slime;
import RPGText.entity.enemies.Wolf;

public class DungeonTutorial extends Dungeon {
    public DungeonTutorial() {
        super(new Dragon(), 11);
    }
    
    @Override
    public EntityEnemy enemyRandomizer() {
        double probability = Math.random();
        if(probability < 0.41) {
            return new Slime(); //40% 0.4 = 0 ao 0.4
        }else if(probability < 0.76) {
            return new Goblin(); //35% 0.4 + 0.35 = 0.41 ao 0.75
        }else {
            return new Wolf(); //25% 0.4 + 0.35 + 0.25 = 0.76 ao 1
        }
    }
}

/* 11 andares ( 1 Dungeon )
 * 0 - 4 : monstros e 1 bau
 * 5 : safe room
 * 6 - 9 : 3 monstros e 1 bau
 * 10 - 11 : safe room antes do boss e o boss;
 */