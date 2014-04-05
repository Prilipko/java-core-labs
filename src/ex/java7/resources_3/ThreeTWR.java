package ex.java7.resources_3;

import ex.java7.AutoCloseableFactory;
import ex.java7.TryBody;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 04.09.13
 * Time: 11:04
 * To change this template use File | Settings | File Templates.
 */
public class ThreeTWR implements Three {
    public void call(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB,
                     AutoCloseableFactory factoryC, TryBody body) throws Throwable {
        try (AutoCloseable resourceA = factoryA.create();
             AutoCloseable resourceB = factoryB.create();
             AutoCloseable resourceC = factoryC.create()) {
            body.runBody();
        }
    }
}