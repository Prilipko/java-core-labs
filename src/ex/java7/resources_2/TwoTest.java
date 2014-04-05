package ex.java7.resources_2;

import ex.java7.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 04.09.13
 * Time: 11:28
 * To change this template use File | Settings | File Templates.
 */
public class TwoTest extends ResourceTest {

    final private static Two twoImpl = new TwoImpl();
    final private static Two twoTWR = new TwoTWR();

    private static boolean Var(AutoCloseableFactory F1, AutoCloseableFactory F2, TryBody tryBody) {
        Throwable exImpl = new Exception("NOP");
        Throwable exTWR = exImpl;
        try {
            twoImpl.call( F1, F2, tryBody);
        } catch (Throwable ex) {
            exImpl = ex;
        }
        try {
            twoTWR.call( F1, F2, tryBody);
        } catch (Throwable ex) {
            exTWR = ex;
        }
        return exceptionMatcher(exImpl, exTWR);
    }

    public static void main(String[] args) throws Throwable {
        final List<Boolean> results = new LinkedList<>();

        results.add(Var(new FactoryOkOk("F1"), new FactoryOkOk("F2"), new BodyOk()));
        results.add(Var(new FactoryOkOk("F1"), new FactoryOkFail("F2"), new BodyOk()));
        results.add(Var(new FactoryOkFail("F1"), new FactoryOkOk("F2"), new BodyOk()));
        results.add(Var(new FactoryOkOk("F1"), new FactoryOkOk("F2"), new BodyFail()));
        results.add(Var(new FactoryOkOk("F1"), new FactoryFail("F2"), new BodyOk()));
        results.add(Var(new FactoryFail("F1"), new FactoryOkOk("F2"), new BodyOk()));
        results.add(Var(new FactoryOkFail("F1"), new FactoryOkFail("F2"), new BodyOk()));
        results.add(Var(new FactoryOkOk("F1"), new FactoryOkFail("F2"), new BodyFail()));
        results.add(Var(new FactoryOkFail("F1"), new FactoryOkOk("F2"), new BodyFail()));
        results.add(Var(new FactoryOkFail("F1"), new FactoryFail("F2"), new BodyOk()));
        results.add(Var(new FactoryOkFail("F1"), new FactoryOkFail("F2"), new BodyFail()));
        for(int i=0;i<results.size();i++){
            if(!results.get(i)){
                System.err.println("No equals variant: " + i);
                return;
            }
        }
        System.err.println("All right");
    }
}
