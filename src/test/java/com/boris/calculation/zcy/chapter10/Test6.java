package com.boris.calculation.zcy.chapter10;

import org.junit.Test;

/**
 * Description:
 * 给定两个长度都为N的数组weights和values,
 * weights[i]和values[i]分别代表i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，
 * 你装的物品不能超过这个重量。
 * 返回你能装下最多的价值是多少？
 *
 * @author boris
 * @date Created on 2021/6/11
 */
public class Test6 {
    @Test
    public void test() {
        int[] weights = new int[]{3, 4, 7, 6};
        int[] values = new int[] {1, 4, 3, 20};
        int maxValue = getMaxValue(weights, values, 10, 0);
        System.out.println(maxValue);
    }

    public int getMaxValue(int[] weights, int[] values, int bag, int index) {
        if (bag < 0) {
            return -1;
        }

        if (index == weights.length) {
            return 0;
        }

        int result1 = getMaxValue(weights, values, bag - weights[index], index+1);
        int result2 = getMaxValue(weights, values, bag, index+1);
        if (result1 != -1) {
            result1 = result1 + values[index];
        }
        return Math.max(result1, result2);
    }
}
