package com.boris.calculation.zcy.chapter10;

import org.junit.Test;

/**
 * Description:
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线，玩家A和玩家B依次拿走每张纸牌，
 * 规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。
 *
 * @author boris
 * @date Created on 2021/6/11
 */
public class Test7 {
    @Test
    public void test() {
        int[] arr = new int[]{1, 100, 70, 80};
        int max = Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
        System.out.println(max);
    }

    public int first(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        int result1 = arr[left] + second(arr, left + 1, right);
        int result2 = arr[right] + second(arr, left, right - 1);
        return Math.max(result1, result2);
    }

    public int second(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int result1 = first(arr, left + 1, right);
        int result2 = first(arr, left, right - 1);
        return Math.min(result1, result2);
    }
}
