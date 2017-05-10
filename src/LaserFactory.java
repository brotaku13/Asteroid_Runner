
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
        switch(Main.laserLevel){
            case(0):
                if (firing) {
                    laserShotArrayList.add(new LaserShot(7, 1, 14, 4, player.getX() + player.getShipLength(), player.getY() + player.getShipLength() / 2));
                }
                break;
            case(1):
                if (firing) {
                    laserShotArrayList.add(new LaserShot(7, 1, 14, 10, player.getX() + player.getShipLength(), player.getY() + player.getShipLength() / 2));
                }
                break;
            case(2):
                if (firing) {
                    laserShotArrayList.add(new LaserShot(14, 1, 4, 4, player.getX() + player.getShipLength(), player.getY() + player.getShipLength() / 2));
                }
                break;
            case(3):
                if (firing) {
                    laserShotArrayList.add(new LaserShot(7, 1, 4, 4, player.getX() + player.getShipLength(), player.getY()));
                    laserShotArrayList.add(new LaserShot(7, 1, 4, 4, player.getX() + player.getShipLength(), player.getY() + player.getShipLength()));

                }
                break;


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
