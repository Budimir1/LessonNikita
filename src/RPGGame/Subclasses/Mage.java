package RPGGame.Subclasses;

import RPGGame.Attacker;

public class Mage implements Attacker {

    private int damageMage;

    public Mage(int damageMage) {
        this.damageMage = damageMage;
    }

    @Override
    public void attacker() {
        System.out.println("Урон мага" + damageMage);
    }
}

