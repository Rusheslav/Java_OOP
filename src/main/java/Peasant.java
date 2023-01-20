import java.util.ArrayList;

public class Peasant extends BaseHero{
    int supply;
    public Peasant(String name, int attack, int defence, int[] damage, int maxHealth, int speed, int supply) {
        super(name, attack, defence, damage, maxHealth, speed);
        this.supply = supply;
    }

    public Peasant(String name) {
        super(name, 1, 1, new int[] {1, 1}, 1, 3);
        this.supply = 1;
    }

    @Override
    public String toString() {
        return super.toString() + ", Supply";
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {

    }
}
