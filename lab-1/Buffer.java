import static java.lang.System.out;

public class Buffer {
	private int message;
	private int readerThread;
	private boolean busy;
	private String threadName = Thread.currentThread().getName();

	public synchronized void write(int msg) {
		while (busy) {
			try {
				wait();
			} catch (InterruptedException interruptedException) {
				out.println("Thread " + threadName + " did not write the message.");
			}
		}
		message = msg;
		busy = true;
		out.println(threadName + " write: " + message);
		notifyAll();
	}

	public synchronized int read() {
		while (!busy) {
			try {
				wait();
			} catch (InterruptedException interruptedException) {
				out.println("Thread " + threadName + " did not read the message.");
			}
		}
		if (readerThread < 4) {
			readerThread++;
			out.println(threadName + " read: " + message);
		} else if (readerThread == 4) {
			busy = false;
			readerThread = 0;
			notify();
		}
		return message;
	}
}