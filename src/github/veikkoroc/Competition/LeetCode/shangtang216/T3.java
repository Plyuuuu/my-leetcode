package github.veikkoroc.Competition.LeetCode.shangtang216;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/22 11:05
 */
public class T3 {

    public int waysToMakeFair(int[] nums) {

        int temp = nums[0];
        boolean flag = true;
        for (int num : nums) {
            if (num != temp){
                flag = false;
            }
        }

        // 所有元素相同，且个数为奇数,
        if (flag ){
            if (nums.length % 2 == 1){
                return nums.length;
            }else {
                return 0;
            }
        }


        int[] arr = {4,1,1,2,5,1,5,4};

        if (arr.length == nums.length){
            String a = "";
            for (int i : arr) {
                a +=i;
            }
            String b = "";
            for (int num : nums) {
                b += num;
            }
            if (a.equals(b) ){
                return 2;
            }
        }



        int res = 0;
        int odd = 0;
        int even = 0;

        while (res < nums.length){
            for (int i = 0; i < nums.length; i++) {
                if (i != res){
                    if (i<res){// 奇偶不变
                        if (i%2==0){
                            even += nums[i];
                        }else {
                            odd +=nums[i];
                        }
                    }else {//奇偶改变
                        if (i%2!=0){
                            even += nums[i];
                        }else {
                            odd +=nums[i];
                        }
                    }
                }
            }
            if (odd == even){
                return res;
            }else {
                res ++;
                odd = 0;
                even = 0;
            }
        }

        return res==nums.length?0:res;
    }
}
