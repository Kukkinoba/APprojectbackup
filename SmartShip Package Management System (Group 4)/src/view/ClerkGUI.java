package view;

import model.Clerk;
import model.Shipment;

import javax.swing.*;
import java.awt.*;

public class ClerkGUI extends JFrame {

    private Clerk clerk;

    public ClerkGUI(Clerk clerk) {
        this.clerk = clerk;

        setTitle("Clerk Portal - " + clerk.getfName());
        setSize(550, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(7, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Clerk Dashboard", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        panel.add(title);

        JButton btnViewShipments = new JButton("View All Shipments");
        JButton btnAssign = new JButton("Assign Shipment to Vehicle");
        JButton btnViewAssignments = new JButton("View Vehicle Assignments");
        JButton btnHandlePayment = new JButton("Handle Payment");
        JButton btnViewPayslip = new JButton("View Payslip");
        JButton btnEmailPayslip = new JButton("Email Payslip");
        JButton btnLogout = new JButton("Logout");

        panel.add(btnViewShipments);
        panel.add(btnAssign);
        panel.add(btnViewAssignments);
        panel.add(btnHandlePayment);
        panel.add(btnViewPayslip);
        panel.add(btnEmailPayslip);
        panel.add(btnLogout);

        add(panel);

        // ------------------ View All Shipments ------------------
        btnViewShipments.addActionListener(e ->
            JOptionPane.showMessageDialog(this, clerk.viewAllShipments())
        );

        // ------------------ Assign Shipment to Vehicle ------------------
        btnAssign.addActionListener(e -> {

            JTextField txtTracking = new JTextField();
            JTextField txtVehicle = new JTextField();

            JPanel form = new JPanel(new GridLayout(2, 2, 5, 5));
            form.add(new JLabel("Tracking Number:")); form.add(txtTracking);
            form.add(new JLabel("Vehicle Plate:")); form.add(txtVehicle);

            int result = JOptionPane.showConfirmDialog(this, form,
                    "Assign Shipment", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String msg = clerk.assignShipToVehicle(
                        txtTracking.getText(),
                        txtVehicle.getText()
                );
                JOptionPane.showMessageDialog(this, msg);
            }
        });

        // ------------------ View Vehicle Assignments ------------------
        btnViewAssignments.addActionListener(e ->
            JOptionPane.showMessageDialog(this, clerk.viewVehicleAssignments())
        );

        // ------------------ Handle Payment ------------------
        btnHandlePayment.addActionListener(e -> {

            String tracking = JOptionPane.showInputDialog(
                    this, "Enter Tracking Number:");

            if (tracking != null && !tracking.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this, clerk.handlePayment(tracking)
                );
            }
        });

        // ------------------ View Payslip ------------------
        btnViewPayslip.addActionListener(e ->
            JOptionPane.showMessageDialog(this, clerk.viewPayslip())
        );

        // ------------------ Email Payslip ------------------
        btnEmailPayslip.addActionListener(e ->
            JOptionPane.showMessageDialog(
                    this,
                    "Payslip emailed to: " + clerk.getEmail()
            )
        );

        // ------------------ Logout ------------------
        btnLogout.addActionListener(e -> dispose());
    }
}
