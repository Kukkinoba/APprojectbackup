package model;

public class Manager extends User {
	
	public Manager(int userId, String userName, String fName, String lName, String email, String password, String role) {
	super(userId, userName, fName, lName, email, password, role);
	
	}

	//open the  for customer role
	public void openMainPortal(){
		System.out.println("Opening Manager Portal For" + userName);
	
	
	}
}
