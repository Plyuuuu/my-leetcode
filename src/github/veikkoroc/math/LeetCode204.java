package github.veikkoroc.math;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/12/3 0:06
 */
public class LeetCode204 {

    /**
     * 埃氏筛算法  优化
     *
     * @param n
     * @return
     */
    public int countPrimes1(int n) {

        // 计算结果
        int res = 0;

        // 0-n每个数是否为质数的标志
        boolean[] flag = new boolean[n];

        // 其实当 i*i > n 时后面的保留数字没必要在重复进行排除了
        int sqrt = (int)Math.sqrt(n);


        // 从二开始，0 和 1 都不算是质数
        for (int i = 2; i <= sqrt; i++) {
            // 把i的倍数的数排除,比如i = 2, 4,6,8,10...都要排除
            if ( i*i < n && !flag[i] ){


                for (int j = i<<1;j < n ;j+=i){

                    // 排除当前质数的倍数
                    flag[j] = true;
                }
            }

        }
        for (int i = 2; i < flag.length; i++) {
            if (!flag[i]) res++;
        }
        return res;
    }

    /**
     * 埃氏筛算法
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {

        // 计算结果
        int res = 0;

        // 0-n每个数是否为质数的标志
        boolean[] flag = new boolean[n];

        // 从二开始，0 和 1 都不算是质数
        for (int i = 2; i < n; i++) {
            // 把i的倍数的数排除,比如i = 2, 4,6,8,10...都要排除
            if ( i*i < n && !flag[i] ){


                for (int j = i<<1;j < n ;j+=i){

                    // 排除当前质数的倍数
                    flag[j] = true;
                }
            }

        }
        for (int i = 2; i < flag.length; i++) {
            if (!flag[i]) res++;
        }
        return res;
    }

    @Test
    public void test(){
        boolean[] arr = new boolean[5];
        // [false, false, false, false, false]
        System.out.println(Arrays.toString(arr));
    }
}
