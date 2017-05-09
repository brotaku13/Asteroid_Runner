import javafx.scene.shape.Ellipse;

import java.awt.*;
import java.awt.geom.Area;


/**
 * Created by brian on 5/3/2017.
 */
public class Player extends GameObjects {

    private int speed;
    public int shipSize = 40;
    private boolean up, down, left, right;

    public Player (){
        setX(Main.HEIGHT / 2);
        setY(Main.WIDTH / 3);
        speed = 10;
    }


    @Override
    public void update(){
        move();
    }


    @Override
    public void draw(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(getX(), getY(), shipSize, shipSize);


    }

    public Rectangle shipRectangle(){
        return new Rectangle(getX(), getY(), shipSize, shipSize);
    }


    public void move(){
        /*
        controls moving up, and bounds it to more than height = 0
         */
        if (getY() >= 0) {
            if (up) {
                setY(this.getY() - speed);
            }
        } else {setY(0);}

        /*
        controls moving down, and bounds it to more than height = main.HEIGHT
         */
        if (getY() <= Main.HEIGHT) {
            if (down) {
                setY(this.getY() + speed);
            }
        } else {setY(Main.HEIGHT);}

        /*
        controls moving right, and bounds it to more than length = main.WIDTH
         */
        if (getX() <= Main.WIDTH) {
            if (right) {
                setX(this.getX() + speed);
            }
        } else {setX(Main.WIDTH);}

        /*
        controls moving left, and bounds it to more than length = 0
         */
        if (getX() >= 0) {
            if (left) {
                setX(this.getX() - speed);
            }
        } else {setX(0);}

    }



    public void setUP(boolean newUp) {up = newUp;}
    public void setDOWN(boolean newDown) {down = newDown;}
    public void setRIGHT(boolean newRight) {right = newRight;}
    public void setLEFT(boolean newLeft) {left = newLeft;}

    public int getShipLength() { return shipSize; }
    public void setShipLength( int newShipLength) { this.shipSize = newShipLength; }

}
