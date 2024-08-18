package RPGText;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import RPGText.entity.EntityPlayable;
import RPGText.entity.player.Warrior;
import RPGText.entity.player.Mage;

public class Choice {
    private static List<String> types = Arrays.asList (
        "WARRIOR",
        "MAGE"
    );

    static Scanner sc = new Scanner(System.in);

    public static String typeShowcase() {
        
        System.out.println("Escolha sua classe: ");
        for(String i : types) {
            System.out.println(" - " + i);
        }
        return sc.nextLine();
    }

    // Leitor de Classe/Tipo
    public static EntityPlayable typeReader(String type) {
        if(type.equalsIgnoreCase("WAR")) {
            return new Warrior();
        } else if(type.equalsIgnoreCase("MAG")) { 
            return new Mage();
        }   else {
            return new Warrior();
        }
    }
}
