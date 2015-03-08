package collections.iterator.is_to_iterator_adapter;

import java.io.ByteArrayInputStream;
import java.util.Iterator;

public class ISToIteratorAdapterTest {
    public static void main(String[] args) {
        Iterator<Integer> iter3
                = new ISToIteratorAdapter(new ByteArrayInputStream(new byte[]{10, 20, 30}));
        while (iter3.hasNext()) {
            System.out.print(" " + iter3.next());
        }
        System.out.println();

        Iterator<Integer> iter0
                = new ISToIteratorAdapter(new ByteArrayInputStream(new byte[0]));
        while (iter0.hasNext()) {
            System.out.print(" " + iter0.next());
        }
        System.out.println();

        Iterator<Integer> iter1
                = new ISToIteratorAdapter(new ByteArrayInputStream(new byte[]{10}));
        while (iter1.hasNext()) {
            System.out.print(" " + iter1.next());
        }
        System.out.println();
    }
}