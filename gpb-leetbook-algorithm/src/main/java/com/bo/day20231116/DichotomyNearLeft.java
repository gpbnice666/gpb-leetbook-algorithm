package com.bo.day20231116;

/**
 * 二分法,找到满足大于等于value最左的位置
 *
 * @Author: gpb
 * @Date: 2023/11/16 16:58
 * @Description:
 */
public class DichotomyNearLeft {
    public static int nearestIndex (int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        int index = -1;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                // 继续二次查找
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static void main (String[] args) {
        int[] arr = {0,1,2,3,3,3,5,5,6,6,6,6,10};
        System.out.println(nearestIndex(arr,3));
        System.out.println(nearestIndex(arr,6));
    }
}
