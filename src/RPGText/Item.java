package RPGText;

import RPGText.entity.Entity;

public class Item {
    public void usageItem(String consumables, Entity character) {
        System.out.println(consumables);
        if(consumables.equals("CURA")){
            int heal = character.healling(5);
            System.out.println("Você curou " + heal);
        }else if(consumables.equals("MANA")){

        }
    }
}
