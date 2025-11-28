package model;

import java.util.ArrayList;

public class Manager extends User {

    // ---------------------- System Storage ----------------------
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Shipment> shipments = new ArrayList<>();
    private ArrayList<Vehicle> vehicles = new ArrayList<>();


    // ---------------------- Constructor ----------------------
    public Manager(int userId, String userName, String fName, String lName,
                   String email, String password, String role, String phone) {

        super(userId, userName, fName, lName, email, password, role, phone);
    }


    // ---------------------- Open GUI ----------------------
    @Override
    public void openMainPortal() {
        new view.ManagerGUI(this).setVisible(true);
    }


    //add user
    public void addUser(User u) {
        users.add(u);
    }

    // remove user
    public boolean removeUser(int id) {
        return users.removeIf(u -> u.getUserId() == id);
    }

    //view all user
    public String viewAllUsers() {
        if (users.isEmpty()) return "No user accounts found.";

        StringBuilder sb = new StringBuilder("User Accounts:\n\n");

        for (User u : users) {
            sb.append("ID: ").append(u.getUserId())
              .append(" | Name: ").append(u.getfName()+ " " +u.getlName())
              .append(" | Role: ").append(u.getRole())
              .append("\n");
        }
        return sb.toString();
    }


    // adding shipments

    public void addShipment(Shipment s) {
        shipments.add(s);
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public ArrayList<Shipment> getShipments() {
        return shipments;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }



    /** Shipment report: pending, transit, delivered, delayed */
    public String generateShipmentReport() {
        int pending = 0, transit = 0, delivered = 0, delayed = 0;

        for (Shipment s : shipments) {
            switch (s.getStatus()) {
                case "Pending" -> pending++;
                case "In Transit" -> transit++;
                case "Delivered" -> delivered++;
                case "Delayed" -> delayed++;
            }
        }

        return "Shipment Report\n------------------\n" +
                "Pending: " + pending +
                "\nIn Transit: " + transit +
                "\nDelivered: " + delivered +
                "\nDelayed: " + delayed;
    }


    /** Revenue report based on shipment cost */
    public String generateRevenueReport() {
        double total = 0;

        for (Shipment s : shipments) total += s.getCost();

        return "Revenue Report\n------------------\n" +
                "Total Revenue: $" + total;
    }


    /** Vehicle utilization report */
    public String generateVehicleReport() {
        int total = vehicles.size();
        int active = 0;

        for (Vehicle v : vehicles)
            if (v.isAvailable()) active++;

        return "Vehicle Report\n------------------\n" +
                "Total Vehicles: " + total +
                "\nAvailable: " + active +
                "\nIn Use: " + (total - active);
    }


    /** Delivery performance report */
    public String generatePerformanceReport() {
        int delivered = 0, delayed = 0;

        for (Shipment s : shipments) {
            if (s.getStatus().equals("Delivered")) delivered++;
            if (s.getStatus().equals("Delayed")) delayed++;
        }

        return "Delivery Performance\n------------------\n" +
                "On-Time: " + delivered +
                "\nDelayed: " + delayed;
    }


    // ============================================================================
    //                                PAYSLIPS
    // ============================================================================

    public String makePayslip(String employeeName, double base, double bonus, double deduct) {

        double total = base + bonus - deduct;

        return "Payslip for " + employeeName +
                "\n---------------------------" +
                "\nBase Salary: $" + base +
                "\nBonus: $" + bonus +
                "\nDeductions: $" + deduct +
                "\n---------------------------" +
                "\nTotal: $" + total;
    }


    public String emailPayslip(String email) {
        return "Payslip emailed to " + email;
    }


    // ============================================================================
    //                                EXPORTING
    // ============================================================================

    public String exportReport(String reportName) {
        return "Report '" + reportName + "' exported to PDF.";
    }
}
