import javafx.scene.shape.Ellipse;
import java.util.Random;

import java.awt.*;
import java.awt.geom.Area;

/**
 * Created by brian on 5/4/2017.
 */
public class MediumAsteroid extends Asteroid{
    Random rand = new Random();
    private Rectangle boundingRect = new Rectangle(getX(), getY(), getWidth(), getLength());


    public MediumAsteroid(int height) {

        super(5, 5);
        setX(Main.WIDTH);
        setY(height);
        setLength(rand.nextInt(50) + 20);
        setWidth(rand.nextInt(50) + 20);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillRect(getX(), getY(), getWidth(), getLength());
    }

    @Override
    public Rectangle EnemyRectangle() {
        return boundingRect;
    }



    @Override
    public void update() {
        move();
        boundingRect.setRect(getX(), getY(), getWidth(), getLength());

    }

    public void move(){
        setX(getX()- getVelocity());
    }



}
