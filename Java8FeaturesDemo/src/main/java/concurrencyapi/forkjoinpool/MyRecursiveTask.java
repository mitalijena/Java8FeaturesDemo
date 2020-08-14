package concurrencyapi.forkjoinpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask<String> extends RecursiveTask<String> {

	private long workLoad = 0;

	public MyRecursiveTask(long workLoad) {
		this.workLoad = workLoad;
	}

	@Override
	protected String compute() {
		// if work is above threshold, break tasks up into smaller tasks
		if (this.workLoad > 10) {
			System.out.println("MyRecursiveTask : Splitting workLoad : " + this.workLoad);

			List<MyRecursiveAction> subtasks = new ArrayList<MyRecursiveAction>();

			subtasks.addAll(createSubtasks());

			// ForkJoinTask.invokeAll(subtasks);
			for (RecursiveAction subtask : subtasks) {
				subtask.fork();
			}

		} else {
			System.out.println("MyRecursiveTask : Doing workLoad myself: " + this.workLoad);
		}
		return (String) "success";
	}

	private List<MyRecursiveAction> createSubtasks() {
		List<MyRecursiveAction> subtasks = new ArrayList<MyRecursiveAction>();

		MyRecursiveAction subtask1 = new MyRecursiveAction(this.workLoad / 2);
		MyRecursiveAction subtask2 = new MyRecursiveAction(this.workLoad / 2);

		subtasks.add(subtask1);
		subtasks.add(subtask2);

		return subtasks;

	}
	

}
