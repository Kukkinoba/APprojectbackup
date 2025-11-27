package model;

public class Customer extends User {

	public Customer(int userId, String userName, String fName, String lName, String email, String password, String role, String phone) {
	super(userId, userName, fName, lName, email, password, role, phone);
	
	}

	//open the  for customer role
	public void openMainPortal(){
		System.out.println("Opening Customer Portal For" + userName);
	}

	
	//--------------------Actions-------------------
	
	public void createAccount() {
		//create new account interface
	}
	
	public void createShippingRequest() {
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


	package model;
	public class Customer extends User {
	    private String address;
	    private String phone;

	    public Customer(int id, String name, String username, String password, String address, String phone) {
	        super(id, name, username, password, "Customer");
	        this.address = address;
	        this.phone = phone;
	    }

	    public String getAddress() { return address; }
	    public void setAddress(String address) { this.address = address; }
	    public String getPhone() { return phone; }
	    public void setPhone(String phone) { this.phone = phone; }
	}

}
