package objectgame;

import util.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Clounds {

    private BufferedImage cloundImage;
    private List<Cloud> clouds;

    public Clounds() throws IOException {
        cloundImage= Resource.getResourceImage("D:\\dinasour\\src\\userinterface\\data\\cloud.png");
        clouds=new ArrayList<Cloud>();

        Cloud cloud1=new Cloud();
        cloud1.posX=100;
        cloud1.posY=50;

        clouds.add(cloud1);

        cloud1=new Cloud();
        cloud1.posX=200;
        cloud1.posY=30;

        clouds.add(cloud1);

        cloud1=new Cloud();
        cloud1.posX=300;
        cloud1.posY=80;

        clouds.add(cloud1);

        cloud1=new Cloud();
        cloud1.posX=450;
        cloud1.posY=50;

        clouds.add(cloud1);
        cloud1=new Cloud();
        cloud1.posX=600;
        cloud1.posY=60;

        clouds.add(cloud1);


    }

    public void update(){
        for(Cloud cloud:clouds){
            cloud.posX-=2;

        }

        Cloud firstCloud=clouds.get(0);
        if(firstCloud.posX+cloundImage.getWidth()<0){
          firstCloud.posX=600;
          clouds.remove(firstCloud);
          clouds.add(firstCloud);
        }
    }

    public void draw(Graphics g){
        for(Cloud cloud:clouds){
            g.drawImage(cloundImage,(int)cloud.posX,(int)cloud.posY,null);
        }

    }

    private class Cloud{
        float posX;
        float posY;

    }
}
