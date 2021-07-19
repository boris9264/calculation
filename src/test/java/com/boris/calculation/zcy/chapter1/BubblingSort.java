package com.boris.calculation.zcy.chapter1;

import com.boris.calculation.util.JsonUtil;
import org.junit.Test;

import java.util.Objects;

/**
 * Description: 冒泡排序
 *
 * @author boris
 * @date Created on 2021/5/12
 */
public class BubblingSort {
    int[] arr = new int[]{4, 7, 8, 1, 2, 9};

    @Test
    public void test() {
        System.out.println(JsonUtil.toString(this.bubblingSort(arr)));
    }

    public int[] bubblingSort(int[] arr) {
        if (Objects.isNull(arr) || arr.length<2) {
            return arr;
        }

        for (int j = arr.length-1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i+1]) {
                    int swap = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = swap;
                }
            }
        }

        return arr;
    }
}

