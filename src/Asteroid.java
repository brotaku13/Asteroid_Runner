import java.awt.*;
import java.awt.geom.Area;


public abstract class Asteroid extends EnemyObjects {


    public Asteroid (int newLife){
        super(newLife);

    }

    @Override
    public abstract Rectangle EnemyRectangle();

    @Override
    public void update(){

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);

    }
}
