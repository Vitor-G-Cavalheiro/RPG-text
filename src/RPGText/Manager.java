package RPGText;

import RPGText.dungeon.DungeonTutorial;
import RPGText.entity.EntityPlayable;

public class Manager {
    Listener listen = new Listener();
    DungeonTutorial dungeonTutorial = new DungeonTutorial();

    // Inicia um novo jogo
    public void startGame() {
        String player = listen.loadingScreen();
        if(player.equalsIgnoreCase("JOGAR")) {
            nameTypeManager();
        } else if(player.equalsIgnoreCase("PASSWORD")) {
            String valid = listen.passwordVerify();
            if(!valid.equalsIgnoreCase("PASSWORD INVÁLIDA")) {
                passwordReader(valid);
            }
        }
    }

    // Grava o nome e classe do jogador
    public void nameTypeManager() {
        String type = Choice.typeShowcase();
        String name = listen.nameCharacter();
        EntityPlayable junior = Choice.typeReader(type.substring(0, 3));
        junior.setName(name);
        dungeonTutorial.startDungeon(junior);
    }

    // Chama o final de jogo caso morra ou vença
    public static void endGame() {
        System.out.println("FIM DE JOGO\nOBRIGADO POR JOGAR");
    }

    // Gera um password para salvar o personagem
    public static void passwordGenerator(EntityPlayable junior) {
        if(junior.getLife() > 0) {
            System.out.println("PASSWORD: " + junior.getLevel() + "|" + junior.getType() + "|" + junior.getName() + "|VK");
        }
        endGame();
    }

    // Leitor de password
    public void passwordReader(String password) {
        String[] passwordBreak = password.split("\\|");
        EntityPlayable junior = Choice.typeReader(passwordBreak[1]);
        junior.setLevel(Integer.parseInt(passwordBreak[0]));
        junior.setName(passwordBreak[2]);
        dungeonTutorial.startDungeon(junior);
    }
}
