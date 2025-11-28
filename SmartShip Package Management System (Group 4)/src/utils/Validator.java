package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	//Sets the pattern for both what the email and pasword can contain plus 
	public static final Pattern VALIDATE_EMAIL_REGEX = 
	        Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
	        
	        
	public static final Pattern VALIDATE_PASSWORD_REGEX = 
			Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");
	        
	
	
	
	//validation checks for email
	public static boolean validateEmail(String email) {
		if(email == null) return false;
		Matcher matcher = VALIDATE_EMAIL_REGEX.matcher(email);
		return matcher.matches();
	}

	
	
	public static boolean validatePassword(String password) {
		if(password == null) return false;
		Matcher matcher = VALIDATE_PASSWORD_REGEX.matcher(password);
		return matcher.matches();
	}        
	        
}