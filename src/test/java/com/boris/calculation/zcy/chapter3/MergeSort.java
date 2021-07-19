package com.boris.calculation.zcy.chapter3;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description: 归并排序
 *
 * @author boris
 * @date Created on 2021/5/18
 */
public class MergeSort {
    int[] arr = new int[]{1, 3, 2, 4, 5};

    @Test
    public void test() {
        this.process(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = left + (right - left) / 2;
        process(arr, left, middle);
        process(arr,middle+1 , right);
        mergeArr(arr, left, middle, right);
    }

    public void mergeArr(int[] arr, int left, int middle, int right) {
        int[] sortArr = new int[right-left+1];
        int index1 = left;
        int index2 = middle+1;
        int sortArrIndex = 0;
        while (index1 <= middle && index2 <= right) {
            sortArr[sortArrIndex++] = arr[index1]<=arr[index2]?arr[index1++]:arr[index2++];
        }

        while (index1 <= middle) {
            sortArr[sortArrIndex++] = arr[index1++];
        }

        while (index2 <= right) {
            sortArr[sortArrIndex++] = arr[index2++];
        }

        for (int i = 0; i < sortArr.length; i++) {
            arr[left + i] = sortArr[i];
        }
    }
}
