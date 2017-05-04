import java.awt.*;


/**
 * Created by brian on 5/3/2017.
 */
public class Player extends GameObjects {

    private int speed;
    private int shipLength = 20;




    private boolean up, down, left, right;

    public Player (){
        setX(Main.HEIGHT / 2);
        setY(Main.WIDTH / 3);
        speed = 10;
    }

    public void update(){
        move();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        //g.fillRect(getX(), getY(), 25, 25);
        int[] shipXarr = {this.getX() + shipLength, this.getX() - (shipLength / 4), this.getX(), this.getX() - (shipLength / 4)};
        int[] shipYarr = {this.getY(), this.getY() - (shipLength / 2), this.getY(), this.getY() + (shipLength / 2)};
        int shipNumPts = 4;
        g.fillPolygon(shipXarr, shipYarr, shipNumPts);

    }

    public void move(){


        if (up) {
            setY(this.getY() - speed);
        }
        if (down) {
            setY(this.getY() + speed);
        }
        if (right) {
            setX(this.getX() + speed);
        }
        if (left) {
            setX(this.getX() - speed);
        }

    }

    public void setUP(boolean newUp) {up = newUp;}
    public void setDOWN(boolean newDown) {down = newDown;}
    public void setRIGHT(boolean newRight) {right = newRight;}
    public void setLEFT(boolean newLeft) {left = newLeft;}
}
