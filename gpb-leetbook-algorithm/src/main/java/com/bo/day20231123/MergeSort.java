package com.bo.day20231123;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @Author: gpb
 * @Date: 2023/11/23 17:01
 * @Description:
 */
public class MergeSort {
    public static void main (String[] args) {
        int[] arr1 = {2, 3, 9, 1, 7, 5};
        sort(arr1);
        System.out.println("递归版归并排序：" + Arrays.toString(arr1));
        int[] arr2 = {2, 3, 9, 1, 7, 5};
        sortWhile(arr2);
        System.out.println("循环版归并排序：" + Arrays.toString(arr2));
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] testArr1 = generateRandomArray(maxSize, maxValue);
            int[] testArr2 = copyArray(testArr1);
            sort(testArr1);
            sortWhile(testArr2);
            if (!isEqual(testArr1, testArr2)) {
                System.out.println("出错了！");
                System.out.println(Arrays.toString(testArr1));
                System.out.println(Arrays.toString(testArr2));
                break;
            }
        }
        System.out.println("测试结束");
    }

    /**
     * 非递归版本归并排序
     *
     * @param arr
     */
    public static void sortWhile (int[] arr) {
        if (arr == null || arr.length <= 2) {
            return;
        }
        int n = arr.length - 1;
        // 步长
        int sizeMerge = 1;
        while (sizeMerge <= n) {
            // 左部分数组下标第一个位置
            int l = 0;
            while (l <= n) {
                // 求中点位置,mid
                // 为什么要-1呢？
                // 因为：数组下标 0,1,2,3,4,5,6,7,8,9,10,11,12
                // 如果步长为4的话不减-1情况下, mid=l + sizeMerge = 0+4 = 4, r=mid+sizeMerge=4+4=8
                // 就会分成  l=[0,1,2,3,4] r=[4,5,6,7,8]
                // l,r就会多算一个数,l应该是[0,1,2,3],r应该是[4,5,6,7]
                int mid = l + sizeMerge - 1;
                // 如果中点位置大于n数组长度就结束了,这种情况就是没有了右部分了
                if (mid >= n) {
                    break;
                }
                // 求右边结束的位置,中点位置+步长和数组长度那个小取那个,防止越界
                int r = Math.min((mid + sizeMerge), n);
                // 开始合并
                merge(arr, l, mid, r);
                // 左边=右边+1的位置,向右边移动
                l = r + 1;
            }
            // 防止int类型越界
            if (sizeMerge > n / 2) {
                return;
            }
            // 每次都乘2,sizeMerge*=2;
            sizeMerge = sizeMerge << 1;
        }
    }

    /**
     * 归并排序
     *
     * @param arr
     */
    public static void sort (int[] arr) {
        if (arr == null || arr.length <= 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * 排序方法
     *
     * @param arr
     * @param begin
     * @param end
     */
    public static void process (int[] arr, int begin, int end) {
        if (begin == end) {
            return;
        }
        // 求中点
        int mid = begin + ((end - begin) >> 1);
        // 左半部分递归先有序
        process(arr, begin, mid);
        // 右半部分有序
        process(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }

    /**
     * 合并排序
     *
     * @param arr
     * @param begin 左
     * @param mid   中点
     * @param end   右
     */
    private static void merge (int[] arr, int begin, int mid, int end) {
        // 创建辅助数组
        int[] help = new int[end - begin + 1];
        // 辅助数组的下标
        int i = 0;
        // 左部分开始下标
        int p1 = begin;
        //  右部分开始下标
        int p2 = mid + 1;
        // 对于左部分的终点位置就是mid中间位置
        // 对于右部分的终点位置就end文职
        while (p1 <= mid && p2 <= end) {
            // p1,p2指针只会移动一个
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 要么左部分有剩余的
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        // 要么左部分有剩余的
        while (p2 <= end) {
            help[i++] = arr[p2++];
        }
        // 排序好的数组,回填
        /*
         *  因为排序只是对arr中的区间排序,所以需要从开始位置恢复数组
         *  所以begin+i1的位置
         *  arr = [...6,9,3,2,5,1...]
         *  数组下标 ...5,6,7,8,9,10
         *  help = [1,2,3,5,6,9]
         *  数组下标  0,1,2,3,4,5
         *  begin = 5,end=10
         *  arr[begin + i]= arr[5+0]=arr[5] 依次类推,使arr数组区间进行有序
         * */
        for (int i1 = 0; i1 < help.length; i1++) {
            arr[begin + i1] = help[i1];
        }
    }


    // for test
    public static int[] generateRandomArray (int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray (int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual (int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray (int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
