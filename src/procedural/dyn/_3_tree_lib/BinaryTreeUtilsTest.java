package procedural.dyn._3_tree_lib;


import procedural.dyn.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 20.08.13
 * Time: 12:04
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeUtilsTest {
    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(0, null, null);
        root.left = new TreeNode(1, null, null);
        root.right = new TreeNode(2, null, null);
        root.left.right = new TreeNode(3, null, null);
        root.right.left = new TreeNode(4, null, null);
        root.left.right.left = new TreeNode(3, null, null);
        root.left.right.right = new TreeNode(2, null, null);
        root.right.left.left = new TreeNode(1, null, null);
        root.right.left.right = new TreeNode(0, null, null);
        System.out.println("Size:   " + BinaryTreeUtils.size(root));
        System.out.println("Height: " + BinaryTreeUtils.height(root));
        System.out.println("Sum:    " + BinaryTreeUtils.sum(root));
        System.out.println("Max:    " + BinaryTreeUtils.max(root));
    }
}
