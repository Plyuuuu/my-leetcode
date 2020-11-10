package github.veikkoroc.Algorithm.DFS;

import java.util.*;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *  深度优先遍历、递归、回溯
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/9 20:32
 */
public class LeetCode46 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> permute = permute(arr);
        System.out.println(permute);

    }

    /**
     * 状态变量
     *  递归的层数：depth
     *  已经选了哪些数：path
     *  是否被选过：used boolean[]
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        //数组长度
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //nums为空，返回空结果
        if (len == 0){
            return res;
        }
        //栈实现路径
        Deque<Integer> path = new ArrayDeque<Integer>();
        //是否被选过
        boolean[] used = new boolean[len];
        dfs(nums,len,0,path,used,res);

        return res;
    }

    private static void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        //递归结束条件
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0;i<len;i++){
            if (used[i]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth+1,path,used,res);
            //回溯
            path.removeLast();
            used[i] = false;
        }

    }
}
