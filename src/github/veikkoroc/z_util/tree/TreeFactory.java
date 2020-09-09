package github.veikkoroc.z_util.tree;

import github.veikkoroc.BFS.LeetCode107;

/**
 * 获取一个二叉树
 * 树结构参照如下
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/9 21:10
 */
public class TreeFactory {
    public static TreeNode getBinaryTree(){
        //创建一颗二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }
}
