package com.boris.calculation.zcy.chapter8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description:
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的 金条，不管切成长度多大的两半，都要花费20个铜板。一群人想整分整块金条，怎么分最省铜板？
 *
 * 例如，给定数组{10,20,30}，代表一共三个人，整块金条长度为10+20+30=60. 金条要分成10,20,30三个部分。 如果， 先把长度60的金条分成10和50，花费60 再把长度50的金条分成20和30，花费50 一共花费110铜板。
 * 但是，如果先把长度60的金条分成30和30，花费60 再把长度30金条分成10和20，花费30 一共花费90铜板。
 *
 * 输入一个数组，返回分割的最小代价。
 * @author boris
 * @date Created on 2021/6/4
 */
public class Test7 {
    @Test
    public void test() {
        int[] arr = {30, 20, 40, 50, 10};
        System.out.println(splitGold1(arr));
        System.out.println(splitGold(arr));
    }

    public int splitGold(int[] goldArr) {
        PriorityQueue<Integer> goldQueue = new PriorityQueue<>();
        for (int i : goldArr) {
            goldQueue.add(i);
        }

        int sum = 0;
        int cur = 0;
        while (goldQueue.size() > 1) {
            int a1 = goldQueue.poll();
            int a2 = goldQueue.poll();
            cur = a1 + a2;
            sum += cur;
            goldQueue.add(cur);
            System.out.println(a1 + "   " + a2);
        }
        return sum;
    }

    public int splitGold1(int[] goldArr) {
        int result = 0;
        Arrays.sort(goldArr);
        int length = 0;
        for (int i : goldArr) {
            length += i;
        }

        for (int i = goldArr.length-1; i >= 1; i--) {
            result = result + length;
            length = length - goldArr[i];
        }
        return result;
    }
}
