import models.Vehicle;
import models.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleInventoryManager {

    private List<Vehicle> vehicles;

    public VehicleInventoryManager() {
        vehicles = new ArrayList<>();
    }

    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehiclesByType(VehicleType vehicleType) {
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for(Vehicle vehicle : this.vehicles) {
            if(vehicle.getVehicleType() == vehicleType)
                filteredVehicles.add(vehicle);
        }
        return filteredVehicles;
    }
}
