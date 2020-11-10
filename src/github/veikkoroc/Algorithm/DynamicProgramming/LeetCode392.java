package github.veikkoroc.Algorithm.DynamicProgramming;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/9 15:58
 */
public class LeetCode392 {

    /**
     * 双指针法
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        // 边界判断
        if (s == ""){
            return true;
        }

        // s:要匹配的字符串,t:目标字符串 都转陈字符数组
        char[] srcChars = s.toCharArray();
        char[] tarChars = t.toCharArray();

        // 创建辅助双指针
        int srcPoint = 0;
        int tarPoint = 0;

        // 创建辅助变量
        int count = 0;

        while (srcPoint < srcChars.length){

            if (tarPoint == tarChars.length){
                return false;
            }

            // 字符一样
           if (tarChars[tarPoint] == srcChars[srcPoint]){
               srcPoint++;
               tarPoint++;
               count++;
           }else {
               tarPoint++;
           }

        }

        return count == srcChars.length;
    }
}
