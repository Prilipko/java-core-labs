package procedural.dyn._1_single_lib;

import procedural.dyn.Node;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 15.08.13
 * Time: 19:04
 * To change this template use File | Settings | File Templates.
 */


//Разработать класс-библиотеку для работы с односвязными списками.
//А именно 3 метода:
//public class SingleLLUtils_1 {
//    public static int length(Node tail) {...}
//    public static int max(Node tail) {...}
//    public static int sum(Node tail) {...}
//}
//Используйте любой или все вместе подходы при решения задачи (итеративный, рекурсивные, в любом направлении).

public class SingleLLUtils_1 {

    public static int length(Node tail) {
        return tail == null ? 0 : 1 + length(tail.next);
    }

    //iteration
//    public static int max(Node tail) {
//        int maxValue = tail.value;
//        while(tail.next != null){
//            tail = tail.next;
//            if(tail.value > maxValue){
//                maxValue = tail.value;
//            }
//        }
//        return maxValue;
//    }

    //recursion
    public static int max(Node tail) {
        if (tail.next != null) {
            int maxValue = max(tail.next);
            return tail.value > maxValue ? tail.value : maxValue;
        }
        return tail.value;
    }

    public static int sum(Node tail) {
        return tail == null ? 0 : tail.value + sum(tail.next);
    }
}