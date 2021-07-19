package com.boris.calculation.medium;

import com.boris.calculation.util.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author boris
 * @description 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
 * 使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * @date Created on 2021/6/17
 */
public class Test2 {
    @Test
    public void test() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = getResult(nums);
        System.out.println(JsonUtil.toString(result));
    }

    public List<List<Integer>> getResult(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int targetSum = Math.abs(nums[i]);
            int leftIndex = i+1;
            int rightIndex = nums.length - 1;

            //数组是有序的
            //大于targetSum时只有右指针向左移动 两数之和才能越来越小
            //小于targetSum时只有左指针向右移动 两数之和才能越来越大
            while (leftIndex < rightIndex) {
                if (nums[leftIndex] + nums[rightIndex] > targetSum) {
                    rightIndex--;
                    while (rightIndex - 1 > 0 && nums[rightIndex] == nums[rightIndex - 1]) {
                        rightIndex--;
                    }
                } else if (nums[leftIndex] + nums[rightIndex] <= targetSum) {
                    if (nums[leftIndex] + nums[rightIndex] == targetSum) {
                        result.add(Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]));
                    }
                    leftIndex++;
                    while (leftIndex + 1 < nums.length - 1 && nums[leftIndex] == nums[leftIndex + 1]) {
                        leftIndex++;
                    }
                }
            }

        }
        return result;
    }
}
