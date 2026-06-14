package entity;

public class Vehicle {
    private int id;
    private String vehicleNumber;
    private String model;
    private int customerId;

    public Vehicle(int id, String vehicleNumber,
                   String model, int customerId) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getModel() {
        return model;
    }

    public int getCustomerId() {
        return customerId;
    }
}