package com.bo.day20231121;

import java.util.Stack;

/**
 * @Author: gpb
 * @Date: 2023/11/22 16:12
 * @Description:
 */
public class GetMinStack {
    public static void main (String[] args) {
/*
        // peek不会把元素弹出,pop会把元素弹出
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
*/
        System.out.println("=============");

        MinStack minStack = new MinStack();
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.push(4);
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());
    }

    public static class MinStack {
        // 数据栈
        private Stack<Integer> dataStack;
        // 最小栈
        private Stack<Integer> minStack;

        public MinStack () {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push (int data) {
            dataStack.push(data);
            if (minStack.isEmpty()) {
                minStack.push(data);
                return;
            }
            Integer peek = minStack.peek();
            if (peek > data) {
                minStack.push(data);
            } else {
                minStack.push(peek);
            }
        }

        public int pop () {
            if (dataStack.isEmpty()) {
                throw new RuntimeException("栈为空~~~");
            }
            minStack.pop();
            return dataStack.pop();
        }

        public int getMin () {
            if (minStack.isEmpty()) {
                throw new RuntimeException("栈为空~~~");
            }
            return minStack.peek();
        }
    }
}
