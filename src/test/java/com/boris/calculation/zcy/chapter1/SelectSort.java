package com.boris.calculation.zcy.chapter1;

import com.boris.calculation.util.JsonUtil;
import org.junit.Test;

import java.util.Objects;

/**
 * Description:
 *
 * @author boris
 * @date Created on 2021/5/12
 */
public class SelectSort {
    int[] arr = new int[]{4, 7, 8, 1, 2, 9};

    @Test
    public void test() {
        System.out.println(JsonUtil.toString(this.sortArr(arr)));
    }

    public int[] sortArr(int[] arr) {
        if (Objects.isNull(arr) || arr.length<2) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int swap = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = swap;
            }
        }
        return arr;
    }
}
