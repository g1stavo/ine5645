public class ThreadPoolTest2 {
  public static void main(String[] args) {
    int numWorkers = Integer.parseInt(args[0]);

    ExecutorService tpes = Executors.newCachedThreadPool();
    CallableWorkerThread workers[] = new CallableWorkerThread[numWorkers];
    Future<Integer> futures[] = new Future[numWorkers];

    for (int i = 0; i < numWorkers; i++) {
      workers[i] = new CallableWorkerThread(i);
      futures[i] = tpes.submit(workers[i]);
    }

    for (int i = 0; i < numWorkers; i++) {
      try {
        System.out.println("Ending worker: " + futures[i].get());
      } catch (Exception e) { }
    }
  }
}
