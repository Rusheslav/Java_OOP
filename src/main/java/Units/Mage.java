package Units;

import java.util.ArrayList;

public class Mage extends Healer {

    public Mage(ArrayList<BaseHero> name, int x, int y, int gangSize) {
        super(name, 17, 12, new int[] {-5, -5}, 30, 9,1, x, y, gangSize);
    }


}
