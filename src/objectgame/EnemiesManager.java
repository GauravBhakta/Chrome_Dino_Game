/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objectgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import util.Resource;

/**
 *
 * @author DELL E5570
 */
public class EnemiesManager {
    private List<Enemy> enemies;
    private Random random;
    
    private BufferedImage imageCactus1, imageCactus2;
    
    public EnemiesManager(){
        enemies = new ArrayList<Enemy>();
        imageCactus1 = Resource.getResourceImage("data/cactus1.png");
        imageCactus2 = Resource.getResourceImage("data/cactus2.png");
        random = new Random();
        
        enemies.add(getRandomCactus());
        random = new Random();
    }
    
    public void update(){
        for(Enemy e : enemies){
            e.update();
        }
        Enemy firstEnemy = enemies.get(0);
        if(firstEnemy.isOutOfScreen()){
            enemies.remove(firstEnemy);
            enemies.add(getRandomCactus());
        }
    }
    
    public void draw(Graphics g){
        for(Enemy e : enemies){
            e.draw(g);
        }
    }
    private Cactus getRandomCactus(){
        Cactus cactus;
        cactus = new Cactus();
        cactus.setX(600);
        if(random.nextBoolean()){
            cactus.setImage(imageCactus1);
        }else{
              cactus.setImage(imageCactus2);
        }
        return cactus;
    }
}
