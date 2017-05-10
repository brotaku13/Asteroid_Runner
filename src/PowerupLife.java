import java.awt.*;

/**
 * Created by brian on 5/10/2017.
 */
public class PowerupLife extends Powerup{
    private int height;
    private int width;
    private Color color;
    private Rectangle boundingRect;
    private int velocity = 3;

    public PowerupLife(int x_coord, int y_coord){
        setX(x_coord);
        setY(y_coord);
        color = Color.RED;
        height = width = 40;
        boundingRect = new Rectangle(getX(), getY(), width, height);

    }



    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        //g.fillRect(getX(), getY(), width, height);
        g.setFont(new Font("HelveticaNeue-CondensedBlack", Font.BOLD, 40));
        g.drawString("+", getX(), getY());
    }

    @Override
    public void update() {
        move();
        boundingRect.setRect(getX(), getY(), width, height);

    }

    public void move(){
        setX(getX()- velocity);
    }

    @Override
    public Rectangle getBoundingRect(){
        return boundingRect;
    }

    @Override
    public int getWidth(){ return width; }

    @Override
    public void performPowerUp(){
        if (Main.playerLife < 3)
            Main.playerLife += 1;
    }
}
