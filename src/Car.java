import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Car {
    static int width = 100;
    static int height = 50;
    int speed;

    BufferedImage bufferedImage;

    Rectangle bounds;

    public Car(int x, int y, int speed) {
        this.speed = speed;
        try {
            bufferedImage = ImageIO.read(new File("Sprites\\Car.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bounds = new Rectangle(x, y, width, height);
    }

    public void updatePosition() {
        bounds.setLocation((int) bounds.getX() + speed, (int) bounds.getY());
        if(bounds.x > Engine.gui.width) {
            bounds.setLocation((int) (0 - bounds.getWidth()), bounds.y);
        }
        if(Engine.isTouching()) {
            Engine.running = false;
        }
    }
}
