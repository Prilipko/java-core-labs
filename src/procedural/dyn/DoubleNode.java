package procedural.dyn;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 20.08.13
 * Time: 13:08
 * To change this template use File | Settings | File Templates.
 */
public class DoubleNode {
    public int value;
    public DoubleNode prev;
    public DoubleNode next;
    public DoubleNode(int value, DoubleNode prev, DoubleNode next){
    this.value = value;
    this.prev = prev;
    this.next = next;
}
}