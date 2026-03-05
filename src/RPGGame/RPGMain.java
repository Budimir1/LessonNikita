package RPGGame;


import RPGGame.Subclasses.Warrior;

public class RPGMain {
    public static void main(String[] args) {

        Character pers1 = new Character("Budimir", 1, 100, 100000000);

        Attacker pers2 = new Warrior("Nikita", 100, 1000, 10000);

        pers2.attacker("Budimir");

        System.out.println(pers1);
        System.out.println(pers2);


    }
}
