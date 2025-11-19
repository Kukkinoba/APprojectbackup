package model;

import java.time.LocalDateTime;

public class Shipment {
    private int shipmentId;
    private int customerId;
    private String senderName;
    private String senderAddress;
    private String recipientName;
    private String recipientAddress;
    private double weight;
    private double cost;
    private String packageType; // standard, express, fragile
    private int zone; // 1–4
    private String trackingNumber;
    private String status; // Pending, Assigned, In Transit, Delivered, Cancelled
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // --- Constructors ---
    public Shipment() {}

    public Shipment(int shipmentId, int customerId, String senderName, String senderAddress,
                    String recipientName, String recipientAddress, double weight, double cost,
                    String packageType, int zone, String trackingNumber, String status,
                    LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.shipmentId = shipmentId;
        this.customerId = customerId;
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.weight = weight;
        this.cost = cost;
        this.packageType = packageType;
        this.zone = zone;
        this.trackingNumber = trackingNumber;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    
    public int getShipmentId() { return shipmentId; }
    public void setShipmentId(int shipmentId) { this.shipmentId = shipmentId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }

    public String getSenderAddress() { return senderAddress; }
    public void setSenderAddress(String senderAddress) { this.senderAddress = senderAddress; }

    public String getRecipientName() { return recipientName; }
    public void setRecipientName(String recipientName) { this.recipientName = recipientName; }

    public String getRecipientAddress() { return recipientAddress; }
    public void setRecipientAddress(String recipientAddress) { this.recipientAddress = recipientAddress; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    public String getPackageType() { return packageType; }
    public void setPackageType(String packageType) { this.packageType = packageType; }

    public int getZone() { return zone; }
    public void setZone(int zone) { this.zone = zone; }

    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    // --- Utility ---
    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentId=" + shipmentId +
                ", customerId=" + customerId +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", status='" + status + '\'' +
                ", cost=" + cost +
                '}';
    }
}
