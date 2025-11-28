package server;

import java.sql.*;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.Logger;
import utils.LoggerManager;
import model.*;
import model.User;
import model.Customer;
import model.Driver;

public class databaseConnection {

    //----------------------- Logger -----------------------
    private static final Logger logger = LoggerManager.getLogger(databaseConnection.class);

    //----------------------- Connection Details -----------------------
    private static final String DB_URL = "jdbc:mysql://localhost:3307/SmartShip";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "usbw";

    //----------------------- Get Connection -----------------------
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            logger.info("Connected to local SmartShip database successfully.");
            JOptionPane.showMessageDialog(null, "Connected to local server", "JDBC Connection Status", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            LoggerManager.logException(logger, "Failed to connect to SmartShip database", e);
            JOptionPane.showMessageDialog(null, "Database connection failed!", "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }

    //----------------------- Authenticate User -----------------------
    public static User authenticateUser(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        User user = null;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("userId");
                String userName = rs.getString("userName");
                String fName = rs.getString("fName");
                String lName = rs.getString("lName");
                String role = rs.getString("role");
                String phone = rs.getString("phone");
                String address = rs.getString("address");

                logger.info("Found user in database: " + email + " | Role: " + role);

                switch (role.toLowerCase()) {
                    case "manager":
                        user = new Manager(id, userName, fName, lName, email, password, role, phone);
                        break;
                    case "driver":
                        user = new Driver(id, userName, fName, lName, email, password, role, phone);
                        break;
                    case "customer":
                        user = new Customer(id, userName, fName, lName, email, password, role, phone, address);
                        break;
                    case "clerk":
                        user = new Clerk(id, userName, fName, lName, email, password, role, phone);
                        break;
                    default:
                        logger.warn("Unknown role '{}' for user: {}", role, email);
                        break;
                }
            } else {
                logger.warn("No matching credentials found for: " + email);
            }

        } catch (SQLException e) {
            LoggerManager.logException(logger, "SQL error while authenticating " + email, e);
        }

        return user;
    }

}