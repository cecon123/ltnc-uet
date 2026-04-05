
import java.util.*;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();
            List<Robot> robots = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                String type = sc.next();
                int id = sc.nextInt();
                String model = sc.next();

                switch (type) {
                    case "DR" ->
                        robots.add(new DroneRobot(id, model));
                    case "FR" ->
                        robots.add(new FishRobot(id, model));
                    case "AR" ->
                        robots.add(new AmphibiousRobot(id, model));
                }
            }

            for (Robot r : robots) {

                r.performMainTask();

                if (r instanceof Flyable f) {
                    f.fly();
                }

                if (r instanceof Swimmable s) {
                    s.swim();
                }

                if (r instanceof GPS g) {
                    g.getCoordinates();
                }
            }
        }
    }
}
