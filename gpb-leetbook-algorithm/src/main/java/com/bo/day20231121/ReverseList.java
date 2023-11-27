package com.bo.day20231121;

import java.util.ArrayList;

/**
 * 链表反转
 *
 * @Author: gpb
 * @Date: 2023/11/21 14:22
 * @Description:
 */
public class ReverseList {

    public static class Node {
        public int value;
        public Node next;

        public Node (int data) {
            value = data;
        }
    }

    public static Node reverseList (Node head) {
        // 记录head节点
        Node pre = null;
        // 记录下一个节点引用
        Node next = null;
        while (head != null) {
            // 进行记录  head下一个节点
            next = head.next;
            // 把 head.next 指向pre 上一个节点
            head.next = pre;
            // 记录 next 上一个节点位置
            pre = head;
            // head 继续只想下一个
            head = next;
        }
        return pre;
    }


    public static class DoubleNode {
        public int value;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode (int data) {
            this.value = data;
        }
    }

    public static DoubleNode reverseDoubleNode (DoubleNode head) {
        // 和单链表反转思想一样
        // 记录head节点
        DoubleNode pre = null;
        // 记录head.next节点位置
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            // head后指针只想pre节点
            head.next = pre;
            // 前指针只想next
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

}
