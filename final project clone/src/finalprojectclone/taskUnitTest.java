package finalprojectclone;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

class taskUnitTest {
	savedtaskclone tempQueue = new savedtaskclone();
	PriorityQueue<Task2> pq = new PriorityQueue<Task2>(new TaskComparator());

	@Test
	public void ViewIncompletedTasks() {

		if (pq.isEmpty()) {
			System.out.println("No task found");
		}

		while (!pq.isEmpty()) {
			assertTrue(pq.isEmpty());
			break;
		}

	}

	@Test
	public void deleteAll() {
		PriorityQueue<Task2> pq = new PriorityQueue<Task2>();
		Task2 task = new Task2();
		task.deleteAllIncompleteTasks(pq);
		assertTrue(pq.isEmpty());
	}

	@Test

	public void deleteAllCompletedtask() {

		savedtaskclone tempQueue2 = new savedtaskclone();

		Task2 task = new Task2();
		tempQueue2.deleteAllCompletedtask();
		assertTrue(tempQueue2.isEmpty());
	}

	@Test

	public void viewtask() {
		PriorityQueue<Task2> pq = new PriorityQueue<Task2>(new TaskComparator());

		Task2 task = new Task2();

		task.ViewIncompletedTasks(pq);

		assertEquals(pq, task);

	}

	@Test
	public void addTask() {
		Task2 task2 = new Task2("gym", 2, 0);
		System.out.print(task2.getTask());
		assertEquals("Task {id ='0 task='gym', levelofImportant = 2}", task2);

	}

	public void myPublicMethod() {
		PriorityQueue<Task2> pq = new PriorityQueue<Task2>(new TaskComparator());

		Task2 task = new Task2();

		assertEquals(pq, pq);
	}

}
