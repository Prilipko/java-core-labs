package ex.mech;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 26.08.13
 * Time: 14:36
 * To change this template use File | Settings | File Templates.
 */
public class BruteForce {
    private static List<String> result = new LinkedList<>();
    public static List<String> getResult(){
        java.util.Collections.sort(result);
        return result;
    }

    static void resFunc(Callable[] arr, Callable[] res, int index, TraceIF trace) {
        if (index == res.length) {
                try{
                    trace.f(res);
                }
                catch (Throwable e){
                    // NOP
                }
                String tmp=trace.getResult();
                if(!result.contains(tmp)){
                    result.add(tmp);
                }
            return;
        }
        for (Callable c : arr) {
            res[index] = c;
            resFunc(arr, res, index + 1,trace);
        }
    }
}
