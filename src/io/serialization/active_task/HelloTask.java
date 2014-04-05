package io.serialization.active_task;

/**
 * Created with IntelliJ IDEA.
 * User: Prilipko
 * Date: 21.10.13
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HelloTask implements Task, Serializable {
    private String msg;
    private int counter;
    private long sleepTime;

    public HelloTask(String msg, int counter, long sleepTime) {
        this.msg = msg;
        this.counter = counter;
        this.sleepTime = sleepTime;
    }

    @Override
    public Task next() {
        System.out.println(msg + ":" + counter);
        counter--;
        return (counter == 0) ? null : this;
    }

    @Override
    public long sleepTime() {  return sleepTime;
    }

    public String getMsg() {
        return msg;
    }

    public int getCounter() {
        return counter;
    }

    public long getSleepTime() {
        return sleepTime;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(msg);
        out.writeInt(counter);
        out.writeLong(sleepTime);
    }

    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        this.msg = in.readUTF();
        this.counter = in.readInt();
        this.sleepTime = in.readLong();
    }
}

