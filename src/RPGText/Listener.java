package RPGText;
import java.util.Scanner;

public class Listener {
    Scanner sc = new Scanner(System.in);

    public String loadingScreen() {
        System.out.println("BEM VINDO AO TESTE 0.14");
        System.out.println("DIGITE JOGAR PARA INICIAR");
        String player = sc.nextLine();
        return player;
    }

    public String nameCharacter() {
        System.out.println("NOMEIE SEU PERSONAGEM: ");
        String player = sc.nextLine();
        return player;
    }
    
    public String choiceCombat() {
        System.out.println("O QUE DESEJA FAZER?\n - ATACAR\n - ITEM\n - FUGIR");
        String player = sc.nextLine();
        return player;
    }

    public String choiceItem() {
        System.out.println("QUAL ITEM DESEJA USAR?\n - CURA\n - MANA");
        String item = sc.nextLine();
        return item;
    }
}
