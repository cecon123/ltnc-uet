public class Inventory {
    private Product[] items;
    public Inventory(Product[] initialItems) {
        this.items = new Product[initialItems.length];
        for (int i = 0; i < initialItems.length; i++) {
            if (initialItems[i] != null) {
                this.items[i] = new Product(initialItems[i].getId(), initialItems[i].getName(), initialItems[i].getPrice());
            }
        }
    }
    public static void main(String[] args) {
        Product[] arr = {
                new Product("P001", "Laptop", 2000),
                new Product("P002", "Smartphone", 500),
        };
        Inventory kho = new Inventory(arr);
        arr[0].setPrice(5000);
        for (Product item : kho.items) {
            System.out.println(item);
        }
    }
}
