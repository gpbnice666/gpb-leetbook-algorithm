package com.bo.day20231121;

/**
 * 递归演示获取数组中最大的数字
 *
 * @Author: gpb
 * @Date: 2023/11/23 14:21
 * @Description:
 */
public class GetMax {
    public static void main (String[] args) {
        System.out.println(3/2);
        System.out.println(1/2);
        int[] arr = {6, 2, 7, 9};
        System.out.println(process(arr, 0, arr.length - 1));
    }

    public static int process (int[] arr, int begin, int end) {
        // 终止条件,arr[L..R]范围上只有一个数，直接返回，base case
        if (begin == end) {
            return arr[begin];
        }
        // 取中间点
        int mid = begin + ((end - begin) >> 1);
        // 数组区间左边最大的数字
        int leftMax = process(arr, begin, mid);
        // 数组区间右边最大数字
        int rightMax = process(arr, mid + 1, end);
        return Math.max(leftMax, rightMax);
    }
}
