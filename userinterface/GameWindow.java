package userinterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow  extends JFrame {

    private GameScreen gameScreen;

    public GameWindow() throws IOException {
        super("Java T-Rex game");
        setSize(600,175);
        setLocation(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameScreen=new GameScreen();
        add(gameScreen);
        addKeyListener(gameScreen);
    }

    public void startGame(){
        gameScreen.startGame();
    }

    public static void main(String[] args) throws IOException {
       GameWindow gw=new GameWindow();
       gw.setVisible(true);
        gw.startGame();

    }
    /*public void paint(Graphics g){
        super.paint(g);
        BufferedImage image=null;
        try {
            image= ImageIO.read(new File("D:\\dinasour\\src\\userinterface\\data\\cactus1.png"));
            g.drawImage(image,100,100,null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

}
