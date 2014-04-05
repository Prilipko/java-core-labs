package ex.mech;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 26.08.13
 * Time: 13:47
 * To change this template use File | Settings | File Templates.
 */
public interface TraceIF {
    public void f(Callable[] f) throws Exception;
    public Callable[] getVarFunc();
    public String getResult();
    public int getFunCount() ;
}
