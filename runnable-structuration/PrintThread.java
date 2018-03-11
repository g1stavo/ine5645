import java.util.Random;

public class PrintThread implements Runnable {
  private int sleepTime;
  private String threadName;
  private static Random generator = new Random();

  public PrintThread(String name) {
    threadName = name;
    sleepTime = generator.nextInt(5000);
  }

  public void run() {
    try {
      System.out.printf("%s going to sleep for %d milliseconds.\n", threadName, sleepTime);
      Thread.sleep(sleepTime);
    } catch (InterruptedException exception) {
      exception.printStackTrace();
    }
    System.out.printf("%s done sleeping\n", threadName);
  }
}
