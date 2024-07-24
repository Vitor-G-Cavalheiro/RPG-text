package RPGText;

import java.util.Scanner;

import RPGText.entity.EntityEnemy;
import RPGText.entity.EntityPlayable;

public class Listener {
    Scanner sc = new Scanner(System.in);

    // Escuta o inicio do jogo
    public String loadingScreen() {
        System.out.println("BEM VINDO AO TESTE 0.46");
        System.out.println("DIGITE JOGAR PARA INICIAR");
        String player = sc.nextLine();
        return player;
    }

    // Nomeia o personagem
    public String nameCharacter() {
        System.out.println("NOMEIE SEU PERSONAGEM: ");
        String player = sc.nextLine();
        return player;
    }
    
    // Escolhas dentro do combate
    public Boolean choiceCombat(EntityPlayable character, EntityEnemy enemy) {
        boolean combatContinue = true;
        System.out.println("O QUE DESEJA FAZER?\n - ATACAR\n - ITEM\n - FUGIR");
        String player = sc.nextLine();
        if(player.equalsIgnoreCase("ATACAR")) {
            choiceSkill(character, enemy);
        }else if(player.equalsIgnoreCase("ITEM")) {
            String consumables = choiceItem();
            Item.usageItem(consumables, character);
        }else if(player.equalsIgnoreCase("FUGIR")) {
            combatContinue = false;
        }
        return combatContinue;
    }

    // Escolha de item para ser usado
    public String choiceItem() {
        System.out.println("QUAL ITEM DESEJA USAR?\n - CURA\n - MANA");
        String item = sc.nextLine();
        return item;
    }

    // Escolha uma habilidade para ser usada
    public String choiceSkill(EntityPlayable character, EntityEnemy enemy) {
        String skillOne = character.getNameSkillOne();
        String skillTwo = character.getNameSkillTwo();
        System.out.println("QUAL HABILIDADE VAI USAR?\n - ATACAR\n - " + skillOne + "\n - " + skillTwo);
        String skill = sc.nextLine();
        if(skill.equalsIgnoreCase("ATACAR")) {
            Combat.strike(character, enemy);
        } else if(skill.equalsIgnoreCase(skillOne)) {
            character.skillOne(enemy);
        } else if(skill.equalsIgnoreCase(skillTwo)) {
            character.skillTwo(enemy);
        }
        return skill;
    }
}
