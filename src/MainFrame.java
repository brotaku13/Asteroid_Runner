import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class MainFrame extends JPanel implements ActionListener {
    Player player;
    LaserFactory laserFactory;
    //List of enemy objects, all enemy objects inherit from EnemyObject and are contined in this list, which is drawn at every Timer Action
    ArrayList<EnemyObjects> enemyObjectList;
    ArrayList<LaserShot> laserArray;



    //collision detection object
    CollisionDetection collisionDetection = new CollisionDetection();

    //input mapping objects
    InputMap inputmap;
    ActionMap actionmap;

    //Util Timer: runs enemy Object Creation
    Timer timer;

    //Swing Timer: runs animation
    javax.swing.Timer swingTimer;


    Random rand = new Random();


    public MainFrame (){
        player = new Player();
        inputmap = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        actionmap = this.getActionMap();
        enemyObjectList = new ArrayList<>();
        laserArray = new ArrayList<>();
        laserFactory = new LaserFactory(laserArray, player);






        //instantiating Swing Timer. This is the timer that runs the animation and repainting
        swingTimer = new javax.swing.Timer(4, this);
        swingTimer.start();

        //instantiating the util Timer, this runs the gameManager and adds asteroid to the objectList
        timer = new Timer();


    }

    public void gameManager(){
        LaserFactory laserFactory = new LaserFactory(laserArray, player);

        timer.schedule(new AsteroidFactory(enemyObjectList), 0, rand.nextInt(500));

        //mapping SpaceBar
        inputmap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "SPACE");
        inputmap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "SPACE_RELEASED");
        actionmap.put("SPACE", new KeyBindings(laserFactory, "SPACE"));
        actionmap.put("SPACE", new KeyBindings(laserFactory, "SPACE_RELEASED"));

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


    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (GameObjects obj : enemyObjectList){
            obj.draw(g);
        }
        for (LaserShot laser : laserArray){
            laser.draw(g);
        }
        player.draw(g);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (GameObjects obj : enemyObjectList){
                obj.update();
            }
            laserFactory.update();

            for (LaserShot laser : laserArray){
                laser.update();
            }

            player.update();

            collisionDetection.DetectCollision(enemyObjectList, player);

            repaint();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
