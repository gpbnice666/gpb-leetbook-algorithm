package com.bo.day20231121;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: gpb
 * @Date: 2023/11/22 16:56
 * @Description:
 */
public class TwoQueueImplementStacks {
    public static void main (String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.offer(2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println("test begin");
        TwoQueueToStacks<Integer> myStack = new TwoQueueToStacks<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 1000000;
        int max = 1000000;
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty()) {
                if (!test.isEmpty()) {
                    System.out.println("Oops");
                }
                int num = (int) (Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else if (Math.random() < 0.5) {
                    if (!myStack.peek().equals(test.peek())) {
                        System.out.println("Oops");
                    }
                } else if (Math.random() < 0.75) {
                    if (!myStack.poll().equals(test.pop())) {
                        System.out.println("Oops");
                    }
                } else {
                    if (myStack.isEmpty() != test.isEmpty()) {
                        System.out.println("Oops");
                    }
                }
            }
        }

        System.out.println("test finish!");
    }

    public static class TwoQueueToStacks<T> {
        private Queue<T> queue;
        private Queue<T> help;

        public TwoQueueToStacks () {
            this.queue = new LinkedList<>();
            this.help = new LinkedList<>();
        }

        public void push (T data) {
            queue.add(data);
        }

        public T poll () {
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            T ans = queue.poll();
            Queue<T> t = queue;
            // 再把 help中的数据导入添加队列中
            queue = help;
            help = t;
            return ans;
        }

        public T peek () {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            help.offer(ans);
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }


        public boolean isEmpty () {
            return queue.isEmpty();
        }
    }
}