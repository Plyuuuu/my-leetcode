package github.veikkoroc.Competition.LeetCode.shangtang216;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/23 13:36
 */
public class LeetCode1663 {

    @Test
    public void test(){
        getSmallestString(3,27);
    }

    /**
     * 思路：
     *      先把赋值n个a==>"aaaa"
     *      计算剩余值 t = k-n;
     *      把剩余值从后往前加入arr
     * @param n
     * @param k
     * @return
     */
    public String getSmallestString(int n, int k) {

        char[] arr = new char[n];

        // 赋值失败
       /* for (char c : arr) {
            c = 'a';
        }*/
       // 赋值成功
        for (int i = 0; i < n; i++) {
            arr[i] = 'a';
        }

        // System.out.println(Arrays.toString(arr));

        // 计算剩余值
        int t = k-n;
        // System.out.println(t);

        // 把t加入arr
        for (int i = n-1; i > -1; i--) {
            // t >= 25
            int temp = t / 25;
            if (temp >0){
                arr[i] = (char)(arr[i]+25);
                t = t -25;

                // t < 25
            }else {
                // 0 < t < 25
                if (t % 25 > 0){
                    arr[i] = (char)(arr[i]+t);
                }
                break;
            }
        }


        return new String(arr);
    }
}
