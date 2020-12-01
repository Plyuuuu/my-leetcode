package github.veikkoroc.algorithm.Greed;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/20 19:10
 */
public class LeetCode122 {



    public int maxProfit(int[] prices) {

        // 存放结果
        int res = 0;
        // 存放差值
        int temp = 0;
        // 双指针
        int l = 0;
        int r = l+1;


        while (r < prices.length){
            temp = prices[r] - prices[l];
            if (temp >0 ){
                res += temp;
            }
            l++;
            r++;
        }


        return res;
    }

}
