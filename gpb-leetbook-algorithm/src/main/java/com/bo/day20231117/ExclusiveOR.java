package com.bo.day20231117;

/**
 * ^ 异或运算
 * 规则：二进制数,相同为0,不同为1
 * 结论：
 * 0^任何数=数本身
 * 相同数^相同数=0
 * 一组数都是^,最终结果都是一样的
 *
 * @Author: gpb
 * @Date: 2023/11/17 11:45
 * @Description:
 */
public class ExclusiveOR {
    public static void main (String[] args) {
        int a = 32;
        int b = 89;

        System.out.println(a);
        System.out.println(b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        /*
         * ^ 两数交换原理
         * 因为 a^a=0 这个结论
         * 推理
         * a = a^b;
         * b = a^b^b; 所以 b=a;
         * a = a^b^a; 所以 a=b;
         * */
        System.out.println(a);
        System.out.println(b);

        int num = 128 + 5;
        System.out.println(num);
        System.out.println(~num + 1);
        System.out.println(num & (~num + 1));
    }
}
