package github.veikkoroc.recursion;

import github.veikkoroc.z_util.tree.TreeFactory;
import github.veikkoroc.z_util.tree.TreeNode;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/9 21:07
 */
public class GetBinaryTreeHeight {
    public static void main(String[] args) {
        TreeNode root = TreeFactory.getBinaryTree();
        System.out.println(getBinaryTreeHeight(root));
    }
    public static int getBinaryTreeHeight(TreeNode root){
        if (root == null){//空二叉树返回0
            return 0;
        }
        int height_left = 1;
        int height_right = 1;
        if (root.left !=null){
            height_left += getBinaryTreeHeight(root.left);
        }
        if (root.right!=null){
            height_right += getBinaryTreeHeight(root.right);
        }

        return height_left>height_right?height_left:height_right;
    }

}
