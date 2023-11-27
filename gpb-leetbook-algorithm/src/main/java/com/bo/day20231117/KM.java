package com.bo.day20231117;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: gpb
 * @Date: 2023/11/20 16:28
 * @Description:
 */
public class KM {

    /**
     * 在一组数组中,有一个数出现了K次,其余的数出现了M次,请你找出出现K次的数
     * 题解：
     * 00000000……00003;32位的数组,比如0位置中数组3次1进行记录
     * 来进出存储每个数的二进制1在i出现的次数;
     * 遍历二进制数组i判断i%m!=0,说明这个位置肯定有要找的出现K次的数
     * 如果i%m==0,说明没有出现K次的数
     * 把1<<i,进行左移i次,进行恢复
     *
     * @param arr
     * @param K
     * @param M
     * @return
     */
    public static int onlyKTimes (int[] arr, int K, int M) {
        int[] t = new int[32];
        for (int i : arr) {
            for (int i1 = 0; i1 <= 31; i1++) {
                if (((i >> i1) & 1) != 0) {
                    t[i1] += 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= 31; i++) {
            if (t[i] % M != 0) {
                // 1 << i 进行复原K次出现的数字
                // | 类似进行相加
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static int test (int[] arr, int K, int M) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
                continue;
            }
            map.put(i, 1);
        }
        for (int i : arr) {
            if (map.get(i) == K) {
                return i;
            }
        }
        return -1;
    }

    public static void main (String[] args) {
//        int arr[] = {1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 5, 5, 5, 5};
//        System.out.println(onlyKTimes(arr, 3, 4));
        int kinds = 30;
        int range = 30;
        int testTime = 100000;
        int max = 9;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * max) + 1; // a 1 ~ 9
            int b = (int) (Math.random() * max) + 1; // b 1 ~ 9
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            // k < m
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kinds, range, k, m);
            int ans1 = test(arr, k, m);
            int ans2 = onlyKTimes(arr, k, m);
            if (ans1 != ans2) {
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println(arr);
                System.out.println("出错了！");
            }
        }
        System.out.println("测试结束");
    }

    public static int[] randomArray (int maxKinds, int range, int k, int m) {
        int ktimeNum = randomNumber(range);
        // 数组中可以存储几种数,+2 必须保证存在两种数字
        int numKinds = (int) (Math.random() * maxKinds) + 2;
        // k * 1 + (numKinds - 1) * m
        int[] arr = new int[k + (numKinds - 1) * m];
        int index = 0;
        for (; index < k; index++) {
            arr[index] = ktimeNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(ktimeNum);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        // arr 填好了
        for (int i = 0; i < arr.length; i++) {
            // i 位置的数，我想随机和j位置的数做交换
            int j = (int) (Math.random() * arr.length);// 0 ~ N-1
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }

    // 为了测试
    // [-range, +range]
    public static int randomNumber (int range) {
        return (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
    }
}
