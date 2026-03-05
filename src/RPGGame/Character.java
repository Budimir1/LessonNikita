package RPGGame;

public class Character {

    public String name;
    public int level;
    public int health;
    public int mana;

    public Character(String name, int level, int health, int mana) {
        this.health = health;
        this.mana = mana;
        this.level = level;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name " + name + "\n" + "Level " + level + "\n" + "Health " + health + "\n" + "Mana " + mana;
    }
}
