import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) {
    Buffer buffer = new Buffer();
    ScheduledExecutorService threadsEscritoras = Executors.newScheduledThreadPool(1);
    ExecutorService threadsLeitoras = Executors.newFixedThreadPool(4);

    try {
      for (int i = 0; i < 120; i++) {
        threadsLeitoras.execute(new Leitor(buffer));
        threadsEscritoras.scheduleAtFixedRate(new Escritor(buffer), 0, 300, TimeUnit.MILLISECONDS);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    threadsEscritoras.shutdownNow();
    threadsLeitoras.shutdownNow();

    while (!threadsEscritoras.isTerminated()) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        System.out.println("Thread: " + Thread.currentThread().getName() + " não finalizada.");
      }
    }
    System.exit(0);
  }
}
