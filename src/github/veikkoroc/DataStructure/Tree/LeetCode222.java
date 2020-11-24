package github.veikkoroc.DataStructure.Tree;

import github.veikkoroc.z_util.tree.TreeNode;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/24 11:31
 */
public class LeetCode222 {

    /**
     * 暴力破解
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {

        if (root == null){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return root==null?0:(countNodes(root.left)+countNodes(root.right)+1);
    }
}
