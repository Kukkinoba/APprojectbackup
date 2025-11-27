package model;

public class Shipment {
    private int shipmentId;
    private int customerId;
    private String senderName;
    private String recipientName;
    private String recipientAddress;
    private double weight;
    private String type; // standard, express, fragile
    private int zone;
    private double cost;
    private String status; // Pending, Assigned, In Transit, Delivered
    private String trackingNumber;

    public Shipment() {}

    public Shipment(int shipmentId, int customerId, String senderName, String recipientName,
                    String recipientAddress, double weight, String type, int zone,
                    double cost, String status, String trackingNumber) {
        this.shipmentId = shipmentId;
        this.customerId = customerId; // should be userid with customer role
        this.senderName = senderName;
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.weight = weight;
        this.type = type;
        this.zone = zone;
        this.cost = cost;
        this.status = status;
        this.trackingNumber = trackingNumber;
    }

    // Getters and setters
    public int getShipmentId() { return shipmentId; }
    public void setShipmentId(int shipmentId) { this.shipmentId = shipmentId; }
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }
    public String getRecipientName() { return recipientName; }
    public void setRecipientName(String recipientName) { this.recipientName = recipientName; }
    public String getRecipientAddress() { return recipientAddress; }
    public void setRecipientAddress(String recipientAddress) { this.recipientAddress = recipientAddress; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getZone() { return zone; }
    public void setZone(int zone) { this.zone = zone; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }
}
