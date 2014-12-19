package collections.impl.SimpleArrayList;

import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;

import static org.junit.Assert.*;


/**
 * Created by Alexander on 18.12.14.
 */
public class SimpleArrayList_qTest {
    SimpleArrayList_q<String> list;

    @Before
    public void setUp() throws Exception {
        list = new SimpleArrayList_q<>();
        list.add("1");
        list.add("2");
        list.add("3");
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
        SimpleArrayList_q<String> second = new SimpleArrayList_q<>();
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


    @Test(expected = NullPointerException.class)
    public void testRemove_null() throws Exception {
        list.remove(null);
    }

    @Test
    public void testEquals() throws Exception {
        SimpleArrayList_q<String> second = new SimpleArrayList_q<>();
        second.add("1");
        second.add("2");
        second.add("3");
        assertTrue(list.equals(second));
    }

    @Test
    public void testEquals_dif() throws Exception {
        SimpleArrayList_q<String> second = new SimpleArrayList_q<>();
        second.add("1");
        second.add("2");
        second.add("4");
        assertFalse(list.equals(second));
    }

    @Test
    public void testEquals_wrongSize() throws Exception {
        SimpleArrayList_q<String> second = new SimpleArrayList_q<>();
        second.add("1");
        second.add("2");
        assertFalse(list.equals(second));
    }


    @Test
    public void testToString() throws Exception {
        assertEquals("[1, 2, 3]", list.toString());
    }
}
