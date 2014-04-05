package procedural.dyn.dna_lib;

import procedural.dyn.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 20.08.13
 * Time: 16:48
 * To change this template use File | Settings | File Templates.
 */
public class DnaUtils {
    public static TreeNode dna(int circles, int dim) {
        TreeNode begin = null;
        for (int i = 0; i < circles * dim; i++) {
            begin = new TreeNode(i, begin, null);
        }
        TreeNode result = begin;
        TreeNode nextLevel = begin;
        for (int i = 0; i < dim; i++) {
            assert nextLevel != null;
            nextLevel = nextLevel.left;
        }
        for (int i = 0; i < dim * (circles - 1); i++) {
            assert begin != null;
            begin.right = nextLevel;
            begin = begin.left;
            nextLevel = nextLevel.left;
        }
        return result;
    }
}
