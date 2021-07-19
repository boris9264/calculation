package com.boris.calculation.zcy.chapter7;

/**
 * Description:
 *
 * @author boris
 * @date Created on 2021/5/26
 */
public class Node {
    int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
