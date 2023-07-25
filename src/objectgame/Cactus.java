package objectgame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import util.Resource;

public class Cactus extends Enemy {
    
    private BufferedImage image;
    private int poaX,poaY;
    private Rectangle rect;
    
    public Cactus(){
        image = Resource.getResourceImage("data/cactus1.png");
        poaX = 200;
        poaY = 65;
        rect = new Rectangle();
    }
    
    public void update(){
        poaX -= 2;
        rect.x = poaX;
        rect.y = poaY;
        rect.width = image.getWidth();
        rect.height = image.getHeight();
    }
    
    @Override
    public Rectangle getBound(){
        return rect;
    }
    @Override
    public void draw(Graphics g){
        g.drawImage(image,poaX,poaY,null);
    }
    public void setX(int x){
        poaX = x;
    }
    public void setY(int y){
        poaY = y;
    }
    public void setImage(BufferedImage image){
        this.image = image;
    }
    @Override
    public boolean isOutOfScreen(){
        return (poaX + image.getWidth() < 0);
    }
}
