import javax.swing.*;
import java.awt.*;

/**
 * Created by brian on 5/9/2017.
 */
public class LifeBar extends JPanel {

    private int width;
    private int height;
    private int x_coord;
    private int y_coord;
    private Color color;
    private int playerLife;

    public LifeBar (){
        width = 210;
        height = 40;
        color = Color.WHITE;
        x_coord = Main.GAME_WIDTH - 260;
        y_coord = 30;
        playerLife = Main.playerLife;



    }


    public void draw(Graphics g){
        g.setColor(color);
        g.drawRect(x_coord, y_coord, width, height);
        for (int i = 0; i < playerLife; i++){
            g.fillRect(x_coord + (i * 70), y_coord, width / 3, height);
        }


    }

    public void update(){
        playerLife = Main.playerLife;
    }

}
