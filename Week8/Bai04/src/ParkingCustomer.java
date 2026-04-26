
import java.util.ArrayList;
import java.util.List;

class ParkingCustomer {

    private final String name;
    private final List<ParkingTicket> tickets = new ArrayList<>();

    public ParkingCustomer(String name) {
        this.name = name;
    }

    public void addTicket(ParkingTicket ticket) {
        tickets.add(ticket);
    }

    public String receipt() {
        String result = "Parking Receipt for " + name + "\n";

        for (ParkingTicket each : tickets) {
            result += "\t" + each.getVehicle().getPlate() + "\t" + each.getFee() + "\n";
        }

        result += "Total fee is " + getTotalFee() + "\n";
        result += "You earned " + getTotalBonusPoints() + " bonus points";
        return result;
    }

    private double getTotalFee() {
        double totalFee = 0;

        for (ParkingTicket each : tickets) {
            totalFee += each.getFee();
        }

        return totalFee;
    }

    private int getTotalBonusPoints() {
        int totalBonusPoints = 0;

        for (ParkingTicket each : tickets) {
            totalBonusPoints += each.getBonusPoints();
        }

        return totalBonusPoints;
    }
}
