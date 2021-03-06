package collections.iterator.square;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static collections.iterator.IteratorUtils.interval;
import static collections.iterator.IteratorUtils.squares;

/**
 * Created by Worker on 08.03.15.
 */
public class SquareIteratorTest {
    StringBuilder actual;
    double[] array;

    @Before
    public void setUp() throws Exception {
        actual = new StringBuilder();
        array = new double[]{0.5, 1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5, 9.5, 10.5};
    }

    @Test
    public void test1() throws Exception {
        for (int index : squares(0, array.length)) {
            actual.append(" ").append(array[index]);
        }
        Assert.assertEquals(" 0.5 1.5 4.5 9.5",actual.toString());
    }

    @Test
    public void test2() throws Exception {
        for (int index : squares(3, array.length)) {
            actual.append(" ").append(array[index]);
        }
        Assert.assertEquals(" 4.5 9.5",actual.toString());
    }

    @Test
    public void test3() throws Exception {
        for (int index : squares(5, 8)) {
            actual.append(" ").append(array[index]);
        }
        Assert.assertEquals("",actual.toString());
    }

    @Test
    public void test4() throws Exception {
        for (int index : squares(4, 5)) {
            actual.append(" ").append(array[index]);
        }
        Assert.assertEquals(" 4.5",actual.toString());
    }
}
