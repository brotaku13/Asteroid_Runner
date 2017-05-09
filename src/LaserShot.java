import java.awt.*;

public class LaserShot extends GameObjects{
    private int fireSpeed;
    private int power;
    private int length;
    private int height;

    public LaserShot(int newFireSpeed, int newPower, int newLength, int newHeight, int x_coord, int y_coord){
        height = newHeight;
        length = newLength;
        fireSpeed = newFireSpeed;
        power = newPower;
        this.setX(x_coord);
        this.setY(y_coord);
    }


    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(getX(), getY(), length, height);
    }

    @Override
    public void update() {
        move();
    }

    public void move(){
        setX(getX() + fireSpeed);
    }
}
