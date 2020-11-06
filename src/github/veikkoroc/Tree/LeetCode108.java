package github.veikkoroc.Tree;

import github.veikkoroc.z_util.tree.TreeNode;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/6 10:20
 */
public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {

        return dfs(nums,0,nums.length-1);
    }

    /**
     * 递归法
     *  终止条件:l==r
     *  在干什么:中间值(l+r)/2对应根节点, 左边的放更节点左边，右边放右边
     *  返回什么:当前递归的根节点
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public TreeNode dfs(int[] nums,int l,int r){
        // 终止条件
        if (l > r){
            return null;
        }

        // 中间节点
        //int mid = (l+r)/2;
        int mid = l+(r-l)/2;

        // 构建node
        TreeNode node = new TreeNode(nums[mid]);

        // 递归
        node.left = dfs(nums,l,mid-1);
        node.right = dfs(nums,mid+1,r);



        return node;
    }
}
