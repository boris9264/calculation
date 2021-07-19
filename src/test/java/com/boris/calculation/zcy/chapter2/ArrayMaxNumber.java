package com.boris.calculation.zcy.chapter2;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:
 *
 * @author boris
 * @date Created on 2021/5/14
 */
public class ArrayMaxNumber {
    int[] arr = new int[]{4, 7, 8, 1, 2, 9};

    @Test
    public void test() {
        System.out.println(this.getMaxNumber(arr, 0, 0));
        System.out.println(this.getArrayMaxNumber(arr, 0, arr.length-1));
    }

    public int getMaxNumber(int[] arr, int maxNumber, int index) {
        if (arr.length==index) {
            return maxNumber;
        }

        if (maxNumber<arr[index]) {
            maxNumber = arr[index];
        }

        return this.getMaxNumber(arr, maxNumber, index+1);
    }

    public int getArrayMaxNumber(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        int middle = left + (right - left) / 2;
        int leftMax = getArrayMaxNumber(arr, left, middle);
        int rightMax = getArrayMaxNumber(arr, middle+1, right);
        return leftMax > rightMax ? leftMax : rightMax;
    }
}
