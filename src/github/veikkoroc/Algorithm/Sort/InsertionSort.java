package github.veikkoroc.Algorithm.Sort;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/20 14:18
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {100,97,56,150};
        //sort(arr);
        int numbers[] = {4,1,32,56,28,67,12,78,23,0};
        sortPlus(numbers);
    }
    public static void sortPlus(int[] arr){
        // 遍历无序表
        for (int i = 1; i < arr.length; i++) {
            // 待插入的数
            int insertV = arr[i];
            // 待插入的数的前一个数的索引
            int beforeIndex = i-1;
            // 待插入的数的前面的数 > insertV时，说明还未找到适当位置
            while (beforeIndex >=0 && insertV < arr[beforeIndex]){//改变排序顺序只需要改成 insertV>arr[beforeIndex] 即可
                // beforeIndex对应的值后移
                arr[beforeIndex+1] = arr[beforeIndex];
                //继续和前面的数比较
                beforeIndex--;
            }
            //跳出循环，找到了适当位置
            arr[beforeIndex+1] = insertV;
        }
        System.out.println(Arrays.toString(arr));

    }



    public static void sort(int[] arr){
        // 第一轮：{100,97,  56,150}===》{97,100,  56,150}
        //有序列表：{100}===>{97,100}
        //待插入的数
        int insertVal = arr[1];//第二个元素开始
        //插入的位置
        int insertIndex = 1-1;//前面一个数的下标

        //还没找到位置的情况
        while(insertIndex>=0&& insertVal < arr[insertIndex]) {
            //前面一个数就要后移一位
            arr[insertIndex +1] =arr[insertIndex];
            //继续和前面的数比较
            insertIndex--;
        }
        //退出循环说明找到位置了
        arr[insertIndex+1] = insertVal;

        //第二轮：{97,100,  56,150}===》{97,56,  100,150}===》{  56,97,100,150}

        //待插入的数
        int insertVal1 = arr[2];
        //待插入的位置
        int indexIndex1 = 2-1;
        //还没找到位置的情况
        while (indexIndex1 >=0&&arr[indexIndex1]>insertVal1){
            //前面的数后移一位
            arr[indexIndex1+1] = arr[indexIndex1];
            indexIndex1--;
        }
        //退出循环说明找到了
        arr[indexIndex1+1] = insertVal1;


        System.out.println(Arrays.toString(arr));
    }
}
