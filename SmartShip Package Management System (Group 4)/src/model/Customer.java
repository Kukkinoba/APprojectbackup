package model;

public class Customer extends User {

	public Customer(int userId, String userName, String fName, String lName, String email, String password, String role) {
	super(userId, userName, fName, lName, email, password, role);
	
	}

	//open the  for customer role
	public void openMainPortal(){
		System.out.println("Opening Customer Portal For" + userName);
	}

	
	//--------------------Actions-------------------
	
	public void createAccount() {
		//create new account interface
	}
	
	public void createShippigRequest() {
		//create shipping request interface
	}
	
	public void trackPackage() {
		//create package tracking interface
	}
	
	public void receiveInvoice() {
		//print invoice on button press
	}
	
	public void emailReceipt() {
		//send email to receipt (find a way to implement it and send it to actual email account)
	}




}
