package com.boris.calculation.zcy.chapter1;

import org.junit.Test;

/**
 * Description: 局部最小
 * 最左侧 arr[0]<arr[1] 是局部最小
 * 最右侧 arr[max]<arr[max-1] 是局部最小
 * 中间部分 arr[i-1] > arr[i] < arr[i+1] 是局部最小
 * 最左侧和最右侧都不是局部最小时 中间必存在局部最小 使用二分法
 * @author boris
 * @date Created on 2021/5/13
 */
public class LocalMin {
    int[] arr = new int[]{8, 7, 8, 1, 2, 9};

    @Test
    public void test() {
        System.out.println(this.getLocalMinIndex(arr));
    }

    public int getLocalMinIndex(int[] arr) {
        int right = arr.length-1;
        int left = 0;
        int middle = 0;

        while (left < right) {
            middle = left + (right - left) / 2;
            if (left == 0 && arr[left] < arr[left+1]) {
                return left;
            } else if (right == arr.length-1 && arr[right]<arr[right-1]) {
                return right;
            } else if (arr[middle] < arr[middle-1] && arr[middle] < arr[middle+1]) {
                return middle;
            } else if (arr[middle] > arr[middle-1]) {
                left = middle-1;
            } else {
                right = middle+1;
            }
        }
        return -1;
    }
}
