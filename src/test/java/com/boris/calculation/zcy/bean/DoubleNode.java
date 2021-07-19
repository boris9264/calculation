package com.boris.calculation.zcy.bean;

import java.util.Objects;

/**
 * Description:
 *
 * @author boris
 * @date Created on 2021/5/14
 */
public class DoubleNode {
    public int value;
    public DoubleNode prev;
    public DoubleNode next;

    public DoubleNode(int value) {
        this.value = value;
    }

    public DoubleNode(int value, DoubleNode prev, DoubleNode next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

}
