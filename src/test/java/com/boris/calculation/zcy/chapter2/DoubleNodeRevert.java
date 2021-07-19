package com.boris.calculation.zcy.chapter2;

import com.boris.calculation.util.JsonUtil;
import com.boris.calculation.zcy.bean.DoubleNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

/**
 * Description: 双向列表反转
 *
 * @author boris
 * @date Created on 2021/5/14
 */
public class DoubleNodeRevert {
    DoubleNode doubleNode;

    @Before
    public void init() {
        doubleNode = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(3);
        DoubleNode doubleNode4 = new DoubleNode(4);

        doubleNode4.prev = doubleNode3;
        doubleNode3.prev = doubleNode2;
        doubleNode2.prev = doubleNode;

        doubleNode.next = doubleNode2;
        doubleNode2.next = doubleNode3;
        doubleNode3.next = doubleNode4;
    }

    @Test
    public void run() {
        DoubleNode result = this.revert(doubleNode);
        System.out.println(123);
    }

    public DoubleNode revert(DoubleNode doubleNode) {
        DoubleNode result = null;
        DoubleNode prev = null;
        DoubleNode next = null;

        while (!Objects.isNull(doubleNode)) {
            next = result;
            prev = doubleNode.next;
            result = new DoubleNode(doubleNode.value);
            result.next = next;
            result.prev = prev;
            doubleNode = doubleNode.next;
        }
        return result;
    }
}
