public class App {
    public static void main(String[] args) throws Exception {
        Warrior junior = new Warrior(3, 0, 0, 2, 5);
        Dragon boss = new Dragon(5, 1, 0, 5, 20);

        Combat combat = new Combat(junior, boss);

        combat.combatStart();
    }
}
