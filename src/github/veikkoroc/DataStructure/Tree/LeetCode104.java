package github.veikkoroc.DataStructure.Tree;

import github.veikkoroc.z_util.tree.TreeFactory;
import github.veikkoroc.z_util.tree.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/6 20:25
 */
public class LeetCode104 {
    public static void main(String[] args) {
        TreeNode root = TreeFactory.getBinaryTree();
        System.out.println(maxDepth(root));

    }

    /**
     * 递归三部曲
     *  1.终止条件
     *  2.求返回值
     *  3.本级递归做什么
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {

        //1、终止条件
        if (root == null){
            return 0;
        }
        // 2、每层递归在什么 求左右子树最大深度
        int liftHeight = 1;
        int rightHeight = 1;

        if (root.left != null){
            liftHeight += maxDepth(root.left);
        }
        if (root.right != null){
            rightHeight +=maxDepth(root.right);
        }
        //3、求返回值
        return rightHeight>liftHeight?rightHeight:liftHeight;
    }
}
