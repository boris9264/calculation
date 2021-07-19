package com.boris.calculation.zcy.chapter11;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author boris
 * @description
 * 给定一个字符串str，给定一个字符串类型的数组arr，出现的字符都是小写英文。
 * arr每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出str来。
 * 返回需要至少多少张贴纸可以完成这个任务。
 * 例子：str= "babac"，arr = {"ba","c","abcd"}。
 * a + ba + c 3 abcd + abcd 2 abcd+ba 2。所以返回2。
 * @date Created on 2021/6/17
 */
public class Test5 {
    @Test
    public void test() {
        char[] arr = new char[]{'a','b','c'};
        printStr(arr, new HashSet<>(), "");
    }

    public void printStr(char[] arr, Set<Integer> index, String str) {
        if (arr.length == index.size()) {
            System.out.println(str);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!index.contains(i)) {
                index.add(i);
                printStr(arr, index, str + arr[i]);
                index.remove(i);
            }
        }
    }

}
