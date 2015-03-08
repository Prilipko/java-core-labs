package collections.iterator;

import java.util.Iterator;

public class IntervalIterator implements Iterator<Integer> {
    private final int max;
    private int current;

    public IntervalIterator(int left, int right) {
        this.max = right;
        this.current = left;
    }

    @Override
    public boolean hasNext() {
        return current < max;
    }

    @Override
    public Integer next() {
        return current++;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}