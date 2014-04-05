package procedural.loop.insertion_sort_optimized;

/**
 * Created with IntelliJ IDEA.
 * User: Prilipko
 * Date: 14.08.13
 * Time: 13:52
 * To change this template use File | Settings | File Templates.
 */
import java.util.Arrays;

public class BinarySearchTest {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(Arrays.binarySearch(arr, 5));
        System.out.println(Arrays.binarySearch(arr, 10));
        System.out.println(Arrays.binarySearch(arr, 15));
        System.out.println(Arrays.binarySearch(arr, 20));

        System.out.println(Arrays.binarySearch(arr, 50));
        System.out.println(Arrays.binarySearch(arr, 55));
    }
}
//>> -1
//>> 0
//>> -2
//>> 1
//>> 4
//>> -6