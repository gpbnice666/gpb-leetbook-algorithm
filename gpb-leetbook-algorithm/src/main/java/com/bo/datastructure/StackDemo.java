package com.bo.datastructure;

import java.util.Stack;

/**
 * 栈是一种具有[先入后出] 特点的抽象数据结构，可以使用数组或链表实现

 * @Author: gpb
 * @Date: 2023/7/28 10:38
 * @Description:
 */
public class StackDemo {
    public static void main (String[] args) {
        Stack<Integer> stack = new Stack();

        // 通过常用操作「入栈 push()」,「出栈 pop()」，展示了栈的先入后出特性。
        stack.push(1); // 元素 1 入栈
        stack.push(2); // 元素 2 入栈
        stack.pop();        // 出栈 -> 元素2
        stack.pop();        // 出栈 -> 元素1

        /*
        *
        * 注意：通常情况下，不推荐使用Java的 Vector 以及子类 Stack
        * er
        *
        * */
    }
}
