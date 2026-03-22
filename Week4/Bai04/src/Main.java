interface IData {
    void show(); 
}

/*class DataManagerBefore implements IData {
    void show() {
        System.out.println("Show Data");
    }
}*/

class DataManagerAfter implements IData {
    @Override
    public void show() {
        System.out.println("Show Data");
    }
}

public class Main {
    public static void main(String[] args) {
        IData data = new DataManagerAfter();
        data.show();
    }
}
