
import java.util.Random;

import java.awt.*;

public class LargeAsteroid extends Asteroid{

    Random rand = new Random();
    private Rectangle boundingRect = new Rectangle(getX(), getY(), getWidth(), getLength());
    private Color color = new Color(118, 135, 131);

    public LargeAsteroid(int height) {

        super(7);

        setX(Main.GAME_WIDTH);
        setY(height);
        setLength(rand.nextInt(120) + 50);
        setWidth(rand.nextInt(120) + 50);
        setVelocity(rand.nextInt(5 - 2) + 2);
        setPoints(getLength() * getWidth() / 10);


    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(color);
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
