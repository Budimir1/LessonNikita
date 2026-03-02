package RPGGame.Subclasses;

import RPGGame.Attacker;

public class Warrior implements Attacker {

    private int damageWarrior;

    public Warrior(int damageWarrior) {
        this.damageWarrior = damageWarrior;
    }

    @Override
    public void attacker() {
        System.out.println("Урон воина" + damageWarrior);
    }
}
