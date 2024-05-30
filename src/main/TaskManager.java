package main;
import javax.swing.JOptionPane;


public class TaskManager {
	
        
	Task[] tasks = new Task[100];
	
	int taskCounter = 0; // Auto-Generated Primary Key // Increment when adding to Task[] array
	
	enum Items {
		
		AddNewTask,
		
		
	}

	// This function invokes the Task class constructor
	public static void createNewTask() {
            Task task = new Task();
            Task.NewTaskInformation();
        }
	

	
	public static void showTaskManagerMenuItems() {
		for (int i = 0; i < Items.values().length; i++) {
			System.out.println(i + ") " + Items.values()[i]);
		}
	}
	
	public static void promptUser() {
		int choice = Main.scanner.nextInt();
		Main.scanner.nextLine();
		
		if (choice == 0) {
			 JOptionPane.showMessageDialog(null,"TaskManager.AddNewTask");
		}
		
	
        }
}
                
               
	
 
               
	
