package procedural.dyn._1_single_lib;

import procedural.dyn.Node;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 15.08.13
 * Time: 19:07
 * To change this template use File | Settings | File Templates.
 */
public class SingleLLUtils_1Test {
    public static void main(String[] args) {
        Node tail = new Node(0,null);
        tail = new Node(1,tail);
        tail = new Node(2,tail);
        tail = new Node(3,tail);
        tail = new Node(4,tail);
        tail = new Node(5,tail);
        System.out.println(SingleLLUtils_1.length(tail));
        System.out.println(SingleLLUtils_1.max(tail));
        System.out.println(SingleLLUtils_1.sum(tail));
    }
}
