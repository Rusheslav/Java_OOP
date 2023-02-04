package Units;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class BaseHero implements BaseInterface {
    public ArrayList<BaseHero> name;
    protected int attack, defence, maxHealth, supply, gangSize;
    public float health;
    public int speed;
    protected int[] damage;
    protected Vector2 position;
    public String type;


    public BaseHero(ArrayList<BaseHero> name, int attack, int defence, int[] damage, int maxHealth, int speed, int x, int y, int gangSize) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.speed = speed;
        this.supply = 0;
        this.position = new Vector2(x, y);
        this.gangSize = gangSize;
        this.type = this.getClass().getName().split("\\.")[1];
    }


    @Override
    public void step(ArrayList<BaseHero> heroList) {

    }

    @Override
    public String getInfo() {
        String outStr = String.format("\t%-3s\t⚔ %-3d\t\uD83D\uDEE1 %-3d\t♥%-3d%%\t☠%-3d\t        ", type, attack,defence,(int) health * 100/maxHealth,(damage[0] + damage[1])/2);
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
