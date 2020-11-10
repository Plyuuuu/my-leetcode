package github.veikkoroc.DataStructure.Tree;

import github.veikkoroc.z_util.tree.TreeFactory;
import github.veikkoroc.z_util.tree.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度（叶子节点到根节点的深度）。
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/13 22:00
 */
public class LeetCode111 {
    public static void main(String[] args) {
        TreeNode root = TreeFactory.getBinaryTree();
        System.out.println(root);
        int i = minDepth(root);
        System.out.println(i);
    }
    public static int minDepth(TreeNode root) {
        //传入空值返回0
        if (root == null){
            return 0;
        }
        //第一种情况：左右节点都为空直接返回 1
        if (root.left== null && root.right==null){
            return 1;
        }
        //第二种情况：左右节点有一个为空，返回不为空节点的深度
        int num1 = minDepth(root.left);
        int num2 = minDepth(root.right);
        if (root.left==null|| root.right==null){
            return num1+num2+1;
        }
        //第三种情况：左右节点都不为空
        return Math.min(num1,num2)+1;
    }
}
