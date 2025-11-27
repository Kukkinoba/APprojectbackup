package model;

public class Vehicle {
    private int vehicleId;
    private String plateNumber;
    private double capacityWeight;
    private int capacityCount;
    private boolean available;

    public Vehicle() {}

    public Vehicle(int vehicleId, String plateNumber, double capacityWeight, int capacityCount, boolean available) {
        this.vehicleId = vehicleId;
        this.plateNumber = plateNumber;
        this.capacityWeight = capacityWeight;
        this.capacityCount = capacityCount;
        this.available = available;
    }

    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }
    public String getPlateNumber() { return plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }
    public double getCapacityWeight() { return capacityWeight; }
    public void setCapacityWeight(double capacityWeight) { this.capacityWeight = capacityWeight; }
    public int getCapacityCount() { return capacityCount; }
    public void setCapacityCount(int capacityCount) { this.capacityCount = capacityCount; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}