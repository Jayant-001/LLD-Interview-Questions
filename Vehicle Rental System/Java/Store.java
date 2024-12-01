import models.User;
import models.Vehicle;
import models.VehicleStatus;
import models.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {

    int id;
    VehicleInventoryManager inventory;
    List<Reservation> reservations;
    Location location;

    public Store() {
        this.id = (int)(Math.random() * 101); // 0 to 100
        this.inventory = new VehicleInventoryManager();
        reservations = new ArrayList<>();
    }

    public void setVehicles(List<Vehicle> vehicles) {
        inventory.setVehicles(vehicles);
    }

    public List<Vehicle> getVehiclesByType(VehicleType vehicleType) {
        return inventory.getVehiclesByType(vehicleType);
    }

    public Reservation createReservation(User user, Vehicle vehicle, ReservationType reservationType) {
        Reservation reservation = new Reservation(user, vehicle, reservationType);
        reservations.add(reservation);
        return reservation;
    }

    public void completeReservation(int reservationId) {
        for(Reservation reservation : this.reservations) {
            if(reservation.id == reservationId) {
                reservation.vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
                reservation.reservationStatus = ReservationStatus.COMPLETED;
            }
        }
    }

    public void printVehicles() {
        List<Vehicle> vehicles = inventory.getVehicles();
        for(Vehicle v : vehicles) {
            System.out.println(v.toString());
        }
    }

    public void printReservations() {
        for(Reservation r : this.reservations) {
            System.out.println(r.toString());
        }
    }
}
