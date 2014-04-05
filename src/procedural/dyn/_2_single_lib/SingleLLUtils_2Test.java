package procedural.dyn._2_single_lib;

import procedural.dyn.Node;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 15.08.13
 * Time: 20:18
 * To change this template use File | Settings | File Templates.
 */


public class SingleLLUtils_2Test {
    public static void main(String[] args) {
        Node tail;
        tail = SingleLLUtils_2.add(null,10);
        tail = SingleLLUtils_2.add(tail,20);
        tail = SingleLLUtils_2.add(tail,30);
        tail = SingleLLUtils_2.add(tail,0,35);
        tail = SingleLLUtils_2.add(tail,2,25);
        tail = SingleLLUtils_2.add(tail,4,15);
        tail = SingleLLUtils_2.add(tail,6,5);
        tail = SingleLLUtils_2.remove(tail,0);
        tail = SingleLLUtils_2.remove(tail,1);
        tail = SingleLLUtils_2.remove(tail,2);
        tail = SingleLLUtils_2.remove(tail,3);
        tail = SingleLLUtils_2.remove(tail);
    }
}
