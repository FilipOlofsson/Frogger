import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    int width = 50;
    int height = 50;
    Rectangle bounds;
    BufferedImage bufferedImage;

    public Player() {
        bounds = new Rectangle(375, 450, width, height);
        try {
            bufferedImage = ImageIO.read(new File("Sprites\\player.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
