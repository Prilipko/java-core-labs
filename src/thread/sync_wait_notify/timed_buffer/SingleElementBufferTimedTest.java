package thread.sync_wait_notify.timed_buffer;

public class SingleElementBufferTimedTest {
    public static void main(String[] args) {
        SingleElementBufferTimed buffer = new SingleElementBufferTimed();
        new Thread(new ProducerTimed(1, 1000, buffer, 100)).start();
    }
}