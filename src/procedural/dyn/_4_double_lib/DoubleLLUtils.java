package procedural.dyn._4_double_lib;

import procedural.dyn.DoubleNode;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 20.08.13
 * Time: 13:12
 * To change this template use File | Settings | File Templates.
 */
/*
 Разработать класс-библиотеку для работы с двусвязными списками.
 А именно 4 метода из DynamicArray:

public class SingleLLUtils_2 {
    public static DoubleNode add(DoubleNode tail, int elem) {...}
    public static DoubleNode remove(DoubleNode tail) {...}
    public static DoubleNode add(DoubleNode tail, int index, int elem) {...}
    public static DoubleNode remove(DoubleNode tail, int index) {...}
}

 для класса
public class DoubleNode {
    public int value;
    public DoubleNode prev;
    public DoubleNode next;
    public DoubleNode(int value, DoubleNode left, DoubleNode right)
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}
Используйте любой или все вместе подходы при решения задачи
(итеративный, рекурсивные, в любом направлении).
Примечание: теперь надо модифицировать две ссылки, а не одну
(как у односвязных списков).
 */

public class DoubleLLUtils {
    public static DoubleNode add(DoubleNode tail, int elem) {
        DoubleNode result = new DoubleNode(elem, null, tail);
        if (tail != null) {
            tail.prev = result;
        }
        return result;
    }

    public static DoubleNode remove(DoubleNode tail) {
        tail.next.prev = null;
        return tail.next;
    }

    public static DoubleNode add(DoubleNode tail, int index, int elem) {
        if (index == 0) {
            return add(tail, elem);
        }
        if (index > 1) {
            add(tail.next, index - 1, elem);
        } else {
            DoubleNode newElem = new DoubleNode(elem, tail, tail.next);
            if (tail.next != null) {
                tail.next.prev = newElem;
            }
            tail.next = newElem;
        }
        return tail;
    }

    public static DoubleNode remove(DoubleNode tail, int index) {
        if (index == 0) {
            return remove(tail);
        }
        if (index > 1) {
            remove(tail.next, index - 1);
        } else {
            DoubleNode oldElem = tail.next;
            tail.next = oldElem.next;
            if (tail.next != null) {
                tail.next.prev = tail;
            }
        }
        return tail;
    }
}
