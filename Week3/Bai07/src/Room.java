public abstract class Room {
    protected double pricePerNight;
    public Room(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public abstract double calculatePrice(int nights);
}
