import java.awt.*;


public class PowerupLaserLevel extends Powerup {
    private int height;
    private int width;
    private Color color;
    private Rectangle boundingRect;
    private int velocity = 3;

    public PowerupLaserLevel(int x_coord, int y_coord){
        setX(x_coord);
        setY(y_coord);
        color = Color.CYAN;
        height = width = 20;
        boundingRect = new Rectangle(getX(), getY(), width, height);

    }




    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        //g.fillRect(getX(), getY(), width, height);
        g.setFont(new Font("HelveticaNeue-CondensedBlack", Font.BOLD, 30));
        g.drawString(">", getX(), getY());
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
    public Rectangle getBoundingRect() {
        return boundingRect;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void performPowerUp(){
        Main.laserLevel += 1;
    }
}
