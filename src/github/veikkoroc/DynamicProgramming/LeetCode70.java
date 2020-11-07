package github.veikkoroc.DynamicProgramming;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/14 11:40
 */
public class LeetCode70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(0));
    }

    /**
     *
     * 斐波那契数列：0、1、1、2、3、5、8、13、21、34、55、89、144、233
     *
     * 题解：https://leetcode-cn.com/problems/climbing-stairs/solution/hua-jie-suan-fa-70-pa-lou-ti-by-guanpengchn/
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1+sqrt_5)/2,n+1)-Math.pow((1-sqrt_5)/2,n+1);
        return (int)(fib_n/sqrt_5);
    }
}
