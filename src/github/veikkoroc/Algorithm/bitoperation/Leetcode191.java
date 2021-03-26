package github.veikkoroc.algorithm.bitoperation;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/22 12:16
 */
public class Leetcode191 {

    public static void main(String[] args) {
        System.out.println(0b10); // 2
        System.out.println(010); // 8
        System.out.println(10); // 10
        System.out.println(0x10); // 16

        System.out.println(hammingWeight(0b1010));
        System.out.println(hammingWeight(1010));
        System.out.println(hammingWeight(011101));

        System.out.println(hammingWeight2(0b11101));
        System.out.println(hammingWeight2(011101));

        // 测试十进制是否也会用二进制运算
        System.out.println(hammingWeight(10));
        System.out.println(hammingWeight2(10));
    }

    /**
     * 二进制：0b 开头
     * 八进制：0 开头(但是运算还是以二进制运算)
     * 十进制：默认
     * 十六进制：0x 开头
     *
     *  方式1：循环暴力检查
     *
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & (1<<i)) != 0){
                res++;
            }
        }
        return res;
    }

    /**
     * 方式2：
     *      n&（n-1） = 6 & 5 = 0110 & 0101 = 0100 = 4
     *      7 & 6 = 0111 & 0110 = 0110 = 6
     *      把 n 的最后一位 1 变为 0
     *
     * @param n
     * @return
     */
    public static int hammingWeight2(int n) {
        int res = 0;

        while ( n!=0 ){
            res ++;
            n = n&(n-1);
        }
        return res;
    }

}
