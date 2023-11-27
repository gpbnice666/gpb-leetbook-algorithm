package com.bo.day20231123;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * 小和问题
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。
 * 比如：arr=[6,3,1,5,0,9,6,8,2]
 * 6：左边数小于6为 没有
 * 3：左边数小于3为 没有
 * 1：左边数小于1为 没有
 * 5：左边数小于5为3,1
 * 0：左边数小于0为 没有
 * 9：左边数小于9为6,3,1,5,0
 * 6：左边数小于6为3，1，5，0
 * 8：左边数小于8为6，3，1，5，0，6
 * 2：左边数小于2为1，0
 * 小和=3+1+6+3+1+5+0+3+1+5+0+6+3+1+5+0+6+1+0=50
 * 图解
 * https://cloud.fynote.com/edit?nid=376175&id=1700812234097&t=1700818139889
 *
 * @Author: gpb
 * @Date: 2023/11/24 14:03
 * @Description:
 */
public class SmallSum {
    public static void main (String[] args) {
//        System.out.println(3 + 1 + 6 + 3 + 1 + 5 + 0 + 3 + 1 + 5 + 0 + 6 + 3 + 1 + 5 + 0 + 6 + 1 + 0);
//        System.out.println(4 * 0 + 4 * 1 + 3 * 3 + 3 * 5 + 2 * 6);
     //   int[] arr = {6, 3, 1, 5, 0, 9, 6, 8, 2};
   //     System.out.println(arr.length);
//        System.out.println(smallSum(arr));
//        int[] arr = {1, 3, 6, 0, 5};
//        System.out.println(merge(arr, 0, 2, 4));
//        System.out.println(Arrays.toString(arr));
    }
    /*
     * 解题思路：
     * arr=[6,3,1,5,0,9,6,8,2] 通过归并进行求解
     * 下标  0,1,2,3,4,5,6,7,8
     * 1) mid = 4,l=0,r=mid-1=3,范围：0,1,2,3
     *  6,3 不存在小和 1,5 存在小和 1
     *  [3,6]   [1,5] 计算小和
     *  比如说 左数组中的数和右数组进行比较,
     *   如果右数组的数据大于左数组存在小和
     *   存在几个左边指针上数：r(右边终点位置)-p2(右边移动指针的位置)*当前左边移动指针位置的数
     *  依次类推
     *
     * */

    /**
     * 小和问题
     *
     * @param arr
     * @return
     */
    public static int smallSum (int[] arr) {
        if (arr == null) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process (int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        // 中点位置
        int mid = l + ((r - l) >> 1);
        // 左部分 + 右边部分 + 合并
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    // arr=[0,1,3,5,6,2,6,8,9],l=0,m=4,r=8
    // 下标= 0,1,2,3,4,5,6,7,8
    // l数组范围：lArr=[0,1,3,5,6]
    // r数组范围：rArr=[2,6,8,9]
    // p1=l=0,p2=mid+1=4+1=5
    // 如果计算左数组中数需要累计多次，使用r(右边终点位置)-p2(右边移动指针的位置)*当前左边移动指针位置的数，会少算一个
    // 比如 lArr[1]数字应该累计多次：(8-5)*1=3,但是实际右数组所以数都大于1,少计算了以为,这样是使用下标来计算，应该使用右数组的长度计算需要加上一个1
    // (使用r(右边终点位置)-p2(右边移动指针的位置)+1)*当前左边移动指针位置的数 (8-5+1)*1=4
    public static int merge (int[] arr, int l, int mid, int r) {
        // 辅助数组
        int[] help = new int[r - l + 1];
        // 辅助数组的下标
        int i = 0;
        // 左部分数组的下标
        int p1 = l;
        // 右部分数组的下标
        int p2 = mid + 1;
        // 小和的值
        int ans = 0;
        while (p1 <= mid && p2 <= r) {
            // 存在几个左边指针上数：r(右边终点位置)-p2(右边移动指针的位置)*当前左边移动指针位置的数
            // 左数组和右边数组的数字进行比较
            ans += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int i1 = 0; i1 < help.length; i1++) {
            arr[l + i1] = help[i1];
        }
        return ans;
    }
}
