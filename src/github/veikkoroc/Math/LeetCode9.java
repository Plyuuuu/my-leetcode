package github.veikkoroc.Math;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/28 9:56
 */
public class LeetCode9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome3(1000000001));
    }
    public static boolean isPalindrome(int x) {
        //把数字转字符串
        String str = x+"";
        StringBuilder reverse = new StringBuilder(str).reverse();
        return str.equals(reverse.toString());
    }
    public static boolean isPalindrome1(int x) {
        //边界判断
        if (x<=9 && x>=0){
            return true;
        }
        if (x<0||x%10==0){
            return false;
        }
        //求x的最大位数
        long temp = 1;
        while (temp < x){
            temp *= 10;
        }
        temp /=10;
        int temp1 = (int)temp;
        //System.out.println(temp);

        while (x>0){
            int left = x/temp1;
            int right = x%10;
            //System.out.println("left:"+left);
            //System.out.println("right:"+right);
            if (left!=right){
                return false;
            }
            x = x%temp1/10;
            temp1 /=100;
            //System.out.println("x:"+x);
        }


        return true;
    }
    public static boolean isPalindrome3(int x) {
        //边界判断
        if (x < 0){ return false;}
        int div = 1;
        //
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}
