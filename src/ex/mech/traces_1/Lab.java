package ex.mech.traces_1;

import ex.mech.TraceIF;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 24.08.13
 * Time: 18:52
 * To change this template use File | Settings | File Templates.
 */

//ЗАДАНИЕ
//На месте каждого комментария /**/ можно:
//        - оставить все как есть (оставить комментарий)
//        - или вставить throw new NullPointerException();
//- или вставить throw new Error();
//public class Lab {
//    public static Void main(String[] args) {
//        System.err.print(0);
//        try {
//            System.err.println(1);
//            if (true) {/*...*/}
//            System.err.print(2);
//        } catch (calltimeException e) {
//            System.err.print(3);
//            if (true) {/*...*/}
//            System.err.print(4);
//        } finally {
//            System.err.print(5);
//            if (true) {/*...*/}
//            System.err.print(6);
//        }
//        System.err.print(7);
//    }
//}
//Задание: пришлите все различные трассы, которые может вывести эта программа.
//        Трассы записать в столбик, программы, которые их генерируют – не нужны. Трассы могут
//        идти в любом порядке.
//        Ожидается что-то типа:
//        1234567
//        123
//        345
//        67
//        1267
//        2345

public class Lab implements TraceIF {
    static StringBuilder result = new StringBuilder();

    public String getResult() {
        return result.toString();
    }

    public int getFunCount() {
        return 3;
    }

    private class r1 implements Callable {
        @Override
        public Void call() {
            // NOP
            return null;
        }
    }

    private class r2 implements Callable {
        @Override
        public Void call() {
            throw new NullPointerException();
        }
    }

    private class r3 implements Callable {
        @Override
        public Void call() {
            throw new Error();
        }
    }

    private final Callable[] VarFunc = {new r1(), new r2(), new r3()};

    public void f(Callable[] f) throws Exception {
        result = new StringBuilder();
        result.append(0);
        try {
            result.append(1);
            f[0].call();
            result.append(2);
        } catch (RuntimeException e) {
            result.append(3);
            f[1].call();
            result.append(4);
        } finally {
            result.append(5);
            f[2].call();
            result.append(6);
        }
        result.append(7);
    }

    @Override
    public Callable[] getVarFunc() {
        return VarFunc;
    }
}
