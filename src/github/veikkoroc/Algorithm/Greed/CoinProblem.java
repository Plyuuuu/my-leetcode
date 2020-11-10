package github.veikkoroc.Algorithm.Greed;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 硬币问题：
 *  有 1元、5元、10元、50元、100元、500元的硬币各c1,c5,c10,c50,c100,c500枚
 *  现在要用这些硬币来支付A元，最少需要支付多少硬币？
 *
 *  输入：
 *      第一行：输入6个数字，分别代表从小到大硬币的个数
 *      第二行：输入需要支付A元
 *  样例：
 *   输入：
 *      3 2 1 3 0 2
 *      620
 *   输出：
 *      6
 *  c500=1,c100=0,c50=2,c10=1,c5=2,c1=0
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/7 20:23
 */
public class CoinProblem {
    public static void main(String[] args) {

        // 创建扫描器
        Scanner scanner = new Scanner(System.in);

        // 放硬币个数的数组
        int[] coins = new int[6];
        for (int i = 0; i < 6; i++) {
            // 默认回车作为分隔,空格也可以
            coins[i] = scanner.nextInt();
        }
        System.out.println("coins = "+Arrays.toString(coins));

        // 需要支付的钱
        int A = scanner.nextInt();
        System.out.println("A = "+A);

    }

    /**
     *
     * @param arr    从小到大面值的硬币个数
     * @param count  需要付的钱
     * @return
     */
    private static int solution(int[] arr,int count){

        // 边界判断
        if (count <= 0 ) return 0;




        return 0;
    }


}
