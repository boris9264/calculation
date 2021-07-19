package com.boris.calculation.zcy.chapter4;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description: 堆排序
 *
 * @author boris
 * @date Created on 2021/5/20
 */
public class HeapSort {
    int[] arr = new int[]{3, 1, 7, 0, 2};

    @Test
    public void test() {
        System.out.println(Arrays.toString(heapSort(arr)));
    }

    public int[] heapSort(int[] arr) {
        for (int i = arr.length-1; i > -1; i--) {
            heapDown(arr, i, arr.length-1);
        }

        for (int i = 0; i < arr.length; i++) {
            popAndSwap(arr, arr.length-i-1);
        }
        return arr;
    }

    /**
     * 弹出最大值并放在数组末端
     */
    private void popAndSwap(int[] arr, int tailIndex) {
        swap(arr, 0, tailIndex);
        heapDown(arr, 0, tailIndex);
    }

    /**
     * 数组形成二叉树 最大根堆
     */
    private void heapDown(int[] arr, int index, int tailIndex) {
        int leftIndex = index*2+1;
        while(leftIndex < tailIndex) {
            //左右子节点最大下标
            int maxIndex = leftIndex+1<tailIndex&&arr[leftIndex+1]>arr[leftIndex]?leftIndex+1:leftIndex;
            if (arr[maxIndex] <= arr[index]) {
                break;
            }

            swap(arr, index, maxIndex);
            index = maxIndex;
            leftIndex = index*2+1;
        }

    }

    private void swap(int[] arr, int index1, int index2) {
        int swap = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = swap;
    }
}
