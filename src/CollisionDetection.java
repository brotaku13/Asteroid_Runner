
import java.util.ArrayList;
import java.util.Random;

public class CollisionDetection {
    Random rand = new Random();
    public CollisionDetection (){

    }

    public void DetectCollision(ArrayList<EnemyObjects> enemyObjectList, ArrayList<LaserShot> laserArray, ArrayList<Powerup> powerupArray, Player player){
        for (int i = 0; i < enemyObjectList.size(); i++){
            if (!laserArray.isEmpty()){
                for (int j = 0; j < laserArray.size(); j++){
                    if(enemyObjectList.get(i).EnemyRectangle().intersects(laserArray.get(j).laserRect())){
                        enemyObjectList.get(i).life -= 1;
                        if (enemyObjectList.get(i).life == 0){
                            int powerUpChance = rand.nextInt(100);
                            if (powerUpChance > 5 && powerUpChance <= 40){
                                powerupArray.add(new PowerupLife(enemyObjectList.get(i).getX(), enemyObjectList.get(i).getY()));
                            }
                            else if (powerUpChance >= 0 && powerUpChance <= 5){
                                powerupArray.add(new PowerupLaserLevel(enemyObjectList.get(i).getX(), enemyObjectList.get(i).getY()));

                            }
                        }
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
                    if(Main.laserLevel > 0){
                        Main.laserLevel -= 1;

                    }
                }
                if (enemyObjectList.get(i).life <= 0){
                    Main.points += enemyObjectList.get(i).getPoints();
                }

                enemyObjectList.remove(i);

            }
            for(int j = 0; j < powerupArray.size(); j++){
                if (powerupArray.get(j).getBoundingRect().intersects(player.shipRectangle())){
                    powerupArray.get(i).performPowerUp();
                    powerupArray.remove(j);
                }
            }

        }
        if (!laserArray.isEmpty()){
            for (int i = 0; i < laserArray.size(); i++){
                if (laserArray.get(i).getX() > Main.GAME_WIDTH){
                    laserArray.remove(i);

                }
            }
        }
        if (!powerupArray.isEmpty()){
            for (int i = 0; i < powerupArray.size(); i++){
                if (powerupArray.get(i).getX() + powerupArray.get(i).getWidth() < 0){
                    powerupArray.remove(i);
                }
            }
        }


    }

}
