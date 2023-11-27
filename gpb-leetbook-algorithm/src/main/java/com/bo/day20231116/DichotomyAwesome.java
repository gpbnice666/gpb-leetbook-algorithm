package com.bo.day20231116;

import java.util.Arrays;

/**
 * 二分查找区域最小
 *
 * @Author: gpb
 * @Date: 2023/11/17 10:13
 * @Description:
 */
public class DichotomyAwesome {

    public static int getLessIndex (int arr[]) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        // 为啥 L 不是从0的位置开始,应为0的为位置已经验证过了,不需要在进行验证
        int L = 1;
        // 同理 R 也不需要从 arr.length -1 的位置开始
        int R = arr.length - 2;
        int mid = 0;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                // 如果mid 大于 左边的数字, 说明从0位置到mid位置存在局部最小
                // R 需要往左边移动
                if (arr[mid] > arr[mid - 1]) {
                    R = mid - 1;
                } else {
                    // 如果mid 小于右边的数字,说明mid到arr.length -1 位置存在最小
                    // L 需要往右边移动
                    L = mid + 1;
                }
            }
/*
             // 老师版本
            // 如果mid 大于 左边的数字, 说明从0位置到mid位置存在局部最小
            // R 需要往左边移动
            if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            }
            // 如果mid 大于右边的数字,说明mid到arr.length -1 位置存在最小
            // L 需要往右边移动
            else if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            }else {
                // 如果mid 既不大于右边的数,有不大于左边的数
                // 说明他就是局部最小
                return mid;
            }

 */
        }
        return L;
    }

    // 验证得到的结果，是不是局部最小
    public static boolean isRight (int[] arr, int index) {
        if (arr.length <= 1) {
            return true;
        }
        if (index == 0) {
            return arr[index] < arr[index + 1];
        }
        if (index == arr.length - 1) {
            return arr[index] < arr[index - 1];
        }
        return arr[index] < arr[index - 1] && arr[index] < arr[index + 1];
    }

    // 为了测试
    // 生成相邻不相等的数组
    public static int[] generateRandomArray (int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        arr[0] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        for (int i = 1; i < arr.length; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
            } while (arr[i] == arr[i - 1]);
        }
        return arr;
    }

    // 为了测试
    public static void main (String[] args) {
/*        测试开始
        arr: [-11, -64, 14, 5, -17, -21, -4, 68, 53, -10, 0, -9, -47, -16]
        ans: 7
        出错了！
        测试结束
        int arr[] = {-11, -64, 14, 5, -17, -21, -4, 68, 53, -10, 0, -9, -47, -16};
        int ans = getLessIndex(arr);
        System.out.println(ans);
        if (!isRight(arr, ans)) {
            System.out.println("出错了！");
        }*/
        int testTime = 1000000;
        int maxSize = 30;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int ans = getLessIndex(arr);
            if (!isRight(arr, ans)) {
                System.out.println("arr: " + Arrays.toString(arr));
                System.out.println("ans: " + ans);
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束");
    }

}

