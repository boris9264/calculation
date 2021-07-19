package com.boris.calculation.zcy.chapter8;

import com.boris.calculation.util.JsonUtil;
import com.boris.calculation.zcy.chapter7.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Description:
 *
 * @author boris
 * @date Created on 2021/6/3
 */
public class Test1 {
    int[] arr = new int[]{1, 3, 2, 4, 5};

    @Test
    public void test() {
        process(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public void process(int[] arr, int left, int right) {
        if (arr == null || arr.length==0 || left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;
        process(arr, left, middle);
        process(arr, middle + 1, right);
        mergeSort(arr, left, right, middle);
    }

    public void mergeSort(int[] arr, int left, int right, int middle) {
        int leftIndex = left;
        int rightIndex = middle + 1;
        int[] sortArr = new int[right - left + 1];
        int sortIndex = 0;
        while (leftIndex <= middle && rightIndex <= right) {
            sortArr[sortIndex++] = arr[leftIndex] <= arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }

        while (leftIndex <= middle) {
            sortArr[sortIndex++] = arr[leftIndex++];
        }

        while (rightIndex <= right) {
            sortArr[sortIndex++] = arr[rightIndex++];
        }

        for (int i = 0; i < sortArr.length; i++) {
            arr[left + i] = sortArr[i];
        }
    }
}
