public class Escritor implements Runnable {

  private Buffer mensagem;

  public Escritor(Buffer msg) {
    this.mensagem = msg;
  }

  @Override
  public void run() {
    for (int i = 1; i <= 120; i++) {
      mensagem.escrever(i);
    }
  }
}
