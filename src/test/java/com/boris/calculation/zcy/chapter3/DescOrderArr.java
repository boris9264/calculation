package com.boris.calculation.zcy.chapter3;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description: int[] arr = new int[]{3, 1, 0, 4, 2}; 数组降序对 3,1 3,0 3,2 1,0 4,2 求降序对数量
 *
 * @author boris
 * @date Created on 2021/5/19
 */
public class DescOrderArr {
    int[] arr = new int[]{3, 1, 7, 0, 2};

    @Test
    public void test() {
        int sum = this.descOrderSum(arr, 0, arr.length-1);
        System.out.println(sum);
        System.out.println(Arrays.toString(arr));
    }

    public int descOrderSum(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }

        int middle = left + (right - left) / 2;

        return descOrderSum(arr, left, middle) + descOrderSum(arr, middle+1, right) + descOrderMerge(arr, left, middle, right);
    }

    public int descOrderMerge(int[] arr, int left, int middle, int right) {
        int sum = 0;
        int[] sortArr = new int[right - left + 1];
        int sortIndex = 0;
        int index1 = left;
        int index2 = middle+1;

        while (index1<=middle && index2<=right) {
            if (arr[index1] > arr[index2]) {
                sum = sum + (middle - index1 + 1);
            }
            sortArr[sortIndex++] = arr[index1] > arr[index2]?arr[index2++]:arr[index1++];
        }

        while (index1<=middle) {
            sortArr[sortIndex++] = arr[index1++];
        }

        while (index2<=right) {
            sortArr[sortIndex++] = arr[index2++];
        }

        for (int i = 0; i < sortArr.length; i++) {
            arr[left + i] = sortArr[i];
        }
        return sum;
    }
}
