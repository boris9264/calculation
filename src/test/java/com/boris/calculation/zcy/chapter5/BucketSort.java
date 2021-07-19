package com.boris.calculation.zcy.chapter5;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description: 桶排序
 *
 * @author boris
 * @date Created on 2021/5/24
 */
public class BucketSort {
    int[] arr = new int[]{103, 2, 37, 425, 94};

    @Test
    public void test() {
        this.bucketSort(arr);

//        System.out.println(this.getDigitNumber(37, 2));
    }

    private int maxDigit(int[] arr) {
        int maxDigit = 0;
        int maxNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= maxNumber) {
                maxNumber = arr[i];
            }
        }

        while (maxNumber>0) {
            maxNumber = maxNumber / 10;
            maxDigit++;
        }
        return maxDigit;
    }

    private int getDigitNumber(int number, int digit) {
        int result = 1;

        while (digit > 1) {
            result = result * 10;
            digit--;
        }

        return (number / result) % 10;
    }

    public void bucketSort(int[] arr) {
        int[] bucketArr = new int[10];
        int[] sortArr = new int[arr.length];

        int maxDigit = this.maxDigit(arr);
        for (int i = 1; i <= maxDigit; i++) {

            for (int j = 0; j < arr.length; j++) {
                int digitNumber = this.getDigitNumber(arr[j], i);
                bucketArr[digitNumber] = bucketArr[digitNumber] + 1;
            }

            for (int j = 1; j < bucketArr.length; j++) {
                bucketArr[j] = bucketArr[j] + bucketArr[j-1];
            }

            for (int j = arr.length-1; j >=0; j--) {
                int digitNumber = this.getDigitNumber(arr[j], i);
                sortArr[bucketArr[digitNumber]-1] = arr[j];
                bucketArr[digitNumber] = bucketArr[digitNumber] - 1;
            }
            bucketArr = new int[10];
        }

        System.out.println(Arrays.toString(sortArr));
    }
}
