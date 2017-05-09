import javafx.scene.shape.Ellipse;
import java.util.Random;

import java.awt.*;
import java.awt.geom.Area;


public class LargeAsteroid extends Asteroid{

    Random rand = new Random();

    public LargeAsteroid(int height) {

        super(5);
        life = 50;
        setX(Main.WIDTH);
        setY(height);
        setLength(rand.nextInt(120) + 50);
        setWidth(rand.nextInt(120) + 50);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillRect(getX(), getY(), getWidth(), getLength());
    }

    @Override
    public Rectangle EnemyRectangle() {
        return new Rectangle(getX(), getY(), getWidth(), getLength());
    }



    @Override
    public void update() {
        move();

    }

    public void move(){
        setX(getX()- getVelocity());
    }



}
