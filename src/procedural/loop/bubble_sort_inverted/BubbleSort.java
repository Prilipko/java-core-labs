package procedural.loop.bubble_sort_inverted;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 12.08.13
 * Time: 21:16
 * To change this template use File | Settings | File Templates.
 */

//public class BubbleSort {
//    public static void sort(int[] arr) {
//        for (int barrier = arr.length - 1; barrier >= 0; barrier--) {
//            for (int index = 0; index < barrier; index++) {
//                if (arr[index] > arr[index + 1]) {
//                    int tmp = arr[index];
//                    arr[index] = arr[index + 1];
//                    arr[index + 1] = tmp;
//                }
//            }
//        }
//    }
// }

//На этой странице приведен полный исходный код сортировки "пузырьком".
//Алгоритм допускает вариации и оптимизации. В данном случае приведен алгоритм,
//при котором "всплывает" самый большой элемент. Перепишите алгоритм на такой,
//при котором "тонет" самый маленький элемент (). Порядок сортировки должен
//сохраниться - по возрастанию. Элементы должны перебираться справа - налево.
//Всплывал - вправо, тонет - влево. Цикл не доходил до правого конца, теперь не доходит до левого.
//В массиве из 6 элементов должны сравниваться (и в случае инверсии переставляться) пары
//        4-5 3-4 2-3 1-2 0-1
//        4-5 3-4 2-3 1-2
//        4-5 3-4 2-3
//        4-5 3-4
//        4-5

public class BubbleSort {
    public static void sort(int[] arr) {
        for (int barrier = 0; barrier < arr.length; barrier++) {
            for (int index = barrier-1; index >= 0; index--) {
                if (arr[index] > arr[index + 1]) {
                    int tmp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = tmp;
                }
            }
        }
    }
}
