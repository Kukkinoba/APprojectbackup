package model;

import java.sql.*;
import java.util.ArrayList;
import server.databaseConnection;

public class Customer extends User {

    private String address;

    // Storage
    private ArrayList<Shipment> shipmentHistory = new ArrayList<>();
    private ArrayList<String> invoices = new ArrayList<>();


    // ---------------- Constructor ----------------
    public Customer(int userId, String userName, String fName, String lName,
                    String email, String password, String role,
                    String phone, String address) {

        super(userId, userName, fName, lName, email, password, role, phone);
        this.address = address;
    }


    // ---------------- Getters & Setters ----------------
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }



    // ---------------- create account for customer ----------------
    public static Customer createAccountDB(String userName, String fName, String lName,
                                           String email, String phone, String address,
                                           String password) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = databaseConnection.getConnection();

            String sql = "INSERT INTO users (userName, fName, lName, email, password, role, phone, address) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, userName);
            ps.setString(2, fName);
            ps.setString(3, lName);
            ps.setString(4, email);
            ps.setString(5, password);
            ps.setString(6, "Customer");
            ps.setString(7, phone);
            ps.setString(8, address);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    int generatedId = rs.getInt(1);

                    return new Customer(
                            generatedId,
                            userName,
                            fName,
                            lName,
                            email,
                            password,
                            "Customer",
                            phone,
                            address
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception ignored) {}
            try { if (ps != null) ps.close(); } catch (Exception ignored) {}
            try { if (conn != null) conn.close(); } catch (Exception ignored) {}
        }

        return null; // If creation fails
    }


    // ---------------- shipment request creation ----------------

    public double createShipment(double weight, String type, int zone,
                                 String recipient, String recipientAddress) {

        Shipment s = new Shipment();
        s.setShipmentId(shipmentHistory.size() + 1);
        s.setUserId(this.userId);
        s.setSenderName(fName + " " + lName);
        s.setRecipientName(recipient);
        s.setRecipientAddress(recipientAddress);
        s.setWeight(weight);
        s.setType(type);
        s.setZone(zone);
        s.setStatus("Pending");

        // tracking and shimpment
        String trk = Shipment.genTrackingNumber();
        s.setTrackingNumber(trk);
        s.setDistanceKm(Shipment.genDisByZone(zone));

        // Cost calculation from shipment
        double cost = s.calCost(weight, type, zone);
        s.setCost(cost);

        // Save shipment
        shipmentHistory.add(s);

        // Save invoice
        invoices.add(
                "Invoice for Shipment #" + s.getShipmentId() +
                " | Tracking: " + s.getTrackingNumber() +
                " | Cost: $" + cost +
                " | Status: Unpaid"
        );

        return cost;
    }


    // ---------------- track package ----------------
    public String trackPackage(String trackingNumber) {

        for (Shipment s : shipmentHistory) {
            if (s.getTrackingNumber().equals(trackingNumber)) {
                return s.trackInfo();
            }
        }

        return "Tracking number not found.";
    }


    // ---------------- view invoies stored in array ----------------

    public String viewInvoices() {

        if (invoices.isEmpty()) {
            return "No invoices found.";
        }

        StringBuilder sb = new StringBuilder("Invoices:\n\n");

        for (String inv : invoices) {
            sb.append(inv).append("\n");
        }

        return sb.toString();
    }


    // ---------------- print shipment history----------------

    public ArrayList<Shipment> getShipmentHistory() {
        return shipmentHistory;
    }


	@Override
	public void openMainPortal() {
		
	}

}
