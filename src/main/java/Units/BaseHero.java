package Units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class BaseHero implements BaseInterface {
    ArrayList<BaseHero> name;
    int attack, defence, maxHealth, speed, health, supply;
    int[] damage;

    Random rand = new Random();
    protected Vector2 position;


    public BaseHero(ArrayList<BaseHero> name, int attack, int defence, int[] damage, int maxHealth, int speed, int x, int y) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.health = maxHealth - rand.nextInt(maxHealth);
        this.speed = speed;
        this.supply = 0;
        this.position = new Vector2(x, y);
    }


    @Override
    public void step(ArrayList<BaseHero> heroList) {

    }

    @Override
    public String getInfo() {
        String outStr = String.format("⚔ %d\t\uD83D\uDEE1 %d\t♥%d%%\t☠%d", attack,defence,health * 100/maxHealth,(damage[0] + damage[1])/2);
        return outStr;
    }

    @Override
    public String toString() {
         return "Name: " + name + ", Type: " + getInfo() + ", Attack: " + attack + ", Defence: "
                 + defence + ", Damage: " + Arrays.toString(damage) + ", Health: "
                 + health + ", Speed: " + speed;
    }

    @Override
    public String getName() {
        return this.getClass().getName().split("\\.")[1];
    }

    @Override
    public Vector2 getPosition() {
        return this.position;
    }
}
