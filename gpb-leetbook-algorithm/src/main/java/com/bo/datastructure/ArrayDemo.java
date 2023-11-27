package com.bo.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组
 * 数组是将相同类型的元素存储于连续内存空间的数据结构，其长度不可变
 * @Author: gpb
 * @Date: 2023/7/28 10:23
 * @Description:
 */
public class ArrayDemo {
    public static void main (String[] args) {
        int[] array = new int[5];
        array[0] = 2;
        array[1] = 3;
        array[2] = 1;
        array[3] = 0;
        array[4] = 2;
        /*
        *  直接赋值方式初始化
        * */
        int[] initArray = {2,3,1,0,2};

        /*
        *
        * [可变数组]是经常使用的数据结构，其基于数组和扩容机制实现，相比普通数组更加灵活
        * 常用操作有：访问元素，添加元素，删除元素
        *
        * */

        List<Integer> arrayList = new ArrayList<>();

        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(2);
    }
}
