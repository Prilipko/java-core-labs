package procedural.loop.selection_sort_optimized;

/**
 * Created with IntelliJ IDEA.
 * User: Prilipko
 * Date: 14.08.13
 * Time: 12:58
 * To change this template use File | Settings | File Templates.
 */
//Сортировка выборками (Selection Sort):

//public class SelectionSort {
//    public static void sort(int[] arr) {
//        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
//            for (int index = barrier + 1; index < arr.length; index++) {
//                if (arr[barrier] > arr[index]) {
//                    int tmp = arr[index];
//                    arr[index] = arr[barrier];
//                    arr[barrier] = tmp;
//                }
//            }
//        }
//    }
//}

//Есть гипотеза, что обращение к локальной переменной типа int происходит
//быстрее чем обращение к элементу локальной переменной типа int[].
//Задание состоит в том, что бы переписать алгоритм Selection Sort:
//- убрать обращение во внутреннем цикле к элементу массива arr[barrier]
//- убрать обмен элементами arr[barrier] c arr[index] каждый раз,
//  когда находится очередной меньший элемент.
//  Найти наименьший элемент - обменять с ним.

public class SelectionSort {
    public static void sort(int[] arr) {
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            int bestValue = arr[barrier];
            int bestIndex = barrier;
            for (int index = barrier + 1; index < arr.length; index++) {
                int currentValue = arr[index];
                if (bestValue > currentValue) {
                    bestValue = currentValue;
                    bestIndex = index;
                }
            }
            int tmp = arr[bestIndex];
            arr[bestIndex] = arr[barrier];
            arr[barrier] = tmp;
        }
    }
}
