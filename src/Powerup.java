import java.awt.*;

/**
 * Created by brian on 5/10/2017.
 */
public abstract class Powerup extends GameObjects {

    public abstract Rectangle getBoundingRect();
    public abstract int getWidth();



    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void update() {

    }

    public void performPowerUp(){

    }
}
