package finalprojectclone;
/*
 * This To-Do List app allows the user to add tasks using a priority queue, which then 
 * sorts the tasks based on their level of importance as determined by the user. 
 * This ensures that tasks are listed with higher-priority tasks appearing first. 
 * Additionally, the app allows the user to complete a task by entering its task ID and provides 
 * the option to display completed tasks using a linked list.
 */

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class taskDriver {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		boolean done = false;
		PriorityQueue<Task2> pq = new PriorityQueue<Task2>(new TaskComparator());
		// PriorityQueue<Task2> pq = new PriorityQueue<Task2>((t1, t2) ->
		// Integer.compare(t1.levelofImportant, t2.levelofImportant));

		savedtaskclone tempQueue = new savedtaskclone();
		LinkedList<Task2> savedtasks = new LinkedList<>();
		Task2 task = new Task2();

		/*
		 * while loop to exist the program if the user enter number 5 by assigning done
		 * = True so the loop will keeping running until the user enter number 5
		 */
		while (!done) {

			System.out.println("\n To Do List App: ");
			System.out.println("1. Add Task:");
			System.out.println("2. View Incompleted Tasks");
			System.out.println("3. Complete a Task: ");
			System.out.println("4. View Completed Tasks");
			System.out.println("5. Exit");
			System.out.println("6. search");
			System.out.println("8. Delete All Completed Tasks");
			System.out.println("9. Delete All Incomplete Task");
			System.out.println("Enter your choice: ");

			// while loop the ensure the user enter only number
			while (!in.hasNextInt()) {
				System.out.println("invalid choice, Only number are allwed");
				in.nextLine();

			}

			int choice = in.nextInt();
			in.nextLine();

			// this switch allow the user to choose from these option
			switch (choice) {
			// case 1 to add a task by using the addTask method
			case 1:
				pq.add(task.addTask(in));
				break;
			// case 2 to view incomplete tasks by using the ViewIncompletedTasks method

			case 2:
				task.ViewIncompletedTasks(pq);
				break;
			// case 3 to delete a task by using the deletetask method

			case 3:
				task.deletetask(in, pq, tempQueue);
				break;
			// case 4 to view saved task by using the savedTask method

			case 4:
				tempQueue.savedTask();

				break;
			// case 5 to exist the program by assigning done = true

			case 5:
				System.out.println("Exiting...");
				done = true;
				break;
			// case 6 to search for a task by using the search method

			case 6:
				tempQueue.search();

				// case 8 to delete all incomplete tasks by using the deleteAllCompletedtask
				// method

			case 8:
				tempQueue.deleteAllCompletedtask();
				break;
			// case 9 to delete all complete tasks by using the deleteAllIncompleteTasks
			// method

			case 9:
				task.deleteAllIncompleteTasks(pq);
				break;

			// if number not included in the cases above
			default:
				System.out.println("Invalid choice.");
			}

		}

		in.close(); // Close the scanner
	}
}
