package github.veikkoroc.Algorithm.DFS;

import github.veikkoroc.z_util.tree.TreeNode;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/24 11:40
 */
public class LeetCode112 {

    public boolean hasPathSum(TreeNode root, int sum) {

        // 递归终止条件

        if (root == null){
            return false;
        }

        // 到达根节点判断是否满足
        if (root.left == null && root.right == null){
            return root.val == sum;
        }

        // 左边递归
        if (hasPathSum(root.left,sum - root.val)){
            return true;
        }
        // 右边递归
        if (hasPathSum(root.right,sum - root.val)){
            return true;
        }

        return false;
    }
}
