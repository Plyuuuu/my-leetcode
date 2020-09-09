package github.veikkoroc.z_util.tree;

/**
 * 二叉树节点
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/9 21:07
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
