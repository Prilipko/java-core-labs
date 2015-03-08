package collections.iterator.merge;

import java.util.Iterator;

public class MergeIterable implements Iterable<Integer> {
    private final Iterable<Integer> iter0;
    private final Iterable<Integer> iter1;

    public MergeIterable(Iterable<Integer> iter0, Iterable<Integer> iter1) {
        this.iter0 = iter0;
        this.iter1 = iter1;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MergeIterator(iter0.iterator(), iter1.iterator());
    }
}