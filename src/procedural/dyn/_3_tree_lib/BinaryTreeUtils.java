package procedural.dyn._3_tree_lib;

import procedural.dyn.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 20.08.13
 * Time: 12:00
 * To change this template use File | Settings | File Templates.
 */
/*
 Разработать класс-библиотеку для работы с бинарными деревьями.
 А именно 4 метода:

public class BinaryTreeUtils {
    public static int size(TreeNode root) {...}
    public static int height(TreeNode root) {...}
    public static int sum(TreeNode root) {...}
    public static int max(TreeNode root) {...}
}

для класса
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
Используйте любой или все вместе подходы при решения задачи
(итеративный, рекурсивные, в любом направлении).
Примечание: почти так и устроен java.util.TreeMap.
Добавляется поддержка "сбалансированности": в отличии от нашего дерева,
TreeMap не вырождается в односвязный список
(структура данных TreeMap называется Красно-Черное дерево).
 */

public class BinaryTreeUtils {
    public static int size(TreeNode root) {
        return root != null ? 1 + size(root.left) + size(root.right) : 0;
    }

    public static int height(TreeNode root) {
        return root != null ? 1 + Math.max(height(root.right), height(root.left)) : 0;
    }

    public static int sum(TreeNode root) {
        return root != null ? root.value + sum(root.left) + sum(root.right) : 0;
    }

    public static int max(TreeNode root) {
        int result;
        result = root.value;
        if (root.left != null) {
            result = Math.max(result, max(root.left));
        }
        if (root.right != null) {
            result = Math.max(result, max(root.right));
        }
        return result;
    }
}
