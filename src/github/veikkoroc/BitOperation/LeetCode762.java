package github.veikkoroc.BitOperation;

/**
 * 762. 二进制表示中质数个计算置位
 * 输入: L = 6, R = 10
 * 输出: 4
 * 解释:
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 *
 * ps:R最大是10的六次方
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/14 9:00
 */
public class LeetCode762 {
    public static void main(String[] args) {
        int i = countPrimeSetBits(842, 888);
        System.out.println(i);
    }
    public static int countPrimeSetBits(int L, int R) {
        //如果L小于R，返回0
        if (L>R){
            return 0;
        }
        //存放结果
        int res = 0;
        for (int i = L;i<=R;i++){
            if (bitCountIsPrime(i)){
                res ++;
            }
        }
        return res;
    }
    public static boolean bitCountIsPrime(int i){
        int j = Integer.bitCount(i);
        return (j==2||j==3||j==5||j==7||j==11||j==13||j==17||j==19);
    }

}
