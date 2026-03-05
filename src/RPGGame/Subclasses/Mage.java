package RPGGame.Subclasses;

import RPGGame.Attacker;
import RPGGame.Character;

public class Mage extends Character implements Attacker {

    private int spellPower;

    public Mage(String name, int level, int health, int mana) {
        super(name, level, health, mana);
        this.spellPower = 15;
    }


    @Override
    public void attacker(int target) {
        int damage = spellPower + 20;
        if (mana > 50) {
            mana -= 50;
            System.out.print(name + " кидает огненный шар! "  + damage);
        }System.out.print(name + " маны не хватает");

    }
}