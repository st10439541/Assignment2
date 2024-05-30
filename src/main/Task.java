//package main;
//
//import javax.swing.JOptionPane;
//
//public class Task {
//    private static int taskNumber = 0;
//
//    public static void NewTaskInformation() {
//        // Task Name
//        String taskName = showInputDialog("Enter the task name:");
//        
//        // Task Description
//        String taskDescription = showInputDialog("Enter task description:");
//        if (taskDescription.length() > 50) {
//            showMessageDialog("Error: Please enter a task description of less than 50 characters", "Error", JOptionPane.ERROR_MESSAGE);
//            return; // Exit the method if the description is too long
//        }
//        showMessageDialog("Task successfully captured!", "Task Description", JOptionPane.INFORMATION_MESSAGE);
//
//        // Developer Details
//        String developerDetails = promptUserName() + " " + promptLastName();
//        showMessageDialog("Developer details: " + developerDetails, "Developer", JOptionPane.INFORMATION_MESSAGE);
//
//        // Task Duration
//        String taskDurationStr = showInputDialog("Enter task duration (in hours):");
//        int taskDuration = Integer.parseInt(taskDurationStr);
//        showMessageDialog("Task duration: " + taskDuration + " hours", "Task Duration", JOptionPane.INFORMATION_MESSAGE);
//
//        // Task ID
//        String taskID = generateTaskID(taskName, taskNumber, promptUserName());
//        showMessageDialog("Task ID: " + taskID, "Task ID", JOptionPane.INFORMATION_MESSAGE);
//        taskNumber++; // Increment the task number for the next task
//
//        // Task Status
//        String taskStatus = showTaskStatusMenu();
//        if (taskStatus != null) {
//            showMessageDialog("""
//                Overall task information: 
//                Task name: """ + taskName + "\n" + 
//                "taskDescription: " + taskDescription + "\n" +       
//                "Developer details: " + developerDetails + "\n" + 
//                "Task duration: " + taskDuration + " hours\n" + 
//                "Task Status: " + taskStatus, 
//                "Task Information", JOptionPane.INFORMATION_MESSAGE);
//        }
//    }
//
//    static String showInputDialog(String message) {
//        String testValue = System.getProperty("test.dialog.return");
//        if (testValue != null) {
//            System.setProperty("test.dialog.return", "");
//            return testValue;
//        }
//        return JOptionPane.showInputDialog(message);
//    }
//
//    static void showMessageDialog(String message, String title, int messageType) {
//        JOptionPane.showMessageDialog(null, message, title, messageType);
//    }
//
//    static String promptUserName() {
//        return showInputDialog("Enter your first name:");
//    }
//
//    static String promptLastName() {
//        return showInputDialog("Enter your last name:");
//    }
//
//    static String generateTaskID(String taskName, int taskNumber, String userName) {
//        String prefix = taskName.length() >= 2 ? taskName.substring(0, 2) : taskName;
//        String suffix = userName.length() >= 3 ? userName.substring(userName.length() - 3) : userName;
//        return prefix + ":" + taskNumber + ":" + suffix;
//    }
//
//    static String showTaskStatusMenu() {
//        String input = showInputDialog("Choose task status:\n1. To Do\n2. Done\n3. Doing");
//
//        if (input != null && !input.isEmpty()) {
//            try {
//                int choice = Integer.parseInt(input);
//                return switch (choice) {
//                    case 1 -> "To Do";
//                    case 2 -> "Done";
//                    case 3 -> "Doing";
//                    default -> {
//                        showMessageDialog("Invalid choice. Defaulting to 'To Do'.", "Error", JOptionPane.ERROR_MESSAGE);
//                        yield "To Do";
//                    }
//                };
//            } catch (NumberFormatException e) {
//                showMessageDialog("Invalid choice. Cancelling...", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//        return null;
//    }
//}



package main;

import EasyKanban.Kanban;
import javax.swing.JOptionPane;

public class Task {
    private static int taskNumber = 0;

    public static void main(String[] args) {
        NewTaskInformation();
    }

    public static void NewTaskInformation() {
        while (true) {
            // Ask user how many tasks they need to input
            String taskCountStr = showInputDialog("How many tasks do you need to input?");
            if (taskCountStr == null) {
                // Returning back to Kanban
                Kanban.runKanban();
                return;
            }

            try {
                int taskCount = Integer.parseInt(taskCountStr);

                // Loop to input each task
                for (int i = 0; i < taskCount; i++) {
                    // Task Name
                    String taskName = showInputDialog("Enter the task name:");
                    if (taskName == null) {
                        Kanban.runKanban();
                        return; // If the user cancels, return to Kanban
                    }

                    // Task Description
                    String taskDescription = null;
                    while (true) {
                        taskDescription = showInputDialog("Enter task description:");
                        if (taskDescription == null) {
                            Kanban.runKanban();
                            return; // If the user cancels, return to Kanban
                        }
                        if (taskDescription.length() > 50) {
                            showMessageDialog("Error: Please enter a task description of less than 50 characters", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            break; // Exit the loop if the description length is valid
                        }
                    }
                    showMessageDialog("Task successfully captured!", "Task Description", JOptionPane.INFORMATION_MESSAGE);

                    // Developer Details
                    String firstName = promptUserName();
                    if (firstName == null) {
                        Kanban.runKanban();
                        return; // If the user cancels, return to Kanban
                    }
                    String lastName = promptLastName();
                    if (lastName == null) {
                        Kanban.runKanban();
                        return; // If the user cancels, return to Kanban
                    }
                    String developerDetails = firstName + " " + lastName;
                    showMessageDialog("Developer details: " + developerDetails, "Developer", JOptionPane.INFORMATION_MESSAGE);

                    // Task Duration
                    String taskDurationStr = showInputDialog("Enter task duration (in hours):");
                    if (taskDurationStr == null) {
                        Kanban.runKanban();
                        return; // If the user cancels, return to Kanban
                    }
                    int taskDuration = Integer.parseInt(taskDurationStr);
                    showMessageDialog("Task duration: " + taskDuration + " hours", "Task Duration", JOptionPane.INFORMATION_MESSAGE);

                    // Task ID
                    String taskID = generateTaskID(taskName, taskNumber, firstName);
                    showMessageDialog("Task ID: " + taskID, "Task ID", JOptionPane.INFORMATION_MESSAGE);
                    taskNumber++; // Increment the task number for the next task

                    // Task Status
                    String taskStatus = showTaskStatusMenu();
                    if (taskStatus == null) {
                        Kanban.runKanban();
                        return; // If the user cancels, return to Kanban
                    }
                    showMessageDialog("""
                        Overall task information: 
                        Task name: """ + taskName + "\n" + 
                        "Task Description: " + taskDescription + "\n" +       
                        "Developer details: " + developerDetails + "\n" + 
                        "Task duration: " + taskDuration + " hours\n" + 
                        "Task Status: " + taskStatus, 
                        "Task Information", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                showMessageDialog("Invalid number. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    static String showInputDialog(String message) {
        String testValue = System.getProperty("test.dialog.return");
        if (testValue != null) {
            System.setProperty("test.dialog.return", "");
            return testValue;
        }
        return JOptionPane.showInputDialog(message);
    }

    static void showMessageDialog(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }

    static String promptUserName() {
        return showInputDialog("Enter your first name:");
    }

    static String promptLastName() {
        return showInputDialog("Enter your last name:");
    }

    static String generateTaskID(String taskName, int taskNumber, String userName) {
        String prefix = taskName.length() >= 2 ? taskName.substring(0, 2) : taskName;
        String suffix = userName.length() >= 3 ? userName.substring(userName.length() - 3) : userName;
        return prefix + ":" + taskNumber + ":" + suffix;
    }

    static String showTaskStatusMenu() {
        String input = showInputDialog("Choose task status:\n1. To Do\n2. Done\n3. Doing");

        if (input != null && !input.isEmpty()) {
            try {
                int choice = Integer.parseInt(input);
                return switch (choice) {
                    case 1 -> "To Do";
                    case 2 -> "Done";
                    case 3 -> "Doing";
                    default -> {
                        showMessageDialog("Invalid choice", "Error", JOptionPane.ERROR_MESSAGE);
                        yield "To Do";
                    }
                };
            } catch (NumberFormatException e) {
                showMessageDialog("Invalid choice. Cancelling...", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        Kanban.runKanban();
        return null;
    }
}

