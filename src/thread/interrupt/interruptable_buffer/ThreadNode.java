package thread.interrupt.interruptable_buffer;

public class ThreadNode {
    public final Thread thread;
    public final ThreadNode nextNode;

    public ThreadNode(Thread thread, ThreadNode nextNode) {
        this.thread = thread;
        this.nextNode = nextNode;
    }
}