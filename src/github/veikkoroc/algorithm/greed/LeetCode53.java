package github.veikkoroc.algorithm.greed;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/7 17:24
 */
public class LeetCode53 {

    /**
     * 贪心算法
     * https://leetcode-cn.com/problems/maximum-subarray/solution/53-zui-da-zi-xu-he-bao-li-tan-xin-xiang-jie-by-car/
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {


        int maxSum = Integer.MIN_VALUE;
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
             temp += nums[i];
             if (temp > maxSum){
                 maxSum = temp;
             }
             if (temp <= 0){
                 temp = 0;
             }
        }

        return maxSum;
    }
}
