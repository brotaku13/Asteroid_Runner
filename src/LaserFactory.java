
import java.util.ArrayList;

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
            laserShotArrayList.add(new LaserShot(7, 1, 14, 4, player.getX() + player.getShipLength(), player.getY() + player.getShipLength() / 2));
        }


    }

    public void update() {
        if((System.currentTimeMillis() - lastFire) >= player.getFireRate()) {
            createLaser();
            lastFire = System.currentTimeMillis();
        }
    }


    public void setFiring(boolean newbool) {this.firing = newbool;}

    public void setLastFire() { lastFire = 1000; }
}
