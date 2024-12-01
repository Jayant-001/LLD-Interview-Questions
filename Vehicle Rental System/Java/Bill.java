import models.VehicleType;

public class Bill {
    Reservation reservation;
    double amount;
    boolean isPaid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.amount = reservation.vehicle.getVehicleType() == VehicleType.CAR ? 1000 : 500;
        this.isPaid = false;
    }

    @Override
    public String toString() {
        return "Reservation: " + reservation.toString() + "| Amount: " + amount + "| Payment status: " + isPaid;
    }
}
