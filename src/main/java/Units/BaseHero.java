package Units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class BaseHero implements BaseInterface {
    String name;
    int attack, defence, maxHealth, speed, health, supply;
    int[] damage;

    Random rand = new Random();

    public BaseHero(String name, int attack, int defence, int[] damage, int maxHealth, int speed) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.health = maxHealth - rand.nextInt(maxHealth);
        this.speed = speed;
        this.supply = 0;
    }


    @Override
    public void step(ArrayList<BaseHero> heroList) {

    }

    @Override
    public String getInfo() {
        return this.getClass().getName().split("\\.")[1] + " H" + String.valueOf(health * 100/maxHealth) + "%";
    }

    @Override
    public String toString() {
         return "Name: " + name + ", Type: " + getInfo() + ", Attack: " + attack + ", Defence: "
                 + defence + ", Damage: " + Arrays.toString(damage) + ", Health: "
                 + health + ", Speed: " + speed;
    }
}
