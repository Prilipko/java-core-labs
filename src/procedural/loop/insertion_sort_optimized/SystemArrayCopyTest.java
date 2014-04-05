package procedural.loop.insertion_sort_optimized;

/**
 * Created with IntelliJ IDEA.
 * User: Prilipko
 * Date: 14.08.13
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
import java.util.Arrays;

public class SystemArrayCopyTest {
    public static void main(String[] args) {
        int[] arr0 = {1, 2, 3, 4, 5, 6};
        int[] arr1 = {0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println(Arrays.toString(arr0));
        System.out.println(Arrays.toString(arr1));

        System.arraycopy(arr0, 1, arr1, 2, 3);
        System.out.println(Arrays.toString(arr1));

        System.arraycopy(arr0, 1, arr0, 2, 3);
        System.out.println(Arrays.toString(arr0));
    }
}

//>> [1, 2, 3, 4, 5, 6]
//>> [0, 0, 0, 0, 0, 0, 0, 0]
//>> [0, 0, 2, 3, 4, 0, 0, 0]
//>> [1, 2, 2, 3, 4, 6]

