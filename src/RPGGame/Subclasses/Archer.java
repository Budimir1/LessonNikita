package RPGGame.Subclasses;

import RPGGame.Attacker;
import RPGGame.Character;
import RPGGame.Inventory;

public class Archer extends Character implements Attacker {
    private int shot;

    public Archer(String name, int level, int health, int mana) {
        super(name, level, health, mana);
        this.shot = 20;
    }

    @Override
    public void attacker(String target) {
        int damage = shot + 20;
        System.out.println(name + " стреляет из лука! "  + damage);
    }
}
