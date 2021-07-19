package com.boris.calculation.zcy.chapter8;

import org.junit.Test;
import org.springframework.util.comparator.ComparableComparator;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description:
 * 输入： 参数1，正数数组costs 参数2，正数数组profits 参数3，正数k 参数4，正数m
 *
 * costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润) k表示你不能并行、只能串行的最多做k个项目 m表示你初始的资金
 *
 * 说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个项目。
 * 输出： 你最后获得的最大钱数。
 *
 * @author boris
 * @date Created on 2021/6/5
 */
public class Test8 {
    @Test
    public void test() {
        int[] costs = new int[]{1,2,3,4};
        int[] profits = new int[]{2,3,4,5};

        int result = getMoney(costs, profits, 3, 1);
        System.out.println(result);
    }

    public int getMoney(int[] costs, int[] profits, int k, int m) {
        PriorityQueue<Program> minCostQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        PriorityQueue<Program> maxProfitQueue = new PriorityQueue<>((o1, o2) -> o2.profit - o1.profit);

        for (int i = 0; i < costs.length; i++) {
            minCostQueue.add(new Program(costs[i], profits[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!minCostQueue.isEmpty() && m >= minCostQueue.peek().cost) {
                maxProfitQueue.add(minCostQueue.poll());
            }

            if (maxProfitQueue.isEmpty()) {
                return m;
            }

            m = m + maxProfitQueue.poll().profit;
        }
        return m;
    }

    public static class Program {
        //花费
        private int cost;
        //利润
        private int profit;

        public Program(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }
}
