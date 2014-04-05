package ex.java7.resources_3;

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
public class ThreeTest extends ResourceTest {

    final private static Three THREE_IMPL = new ThreeImpl();
    final private static Three THREE_TWR = new ThreeTWR();

    private static boolean Var(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB,
                               AutoCloseableFactory factoryC, TryBody body) {
        Throwable exImpl = new Exception("NOP");
        Throwable exTWR = exImpl;
        try {
            THREE_IMPL.call(factoryA, factoryB, factoryC, body);
        } catch (Throwable ex) {
            exImpl = ex;
        }
        try {
            THREE_TWR.call(factoryA, factoryB, factoryC, body);
        } catch (Throwable ex) {
            exTWR = ex;
        }
        return exceptionMatcher(exImpl, exTWR);
    }

    public static void main(String[] args) throws Throwable {
        final List<Boolean> results = new LinkedList<>();

        //0 exceptions
        results.add(Var(new FactoryOkOk("F1"), new FactoryOkOk("F2"), new FactoryOkOk("F3"), new BodyOk()));//1
        //1 exceptions
        results.add(Var(new FactoryOkOk("F1"), new FactoryOkOk("F2"), new FactoryOkOk("F3"), new BodyFail()));//2
        results.add(Var(new FactoryOkOk("F1"), new FactoryOkOk("F2"), new FactoryOkFail("F3"), new BodyOk()));//3
        results.add(Var(new FactoryOkOk("F1"), new FactoryOkFail("F2"), new FactoryOkOk("F3"), new BodyOk()));//4
        results.add(Var(new FactoryOkFail("F1"), new FactoryOkOk("F2"), new FactoryOkOk("F3"), new BodyOk()));//5

        results.add(Var(new FactoryOkOk("F1"), new FactoryOkOk("F2"), new FactoryFail("F3"), new BodyOk()));//6
        results.add(Var(new FactoryOkOk("F1"), new FactoryFail("F2"), new FactoryOkOk("F3"), new BodyOk()));//7
        results.add(Var(new FactoryFail("F1"), new FactoryOkOk("F2"), new FactoryOkOk("F3"), new BodyOk()));//8
        //2 exceptions
        results.add(Var(new FactoryOkOk("F1"), new FactoryOkOk("F2"), new FactoryOkFail("F3"), new BodyFail()));//9
        results.add(Var(new FactoryOkOk("F1"), new FactoryOkFail("F2"), new FactoryOkOk("F3"), new BodyFail()));//10
        results.add(Var(new FactoryOkFail("F1"), new FactoryOkOk("F2"), new FactoryOkOk("F3"), new BodyFail()));//11

        results.add(Var(new FactoryOkOk("F1"), new FactoryOkFail("F2"), new FactoryOkFail("F3"), new BodyOk()));//12
        results.add(Var(new FactoryOkFail("F1"), new FactoryOkOk("F2"), new FactoryOkFail("F3"), new BodyOk()));//13

        results.add(Var(new FactoryOkFail("F1"), new FactoryOkFail("F2"), new FactoryOkOk("F3"), new BodyOk()));//14

        results.add(Var(new FactoryOkOk("F1"), new FactoryOkFail("F2"), new FactoryFail("F3"), new BodyOk()));//15
        results.add(Var(new FactoryOkFail("F1"), new FactoryOkOk("F2"), new FactoryFail("F3"), new BodyOk()));//16

        results.add(Var(new FactoryOkFail("F1"), new FactoryFail("F2"), new FactoryOkOk("F3"), new BodyOk()));//17
        //3 exceptions
        results.add(Var(new FactoryOkOk("F1"), new FactoryOkFail("F2"), new FactoryOkFail("F3"), new BodyFail()));//18
        results.add(Var(new FactoryOkFail("F1"), new FactoryOkOk("F2"), new FactoryOkFail("F3"), new BodyFail()));//19

        results.add(Var(new FactoryOkFail("F1"), new FactoryOkFail("F2"), new FactoryOkOk("F3"), new BodyFail()));//20

        results.add(Var(new FactoryOkFail("F1"), new FactoryOkFail("F2"), new FactoryOkFail("F3"), new BodyOk()));//21

        results.add(Var(new FactoryOkFail("F1"), new FactoryOkFail("F2"), new FactoryFail("F3"), new BodyOk()));//22

        //4 exceptions
        results.add(Var(new FactoryOkFail("F1"), new FactoryOkFail("F2"), new FactoryOkFail("F3"), new BodyFail()));//23

        for(int i=0;i<results.size();i++){
            if(!results.get(i)){
                System.err.println("No equals variant: " + i);
                return;
            }
        }
        System.err.println("All right");
    }
}
