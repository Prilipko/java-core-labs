package procedural.recursion.permutation;

/**
 * Created with IntelliJ IDEA.
 * User: Prilipko
 * Date: 13.08.13
 * Time: 17:09
 * To change this template use File | Settings | File Templates.
 */
import java.util.Arrays;

//Это некорректный код, который должен рекурсивно строить все
//возможные перестановки. Исправьте его.
//        >> [2, 3, 1]
//        >> [2, 3, 1]
//        >> [1, 2, 3]
//        >> [1, 2, 3]
//        >> [2, 1, 3]
//        >> [2, 1, 3]
//Этот код "недоперемешивает" элементы.
//Количество вариантов верное, но почему-то имеются дубликаты.

public class Permutation_q {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permutation(arr, arr.length);
    }
//    private static void permutation(int[] arr, int size) {
//        if (size < 2) {
//            System.out.println(Arrays.toString(arr));
//        } else {
//            for (int k = 0; k < size; k++) {
//                swap(arr, k, size - 1);
//                permutation(arr, size - 1);
//            }
//        }
//    }

    private static void permutation(int[] arr, int size) {
        arr = arr.clone();
        if (size < 2) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int k = 0; k < size; k++) {
                swap(arr, size - 1 - k, size - 1);
                permutation(arr, size - 1);
            }
        }
    }

    private static void swap(int[] arr, int index0, int index1) {
        int tmp = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = tmp;
    }
}
