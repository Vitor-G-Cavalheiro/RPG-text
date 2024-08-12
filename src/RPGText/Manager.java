package RPGText;

import RPGText.dungeon.DungeonTutorial;
import RPGText.entity.EntityPlayable;
import RPGText.entity.Warrior;

public class Manager {
    Listener listen = new Listener();
    DungeonTutorial dungeonTutorial = new DungeonTutorial();
    
    Warrior junior = new Warrior();

    // Inicia um novo jogo
    public void startGame() {
        String player = listen.loadingScreen();
        if(player.equalsIgnoreCase("JOGAR")) {
            nameManager();
        } else if(player.equalsIgnoreCase("PASSWORD")) {
            String valid = listen.passwordVerify();
            if(!valid.equalsIgnoreCase("PASSWORD INVÁLIDA")) {
                passwordReader(valid);
            }
        }
    }

    // Grava o nome do jogador
    public void nameManager() {
        String name = listen.nameCharacter();
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
        EntityPlayable junior = typeReader(passwordBreak[2]);
        junior.setLevel(Integer.parseInt(passwordBreak[0]));
        junior.setName(passwordBreak[2]);
        dungeonTutorial.startDungeon(junior);
    }

    // Seletor de Classe/Tipo
    public static EntityPlayable typeReader(String type) {
        if(type.equals("WAR")) {
            return new Warrior();
        } else {
            return new Warrior();
        }
    }
}
