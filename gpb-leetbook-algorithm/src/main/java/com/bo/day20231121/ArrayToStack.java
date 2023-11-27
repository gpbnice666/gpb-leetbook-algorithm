package com.bo.day20231121;

/**
 * 数组实现栈
 *
 * @Author: gpb
 * @Date: 2023/11/22 14:50
 * @Description:
 */
public class ArrayToStack {


    public static void main (String[] args) {
//        int i=10,j=10;
//        System.out.println(i++);
//        System.out.println(++j);
//        System.out.println(i);
//        System.out.println(j);
        ArrayStack stack = new ArrayStack(3);
        System.out.println("==>栈中添加数据");
        stack.push(1);
        stack.push(2);
        stack.push(3);
 //       stack.push(3);
        System.out.println("==>栈中弹出数据");
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println("==>栈中再次添加数据");
        stack.push(7);
        stack.push(8);
        System.out.println("==>栈中弹出数据");
        System.out.println(stack.poll());
     //   System.out.println(stack.poll());
        stack.push(12);
        stack.push(815);
        stack.push(888);

        System.out.println(stack.poll());
    }


    /**
     * 栈：先进后出,后进先出
     * 维护一个index指定数据的弹出
     * | 2 | 弹出元素  | 2 |
     * | 3 | ==>     | 3 |
     * | 5 | index=4 | 5 | index=3;
     * | 7 |         | 7 |
     */
    public static class ArrayStack {
        private int[] arr;
        private int index;

        private int limit;

        public ArrayStack (int limit) {
            this.arr = new int[limit];
            this.index = 0;
            this.limit = limit;
        }

        public void push (int value) {
            if (index == limit) {
                throw new RuntimeException("栈已满~~~");
            }
            arr[index++] = value;
        }

        public int poll () {
            if (index == 0) {
                throw new RuntimeException("栈为空~~~");
            }
            return arr[--index];
        }
    }
}
