package finalprojectclone;
/*
 * This To-Do List app allows the user to add tasks using a priority queue, which then 
 * sorts the tasks based on their level of importance as determined by the user. 
 * This ensures that tasks are listed with higher-priority tasks appearing first. 
 * Additionally, the app allows the user to complete a task by entering its task ID and provides 
 * the option to display completed tasks using a linked list.
 */
import java.util.LinkedList;
import java.util.Scanner;

public class savedtaskclone extends LinkedList<Task2> {

	private static final long serialVersionUID = -7307426967528470170L;

	/*
	 * This method display the complete task by using the tempQueu where 
	 * the task completed task was added to it 
	 */
	public void savedTask() {
		
		// if statement to check if tempQueue is empty
		if (this.isEmpty()) {
			System.out.println("No task found");
			
		// if not empty return tempQueue	
		} else {
			System.out.println(this);
		}
	}

	/*
	 * method to delete all completed task by using removeAll method 
	 */
	public void deleteAllCompletedtask() {
		// if statement to check if tempQueue is empty

		if (this.isEmpty()) {
			System.out.println("No task found");
		// if not empty delete all task in tempQueue	
		} else {
			System.out.println("All tasked removed " + this.removeAll(this));
		}
	}

	/* method to search for a task by letting the user enter the name of task 
	 * and check if the tempQueue have the task by using contain method
	 */
	public void search() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter task name");
		String task = scanner.nextLine();
		if (this.contains(task)) {
			System.out.println("found");
		} else {
			System.out.println("not found");
		}
	}

}
