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
	
	@Test // tests that assertion is thrown if task ID is > 10 characters
	void testTaskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345123456", "task name", "task description");
		});
	}
	
	@Test // tests that assertion is thrown if task ID is null
	void testTaskIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "task name", "task description");
		});
	}
	
	@Test // tests that assertion is thrown if task name is > 20 characters
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234512345", "task name 1234567890-", "task description");
		});
	}
		
	@Test // tests that assertion is thrown if task name null
	void testTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234512345", null, "task description");
		});
	}

	@Test // tests that assertion is thrown if task description is > 50 characters
	void testTaskDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234512345", "task name", 
					"task description 1234567890qwertyuiopasdfghjklzxcvbnm");
		});
	}
			
	@Test // tests that assertion is thrown if task description null
	void testTaskDiscriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234512345", "task name", null);
		});
	}
		
	@Test
	void testSetTaskName () {
		Task task = new Task ("1234512345", "task name", "task description");
		task.setTaskName ("name");
		assertEquals("name", task.getTaskName());
		// too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName("task name 1234567890-");
        });
		
        // null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName(null);
        });
	}
	
	@Test
	void testSetTaskDescription () {
		Task task = new Task ("1234512345", "task name", "task description");
		task.setTaskDescription ("description");
		assertEquals("description", task.getTaskDescription());
		// too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription("task description 1234567890qwertyuiopasdfghjklzxcvbnm");
        });
		
        // null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription(null);
        });
	}

}

