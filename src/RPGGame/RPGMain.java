package RPGGame;


import RPGGame.Subclasses.Warrior;

public class RPGMain {
    public static void main(String[] args) {
        Inventory inventoryPers1 = new Inventory("Onion", 50, "Health Potion");
        Character pers1 = new Character("Budimir", 25, 1000, 100);
        Warrior warriorPers1 = new Warrior(pers1.name, pers1.level, pers1.health, pers1.mana);

        Attacker attacker = new Warrior("Budimir", 25, 1000, 100);

        System.out.println(warriorPers1);
        System.out.println(attacker);


    }
}
