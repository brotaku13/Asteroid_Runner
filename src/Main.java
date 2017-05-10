import javax.swing.*;
import java.awt.*;

/**
 * Created by brian on 5/3/2017.
 */
public class Main {
    public static final int WINDOW_HEIGHT = 920;
    public static final int WINDOW_WIDTH = 1400;


    public static final int GAME_HEIGHT = 780;
    public static final int GAME_WIDTH = 1360;

    public static final int UI_HEIGHT = 100;

    public static int playerLife = 3;
    public static int points = 0;





    public static void main(String[] args) {

        JFrame gameFrame = new JFrame("Asteroid Runner");
        gameFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
        gameFrame.setBackground(Color.DARK_GRAY);

        JPanel pane = new JPanel(new GridBagLayout());
        pane.setBackground(Color.DARK_GRAY);

        GridBagConstraints c = new GridBagConstraints();

        GameUI gameUI = new GameUI();
        gameUI.setPreferredSize(new Dimension(GAME_WIDTH, UI_HEIGHT));
        gameUI.setBackground(Color.BLACK);
        gameUI.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));

        //c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 20, 0, 20);
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 1.0;
        c.weightx = 1.0;

        pane.add(gameUI, c);

        MainFrame mainframe = new MainFrame();
        mainframe.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        mainframe.setBackground(Color.BLACK);
        mainframe.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 20, 20, 20);
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 1.0;
        c.weightx = 1.0;

        pane.add(mainframe, c);


        gameFrame.add(pane);
        gameFrame.pack();
        gameFrame.setVisible(true);

        mainframe.gameManager();

    }
}
