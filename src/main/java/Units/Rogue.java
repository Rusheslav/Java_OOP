package Units;

import java.util.ArrayList;

public class Rogue extends Soldier {
    public Rogue(ArrayList<BaseHero> name, int x, int y, int gangSize) {
        super(name, 8, 3, new int[] {2, 4}, 10, 6, x, y, gangSize);
    }
}
