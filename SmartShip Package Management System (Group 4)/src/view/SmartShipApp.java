package view;

import java.util.Scanner;
import model.*;
import server.databaseConnection;

public class SmartShipApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====== SMARTSHIP LOGIN ======");
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        User user = databaseConnection.authenticateUser(email, password);
        if (user != null) {
            System.out.println("Login successful! Redirecting to portal...");
            user.openMainPortal();
        } else {
            System.out.println("Login failed. Check credentials.");
        }
    }
}
