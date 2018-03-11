import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class RunnableTester {
   public static void main(String[] args) {
      PrintTask task1 = new PrintTask("thread1");
      PrintTask task2 = new PrintTask("thread2");
      PrintTask task3 = new PrintTask("thread3");        
      System.out.println("Starting threads");
      ExecutorService threadExecutor = Executors.newFixedThreadPool(3);
      threadExecutor.execute(task1); 
      threadExecutor.execute(task2);
      threadExecutor.execute(task3);
      threadExecutor.shutdown(); 
      System.out.println("Threads started, main ends\n");
   }
}