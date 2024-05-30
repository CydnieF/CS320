/*  
 *  Developer: Cydnie Fisher
 *  Date: May 29th, 2024
 *  Description: JUnit tests for main.Task
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Task;


class TaskTest {
	@Test // tests that task can be created
	void testTaskClass() {
		Task task = new Task ("1234567890", "task name", "task description");
		assertEquals("1234567890", task.getTaskID());
		assertEquals("task name", task.getTaskName());
		assertEquals("task description", task.getTaskDescription());
	}
	
	@Test // tests that assertion is thrown if task ID is invalid
	void testTaskIDInvalid() {
		// task ID is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345123456", "task name", "task description");	
		});
		// task ID is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "task name", "task description");
		});
	}
		
	@Test // tests that assertion is thrown if task name is invalid
	void testTaskNameInvalid() {
		// task Name is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234512345", "task name 1234567890-", "task description");
		});
		// task name is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234512345", null, "task description");
		});
	}

	@Test // tests that assertion is thrown if task description is invalid
	void testTaskDescriptionInvalid() {
		// task description is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234512345", "task name", 
					"task description 1234567890qwertyuiopasdfghjklzxcvbnm");
		});
		// task description is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234512345", "task name", null);
		});
	}
		
	@Test // tests setter method for task name, and if appropriate exceptions are thrown
	void testSetTaskName () {
		Task task = new Task ("1234512345", "task name", "task description");
		task.setTaskName ("name");
		assertEquals("name", task.getTaskName());
		// task name is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName("task name 1234567890-");
        });
        // task name is null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName(null);
        });
	}
	
	@Test // tests setter method for task description, and if appropriate exceptions are thrown
	void testSetTaskDescription () {
		Task task = new Task ("1234512345", "task name", "task description");
		task.setTaskDescription ("description");
		assertEquals("description", task.getTaskDescription());
		// task description is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription("task description 1234567890qwertyuiopasdfghjklzxcvbnm");
        });		
        // task description is null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription(null);
        });
	}
}