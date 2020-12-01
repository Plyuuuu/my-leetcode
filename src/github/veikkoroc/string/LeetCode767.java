package github.veikkoroc.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/30 10:50
 */
public class LeetCode767 {
    @Test
    public void test(){
        reorganizeString("aaaabbcddddd");
    }

    public String reorganizeString(String S) {

        char[] chars = S.toCharArray();
        // 计数数组
        int[] nums = new int[26];

        for (char c : chars) {
            nums[c-'a'] += 1;
        }

        System.out.println(Arrays.toString(nums));

        // 找出元素最多的那个字母
        int max = nums[0];
        char maxChar ='a';
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max){
                max = nums[i];
                maxChar = (char) ('a'+i);
            }
        }

        // System.out.println(max);
        // System.out.println(maxChar);

        // 如果最大字母个数>字符串长度+1的一半时，就不能重构
        if ((chars.length+1)>>1 < max ){
            return "";
        }

        char[] res = new char[chars.length];
        int index = 0;
        int temp = max;
        // 把出现次数最多的放在偶数位置
        while (temp>0){
            res[index] = maxChar;
            index += 2;
            temp--;
        }
        System.out.println(Arrays.toString(res));


       // System.out.println(chars.length);
       // System.out.println(max);

        // 把其他元素放入剩余位置
        int index2 = 1;
        int count = chars.length - max;

        int i = 0;

        while (true){




            // 最多的元素不用加，为0个数的元素也不用加
            if (nums[i] > 0 && nums[i] != max){
               // System.out.println("要加的字符符合");

                // 往未加过的位置加
                if (res[index2] == '\u0000'){
                   // System.out.println("该位置可以加");

                    res[index2] = (char)('a'+i);


                    nums[i]--;
                    index2++;
                    count--;

                    if (count == 0){
                        break;
                    }

                    // 如果位置上数据，index2 后移
                }else {
                    index2++;
                }

            }else {
                System.out.println("要加的字符不符合");
                i = (i+1)%26;
            }


        }


         // System.out.println(Arrays.toString(res));

         return new String(res);
    }


    char c;
    @Test
    public void test2(){

        System.out.println(c=='\u0000');
        c = (char)('a'+1);
        System.out.println(c);
    }
}
