public class Escritor implements Runnable {

  private Buffer buffer;
  private static int valor = 0;
  public Escritor(Buffer buffer) {
    this.buffer = buffer;
  }

  @Override
  public void run() {
    buffer.escrever(valor++);
  }
}
