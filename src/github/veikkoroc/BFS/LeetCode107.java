package github.veikkoroc.BFS;

import java.util.*;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/6 16:33
 */
public class LeetCode107 {
    public static void main(String[] args) {
        //创建一颗二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrderBottom(root));

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null){//root为空，返回空数组
            return new ArrayList<List<Integer>>();
        }
        //存放最终结果
        ArrayList<List<Integer>> result = new ArrayList<>();
        //借助队列，把跟节点放入队尾
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //队列不为空执行如下操作
        while(!queue.isEmpty()){
            //遍历次数为队列的长度
            int n = queue.size();
            //存放每次遍历的结果
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode poll = queue.poll();//出队列
                arrayList.add(poll.val);
                //按成遍历
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            result.add(arrayList);

        }

        //翻转结果
        Collections.reverse(result);
        return result;
    }

    //树节点
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
