package github.veikkoroc.Algorithm.DoublePoint;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/24 13:35
 */
public class LeetCode344 {
    public void reverseString(char[] s) {

        char temp;
        int l = 0;
        int r = s.length-1;
        while (true){
            // 终止条件
            if (l >= r){
                return;
            }
            // 交换
            temp = s[l];
            s[l] = s[r];
            s[r] = temp;

            // 指针移动
            l++;
            r--;
        }

    }
}
