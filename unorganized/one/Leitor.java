package principal;

public class Leitor implements Runnable {
  private Buffer sharedLocation;

  public Leitor(Buffer shared) {
    sharedLocation = shared;
  }

  public void run() {
    for (int x = 0; x <= 120; x++) {
      sharedLocation.ler();
    }
  }
}
