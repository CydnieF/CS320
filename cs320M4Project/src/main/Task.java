/*  
 *  Developer: Cydnie Fisher
 *  Date: May 29th, 2024
 *  Description: Sets requirement and create getters and setters for task attributes
 */
package main;

public class Task {
    private final String taskID;
    private String taskName;
    private String taskDescription;

    // constructor for Task
    public Task(String taskID, String taskName, String taskDescription) {
    	// task ID cannot be null, or greater than 10 characters
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        // task name cannot be null, or greater than 20 characters
        if (taskName == null || taskName.length() > 20) {
            throw new IllegalArgumentException("Invalid task name");
        }
        // task description cannot be null, or greater than 50 characters
        if (taskDescription == null || taskDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid task description");
        }

        this.taskID = taskID;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    // getters and setters for task attributes
    public String getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    // task name cannot be null or greater than 20 characters
    public void setTaskName(String taskName) {
        if (taskName == null || taskName.length() > 20) {
            throw new IllegalArgumentException("Invalid task name");
        }
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    // task description cannot be null or greater than 50 characters
    public void setTaskDescription(String taskDescription) {
        if (taskDescription == null || taskDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid task description");
        }
        this.taskDescription = taskDescription;
    }
}
