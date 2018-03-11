import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    ScheduledExecutorService ste = Executors.newScheduledThreadPool(1);
    ExecutorService te = Executors.newFixedThreadPool(4);
    Buffer buffer = new Buffer();

    for (int i = 1; i <= 120; i++) {
      ste.scheduleAtFixedRate(new Escritor(buffer), 0, 1, TimeUnit.MILLISECONDS);
      te.execute(new Leitor(buffer));
    }
  }
}
