public class Circle extends Shape {

    public Circle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Vẽ hình tròn tại (" + x + ", " + y + ")");
    }

    @Override
    public void erase() {
        System.out.println("Xóa hình tròn tại (" + x + ", " + y + ")");
    }
}
