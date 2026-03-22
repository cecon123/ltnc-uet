public class Square extends Shape {

    public Square(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Vẽ hình vuông tại (" + x + ", " + y + ")");
    }

    @Override
    public void erase() {
        System.out.println("Xóa hình vuông tại (" + x + ", " + y + ")");
    }
}
