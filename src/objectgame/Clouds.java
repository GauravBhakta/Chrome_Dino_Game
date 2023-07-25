package objectgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import util.Resource;

public class Clouds {

    private BufferedImage cloudImage;
    
    private List<Cloud> clouds;
    
    public Clouds() {
        cloudImage = Resource.getResourceImage("data/cloud.png");
        clouds = new ArrayList<Cloud>();
        
        Cloud cloud1 = new Cloud();
        cloud1.poaX = 100;
        cloud1.poaY = 50;
        clouds.add(cloud1);
        
        cloud1 = new Cloud();
        cloud1.poaX = 200;
        cloud1.poaY = 30;
        clouds.add(cloud1);
        
        cloud1 = new Cloud();
        cloud1.poaX = 300;
        cloud1.poaY = 80;
        clouds.add(cloud1);
        
        cloud1 = new Cloud();
        cloud1.poaX = 450;
        cloud1.poaY = 50;
        clouds.add(cloud1);
        
        cloud1 = new Cloud();
        cloud1.poaX = 600;
        cloud1.poaY = 60;
        clouds.add(cloud1);
        
    }
    
    public void update(){
        for(Cloud cloud : clouds){
            cloud.poaX--;
        }
        Cloud firstCloud = clouds.get(0);
        if(firstCloud.poaX + cloudImage.getWidth() < 0){
            firstCloud.poaX = 600;
            clouds.remove(firstCloud);
            clouds.add(firstCloud);
        }
    }

    public void draw(Graphics g) {
        for(Cloud cloud : clouds){
        g.drawImage(cloudImage, (int)cloud.poaX, (int)cloud.poaY, null);
        }
    }

    private class Cloud {

        float poaX;
        float poaY;

    }
}
