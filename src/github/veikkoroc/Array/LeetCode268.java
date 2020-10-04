package github.veikkoroc.Array;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *  示例 1:
 *
 *      输入: [3,0,1]
 *      输出: 2
 *
 * 示例 2:
 *
 *      输入: [9,6,4,2,3,5,7,0,1]
 *      输出: 8
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/4 20:10
 */
public class LeetCode268 {
    public static void main(String[] args) {
        int[] arr = {2,0,1};
        int i = missingNumber(arr);
        System.out.println(i);
    }

    /**
     * 方式一：异或
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {

        //获取数组长度
        int length = nums.length;

        //存放结果
        int res =0;

        //遍历nums
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }

        return res^length;
    }

    /**
     * 数学
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums) {
        //获取数组长度
        int length = nums.length;
        System.out.println("length:"+length);
        //计算1-n的和，再减去数组所有值的和
        int sum = (length)*(length+1)/2;
        System.out.println("sum:"+sum);
        int numsSum = 0;
        for (int num : nums) {
            numsSum +=num;
        }
        System.out.println("numsSum:"+numsSum);
        return sum-numsSum;
    }
}
