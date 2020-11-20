package github.veikkoroc.Algorithm.DFS;

import github.veikkoroc.z_util.tree.TreeFactory;
import github.veikkoroc.z_util.tree.TreeNode;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/20 20:43
 */
public class GetBinaryTreeHeight {

    public static void main(String[] args) {
        TreeNode binaryTree = TreeFactory.getBinaryTree();
        System.out.println(binaryTree);
        System.out.println(dfs(binaryTree));
        System.out.println(height(binaryTree));
    }
    public static int dfs(TreeNode root){

        // 递归终止条件，左右子树都为null
        if (root.left == null && root.right == null){
            return 1;
        }
        // 左子树为null,返回右子树的高度
        if (root.left == null){
            return dfs(root.right) + 1;
        }
        // 右子树为null，返回左子树的高度
        if (root.right == null){
            return dfs(root.left) + 1;
        }
        // 左右子树都不为空，返回左右子树的最大高度

        return 1 + Math.max(dfs(root.left),dfs(root.right));
    }

    public static int height(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }

}
