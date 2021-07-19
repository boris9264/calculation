package com.boris.calculation.zcy.chapter1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

/**
 * Description:
 *
 * @author boris
 * @date Created on 2021/5/12
 */
public class InsertSort {
    int[] arr = new int[]{4, 7, 8, 1, 2, 9};

    @Test
    public void test() {
        System.out.println(Arrays.toString(this.insertSort(arr)));
    }

    public int[] insertSort(int[] arr) {
        if (Objects.isNull(arr) || arr.length<2) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int swap = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = swap;
                } else {
                    break;
                }
            }
        }
        return arr;
    }
}
