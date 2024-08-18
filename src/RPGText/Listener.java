package RPGText;

import java.util.Scanner;

import RPGText.entity.EntityEnemy;
import RPGText.entity.EntityPlayable;

public class Listener {
    Scanner sc = new Scanner(System.in);
    private String player;

    // Escuta o inicio do jogo
    public String loadingScreen() {
        System.out.println("BEM VINDO AO TESTE 0.78");
        System.out.println("DIGITE JOGAR PARA INICIAR");
        player = sc.nextLine();
        return player;
    }

    // Nomeia o personagem
    public String nameCharacter() {
        System.out.println("NOMEIE SEU PERSONAGEM: ");
        return sc.nextLine();
    }

    // Escreve uma password
    public String passwordVerify() {
        System.out.println("Digite a Password: ");
        player = sc.nextLine();
        String[] passwordBreak = player.split("\\|");
        if(!passwordBreak[3].equalsIgnoreCase("VK")) {
            return "PASSWORD INVÁLIDA";
        } else {
            return player;
        }
    }
    
    // Escolhas dentro do combate
    public Boolean choiceCombat(EntityPlayable character, EntityEnemy enemy) {
        boolean combatContinue = true;
        System.out.println("O QUE DESEJA FAZER?\n - ATACAR\n - ITEM\n - FUGIR");
        player = sc.nextLine();
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
        return sc.nextLine();
    }

    // Escolha uma habilidade para ser usada
    public String choiceSkill(EntityPlayable character, EntityEnemy enemy) {
        String skillOne = character.getNameSkillOne();
        String skillTwo = character.getNameSkillTwo();
        System.out.println("QUAL HABILIDADE VAI USAR?\n - ATACAR\n - " + character.getCustSkillOne() + " | " + skillOne + "\n - " + character.getCustSkillTwo() + " | " + skillTwo);
        player = sc.nextLine();
        if(player.equalsIgnoreCase("ATACAR")) {
            Combat.strike(character, enemy);
        } else if(player.equalsIgnoreCase(skillOne)) {
            if(character.getMana() >= character.getCustSkillOne()) { //Verificação de Mana Suficiente
                character.custMana(character.getCustSkillOne());
                System.out.println("Sua mana atual é de: " + character.getMana());
                character.skillOne(enemy);
            } else {
                System.out.println("Sem mana para usar este ataque!");
            }
        } else if(player.equalsIgnoreCase(skillTwo)) {
            if(character.getMana() >= character.getCustSkillTwo()) { //Verificação de Mana Suficiente
                character.custMana(character.getCustSkillTwo());
                character.skillTwo(enemy);
            } else {
                System.out.println("Sem mana para usar este ataque!");
            };
        }
        return player;
    }
}
