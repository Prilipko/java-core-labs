package procedural.loop.array_inverter_optimized;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 11.08.13
 * Time: 16:45
 * To change this template use File | Settings | File Templates.
 */
import java.util.Arrays;

import static procedural.loop.array_inverter_optimized.ArrayInverter.invert;

public class ArrayInverterTest {

    public static void main(String[] args) {
        int[] arr;

        arr = new int[]{};
        System.out.print(Arrays.toString(arr) + " -> ");
        invert(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0};
        System.out.print(Arrays.toString(arr) + " -> ");
        invert(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 1};
        System.out.print(Arrays.toString(arr) + " -> ");
        invert(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 1, 2};
        System.out.print(Arrays.toString(arr) + " -> ");
        invert(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print(Arrays.toString(arr) + " -> ");
        invert(arr);
        System.out.println(Arrays.toString(arr));
    }
}