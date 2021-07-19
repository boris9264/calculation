package com.boris.calculation.zcy.chapter11;

import org.junit.Test;

/**
 * @author boris
 * @description 斐波那契数列
 * @date Created on 2021/6/13
 */
public class Test2 {
    @Test
    public void test() {
        System.out.println(getValue(6));
    }

    public int getValue(int number) {
        int result = 1;
        if (number == 1 || number == 2) {
            return result;
        }

        int a = 1;
        int b = 1;

        for (int i = 3; i <= number; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }
}
