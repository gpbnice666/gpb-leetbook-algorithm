package com.bo.day20231116;

/**
 * 简单二分查找
 *
 * @Author: gpb
 * @Date: 2023/11/16 16:18
 * @Description:
 */
public class DichotomyFindExist {

    /**
     * 在有序数组判断一个数是否存在,二分查找法
     * @param sortedArr
     * @param num
     * @return
     */
    public static boolean exist (int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        // 二分左边起点
        int L = 0;
        // 二分右边起点
        int R = sortedArr.length - 1;
        // 中间位置
        int mid = 0;
        while (L <= R) {
            // 等同于 mid = (R + L) /2, >> 1 运算等于 除于2
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            }
            /*
             * 如果中间位置的数 大于 num 说明需要往左边找了，左边一定小于num
             *
             * L   mid   R
             * 大于情况下
             * L  R
             * 小于情况下
             *        L  R
             * */
            if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return false;
    }

    public static void main (String[] args) {
        int[] arr = {0,1,2,3,4,5,5,6,7,8,9,10,11,12,13,15,16};
        System.out.println(exist(arr,10));
        System.out.println(exist(arr,14));
    }

}
