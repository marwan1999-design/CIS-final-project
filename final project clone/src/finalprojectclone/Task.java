package finalprojectclone;

/*
 * /*
 * This To-Do List app allows the user to add tasks using a priority queue, which then 
 * sorts the tasks based on their level of importance as determined by the user. 
 * This ensures that tasks are listed with higher-priority tasks appearing first. 
 * Additionally, the app allows the user to complete a task by entering its task ID and provides 
 * the option to display completed tasks using a linked list.
 */
 

import java.util.*;

class TaskComparator implements Comparator<Task2> {
	public int compare(Task2 s1, Task2 s2) {
		if (s1.getLevelofImportant() < s2.getLevelofImportant())
			return 1;
		else if (s1.getLevelofImportant() > s2.getLevelofImportant())
			return -1;
		return 0;
	}
}

/*
 * A task class with parameters: task, levelOfImportant, and id, with getter and
 * setter methods for each.
 */

class Task2 implements Comparable<Task2> {

	private String task;
	private int levelofImportant;

	// int levelofImportant;
	private int id;

	public Task2() {
		task = "";
		levelofImportant = 0;
		id = 0;
	}

	// compareTo method to compare by level of importance, setting the smallest
	// number as the highest priority.
	@Override
	public int compareTo(Task2 o) {
		return Integer.compare(this.levelofImportant, o.levelofImportant); // Compare by priority
	}

	// A parameterized Task constructor
	public Task2(String task, int levelofImportant, int id) {
		this.task = task;
		this.setLevelofImportant(levelofImportant);
		this.id = id++;
	}

	public String toString() {

		return "Task {" + "id ='" + id + " task='" + task + '\'' + ", levelofImportant = " + getLevelofImportant() + '}'
				+ "\n";
	}

	public int getLevelofImportant() {
		return levelofImportant;
	}

	public void setLevelofImportant(int levelofImportant) {
		this.levelofImportant = levelofImportant;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// method to view incomplete task
	public void ViewIncompletedTasks(PriorityQueue<Task2> pq) {
		// This if statement checks if the queue is empty. If not, it proceeds to the
		// below code.

		if (pq.isEmpty()) {
			System.out.println("No task found");
		}

		// This prints out the number of tasks added using the size method.
		else {
			System.out.println("Number of tasks added: " + pq.size());

			/*
			 * This list sorts the items added using compareTo, from the smallest (highest
			 * priority) to the largest (lowest priority), and prints them out.
			 */

			List<Task2> sorted = new ArrayList<>(pq);
			Collections.sort((sorted));
			System.out.println("All task sorted n/" + sorted);

		}

	}

	// method to add a task
	public Task2 addTask(Scanner n) {
		Task2 taskadded;
		int levelofImportant;
		int min = 1;
		int max = 3;
		System.out.println("Add task name:");
		String task = n.nextLine();
		System.out.println("choose 1 for high priority, 2 for medium, 3 for low");

		/*
		 * This while loop ensures that the user enters a number from 1 - 3 by first
		 * checking if the input is a string. If it is, it prompts the user to enter the
		 * input again. If it is an integer, it then checks if the number is between 1
		 * and 3.
		 */

		while (true) {
			if (!n.hasNextInt()) {
				System.out.println("invalid input, only integer from 1 -3 are allowed");
				n.nextLine();
			} else {
				levelofImportant = n.nextInt();
				if (levelofImportant < min || levelofImportant > max) {
					System.out.println("Number is out of range");
					n.nextLine();
				}

				else {
					break;
				}
			}
		}

		int id = this.id++;
		// Task is added after getting user input, and a message is displayed confirming
		// the task has been added.
		taskadded = new Task2(task, levelofImportant, id);
		System.out.println("task added successfully");

		return taskadded;

	}

	// method to delete a task
	public void deletetask(Scanner in, PriorityQueue<Task2> pq, savedtaskclone tempQueue) {
		/*
		 * This if statement checks if the queue is empty. If it is, it proceeds to the
		 * below while loop.
		 */
		if (pq.isEmpty()) {

			System.out.println("No task found");
		}

		/*
		 * This while loop checks if the queue is not empty. If the queue is not empty,
		 * it displays the sorted list and asks the user to enter the task ID to be
		 * deleted. If the task ID entered is a string, an invalid input message is
		 * displayed, and the user is prompted for a different input.
		 */
		while (!pq.isEmpty()) {
			List<Task2> sorted = new ArrayList<>(pq);
			Collections.sort((sorted));
			System.out.println(sorted);
			System.out.println("enter task ID to complete: ");
			while (!in.hasNextInt()) {
				System.out.println("invalid input, only integer are allowed");
				in.next();

			}

			/*
			 * This for loop checks if the task ID entered matches an existing list. If it
			 * does, the task gets deleted, and a message is displayed indicating this. If
			 * the task ID is not found, it displays a "Task ID not found" message and exits
			 * the loop.
			 */

			int taskId = in.nextInt();
			for (Task2 task : pq) {
				if (task.id == taskId) {

					tempQueue.add(task);
					pq.remove(task);
					System.out.println("task deleted");

				} else {
					System.out.println("Task ID Not found");
				}
			}
			break;

		}
	}

	/*
	 * This method deletes all incomplete tasks. If the user decides to clear all
	 * tasks, this method simply checks if the queue is empty or not. If empty, it
	 * returns "No task found." If not empty, it clears all tasks using the clear
	 * method and returns a message: "All tasks cleared."
	 */
	public void deleteAllIncompleteTasks(PriorityQueue<Task2> pq) {
		// If statement to check if the queue is empty or not. If empty, it returns "No
		// task found."

		if (pq.isEmpty()) {
			System.out.println("No task found");
		}

		// If the queue is not empty, clear all tasks using the clear method.
		else {

			pq.clear();
			System.out.println("All tasked cleared");
		}

	}

}
