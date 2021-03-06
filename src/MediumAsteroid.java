
import java.util.Random;

import java.awt.*;

public class MediumAsteroid extends Asteroid{
    Random rand = new Random();
    private Rectangle boundingRect = new Rectangle(getX(), getY(), getWidth(), getLength());
    private Color color = new Color(234, 255, 251);

    public MediumAsteroid(int height) {

        super(3);
        setX(Main.GAME_WIDTH);
        setY(height);
        setLength(rand.nextInt(50) + 20);
        setWidth(rand.nextInt(50) + 20);
        setVelocity(rand.nextInt(10 - 5) + 2);
        setPoints((getLength() * getWidth()) / 10);
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
