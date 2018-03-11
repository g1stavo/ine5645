import java.util.concurrent.*;
public class ProducerConsumerTest3 {
    public static void main(String[] args) {

        BlockingQueue c = new ArrayBlockingQueue(1);
        Producer3 p1 = new Producer3(c, 1);
        Consumer3 c1 = new Consumer3(c, 1);

        p1.start();
        c1.start();
    }
}