package concurrencyapi.forkjoinpool;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolDemo {
	
	public static void main(String args[]) {
		
		ForkJoinPool Pool = new ForkJoinPool(12);  
		MyRecursiveAction myRecursiveAction = new MyRecursiveAction(12);
		//Pool.invoke(myRecursiveAction);
		System.out.println("MyRecursiveAction : Result : " +Pool.invoke(myRecursiveAction));
		MyRecursiveTask myRecursiveTask = new MyRecursiveTask(7);
		String result = (String) Pool.invoke(myRecursiveTask);
		System.out.println("MyRecursiveTask : Result : "+result);
	}

	
	
}
