
public class Main {

    public static void main(String[] args) {
        Order standardOrder = new Order(new StandardDelivery(), 10, 20);
        Order expressOrder = new Order(new ExpressDelivery(), 10, 20);
        Order fragileOrder = new Order(new FragileDelivery(), 10, 20);
        Order bulkyOrder = new Order(new BulkyDelivery(), 10, 20);

        printOrder(standardOrder);
        printOrder(expressOrder);
        printOrder(fragileOrder);
        printOrder(bulkyOrder);
    }

    private static void printOrder(Order order) {
        System.out.println(order.getLabel() + " Phí giao hàng: " + order.getDeliveryFee());
    }
}
