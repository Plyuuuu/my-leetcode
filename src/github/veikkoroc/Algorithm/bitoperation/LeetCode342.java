package github.veikkoroc.algorithm.bitoperation;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/26 10:57
 */
public class LeetCode342 {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(1<<31);
    }

    /**
     * 思路：
     *
     *  4 的幂 ：1 ，4,16,64....
     *  1<<0,1<<2,1<<4
     *
     *  所以 4 的幂是只有一个 1 而且 是 1 左移偶数位
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfFour(int n) {

        // 边界判断，n>=0
        if (n<0){
            return false;
        }


        // 先判断是否只有一个 1
        int res = 0;
        int temp = n;
        while (temp!=0){
            // 判断最后一位是否为1
            if ((temp&1) != 0){
                res ++;
            }
            temp>>=1;
        }
        if (res != 1){
            return false;
        }
        System.out.println(res);

        // 再判断1是否在偶数位
        for (int i = 0; i < 32; i++) {


            if (n==0){
                if ((i+1)%2 == 0){
                    return true;
                }
                return false;
            }
            n = n>>1;
        }

        return false;
    }

}
