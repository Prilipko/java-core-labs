package collections.iterator.square;

import java.util.Iterator;

public class SquareIterable implements Iterable<Integer> {
    private final int left;
    private final int right;

    public SquareIterable(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SquareIterator(left, right);
    }
}