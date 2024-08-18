package RPGText;

import RPGText.entity.EntityPlayable;

public class Item {
    // Método de usar algum consumível (Vida ou Mana)
    public static void usageItem(String consumables, EntityPlayable character) {
        System.out.println(consumables);
        if(consumables.equalsIgnoreCase("CURA")) {
            int heal = character.healling(5);
            System.out.println("Você curou " + heal);
        }else if(consumables.equalsIgnoreCase("MANA")) {
            int mana = character.manaRec(5);
            System.out.println("Você recuperou " + mana);
        }
    }
}
