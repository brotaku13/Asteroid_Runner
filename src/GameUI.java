import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by brian on 5/9/2017.
 */
public class GameUI extends MainFrame {

    LifeBar lifeBar = new LifeBar();
    Points pointShow = new Points();



    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        lifeBar.draw(g);
        pointShow.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lifeBar.update();
        pointShow.update();
        repaint();
    }
}
