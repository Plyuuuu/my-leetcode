package github.veikkoroc.algorithm.bitoperation;

/**
 *
 * 颠倒给的二进制数据
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/23 9:01
 */

public class LeetCode190 {

    public static void main(String[] args) {

    }

    /**
     * 1、最低位开始遍历 原二进制数，把每位从左往右添加到新的二进制数上
     * @param n
     * @return
     */
    public static int reverseBits(int n) {

        int res = 0;

        for (int i = 0; i < 32; i++) {
            // 先把res左移一位，空出位置
            res = res <<1;
            // 把 n 最后一位加到 res 最后一位
            res |= n & 1;
            // n 右移一位
            n = n >> 1;
        }


        return res;
    }

}
