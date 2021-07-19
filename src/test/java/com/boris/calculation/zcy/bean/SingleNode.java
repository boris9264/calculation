package com.boris.calculation.zcy.bean;

/**
 * Description:
 *
 * @author boris
 * @date Created on 2021/5/13
 */
public class SingleNode {
    private int value;

    private SingleNode next;

    public SingleNode(int value) {
        this.value = value;
    }

    public SingleNode(int value, SingleNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }
}
