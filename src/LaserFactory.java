import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by brian on 5/8/2017.
 */
public class LaserFactory {
    private ArrayList<LaserShot> laserShotArrayList;
    private Player player;
    private boolean firing;
    private long lastFire = 1000;



    public LaserFactory(ArrayList<LaserShot> laserArray, Player player){
        laserShotArrayList = laserArray;
        this.player = player;

    }


    public void createLaser() {

        if (firing) {
            System.out.println("creating laser");
            laserShotArrayList.add(new LaserShot(7, 1, 14, 4, player.getX() + player.getShipLength(), player.getY() + player.getShipLength() / 2));
        }


    }

    public void update() {
        if((System.currentTimeMillis() - lastFire) >= player.getFireRate()) {
            // Code to move apple goes here.
            createLaser();
            lastFire = System.currentTimeMillis();
        }
    }


    public void setFiring(boolean newbool) {this.firing = newbool;}

    public void setLastFire(int newLastFire) { lastFire = newLastFire; }
}
