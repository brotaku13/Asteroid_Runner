
import java.util.ArrayList;

public class CollisionDetection {

    public CollisionDetection (){

    }

    public void DetectCollision(ArrayList<EnemyObjects> enemyObjectList, ArrayList<LaserShot> laserArray,  Player player){
        for (int i = 0; i < enemyObjectList.size(); i++){
            if (!laserArray.isEmpty()){
                for (int j = 0; j < laserArray.size(); j++){
                    if(enemyObjectList.get(i).EnemyRectangle().intersects(laserArray.get(j).laserRect())){

                        enemyObjectList.get(i).life -= 1;
                        laserArray.remove(j);
                    }
                }
            }
            if(enemyObjectList.get(i).EnemyRectangle().intersects(player.shipRectangle()) ||
                    enemyObjectList.get(i).life <= 0 ||
                    enemyObjectList.get(i).getX() + enemyObjectList.get(i).getLength() < 0)
            {
                if(enemyObjectList.get(i).EnemyRectangle().intersects(player.shipRectangle())){

                    if(Main.playerLife > 0){
                        Main.playerLife -= 1;

                    }
                }

                enemyObjectList.remove(i);

            }

        }
        if (!laserArray.isEmpty()){
            for (int i = 0; i < laserArray.size(); i++){
                if (laserArray.get(i).getX() > Main.GAME_WIDTH){
                    laserArray.remove(i);

                }
            }
        }


    }

}
