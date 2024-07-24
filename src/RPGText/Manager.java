package RPGText;

import RPGText.entity.Warrior;

public class Manager {
    Listener listen = new Listener();
    Dungeon dungeon = new Dungeon();
    
    Warrior junior = new Warrior();

    // Inicia um novo jogo
    public void startGame() {
        String player = listen.loadingScreen();
        if(player.equalsIgnoreCase("JOGAR")){
            nameManager();
        }
    }

    // Grava o nome do jogador
    public void nameManager() {
        String name = listen.nameCharacter();
        junior.setName(name);
        dungeon.startDungeon(junior);
    }

    // Probabilidade de 0 a 10
    public static int probabilityDice() {
        int strike = (int) (Math.random() * 10) + 1;
        return strike;
    }

    // Chama o final de jogo caso morra
    public static void endGame() {
        System.out.println("FIM DE JOGO\nOBRIGADO POR JOGAR");
    }
}
