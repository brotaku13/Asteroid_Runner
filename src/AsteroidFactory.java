import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by brian on 5/4/2017.
 */
public class AsteroidFactory extends TimerTask {

    private Random rand = new Random();
    ArrayList<EnemyObjects> enemyObjects;

    public AsteroidFactory(ArrayList<EnemyObjects> enemyObjectList) {
        enemyObjects = enemyObjectList;
    }


    @Override
    public void run() {
        int creationProbability = rand.nextInt(10);

        if (creationProbability < 5)
            enemyObjects.add(new MediumAsteroid(rand.nextInt(Main.HEIGHT)));
        else if (creationProbability <= 10 && creationProbability >= 5)
            enemyObjects.add(new LargeAsteroid(rand.nextInt(Main.HEIGHT)));

    }
}
