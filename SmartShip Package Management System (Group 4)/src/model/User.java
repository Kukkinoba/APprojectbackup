//Group members: Justin Mais (2103928) & Elisha Beverly (2100145)
package model;

import java.time.LocalDateTime;
import java.util.logging.Level;

import org.apache.logging.log4j.Logger;
import utils.LoggerManager;
import server.databaseConnection;
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
	//--------------------- Login Function ---------------------
	public static User Login(String email, String password) {
	    try {
	        logger.info("Attempting login for " + email);

	        // Step 1: Validate credentials through database
	        User user = databaseConnection.authenticateUser(email, password);

	        // Step 2: Check if the database returned a matching user
	        if (user != null) {
	            user.setLastLogin(LocalDateTime.now());
	            logger.info("Login successful for user: " + email + " | Role: " + user.getRole());

	            // Step 3: Open the correct portal based on user role
	            switch (user.getRole().toLowerCase()) {
	                case "manager":
	                    logger.info("Redirecting " + user.getUserName() + " to Manager Portal...");
	                    user.openMainPortal();
	                    break;

	                case "driver":
	                    logger.info("Redirecting " + user.getUserName() + " to Driver Portal...");
	                    user.openMainPortal();
	                    break;

	                case "customer":
	                    logger.info("Redirecting " + user.getUserName() + " to Customer Portal...");
	                    user.openMainPortal();
	                    break;

	                case "clerk":
	                    logger.info("Redirecting " + user.getUserName() + " to Clerk Portal...");
	                    user.openMainPortal();
	                    break;

	                default:
	                    logger.warn("Unrecognized role for user: " + email + " | Role: " + user.getRole());
	                    System.out.println("Unknown role detected. Please contact an administrator.");
	                    break;
	            }

	            // Step 4: Return the logged-in user object
	            return user;

	        } else {
	            // No match found in database
	            logger.warn("Login failed for " + email + " - credentials not found in database.");
	            System.out.println("Login failed! Please check your email or password and try again.");
	            return null;
	        }

	    } catch (Exception e) {
	        // Step 5: Handle any errors gracefully
	        LoggerManager.logException(logger, "Error during login process for " + email, e);
	        System.out.println("An unexpected error occurred while logging in. Please try again later.");
	        return null;
	    }
	}
	
	
	
	
	
	//---------------------Logout Function---------------------
	public void Logout() {
		logger.info("User" + userName + "has logged out");
		System.out.println("Bye Bye"+ userName + "Come back soon <3");
		
	};
	
	
	// change password function
	public void changePassword() {}
	
	
	//---------------------Portals Section---------------------
	abstract void openMainPortal();
}
