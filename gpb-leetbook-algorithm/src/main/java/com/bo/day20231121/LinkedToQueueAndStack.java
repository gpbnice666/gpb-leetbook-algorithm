package com.bo.day20231121;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 链表实现队列和栈
 *
 * @Author: gpb
 * @Date: 2023/11/22 14:09
 * @Description:
 */
public class LinkedToQueueAndStack {
    public static void main (String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        System.out.println("====>>queue添加元素");
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println("====>>queue弹出元素");
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());

        MyStack<Integer> myStack = new MyStack<>();
        System.out.println("====>>stack添加元素");
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println("====>>stack弹出元素");
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());

        System.out.println("====>>程序开始测试");
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStackT = new MyStack<>();
            MyQueue<Integer> myQueueT = new MyQueue<>();
            Stack<Integer> stack = new Stack<>();
            java.util.Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStackT.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStackT.push(nums);
                        stack.push(nums);
                    } else {
                        if (!isEqual(myStackT.poll(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }
                int numq = (int) (Math.random() * value);
                if (queue.isEmpty()) {
                    myQueueT.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueueT.push(numq);
                        queue.offer(numq);
                    } else {
                        if (!isEqual(myQueueT.poll(), queue.poll())) {
                            System.out.println("oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }


    public static boolean isEqual (Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }

    public static class Node<T> {
        public T value;
        public Node<T> pre;
        public Node<T> next;

        public Node (T data) {
            value = data;
        }
    }

    /**
     * 队列
     *
     * @param <T>
     */
    public static class MyQueue<T> {
        private Queue<T> queue;

        public MyQueue () {
            queue = new Queue<>();
        }

        public void push (T value) {
            queue.addFromHead(value);
        }

        public T poll () {
            return queue.popFromTail();
        }

        public boolean isEmpty () {
            return queue.isEmpty();
        }
    }

    /**
     * 栈：先进后出,后进先出
     *
     * @param <T>
     */
    public static class MyStack<T> {
        private Queue<T> queue;

        public MyStack () {
            queue = new Queue<>();
        }

        public void push (T value) {
            queue.addFromHead(value);
        }

        public T poll () {
            return queue.popFromHead();
        }

        public boolean isEmpty () {
            return queue.isEmpty();
        }
    }

    /**
     * 队列:先进先出,后进后出
     *
     * @param <T>
     */
    public static class Queue<T> {
        /**
         * 头
         */
        public Node<T> head;

        /**
         * 尾巴
         */
        public Node<T> tail;

        /**
         * 从头部开始加元素
         *
         * @param value
         */
        public void addFromHead (T value) {
            Node<T> node = new Node<>(value);
            // 如果head等于null,说明队列没有元素
            if (head == null) {
                // 第一个元素即时头,也是尾
                head = node;
                tail = node;
            } else {
                // 新添加的元素为头部,此时的头部为第二个元素
                node.next = head;
                head.pre = node;
                // 头部指向新添加的元素
                head = node;
            }
        }

        /**
         * 头弹出元素
         *
         * @return
         */
        public T popFromHead () {
            if (head == null) {
                return null;
            }
            Node<T> cur = head;
            if (head == tail) {
                // 如果头尾相等说明是最后一个元素
                // 需要吧头尾值空
                head = null;
                tail = null;
            } else {
                // 重新定义头部
                head = head.next;
                // 移除的元素断开连接
                cur.next = null;
                head.pre = null;
            }
            return cur.value;
        }

        /**
         * 从尾部开始加元素
         *
         * @param value
         */
        public void addFromTail (T value) {
            Node<T> node = new Node<>(value);
            // 如果head等于null,说明队列没有元素
            if (head == null) {
                // 第一个元素即时头,也是尾
                head = node;
                tail = node;
            } else {
                // 新添加的元素为尾部,此时的尾巴第二个元素
                node.pre = tail;
                tail.next = node;
                // 尾部指向新添加的元素
                tail = node;
            }
        }

        /**
         * 头弹出元素
         *
         * @return
         */
        public T popFromTail () {
            if (tail == null) {
                return null;
            }
            Node<T> cur = tail;
            if (head == tail) {
                // 如果头尾相等说明是最后一个元素
                // 需要吧头尾值空
                head = null;
                tail = null;
            } else {
                // 重新定义头部
                tail = tail.pre;
                // 移除的元素断开连接
                cur.pre = null;
                tail.next = null;
            }
            return cur.value;
        }

        public Boolean isEmpty () {
            return head == null;
        }
    }
}
