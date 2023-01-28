package Units;

import java.util.ArrayList;

public class Crossbowman extends Archer {

    public Crossbowman(ArrayList<BaseHero> name, int x, int y, int gangSize) {
        super(name, 6, 3, new int[] {2, 3}, 10,4, 16, x, y, gangSize);
    }
}
