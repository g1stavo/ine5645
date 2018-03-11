public class CubbyHole {
    private int contents;
    private boolean available = false;

    public synchronized int get(int who) {
        ...
    }

    public synchronized void put(int who, int value) {
        ...
    }
}