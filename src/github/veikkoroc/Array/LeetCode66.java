package github.veikkoroc.Array;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 思路：
 *  第一种情况：最后一位不是9，直接+1再返回
 *  第二种情况：最后一位是9，且中间位有不是9
 *  第三种情况：全是9，直接返回比原数组size大一的且第0位位1的数组
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/14 14:22
 */
public class LeetCode66 {
    public static void main(String[] args) {
        //[9,8,7,6,5,4,3,2,1,0]
        int [] arr = {9,8,7,6,5,4,3,2,1,0};
        int[] arr1 = {9,9,9};
        int[] ints = plusOne(arr1);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0){
                return digits;
            }

        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

   /* public static int[] plusOne(int[] digits) {
        //数组的长度
        int length = digits.length;
        //存放数组对应的数值
        long num = 0;
        for (int i = 0; i < digits.length; i++) {
            //num = 3*1+2*10+1*100
            num += digits[digits.length-i-1]* Math.pow(10,i);
        }
        //9876543211
        num = num+1;

        String string = num+"";
        int len = string.length();
        //存放结果
        int[] res = new int[len];
        //把数值转成数组
        for (int i = 0; i < len; i++) {

            res[i] = (int) ((Long)num/Math.pow(10,len-1-i))%10;
        }

        return res;
    }*/
    @Test
    public  void test(){
        double l = 9876543211L;
        System.out.println(l%10);
    }
}
