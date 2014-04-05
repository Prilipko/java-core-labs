package procedural.dyn._5_fibonacci_tree;

import procedural.dyn.TreeNode;


/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 20.08.13
 * Time: 15:19
 * To change this template use File | Settings | File Templates.
 */


//Разработать класс-библиотеку для генерации бинарного дерева,
//соответствующего по форме истории рекурсивного вычисления числа Фибоначчи.
//А именно 2 метода:
//public class FibonacciTreeUtils{
//    public static TreeNode generateArg(int k) {...}
//    public static TreeNode generateRes(int k) {...}
//}
//
//generateArg() - в качестве value ставит номер числа Фибоначчи
//(аргумент, по которому вычисляют число Фибоначчи):
//generateArg(3) =
//        1
//      /
//    2
//   /  \
//  /    0
//3
//  \
//   1
//
//    generateRes() - в качестве value ставит значение числа Фибоначчи.
//generateArg(3) =
//       1
//      /
//    1
//   /  \
//  /    0
//2
//  \
//    1
//
//    Вспомогательный метод для визуализации бинарного дерева:
//public class TreeVisualizer {
//    public static void main(String[] args) {
//        print(FibonacciTreeGenerator.generateArg(3), 0);
//        System.out.println("-------");
//        print(FibonacciTreeGenerator.generateRes(3), 0);
//    }
//    private static void print(TreeNode root, int depth) {
//        if (root != null) {
//            print(root.right, depth + 1);
//            for (int k = 0; k < depth; k++) {
//                System.out.print("   ");
//            }
//            System.out.println(root.value);
//            print(root.left, depth + 1);
//        }
//    }
//}
//>>>      1
//>>>   2
//>>>      0
//>>>3
//>>>   1
//>>>-------
//>>>      1
//>>>   1
//>>>      0
//>>>2
//>>>   1

public class FibonacciTreeUtils {
    public static TreeNode generateArg(int k) {
        if (k <= 1) {
            return new TreeNode(k, null, null);
        }
        return new TreeNode(k, generateArg(k - 1), generateArg(k - 2));
    }

    private static int getRes(int k) {
        if (k <= 1) return k;
        int result = 1;
        int[] prev = {0, 1};
        for (int i = 1; i < k; i++) {
            result = prev[0] + prev[1];
            prev[0] = prev[1];
            prev[1] = result;
        }
        return result;
    }

    public static TreeNode generateRes(int k) {
        return generateArg(getRes(k));
    }
}
