package io.serialization.active_task;

/**
 * Created with IntelliJ IDEA.
 * User: Prilipko
 * Date: 21.10.13
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
public class TaskThread extends Thread {
    private Task task;
    private volatile boolean pause;

    public TaskThread(Task task) {
        this.task = task;
    }

    public void pauseStart() {
        this.pause = true;
        this.interrupt();
    }
    public void pauseStop() {
        this.pause = false;
    }

    @Override
    public void run() {
        while (task != null) {
            try {
                Thread.sleep(task.sleepTime());
            } catch (InterruptedException e) {
                if (pause) {
                    while (pause) ;
                } else {
                    return;
                }
            }
            task = task.next();
        }
    }

    public Task getTask() {
        return task;
    }
}