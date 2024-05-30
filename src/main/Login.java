//package main;
//import javax.swing.JOptionPane;
////import javax.swing.JPasswordField;
////import javax.swing.JTextField;
//
//public class Login {
//	
//	public static void login() {
//		String username = Prompt.promptUserName();
//		User user = UserManager.findUserByUserName(username);
//		if (user == null) {
//			 JOptionPane.showMessageDialog(null,"User Not Found - Check that your Username is correct! \n");
//			return;
//		}
//		String password = Prompt.promptPassword();
//		Boolean valid = validateLoginCredentials(user, password);
//		if (valid) {
//			 JOptionPane.showMessageDialog(null,"\nSuccessfully Logged-In \n");
//			new Kanban();
//		} else {
//			 JOptionPane.showMessageDialog(null,"\nPasswords don't Match ... \n");
//		}
//	}
//	
//	private static Boolean validateLoginCredentials(User user, String password) {
//		if (user.getPassword().equals(password)) {
//			return true;
//		}
//		return false;
//	}
//	
//
//}

package main;
import EasyKanban.Kanban;
import javax.swing.JOptionPane;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;

public class Login {
	
	public static void login() {
		String username = Prompt.promptUserName();
		User user = UserManager.findUserByUserName(username);
		if (user == null) {
			 JOptionPane.showMessageDialog(null,"User Not Found - Check that your Username is correct! \n");
			return;
		}
		String password = Prompt.promptPassword();
		Boolean valid = validateLoginCredentials(user, password);
		if (valid) {
			 JOptionPane.showMessageDialog(null,"\nSuccessfully Logged-In \n");
			Kanban kanban = new Kanban();
                        
                        Kanban.runKanban();
                        
                        
		} else {
			 JOptionPane.showMessageDialog(null,"\nPasswords don't Match ... \n");
		}
	}
	
	private static Boolean validateLoginCredentials(User user, String password) {
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	

}