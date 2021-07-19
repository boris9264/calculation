package com.boris.calculation.zcy.chapter10;

import org.junit.Test;

/**
 * Description:
 * 打印一个字符串的全部子序列
 *
 * 相对顺序不能乱
 * eg: abc
 *
 * abc ab ac a bc c
 * @author boris
 * @date Created on 2021/6/10
 */
public class Test3 {
    @Test
    public void test() {
        char[] charArr = new char[] {'a', 'b', 'c'};
//        print(charArr, 0, "");
        println(charArr, 0, "");
    }

    public void println(char[] charArr, int index, String path) {
        if (index == charArr.length) {
            System.out.println(path);
            return;
        }

        println(charArr, index+1, path);
        println(charArr, index+1, path + charArr[index]);
    }












    public void print(char[] charArr, int index, String path) {
        if (charArr.length == index) {
            System.out.println(path);
            return;
        }
        print(charArr, index + 1, path);

        print(charArr, index + 1, path + charArr[index]);
    }
}
