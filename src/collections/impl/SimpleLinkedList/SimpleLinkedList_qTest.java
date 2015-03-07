package collections.impl.SimpleLinkedList;

import collections.impl.SimpleList;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Worker on 07.03.15.
 */
public class SimpleLinkedList_qTest {
    SimpleList<String> list;
    SimpleList<String> second;

    @Before
    public void setUp() throws Exception {
        list = new SimpleLinkedList_q<>();
        list.add("1");
        list.add("2");
        list.add("3");
        second = new SimpleLinkedList_q<>();
    }
    @Test
    public void testIterator() throws Exception {
        Iterator<String> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            assertEquals("" + ++i, iterator.next());
        }
    }

    @Test
    public void testIterator_remove() throws Exception {
        Iterator<String> iterator = list.iterator();
        if(iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
        second.add("2");
        second.add("3");
        assertTrue(list.equals(second));
    }

    @Test
    public void testRemove() throws Exception {
        assertTrue(list.contains("2"));
        assertTrue(list.remove("2"));
        assertFalse(list.contains("2"));
    }


    @Test
    public void testRemove_null() throws Exception {
        list.add(null);
        assertTrue(list.contains(null));
        list.remove(null);
        assertFalse(list.contains(null));
    }

    @Test
    public void testEquals() throws Exception {
        second.add("1");
        second.add("2");
        second.add("3");
        assertTrue(list.equals(second));
    }

    @Test
    public void testEquals_dif() throws Exception {
        second.add("1");
        second.add("2");
        second.add("4");
        assertFalse(list.equals(second));
    }

    @Test
    public void testEquals_wrongSize() throws Exception {
        second.add("1");
        second.add("2");
        assertFalse(list.equals(second));
    }


    @Test
    public void testToString() throws Exception {
        assertEquals("[1, 2, 3]", list.toString());
    }


}
