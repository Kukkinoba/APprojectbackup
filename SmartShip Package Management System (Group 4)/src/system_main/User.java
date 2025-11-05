//Group members: Justin Mais () & Elisha Beverly (2100145)
package system_main;

public abstract class User {
	
	//-----------------------Main Attributes-----------------------
	protected int userId;
	protected String userName;
	protected String fName;
	protected String lName;
	protected String email;
	protected String password;
	protected String role;
	
	//---------------------Default Constructor---------------------
	public User() {
		userId = 0;
		userName = "";
		fName = "";
		lName = "";
		email = "";
		password = "";
		role = "";
	}
	
	//-------------------------Constructor-------------------------
	public User(int userID, String name, String email, String password, String role) {
		super();
		this.userId = userID;
		this.fName = name;
		this.lName = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	
	
	//---------------------Getters and Setters---------------------
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}	;
	
	
	//---------------------Login Function---------------------
	public static User Login(String email, String password) {
		return null;
		
	};
	
	
	//---------------------Logout Function---------------------
	public void Logout() {
		System.out.println(userName + " has logged out.");
		
	};
	
	//---------------------Portals Section---------------------
	
}
