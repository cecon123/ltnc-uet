
public class FishRobot extends Robot implements Swimmable {

    public FishRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    public void performMainTask() {
        System.out.println("Fish robot exploring underwater.");
    }

    @Override
    public void swim() {
        System.out.println("Fish robot swimming.");
    }

}
