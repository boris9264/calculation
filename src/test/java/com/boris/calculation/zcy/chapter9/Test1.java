package com.boris.calculation.zcy.chapter9;

import org.junit.Test;

/**
 * Description: 并查集
 * 如果两个user，a字段一样、或者b字段一样、或者c字段一样，就认为是一个人
 * 请合并users，返回合并之后的用户数量
 *
 * @author boris
 * @date Created on 2021/6/9
 */
public class Test1 {
    public static class User {
        public String a;
        public String b;
        public String c;

        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    @Test
    public void test() {
        System.out.println(123);
    }

    public static int mergeUsers(User[] users) {
        return 100;
    }
}
