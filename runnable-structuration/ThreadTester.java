import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTester {
  public static void main(String[] args) {
    PrintThread thread1 = new PrintThread("thread1");
    PrintThread thread2 = new PrintThread("thread2");
    PrintThread thread3 = new PrintThread("thread3");
    System.out.println("Starting threads");

    ExecutorService threadExecutor = Executors.newCachedThreadPool();
    threadExecutor.execute(thread1);
    threadExecutor.execute(thread2);
    threadExecutor.execute(thread3);
    threadExecutor.shutdown();
    
    System.out.println("Threads started, main ends\n");
  }
}
