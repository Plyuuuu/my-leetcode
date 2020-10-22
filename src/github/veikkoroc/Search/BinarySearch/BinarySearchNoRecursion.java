package github.veikkoroc.Search.BinarySearch;

import org.junit.Test;

import java.util.ArrayList;

/**
 *
 * 非递归的二分查找
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/22 14:07
 */
public class BinarySearchNoRecursion {
    @Test
    public void testSearch(){
        int[] arr = {1,2,3,3,3,4};
        ArrayList<Integer> search = search(arr, 3, 0, arr.length - 1);
        System.out.println(search.toString());
    }

    public ArrayList<Integer> search(int[] arr,int value,int left,int right){

        // 辅助指针
        int leftTemp = left;
        int rightTemp = right;

        // 中间值
        int mid = (leftTemp+rightTemp)/2;

        // 结果集合
        ArrayList<Integer> res = new ArrayList<>();

        while (true){

            // 边界条件
            if (leftTemp > rightTemp ){
                return new ArrayList<>();
            }

            // value > 中值
            if (value > arr[mid]){
                leftTemp = mid+1;
                mid = (leftTemp + rightTemp)/2;
                continue;
            }else if (value < arr[mid]){
                rightTemp = mid -1;
                mid = (leftTemp + rightTemp)/2;
                continue;

                // 找到了，看看周围还有没有
            }else if (value == arr[mid]){

                res.add(mid);

                // 看看左边还有没有
                int tempL = mid -1;
                while (true){
                    if (arr[tempL] == value){
                        res.add(tempL);
                        tempL = tempL-1;
                    }else {
                        break;
                    }
                }

                // 看看右边还有没有
                int tempR = mid +1;
                while (true){
                    if (arr[tempR] == value){
                        res.add(tempR);
                        tempR = tempR+1;
                    }else {
                        break;
                    }
                }

                return res;
            }

        }


    }

}
