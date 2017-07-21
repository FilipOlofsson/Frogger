import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Engine {

    static Player player;
    static int tick = 20;
    static int points = 0;

    static boolean running = true;

    static Random rnd;

    static GUI gui;

    static List<Car> carList = new ArrayList<>();

    private static void init() {
        player = new Player();
        rnd = new Random();
        gui = new GUI();
        for(int i = 0; i < 9; i++) {
            carList.add(new Car(0, Car.height * i, 2 + rnd.nextInt(10)));
        }
    }

    public static boolean isTouching() {
        for(Car car : carList) {
            if(car.bounds.contains(player.bounds.getBounds())) {
                return true;
            }
        }
        return false;
    }

    public static void goForward() {
        carList.add(new Car(0, -50, 2 + rnd.nextInt(10)));
        for(Car car : carList) {
            car.bounds.setLocation( (int) car.bounds.x, (int) (car.bounds.getY() + car.bounds.getHeight()));
            if(car.bounds.getY() + car.bounds.getHeight() > gui.height) {
                car = null;
            }
        }
        points++;
    }

    private static void run() throws InterruptedException {
        while(running) {
            if(isTouching()) {
                running = false;
            }
            for(Car car : carList) {
                car.updatePosition();
            }
            gui.panel.repaint();
            Thread.sleep(tick);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        init();
        run();
    }


}
