package github.veikkoroc.DFS;

import github.veikkoroc.z_util.tree.TreeFactory;
import github.veikkoroc.z_util.tree.TreeNode;

/**
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * https://leetcode-cn.com/problems/same-tree/
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/26 18:08
 */
public class LeetCode100 {
    public static void main(String[] args) {

        TreeNode binaryTree1 = TreeFactory.getBinaryTree();
        TreeNode binaryTree2 = TreeFactory.getBinaryTree();

        boolean sameTree = isSameTree(binaryTree1, binaryTree2);
        System.out.println(sameTree);
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }

    }
}
