package github.veikkoroc.Tree;

import github.veikkoroc.z_util.tree.TreeNode;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/6 11:05
 */
public class LeetCode226 {

    /**
     * 递归法
     *  递归结束条件:root.left == root.right == null
     *  每层递归在干嘛:temp = root.left,root.left == root.right,root.right == temp
     *  返回值:root
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {



        if (root == null ||(root.left == null && root.right == null)){
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left!=null){
            invertTree(root.left);
        }
        if (root.right!=null){

            invertTree(root.right);
        }

        return root;
    }
}
