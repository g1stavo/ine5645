public class Reader implements Runnable {
	private Buffer message;

	public Reader(Buffer msg) {
		message = msg;
	}

	@Override
	public void run() {
		for (int i = 0; i < 120; i++) {
			while (message.read() != 0) {
				message.read();
			}
		}
	}
}