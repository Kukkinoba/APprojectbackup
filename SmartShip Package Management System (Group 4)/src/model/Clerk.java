package model;

public class Clerk extends User {

	public Clerk(int userId, String userName, String fName, String lName, String email, String password, String role, String phone) {
	super(userId, userName, fName, lName, email, password, role, phone);
	
	}

	//open the  for customer role
	public void openMainPortal(){
		System.out.println("Opening Clerk Portal For" + userName);
	}
	
	//assign shipment to vehicle
	public void assignShipToVehicle(int shipmentId, int vehicleId) {
			System.out.println("assigning shipment " + shipmentId + "to vehilce" + vehicleId);
	}
	
}
