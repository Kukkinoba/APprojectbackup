//Group members: Justin Mais (2103928) & Elisha Beverly (2100145)
package model;

import java.time.LocalDateTime;
import org.apache.logging.log4j.Logger;
import utils.LoggerManager;

import utils.Validator;

public abstract class User {
	// the logger
	protected static final Logger logger = LoggerManager.getLogger(User.class);
	
	
	//-----------------------Main Attributes-----------------------
	protected int userId;
	protected String userName;
	protected String fName;
	protected String lName;
	protected String email;
	protected String password;
	protected String role;
	protected LocalDateTime lastLogin;
	
	
	//---------------------Default Constructor---------------------
	public User() {
		userId = 0;
		userName = "";
		fName = "";
		lName = "";
		email = "";
		password = "";
		role = "";
		lastLogin = null;
	}
	

	//-------------------------Constructor-------------------------
	public User(int userId, String userName, String fName, String lName, String email, String password, String role) {
		this.userId = userId;
		this.userName = fName + " " + lName; //Username made from combining first and last
		this.fName = fName;
		this.lName = lName;
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
		if (Validator.validateEmail(email)) {
			this.email = email;
			logger.info("Email received for user: "+ userName +"\nEmail: "+ email);
		} else {
			logger.warn("This emails format is invalid for user: "+ userName +"\nEmail: "+ email);
			throw new IllegalArgumentException("Invalid email format");
		}
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		if (Validator.validatePassword(password)) {
			this.password = password;
			logger.info("Everything checks out "+ userName + ". Proceed!~");
		} else {
			logger.warn("Password validation failed. Are you a scammer "+ fName + "?" );
			throw new IllegalArgumentException("Invalid email format");
		}
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}	
	
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	
	
	
	
	//---------------------Login Function---------------------
	public static User Login(String email, String password) {
		
		//check email and password
		//validate with database
		//return whether or not it matches an entry
		//maybe an exception incase smthn wrong
		//return a statement if it matches, if not retry login
		//switch case to choose what portal to open if the role that matches the credentials
		
		
		return null;
		
	};
	
	
	
	
	
	//---------------------Logout Function---------------------
	public void Logout() {
		System.out.println(userName + " has logged out.");
		
	};
	
	
	
	
	//---------------------Portals Section---------------------
	abstract void openMainPortal();
}
