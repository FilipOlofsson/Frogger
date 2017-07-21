import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends Canvas {
    JFrame frame;
    JPanel panel;

    int width = 800;
    int height = 600;

    public GUI() {
        frame = new JFrame();
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(Engine.player.bufferedImage, Engine.player.bounds.x, Engine.player.bounds.y, null);
                for(Car car : Engine.carList) {
                    ((Graphics2D) g).drawImage(car.bufferedImage, car.bounds.x, car.bounds.y, null);
                }
                g.setColor(Color.RED);
                FontMetrics fm = g.getFontMetrics();
                g.setFont(new Font("Arial", Font.BOLD, 25));
                g.drawString(Integer.toString(Engine.points), 1, 25);
            }
        };
        frame.add(panel);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyChar() == KeyEvent.VK_SPACE) {
                    Engine.goForward();
                }
            }
        });
        frame.setPreferredSize(new Dimension(width, height));
        frame.setTitle("Hej");
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}