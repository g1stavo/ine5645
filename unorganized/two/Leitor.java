public class Leitor implements Runnable {

  public Buffer buffer;

  public Leitor(Buffer buffer) {
    this.buffer = buffer;
  }

  @Override
  public void run() {
    buffer.ler();
  }
}
