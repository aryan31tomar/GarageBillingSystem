package services;

import java.util.ArrayList;
import java.util.List;

import entity.Vehicle;

public class VehicleService {

    private static List<Vehicle> vehicles = new ArrayList<>();
    private static int vehicleIdCounter = 1;

    public static void addVehicle(Vehicle vehicle) {
        vehicle.setId(vehicleIdCounter++);
        vehicles.add(vehicle);
    }

    public static Vehicle getVehicleByNumber(String number) {
        for (Vehicle v : vehicles) {
            if (v.getVehicleNumber().equalsIgnoreCase(number)) {
                return v;
            }
        }
        return null;
    }

    public static List<Vehicle> getAllVehicles() {
        return vehicles;
    }
}