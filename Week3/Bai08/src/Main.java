
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Robot> robots = new ArrayList<>();
        robots.add(new DroneRobot(1, "SkyEyeY"));
        robots.add(new FishRobot(2, "AquaBotX"));
        robots.add(new AmphibiousRobot(3, "AmphiX"));

        for (Robot r : robots) {
            r.performMainTask();
        }

        Robot r1 = robots.get(0);

        if (r1 instanceof Flyable) {
            Flyable f = (Flyable) r1;
            f.fly();
        }

        if (r1 instanceof GPS) {
            GPS g = (GPS) r1;
            g.getCoordinates();
        }

        Robot r2 = robots.get(1);
        if (r2 instanceof Swimmable) {
            Swimmable s = (Swimmable) r2;
            s.swim();
        }

        Robot r3 = robots.get(2);

        if (r3 instanceof Flyable) {
            Flyable f = (Flyable) r3;
            f.fly();
        }
    }
}
