package github.veikkoroc.Math;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/23 15:58
 */
public class LeetCode263 {
    public static void main(String[] args) {

    }
    public boolean isUgly(int num) {
        // 边界判断
        if (num == 0){
            return false;
        }
        while (true){
            if (num % 2 == 0){
                num = num>>1;
            }else if (num % 3 == 0){
                num = num /3;
            }else if (num % 5 == 0){
                num = num/5;
            }else {
                // 不能分解了
                break;
            }
        }
        return num == 1;
    }
}
