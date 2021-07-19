package com.boris.calculation.zcy.chapter4;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Description:
 * 已知一个几乎有序的数组。几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离一定不超过k，
 * 并且k相对于数组长度来说是比较小的。请选择一个合适的排序策略，对这个数组进行排序
 *
 * @author boris
 * @date Created on 2021/5/20
 */
public class HeapSortTest {
    int[] arr = new int[]{1, 5, 0, 2, 3};

    @Test
    public void test() {
        System.out.println(Arrays.toString(this.sort(arr, 4)));
    }

    /**
     * 任意一个元素排序的移动次数不超过k次
     * 先把数组中前k个元素放入最小根堆中
     * 弹出一个元素，再把k+1个元素放入最小根堆 再弹出
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] sort(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i >= k) {
                arr[index++] = heap.poll();
            }
            heap.add(arr[i]);
        }

        while (!heap.isEmpty()) {
            arr[index++] = heap.poll();
        }
        return arr;
    }
}
