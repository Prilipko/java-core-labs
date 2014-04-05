package procedural.dyn._5_fibonacci_tree;

import procedural.dyn.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 20.08.13
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */

public class TreeVisualizer {
    public static void main(String[] args) {
        print(FibonacciTreeUtils.generateArg(3), 0);
        System.out.println("-------");
        print(FibonacciTreeUtils.generateRes(3), 0);
    }
    private static void print(TreeNode root, int depth) {
        if (root != null) {
            print(root.right, depth + 1);
            for (int k = 0; k < depth; k++) {
                System.out.print("   ");
            }
            System.out.println(root.value);
            print(root.left, depth + 1);
        }
    }
}