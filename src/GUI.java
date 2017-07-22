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
                g.setColor(Color.gray);
                if(Engine.player.onLighter) {
                    g.setColor(Color.gray);
                    for(int i = 1; i < width/Car.height; i+=2) {
                        g.fillRect(0, i * Car.height, width, Car.height);                                               // Draw the gray road
                    }
                    g.setColor(Color.lightGray);
                    for(int i = 0; i < width/Car.height; i+=2) {
                        g.fillRect(0, i * Car.height, width, Car.height);                                               // Draw the lightgray road
                    }
                } else {
                    g.setColor(Color.lightGray);
                    for(int i = 1; i < width/Car.height; i+=2) {
                        g.fillRect(0, i * Car.height, width, Car.height);                                               // Draw the lightgray road
                    }
                    g.setColor(Color.gray);
                    for(int i = 0; i < width/Car.height; i+=2) {
                        g.fillRect(0, i * Car.height, width, Car.height);                                               // Draw the gray road
                    }
                }

                g.drawImage(Engine.player.bufferedImage, Engine.player.bounds.x, Engine.player.bounds.y, null);  // Draw the Player
                for(Car car : Engine.carList) {
                    ((Graphics2D) g).drawImage(car.bufferedImage, car.bounds.x, car.bounds.y, null);             // Draw each car
                }
                g.setColor(Color.RED);
                FontMetrics fm = g.getFontMetrics();
                g.setFont(new Font("Arial", Font.BOLD, 25));
                g.drawString(Integer.toString(Engine.points), 1, 25);                                               // Draw the String
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
        frame.getContentPane().setPreferredSize(new Dimension(width, height));
        frame.setTitle("Hej");
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
