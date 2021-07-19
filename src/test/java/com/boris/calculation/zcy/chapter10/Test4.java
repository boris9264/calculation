package com.boris.calculation.zcy.chapter10;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description: 打印一个字符串的全部排列
 *
 * @author boris
 * @date Created on 2021/6/10
 */
public class Test4 {
    @Test
    public void test() {
        char[] charArr = new char[]{'a', 'b'};
        printAllStr(charArr, 0);
    }

    public void printAllStr(char[] charArr, int index) {
        if (index == charArr.length) {
            System.out.println(Arrays.toString(charArr));
            return;
        }

        for (int i = index; i < charArr.length; i++) {
            swap(charArr, index, i);
            printAllStr(charArr, index+1);
            swap(charArr, i, index);
        }
    }

    public void swap(char[] charArr, int i, int j) {
        char a = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = a;
    }
}
