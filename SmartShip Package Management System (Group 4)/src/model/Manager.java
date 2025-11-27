package model;

public class Manager extends User {
	
	public Manager(int userId, String userName, String fName, String lName, String email, String password, String role, String phone) {
	super(userId, userName, fName, lName, email, password, role, phone);
	
	}

	//open the  for customer role
	public void openMainPortal(){
		System.out.println("Opening Manager Portal For" + userName);
	}
	
	//generate report for manager
	public void genReport(String reportType){
		System.out.println("Generating" + reportType + "report.");
	}
}
