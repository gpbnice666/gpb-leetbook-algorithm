package com.bo.day20231117;

import java.util.Arrays;

/**
 * 题解：
 * 根据^操作结论：一
 * 0^任何数=数本身
 * 相同数^相同数=0
 * 一组数都是^,最终结果都是一样的
 *
 * @Author: gpb
 * @Date: 2023/11/20 11:05
 * @Description:
 */
public class ArrayOddNumber {
    /**
     * 题目：一个数组中有一种数出现了奇数次，其他数都出现了偶数次,怎么找到并打印这种数
     *
     * @param arr
     * @return
     */
    public static int printOddNumber (int[] arr) {
        int ans = 0;
        for (int i : arr) {
            ans ^= i;
        }
        return ans;
    }

    /**
     * 题目：一个数组中有两种数出现了奇数次，其他数都出现了偶数次,怎么找到并打印这种数
     * 题解：首先找到这两个奇数^的结果 a^b=eor,
     * 找eor的最右边的位置, n = eor&(~eor+1)
     * 再找出数组最右边为1位置==n,找出a,或者b
     *
     * @param arr
     * @return
     */
    public static int[] printOddNumber2 (int[] arr) {
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        int n = eor & (~eor + 1);
        int eor2 = 0;
        for (int i : arr) {
            if ((i & (~i + 1)) == n) {
                eor2 ^= i;
            }
        }
        return new int[]{eor ^ eor2, eor2};
    }

    public static void main (String[] args) {
        int[] arr1 = {3, 3, 1, 21, 23, 23, 2, 1, 21, 21, 21};
        System.out.println(printOddNumber(arr1));
        int[] arr2 = {3, 3, 1, 21, 23, 23, 2, 1, 21, 21, 21, 91, 32, 91, 32, 33, 91, 33};
        System.out.println(Arrays.toString(printOddNumber2(arr2)));
    }
}
