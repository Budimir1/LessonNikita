package RPGGame.Subclasses;

import RPGGame.Attacker;
import RPGGame.Character;

public class Warrior extends Character implements Attacker {
    private int powerHit;

    public Warrior(String name, int level, int health, int mana) {
        super(name, level, health, mana);
        this.powerHit = 30;
    }

    @Override
    public void attacker(String target) {
        int damage = powerHit + 20;
        System.out.println(name + " атакует менчом! " + damage);
        health -= damage;
    }
}