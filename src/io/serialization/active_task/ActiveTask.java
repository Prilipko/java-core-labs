package io.serialization.active_task;

/**
 * Created with IntelliJ IDEA.
 * User: Prilipko
 * Date: 21.10.13
 * Time: 19:53
 * To change this template use File | Settings | File Templates.
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ActiveTask implements Serializable {
    private transient TaskThread thread;

    public ActiveTask(Task task) {
        this.thread = new TaskThread(task);
        this.thread.start();
    }

    public void pauseStart() {
        thread.pauseStart();
    }

    public void pauseStop() {
        thread.pauseStop();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        thread.pauseStart();
        Task intTask = thread.getTask();
        if (intTask instanceof HelloTask) {
            HelloTask helloTask = (HelloTask) intTask;
            out.writeObject(helloTask.getMsg());
            out.writeInt(helloTask.getCounter());
            out.writeLong(helloTask.getSleepTime());
        } else {
            Task task = thread.getTask();
            out.writeObject(task);
        }
        thread.pauseStop();
    }

    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        Object tmpTask;
        tmpTask = in.readObject();

        if (tmpTask instanceof Task) {
            this.thread = new TaskThread((Task)tmpTask);
        } else {
            String msg = (String)tmpTask;
            int counter = in.readInt();
            long sleepTime = in.readLong();
            HelloTask tmpHT = new HelloTask(msg,counter,sleepTime);
            this.thread = new TaskThread(tmpHT);
        }
        this.thread.start();
    }
}