package com.boris.calculation.zcy.chapter11;

import org.junit.Test;

/**
 * Description:
 * 给定一个数组，所有元素可重复使用，所有元素值不相同，求出和为目标值的所有组合总数
 * eg:[10, 5] 15
 * 10,5 5,5,5
 * @author boris
 * @date Created on 2021/6/11
 */
public class Test4 {
    @Test
    public void test() {
        int[] number = new int[]{10, 5, 1};
        int count = getCount(number, 15, 0);
        System.out.println(count);
    }

    public int getCount(int[] number, int total, int index) {
        if (total == 0) {
            return 1;
        }

        if (index == number.length-1) {
            return 0;
        }

        int result = 0;
        int sub = total / number[index];
        for (int i = 0; i <= sub; i++) {
            result = result + getCount(number, total - number[index] * i, index + 1);
        }
        return result;
    }


}
