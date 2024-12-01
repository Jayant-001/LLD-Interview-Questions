import models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> users = createUsers(); // Create some Users
        List<Vehicle> vehicles = createVehicles(); // Create some Vehicles
        List<Store> stores = createStores(vehicles); // create stores


        // A rental system will contain some registered users and stores (with some vehicles)
        RentalSystem system = new RentalSystem(users, stores);

        // -------------------------------------- Flow starts here ----------------------------------------
        // When a user comes
        User user = users.get(0);

        // User search for stores based on the location
        Location location = new Location("Gurgaon");
        Store filteredStore = system.getStore(location);  // Get stores based on the location filter

        // Get all the vehicles from the filtered store (can put filter on Vehicle Type)
        List<Vehicle> filteredVehicles = filteredStore.getVehiclesByType(VehicleType.CAR);

        // Choose one vehicle and make reservation
        Reservation reservation = filteredStore.createReservation(user, filteredVehicles.get(0), ReservationType.DAILY);

        // Generating bill based on reservation
        Bill bill = new Bill(reservation);
        System.out.println("Printing bill before payment: \n" + bill);

        Payment payment = new Payment();
        payment.payBill(bill);
        System.out.println("Printing bill after payment: \n" + bill);

        // Print vehicles and reservation logs before completing the reservation
        filteredStore.printVehicles();
        filteredStore.printReservations();

        // Submit the vehicle and mark the reservation Completed
        filteredStore.completeReservation(reservation.id);

        // Print vehicles and reservation logs after completing the reservation
        filteredStore.printVehicles();
        filteredStore.printReservations();
    }

    /**
     *
     * Generate Dummy Data
     *
     */

    public static List<User> createUsers() {
        User user1 = new User("Jayant");
        User user2 = new User("Aman");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        return users;
    }

    public static List<Vehicle> createVehicles() {
        Vehicle vehicle1 = new Car(101);
        Vehicle vehicle2 = new Car(102);
        Vehicle vehicle3 = new Bike(103);
        Vehicle vehicle4 = new Bike(104);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
        vehicles.add(vehicle4);

        return vehicles;
    }

    public static List<Store> createStores(List<Vehicle> vehicles) {
        Store store = new Store();
        store.setVehicles(vehicles);

        // Create a new ArrayList and add the store to it
        List<Store> stores = new ArrayList<>();
        stores.add(store);
        return stores;
    }
}