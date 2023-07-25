package chromedinogame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;
import objectgame.Cactus;
import objectgame.Clouds;
import objectgame.EnemiesManager;
import objectgame.Land;
import objectgame.MainCharacter;

public class GameScreen extends JPanel implements Runnable, KeyListener {

    public static final float GRAVITY = 0.1f;
    public static final float GROUNDY = 110; //by pxel

    private MainCharacter mainCharacter;
    private Thread thread;
    private Land land;
    private Clouds clouds;
    private EnemiesManager enemiesManager;
    

    public GameScreen() {
        thread = new Thread(this);
        mainCharacter = new MainCharacter();
        mainCharacter.setX(50);
        land = new Land(this);
        clouds = new Clouds();
        enemiesManager =new EnemiesManager();
    }

    public void startGame() {
        thread.start();
    }

    @Override
    public void run() {
        while (true) {

            try {
                mainCharacter.update();
                land.update();
                clouds.update();
                enemiesManager.update();
                repaint();
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.decode("#f7f7f7"));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        g.drawLine(0, (int) GROUNDY, getWidth(), (int) GROUNDY);
        clouds.draw(g);
        land.draw(g);
        mainCharacter.draw(g);
        enemiesManager.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        mainCharacter.jump();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released");
    }

}
