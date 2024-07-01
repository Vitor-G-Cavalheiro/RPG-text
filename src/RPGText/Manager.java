package RPGText;

import RPGText.entity.Dragon;
import RPGText.entity.Warrior;

public class Manager {
    Warrior junior = new Warrior(3, 3, 0, 20, 5, "Rodrigo Junior");
    Dragon boss = new Dragon(5, 1, 0, 5, 20, "Deus Dragão Vermelho");

    Combat combat = new Combat(junior, boss);
    Listener listen = new Listener();
}
