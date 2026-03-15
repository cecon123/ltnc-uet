
public class StandardRoom extends Room {

    public StandardRoom(double pricePerNight) {
        super(pricePerNight);
    }

    @Override
    public double calculatePrice(int nights) {
        double total = pricePerNight * nights;
        if (nights > 3) {
            return total * 0.95;
        } else {
            return total;
        }
    }
}
