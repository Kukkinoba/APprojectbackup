package model;

public class Manager extends User {
	
	public Manager(int userId, String userName, String fName, String lName, String email, String password, String role, String phone) {
	super(userId, userName, fName, lName, email, password, role, phone);
	
	}

	//open the  for customer role
	public void openMainPortal(){
		System.out.println("Opening Manager Portal For" + userName);
	}
	
	
	//--------------------Actions for the manager-------------------
	
	public void makePayslip() {
		//send email to receipt (find a way to implement it and send it to actual email account)
	}
	
	public void manageAccounts() {
		//send email to receipt (find a way to implement it and send it to actual email account)
	}

	//generate report for manager
	public void genReport(String reportType){
		System.out.println("Generating" + reportType + "report.");
	}
	
	public void exportReport() {
		//send email to receipt (find a way to implement it and send it to actual email account)
	}
	
}


package model;

public class Manager extends User {

    // -------------------- Constructor --------------------
    public Manager(int userId, String userName, String fName, String lName,
                   String email, String password, String role, String phone) {

        super(userId, userName, fName, lName, email, password, role, phone);
    }

    // -------------------- Portal Override --------------------
    @Override
    public void openPortal() {
        System.out.println("Opening Manager Portal for " + getFullName());
        // Later: Launch Manager GUI window:
        // new ManagerPortal(this).setVisible(true);
    }

    // -------------------- Manager Actions --------------------

    /** 
     * Generate payslip for a user (Driver/Clerk)
     */
    public void makePayslip(int employeeId, double gross, double deductions) {
        System.out.println("Generating payslip for User ID: " + employeeId);
        // TODO: Create PaySlip object & insert into DB
        // TODO: Send receipt or PDF via email
    }

    /**
     * Manage all user accounts (create, disable, update roles)
     */
    public void manageAccounts() {
        System.out.println("Accessing User Account Management...");
        // TODO: Perform account operations
    }

    /**
     * Generate analytical or performance reports
     */
    public void genReport(String reportType) {
        System.out.println("Generating " + reportType + " report...");
        // TODO: Create report logic: shipment/delivery/vehicle utilization
    }

    /**
     * Export reports to PDF or email
     */
    public void exportReport(String reportType) {
        System.out.println("Exporting " + reportType + " report to PDF...");
        // TODO: PDF export using iText / Apache PDFBox
        // TODO: Optionally email to manager
    }
}
