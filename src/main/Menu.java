package main;

import javax.swing.JOptionPane;

public class Menu {

    enum Items {
        Login,
        Register,
        Exit,
    }

//    public static void printMenuItems() {
//        JOptionPane.showMessageDialog(null,"Main Menu: \n");
//        for (int i = 0; i < Items.values().length; i++) {
//            System.out.println(i + ") " + Items.values()[i]);
//        }
//    }

     public static void promptUser() {
         
         JOptionPane.showMessageDialog(null, "Welcome! Please Select an option:", "Main Menu", JOptionPane.INFORMATION_MESSAGE);

        // Main menu loop
        while (true) {
            int choice = showMainMenu();
            switch (choice) {
                case 1:
                    Login.login();
                    break;
                case 2:
                    Registration.reg();
                    break;
                case 3:
                    // Exit message
                    JOptionPane.showMessageDialog(null,"Terminating Program!", "Exit", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    // Invalid choice message
                    JOptionPane.showMessageDialog(null, "Invalid Option Selected - Try Again?", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to display the main menu and get user input
    private static int showMainMenu() {
        String input = JOptionPane.showInputDialog("1. Login\n2. Register\n3. Exit");

        // Handling cancel or close operation
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Terminating Program...", "Terminated", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // Invalid input message
            JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        
//        String[] options = {"Login", "Register", "Exit"};
//        int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
//
//        switch (choice) {
//            case 0:
//                Login.login();
//                break;
//            case 1:
//                Registration.reg();
//                break;
//            case 2:
//                JOptionPane.showMessageDialog(null, "Terminating Program!", "Exit", JOptionPane.INFORMATION_MESSAGE);
//                System.exit(0); // Terminate the program
//            default:
//                JOptionPane.showMessageDialog(null, "Invalid Option Selected - Try Again?", "Error", JOptionPane.ERROR_MESSAGE);
//                break;
//        }
    }   

    
   
 }
