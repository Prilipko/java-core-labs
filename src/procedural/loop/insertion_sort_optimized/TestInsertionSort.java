package procedural.loop.insertion_sort_optimized;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Prilipko
 * Date: 14.08.13
 * Time: 13:40
 * To change this template use File | Settings | File Templates.
 */
//Тестирующий класс
public class TestInsertionSort {
    public static void main(String[] args) {
        int[][] data = {
                {},
                {1},
                {0, 3, 2, 1},
                {6, 8, 3, 123, 5, 4, 1, 2, 0, 9, 7},
                {3, 2, 1, 3, 2, 1, 3, 2, 1},
        };
        for (int[] arr : data) {
            System.out.print(Arrays.toString(arr) + " -> ");
            InsertionSort.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}

//>> [] -> []
//>> [1] -> [1]
//>> [0, 3, 2, 1] -> [0, 1, 2, 3]
//>> [6, 8, 3, 123, 5, 4, 1, 2, 0, 9, 7] -> [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 123]