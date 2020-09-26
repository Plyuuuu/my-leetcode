package github.veikkoroc.String;

/**
 *
 * 2. 缩写校验（建议时间复杂度 O(n) ）
 * 给定⼀一个⾮非空字符串串 s 和⼀一个缩写 abbr，请校验它们是否匹配。
 * 假设字符串串中只包含⼩小写字⺟母，缩写中只包含⼩小写字⺟母和数字。缩写中的数字
 * 表示其缩略略的字符数；连续多位数字表示⼀一个多位数。
 *
 * 例例如，字符串串 “word” 的缩写有且仅有以下这些：[“word", "1ord", "w1rd",
 * "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d",
 * "w3", “4"]。
 *
 * 例例 1：输⼊入：s = “internationalization"，abbr = "i12iz4n"
 * 返回：true
 * 解释：abbr 中的 12 表示有⼗十⼆二个字符被缩略略了了。
 *
 * 例例 2：输⼊入：s = “apple"，abbr = “a2e"
 * 返回：false
 * 需要实现的⽅方法原型：boolean valid(String word, String abbr)
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/26 12:41
 */
public class DaXi02 {

    public static void main(String[] args) {
        String s1 = "internationalization";
        String abbr1 = "i12iz4n";
        String s2 = "apple";
        String abbr2 = "a2le";

        boolean var1 = valid(s1, abbr1);
        System.out.println(var1);

        boolean var2 = valid(s2, abbr2);
        System.out.println(var2);
    }
    public static boolean valid(String word,String abbr){
        //abbr不符合条件返回false
        if (abbr == null || abbr == "" || word.length()<abbr.length()){
            return false;
        }

        //先把字符串转成字符数组
        char[] words = word.toCharArray();
        char[] abbrs = abbr.toCharArray();

        // 使用双指针,i指向words，j指向abbrs
        int i = 0;
        int j = 0;

        while (i < words.length && j < abbrs.length){
            //相同字符，继续比较
            if (words[i] == abbrs[j]){
                i++;
                j++;
                continue;
            }
            //如果abbrs有数字
            if (Character.isDigit(abbrs[j])){
                int temp = 0;
                //不止一位数的话继续获取
                while (j<abbrs.length && Character.isDigit(abbrs[j])){
                    temp = temp*10 + abbrs[j]-'0';
                    j++;
                }
                //System.out.println("数字是："+temp);
                i += temp;
            }
            //如果既不是数字，也不一样，返回false
            else {
                return false;
            }
        }
        //都遍历到末尾返回true
        return (i == words.length)&&(j == abbrs.length);
    }

}
