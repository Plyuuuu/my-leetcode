package github.veikkoroc.bit_operation;

/**
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/7 20:10
 */
public class LeetCode405 {
    public static void main(String[] args) {
        //System.out.println(15&15);
        System.out.println(toHex(-1));
    }
    public static String toHex(int num) {
        if (num==0){
            return "0";
        }
        char[] chars = "0123456789abcdef".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int temp;
        while (num!=0){
            temp = num & 15;//比较num后四位二进制和1111的区别
            stringBuilder.append(chars[temp]);
            num=num>>>4;//无符号右移四位继续比较，直到为0
        }

        return stringBuilder.reverse().toString();
    }
}
