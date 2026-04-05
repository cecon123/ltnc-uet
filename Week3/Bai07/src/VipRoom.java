
public class VipRoom extends Room {

    public VipRoom(double pricePerNight) {
        super(pricePerNight);
    }

    @Override
    public double calculatePrice(int nights) {
        return pricePerNight * nights;
    }

}
