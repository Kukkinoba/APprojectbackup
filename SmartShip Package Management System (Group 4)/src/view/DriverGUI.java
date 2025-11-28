package view;

import model.Driver;
import model.Shipment;

import javax.swing.*;
import java.awt.*;

public class DriverGUI extends JFrame {

    private Driver driver;

    public DriverGUI(Driver driver) {
        this.driver = driver;

        setTitle("Driver Portal - " + driver.getfName());
        setSize(500, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Driver Dashboard", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        panel.add(title);

        JButton btnViewDeliveries = new JButton("View Assigned Deliveries");
        JButton btnUpdateStatus = new JButton("Update Shipment Status");
        JButton btnViewPayslip = new JButton("View Payslip");
        JButton btnEmailPayslip = new JButton("Email Payslip");
        JButton btnLogout = new JButton("Logout");

        panel.add(btnViewDeliveries);
        panel.add(btnUpdateStatus);
        panel.add(btnViewPayslip);
        panel.add(btnEmailPayslip);
        panel.add(btnLogout);

        add(panel);

        // ------------------ view deliveries ------------------
        btnViewDeliveries.addActionListener(e -> {

            StringBuilder sb = new StringBuilder();

            if (driver.getAssignedDeliveries().isEmpty()) {
                sb.append("No deliveries assigned.");
            } else {
                for (Shipment s : driver.getAssignedDeliveries()) {
                    sb.append("Tracking #: ").append(s.getTrackingNumber())
                      .append("\nRecipient: ").append(s.getRecipientName())
                      .append("\nStatus: ").append(s.getStatus())
                      .append("\nDistance: ").append(s.getDistanceKm()).append(" km")
                      .append("\n------------------------\n");
                }
            }

            JOptionPane.showMessageDialog(this, sb.toString());
        });

        // ------------------ driver update shipment ------------------
        btnUpdateStatus.addActionListener(e -> {

            JTextField txtTracking = new JTextField();
            JComboBox<String> cmbStatus = new JComboBox<>(
                    new String[]{"In Transit", "Delivered", "Delayed", "Cancelled"});

            JPanel form = new JPanel(new GridLayout(2, 2, 5, 5));
            form.add(new JLabel("Tracking Number:")); form.add(txtTracking);
            form.add(new JLabel("New Status:")); form.add(cmbStatus);

            int result = JOptionPane.showConfirmDialog(this, form,
                    "Update Shipment Status", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String msg = driver.updateShipmentStatus(
                        txtTracking.getText(),
                        cmbStatus.getSelectedItem().toString()
                );
                JOptionPane.showMessageDialog(this, msg);
            }
        });

        // ------------------ view payslip ------------------
        btnViewPayslip.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, driver.viewPayslip());
        });


        // ------------------ LOGOUT ------------------
        btnLogout.addActionListener(e -> dispose());
    }
}
