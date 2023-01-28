package Units;

import java.util.ArrayList;

public interface BaseInterface {
    void step(ArrayList<BaseHero> heroList);
    String getInfo();
    String getName();
    Vector2 getPosition();
}
