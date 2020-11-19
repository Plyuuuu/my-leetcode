package github.veikkoroc.DataStructure.Array;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/19 15:07
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {

        // 创建计数器
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                count++;
                continue;
            }
            if (count > 0 ){
                // 把当前元素前移count为
                nums[i-count] = nums[i];
                nums[i] = 0;
            }

        }


    }
}
