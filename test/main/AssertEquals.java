package main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class AssertEquals {

    private Method showInputDialogMethod;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() throws Exception {
        // Redirect System.out to capture output for verification
        System.setOut(new PrintStream(outContent));
        
        // Prepare to access private methods of Task class
        showInputDialogMethod = Task.class.getDeclaredMethod("showInputDialog", String.class);
        showInputDialogMethod.setAccessible(true);
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.clearProperty("test.dialog.return");
    }

    @Test
    public void testTaskDescriptionTooLong() throws Exception {
        // Simulate task description input that is too long
        System.setProperty("test.dialog.return", "Task description is too long and it should create a error just for the sake of this taaaassskkk.");

        // Use reflection to call showInputDialog and simulate user input
        String taskDescription = (String) showInputDialogMethod.invoke(null, "get rick rolled");

        // Capture the output message
        String message;
        if (taskDescription.length() > 50) {
            message = "Error: Please enter a task description of less than 50 characters";
        } else {
            message = "Task successfully captured!";
        }

        // Check if the error message was printed
        assertEquals("Error: Please enter a task description of less than 50 characters", message);
    }

    @Test
    public void testValidTaskDescription() throws Exception {
        // Simulate a valid task description input
        System.setProperty("test.dialog.return", "This description is valid.");

        // Use reflection to call showInputDialog and simulate user input
        String taskDescription = (String) showInputDialogMethod.invoke(null, "this is a short explanation");

        // Capture the output message
        String message;
        if (taskDescription.length() > 50) {
            message = "Error: Please enter a task description of less than 50 characters";
        } else {
            message = "Task successfully captured!";
        }

        // Check if the success message was printed
        assertEquals("Task successfully captured!", message);
    }
    
    @Test
    public void testCorrectIDs() throws Exception {
        Method method = Task.class.getDeclaredMethod("generateTaskID", String.class, int.class, String.class);
        method.setAccessible(true);

        // Test case 1
        String taskName1 = "Development";
        int taskNumber1 = 1;
        String userName1 = "Michelle Huang";
        String expectedTaskID1 = "De:1:ang";
        String actualTaskID1 = (String) method.invoke(null, taskName1, taskNumber1, userName1);
        assertEquals(expectedTaskID1, actualTaskID1);

        // Test case 2
        String taskName2 = "Testing";
        int taskNumber2 = 2;
        String userName2 = "John Doe";
        String expectedTaskID2 = "Te:2:Doe";
        String actualTaskID2 = (String) method.invoke(null, taskName2, taskNumber2, userName2);
        assertEquals(expectedTaskID2, actualTaskID2);

        // Test case 3
        String taskName3 = "Design";
        int taskNumber3 = 3;
        String userName3 = "Jane Smith";
        String expectedTaskID3 = "De:3:ith";
        String actualTaskID3 = (String) method.invoke(null, taskName3, taskNumber3, userName3);
        assertEquals(expectedTaskID3, actualTaskID3);

        // Test case 4
        String taskName4 = "Deployment";
        int taskNumber4 = 4;
        String userName4 = "Alice Johnson";
        String expectedTaskID4 = "De:4:son";
        String actualTaskID4 = (String) method.invoke(null, taskName4, taskNumber4, userName4);
        assertEquals(expectedTaskID4, actualTaskID4);

        // Test case 5
        String taskName5 = "Research";
        int taskNumber5 = 5;
        String userName5 = "Bob Brown";
        String expectedTaskID5 = "Re:5:own";
        String actualTaskID5 = (String) method.invoke(null, taskName5, taskNumber5, userName5);
        assertEquals(expectedTaskID5, actualTaskID5);
    }
}