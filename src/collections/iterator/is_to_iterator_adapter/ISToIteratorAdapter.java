package collections.iterator.is_to_iterator_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ISToIteratorAdapter implements Iterator<Integer> {
    private final InputStream is;
    int head;

    public ISToIteratorAdapter(InputStream is) {
        this.is = is;
        head = -1;
    }

    @Override
    public boolean hasNext() {
        try {
            head = is.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return head != -1;
    }

    @Override
    public Integer next() {
        return head;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}