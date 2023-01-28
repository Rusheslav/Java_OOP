package Units;

import java.util.ArrayList;

public class Monk extends Healer {
    public Monk(ArrayList<BaseHero> name, int x, int y, int gangSize) {
        super(name, 17, 12, new int[] {-4, -4}, 30, 5, 1, x, y, gangSize);
    }

}
