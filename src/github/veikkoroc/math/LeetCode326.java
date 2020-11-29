package github.veikkoroc.math;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/17 14:32
 */
public class LeetCode326 {
    public static void main(String[] args) {
        int pow = (int)Math.pow(3, 19);
        int pow1 = (int)Math.pow(3, 20);
        int pow2 = (int)Math.pow(3, 21);
        System.out.println(pow);
        System.out.println(pow1);
        System.out.println(pow2);
        System.out.println(isPowerOfThree(3));
    }
    public static boolean isPowerOfThree(int n) {
        //如果n<1(3的0次方)，返回false
        if (n<1){
            return false;
        }
        //int 的最大是 3 的 19次方     -2^31 - 2^31-1

        return n>=1&&Math.pow(3,19)%n==0.0;
    }
}
