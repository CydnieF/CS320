/*  
 *  Developer: Cydnie Fisher
 *  Date: May 29th, 2024
 *  Description: JUnit tests for main.TaskService
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.TaskService;

class TaskServiceTest {
	
	private TaskService taskService;
	
	@BeforeEach
	public void setUp() {
		taskService = new TaskService();
	}
	
	@Test // tests that a new task can be added
	public void testAddTask() {
		taskService.addTask ("1","task name", "task description");
		assertNotNull(taskService.getTask("1"));
	}
	
	@Test // tests that the same task ID can't be used twice at the same time
	public void testAddTaskDuplicateID() {
		taskService.addTask ("1","task name", "task description");
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask("1", "name", "description");
		});	
	}
	
	@Test // tests that a task can be deleted
	public void testDeleteTask() {
        taskService.addTask("1","task name", "task description");
        taskService.deleteTask("1");
        assertNull(taskService.getTask("1"));
        // tests that only valid tasks can be deleted
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("2");
        });
    }
    
    @Test // tests that a tasks attributes can be updated using the task ID
    public void testUpdateTaskName() {
        taskService.addTask("1","task name", "task description");
        // task name can be updated
        taskService.updateTaskName("1", "name");
        assertEquals("name", taskService.getTask("1").getTaskName());
        // task description can be updated
        taskService.updateTaskDescription("1", "description");
        assertEquals("description", taskService.getTask("1").getTaskDescription());
    }
    
    @Test // tests that an exception is thrown when trying to update a nonexistant task
    public void testUpdateTaskNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("3", "name");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("3", "description");
        });
    }
}
