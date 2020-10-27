package github.veikkoroc.DoublePoint;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/27 15:50
 */
public class LeetCode26 {
    public static void main(String[] args) {

    }
    public static int removeDuplicates(int[] nums) {
        // 边界判断
        if (nums.length ==0){
            return 0;
        }
        int pre = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[pre] != nums[i]){
                pre++;
                nums[pre] = nums[i];
            }
        }

        return pre+1;
    }
}
