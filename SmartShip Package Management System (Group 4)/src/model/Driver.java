package model;

import java.util.ArrayList;

public class Driver extends User {

    // The deliveries assigned to the driver
    private ArrayList<Shipment> assignedDeliveries = new ArrayList<>();

    // ------------------ Constructor ------------------
    public Driver(int userId, String userName, String fName, String lName,
                  String email, String password, String role, String phone) {

        super(userId, userName, fName, lName, email, password, role, phone);
    }

    // ------------------ open driver portal ------------------
    @Override
    public void openMainPortal() {
        new view.DriverGUI(this).setVisible(true);
    }

    // ------------------ Get Assigned Deliveries ------------------
    public ArrayList<Shipment> getAssignedDeliveries() {
        return assignedDeliveries;
    }

    // ------------------ Assign NEW Delivery ------------------
    public void assignDelivery(Shipment s) {
        assignedDeliveries.add(s);
    }

    // ------------------ Update Shipment Status ------------------
    public String updateShipmentStatus(String trackingNumber, String newStatus) {

        for (Shipment s : assignedDeliveries) {
            if (s.getTrackingNumber().equals(trackingNumber)) {
                s.setStatus(newStatus);
                return "Shipment " + trackingNumber + " updated to " + newStatus;
            }
        }

        return "Tracking number not found in your assigned deliveries.";
    }

    // ------------------ View Payslip ------------------
    public String viewPayslip() {
        return "Driver Payslip\n---------------------\n" +
               "Name: " + this.fName + " " + this.lName + "\n" +
               "Role: Driver\n" +
               "Monthly Salary: $150,000\n" +
               "Transport Allowance: $20,000\n" +
               "Total: $170,000";
    }
}
