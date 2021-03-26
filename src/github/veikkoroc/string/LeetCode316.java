package github.veikkoroc.string;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/12/20 13:16
 */
public class LeetCode316 {

    /**
     * 使用数组存放26个字母的个数，初始为0
     * 把字符串转字符数组
     * 遍历字符串，
     *      每当字符出现次数为0时就把数组对应的位置的字母个数+1，且把该字符添加到结果集上
     *      否则不添加
     * @param s
     * @return
     */
    int[] help = new int[26];
    public String removeDuplicateLetters(String s) {

        char[] chars = s.toCharArray();
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            if (help[chars[i]-97]>0){
                continue;
            }else {
                res += chars[i];
                help[chars[i]-97]++;
            }
        }

        return res;
    }


}
