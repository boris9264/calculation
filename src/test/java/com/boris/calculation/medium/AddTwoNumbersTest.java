package com.boris.calculation.medium;

import com.boris.calculation.bean.ListNode;
import com.boris.calculation.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: boris
 * @Data: Created on 2019/6/19
 * @Description: 两数相加
 */
public class AddTwoNumbersTest {
    ListNode l1;
    ListNode l2;

    @Before
    public void init() {
        l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(1);
        System.out.println(JsonUtil.toString(l1));

        System.out.println(JsonUtil.toString(l2));
    }

    @Test
    public void run() {
        ListNode result = new ListNode(0);
        ListNode curNode = result;
        int addVal = 0;
        while(true) {
            int sum = 0;
            sum = sum + addVal;
            addVal = 0;
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }

            if (sum >= 10) {
                sum = sum - 10;
                addVal = 1;
            }

            curNode.val = sum;
            if (l1==null && l2==null) {
                break;
            }

            curNode.next = new ListNode(0);
            curNode = curNode.next;
        }
        System.out.println(JsonUtil.toString(result));
    }

    /*
        给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

        示例：

        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807
    */

}
