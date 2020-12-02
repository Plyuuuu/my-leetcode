package github.veikkoroc.algorithm.greed;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/8 20:28
 */
public class LeetCode1221 {
    public int balancedStringSplit(String s) {

        // 把s转字符数组
        char[] chars = s.toCharArray();

        // 辅助变量
        int countR = 0;
        int countL = 0;
        int res = 0;

        // 遍历
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R'){
                countR++;
            }else {
                countL++;
            }if (countR == countL){
                res ++;
            }

        }

        return res;
    }
}
