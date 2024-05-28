package main;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	// stores tasks and their attributes
    private final Map<String, Task> tasks; //= new HashMap<>();
    public TaskService() {
    	this.tasks = new HashMap <>();
    }

    // allows for a new task to be created
    public void addTask(String taskID, String taskName, String taskDescription) {
    	// ensure that task ID is not already in use
        if (tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        Task newTask = new Task(taskID, taskName, taskDescription);
        tasks.put(taskID, newTask);
    }

    // allow for a task to be deleted via task ID
    public void deleteTask(String taskID) {
    	// ensure that task id is already in use
        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        // remove deleted task ID so it van be used again
        tasks.remove(taskID);
    }

    // allow for task's name to be updated via task ID
    public void updateTaskName(String taskID, String newTaskName) {
        Task task = tasks.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        task.setTaskName(newTaskName);
    }

    // allow for task's description to be updated via task ID
    public void updateTasktaskDescription(String taskID, String newTaskDescription) {
        Task task = tasks.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        task.setTaskDescription(newTaskDescription);
    }
    
    // get task information via task ID
    public Task getTask (String taskID) {
    	return tasks.get(taskID);
    }

}
