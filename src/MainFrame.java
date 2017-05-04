import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by brian on 5/3/2017.
 */
public class MainFrame extends JPanel implements ActionListener {
    Player player;

    InputMap inputmap;
    ActionMap actionmap;

    Timer t;

    public MainFrame (){
        player = new Player();
        inputmap = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        actionmap = this.getActionMap();

        // mapping up
        inputmap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "UP");
        inputmap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "UP_RELEASED");// key released
        actionmap.put("UP", new KeyBindings(player, "UP"));
        actionmap.put("UP_RELEASED", new KeyBindings(player, "UP_RELEASED"));

        //mapping down
        inputmap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "DOWN");
        inputmap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "DOWN_RELEASED");
        actionmap.put("DOWN", new KeyBindings(player, "DOWN"));
        actionmap.put("DOWN_RELEASED", new KeyBindings(player, "DOWN_RELEASED"));

        //mapping right
        inputmap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "RIGHT");
        inputmap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "RIGHT_RELEASED");
        actionmap.put("RIGHT", new KeyBindings(player, "RIGHT"));
        actionmap.put("RIGHT_RELEASED", new KeyBindings(player, "RIGHT_RELEASED"));

        //mapping left
        inputmap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "LEFT");
        inputmap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "LEFT_RELEASED");
        actionmap.put("LEFT", new KeyBindings(player, "LEFT"));
        actionmap.put("LEFT_RELEASED", new KeyBindings(player, "LEFT_RELEASED"));


        t = new Timer(1, this);
        t.start();

    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        player.draw(g);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        repaint();
    }
}
