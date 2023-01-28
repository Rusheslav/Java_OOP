package Units;

import java.util.ArrayList;

public class Spearman extends Soldier {

    public Spearman(ArrayList<BaseHero> name, int x, int y, int gangSize) {
        super(name, 4, 5, new int[] {1, 3}, 10, 4, x, y, gangSize);
    }
}
