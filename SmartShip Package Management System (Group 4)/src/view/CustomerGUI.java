package view;

import model.Customer;

import javax.swing.*;
import java.awt.*;

public class CustomerGUI extends JFrame {

    private Customer customer;

    public CustomerGUI(Customer customer) {
        this.customer = customer;

        setTitle("Customer Portal - " + customer.getfName());
        setSize(550, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(7, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Customer Dashboard", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        panel.add(title);

        // buttonms overall
        JButton btnCreateAccount = new JButton("Create New Account");
        JButton btnCreateShipment = new JButton("Create Shipment");
        JButton btnTrackPackage = new JButton("Track Package");
        JButton btnViewInvoices = new JButton("View Invoices");
        JButton btnEmailReceipt = new JButton("Email Receipt");
        JButton btnLogout = new JButton("Logout");

        //buttons to add to the different functions
        panel.add(btnCreateAccount);
        panel.add(btnCreateShipment);
        panel.add(btnTrackPackage);
        panel.add(btnViewInvoices);
        panel.add(btnEmailReceipt);
        panel.add(btnLogout);

        add(panel);


      //--------------------- create shipment request ---------------------
        btnCreateAccount.addActionListener(e -> {

            JTextField txtFName = new JTextField();
            JTextField txtLName = new JTextField();
            JTextField txtUsername = new JTextField();
            JTextField txtEmail = new JTextField();
            JTextField txtPhone = new JTextField();
            JTextField txtAddress = new JTextField();
            JPasswordField txtPassword = new JPasswordField();

            JPanel form = new JPanel(new GridLayout(7, 2, 5, 5));
            form.add(new JLabel("First Name:")); form.add(txtFName);
            form.add(new JLabel("Last Name:")); form.add(txtLName);
            form.add(new JLabel("Username:")); form.add(txtUsername);
            form.add(new JLabel("Email:")); form.add(txtEmail);
            form.add(new JLabel("Phone:")); form.add(txtPhone);
            form.add(new JLabel("Address:")); form.add(txtAddress);
            form.add(new JLabel("Password:")); form.add(txtPassword);

            int result = JOptionPane.showConfirmDialog(
                    this, form, "Create Account", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {

                Customer newCust = Customer.createAccountDB(
                        txtUsername.getText(),
                        txtFName.getText(),
                        txtLName.getText(),
                        txtEmail.getText(),
                        txtPhone.getText(),
                        txtAddress.getText(),
                        String.valueOf(txtPassword.getPassword())
                );

                if (newCust != null) {
                    JOptionPane.showMessageDialog(this,
                            "Account Created Successfully!\nYour User ID: " + newCust.getUserId());
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Account creation failed.\nCheck database connection.");
                }
            }
        });

      //--------------------- create shipment ---------------------
        btnCreateShipment.addActionListener(e -> {

            JTextField txtRecipient = new JTextField();
            JTextField txtRecAddress = new JTextField();
            JTextField txtWeight = new JTextField();

            JComboBox<String> cmbType = new JComboBox<>(new String[]{"Standard", "Express", "Fragile"});
            JComboBox<String> cmbZone = new JComboBox<>(new String[]{"1", "2", "3", "4"});

            JPanel form = new JPanel(new GridLayout(5, 2, 5, 5));
            form.add(new JLabel("Recipient Name:")); form.add(txtRecipient);
            form.add(new JLabel("Recipient Address:")); form.add(txtRecAddress);
            form.add(new JLabel("Weight (kg):")); form.add(txtWeight);
            form.add(new JLabel("Type:")); form.add(cmbType);
            form.add(new JLabel("Zone:")); form.add(cmbZone);

            int result = JOptionPane.showConfirmDialog(
                    this, form, "Create Shipment", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {

                try {
                    double weight = Double.parseDouble(txtWeight.getText());
                    String type = cmbType.getSelectedItem().toString();
                    int zone = Integer.parseInt(cmbZone.getSelectedItem().toString());

                    double cost = customer.createShipment(
                            weight,
                            type,
                            zone,
                            txtRecipient.getText(),
                            txtRecAddress.getText()
                    );

                    JOptionPane.showMessageDialog(this,
                            "Shipment Created!\nCost: $" + cost);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this,
                            "Invalid input.\nPlease enter correct values.");
                }
            }
        });

      //--------------------- ftrrac packages ---------------------
        btnTrackPackage.addActionListener(e -> {
            String trackingNo = JOptionPane.showInputDialog(this,
                    "Enter Tracking Number:");

            if (trackingNo != null && !trackingNo.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        customer.trackPackage(trackingNo));
            }
        });

      //--------------------- view invoices ---------------------
        btnViewInvoices.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    customer.viewInvoices());
        });


      //--------------------- logout ---------------------
        btnLogout.addActionListener(e -> dispose());
    }
}
