package github.veikkoroc.DataStructure.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * 1. 合并时间区间（建议时间复杂度 O(n) ）
 * 给定⼀一个按开始时间从⼩小到⼤大排序的时间区间集合，请将重叠的区间合并。时
 * 间区间集合⽤用⼀一个⼆二维数组表示，⼆二维数组的每⼀一⾏行行表示⼀一个时间区间（闭区
 * 间），其中 0 位置元素表示时间区间开始，1 位置元素表示时间区间结束。
 *
 * 例例 1：输⼊入：[ [1, 3], [2, 6], [8, 10], [15, 18] ]
 * 返回： [ [1, 6], [8, 10], [15, 18]]
 * 解释：时间区间 [1, 3] 和 [2, 6] 有部分重叠，合并之后为 [1, 6]
 *
 * 例例 2：输⼊入：[[1, 4], [4, 5]]
 * 返回：[[1, 5]]
 * 解释：时间区间[1，4] 和 [4，5]重叠了了⼀一个时间点，合并之后为 [1，5]
 *
 * 需要实现的⽅方法原型：int[][] merge(int[][] intervals)
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/26 6:02
 */
public class DaXi01 {
    public static void main(String[] args) {
        int[][] arr1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] arr2 = {{1,4},{4,5}};

        int[][] merge = merge(arr2);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }

    }
    public static int[][] merge(int[][] intervals){

        //借助HashMap暂时存放结果
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            //遍历得到每个内置数组，如果有重合部分就合并
            if (i<intervals.length-1 && intervals[i][1] >= intervals[i+1][0] ) {
                map.put(intervals[i][0],intervals[i+1][1]);
                i++;
            }else {
                map.put(intervals[i][0],intervals[i][1]);
            }
        }
        //遍历map
        Set<Integer> keys = map.keySet();
        Iterator<Integer> iterator = keys.iterator();
        //存放结果的数组
        int[][] res = new int[map.size()][2];
        //辅助指针
        int i = 0;

        while (iterator.hasNext()){
            Integer key = iterator.next();
            System.out.println("key:"+key+" value:"+map.get(key));
            res[i][0] = key ;
            res[i][1] = map.get(key);
            i++;
        }

        return res;
    }
}
