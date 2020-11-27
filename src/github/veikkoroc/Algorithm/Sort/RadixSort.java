package github.veikkoroc.Algorithm.Sort;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/26 11:13
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        radixSort2(arr);
    }

    private static void radixSort2(int[] arr){

        // 创建一个二维数组，第一维表示桶号0-9（对应个位、十位、百位..的值）第二维表示桶内的元素(最坏情况是所有元素都在一个桶中)
        int[][] bucket = new int[10][arr.length];

        // 辅助数组,存放每个桶内元素个数
        int[] bucketCounts = new int[10];

        // 排序轮数(最大元素的位数)
        int max = arr[0];
        for (int i : arr) {
            if (i>max){
                max = i;
            }
        }

        int sortCounts = (max+"").length();

        for (int i = 0 , n = 1; i < sortCounts; i++,n *= 10) {

            // 进行排序

            for (int j = 0; j < arr.length; j++) {
                // 算出元素对应放哪个桶
                int temp = arr[j] /n % 10;
                // 放入到对应的桶
                bucket[temp][bucketCounts[temp]] = arr[j];
                // 桶中元素个数+1
                bucketCounts[temp] += 1;
            }

//        System.out.println(Arrays.toString(bucketCounts));
//        System.out.println("bucket :");
//        for (int[] ints : bucket) {
//            System.out.println(Arrays.toString(ints));
//        }

            // 把桶中 元素再次赋值给arr
            int index = 0;
            // 遍历桶
            for (int k = 0; k < bucketCounts.length; k++) {
                // 桶中有元素才放入arr
                if (bucketCounts[k] != 0){
                    for (int l = 0; l < bucket[k].length; l++) {
                        if (bucket[k][l] != 0) {
                            arr[index] = bucket[k][l];
                            // 把桶中数组重置为0，防止影响后序排序
                            bucket[k][l] = 0;
                            index++;
                        }
                    }
                }
                // 桶中元素个数也要重置
                bucketCounts[k] = 0;
            }

            System.out.println("第"+(i+1)+"轮排序后"+Arrays.toString(arr));
        }


    }


    /**
     * 推导过程
     *
     * @param arr
     */
    private static void radixSort(int[] arr){

        // 创建一个二维数组，第一个下标表示桶号（对应个位、十位、百位...的值）第二位表示每个桶内的元素
        int[][] bucket = new int[10][arr.length];

        // 辅助数组，存放每个桶内的元素个数(指针)
        int[] help = new int[10];

        // ===================================第一轮排序======================================

        // 把元素放入对应桶中,按个位数排
        for (int i = 0; i < arr.length; i++) {

            // 算出个位数
            int temp = arr[i]%10;

            // 放入对应的桶中
            bucket[temp][help[temp]] = arr[i];

            // 对应桶的元素个数++
            help[temp] = help[temp] + 1;


        }
//        System.out.println("help :");
//        System.out.println(Arrays.toString(help));
//        System.out.println("bucket :");
//        for (int[] ints : bucket) {
//            System.out.println(Arrays.toString(ints));
//        }

        int index = 0;
        // 把第一次排序的结果赋值给 arr
        for (int i = 0; i < help.length; i++) {
            // 桶里有元素才开始放
            if (help[i] != 0){
                // 遍历桶中的数组,把非0元素放入原数组
                for (int j = 0; j < bucket[i].length; j++) {
                    if (bucket[i][j] !=0 ){
                        arr[index] = bucket[i][j];
                        // 桶中元素也要清0,以免影响后面排序
                        bucket[i][j] = 0;
                        index ++;
                    }
                }
            }
            // 桶中元素个数清零
            help[i] = 0;


        }

        System.out.println("第一次排序后:"+Arrays.toString(arr));

        // ===================================第二轮排序======================================

        // 把元素放入对应桶中,按个位数排
        for (int i = 0; i < arr.length; i++) {

            // 算出十位数
            int temp = arr[i]/10%10;

            // 放入对应的桶中
            bucket[temp][help[temp]] = arr[i];

            // 对应桶的元素个数++
            help[temp] = help[temp] + 1;


        }

        index = 0;
        // 把第一次排序的结果赋值给 arr
        for (int i = 0; i < help.length; i++) {
            // 桶里有元素才开始放
            if (help[i] != 0){
                // 遍历桶中的数组,把非0元素放入原数组
                for (int j = 0; j < bucket[i].length; j++) {
                    if (bucket[i][j] !=0 ){
                        arr[index] = bucket[i][j];
                        // 桶中元素也要清0,以免影响后面排序
                        bucket[i][j] = 0;
                        index ++;
                    }
                }
            }
            // 桶中元素个数清零
            help[i] = 0;


        }

        System.out.println("第二次排序后:"+Arrays.toString(arr));

        // ===================================第三轮排序======================================

        // 把元素放入对应桶中,按个位数排
        for (int i = 0; i < arr.length; i++) {

            // 算出十位数
            int temp = arr[i]/100%10;

            // 放入对应的桶中
            bucket[temp][help[temp]] = arr[i];

            // 对应桶的元素个数++
            help[temp] = help[temp] + 1;


        }

        index = 0;
        // 把第一次排序的结果赋值给 arr
        for (int i = 0; i < help.length; i++) {
            // 桶里有元素才开始放
            if (help[i] != 0){
                // 遍历桶中的数组,把非0元素放入原数组
                for (int j = 0; j < bucket[i].length; j++) {
                    if (bucket[i][j] !=0 ){
                        arr[index] = bucket[i][j];
                        // 桶中元素也要清0,以免影响后面排序
                        bucket[i][j] = 0;
                        index ++;
                    }
                }
            }
            // 桶中元素个数清零
            help[i] = 0;


        }

        System.out.println("第三次排序后:"+Arrays.toString(arr));


    }

}
