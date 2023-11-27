package com.bo.day20231121;

import java.util.Stack;

/**
 * 两个栈实现队列
 * 实现思路：
 * 栈a：只负责添加数据
 * 栈b：只负责弹出数据
 * 栈b的数据必须保证
 * 当栈b为空的时候,需要把栈a的数据导入到栈b
 * 栈b不为空的时候,不能导入数据
 * 可以在添加数据时候导入栈b,也可以在弹出的导入数据
 *
 * @Author: gpb
 * @Date: 2023/11/22 16:30
 * @Description:
 */
public class TwoStacksImplementQueue {

    public static void main(String[] args) {
        TwoStacksToQueue test = new TwoStacksToQueue();
        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }

    public static class TwoStacksToQueue {
        // 添加栈
        private Stack<Integer> pushStack;
        // 弹出栈
        private Stack<Integer> popStack;

        public TwoStacksToQueue () {
            this.pushStack = new Stack<>();
            this.popStack = new Stack<>();
        }

        private void pushStackToPopStack () {
            // 只能在弹出栈数据为空的时候才能导入数据
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
        }

        private void push (int data) {
            pushStack.add(data);
            pushStackToPopStack();
        }

        private int poll () {
            if (pushStack.empty() && popStack.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushStackToPopStack();
            return popStack.pop();
        }

        public int peek() {
            if (pushStack.empty() && popStack.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushStackToPopStack();
            return popStack.peek();
        }
    }

}
