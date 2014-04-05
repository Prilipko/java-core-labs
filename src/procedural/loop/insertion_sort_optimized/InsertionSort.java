package procedural.loop.insertion_sort_optimized;

/**
 * Created with IntelliJ IDEA.
 * User: Prilipko
 * Date: 14.08.13
 * Time: 13:40
 * To change this template use File | Settings | File Templates.
 */

import java.util.Arrays;

//АЛГОРИТМ: сортировка вставками (Insertion Sort)
//public class InsertionSort {
//    public static void sort(int[] arr) {
//        for (int k = 1; k < arr.length; k++) {
//            int newElement = arr[k];
//            int location = k - 1;
//            while (location >= 0 && arr[location] > newElement) {
//                arr[location + 1] = arr[location];
//                location--;
//            }
//            arr[location + 1] = newElement;
//        }
//    }
//}
//На странице сортировки вставкой внутренний цикл while ищет
//позицию для вставки перебирая последовательно элементы,
//при этом он поэлементно "смещает" массив.
//В целях оптимизации перепишите алгоритм:
//1) осуществляйте поиск позиции для вставки
//        бинарным поиском (Arrays.binarySearch(...))
//2) найдя позицию - копируйте всю часть массива за
//        один вызов (System.arraycopy(...))
//Примечание: пример работы с методами binarySearch(...)
//        и arraycopy(...) вы можете посмотреть на этой странице.

public class InsertionSort {
    public static void sort(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            if (arr[k - 1] > arr[k]) {
                int newElement = arr[k];
                int newPlace = Arrays.binarySearch(arr, 0, k - 1, newElement);
                newPlace = (newPlace < 0) ? (-newPlace - 1) : newPlace;
                System.arraycopy(arr, newPlace, arr, newPlace + 1, k - newPlace);
                arr[newPlace] = newElement;
            }
        }
    }
}