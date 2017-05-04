import javax.swing.*;
import java.awt.*;

/**
 * Created by brian on 5/3/2017.
 */
public class Main {

    public static final int HEIGHT = 900;
    public static final int WIDTH = 1400;




    public static void main(String[] args) {
        JFrame gameFrame = new JFrame();
        MainFrame mainframe = new MainFrame();

        gameFrame.setBounds(10, 10, WIDTH, HEIGHT);
        gameFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
        gameFrame.setBackground(Color.DARK_GRAY);
        gameFrame.setResizable(true);
        gameFrame.setVisible(true);

        mainframe.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        mainframe.setBackground(Color.DARK_GRAY);
        mainframe.setVisible(true);


        gameFrame.add(mainframe);
        gameFrame.pack();

    }
}
