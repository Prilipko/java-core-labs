package ex.java7.resources_2;

import ex.java7.AutoCloseableFactory;
import ex.java7.TryBody;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 04.09.13
 * Time: 11:04
 * To change this template use File | Settings | File Templates.
 */
public class TwoTWR implements Two {
    public void call(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB, TryBody
            body) throws Throwable {
        try (AutoCloseable resourceA = factoryA.create();
             AutoCloseable resourceB = factoryB.create()) {
            body.runBody();
        }
    }
}