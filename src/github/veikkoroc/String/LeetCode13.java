package github.veikkoroc.String;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/27 15:12
 */
public class LeetCode13 {
    public static void main(String[] args) {

        System.out.println(romanToInt("LVIII"));

    }
    public static int romanToInt(String s) {

        // 先把字符串转成字符数组
        char[] chars = s.toCharArray();

        // 存放结果
        int res = 0;

        for (int i = 0; i < chars.length; i++) {

            if (i < chars.length-1){
                if (helper(chars[i])<helper(chars[i+1])){
                    res += -helper(chars[i]);
                }else {
                    res += helper(chars[i]);
                }
            }else {
                res +=helper(chars[i]);
            }
        }


        return res;
    }

    /**
     * 辅助方法
     * @param c
     * @return
     */
    public static int helper(char c){
        switch (c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }
}
