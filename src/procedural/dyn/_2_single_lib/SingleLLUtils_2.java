package procedural.dyn._2_single_lib;

import procedural.dyn.Node;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 15.08.13
 * Time: 20:18
 * To change this template use File | Settings | File Templates.
 */

/*
Разработать класс-библиотеку для работы с односвязными списками.
А именно 4 метода из DynamicArray:
public class SingleLLUtils_2 {
    public static Node add(Node tail, int elem) {...}
    public static Node remove(Node tail) {...}
    public static Node add(Node tail, int index, int elem) {...}
    public static Node remove(Node tail, int index) {...}
}
Используйте любой или все вместе подходы при решения задачи
(итеративный, рекурсивные, в любом направлении).
 */

public class SingleLLUtils_2 {
    public static Node add(Node tail, int elem) {
        return new Node(elem, tail);
    }

    public static Node remove(Node tail) {
        return tail.next;
    }

    //iteration
//    public static Node add(Node tail, int index, int elem) {
//        Node result = tail;
//        if (index == 0){
//            return new Node(elem,tail);
//        }
//        while(index-- > 1){
//            tail= tail.next;
//        }
//        tail.next=new Node(elem,tail.next);
//        return result;
//    }

    //recursion
    public static Node add(Node tail, int index, int elem) {
        if (index == 0) {
            return new Node(elem, tail);
        }
        if (index > 1) {
            add(tail.next, index - 1, elem);
        } else {
            tail.next = new Node(elem, tail.next);
        }
        return tail;
    }


    public static Node remove(Node tail, int index) {
        if (index == 0) {
            return tail.next;
        }
        if (index > 1) {
            remove(tail.next, index - 1);
        } else {
            tail.next = tail.next.next;
        }
        return tail;
    }
}
