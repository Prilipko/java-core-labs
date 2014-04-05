package io.serialization.active_task;

/**
 * Created with IntelliJ IDEA.
 * User: Prilipko
 * Date: 21.10.13
 * Time: 18:23
 * To change this template use File | Settings | File Templates.
 */
public interface Task {
    public Task next();
    public long sleepTime();
}
