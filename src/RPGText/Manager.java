package RPGText;

public class Manager {
    Listener listen = new Listener();
    Dungeon dungeon = new Dungeon();

    public void startGame() {
        String player = listen.loadingScreen();
        if(player.equals("JOGAR")){
            dungeon.startDungeon();
        }
    }
}
