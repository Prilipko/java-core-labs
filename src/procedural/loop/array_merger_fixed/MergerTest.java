package procedural.loop.array_merger_fixed;

import java.util.Arrays;
import static procedural.loop.array_merger_fixed.Merger.merge;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 12.08.13
 * Time: 20:50
 * To change this template use File | Settings | File Templates.
 */
public class MergerTest {
    public static void main(String[] args) {
        int[] arr1,arr2,result;

        arr1 = new int[]{};
        arr2 = new int[]{};
        System.out.print(Arrays.toString(arr1) + " + ");
        System.out.print(Arrays.toString(arr2) + " -> ");
        result = merge(arr1,arr2);
        System.out.println(Arrays.toString(result));

        arr1 = new int[]{1};
        arr2 = new int[]{};
        System.out.print(Arrays.toString(arr1) + " + ");
        System.out.print(Arrays.toString(arr2) + " -> ");
        result = merge(arr1,arr2);
        System.out.println(Arrays.toString(result));

        arr1 = new int[]{2};
        arr2 = new int[]{1};
        System.out.print(Arrays.toString(arr1) + " + ");
        System.out.print(Arrays.toString(arr2) + " -> ");
        result = merge(arr1,arr2);
        System.out.println(Arrays.toString(result));

        arr1 = new int[]{1,3,5,7};
        arr2 = new int[]{2,4,6};
        System.out.print(Arrays.toString(arr1) + " + ");
        System.out.print(Arrays.toString(arr2) + " -> ");
        result = merge(arr1,arr2);
        System.out.println(Arrays.toString(result));

        arr1 = new int[]{1,2,3,4,5};
        arr2 = new int[]{6,7,8};
        System.out.print(Arrays.toString(arr1) + " + ");
        System.out.print(Arrays.toString(arr2) + " -> ");
        result = merge(arr1,arr2);
        System.out.println(Arrays.toString(result));

    }
}
