import java.awt.*;

/**
 * Created by brian on 5/10/2017.
 */
public class Points {
    private int x_coord;
    private int y_coord;
    private String pointAmount;

    public Points(){
        x_coord = 50;
        y_coord = 50;
        pointAmount = Integer.toString(Main.points);
    }

    public void draw(Graphics g){
        g.setFont(new Font("SansSerif Plain", Font.PLAIN, 40));
        g.setColor(Color.WHITE);
        g.drawString(pointAmount, x_coord, y_coord);

    }

    public void update(){
        pointAmount = Integer.toString(Main.points);
    }
}
