package ex.java7;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 20.09.13
 * Time: 11:43
 * To change this template use File | Settings | File Templates.
 */
public abstract class ResourceTest {
    protected static boolean exceptionMatcher(Throwable ex1, Throwable ex2) {
        if (ex1 == ex2) return true;
        StackTraceElement[] ex1Stack = ex1.getStackTrace();
        StackTraceElement[] ex2Stack = ex1.getStackTrace();
        if (ex1Stack.length != ex2Stack.length) return false;
        for (int i = 0; i < ex1Stack.length; i++) {
            if (!ex1Stack[i].equals(ex2Stack[i])) return false;
        }

        Throwable[] ex1Suppressed = ex1.getSuppressed();
        Throwable[] ex2Suppressed = ex2.getSuppressed();
        if (ex1Suppressed.length != ex2Suppressed.length) return false;
        for (int i = 0; i < ex1Suppressed.length; i++) {
            if (!exceptionMatcher(ex1Suppressed[i], ex2Suppressed[i])) return false;
        }
        return true;
    }
}
