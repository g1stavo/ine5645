public class Leitor implements Runnable {

  private Buffer mensagem;

  public Leitor(Buffer msg) {
    this.mensagem = msg;
  }

  @Override
  public void run() {
    for (int i = 0; i < 120; i++) {
      while (mensagem.ler() != 0) {}
    }
  }
}
