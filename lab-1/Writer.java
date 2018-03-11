public class Writer implements Runnable {
	private Buffer message;

	public Writer(Buffer msg) {
		message = msg;
	}

	@Override
	public void run() {
		for (int i = 0; i < 120; i++) {
			message.write(i);
		}
	}
}