package github.veikkoroc.algorithm.DFS;

import github.veikkoroc.z_util.tree.TreeFactory;
import github.veikkoroc.z_util.tree.TreeNode;

/**
 *
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/26 18:27
 */
public class LeetCode101 {
    public static void main(String[] args) {
        TreeNode binaryTree = TreeFactory.getBinaryTree();
        boolean symmetric = isSymmetric(binaryTree);
        System.out.println(symmetric);
    }
    public static boolean isSymmetric(TreeNode root) {
        // 1.如果是空树，返回true
        if (root == null){
            return true;
        }
        // 2.如果只有一个节点，返回true
        if (root.left == null && root.right == null){
            return true;
        }
        // 3.如果缺少左子树或者右子树，返回false
        if (root.left == null || root.right == null){
            return false;
        }
        // 4.如果是大于等于三个节点的二叉树，执行isMirror方法

        return isMirror(root.left,root.right);

    }
    public static boolean isMirror(TreeNode left,TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }
}
