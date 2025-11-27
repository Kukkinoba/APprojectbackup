package model;

public class Test {
    public static void main(String[] args) {
        User u = User.Login("alice@smartship.com", "pass123");
        if (u != null) {
            System.out.println("Login successful for " + u.getUserName() + " (" + u.getRole() + ")");
            u.openMainPortal();
        }
    }
}
