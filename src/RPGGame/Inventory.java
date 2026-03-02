package RPGGame;

public class Inventory {
    private String weapon;
    private int armor;
    private String potions;


    public Inventory(String weapon, int armor, String potions) {
        this.weapon = weapon;
        this.armor = armor;
        this.potions = potions;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "weapon='" + weapon + '\'' +
                ", armor=" + armor +
                ", potions='" + potions + '\'' +
                '}';
    }
}
