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

        l2 = new ListNode(7);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(4);
        System.out.println(JsonUtil.toString(l1));

        System.out.println(JsonUtil.toString(l2));
    }

    @Test
    public void run() {
        ListNode result = this.addTwoNumbers(l1, l2);
        System.out.println(JsonUtil.toString(result));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int jinwei = 0;

        while (l1!=null || l2!=null) {
            int l1CurVal = l1!=null?l1.val:0;
            int l2CurVal = l2!=null?l2.val:0;
            int curSum = l1CurVal+l2CurVal;
            if (l1CurVal+l2CurVal>=10) {
                jinwei = 1;
                curSum -= 10;
            } else {
                jinwei = 0;
            }
            cur.val = cur.val + curSum;

            if (l1!=null) {
                l1 = l1.next;
            }

            if (l2!=null) {
                l2 = l2.next;
            }

            if (l1!=null || l2!=null) {
                cur.next = new ListNode(jinwei);
                cur = cur.next;
            }

        }
        return result;
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
