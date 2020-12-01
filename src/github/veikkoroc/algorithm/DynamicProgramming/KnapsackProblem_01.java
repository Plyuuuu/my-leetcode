package github.veikkoroc.algorithm.DynamicProgramming;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/9 16:08
 */
public class KnapsackProblem_01 {

    public static void main(String[] args) {

        // 物品的质量和价值
        int[] w = {1,4,3};
        int[] v = {1500,3000,2000};

        // 背包的容量
        int capacity = 4;

        // 物品的个数
        int count = v.length;

        // 创建放入背包的价值vSum
        int[][] vSum = new int[count+1][capacity+1];

        // 根据公式进行动态规划处理,不处理第一行第一列
        // i表示物品
        for (int i = 1; i < vSum.length; i++) {
            // j表示动态的容量
            for (int j = 1; j < vSum[0].length; j++) {
                // 物品重量>当前背包的最大容量
                // 因为程序i从1开始，所有物品重量从i-1开始
                if (w[i-1] > j){
                    vSum[i][j] = vSum[i-1][j];
                }else {
                    // 因为j从1开始，所有求价值要i-1
                    vSum[i][j] = Math.max(vSum[i-1][j],v[i-1]+vSum[i-1][j-w[i-1]]);
                }
            }
        }

        // 输出二维表格
        for (int i = 0; i < vSum.length; i++) {
            System.out.println(Arrays.toString(vSum[i]));
        }

    }

    /**
     * 测试二维数组
     */
    @Test
    public void test(){
        int[][] arr = { {1,2,3},
                        {4,5,6},
                        {7,8,9}};

        System.out.println(Arrays.toString(arr[0]));
        System.out.println(arr[1][1]);

    }
    @Test
    public void test01(){
        int[] a = new int[2];
        System.out.println(a[0]);
    }

}
