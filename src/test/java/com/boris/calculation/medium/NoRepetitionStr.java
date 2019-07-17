package com.boris.calculation.medium;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: boris
 * @Data: Created on 2019/7/17
 * @Description: 无重复字符串的最长子串
 */
public class NoRepetitionStr {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length(), i=0, j=0, sum=0;
        while(i<len && j<len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                sum = Math.max(sum, j-i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return sum;
    }

    @Test
    public void run1() {
        System.out.println(lengthOfLongestSubstring("pwpea"));
    }

    @Test
    public void run() {
        String str = "pwwkew";

        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            String curStr = "";
            for (int j = i; j < str.length(); j++) {
                if (!curStr.contains(String.valueOf(str.charAt(j)))) {
                    curStr = curStr + str.charAt(j);
                } else {
                    if (curStr.length() > max) {
                        max = curStr.length();
                    }
                    break;
                }
            }
        }
        System.out.println(max);
    }
    /*
        给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

        示例 1:

        输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:

        输入: "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:

        输入: "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
                     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

}
