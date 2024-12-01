package models;

import java.util.Date;

public abstract class Vehicle {

    int id;
    String vehicleNumber;
    VehicleType vehicleType;
    String companyName;
    String modelName;
    int kmDriven;
    Date manufacturingDate;
    int average;
    int cc;
    double dailyRentalCost;
    double hourlyRentalCost;
    VehicleStatus vehicleStatus;

    public Vehicle(int id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
        vehicleStatus = VehicleStatus.AVAILABLE;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleStatus(VehicleStatus status) {
        this.vehicleStatus = status;
    }

    @Override
    public String toString() {
        return " " + this.id + " " + this.vehicleType.toString() + " " + this.vehicleStatus.toString();
    }
}
