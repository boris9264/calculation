package com.boris.calculation.zcy.chapter8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Description:
 * 给定一个由字符串组成的数组strs，
 * 必须把所有的字符串拼接起来，
 * 返回所有可能的拼接结果中，字典序最小的结果
 * <p>
 * 字典序：
 * 字符串长度一样时，k进制的整数比较 eg: abc<abd
 * 字符串长度不一样时，短字符串补齐0再比较 eg: ab < b
 *
 * @author boris
 * @date Created on 2021/6/1
 */
public class Test4 {
    String[] strArr = new String[]{"az", "abc", "e", "c", "d"};

    @Test
    public void run() {
//        Set<Integer> set = new HashSet<>();
//        List<String> result = new ArrayList<>();
//        generateStrList(strArr, "", set, result);
//        System.out.println(JsonUtil.toString(result));
        System.out.println(generateStr(strArr));
    }

    public String generateStr(String[] strArr) {
        String result = "";
        Arrays.sort(strArr, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        for (String s : strArr) {
            result += s;
        }
        return result;
    }

    //组成字符串的所有排列组合
    public void generateStrList(String[] strArr, String curStr,
                                Set<Integer> strIndex, List<String> strList) {

        if (strIndex.size() == strArr.length) {
            strList.add(curStr);
            return;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (!strIndex.contains(i)) {
                strIndex.add(i);
                generateStrList(strArr, curStr + strArr[i], strIndex, strList);
                strIndex.remove(i);
            }
        }

    }
}
