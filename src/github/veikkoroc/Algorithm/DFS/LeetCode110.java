package github.veikkoroc.Algorithm.DFS;

import github.veikkoroc.z_util.tree.TreeNode;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/20 19:20
 */
public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {

        if (root == null){
            return true;
        }else {
            return Math.abs(getTreeHeight(root.left)-getTreeHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

    }
    public int getTreeHeight(TreeNode root){

        // root为null返回0
        if (root == null){
            return 0;
        }

        // 左右子树都为空，高度为1
        if (root.left == null && root.right==null){
            return 1;
        }
        // 左子树为空，返回右子树的高度
        if (root.left == null){
            return 1+getTreeHeight(root.right);
        }
        // 右子树为空，返回左子树的高度
        if (root.right == null){
            return 1+getTreeHeight(root.left);
        }
        // 左右子树都不为空，返回左右子树最大高度
        return 1+Math.max(getTreeHeight(root.left),getTreeHeight(root.right));
    }

    public boolean isBalanced1(TreeNode root) {
        if (root == null){
            return true;
        }else {
            return Math.abs(height(root.right)-height(root.left)) <=1 && isBalanced(root.left) && isBalanced(root.right);
        }

    }

    public int height(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }

}
