package com.boris.calculation.zcy.chapter1;

import org.junit.Test;

import java.util.Objects;

/**
 * Description:
 *
 * @author boris
 * @date Created on 2021/5/13
 */
public class CheckExists {
    int[] arr = new int[]{1, 2, 4, 7, 8, 9};

    @Test
    public void test() {
        System.out.println(this.checkExist(5));
    }

    public boolean checkExist(int number) {
        if (Objects.isNull(arr) || arr.length == 0) {
            return false;
        }

        int left = 0;
        int right = arr.length - 1;
        int middle = 0;

        while (left < right) {
            middle = left + (right - left) / 2;
            if (arr[middle] == number) {
                return true;
            } else if (arr[middle] > number) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return false;
    }
}
