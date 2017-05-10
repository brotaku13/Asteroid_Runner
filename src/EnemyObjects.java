import java.awt.Rectangle;


/**
 * Created by brian on 5/3/2017.
 */
public abstract class EnemyObjects extends GameObjects {
    private int velocity;
    protected int length;
    protected int width;
    protected int life;
    private int points;


    public EnemyObjects( int newLife){

        life = newLife;
    }


    public void setVelocity(int newVelocity) { velocity = newVelocity; }

    public abstract Rectangle EnemyRectangle();

    public int getVelocity() { return velocity; }
    public int getLength() { return length; }
    public int getWidth() { return width; }
    public void setLength( int newLength) { length = newLength; }
    public void setWidth(int newWidth) { width = newWidth; }
    public int getPoints(){ return points; }
    public void setPoints(int pointAmount) { this.points = pointAmount; }


}
