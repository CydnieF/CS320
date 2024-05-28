package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Task;


class TaskTest1 {
	@Test
	void testTaskClass() {
		Task task = new Task ("1234567890", "task name", "task description");
		assertEquals("1234567890", task.getTaskID());
	}

}

