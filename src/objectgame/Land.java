package objectgame;

import chromedinogame.GameScreen;
import static chromedinogame.GameScreen.GROUNDY;
import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;
import util.Resource;
import java.util.List;
import java.util.Random;

public class Land {

    private List<ImageLand> listImage;
    private BufferedImage imageLand1, imageLand2, imageLand3;
    private Random random;

    public Land(GameScreen game) {
        random = new Random();
        imageLand1 = Resource.getResourceImage("data/land1.png");
        imageLand2 = Resource.getResourceImage("data/land2.png");
        imageLand3 = Resource.getResourceImage("data/land3.png");
        listImage = new ArrayList<ImageLand>();
        int numberOfLandTitle = 600 / imageLand1.getWidth() + 2;
        for (int i = 0; i < numberOfLandTitle; i++) {
            ImageLand imageLand = new ImageLand();
            imageLand.poaX = (int) (i * imageLand1.getWidth());
            imageLand.image = getImageLand();
            listImage.add(imageLand);
        }
    }

    public void update() {
        for (ImageLand imageLand : listImage) {
            imageLand.poaX -= 2;
        }
        ImageLand firstElement = listImage.get(0);
        if (firstElement.poaX + imageLand1.getWidth() < 0) {
            firstElement.poaX = listImage.get(listImage.size() - 1).poaX + imageLand1.getWidth();
            listImage.add(firstElement);
            listImage.remove(0);

        }
    }

    public void draw(Graphics g) {
        for (ImageLand imageLand : listImage) {
            g.drawImage(imageLand.image, imageLand.poaX, (int) GROUNDY - 20, null);
        }

    }
    private BufferedImage getImageLand () {
        int i = random.nextInt(10);
        switch(i){
            case 0: return imageLand1;
            case 1: return imageLand3;
            default : return imageLand2;
        }
    }

    private class ImageLand {

        int poaX;
        BufferedImage image;
    }
}
