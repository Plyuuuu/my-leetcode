package github.veikkoroc.Competition.LeetCode.shangtang216;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * LeetCode1663
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/22 10:54
 */
public class T2 {

    public String getSmallestString(int n, int k) {

        Map<Integer,Character> map = new HashMap<>();
        for (int i = 1; i < 27; i++) {
            map.put(i,(char)(i+96));
        }


        return null;
    }
    @Test
    public void test(){
        System.out.println('a'+1);// 'a' = 97
        Map<Integer,Character> map = new HashMap<>();
        for (int i = 1; i < 27; i++) {
            map.put(i,(char)(i+96));
        }
        System.out.println(map);
    }
}
