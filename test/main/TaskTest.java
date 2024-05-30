package main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class TaskTest {

    @Before
    public void setUp() {
        // Reset task number before each test
        try {
            Method resetTaskNumber = Task.class.getDeclaredMethod("setTaskNumber", int.class);
            resetTaskNumber.setAccessible(true);
            resetTaskNumber.invoke(null, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        System.clearProperty("test.dialog.return");
    }

    @Test
    public void testGenerateTaskID() throws Exception {
        Method method = Task.class.getDeclaredMethod("generateTaskID", String.class, int.class, String.class);
        method.setAccessible(true);

        String taskName = "Development";
        int taskNumber = 1;
        String userName = "Michelle Huang";

        String expectedTaskID = "De:1:ang";
        String actualTaskID = (String) method.invoke(null, taskName, taskNumber, userName);

        assertEquals(expectedTaskID, actualTaskID);
    }

    @Test
    public void testShowTaskStatusMenu_ToDo() throws Exception {
        System.setProperty("test.dialog.return", "1");
        Method method = Task.class.getDeclaredMethod("showTaskStatusMenu");
        method.setAccessible(true);

        String expectedStatus = "To Do";
        String actualStatus = (String) method.invoke(null);

        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    public void testShowTaskStatusMenu_Done() throws Exception {
        System.setProperty("test.dialog.return", "2");
        Method method = Task.class.getDeclaredMethod("showTaskStatusMenu");
        method.setAccessible(true);

        String expectedStatus = "Done";
        String actualStatus = (String) method.invoke(null);

        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    public void testShowTaskStatusMenu_Doing() throws Exception {
        System.setProperty("test.dialog.return", "3");
        Method method = Task.class.getDeclaredMethod("showTaskStatusMenu");
        method.setAccessible(true);

        String expectedStatus = "Doing";
        String actualStatus = (String) method.invoke(null);

        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    public void testShowTaskStatusMenu_Invalid() throws Exception {
        System.setProperty("test.dialog.return", "4");
        Method method = Task.class.getDeclaredMethod("showTaskStatusMenu");
        method.setAccessible(true);

        String expectedStatus = "To Do";
        String actualStatus = (String) method.invoke(null);

        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    public void testCreateTwoTasks() throws Exception {
        // Reflection method to call private methods
        Method showInputDialog = Task.class.getDeclaredMethod("showInputDialog", String.class);
        showInputDialog.setAccessible(true);

        // Set up input for first task
        System.setProperty("test.dialog.return", "Login Feature");
        String taskName1 = (String) showInputDialog.invoke(null, "Enter the task name:");
        
        System.setProperty("test.dialog.return", "Create login to authenticate users");
        String taskDescription1 = (String) showInputDialog.invoke(null, "Enter task description:");

        System.setProperty("test.dialog.return", "Robyn");
        String developerFirstName1 = (String) showInputDialog.invoke(null, "Enter your first name:");

        System.setProperty("test.dialog.return", "Harrison");
        String developerLastName1 = (String) showInputDialog.invoke(null, "Enter your last name:");
        String developerDetails1 = developerFirstName1 + " " + developerLastName1;

        System.setProperty("test.dialog.return", "8");
        String taskDurationStr1 = (String) showInputDialog.invoke(null, "Enter task duration (in hours):");
        int taskDuration1 = Integer.parseInt(taskDurationStr1);

        String taskID1 = Task.generateTaskID(taskName1, 0, developerFirstName1);

        System.setProperty("test.dialog.return", "1");
        String taskStatus1 = Task.showTaskStatusMenu();

        // Set up input for second task
        System.setProperty("test.dialog.return", "Add task Feature");
        String taskName2 = (String) showInputDialog.invoke(null, "Enter the task name:");
        
        System.setProperty("test.dialog.return", "Create Add Task feature to add task users");
        String taskDescription2 = (String) showInputDialog.invoke(null, "Enter task description:");

        System.setProperty("test.dialog.return", "Mike");
        String developerFirstName2 = (String) showInputDialog.invoke(null, "Enter your first name:");

        System.setProperty("test.dialog.return", "Smith");
        String developerLastName2 = (String) showInputDialog.invoke(null, "Enter your last name:");
        String developerDetails2 = developerFirstName2 + " " + developerLastName2;

        System.setProperty("test.dialog.return", "10");
        String taskDurationStr2 = (String) showInputDialog.invoke(null, "Enter task duration (in hours):");
        int taskDuration2 = Integer.parseInt(taskDurationStr2);

        String taskID2 = Task.generateTaskID(taskName2, 1, developerFirstName2);

        System.setProperty("test.dialog.return", "3");
        String taskStatus2 = Task.showTaskStatusMenu();

        // Assertions to verify the two tasks
        assertEquals("Lo:0:byn", taskID1);
        assertEquals("Ad:1:ike", taskID2);
        assertEquals("To Do", taskStatus1);
        assertEquals("Doing", taskStatus2);
    }
}
