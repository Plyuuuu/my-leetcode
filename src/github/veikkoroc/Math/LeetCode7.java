package github.veikkoroc.Math;

/**
 *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/26 5:24
 */
public class LeetCode7 {
    public static void main(String[] args) {
        int reverse = reverse(1534236469);
        System.out.println(reverse);


        System.out.println(-2<<30);
        //-优先级大于<<
        System.out.println((2<<30)-1);


        System.out.println(Math.pow(-2,31));
        System.out.println(Math.pow(2,31)-1);
    }

    /**
     * 通过不断取余获得每个数值
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        //结果,使用long防止判断时溢出
        long res = 0;

        while (x!=0){
            //int temp = x%10;
            res = res*10 + x%10;
            if (res<-2<<30||res>(2<<30)-1){
                return 0;
            }
            x = x/10;
        }
        return (int)res;
    }
}
