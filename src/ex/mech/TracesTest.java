package ex.mech;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 26.08.13
 * Time: 12:16
 * To change this template use File | Settings | File Templates.
 */
public class TracesTest {
    public static void main(String[] args) {
        //TraceIF trace = new ex.mech.traces_1.Lab();
        TraceIF trace = new ex.mech.traces_2.ExceptionMultiCatchLab();
        BruteForce.resFunc(trace.getVarFunc(),new Callable[trace.getFunCount()],0,trace);
        for(String s: BruteForce.getResult()){
            System.out.println(s);
        }
    }
}
