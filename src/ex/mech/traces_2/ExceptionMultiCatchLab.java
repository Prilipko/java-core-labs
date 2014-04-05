package ex.mech.traces_2;

import ex.mech.TraceIF;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: Prilipko
 * Date: 27.08.13
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */


//ЗАДАНИЕ
//На месте каждого комментария /**/ можно:
//        - оставить все как есть (оставить комментарий)
//        - или вставить throw new NullPointerException();
//- или вставить throw new RuntimeException();
//- или вставить throw new IOException();
//- или вставить throw new Error();
//public class ExceptionMultiCatchLab {
//    public static void main(String[] args) throws Throwable {
//        System.err.println(0);
//        try {
//            System.err.println(1);
//            if (true) {/**/}
//            System.err.print(2);
//        } catch (NullPointerException e) {
//            System.err.print(3);
//            if (true) {/**/}
//            System.err.print(4);
//        } catch (RuntimeException e) {
//            System.err.print(5);
//            if (true) {/**/}
//            System.err.print(6);
//        } catch (Exception e) {
//            System.err.print(7);
//            if (true) {/**/}
//            System.err.print(8);
//        } finally {
//            System.err.print(9);
//            if (true) {/**/}
//            System.err.print(10);
//        }
//        System.err.print(11);
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


public class ExceptionMultiCatchLab implements TraceIF{
    static StringBuilder result = new StringBuilder();

    public String getResult() {
        return result.toString();
    }

    public int getFunCount() {
        return 5;
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
            throw new NullPointerException(); //unchecked
        }
    }

    private class r3 implements Callable {
        @Override
        public Void call() {
            throw new RuntimeException(); //unchecked
        }
    }

    private class r4 implements Callable {
        @Override
        public Void call() throws IOException {
            throw new IOException(); //checked
        }
    }

    private class r5 implements Callable {
        @Override
        public Void call() {
            throw new Error(); //unchecked
        }
    }

    private final Callable[] VarFunc = {new r1(), new r2(), new r3(), new r4(), new r5()};

    public void f(Callable[] f) throws Exception {
        result = new StringBuilder();
        result.append(0);
        try {
            result.append(1);
            f[0].call();
            result.append(2);
        } catch (NullPointerException e) {
            result.append(3);
            f[1].call();
            result.append(4);
        } catch (RuntimeException e) {
            result.append(5);
            f[2].call();
            result.append(6);
        } catch (Exception e) {
            result.append(7);
            f[3].call();
            result.append(8);
        } finally {
            result.append(9);
            f[4].call();
            result.append(10);
        }
        result.append(11);    }

    @Override
    public Callable[] getVarFunc() {
        return VarFunc;
    }
}
