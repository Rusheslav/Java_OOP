package Units;

import java.util.ArrayList;

public class Sniper extends Archer{
    public Sniper(ArrayList<BaseHero> name, int x, int y, int gangSize) {
        super(name, 12, 10, new int[] {8, 10}, 15, 9, 32, x, y, gangSize);
    }
}
