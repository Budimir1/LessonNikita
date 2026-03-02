package RPGGame.Subclasses;

import RPGGame.Attacker;

public class Archer implements Attacker {

    private int damageArcher;

    public Archer(int damageArcher) {
        this.damageArcher = damageArcher;
    }

    @Override
    public void attacker() {
        System.out.println("Урон лучника" + damageArcher);
    }
}
