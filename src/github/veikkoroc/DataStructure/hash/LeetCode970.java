package github.veikkoroc.DataStructure.hash;

import java.util.*;

/**
 *
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/24 13:26
 */
public class LeetCode970 {

    public static void main(String[] args) {
        //System.out.println(Math.pow(2,20));
        List<Integer> list = powerfulIntegers(2, 1, 10);
        System.out.println(list);

    }
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        //强整数最小为2
        if (bound<2){
            return new ArrayList<Integer>();
        }


        //存放结果

        Set<Integer> res = new HashSet<>();

        //暴力法
        for (int i = 0;i<=20 && Math.pow(x,i)<bound;i++){
            for (int j = 0;j<=20 && Math.pow(y,j)<bound;j++){
                int v = (int)(Math.pow(x,i))+ (int)(Math.pow(y,j));
                if (v<=bound){
                    res.add(v);
                }
            }
        }


        return new ArrayList<>(res);
    }

}

