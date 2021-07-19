package com.boris.calculation.zcy.chapter3;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description: 数组小和 统计数组的每个元素左侧比它小的数的总和 归并排序
 *
 * @author boris
 * @date Created on 2021/5/18
 */
public class SortSum {
    int[] arr = new int[]{1, 3, 4, 2, 5};

    @Test
    public void test() {
        int sum = this.sortSum(arr, 0, arr.length - 1);
        System.out.println(sum);
        System.out.println(Arrays.toString(arr));
    }

    public int sortSum(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }

        int middle = left + (right - left) / 2;

        return sortSum(arr, left, middle) + sortSum(arr, middle+1, right) + mergeSum(arr, left, middle, right);
    }

    public int mergeSum(int[] arr, int left, int middle, int right) {
        int sum = 0;
        int[] sortArr = new int[right - left + 1];
        int index1 = left;
        int index2 = middle+1;
        int sortArrIndex = 0;

        while (index1<=middle && index2<=right) {
            if (arr[index1] < arr[index2]) {
                sum = sum + arr[index1] * (right - index2 + 1);
            }
            sortArr[sortArrIndex++] = arr[index1] < arr[index2] ? arr[index1++] : arr[index2++];
        }

        while (index1<=middle) {
            sortArr[sortArrIndex++] = arr[index1++];
        }

        while (index2<=right) {
            sortArr[sortArrIndex++] = arr[index2++];
        }

        for (int i = 0; i < sortArr.length; i++) {
            arr[left + i] = sortArr[i];
        }
        return sum;
    }
}
