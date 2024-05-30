package EasyKanban;

import javax.swing.JOptionPane;
import main.Menu;
import main.Task;
import main.TaskManager;


public class Kanban {

    enum Items {
        AddTasks,
        ShowReport,
        Quit
    }
           
    public static void runKanban() {
        
        JOptionPane.showMessageDialog(null,"Welcome to Kanban!","welcome",JOptionPane.INFORMATION_MESSAGE);
        String[] options = {"AddTasks", "ShowReport", "Quit"};
        int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0 -> {
                TaskManager.showTaskManagerMenuItems();
                Task.NewTaskInformation();
            }
            case 1 -> JOptionPane.showMessageDialog(null, "Coming soon");
            case 2 -> {
                JOptionPane.showMessageDialog(null, "ReturnToMainMenu");
                Menu.promptUser(); // goes back to menu
            }
            default -> JOptionPane.showMessageDialog(null, "Invalid Option Selected - Try Again?", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        runKanban();
    }
}



//package main;
//import javax.swing.JOptionPane;
//import main.Menu;
//import Tasks.Task;
//import Tasks.TaskManager;
//
//public class Kanban {
//
//   
//	enum Items {
//		AddTasks,
//		ShowReport,
//		Quit
//	}
//	
//	Kanban() {
//		//showKanbanMenu();
//                String[] options = {"AddTasks", "ShowReport", "Quit"};
//                int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
//            
//            switch (choice) {
//                case 0 -> {
//                    TaskManager.showTaskManagerMenuItems();
//                    Task.NewTaskInformation();
//            }
//                case 1 -> JOptionPane.showMessageDialog(null, "Coming soon");
//                case 2 -> {
//                    JOptionPane.showMessageDialog(null, "ReturnToMainMenu");
//                    Menu.promptUser(); //goes back to menu
//            }
//                default -> JOptionPane.showMessageDialog(null, "Invalid Option Selected - Try Again?", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//            
//    }   
//        
//        
//}
