package Units;

import java.util.ArrayList;

public class Peasant extends BaseHero{
    public Peasant(String name, int attack, int defence, int[] damage, int maxHealth, int speed) {
        super(name, attack, defence, damage, maxHealth, speed);
    }

    public Peasant(String name) {
        super(name, 1, 1, new int[] {1, 1}, 1, 3);
        this.supply = 1;
    }

    @Override
    public String toString() {
        if (this.supply == 1) {
            return super.toString() + ", Supply";
        } else {
            return super.toString();
        }
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        if (this.supply == 0) {
            this.supply = 1;
        }
    }

    @Override
    public String getInfo() {
        return this.getClass().getName().split("\\.")[1] + " H" + String.valueOf(health * 100/maxHealth) + "%" + " Sup" + this.supply;
    }
}
