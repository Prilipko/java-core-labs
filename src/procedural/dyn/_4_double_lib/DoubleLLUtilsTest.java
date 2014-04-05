package procedural.dyn._4_double_lib;

import procedural.dyn.DoubleNode;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 20.08.13
 * Time: 13:17
 * To change this template use File | Settings | File Templates.
 */
public class DoubleLLUtilsTest {
    public static void main(String[] args) {
        DoubleNode tail;
        tail = DoubleLLUtils.add(null,10);
        tail = DoubleLLUtils.add(tail,20);
        tail = DoubleLLUtils.add(tail,30);
        tail = DoubleLLUtils.add(tail,0,35);
        tail = DoubleLLUtils.add(tail,2,25);
        tail = DoubleLLUtils.add(tail,4,15);
        tail = DoubleLLUtils.add(tail,6,5);
        tail = DoubleLLUtils.remove(tail,0);
        tail = DoubleLLUtils.remove(tail,1);
        tail = DoubleLLUtils.remove(tail,2);
        tail = DoubleLLUtils.remove(tail,3);
        tail = DoubleLLUtils.remove(tail);
    }

}
