public class Buffer {

  private int mensagem = 0;
  private int threadLeitor = 0;
  private boolean occupied = false;

  public synchronized void escrever(int msg) {
    while (occupied) {
      try {
        wait();
      } catch (InterruptedException e) {
        System.out.println(
            "A thread: " + Thread.currentThread().getName() + " não escreveu a mensagem.");
      }
    }
    mensagem = msg;
    occupied = true;
    String nomethread = Thread.currentThread().getName();
    System.out.println(nomethread + "-" + "MENSAGEM ENVIADA: " + msg);
    notifyAll();
  }

  public synchronized int ler() {
    String nomethread = Thread.currentThread().getName();
    while (!occupied) {
      try {
        wait();
      } catch (InterruptedException e) {
        System.out.println(
            "A thread: " + Thread.currentThread().getName() + " não leu a mensagem.");
      }
    }
    if (threadLeitor < 4) {
      int msgRecebida = mensagem;
      threadLeitor++;
      System.out.println(nomethread + "-" + "Mensagem recebida: " + msgRecebida);
    }
    if (threadLeitor == 4) {
      occupied = false;
      threadLeitor = 0;
      notify();
    }
    return mensagem;
  }
}
