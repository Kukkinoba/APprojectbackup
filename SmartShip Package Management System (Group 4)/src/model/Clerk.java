package model;

import java.util.ArrayList;

public class Clerk extends User {

    // all shipments for the clerk to see
    private ArrayList<Shipment> allShipments = new ArrayList<>();
    private ArrayList<String> vehicleAssignments = new ArrayList<>();

    // ------------------ Constructor ------------------
    public Clerk(int userId, String userName, String fName, String lName,
                 String email, String password, String role, String phone) {
        super(userId, userName, fName, lName, email, password, role, phone);
    }

    // ------------------ clerk portal ------------------
    @Override
    public void openMainPortal() {
        new view.ClerkGUI(this).setVisible(true);
    }

    public void addShipmentToSystem(Shipment s) {
        allShipments.add(s);
    }

//view all shipments
    public String viewAllShipments() {
        if (allShipments.isEmpty()) return "No shipments available.";

        StringBuilder sb = new StringBuilder("All Shipments:\n\n");

        for (Shipment s : allShipments) {
            sb.append("ID: ").append(s.getShipmentId())
              .append(" | Tracking: ").append(s.getTrackingNumber())
              .append(" | Status: ").append(s.getStatus())
              .append("\n");
        }
        return sb.toString();
    }

   // assinging shipments to a vehicle
    public String assignShipToVehicle(String trackingNumber, String vehiclePlate) {

        for (Shipment s : allShipments) {
            if (s.getTrackingNumber().equals(trackingNumber)) {

                String record = "Shipment " + trackingNumber +
                        " assigned to vehicle " + vehiclePlate;

                vehicleAssignments.add(record);

                return record;
            }
        }
        return "Shipment not found.";
    }

    public String viewVehicleAssignments() {
        if (vehicleAssignments.isEmpty()) {
            return "No vehicle assignments available.";
        }

        StringBuilder sb = new StringBuilder("Vehicle Assignments:\n\n");
        for (String v : vehicleAssignments) sb.append(v).append("\n");

        return sb.toString();
    }

    // handling payments
    public String handlePayment(String trackingNumber) {
        return "Payment processed for shipment: " + trackingNumber;
    }


    public String viewPayslip() {
        return "Clerk Payslip\n---------------------\n" +
                "Name: " + this.fName + " " + this.lName + "\n" +
                "Role: Clerk\n" +
                "Base Salary: $120,000\n" +
                "Bonus: $10,000\n" +
                "Total: $130,000";
    }
}
