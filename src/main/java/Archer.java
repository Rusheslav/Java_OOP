import java.util.ArrayList;

public class Archer extends BaseHero {
    Integer shoots;
    public Archer(String name, int attack, int defence, int[] damage, int maxHealth, int speed, int shoots) {
        super(name, attack, defence, damage, maxHealth, speed);
        this.shoots = shoots;
    }

    @Override
    public String toString() {
        return super.toString() + ", Shoots " + shoots;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {

    }
}
