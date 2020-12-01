package github.veikkoroc.algorithm.search.InterpolationSearch;

/**
 *
 * 插值查找算法
 *  神似二分查找，只是将mid使用了一个小算法实现自适应
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/22 19:24
 */
public class InterpolationSearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int search = search(arr, 6, 0, arr.length - 1);
        System.out.println(search);

    }

    /**
     * 递归版插值查找
     *
     * @param arr
     * @param value
     * @param left
     * @param right
     * @return
     */
    public static int search(int[] arr,int value,int left,int right){

        // 递归终止条件
        if (left > right){
            return -1;
        }

        // 每层递归在干嘛
        int mid = left + (right-left)*((value-arr[left])/(arr[right]-arr[left])) ;

        // value在mid右边
        if (arr[mid] < value){

            return search(arr,value,mid+1,right);

        }

        else if (arr[mid] > value){
            return search(arr,value,left,mid-1);
        }

        else {
            return mid;
        }



    }

}
