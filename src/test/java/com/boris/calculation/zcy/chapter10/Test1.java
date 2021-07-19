package com.boris.calculation.zcy.chapter10;

import org.junit.Test;

/**
 * Description: 打印汉诺塔最少移动过程
 *
 * @author boris
 * @date Created on 2021/6/9
 */
public class Test1 {
    @Test
    public void test() {
        print(3, "1", "3", "2");
    }

    public void print(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("move " + n + " from " + from + " to " + to);
        } else {
            print(n-1, from, other, to);
            System.out.println("move " + n + " from " + from + " to " + to);
            print(n-1, other, to, from);
        }
    }
}
