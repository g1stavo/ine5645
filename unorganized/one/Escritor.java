package principal;

public class Escritor implements Runnable {
  private Buffer sharedLocation;

  private int z;

  public Escritor(Buffer shared) {
    sharedLocation = shared;
  }

  public void run() {
    for (int z = 0; z <= 120; z++) {
      sharedLocation.escrever(z);
    }
  }
}
