package ex.java7;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 04.09.13
 * Time: 11:02
 * To change this template use File | Settings | File Templates.
 */
public interface AutoCloseableFactory {
    AutoCloseable create() throws Throwable;
}
