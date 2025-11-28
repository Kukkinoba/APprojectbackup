package model;
public class Vehicle {

    private int vehicleId;
    private String plateNumber;
    private double capacityWeight;
    private int capacityCount;
    private boolean available;

    // -------------------- Constructors --------------------

    public Vehicle() {
    	vehicleId = 0;
    	plateNumber = "";
    	capacityWeight = 0.0;
    	capacityCount = 0;
    	available = true;
    }

    public Vehicle(int vehicleId, String plateNumber, double capacityWeight,
                   int capacityCount, boolean available) {
        this.vehicleId = vehicleId;
        this.plateNumber = plateNumber;
        this.capacityWeight = capacityWeight;
        this.capacityCount = capacityCount;
        this.available = available;
    }

    // -------------------- Getters & Setters --------------------

		    public int getVehicleId() {
				return vehicleId;
			}
		
			public void setVehicleId(int vehicleId) {
				this.vehicleId = vehicleId;
			}
		
			public String getPlateNumber() {
				return plateNumber;
			}
		
			public void setPlateNumber(String plateNumber) {
				this.plateNumber = plateNumber;
			}
		
			public double getCapacityWeight() {
				return capacityWeight;
			}
		
			public void setCapacityWeight(double capacityWeight) {
				this.capacityWeight = capacityWeight;
			}
		
			public int getCapacityCount() {
				return capacityCount;
			}
		
			public void setCapacityCount(int capacityCount) {
				this.capacityCount = capacityCount;
			}
		
			public boolean isAvailable() {
				return available;
			}
		
			public void setAvailable(boolean available) {
				this.available = available;
			}

    // -------------------- To Stringe --------------------

    @Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", plateNumber=" + plateNumber + ", capacityWeight=" + capacityWeight
				+ ", capacityCount=" + capacityCount + ", available=" + available + "]";
	}

	

}
 