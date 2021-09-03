package objectgame;

import userinterface.GameScreen;
import util.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemiesManager {

    private List<Enemy> enemies;
    private Random random;

    private BufferedImage imageCactus1,imageCactus2;
    private MainCharacter mainCharacter;
    private GameScreen gameScreen;


    public EnemiesManager(MainCharacter mainCharacter, GameScreen gameScreen) throws IOException {
        this.gameScreen=gameScreen;
        this.mainCharacter=mainCharacter;
        enemies=new ArrayList<Enemy>();
        imageCactus1= Resource.getResourceImage("D:\\dinasour\\src\\userinterface\\data\\cactus1.png");
        imageCactus2= Resource.getResourceImage("D:\\dinasour\\src\\userinterface\\data\\cactus2.png");
        random=new Random();

        enemies.add(getRandomCactus());


    }

    public void update() throws IOException {
        for(Enemy e:enemies){
            e.update();
            if(e.isOver()&&!e.isScoreGot()){
                gameScreen.plusScore(20);
                e.setisScoreGot(true);
            }
            if(e.getBound().intersects(mainCharacter.getBound())){
                    mainCharacter.setAlive(false);

            }


        }
        Enemy firstEnemy=enemies.get(0);
        if(firstEnemy.isOutOfScreen()){
           enemies.remove(firstEnemy);
           enemies.add(getRandomCactus());
        }


    }

    public void draw(Graphics g){
        for(Enemy e:enemies){
            e.draw(g);
        }
    }
    public void reset() throws IOException {
        enemies.clear();
        enemies.add(getRandomCactus());
    }

    private Cactus getRandomCactus() throws IOException {
            Cactus cactus;
            cactus=new Cactus(mainCharacter);
            cactus.setX(600);
            if(random.nextBoolean()){
                cactus.setImage(imageCactus1);
            }
            else{
                cactus.setImage(imageCactus2);
            }
            return cactus;
    }


}
