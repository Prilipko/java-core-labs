package procedural.loop.array_inverter_optimized;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 11.08.13
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */

/**
 *   Есть гипотеза, что декремент счетчика цикла до 0 работает быстрее,
 *   чем инкремент счетчика цикла до определенного не равного 0 значения.
 *   Задание состоит в том, что бы переписать инкремент счетчика
 *   цикла на декремент с нижним пределом 0 в примере метода, инвертирующего массив.
 */

//public class ArrayInverter {
//    public static void invert(int[] arr) {
//        for (int k = 0; k < arr.length / 2; k++) {
//            int tmp = arr[k];
//            arr[k] = arr[arr.length - k - 1];
//            arr[arr.length - k - 1] = tmp;
//        }
//    }
//}

public class ArrayInverter {
    public static void invert(int[] arr) {
        for (int k = arr.length / 2 - 1; k >= 0; k--) {
            int tmp = arr[k];
            arr[k] = arr[arr.length - k - 1];
            arr[arr.length - k - 1] = tmp;
        }
    }
}
