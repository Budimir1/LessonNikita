package RPGGame;

public class Character {
    private int health;
    private int mana;
    private int level;
    private String name;
    private Inventory inventory;
    private Subclasses subclasses;


    public Character(int health, int mana, int level, String name, Inventory inventory, Subclasses subclasses) {
        this.health = health;
        this.mana = mana;
        this.level = level;
        this.name = name;
        this.inventory = inventory;
        this.subclasses = subclasses;
    }

    @Override
    public String toString() {
        return "Name" + name + "Subclasses" + subclasses + "Level" + level + "Health" + health + "Mana" + mana + "Inventory: "  + "\n" + inventory;
    }
}
