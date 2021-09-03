package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Resource {

    public static BufferedImage getResourceImage(String path) throws IOException {
        BufferedImage img=null;
        try{
            img= ImageIO.read(new File(path));
        }catch (IOException ex){
           ex.printStackTrace();
        }
        return img;
    }

}
