package com.boris.calculation.zcy.chapter11;

import org.junit.Test;

/**
 * @author boris
 * @description 假设有排成一行的N个位置，记为1~N，N一定大于或等于2。
 * 开始时机器人在其中的M位置上（M一定是1~N中的一个），
 * 机器人可以往左走或者往右走，如果机器人来到1位置，那么下一步只能往右来到2位置；
 * 如果机器人来到N位置，那么下一步只能往左来到N-1位置。
 * 规定，机器人必须走K步，最终能来到P位置（P也一定是1~N中的一个）的方法有多少种。
 * 给定4个参数N、M、K、P，返回方法数。
 * @date Created on 2021/6/13
 */
public class Test3 {
    @Test
    public void test() {
        System.out.println(getValue(7, 3, 3, 2));
    }

    public int getValue(int n, int m, int k, int p) {
        if (k == 0) {
            if (m == p) {
                return 1;
            }
            return 0;
        }

        if (m == 1) {
            getValue(n, m + 1, k - 1, p);
        }

        if (m == n) {
            getValue(n, m - 1, k - 1, p);
        }
        return getValue(n, m + 1, k - 1, p) + getValue(n, m - 1, k - 1, p);
    }
}
