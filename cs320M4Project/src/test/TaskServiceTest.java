package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Task;
import main.TaskService;

class TaskServiceTest {

	@Test
	public void testAddTask() {
		taskService.addTask ("1","task name", "task description");
		assertNotNull(taskService.getTask("1"));
	}

}
