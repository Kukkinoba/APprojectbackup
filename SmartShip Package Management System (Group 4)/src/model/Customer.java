package model;

public class Customer extends User {

	public Customer(int userId, String userName, String fName, String lName, String email, String password, String role) {
	super(userId, userName, fName, lName, email, password, role);
	
	}

	//open the portal
	public void openMainPortal(){
		System.out.println("Opening Customer Portal For" + userName);
	}

	
	//--------------------Actions-------------------
	
	public void createAccount() {}
	public void createShippigRequest() {}
	public void trackPackage() {}
	public void receiveInvoice() {}
	public void emailReceipt() {}




}
