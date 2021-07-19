package com.boris.calculation.zcy.chapter11;

import org.junit.Test;

/**
 * Description:
 * 现在给你一个长为N，宽为N的棋盘，现在需要你往棋盘上放N个皇后，
 * 并且要求，任意两个皇后不能在同一行，同一列，同一个对角线。
 * 请求出一共有多少种放置方法。
 *
 * @author boris
 * @date Created on 2021/6/11
 */
public class Test1 {
    @Test
    public void test() {
        System.out.println(getMaxCompose(3, new int[3], 0));
    }

    //rowNumber从0开始
    //index表示坐标 index[1]=6 表示第一行第六列
    public int getMaxCompose(int n, int[] index, int rowNumber) {
        if (n == rowNumber) {
            return 1;
        }

        int result = 0;
        //给列赋值
        for (int i = 0; i < n; i++) {
            index[rowNumber] = i;
            if (this.isValid(index, rowNumber, i)) {
                result = result + getMaxCompose(n, index, rowNumber+1);
            }
        }
        return result;
    }

    //任意两个元素不可能在同一行
    //在同一列时 数组值相同
    //在同一斜线时 两个元素的行坐标相减的绝对值 等于两个元素列坐标相减的绝对值
    private boolean isValid(int[] index, int rowNumber, int columnNumber) {
        for (int i = 0; i < rowNumber; i++) {
            if (index[i] == index[rowNumber]) {
                return false;
            }

            if (Math.abs(rowNumber - i) == Math.abs(columnNumber - index[i])) {
                return false;
            }
        }
        return true;
    }

}
