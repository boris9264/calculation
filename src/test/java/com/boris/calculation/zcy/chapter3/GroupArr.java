package com.boris.calculation.zcy.chapter3;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description: 给定一个数组，和一个整数num，把小于等于num的数放在数组的左边，大于num的数放在数组的右边
 *
 * @author boris
 * @date Created on 2021/5/19
 */
public class GroupArr {
    int[] arr = new int[]{7,3,2,4,3,1};

    @Test
    public void test() {
        System.out.println(Arrays.toString(groupArr1(arr, 3)));
    }

    public int[] groupArr(int[] arr, int number) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= number) {
                int swap = 0;
                index++;
                swap = arr[index];
                arr[index] = arr[i];
                arr[i] = swap;
            }
        }
        return arr;
    }

    //分三个区 大于 等于 小于
    public int[] groupArr1(int[] arr, int number) {
        int leftIndex = 0;
        int rightIndex = arr.length-1;

        int i = 0;
        while (i < arr.length) {
            if (rightIndex < i) {
                break;
            }
            if (arr[i] > number) {
                int swap = arr[rightIndex];
                arr[rightIndex] = arr[i];
                arr[i] = swap;
                rightIndex--;
                continue;
            } else if (arr[i] < number) {
                int swap = arr[leftIndex];
                arr[leftIndex] = arr[i];
                arr[i] = swap;
                leftIndex++;
            }
            i++;
        }
        return arr;
    }
}
