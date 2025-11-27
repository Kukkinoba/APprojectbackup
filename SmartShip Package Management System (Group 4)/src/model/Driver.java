package model;

public class Driver extends User {

	public Driver(int userId, String userName, String fName, String lName, String email, String password, String role, String phone) {
	super(userId, userName, fName, lName, email, password, role, phone);
	
	}

	//open the  for customer role
	public void openMainPortal(){
		System.out.println("Opening Driver Portal For" + userName);
	}
	
	//update shimpent status
	public void updateShipStat(int shipmentId, String status) {
		System.out.println("Shipment " + shipmentId + " updated to " + status);
}
}
