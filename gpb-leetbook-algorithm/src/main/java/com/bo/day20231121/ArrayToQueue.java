package com.bo.day20231121;

/**
 * 数组实现队列
 *
 * @Author: gpb
 * @Date: 2023/11/22 15:33
 * @Description:
 */
public class ArrayToQueue {

    public static void main (String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        System.out.println("==>队列中添加数据");
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("==>队列中弹出数据");
        System.out.println(queue.pop());
        queue.push(8);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(23);
        queue.push(21);
        queue.push(78);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    public static class ArrayQueue {
        private int[] arr;
        // 记录队列弹出的位置
        private int begin;
        // 记录队列添加的位置
        private int end;
        // 队列的元素多少个
        private int size;
        // 大小
        private int limit;

        public ArrayQueue (int limit) {
            this.arr = new int[limit];
            this.begin = 0;
            this.end = 0;
            this.size = 0;
            this.limit = limit;
        }

        public void push (int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了~~~");
            }
            arr[end++] = value;
            if (end >= limit) {
                end = 0;
            }
            size++;
        }

        public int pop () {
            if (isEmpty()) {
                throw new RuntimeException("队列空了~~~");
            }
            int ans = arr[begin++];
            if (begin >= limit) {
                begin = 0;
            }
            size--;
            return ans;
        }

        public boolean isEmpty () {
            return size == 0;
        }
    }
}
