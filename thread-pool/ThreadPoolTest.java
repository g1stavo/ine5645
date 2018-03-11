import java.util.concurrent.*;

public class ThreadPoolTest {
  public static void main(String[] args) {
    int numWorkers = Integer.parseInt(args[0]);
    int threadPoolSize = Integer.parseInt(args[1]);

    ExecutorService tpes = Executors.newFixedThreadPool(threadPoolSize);

    WorkerThread[] workers = new WorkerThread[numWorkers];
    for (int i = 0; i < numWorkers; i++) {
      workers[i] = new WorkerThread(i);
      tpes.execute(workers[i]);
    }
    tpes.shutdown();
  }
}
