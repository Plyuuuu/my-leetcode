package github.veikkoroc.Math;

import org.junit.Test;

import java.util.Scanner;

/**
 * 有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。请设计一个算法，计算小团有多少种走法。
 * 给定两个正整数int x,int y，请返回小团的走法数目。
 *
 *  思路：高中排列组合问题
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/22 23:20
 */
public class MoGuJie2019_1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(getNum(x,y));


    }

    /**
     * 排列组合公式方法
     * @param x
     * @param y
     * @return
     */
    public static long getNum(int x,int y){

        return factorial((x+y))/factorial(x)/factorial(y);
    }

    /**
     * 求阶乘
     * @return
     */
    public static long factorial(int i){
        long j = 1;
        for (int k = 1; k <=i; k++) {
            j *= k;
        }
        return j;
    }
    @Test
    public void test(){
        System.out.println(factorial(20)/(factorial(10)*factorial(10)));
        System.out.println(10*9*8*7*6*5*4*3*2*1);
    }
}
