package utils;

import javax.swing.JOptionPane;

public class Format {

	// array of special characters from which the user can choose to create a password
	private static char[] characters = new char[] {'!', '@', '#', '$', '%', '^', '&', '*', '.', '-', '+',  '_'};
	
	public static Boolean checkUsernameComplexity(String username) {
		// fill in the details for checking whether a username is correctly formatted
		return true; // currently all username formats are acceptable
	}
	
	public static Boolean checkPasswordComplexity(String password) {
                // The  password contains (at least):
		//
		// 	- 1 Special Character
		//	- 1 Upper-Case Character
		//	- 1 Numeric Character
		//	- 8 Characters in Length
		//
		
		// Check if password is of the correct length
		if (password.length() < 8) {
			return false;
		}
		// Avoid regex using boolean flags !!!
		Boolean hasSpecialChar = false;
		Boolean hasNumericChar = false;
		Boolean hasUpperChar = false;
		
		// this loop iterates the password string only once,
		// but may have to iterate the entire character array above
		for (int i = 0; i < password.length(); i++) {
			char currentChar = password.charAt(i);
			if (contains(characters, currentChar)) {
				hasSpecialChar = true;
			}
			if (isNumeric(currentChar)) {
				hasNumericChar = true;
			}
			if (isUpper(currentChar)) {
				hasUpperChar = true;
			}
		}
		return (hasSpecialChar && hasNumericChar && hasUpperChar);
	}
	
	// function to check whether a character is contained in specified char array
	private static Boolean contains(char[] array_to_search, char character_to_find) {
		for (int i = 0; i < array_to_search.length; i++) {
			if (array_to_search[i] == character_to_find) {
				return true;
			}
		}
		return false;
	}
	
	public static Boolean isNumeric(char character) {
		return Character.isDigit(character);
	}
	
	public static Boolean isUpper(char character) {
		return Character.isUpperCase(character);
	}
	
	public static void printPasswordComplexityRules() {
		JOptionPane.showMessageDialog(null, """
                                                    Password Format Not Valid - Ensure the Following: 
                                                    Password MUST Contain (At Least): 
                                                    
                                                     - 8 Characters in Length
                                                     - 1 Special Character
                                                     - 1 Numeric Character
                                                     - 1 Upper-Case Character""");
		
	}
        
	
	public static void printUsernameComplexityRules() {
		// Inform the client how to format their username
		System.out.print("Inform client how to format their username correctly");
	}
        
        public static boolean checkNameComplexityRules(String firstName){
        // fill in the details for checking whether a username is correctly formatted
            return true; // currently all name formats are acceptable
        }
        
        public static Boolean checkfirstnameComplexity(String firstname) {
		// fill in the details for checking whether a username is correctly formatted
		return true; // currently all username formats are acceptable
	}
        public static void printFirstandLastnames(){
            JOptionPane.showMessageDialog(null,"Make sure client inputs their names");
        }
        
        public static void printNameComplexityRules(){
            JOptionPane.showMessageDialog(null, "names must be inputted to continue!!");
        }
	
        
       
}
