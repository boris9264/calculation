package com.boris.calculation.zcy.chapter7;

import org.junit.Test;

/**
 * Description:
 *
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开。此时折痕是凹下去的，即折痕突起的方向指向纸条的背面。如果从纸条的下边向上方连续对折2次，压出折痕后展开，此时有三条折痕，从上到下依次是下折痕、下折痕和上折痕。给定一个输入参数N，代表纸条都从下边向上方连续对折N次，请从上到下打印所有折痕的方向。
 * 例如：N=1时，打印：
 * down
 * N=2时，打印：
 * down
 * down
 * up
 *
 * *******************找折痕规律
 * @author boris
 * @date Created on 2021/5/31
 */
public class NodeTest6 {

    @Test
    public void test () {
        print(1, 2, true);
    }
    public void print(int level, int n, boolean down) {
        if (level > n) {
            return;
        }

        print(level + 1, n, true);
        System.out.println(down?"down":"up");
        print(level + 1, n, false);
    }
}
