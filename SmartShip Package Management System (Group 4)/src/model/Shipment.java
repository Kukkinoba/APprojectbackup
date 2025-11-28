package model;

import java.io.Serializable;
import java.security.SecureRandom;

public class Shipment implements Serializable {

    private static final long serialVersionUID = 1L;

    //------------------------ Attributes ------------------------
    private int shipmentId;
    private int userId;               
    private String senderName;
    private String recipientName;
    private String recipientAddress;
    private double weight;
    private String type;              
    private int zone;                 
    private double distanceKm;        
    private double cost;
    private String status;            
    private String trackingNumber;    

    //------------------------ Constructors ------------------------
    public Shipment() {
    	shipmentId = 0;
        userId = 0;
        senderName = "";
        recipientName = "";
        recipientAddress = "";
        weight = 0.0;
        type = "";
        zone = 0;
        distanceKm = 0.0;
        cost = 0.0;
        status = "";
        trackingNumber = "";
        
    }

    public Shipment(int shipmentId, int userId, String senderName, String recipientName,
                    String recipientAddress, double weight, String type, int zone,
                    double cost, String status, String trackingNumber) {

        this.shipmentId = shipmentId;
        this.userId = userId;
        this.senderName = senderName;
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.weight = weight;
        this.type = type;
        this.zone = zone;
        this.cost = cost;
        this.status = status;
        this.trackingNumber = trackingNumber;
        this.distanceKm = genDisByZone(zone);
    }

    //------------------------ Getters & Setters ------------------------
		  public static long getSerialversionuid() {
				return serialVersionUID;
			}
		
			public int getShipmentId() {
				return shipmentId;
			}
		
			public void setShipmentId(int shipmentId) {
				this.shipmentId = shipmentId;
			}
		
			public int getUserId() {
				return userId;
			}
		
			public void setUserId(int userId) {
				this.userId = userId;
			}
		
			public String getSenderName() {
				return senderName;
			}
		
			public void setSenderName(String senderName) {
				this.senderName = senderName;
			}
		
			public String getRecipientName() {
				return recipientName;
			}
		
			public void setRecipientName(String recipientName) {
				this.recipientName = recipientName;
			}
		
			public String getRecipientAddress() {
				return recipientAddress;
			}
		
			public void setRecipientAddress(String recipientAddress) {
				this.recipientAddress = recipientAddress;
			}
		
			public double getWeight() {
				return weight;
			}
		
			public void setWeight(double weight) {
				this.weight = weight;
			}
		
			public String getType() {
				return type;
			}
		
			public void setType(String type) {
				this.type = type;
			}
		
			public int getZone() {
				return zone;
			}
		
			public void setZone(int zone) {
				this.zone = zone;
			}
		
			public double getCost() {
				return cost;
			}
		
			public void setCost(double cost) {
				this.cost = cost;
			}
		
			public String getStatus() {
				return status;
			}
		
			public void setStatus(String status) {
				this.status = status;
			}
		
			public String getTrackingNumber() {
				return trackingNumber;
			}
		
			public void setTrackingNumber(String trackingNumber) {
				this.trackingNumber = trackingNumber;
			}
		
			public double getDistanceKm() {
				return distanceKm;
			}
		
			public void setDistanceKm(double distanceKm) {
				this.distanceKm = genDisByZone(zone);
			}
    
    //------------------------ Shipment Functions ------------------------

    

	public static String genTrackingNumber() {
        SecureRandom trk = new SecureRandom();
        StringBuilder sbtrk = new StringBuilder();

        for (int i = 0; i < 11; i++) {
            sbtrk.append(trk.nextInt(10));
        }
        return sbtrk.toString();
    }

    
    public static double genDisByZone(int zone) {
        SecureRandom dbz = new SecureRandom();
        return switch (zone) {
            case 1 -> 5 + dbz.nextInt(6);     // 5–10 km
            case 2 -> 11 + dbz.nextInt(10);   // 11–20 km
            case 3 -> 21 + dbz.nextInt(20);   // 21–40 km
            case 4 -> 41 + dbz.nextInt(30);   // 41–70 km
            default -> 0;
        };
    }

    
    public double calCost(double weight, String type, int zone) {
        double base = 950;              
        double weightRate = weight * 550.0;
        double disRate = distanceKm * 50.0;

        double typeMultiplier = switch (type.toLowerCase()) {
            case "express" -> 1.5;
            case "fragile" -> 1.15;
            default -> 1.0;
        };

        this.cost = (base + weightRate + disRate) * typeMultiplier;
        return this.cost;
    }


    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }


    public String trackInfo() {
        return "Tracking #: " + trackingNumber +
                "\nStatus: " + status +
                "\nDestination: " + recipientAddress +
                "\nDistance: " + distanceKm + " km";
    }

    //------------------------ ToString ------------------------
    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentId=" + shipmentId +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", userId=" + userId +
                ", weight=" + weight +
                ", type='" + type + '\'' +
                ", zone=" + zone +
                ", distanceKm=" + distanceKm +
                ", cost=" + cost +
                ", status='" + status + '\'' +
                '}';
    }
}
