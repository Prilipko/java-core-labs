package ex.java7.resources_2;

import ex.java7.AutoCloseableFactory;
import ex.java7.TryBody;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 03.09.13
 * Time: 19:27
 * To change this template use File | Settings | File Templates.
 */
public interface Two {
    public void call(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB, TryBody
            body) throws Throwable;
}