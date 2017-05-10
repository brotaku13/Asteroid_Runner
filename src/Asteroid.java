import java.awt.*;
import java.awt.geom.Area;


public abstract class Asteroid extends EnemyObjects {
    private int points;

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

    }

    public int getPoints(){ return points; }
    public void setPoints(int pointAmount) { this.points = pointAmount; }
}
