import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by brian on 5/8/2017.
 */
public class LaserFactory {
    private ArrayList<LaserShot> laserShotArrayList;
    private Player player;
    private boolean firing;


    public LaserFactory(ArrayList<LaserShot> laserArray, Player player){
        laserShotArrayList = laserArray;
        this.player = player;
        firing = false;
    }


    public void createLaser() {
        if (firing){
            System.out.println("creating laser");
            laserShotArrayList.add(new LaserShot(5, 1, 14, 4, player.getX() + player.getShipLength(), player.getY()));

        }
       // laserShotArrayList.add(new LaserShot(5, 1, 14, 4, player.getX() - player.getShipLength(), player.getY()));

    }

    public void update() {
        createLaser();
    }


    public void setFiring(boolean newbool) {
        firing = newbool;
    }

}
