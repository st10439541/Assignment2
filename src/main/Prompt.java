package main;

import javax.swing.JOptionPane;

public class Prompt {

    public static String promptUserName() {
        String username = JOptionPane.showInputDialog(null, "Enter Username:");
        return username;
    }

    public static String promptPassword() {
        String password = JOptionPane.showInputDialog(null, "Enter Password:");
        return password;
    }

    public static String promptFirstName() {
        String firstName = JOptionPane.showInputDialog(null, "Enter First Name:");
        return firstName;
    }

    public static String promptLastName() {
        String lastName = JOptionPane.showInputDialog(null, "Enter Last Name:");
        return lastName;
    }

}