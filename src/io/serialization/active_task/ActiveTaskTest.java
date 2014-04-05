package io.serialization.active_task;

/**
 * Created with IntelliJ IDEA.
 * User: Prilipko
 * Date: 21.10.13
 * Time: 19:53
 * To change this template use File | Settings | File Templates.
 */
import java.io.*;
import java.util.Arrays;

public class ActiveTaskTest {
    public static void main(String[] args) throws Exception {

        ActiveTask oldActiveTask = new ActiveTask(new HelloTask("Hello", 20, 100));
        Thread.sleep(1000);

        byte[] rawData = writeActiveTask(oldActiveTask);
        System.out.println("rawData = " + Arrays.toString(rawData));
        System.out.println("rawData.length = " + rawData.length);
        System.out.println(new String(rawData, "UTF-8"));
        ActiveTask newActiveTask_0 = readActiveTask(rawData);
        ActiveTask newActiveTask_1 = readActiveTask(rawData);
        ActiveTask newActiveTask_2 = readActiveTask(rawData);
    }

    private static byte[] writeActiveTask(ActiveTask activeTask) throws IOException {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(buff);
        out.writeObject(activeTask);
        return buff.toByteArray();  }

    private static ActiveTask readActiveTask(byte[] rawData) throws IOException,
            ClassNotFoundException {
        return (ActiveTask) new ObjectInputStream(new
                ByteArrayInputStream(rawData)).readObject();
    }
}

