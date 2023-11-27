package com.bo.datastructure;

/**
 * 链表以节点为单位，每个元素都是一个独立对象，在内存空间的存储是非连续的
 * 链表的节点对象具有两个成员变量
 * [值 val],[后续节点引用 next]
 *
 * @Author: gpb
 * @Date: 2023/7/28 10:31
 * @Description:
 */
public class ListNodeDemo {

    int val;

    ListNodeDemo next;

    public static void main (String[] args) {
        // 实例化节点
        ListNodeDemo n1 = new ListNodeDemo();
        n1.val = 4;
        ListNodeDemo n2 = new ListNodeDemo();
        n2.val = 5;
        ListNodeDemo n3 = new ListNodeDemo();
        n3.val = 1;

        // 构建引用只想
        n1.next = n2;
        n2.next = n3;
    }

}
