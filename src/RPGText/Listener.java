package RPGText;
import java.util.Scanner;

import RPGText.entity.Dragon;
import RPGText.entity.Warrior;

public class Listener {
    Scanner sc = new Scanner(System.in);

    public void startGame() {
        System.out.println("BEM VINDO AO TESTE 0.13");
        System.out.println("DIGITE JOGAR PARA INICIAR");
        String player = sc.nextLine();
    }
    
    public void choiceCombat() {
        System.out.println("O QUE DESEJA FAZER?\n - ATACAR\n - ITEM\n - FUGIR");
    }
}
