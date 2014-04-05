package ex.java7.resources_3;

import ex.java7.AutoCloseableFactory;
import ex.java7.TryBody;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 03.09.13
 * Time: 19:27
 * To change this template use File | Settings | File Templates.
 */
public interface Three {
    public void call(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB,
                     AutoCloseableFactory factoryC, TryBody body) throws Throwable;
}