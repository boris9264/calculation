package com.boris.calculation.zcy.chapter8;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
 * 给你每一个项目开始的时间和结束的时间
 * 你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。
 * 返回最多的宣讲场次。
 * <p>
 * 会议时间结束早的优先安排
 *
 * @author boris
 * @date Created on 2021/6/4
 */
public class Test5 {
    @Test
    public void test() {
        System.out.println(123);
    }

    public int getProgramNumber(Program[] programs) {
        //数组根据会议结束时间排序
        Arrays.sort(programs, (o1, o2) -> o1.end - o2.end);

        int currentEndTime = 0;
        int result = 0;
        for (Program program : programs) {
            if (program.start >= currentEndTime) {
                result++;
                currentEndTime = program.end;
            }
        }
        return result;
    }


    public static class Program {
        //开始时间
        int start;
        //结束时间
        int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
