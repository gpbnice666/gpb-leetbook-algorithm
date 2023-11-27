package com.bo.day20231121;

/**
 * 链表删除指定元素
 *
 * @Author: gpb
 * @Date: 2023/11/21 15:21
 * @Description:
 */
public class DeleteGivenValue {
    public static class Node {
        public int value;
        public Node next;

        public Node (int data) {
            this.value = data;
        }
    }

    /**
     * 删除链表中为num的所以元素
     *
     * @param head
     * @param num
     * @return
     */
    public static Node removeValue (Node head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        // 进行记录  head下一个节点
        /*
         * pre：用于链接不等num节点
         * cur：进行下一个节点的遍历
         * 不能使用head进行遍历,使用head遍历就会返回一个空
         * 也不能返回pre,因为此时的pre是指向最后一个不等于num的元素
         * pre,head,cur 都是指向内存同一个链表,只要一个断了其他的也会断
         *
         * */
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main (String[] args) {
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(3);
        Node a4 = new Node(2);
        Node a5 = new Node(2);
        Node a6 = new Node(5);
        Node a7 = new Node(8);
        Node a8 = new Node(2);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a7.next = a8;
        System.out.println("======>>初始化链表");
        printList(a1);
        System.out.println("======>>开始验证断开链表");
        System.out.println("======>>验证断开链表-->原始链表");
        printList(a1);
        System.out.println("======>>验证断开链表-->断开后链表");
        Node checkNode = a1;
        checkNode.next.next = null;
        printList(a1);
        System.out.println("======>>结束验证断开链表");
        System.out.println("======>>删除链表为2元素");
        printList(removeValue(a1, 2));
    }

    public static void printList (Node head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }


}
