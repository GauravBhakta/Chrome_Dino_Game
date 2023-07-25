package chromedinogame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GameWindow extends JFrame {
    
    private GameScreen gameScreen;

    public GameWindow() {
        super("Java T-rex Game");
        setSize(600, 175);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameScreen = new GameScreen();
        add(gameScreen);
        addKeyListener(gameScreen);
    }
    
    public void startGame(){
        gameScreen.startGame();
        
    }

    public static void main(String[] args) {
        GameWindow gw = new GameWindow();
        gw.setVisible(true);
        gw.startGame();
    }


}
