package ex.java7;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 04.09.13
 * Time: 11:10
 * To change this template use File | Settings | File Templates.
 */
public class BodyFail implements TryBody {
    public void runBody() throws Throwable {
        System.err.println("body");
        throw new Error("body");
    }
}