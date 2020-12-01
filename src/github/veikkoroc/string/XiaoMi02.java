package github.veikkoroc.string;

import java.util.HashMap;

/**
 * 给定一个字符串, 需要去除所有之前曾经出现过的字符，只保留第一次出现的字符
 * 样例输入
 *  hello, welcome to xiaomi
 * 样例输出
 *  helo, wcmtxia
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/15 20:09
 */
public class XiaoMi02 {
    public static void main(String[] args) {


        String hell = deleteChar2("hello, welcome to xiaomi");
        System.out.println(hell);
    }
    public static String deleteChar2(String s){
        char[] chars = s.toCharArray();
        //使用数组记录字符出现次数，
        int[] arr = new int[chars.length];
        //使用Map记录字符出现个数
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            //不包含直接加入
            if (!map.containsKey(chars[i])){
                map.put(chars[i],1);

                //包含val+1
            }else {
                Integer integer = map.get(chars[i]);
                map.replace(chars[i],++integer);

            }
            //记录对应字符第几次出现
            arr[i] = map.get(chars[i]);
        }
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            //第一次出现，保存下来
            if (arr[i]==1){
                res += chars[i];
            }
        }
        return res;
    }

    /**
     * 坑：Map集合的键会自动排序
     *  ps:....好像用 hashMap 不太行
     * @param s
     * @return
     */
    public static String deleteChar(String s){
        char[] chars = s.toCharArray();

        //使用Map
        HashMap<Character,Integer> map = new HashMap();
        for (int i = 0; i < chars.length; i++) {
            //不包含直接加入
            if (!map.containsKey(chars[i])){
                map.put(chars[i],1);

                //包含val+1
            }else {
                Integer integer = map.get(chars[i]);
                map.replace(chars[i],++integer);

            }
        }
        // 遍历Map，取出Val是1的字符拼接成字符串
        //存放结果
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            //字母个数等于1
            if (map.get(chars[i])==1){
                res += chars[i];
            }
        }


        return res;
    }
}
