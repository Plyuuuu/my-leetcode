package github.veikkoroc.Competition.LeetCode.shangtang216;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/23 14:06
 */
public class LeetCode1664 {
    @Test
    public void test(){
        waysToMakeFair(new int[]{2,1,6,4});
    }
    public int waysToMakeFair(int[] nums) {
        int n=nums.length;
        int [] odd=new int[n];//奇数前缀和，到nums[i]为止的奇数元素之和
        int []even=new int[n];//偶数前缀和，到nums[i]为止的偶数元素之和
        even[0]=nums[0];
        odd[0]=0;
        for(int i=1;i<n;i++){
            if(i%2==0){//偶数
                even[i]=even[i-1]+nums[i];
                odd[i]=odd[i-1];
            }else{//奇数
                odd[i]=odd[i-1]+nums[i];
                even[i]=even[i-1];
            }
        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(odd));
//        System.out.println(Arrays.toString(even));

        // 保存结果
        int res = 0;
        // 试试每个都被删除是否满足结果
        for (int i = 0; i < n; i++) {
            // 删除索引为i后左边部分和, 注意，删除第一个元素左边是没有和的
            int oddSumLeft = i > 0?odd[i-1]:0;
            int evenSumLeft = i > 0?even[i-1]:0;
            // 右边部分和
            int oddSumRight = i < n-1 ? odd[n-1] - odd[i]:0;
            int evenSumRight = i < n-1 ? even[n-1] -even[i]:0;

            if (oddSumLeft+evenSumRight == oddSumRight + evenSumLeft){
                res++;
            }


        }

        return res;
    }
}
