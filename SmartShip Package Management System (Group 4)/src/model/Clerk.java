package model;

public class Clerk extends User {

	public Clerk(int userId, String userName, String fName, String lName, String email, String password, String role, String phone) {
	super(userId, userName, fName, lName, email, password, role, phone);
	
	}

	//open the  for customer role
	public void openMainPortal(){
		System.out.println("Opening Clerk Portal For" + userName);
	}
	
	
	
	
	
	
	
	
	//--------------------Actions for the clerk-------------------
	
		public void manageVehicles() {
			//create new account interface
		}
		
		public void manageDeliSchedule() {
			//create shipping request interface
		}
		
		public void assignShipToVehicle(int shipmentId, int vehicleId) {
				System.out.println("assigning shipment " + shipmentId + "to vehilce" + vehicleId);
		}
		public void handlePay() {
			//print invoice on button press
		}
		
		public void viewPayslip() {
			//send email to receipt (find a way to implement it and send it to actual email account)
		}
}
