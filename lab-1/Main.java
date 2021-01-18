import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import static java.lang.System.out;

public class Main {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		ScheduledExecutorService writerThreads = Executors.newScheduledThreadPool(1);
		ExecutorService readerThreads = Executors.newFixedThreadPool(4);

		try {
			for (int i = 0; i < 120; i++) {
				readerThreads.execute(new Reader(buffer));
				writerThreads.scheduleAtFixedRate(new Writer(buffer), 0, 1, TimeUnit.MILLISECONDS);
			}
		} catch (Exception exception) {
			out.println("An exception has ocurred!");
		}

		writerThreads.shutdownNow();
		readerThreads.shutdownNow();
		
		while (!writerThreads.isTerminated()) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
        		out.println("Thread " + Thread.currentThread().getName() + " not finished.");
      		}
		}
		System.exit(0);
	}
}