package procedural.loop.array_merger_fixed;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 12.08.13
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */
//public class Merger {
//    public static int[] merge(int[] a, int[] b) { // wrong!
//        int[] result = new int[a.length + b.length];
//        int aIndex = 0;
//        int bIndex = 0;
//        while (aIndex + bIndex != result.length) {
//            if (a[aIndex] < b[bIndex]) {
//                result[aIndex + bIndex] = a[aIndex++];
//            } else {
//                result[aIndex + bIndex] = b[bIndex++];
//            }
//        }
//        return result;
//    }
//}
//Метод Merger.merge(...) реализован с небольшой ошибкой - он корректно сливает,
//но некорректно обрабатывает ситуацию, когда один из массивов полностью выбран.
//1. Исправьте ошибку.
//2. После того как обнаружится, что один из массивов "исчерпан" копируйте
//   данные со второго не в цикле, а одним вызовом System.arraycopy(...).

public class Merger {
    public static int[] merge(int[] a, int[] b) { // wrong!
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex + bIndex != result.length) {
            if(aIndex == a.length){
                System.arraycopy(b,bIndex,result,aIndex+bIndex,b.length-bIndex);
                return result;
            }
            if(bIndex == b.length){
                System.arraycopy(a,aIndex,result,aIndex+bIndex,a.length-aIndex);
                return result;
            }
            if (a[aIndex] < b[bIndex]) {
                result[aIndex + bIndex] = a[aIndex++];
            } else {
                result[aIndex + bIndex] = b[bIndex++];
            }
        }
        return result;
    }
}