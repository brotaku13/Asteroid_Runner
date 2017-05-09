import java.awt.*;
import java.awt.geom.Area;
import java.util.ArrayList;

/**
 * Created by brian on 5/4/2017.
 */
public class CollisionDetection {

    public CollisionDetection (){

    }

    public void DetectCollision(ArrayList<EnemyObjects> enemyObjectList, ArrayList<LaserShot> laserArray,  Player player){
        for (int i = 0; i < enemyObjectList.size(); i++){
            if(enemyObjectList.get(i).EnemyRectangle().intersects(player.shipRectangle())){
                enemyObjectList.remove(i);
            }
            if(enemyObjectList.get(i).getX() + enemyObjectList.get(i).getLength() < 0){
                enemyObjectList.remove(i);
            }
        }
    }

}
