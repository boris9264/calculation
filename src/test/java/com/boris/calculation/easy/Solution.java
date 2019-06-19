package com.boris.calculation.easy;

import com.boris.calculation.util.JsonUtil;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: boris
 * @Data: Created on 2019/6/18
 * @Description: 两数之和
 */
public class Solution {
    /*
        给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

        示例:
        给定 nums = [2, 7, 11, 15], target = 9
        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]
    */

    @Test
    public void run() {
        int[] nums = new int[]{2, 11, 7, 15};
        int[] result = twoSum1(nums, 9);
        System.out.println(JsonUtil.toString(result));

        result = twoSum2(nums, 9);
        System.out.println(JsonUtil.toString(result));

        result = twoSum3(nums, 9);
        System.out.println(JsonUtil.toString(result));

        result = twoSum4(nums, 9);
        System.out.println(JsonUtil.toString(result));
    }

    //简单粗暴两层for循环
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //两次遍历 第一次把数组中的值作为key, 坐标作为value放入map中
    //第二次遍历从map中取出第二个目标值的坐标
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(target - nums[i])) {
                return new int[]{i, indexMap.get(target - nums[i])};
            }
        }
        return null;
    }

    //一次遍历 遍历过程中把数组中的值与坐标放入map中 同时判断数组中是否包含目标值的key
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
            if (indexMap.containsKey(target - nums[i])) {
                return new int[]{indexMap.get(target - nums[i]), i};
            }
        }
        return null;
    }

    public int[] twoSum4(int[] nums, int target) {
        List<int[]> result =
        Arrays.stream(nums).boxed()
                .flatMap(a -> Arrays.stream(nums).boxed().filter(b -> a+b == target)
                .map(b -> new int[]{a, b}))
                .collect(Collectors.toList());
        return result.get(0);
    }
}
