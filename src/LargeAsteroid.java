
import java.util.Random;

import java.awt.*;

public class LargeAsteroid extends Asteroid{

    Random rand = new Random();
    private Rectangle boundingRect = new Rectangle(getX(), getY(), getWidth(), getLength());

    public LargeAsteroid(int height) {

        super(2, 10);

        setX(Main.GAME_WIDTH);
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
