package collections.iterator.merge;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static collections.iterator.IteratorUtils.interval;
import static collections.iterator.IteratorUtils.merge;
import static collections.iterator.IteratorUtils.squares;

/**
 * Created by Worker on 08.03.15.
 */
public class MergeIteratorTest {
    StringBuilder actual;

    @Before
    public void setUp() throws Exception {
        actual = new StringBuilder();
    }

    @Test
    public void test1() throws Exception {
        for (int k : merge(interval(10, 12), interval(10, 12))) {
            actual.append(" ").append(k);
        }
        Assert.assertEquals(" 10 10 11 11",actual.toString());
    }

    @Test
    public void test2() throws Exception {
        for (int k : merge(interval(10, 10), interval(10, 12))) {
            actual.append(" ").append(k);
        }
        Assert.assertEquals(" 10 11",actual.toString());
    }

    @Test
    public void test3() throws Exception {
        for (int k : merge(interval(10, 12), interval(10, 10))) {
            actual.append(" ").append(k);
        }
        Assert.assertEquals(" 10 11",actual.toString());
    }

    @Test
    public void test4() throws Exception {
        for (int k : merge(interval(10, 10), interval(10, 10))) {
            actual.append(" ").append(k);
        }
        Assert.assertEquals("",actual.toString());
    }
    @Test
    public void test5() throws Exception {
        for (int k : merge(interval(0, 10), interval(1000, 1002))) {
            actual.append(" ").append(k);
        }
        Assert.assertEquals(" 0 1 2 3 4 5 6 7 8 9 1000 1001",actual.toString());
    }
    @Test
    public void test6() throws Exception {
        for (int k : merge(interval(1000, 1002), interval(0, 10))) {
            actual.append(" ").append(k);
        }
        Assert.assertEquals(" 0 1 2 3 4 5 6 7 8 9 1000 1001",actual.toString());
    }
    @Test
    public void test7() throws Exception {
        for (int k : merge(interval(0, 10), interval(5, 15))) {
            actual.append(" ").append(k);
        }
        Assert.assertEquals(" 0 1 2 3 4 5 5 6 6 7 7 8 8 9 9 10 11 12 13 14",actual.toString());
    }
}
