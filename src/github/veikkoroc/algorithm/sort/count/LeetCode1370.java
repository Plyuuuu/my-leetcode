package github.veikkoroc.algorithm.sort.count;

import org.junit.Test;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/25 18:17
 */
public class LeetCode1370 {
    /**
     * 计数排序
     * @param s
     * @return
     */
    public String sortString(String s) {

        char[] chars = s.toCharArray();

        // 存放每个字母的个数, a = 97
        int[] bucket = new int[26];

        // 把chars每个字符放入相应的桶中
        for (char aChar : chars) {
            int temp = bucket[aChar-97];
            bucket[aChar-97] = ++temp;
        }
        // System.out.println(Arrays.toString(bucket));

        // 找出桶中最多的个数
        int max = 0;
        for (int i : bucket) {
            if (i > max){
                max = i;
            }
        }
        // System.out.println(max);

        // 创建指针 i 来回遍历
        int i = 0;


        // 表示遍历方向的flag
        boolean direction = true;

        // 存放结果
        String res = "";

        while (max > 0){

            if (bucket[i] != 0){
                res +=(char)(i+97);
                bucket[i] = bucket[i] -1;

            }
            if (direction){
                i++;
                if (i == bucket.length){
                    direction = false;
                    i--;
                    max--;
                    continue;
                }
            }else {
                i--;
                if (i == -1){
                    direction = true;
                    i++;
                    max--;
                    continue;
                }
            }


        }

        return res;
    }
    @Test
    public void test(){
        System.out.println('a'+1);
        System.out.println(sortString("aaabbbccc"));
    }
}
