import java.awt.*;

/**
 * Created by brian on 5/3/2017.
 */
public abstract class GameObjects {
    private int x_coord;
    private int y_coord;

    public int getX() {return this.x_coord;}
    public void setX(int newX) {this.x_coord = newX;}
    public int getY() {return this.y_coord; }
    public void setY(int newY) { this.y_coord = newY;}


    public abstract void draw(Graphics g);
    public abstract void update();


}
