package com.boris.calculation.zcy.chapter1;

import org.junit.Test;

/**
 * Description: 异或操作 二进制不进位相加
 *
 * @author boris
 * @date Created on 2021/5/13
 */
public class Test6 {
    int[] arr = new int[]{1,2,2,3,3,4,4,1,6};

    //两个变量交换值
    @Test
    public void test() {
        int a = 10;
        int b = 1;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }

    //一个数组找出出现奇数次的值
    @Test
    public void test1() {
        System.out.println(this.getOddNumber(arr));
    }

    public int getOddNumber(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;
    }
}
