import java.awt.*;
import java.awt.geom.Area;


public abstract class Asteroid extends EnemyObjects {
    protected int life;

    public Asteroid (int newVelocity){
        super(newVelocity);
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
