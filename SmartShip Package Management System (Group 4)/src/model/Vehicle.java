package model;

public class Vehicle {
    private int vehicleId;
    private String licensePlate;
    private String model;
    private double capacityWeight;
    private int capacityQuantity;
    private double currentLoadWeight;
    private int currentLoadQuantity;
    private String status; // Available, Assigned, Maintenance
    private String assignedDriver; // can be replaced by driverId if linked to User table

    // --- Constructors ---
    public Vehicle() {}

    public Vehicle(int vehicleId, String licensePlate, String model, double capacityWeight,
                   int capacityQuantity, double currentLoadWeight, int currentLoadQuantity,
                   String status, String assignedDriver) {
        this.vehicleId = vehicleId;
        this.licensePlate = licensePlate;
        this.model = model;
        this.capacityWeight = capacityWeight;
        this.capacityQuantity = capacityQuantity;
        this.currentLoadWeight = currentLoadWeight;
        this.currentLoadQuantity = currentLoadQuantity;
        this.status = status;
        this.assignedDriver = assignedDriver;
    }

    // --- Getters & Setters ---
    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getCapacityWeight() { return capacityWeight; }
    public void setCapacityWeight(double capacityWeight) { this.capacityWeight = capacityWeight; }

    public int getCapacityQuantity() { return capacityQuantity; }
    public void setCapacityQuantity(int capacityQuantity) { this.capacityQuantity = capacityQuantity; }

    public double getCurrentLoadWeight() { return currentLoadWeight; }
    public void setCurrentLoadWeight(double currentLoadWeight) { this.currentLoadWeight = currentLoadWeight; }

    public int getCurrentLoadQuantity() { return currentLoadQuantity; }
    public void setCurrentLoadQuantity(int currentLoadQuantity) { this.currentLoadQuantity = currentLoadQuantity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAssignedDriver() { return assignedDriver; }
    public void setAssignedDriver(String assignedDriver) { this.assignedDriver = assignedDriver; }

    // --- Utility ---
    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", licensePlate='" + licensePlate + '\'' +
                ", status='" + status + '\'' +
                ", capacityWeight=" + capacityWeight +
                ", currentLoadWeight=" + currentLoadWeight +
                '}';
    }
}

