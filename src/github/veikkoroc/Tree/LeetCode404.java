package github.veikkoroc.Tree;

import github.veikkoroc.z_util.tree.TreeFactory;
import github.veikkoroc.z_util.tree.TreeNode;

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/15 14:20
 */
public class LeetCode404 {

    public static void main(String[] args) {
        TreeNode root = TreeFactory.getBinaryTree();
        System.out.println(root);
        int i = sumOfLeftLeaves(root);
        System.out.println(i);
    }
    public static int sumOfLeftLeaves(TreeNode root) {
        //空树
        if (root == null ){
            return 0;
        }
        //创建一个存放结果的变量
        int sum = 0;
        //如果是左叶子节点
        if (root.left!=null&&root.left.left==null&&root.left.right==null){
            //存放左叶子结点的值
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

        return sum;
    }
}
