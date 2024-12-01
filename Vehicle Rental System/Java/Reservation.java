import models.User;
import models.Vehicle;
import models.VehicleStatus;

import java.time.LocalDateTime;

public class Reservation {
    int id;
    User user;
    Vehicle vehicle;
    LocalDateTime bookingDate;
    LocalDateTime bookingFrom;
    LocalDateTime bookingTo;
    ReservationType reservationType;
    ReservationStatus reservationStatus;

    public Reservation(User user, Vehicle vehicle, ReservationType reservationType) {
        this.id = (int)(Math.random() * 101); // 0 to 100
        this.user = user;
        this.vehicle = vehicle;

        vehicle.setVehicleStatus(VehicleStatus.NOT_AVAILABLE);

        this.bookingDate = LocalDateTime.now();
        this.reservationType = reservationType;
        this.reservationStatus = ReservationStatus.SCHEDULED;
    }

    @Override
    public String toString() {
        return "-> " + id + " User: " + user.toString() + "| Vehicle: " + vehicle + "| " + bookingDate.toString() + " " +
                reservationType.toString() + " " + reservationStatus.toString();
    }
}
