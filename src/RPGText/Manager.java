package RPGText;

import RPGText.entity.Warrior;

public class Manager {
    Listener listen = new Listener();
    Dungeon dungeon = new Dungeon();
    
    Warrior junior = new Warrior();

    public void startGame() {
        String player = listen.loadingScreen();
        if(player.equalsIgnoreCase("JOGAR")){
            nameManager();
        }
    }

    public void nameManager() {
        String name = listen.nameCharacter();
        junior.LvlUp(1);
        dungeon.startDungeon(junior);
    }
}
