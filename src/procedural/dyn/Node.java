package procedural.dyn;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 15.08.13
 * Time: 18:59
 * To change this template use File | Settings | File Templates.
 */
public class Node {
    public Node next;
    public int value;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

