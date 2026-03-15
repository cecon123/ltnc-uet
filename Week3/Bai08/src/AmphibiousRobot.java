
public class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS {

    public AmphibiousRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    public void performMainTask() {
        System.out.println("Amphibious robot performing multi-terrain mission.");
    }

    @Override
    public void fly() {
        System.out.println("Amphibious robot flying.");
    }

    @Override
    public void swim() {
        System.out.println("Amphibious robot swimming.");
    }

    @Override
    public void getCoordinates() {
        System.out.println("Amphibious robot GPS active.");
    }
}
